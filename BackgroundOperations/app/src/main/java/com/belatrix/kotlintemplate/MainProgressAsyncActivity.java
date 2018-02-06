package com.belatrix.kotlintemplate;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainProgressAsyncActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private ProgressBar pBar;
    private Button btnStart;
    private ImageView iviLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_progress_async);
        app();
    }

    private void app() {
        pBar= (ProgressBar)findViewById(R.id.pBar);
        btnStart= (Button) findViewById(R.id.btnStart);
        iviLogo= (ImageView) findViewById(R.id.iviLogo);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnStart){
            startProgress();
        }
    }

    private void startProgress() {
        DownloadAsyncTask downloadAsyncTask= new DownloadAsyncTask();
        downloadAsyncTask.execute();
    }

    private class DownloadAsyncTask extends AsyncTask<String, Integer, String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.v(TAG, "Start");
            resetProgress();
        }

        @Override
        protected String doInBackground(String... strings) {

            for (int i = 0; i <= 10; i++) {
                try {

                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Download Complete ";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            int percent = Math.round(10*values[0]);
            Log.v(TAG, "percent "+percent+"%");
            pBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.v(TAG, "Complete");
            progressComplete();
        }
    }

    private void progressComplete(){
        pBar.setVisibility(View.GONE);
        btnStart.setVisibility(View.GONE);
        iviLogo.setVisibility(View.VISIBLE);

    }

    private void resetProgress(){
        pBar.setVisibility(View.VISIBLE);
        btnStart.setVisibility(View.VISIBLE);
        iviLogo.setVisibility(View.GONE);
        pBar.setProgress(0);

    }
}
