package com.belatrix.kotlintemplate;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.belatrix.kotlintemplate.ui.fragments.BlankFragment;
import com.belatrix.kotlintemplate.ui.fragments.BlankFragmentListener;


public class FragmentCommunicationActivity extends AppCompatActivity
implements BlankFragmentListener {

    private BlankFragment blankFragment;
    private FragmentManager fragmentManager;
    private View constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        constraintLayout= findViewById(R.id.constraintLayout);

        fragmentManager= getSupportFragmentManager();
        blankFragment= (BlankFragment)fragmentManager.findFragmentById(R.id.blankFragment);

        //blankFragment.ejecutarAccionDesdeFragment("Hola Fragment");
    }

    public void otroMetodo(){}

    @Override
    public void actionFragment(Object object) {
        String message= String.valueOf(object);
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void actionActivityCambiarColor() {
        constraintLayout.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
