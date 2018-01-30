package com.belatrix.kotlintemplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.belatrix.kotlintemplate.adapter.MySimpleListAdapter;
import com.belatrix.kotlintemplate.storage.Cheeses;
import com.belatrix.kotlintemplate.storage.Shakespeare;


public class SimpleListActivity extends Activity {


    /*
        1. Proveedor de datos List, ArrayList
        2. Contenedor , ListView, GridView, RecyclerView
        3. Entidad, modelo
        4. Celda , xml
        5. Adapter
        6. Setear adapter al View

     */
    private String[] mStrings = Cheeses.sCheeseStrings;
    private String[] mTitles= Shakespeare.TITLES;
    private String[] mDialogs= Shakespeare.DIALOGUE;
    private String[] mDays = {"Lunes", "Martes","Miercoles","Jueves","Viernes",
            "Sábado", "Domingo"};

    private ListView lviCheeses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        lviCheeses=(ListView)findViewById(R.id.lviCheeses);

        /*lviCheeses.setAdapter(new ArrayAdapter<String>(this,
                R.layout.my_row, mStrings));*/

        MySimpleListAdapter mySimpleListAdapter= new MySimpleListAdapter(this,
                mStrings);

        lviCheeses.setAdapter(mySimpleListAdapter);
        lviCheeses.setTextFilterEnabled(true);

        //events
        lviCheeses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value= String.valueOf(adapterView.getAdapter().getItem(position))+
                        " " +String.valueOf(position);
                showItem(value);
            }
        });
    }

    private void showItem(String value) {

        Toast.makeText(this,"item "+value,Toast.LENGTH_SHORT).show();
    }

}
