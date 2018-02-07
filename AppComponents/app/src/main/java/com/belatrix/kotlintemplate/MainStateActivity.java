package com.belatrix.kotlintemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainStateActivity extends AppCompatActivity {

    private static final String TAG ="MainRotation" ;

    private final String KEY_BUTTON_VALUE= "BTNVALUE";
    private final String KEY_TXT_VALUE= "TXTVALUE";

    private EditText eteEmail;
    private Button btnLogIn;
    private TextView tviMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_state);
        Log.v(TAG, "onCreate()");
        ui();
        app();
    }

    private void app() {
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValues();
            }
        });
    }

    private void setValues() {

        btnLogIn.setText("Estado del boton");
        tviMessage.setText("Estado del textview");
    }

    private void ui() {
        eteEmail= (EditText) findViewById(R.id.eteEmail);
        btnLogIn= (Button) findViewById(R.id.btnLogIn);
        tviMessage= (TextView) findViewById(R.id.tviMessage);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v(TAG, "onDestroy()");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(TAG, "onSaveInstanceState()");

        outState.putString(KEY_BUTTON_VALUE,btnLogIn.getText().toString());
        outState.putString(KEY_TXT_VALUE,tviMessage.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.v(TAG, "onRestoreInstanceState()");
        if(savedInstanceState!=null){
            String btnValue= savedInstanceState.getString(KEY_BUTTON_VALUE);
            String txtValue= savedInstanceState.getString(KEY_TXT_VALUE);

            //ui
            tviMessage.setText(txtValue);
            btnLogIn.setText(btnValue);
        }

    }
}
