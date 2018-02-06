package com.belatrix.kotlintemplate.threads;

import android.util.Log;

/**
 * Created by emedinaa on 23/02/17.
 */

public class SomeThread extends Thread {

    private final String TAG= "Thread";
    @Override
    public void run() {
        super.run();

        //ejecutar una tarea
        for (int i = 0; i <100 ; i++) {
            Log.v(TAG, "count "+i);
        }
    }
}
