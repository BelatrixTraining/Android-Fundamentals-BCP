package com.belatrix.bxtemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.belatrix.bxtemplate.adapter.MovieRecyclerAdapter;
import com.belatrix.bxtemplate.model.MovieEntity;
import com.belatrix.bxtemplate.storage.Movies;

import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rviewMovies;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ui();
        getMovies();
    }

    private void getMovies() {
        //proveedor de datos
        Movies movieRepo= new Movies();
        List<MovieEntity> movies= movieRepo.getMovieEntityList();

        //adapter
        // specify an adapter (see also next example)
        adapter = new MovieRecyclerAdapter(movies);
        rviewMovies.setAdapter(adapter);
    }

    private void ui() {
        //La vista
        rviewMovies= (RecyclerView) findViewById(R.id.rviewMovies);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rviewMovies.setHasFixedSize(true);

        // use a linear layout manager
        //mLayoutManager = new LinearLayoutManager(this);

        // use a grid layout manager
        mLayoutManager = new GridLayoutManager(this,2);

        rviewMovies.setLayoutManager(mLayoutManager);
    }

}
