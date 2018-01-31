package com.belatrix.kotlintemplate.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.model.StarWarsEvent;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by emedinaa on 15/08/17.
 */

public class StarWarsEventAdapter extends RecyclerView.Adapter<StarWarsEventAdapter.ViewHolder> {

    private List<StarWarsEvent> eventList;
    private final Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewEvent;
        public ImageView imageViewEvent;
        public View view;

        public ViewHolder(View v) {
            super(v);
            this.view = v;
            textViewEvent = (TextView) v.findViewById(R.id.textViewEvent);
            imageViewEvent = (ImageView) v.findViewById(R.id.imageViewEvent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public StarWarsEventAdapter(Context context, List<StarWarsEvent> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_event, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        StarWarsEvent starWarsEvent = eventList.get(position);
        holder.textViewEvent.setText(starWarsEvent.getTitle());
        Picasso.with(holder.imageViewEvent.getContext()).load(starWarsEvent.getPhoto()).into(
                holder.imageViewEvent);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return eventList.size();
    }
}