package com.belatrix.kotlintemplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.belatrix.kotlintemplate.adapter.MovieAdapter;
import com.belatrix.kotlintemplate.adapter.MovieObjAdapter;
import com.belatrix.kotlintemplate.adapter.SimpleListAdapter;
import com.belatrix.kotlintemplate.model.MovieEntity;
import com.belatrix.kotlintemplate.storage.Movies;

import java.util.List;


public class CustomListActivity extends Activity {

    /*
        1. Proveedor de datos List, ArrayList
        2. Contenedor , ListView, GridView, RecyclerView
        3. Entidad, modelo
        4. Celda , xml
        5. Adapter
        6. Setear adapter al View

     */
    //private String[] mStrings = Cheeses.sCheeseStrings;
    private String[] mStrings = Movies.DATA;
    private ListView lviCheeses;
    private SimpleListAdapter adapter;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        lviCheeses=(ListView)findViewById(R.id.lviCheeses);

        //adapter= new SimpleListAdapter(this,mStrings);
        //lviCheeses.setAdapter(adapter);

        //movieAdapter= new MovieAdapter(this,mStrings);
        //lviCheeses.setAdapter(movieAdapter);

        Movies movies= new Movies();
        List<MovieEntity> data= movies.getMovieEntityList();

        MovieObjAdapter movieObjAdapter= new MovieObjAdapter(this,
                data);

        lviCheeses.setAdapter(movieObjAdapter);

        lviCheeses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                MovieEntity movieEntity =(MovieEntity) adapterView.getAdapter().getItem(position);
                String message= movieEntity.getTitle()+ " "+movieEntity.isCartelera();
                //String.format("title %s cartela %s ",movieEntity.getTitle(),String.valueOf(movieEntity.isCartelera()) );
                showItem(message);
            }
        });
    }

    private void showItem(String value) {

        Toast.makeText(this,"item "+value,Toast.LENGTH_SHORT).show();
    }
}
