package com.belatrix.kotlintemplate;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.belatrix.kotlintemplate.ui.fragments.BxFragment;


public class BxActivity extends AppCompatActivity implements MyFragmentCallback {

    private FragmentManager fragmentManager;
    private BxFragment bxFragment;
    private View buttonHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bx);
        //init();
        //ui
        //setUpFragment
        buttonHide= findViewById(R.id.buttonHide);
        fragmentManager= getSupportFragmentManager();
        bxFragment= (BxFragment) fragmentManager.findFragmentById(R.id.bxFragment);

        //events
        buttonHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunicarActivityconFragment();
            }
        });

        comunicarActivityconFragment();
    }


    public void showMessageFromActivity(String message){
        Log.v("CONSOLE", " (1) 2 BxActivity");
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    //Escenario (1)
    @Override
    public void comunicarFragmentconActivity(String message) {
        Log.v("CONSOLE", " (1)2 BxActivity con Callback");
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    //Escenario (2)
    @Override
    public void comunicarActivityconFragment() {
        Log.v("CONSOLE", " (2)1 BxActivity");
        if(bxFragment!=null){
            //bxFragment.getView().setVisibility(View.GONE);
            //bxFragment.hideFragment();
            bxFragment.changeTextColor();
        }
    }
}
