package com.belatrix.kotlintemplate.fragments;

import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.listeners.OnCardListener;
import com.belatrix.kotlintemplate.utils.DisplayUtils;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "CardFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnCardListener mListener;

    private Matrix matrix = new Matrix();
    private int xCoord;
    private int yCoord;
    private int center;
    private float angle;
    private int startAngle;

    private int windowWidth;
    private int windowHeight;

    public CardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardFragment newInstance(String param1, String param2) {
        CardFragment fragment = new CardFragment();
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
        return inflater.inflate(R.layout.fragment_card, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCardListener) {
            mListener = (OnCardListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCardListener");
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
        calculateDisplayDimentions();
        center = windowWidth/2 ;
        startAngle= randombyRange(-5,5);

        getView().setRotation(startAngle);

        getView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:

                        break;

                    case MotionEvent.ACTION_MOVE:
                        xCoord = (int) motionEvent.getRawX();
                        yCoord = (int) motionEvent.getRawY();

                        getView().setX(xCoord - center + 40);
                        getView().setY(yCoord-windowHeight/2);

                        if (xCoord >= center)
                        {
                            angle= (float) ((xCoord - center) * (Math.PI / 32));

                        }else
                        {
                            angle= (float) ((xCoord - center) * (Math.PI / 32));
                        }
                        getView().setRotation(angle);
                        Log.v(TAG, "angle "+angle);
                        break;

                    case MotionEvent.ACTION_UP:

                        if(Math.abs(angle)>60){
                            if(mListener!=null){
                                mListener.removeCard(CardFragment.this);
                            }
                            return true;
                        }
                        xCoord = (int) motionEvent.getRawX();
                        yCoord = (int) motionEvent.getRawY();

                        getView().setX(20* DisplayUtils.getCurrentDIP(getActivity()));
                        getView().setY(10*DisplayUtils.getCurrentDIP(getActivity()));
                        getView().setRotation(startAngle);
                        angle=0;
                        break;
                }
                return true;
            }
        });
    }

    private void calculateDisplayDimentions(){
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        windowWidth= metrics.widthPixels;
        windowHeight= metrics.heightPixels;

    }
    private int randombyRange(int min, int max){

        int range = max - min + 1;
        int randomValue =  new Random().nextInt(range) + min;

        return randomValue;
    }
}
