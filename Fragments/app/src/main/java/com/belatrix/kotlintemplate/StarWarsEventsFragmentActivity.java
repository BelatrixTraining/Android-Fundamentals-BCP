package com.belatrix.kotlintemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.belatrix.kotlintemplate.model.StarWarsEvent;
import com.belatrix.kotlintemplate.ui.fragments.EventDetailsFragment;
import com.belatrix.kotlintemplate.ui.fragments.EventFragment;
import com.belatrix.kotlintemplate.ui.fragments.MyFragmentListener;


/**
 * Este ejemplo realiza lo mismo que StarWarsEventsActivity
 * pero esta hecho con fragments y una actividad como contenedor.
 * Tambien valida si estamos en un smartphone o un table , verificando
 * si que exista los 2 fragment o solo 1 , en el caso que exista un solo
 * fragment usa actividades .
 */
public class StarWarsEventsFragmentActivity extends AppCompatActivity implements MyFragmentListener {

    private FragmentManager fragmentManager;
    private EventFragment eventFragment;
    private EventDetailsFragment eventDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars_events_fragment);
        app();
    }

    private void app() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentManager= getSupportFragmentManager();
        eventFragment= (EventFragment) fragmentManager.findFragmentById(R.id.fragmentEvents);
        eventDetailsFragment= (EventDetailsFragment) fragmentManager.findFragmentById(R.id.fragmentDetails);
    }

    @Override
    public void fragmentAction(Object object) {}

    @Override
    public void goToEventDetail(Object object) {

        StarWarsEvent starWarsEvent= (StarWarsEvent)(object);
        if(eventDetailsFragment!=null){
            sendDataToEventDetail(starWarsEvent);

        }else{
            startEventDetail(starWarsEvent);
        }
    }

    private void startEventDetail(StarWarsEvent starWarsEvent){
        Intent intent= new Intent(this,EventDetailFragmentActivity.class);
        intent.putExtra("EVENT",starWarsEvent);
        startActivity(intent);
    }

    private void sendDataToEventDetail(StarWarsEvent starWarsEvent){
        eventDetailsFragment.showEventInfo(starWarsEvent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
