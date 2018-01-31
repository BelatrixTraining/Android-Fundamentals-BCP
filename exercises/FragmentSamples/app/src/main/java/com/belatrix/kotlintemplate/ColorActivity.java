package com.belatrix.kotlintemplate;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.belatrix.kotlintemplate.fragments.BottomBarFragment;
import com.belatrix.kotlintemplate.fragments.BoxFragment;
import com.belatrix.kotlintemplate.listeners.OnColorListener;


public class ColorActivity extends AppCompatActivity implements OnColorListener {

    private BottomBarFragment bottomBarFragment;
    private BoxFragment boxFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        fragmentManager= getSupportFragmentManager();

        bottomBarFragment= (BottomBarFragment) fragmentManager.findFragmentById(R.id.fragBottom);
        boxFragment= (BoxFragment) fragmentManager.findFragmentById(R.id.fragBox);
    }

    @Override
    public void seleccionarColor(int pos) {
        boxFragment.recibirColoryPintar(pos);
    }
}
