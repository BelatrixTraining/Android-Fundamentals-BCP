package com.belatrix.bxtemplate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.belatrix.bxtemplate.R;
import com.belatrix.bxtemplate.model.MovieEntity;

import java.util.List;

/**
 * Created by eduardomedina on 26/01/17.
 */
public class MovieRecyclerAdapter  extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>{

    private List<MovieEntity> movies;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tviTitle;
        public ImageView iviCartelera;

        public ViewHolder(View view) {
            super(view);
            tviTitle=(TextView)view.findViewById(R.id.tviName);
            iviCartelera= (ImageView)view.findViewById(R.id.iviCartelera);
        }
    }

    public MovieRecyclerAdapter(List<MovieEntity> movies) {
        this.movies = movies;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
       View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_movie_grid, parent, false);

        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        MovieEntity movieEntity= movies.get(position);
        int visibility= movieEntity.isCartelera()?(View.VISIBLE):View.GONE;

        holder.tviTitle.setText(movieEntity.getTitle());
        holder.iviCartelera.setVisibility(visibility);
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movies.size();
    }

}
