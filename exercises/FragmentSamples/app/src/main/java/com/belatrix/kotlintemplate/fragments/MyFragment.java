package com.belatrix.kotlintemplate.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.listeners.OnSimpleListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="MyFragment" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnSimpleListener mListener;


    public MyFragment() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_my, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSimpleListener) {
            mListener = (OnSimpleListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSimpleListener");
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
        extras();
    }

    private void extras() {
        if(getArguments()!=null){
            Bundle bundle= getArguments();
            int position= bundle.getInt("POSITION");
            String name= bundle.getString("NAME");

            Log.v(TAG, "position "+position+ " name "+name);
        }
    }
}
