package com.belatrix.kotlintemplate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.belatrix.kotlintemplate.R;
import com.belatrix.kotlintemplate.model.ContactEntity;

import java.util.List;


/**
 * Created by emedinaa on 08/09/15.
 */
public class ContactAdapter extends BaseAdapter {

    private List<ContactEntity> contactEntities;
    private Context context;

    public ContactAdapter(List<ContactEntity> contactEntities, Context context) {
        this.contactEntities=contactEntities;
        this.context=context;
    }

    @Override
    public int getCount() {
        return this.contactEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contactEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Dibujar la celda
        LayoutInflater inflater=LayoutInflater.from(context);
        View container= inflater.inflate(R.layout.row_contact, null);
        ImageView imgContact= (ImageView)container.findViewById(R.id.iviContact);
        TextView tviName= (TextView)container.findViewById(R.id.tviName);

        //Extraer la entidad
        ContactEntity contactEntity= this.contactEntities.get(position);
        //Asociar la entidad con el XML
        tviName.setText(contactEntity.getName());
        imgContact.setImageResource(contactEntity.getPhoto());

        return container;
    }
}
