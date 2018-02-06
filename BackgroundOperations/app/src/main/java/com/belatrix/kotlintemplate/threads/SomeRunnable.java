package com.belatrix.kotlintemplate.threads;

import android.util.Log;

/**
 * Created by emedinaa on 23/02/17.
 */

public class SomeRunnable implements Runnable {
    private final String TAG= "Runnable";

    @Override
    public void run() {
        //ejecutar una tarea
        for (int i = 0; i <100 ; i++) {
            Log.v(TAG, "count "+i);
        }
    }
}
