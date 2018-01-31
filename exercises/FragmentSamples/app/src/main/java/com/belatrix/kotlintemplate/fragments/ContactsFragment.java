package com.belatrix.kotlintemplate.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.adapters.ContactAdapter;
import com.belatrix.kotlintemplate.listeners.OnContactListener;
import com.belatrix.kotlintemplate.model.ContactEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {@link ContactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnContactListener mListener;
    private ListView lstContacts;
    private List<ContactEntity> data;


    public ContactsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactsFragment newInstance(String param1, String param2) {
        ContactsFragment fragment = new ContactsFragment();
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
        View view=  inflater.inflate(R.layout.fragment_contacts, container, false);
        ui(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnContactListener) {
            mListener = (OnContactListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnContactListener");
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

        getContacts();
        //2 Lista lstContacts
        //3 Item row_contact
        //4 Adapter
        ContactAdapter contactAdapter= new ContactAdapter(data,getActivity());
        lstContacts.setAdapter(contactAdapter);

        if(mListener!=null)mListener.renderFirst(first());
    }

    private void getContacts() {
        //1. DATA
        ContactEntity contactEntity= new ContactEntity();
        contactEntity.setId(1);
        contactEntity.setName("Pedro Palotes");
        contactEntity.setEmail("pedro@gmail.com");
        contactEntity.setGroup("Personal");
        contactEntity.setPhone("92835056");
        contactEntity.setPhoto(R.mipmap.img002);

        ContactEntity contactEntity1= new ContactEntity();
        contactEntity1.setId(2);
        contactEntity1.setName("Carlos Palotes");
        contactEntity1.setEmail("carlos@gmail.com");
        contactEntity1.setGroup("Familia");
        contactEntity1.setPhone("96859685");
        contactEntity1.setPhoto(R.mipmap.img004);

        ContactEntity contactEntity2= new ContactEntity();
        contactEntity2.setId(3);
        contactEntity2.setName("Jose Mendoza");
        contactEntity2.setEmail("jose@gmail.com");
        contactEntity2.setGroup("Trabajo");
        contactEntity2.setPhone("97457434");
        contactEntity2.setPhoto(R.mipmap.img005);

        data = new ArrayList<>();
        data.add(contactEntity);
        data.add(contactEntity1);
        data.add(contactEntity2);
    }

    private void ui(View view) {
        lstContacts= (ListView)view.findViewById(R.id.lstContacts);

        //events
        lstContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(mListener!=null && data!=null){
                    ContactEntity contactEntity= (ContactEntity) adapterView.getAdapter().getItem(i);
                    mListener.selectedItemContact(contactEntity);
                }
            }
        });
    }

    private ContactEntity first(){
        if(data!=null){
            return data.get(0);
        }
        return null;
    }
}
