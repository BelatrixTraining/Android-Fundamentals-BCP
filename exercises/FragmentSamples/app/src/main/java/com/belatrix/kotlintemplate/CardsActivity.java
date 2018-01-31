package com.belatrix.kotlintemplate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.belatrix.kotlintemplate.fragments.CardFragment;
import com.belatrix.kotlintemplate.listeners.OnCardListener;


public class CardsActivity extends AppCompatActivity implements OnCardListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        ui();
        populateCards();

    }

    private void ui() {
        findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFragments();
                populateCards();
            }
        });
    }

    private void populateCards() {

        for (int i = 0; i <5 ; i++) {
            addFragment();
        }
    }
    private void clearFragments(){

        for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            removeFragment(fragment);
        }
    }

    private void addFragment() {

        CardFragment cardFragment = CardFragment.newInstance(null,null);
        Bundle args = new Bundle();
        cardFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.flayContainer, cardFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    private void removeFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    @Override
    public void removeCard(Fragment fragment) {
        removeFragment(fragment);
    }
}
