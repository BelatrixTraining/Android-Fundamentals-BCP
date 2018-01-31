package com.belatrix.kotlintemplate.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.belatrix.kotlintemplate.MyFragmentCallback;
import com.belatrix.kotlintemplate.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BxFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BxFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MyFragmentCallback mListener;

    private TextView textView;

    public BxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BxFragment newInstance(String param1, String param2) {
        BxFragment fragment = new BxFragment();
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
        View viewContainer=inflater.inflate(R.layout.fragment_bx, container, false);
        textView= (TextView) viewContainer.findViewById(R.id.textView);
        return viewContainer;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyFragmentCallback) {
            mListener = (MyFragmentCallback) context;
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

        //textView=(TextView) getView().findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showMessage();
                sendMessageToActivity();
            }
        });
    }

    //Comunicación de Fragment a un Activity (1)
    private void sendMessageToActivity(){
        Log.v("CONSOLE", " 1 BxFragment con callback");
        /*((BxActivity)getActivity()).
                showMessageFromActivity("Hello Activity from Fragment");*/
        if(mListener!=null){
            mListener.comunicarFragmentconActivity("Hello Activity from Fragment");
        }
    }
    private void showMessage() {
        Toast.makeText(getActivity(),"Hello Fragment",Toast.LENGTH_LONG).show();
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

    public void hideFragment(){
        Log.v("CONSOLE", " (2)2 BxFragment hideFragment()");
        getView().setVisibility(View.GONE);
    }

    public void changeTextColor(){
        textView.setTextColor(Color.BLUE);
    }
}
