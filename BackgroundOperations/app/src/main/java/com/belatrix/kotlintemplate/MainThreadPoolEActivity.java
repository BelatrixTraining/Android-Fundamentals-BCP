package com.belatrix.kotlintemplate;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.belatrix.kotlintemplate.threads.MyTask;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainThreadPoolEActivity extends AppCompatActivity {

    // Sets the size of the storage that's used to cache images
    private static final int IMAGE_CACHE_SIZE = 1024 * 1024 * 4;

    // Sets the amount of time an idle thread will wait for a task before terminating
    private static final int KEEP_ALIVE_TIME = 1;

    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT=TimeUnit.SECONDS;

    // Sets the initial threadpool size to 8
    private static final int CORE_POOL_SIZE = 8;

    // Sets the maximum threadpool size to 8
    private static final int MAXIMUM_POOL_SIZE = 8;

    private BlockingDeque<Runnable> myTaskBlockingQueue;

    private Handler mHandler;
    private ThreadPoolExecutor threadPoolExecutor;
    private MyTask myTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thread_pool_e);
        app();
    }

    private void app() {

        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //Log.v("CONSOLE","thread ...");
            }
        };

        myTask= new MyTask();
        myTaskBlockingQueue= new LinkedBlockingDeque<Runnable>();


        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, myTaskBlockingQueue);

        threadPoolExecutor.execute(myTask);
    }
}
