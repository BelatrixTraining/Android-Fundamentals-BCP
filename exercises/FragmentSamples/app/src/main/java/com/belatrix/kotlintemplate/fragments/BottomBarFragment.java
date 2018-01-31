package com.belatrix.kotlintemplate.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.listeners.OnColorListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {@link BottomBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomBarFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnColorListener mListener;
    private Button btnBox0;
    private Button btnBox1;
    private Button btnBox2;

    public BottomBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottomBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomBarFragment newInstance(String param1, String param2) {
        BottomBarFragment fragment = new BottomBarFragment();
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
        return inflater.inflate(R.layout.fragment_bottom_bar, container, false);
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
        btnBox0= (Button)getView().findViewById(R.id.btnBox0);
        btnBox1= (Button)getView().findViewById(R.id.btnBox1);
        btnBox2= (Button)getView().findViewById(R.id.btnBox2);

        btnBox0.setOnClickListener(this);
        btnBox1.setOnClickListener(this);
        btnBox2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int pos=-1;
        switch (view.getId()){
            case R.id.btnBox0:
                pos=0;
                break;
            case R.id.btnBox1:
                pos=1;
                break;
            case R.id.btnBox2:
                pos=2;
                break;
        }

        if(pos>=0){
            mListener.seleccionarColor(pos);
        }
    }
}
