package com.belatrix.kotlintemplate.threads;

/**
 * Created by emedinaa on 23/02/17.
 */

public class MyTask implements Runnable {

    private boolean state= true;

    @Override
    public void run() {
        int count=0;
        while (count<100){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}
