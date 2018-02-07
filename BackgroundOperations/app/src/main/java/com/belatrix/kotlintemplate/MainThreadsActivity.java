package com.belatrix.kotlintemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainThreadsActivity extends AppCompatActivity {


    private final String TAG= "CONSOLE";
    private TextView title, console ;
    private  MyRunnable2 myRunnable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_threads);
        ui();

        title.setText("Threads ...");
        startWorking();
        //startWorking2();
    }

    private void ui() {
        title= (TextView)findViewById(R.id.title);
        console= (TextView)findViewById(R.id.consoleTv);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myRunnable2!=null){
            myRunnable2.stop();
        }
    }

    private void logOnConsole(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                console.setText(console.getText() + "\n" + message);
            }
        });
    }

    private void logConsole2(final String message){
        console.setText(console.getText() + "\n" + message);
    }

    public void startWorking2(){

        myRunnable2= new MyRunnable2();
        Executor executor = Executors.newFixedThreadPool(1);
        executor.execute(myRunnable2);

    }

    public void startWorking(){
        Executor executor = Executors.newFixedThreadPool(5);
        //executor.execute(new MyRunnable());
        for ( int i=0; i < 20; i++ ) {
            executor.execute(new MyRunnable());
        }
    }

    public class MyRunnable implements Runnable {
        public void run() {
            Log.d(TAG, "Running From Thread " + Thread.currentThread().getId());
            logOnConsole("Running From Thread " + Thread.currentThread().getId());
            //logConsole2("Threads..");
            // Your Long Running Computation Task
            try {
                // Sleeps for 200 ms
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class MyRunnable2 implements Runnable{
        private boolean running=true;

        @Override
        public void run() {

            while (running){
                try {
                    Log.d(TAG, "Running from thread "+Thread.currentThread().getId());
                    //logConsole2("Running From Thread " + Thread.currentThread().getId());
                    logOnConsole("Running From Thread " + Thread.currentThread().getId());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stop(){
            running= false;
        }
    }
}
