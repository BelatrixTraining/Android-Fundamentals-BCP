package com.belatrix.bxtemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.belatrix.bxtemplate.adapter.RecetaAdapter;
import com.belatrix.bxtemplate.model.Receta;
import com.belatrix.bxtemplate.storage.RecetaRepo;

import java.util.List;

public class RecetaActivity extends AppCompatActivity {

    private ListView lviReceta;
    private List<Receta> recetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);
        ui();
        getRecetas();
    }

    private void getRecetas() {
        //origen de datos
        RecetaRepo recetaRepo= new RecetaRepo();
        recetas= recetaRepo.getRecetas();

        //adapter
        RecetaAdapter recetaAdapter= new RecetaAdapter(recetas,this);

        //setAdapter al view
        lviReceta.setAdapter(recetaAdapter);

    }

    private void ui() {
        lviReceta= (ListView) findViewById(R.id.lviReceta);
        //events
        lviReceta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long l) {
                Receta receta= recetas.get(position);
                if(receta!=null){
                    gotoRecetaDetalle(receta);
                }
            }
        });
    }

    private void gotoRecetaDetalle(Receta receta) {
        Intent intent= new Intent(this,RecetaDetalleActivity.class);
        Bundle bundle= new Bundle();
        //bundle.putInt("ID",receta.getId());
        //bundle.putString("TITLE",receta.getTitle());
        bundle.putSerializable("RECETA",receta);
        intent.putExtras(bundle);
        //startActivity(intent);

        Log.v("CONSOLE","receta "+receta );
        Toast.makeText(this, "receta "+receta,
                Toast.LENGTH_SHORT).show();
    }
}
