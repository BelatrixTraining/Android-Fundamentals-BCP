package com.belatrix.kotlintemplate;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.belatrix.kotlintemplate.ui.fragments.BlankFragment;
import com.belatrix.kotlintemplate.ui.fragments.BlankFragmentListener;


public class FragmentBasicActivity extends AppCompatActivity
implements BlankFragmentListener {

    private BlankFragment blankFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_basic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragmentManager= getSupportFragmentManager();
        blankFragment= (BlankFragment) fragmentManager.findFragmentById(R.id.blankFragment);


        //blankFragment.ejecutarAccionDesdeFragment("Hola Fragment");
        blankFragment.cambiarColorFondo();

    }

    @Override
    public void actionFragment(Object object) {
       //TODO REALIZAR ACCION
    }

    @Override
    public void actionActivityCambiarColor() {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
