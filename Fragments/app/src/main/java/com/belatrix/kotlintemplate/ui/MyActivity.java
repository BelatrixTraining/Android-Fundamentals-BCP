package com.belatrix.kotlintemplate.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.ui.fragments.BlankFragmentListener;


public class MyActivity extends AppCompatActivity
        implements BlankFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public void actionFragment(Object object) {

    }

    @Override
    public void actionActivityCambiarColor() {

    }
}
