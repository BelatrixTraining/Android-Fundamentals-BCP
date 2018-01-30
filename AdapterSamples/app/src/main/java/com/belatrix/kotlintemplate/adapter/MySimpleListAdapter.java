package com.belatrix.kotlintemplate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.belatrix.kotlintemplate.R;

/**
 * Created by emedinaa on 25/01/18.
 */

public class MySimpleListAdapter extends BaseAdapter {

    private String[] data;
    private final Context context;

    public MySimpleListAdapter( Context context,String[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /*
      View view;
        if (convertView == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.row_speech,parent,false);
        } else {
            view = convertView;
        }
        TextView  tviTitle=(TextView)view.findViewById(R.id.tviTitle);
        tviTitle.setText(data[position]);
        return view;
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView;

        if(convertView==null){
            myView=LayoutInflater.from(this.context).
                    inflate(R.layout.row_speech,parent,false);
        }else{
            myView=convertView;
        }

        TextView textView= (TextView) convertView.findViewById(R.id.tviTitle);

        String item= data[position];
        textView.setText(item);

        /*if(model.isFavorite()){

        }else{
          //reseteando
        }*/

        return myView;
    }
}
