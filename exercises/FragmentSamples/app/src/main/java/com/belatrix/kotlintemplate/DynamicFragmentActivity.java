package com.belatrix.kotlintemplate;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.belatrix.kotlintemplate.fragments.MyFragment;
import com.belatrix.kotlintemplate.listeners.OnSimpleListener;


public class DynamicFragmentActivity extends AppCompatActivity implements OnSimpleListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        addFragment();
    }

    private void addFragment() {

        MyFragment newFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("POSITION", 1);
        args.putString("NAME", "MyFragment");
        newFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flayContainer, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
