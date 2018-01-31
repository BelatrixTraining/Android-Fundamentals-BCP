package com.belatrix.kotlintemplate.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belatrix.kotlintemplate.EventDetailFragmentActivity;
import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.data.StarWarsEventData;
import com.belatrix.kotlintemplate.model.StarWarsEvent;
import com.belatrix.kotlintemplate.ui.adapter.StarWarsEventAdapter;
import com.belatrix.kotlintemplate.ui.events.ClickListener;
import com.belatrix.kotlintemplate.ui.events.RecyclerTouchListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * { EventFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MyFragmentListener mListener;

    private RecyclerView recyclerViewEvents;
    private List<StarWarsEvent> events;

    public EventFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventFragment newInstance(String param1, String param2) {
        EventFragment fragment = new EventFragment();
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
        View view= inflater.inflate(R.layout.fragment_event, container, false);
        ui(view);
        return view;
    }

    private void ui(View view) {
        recyclerViewEvents= (RecyclerView)view.findViewById(R.id.recyclerViewEvents);
        recyclerViewEvents.setLayoutManager(new LinearLayoutManager(getActivity()));

        //events
        recyclerViewEvents.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerViewEvents, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(events!=null){
                    StarWarsEvent starWarsEvent= events.get(position);
                    //gotoDetails(starWarsEvent);
                    Log.v("CONSOLE", "1 EventFragment starWarsEvent "+starWarsEvent);
                    if(mListener!=null){
                        mListener.goToEventDetail(starWarsEvent);
                    }
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    private void loadData() {
        events= new StarWarsEventData().generate();
        renderEvents(events);
    }

    private void renderEvents(List<StarWarsEvent> events){
        this.events= events;
        recyclerViewEvents.setAdapter(new StarWarsEventAdapter(getActivity(),this.events));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    private void gotoDetails(StarWarsEvent starWarsEvent) {
        Intent intent= new Intent(getActivity(),EventDetailFragmentActivity.class);
        intent.putExtra("EVENT",starWarsEvent);
        startActivity(intent);
    }
}

