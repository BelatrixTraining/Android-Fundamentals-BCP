package com.belatrix.kotlintemplate.ui.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.model.Pokemon;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by emedinaa on 30/09/17.
 */

public class MyPokemonAdapter  extends RecyclerView.Adapter<MyPokemonAdapter.ViewHolder>{

    private final List<Pokemon> pokemons;
    private final Context context;
    private final MyInterface myInterface;

    public MyPokemonAdapter(Context context, MyInterface myInterface, List<Pokemon> pokemons) {
        this.context= context;
        this.pokemons = pokemons;
        this.myInterface = myInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pokemon, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - replace the contents of the view with that element
        Pokemon pokemon= pokemons.get(position);

        final int itemPosition= position;
        final String pokemonName=pokemon.getName();

        holder.tviName.setText(pokemon.getName());
        holder.iviPhoto.setImageBitmap(getBitmapFromAssets(pokemon.getPhoto()));

        holder.iviPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myInterface!=null){
                    myInterface.showItemMessage(itemPosition,pokemonName);
                    //MainKotlinActivity.noHacer();
                }
            }
        });
        /*holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null){
                    Log.v("ADAPTER", "iviPhoto "+holder.iviPhoto);
                    ViewCompat.setTransitionName(holder.iviPhoto, "iviPhoto");
                    onItemClickListener.onClikListener(position,view,holder.iviPhoto);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public Bitmap getBitmapFromAssets(String fileName) {
        AssetManager assetManager = context.getAssets();

        InputStream istr = null;
        try {
            istr = assetManager.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        return bitmap;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tviName;
        public ImageView iviPhoto;
        public View view;
        public ViewHolder(View  v) {
            super(v);
            this.view = v;
            tviName= (TextView) v.findViewById(R.id.tviName);
            iviPhoto= (ImageView) v.findViewById(R.id.iviPhoto);
        }
    }
}
