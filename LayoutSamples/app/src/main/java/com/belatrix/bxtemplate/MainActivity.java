package com.belatrix.bxtemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setear el XML (vista)
        setContentView(R.layout.layout_relative_example);
        //setContentView(R.layout.layout_example2);
        //setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_linear);
        //setContentView(R.layout.layout_constraint_sample1);
        //setContentView(R.layout.layout_constraint_sample2);
        //setContentView(R.layout.layout_constraint_sample3);

        //app();
    }

    private void app(){

        //declarar los elementos de ui
        textView= (TextView) findViewById(R.id.textView);

        //acciones
        textView.setText("Hola Belatrix");

        //eventos
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
