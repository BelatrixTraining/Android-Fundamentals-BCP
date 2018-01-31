package com.belatrix.kotlintemplate.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.belatrix.kotlintemplate.MainMessageActivity;
import com.belatrix.kotlintemplate.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * interface
 * to handle interaction events.
 * Use the {@link WriteMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WriteMessageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private final String TAG="CONSOLE";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MessageListener mListener;
    private EditText eteMessage;
    private Button btnSend;
    private String message;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WriteMessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WriteMessageFragment newInstance(String param1, String param2) {
        WriteMessageFragment fragment = new WriteMessageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public WriteMessageFragment() {
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
        return inflater.inflate(R.layout.fragment_write_message, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MessageListener) {
            mListener = (MessageListener) context;
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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        eteMessage= (EditText)getView().findViewById(R.id.eteMessage);
        btnSend= (Button)getView().findViewById(R.id.btnSend);

        //TODO events...
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message= eteMessage.getText().toString();
                Log.v(TAG, "1 WriteMessageFragment message " + message);
                if(mListener!=null)
                {
                    mListener.recibiryEnviardesdeFragment(message);

                    //( (MainMessageActivity)(getActivity())).getTwoFragment().mostrarMensaje();
                }
            }
        });

        //btnSend.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            message= eteMessage.getText().toString();
            Log.v(TAG, "1. message " + message);
            ((MainMessageActivity)getActivity()).recibiryEnviarMensaje(message);
        }
    };
}
