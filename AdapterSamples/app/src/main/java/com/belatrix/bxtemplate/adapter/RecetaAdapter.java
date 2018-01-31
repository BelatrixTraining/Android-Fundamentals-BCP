package com.belatrix.bxtemplate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.belatrix.bxtemplate.R;
import com.belatrix.bxtemplate.model.Receta;

import java.util.List;

/**
 * Created by emedinaa on 27/01/17.
 */

public class RecetaAdapter extends BaseAdapter {

    private List<Receta> recetas;
    private final  Context context;

    public RecetaAdapter(List<Receta> recetas, Context context) {
        this.recetas = recetas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return recetas.size();
    }

    @Override
    public Object getItem(int position) {
        return recetas.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        if(convertView==null){
            view= LayoutInflater.from(context).
                    inflate(R.layout.row_receta,viewGroup,false);
        }else{
            view= convertView;
        }

        TextView tviTitle= (TextView)
                view.findViewById(R.id.tviTitle);

        TextView tviDesc= (TextView)
                view.findViewById(R.id.tviDesc);

        View iviFavorite= view.findViewById(R.id.iviFavorite);

        //render asociar entidad con el row
        final Receta receta= recetas.get(position);
        if(receta!=null){
            tviTitle.setText(checkNotNull(receta.getTitle()));
            tviDesc.setText(checkNotNull(receta.getDesc()));
            if(receta.isFavorite()){
                iviFavorite.setVisibility(View.VISIBLE);
            }else{
                iviFavorite.setVisibility(View.GONE);
            }
        }
        return  view;
    }

    private String checkNotNull(String value){
        String string ;
        if(value==null || value.isEmpty()){
            string="";
        }else{
            string= value;
        }
        return  string;
    }
}
