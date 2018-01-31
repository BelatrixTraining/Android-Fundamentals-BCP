package com.belatrix.kotlintemplate.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.listeners.OnColorListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {@link BoxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BoxFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnColorListener mListener;
    private FrameLayout flayBox;

    public BoxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BoxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BoxFragment newInstance(String param1, String param2) {
        BoxFragment fragment = new BoxFragment();
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
        return inflater.inflate(R.layout.fragment_box, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnColorListener) {
            mListener = (OnColorListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnColorListener");
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
        flayBox= (FrameLayout)getView().findViewById(R.id.flayBox);
    }

    public void recibirColoryPintar(int position){
        int color=0;
        switch (position){
            case 0: //morado
                color= Color.MAGENTA;
                break;
            case 1://rojo
                color= Color.RED;
                break;
            case 2: //amarillo
                color= Color.YELLOW;
                break;
        }
        flayBox.setBackgroundColor(color);
    }
}
