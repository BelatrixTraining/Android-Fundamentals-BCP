package com.belatrix.kotlintemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.belatrix.kotlintemplate.model.StarWarsEvent;
import com.squareup.picasso.Picasso;

/**
 * Esta Actividad muestra el detalle de un evento
 */
public class EventDetailsActivity extends AppCompatActivity {

    private ImageView imageViewEvent;
    private TextView textViewEvent;

    private StarWarsEvent starWarsEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        extras();
        ui();

        populate();
    }

    private void populate() {
        if(starWarsEvent!=null){
            textViewEvent.setText(starWarsEvent.getTitle());
            Picasso.with(imageViewEvent.getContext()).load(starWarsEvent.getPhoto()).into(
                    imageViewEvent);
        }
    }

    private void extras() {
        if(getIntent()!=null && getIntent().getExtras()!=null){
            starWarsEvent= (StarWarsEvent) getIntent().getExtras().getParcelable("EVENT");
        }
    }

    private void ui() {
        imageViewEvent= (ImageView)findViewById(R.id.imageViewEvent);
        textViewEvent= (TextView) findViewById(R.id.textViewEvent);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
