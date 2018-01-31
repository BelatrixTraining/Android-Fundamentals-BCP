package com.belatrix.kotlintemplate.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.listeners.OnMessageListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {@link AddMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMessageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="AddMessageF";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnMessageListener mListener;
    private EditText eteMessage;
    private Button btnSend;
    private String message;

    public AddMessageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddMessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddMessageFragment newInstance(String param1, String param2) {
        AddMessageFragment fragment = new AddMessageFragment();
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
        return inflater.inflate(R.layout.fragment_add_message, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        eteMessage= (EditText)getView().findViewById(R.id.eteMessage);
        btnSend= (Button)getView().findViewById(R.id.btnSend);

        //TODO events...
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message= eteMessage.getText().toString();
                Log.v(TAG, "1 message " + message);

                //((MessageActivity)getActivity()).recibiryEnviardesdeFragment(message);
                //((OnMessageListener)getActivity()).recibiryEnviardesdeFragment(message);
                eteMessage.setText("");
                send();


            }
        });
        eteMessage.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (keyEvent != null) {
                    Log.v(TAG, "keycode " + keyEvent.getKeyCode() +
                            " actionId " + actionId);
                }
                if ((keyEvent != null && (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    message= eteMessage.getText().toString();
                    eteMessage.setText("");
                    send();

                }
                return false;
            }
        });
    }

    private void send() {

        if(mListener!=null) {
            mListener.recibiryEnviardesdeFragment(message);
            message="";
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMessageListener) {
            mListener = (OnMessageListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMessageListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
