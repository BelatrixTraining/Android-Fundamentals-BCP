package com.belatrix.bxtemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.belatrix.bxtemplate.model.MovieEntity;


public class MovieDetailActivity extends AppCompatActivity {

    private MovieEntity movieEntity;

    private TextView tviName,tviDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        extras();
        ui();

        populate();
    }

    private void populate() {

        if(movieEntity!=null){
            tviName.setText(checkNotNull(movieEntity.getTitle()));
            tviDesc.setText(checkNotNull(movieEntity.getDesc()));
        }
    }

    private String checkNotNull(String string) {
        if(string==null || string.isEmpty()){
            return "";
        }
        return string;
    }

    private void ui() {
        tviName= (TextView)findViewById(R.id.tviName);
        tviDesc= (TextView)findViewById(R.id.tviDesc);

    }

    private void extras() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            movieEntity = (MovieEntity) bundle.getSerializable("MOVIE");
        }
    }


    /*private void extras() {
        if(getIntent()!=null && getIntent().getExtras()!=null){
            Bundle bundle= getIntent().getExtras();
            movieEntity= (MovieEntity) bundle.getSerializable("MOVIE");
        }
    }*/
}
