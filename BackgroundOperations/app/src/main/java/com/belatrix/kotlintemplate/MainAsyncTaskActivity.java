package com.belatrix.kotlintemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.belatrix.kotlintemplate.asynctask.AsyncListener;
import com.belatrix.kotlintemplate.asynctask.SimpleAsyncTask;

public class MainAsyncTaskActivity extends AppCompatActivity implements AsyncListener {

    private TextView textView;
    private SimpleAsyncTask simpleAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_async_task);

        textView= findViewById(R.id.textView);

        startTask();
    }

    private void startTask(){
        simpleAsyncTask= new SimpleAsyncTask(this);
        simpleAsyncTask.execute();

    }

    @Override
    public void updateView(String message) {
        textView.setText(message);
    }

}
