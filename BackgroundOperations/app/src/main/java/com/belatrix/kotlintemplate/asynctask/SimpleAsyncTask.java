package com.belatrix.kotlintemplate.asynctask;

import android.os.AsyncTask;

import java.util.Random;

/**
 * Created by eduardomedina on 6/02/18.
 */

public class SimpleAsyncTask extends AsyncTask<Void,String,String> {

    private final AsyncListener asyncListener;
    private boolean state= true;

    public SimpleAsyncTask(AsyncListener asyncListener) {
        this.asyncListener = asyncListener;
    }

    @Override
    protected String doInBackground(Void... voids) {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress("Contador "+i);
        }
        return "Completed!";
    }

    @Override
    protected void onPostExecute(String message) {
        super.onPostExecute(message);
        if(asyncListener!=null){
            asyncListener.updateView(message);
        }
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        if(asyncListener!=null){
            asyncListener.updateView(values[0]);
        }
    }
}
