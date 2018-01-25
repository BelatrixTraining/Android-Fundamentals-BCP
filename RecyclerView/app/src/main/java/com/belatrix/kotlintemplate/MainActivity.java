package com.belatrix.kotlintemplate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.belatrix.kotlintemplate.data.PokemonData;
import com.belatrix.kotlintemplate.model.Pokemon;
import com.belatrix.kotlintemplate.ui.adapter.MyInterface;
import com.belatrix.kotlintemplate.ui.adapter.MyPokemonAdapter;
import com.belatrix.kotlintemplate.ui.adapter.OnItemClickListener;
import com.belatrix.kotlintemplate.ui.adapter.PokemonAdapter;
import com.belatrix.kotlintemplate.ui.events.ClickListener;
import com.belatrix.kotlintemplate.ui.events.RecyclerTouchListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener, MyInterface{

    private final int DEFAULT_SPANCOUNT=3;
    private RecyclerView recyclerViewPokemon;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Pokemon> pokemonList;
    private PokemonAdapter pokemonAdapter;
    private MyPokemonAdapter myPokemonAdapter;

    public static void noHacer(String message){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();

        loadPokemonData();
    }

    private void gotoDetails(Pokemon pokemon){
        Intent intent= new Intent(this,PokemonDetailsActivity.class);
        startActivity(intent);
    }

    private void gotoDetailsAnimation(Pokemon pokemon,ImageView imageView){
        Intent intent= new Intent(this,PokemonDetailsActivity.class);
        intent.putExtra("POKEMON", pokemon);
        intent.putExtra("IMAGE_TRANSITION", ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent,options.toBundle());
        }
    }

    private void renderPokemons(){
        //paso5
        pokemonAdapter = new PokemonAdapter(this,pokemonList);
        //myPokemonAdapter= new MyPokemonAdapter(this,this,pokemonList);
        //pokemonAdapter.setOnItemClickListener(this);

        //paso 6
        recyclerViewPokemon.setAdapter(pokemonAdapter);
        //recyclerViewPokemon.setAdapter(myPokemonAdapter);
    }

    private void loadPokemonData() {
        pokemonList= new PokemonData().generate();
        renderPokemons();
    }

    private void ui() {
        recyclerViewPokemon= (RecyclerView)findViewById(R.id.recyclerViewPokemon);
        //mLayoutManager= new LinearLayoutManager(this);//,LinearLayoutManager.VERTICAL,)
        mLayoutManager = new GridLayoutManager(this,DEFAULT_SPANCOUNT);
        recyclerViewPokemon.setLayoutManager(mLayoutManager);

        //events
        recyclerViewPokemon.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewPokemon, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(pokemonList!=null){
                    Pokemon pokemon= pokemonList.get(position);
                    gotoDetails(pokemon);
                }
            }

            @Override
            public void onLongClick(View view, int position) {}
        }));
    }

    @Override
    public void onClikListener(int position, View container, ImageView imageView) {
        if(pokemonList!=null){
            Pokemon pokemon= pokemonList.get(position);
            gotoDetailsAnimation(pokemon,imageView);
        }
    }

    @Override
    public void showItemMessage(int position, String message) {
        Toast.makeText(this, "Item "+position+ " "+message,
                Toast.LENGTH_SHORT).show();
    }
}
