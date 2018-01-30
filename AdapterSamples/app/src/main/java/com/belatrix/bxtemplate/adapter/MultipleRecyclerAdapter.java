package com.belatrix.bxtemplate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.belatrix.bxtemplate.R;
import com.belatrix.bxtemplate.model.MovieEntity;
import com.belatrix.bxtemplate.model.PlaceEntity;
import com.belatrix.bxtemplate.model.TypeEntity;

import java.util.List;

/**
 * Created by eduardomedina on 26/01/17.
 */
public class MultipleRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<TypeEntity> objects;

    private final int MOVIE = 0;
    private final int PLACE = 1;

    public MultipleRecyclerAdapter(List<TypeEntity> objects) {
        this.objects = objects;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case MOVIE:
                View movieView = inflater.inflate(R.layout.row_movie, parent, false);
                viewHolder = new MovieViewHolder(movieView);
                break;
            case PLACE:
                View placeView = inflater.inflate(R.layout.row_place, parent, false);
                viewHolder = new PlaceViewHolder(placeView);
                break;
            default:
                View defaultView = inflater.inflate(R.layout.row_movie, parent, false);
                viewHolder = new MovieViewHolder(defaultView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case MOVIE:
                MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
                renderItemMovie(movieViewHolder, position);
                break;
            case PLACE:
                PlaceViewHolder placeViewHolder = (PlaceViewHolder) holder;
                renderPlaceMovie(placeViewHolder, position);
                break;
            default:
                MovieViewHolder defaultViewHolder = (MovieViewHolder) holder;
                renderItemMovie(defaultViewHolder, position);
                break;
        }
    }

    private void renderPlaceMovie(PlaceViewHolder placeViewHolder, int position) {
        PlaceEntity placeEntity= (PlaceEntity) objects.get(position);
        if(placeEntity!=null){
            placeViewHolder.tviTitle.setText(placeEntity.getTitle());
        }
    }

    private void renderItemMovie(MovieViewHolder movieViewHolder, int position) {
        MovieEntity movieEntity= (MovieEntity) objects.get(position);
        if(movieEntity!=null){
            movieViewHolder.tviName.setText(movieEntity.getTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (objects.get(position).isMovie()) {
            return MOVIE;
        } else if (objects.get(position).isPlace()) {
            return PLACE;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return this.objects.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        public TextView tviName;
        public MovieViewHolder(View itemView) {
            super(itemView);
            tviName= (TextView) itemView.findViewById(R.id.tviName);
        }
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder{

        public TextView tviTitle;
        public PlaceViewHolder(View itemView) {
            super(itemView);
            tviTitle= (TextView) itemView.findViewById(R.id.tviTitle);
        }
    }
}
