package com.belatrix.bxtemplate;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class ItemsEventsActivity extends Activity {

    private final String ITEMEVENTLOG="CONSOLE";

    private Spinner spLocation;
    private String localidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_events);
        //ui();
        uiFlag();
    }

    private void ui() {
        spLocation =(Spinner)findViewById(R.id.spLocation);


        spLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("CONSOLE", "spLocation" + adapterView.getAdapter().getItem(i));
                localidad = adapterView.getAdapter().getItem(i).toString();
                Toast.makeText(ItemsEventsActivity.this,
                        "Item seleccionado "+localidad,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    /*
        Si se percatan, al arrancar esta vista y sin ejecutar ninguna acción, se lanza un mensaje donde indica que se selecciono el primer item.
        Para resolver esto vamos a usar un flag , de tal manera que por mas que se ejecute la primera vez el evento, no realice accion.
     */
    private void uiFlag() {
        spLocation =(Spinner)findViewById(R.id.spLocation);

        spLocation.setTag("empty");
        Log.v(ITEMEVENTLOG,"tag "+spLocation.getTag());

        spLocation.setTag(null);

        spLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spLocation.getTag()!=null){
                    selectedItem(adapterView.getAdapter().getItem(i),adapterView.getAdapter().getItem(i).toString());
                }else{
                    spLocation.setTag("empty");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }

    private void selectedItem(Object item, String itemValue){
        Log.v("CONSOLE", "spLocation" + item);
        localidad = itemValue;
        Toast.makeText(ItemsEventsActivity.this,
                "Item seleccionado "+localidad,Toast.LENGTH_SHORT).show();
    }

}
