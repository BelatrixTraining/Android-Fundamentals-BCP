package com.belatrix.bxtemplate;

import android.animation.Animator;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_example1);
        //setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_linear);
        //setContentView(R.layout.layout_constraint_sample1);
        //setContentView(R.layout.layout_constraint_sample2);
        setContentView(R.layout.layout_constraint_sample3);
    }

}
