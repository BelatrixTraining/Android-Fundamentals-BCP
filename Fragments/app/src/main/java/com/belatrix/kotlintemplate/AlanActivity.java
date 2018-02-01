package com.belatrix.kotlintemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.belatrix.kotlintemplate.ui.fragments.BlankFragmentListener;

public class AlanActivity extends AppCompatActivity implements BlankFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alan);
    }

    @Override
    public void actionFragment(Object object) {

    }

    @Override
    public void actionActivityCambiarColor() {

    }

    @Override
    public void alanLlamaAPapa(Object object) {

    }

    @Override
    public void alanHolaApi(Object object) {

    }

    @Override
    public void cerrarSesion() {

    }
}
