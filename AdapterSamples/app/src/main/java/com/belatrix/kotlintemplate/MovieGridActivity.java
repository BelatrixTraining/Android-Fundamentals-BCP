package com.belatrix.kotlintemplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.belatrix.kotlintemplate.adapter.MovieGridAdapter;
import com.belatrix.kotlintemplate.model.MovieEntity;
import com.belatrix.kotlintemplate.storage.Movies;

import java.util.List;

public class MovieGridActivity extends Activity {

    private GridView myGrid;
    private MovieGridAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);

        myGrid=(GridView) findViewById(R.id.myGrid);


        Movies movies= new Movies();
        List<MovieEntity> data= movies.getMovieEntityList();

        movieAdapter= new MovieGridAdapter(this,
                data);
        myGrid.setAdapter(movieAdapter);

    }
}
