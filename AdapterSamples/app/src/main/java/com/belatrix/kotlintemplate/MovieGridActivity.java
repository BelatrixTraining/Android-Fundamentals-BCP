package com.belatrix.kotlintemplate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.belatrix.kotlintemplate.adapter.MovieGridAdapter;
import com.belatrix.kotlintemplate.model.MovieEntity;
import com.belatrix.kotlintemplate.storage.Movies;

import java.util.List;

public class MovieGridActivity extends Activity {

    /*
    1. Proveedor de datos List, ArrayList
    2. Contenedor , ListView, GridView, RecyclerView
    3. Entidad, modelo
    4. Celda , xml
    5. Adapter
    6. Setear adapter al View

 */

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
