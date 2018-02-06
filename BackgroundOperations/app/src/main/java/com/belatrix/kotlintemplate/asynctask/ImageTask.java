package com.belatrix.kotlintemplate.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.belatrix.kotlintemplate.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by eduardomedina on 23/02/17.
 */

public class ImageTask extends AsyncTask<URL, Integer, Bitmap> {

    private final String TAG= "ImageTask";
    private final Context context;
    private final ImageView imageView;
    private int downloadedBytes = 0;
    private int totalBytes = 0;
    private ProgressDialog progressDialog;

    public ImageTask(Context context, ImageView imageView) {

        this.imageView = imageView;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        if(context!=null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setTitle("Cargando...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setProgress(0);
            progressDialog.setMax(100);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(
                    new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            ImageTask.this.cancel(false);
                        }
                    });
            progressDialog.show();
        }
    }

    @Override
    protected Bitmap doInBackground(URL... params) {
        URL url = params[0];;
        return downloadBmp(url);
    }

    private Bitmap downloadBmp(URL url){
        Bitmap bitmap =null;
        InputStream is = null;
        try {
            if (isCancelled()) {
                return null;
            }
            publishProgress(0);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int responseCode = conn.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK){
                throw new Exception("Unsucesfull Result code");
            }
            totalBytes = conn.getContentLength();
            downloadedBytes = 0;

            is = conn.getInputStream();
            BufferedInputStream bif = new BufferedInputStream(is) {

                int progress = 0;

                public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
                    int readBytes = super.read(buffer, byteOffset, byteCount);
                    if ( isCancelled() ){
                        // Returning -1 means that there is no more data because the
                        // end of the stream has been reached.
                        return -1;
                    }
                    if (readBytes > 0) {
                        downloadedBytes += readBytes;
                        // int percent = (int) ((((float) downloadedBytes) / ((float) totalBytes)) * 100);
                        int percent = (int) ((downloadedBytes * 100f) / totalBytes);
                        if (percent > progress) {
                            publishProgress(percent);
                            progress = percent;
                        }
                    }
                    return readBytes;
                }
            };
            Bitmap downloaded = BitmapFactory.decodeStream(bif);
            if ( !isCancelled() ){
                bitmap = downloaded;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    @Override
    protected void onCancelled() {
        if ( imageView != null && context != null ) {
            Bitmap bitmap = BitmapFactory.decodeResource(
                    context.getResources(), R.mipmap.ic_launcher
            );
            this.imageView.setImageBitmap(bitmap);
        }
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.i(TAG,"Image download "+values[0]);
        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if( progressDialog!=null )
            progressDialog.dismiss();
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
