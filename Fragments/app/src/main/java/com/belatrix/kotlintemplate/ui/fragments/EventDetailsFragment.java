package com.belatrix.kotlintemplate.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.model.StarWarsEvent;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {EventDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MyFragmentListener mListener;

    private ImageView imageViewEvent;
    private TextView textViewEvent;

    private StarWarsEvent starWarsEvent;

    public EventDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventDetailsFragment newInstance(String param1, String param2) {
        EventDetailsFragment fragment = new EventDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_event_details, container, false);
        ui(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyFragmentListener) {
            mListener = (MyFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void ui(View view) {
        imageViewEvent= (ImageView)view.findViewById(R.id.imageViewEvent);
        textViewEvent= (TextView)view.findViewById(R.id.textViewEvent);
        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        extras();
        populate();
    }


    private void extras() {
        if(getActivity().getIntent()!=null && getActivity().getIntent().getExtras()!=null){
            starWarsEvent= (StarWarsEvent) getActivity().getIntent().getExtras().getParcelable("EVENT");
        }
    }

    //https://developer.android.com/topic/performance/graphics/load-bitmap.html
    private void populate() {
        if(starWarsEvent!=null){
            textViewEvent.setText(starWarsEvent.getTitle());
            Picasso.with(imageViewEvent.getContext()).load(starWarsEvent.getPhoto()).into(
                    imageViewEvent);
        }
    }

    public void showEventInfo(StarWarsEvent starWarsEvent){
        Log.v("CONSOLE", "3 EventDetailsFragment starWarsEvent "+starWarsEvent);
        this.starWarsEvent= starWarsEvent;
        populate();
    }
}
