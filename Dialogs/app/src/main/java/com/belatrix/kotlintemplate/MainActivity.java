package com.belatrix.kotlintemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.belatrix.kotlintemplate.fragments.CustomDialogFragment;
import com.belatrix.kotlintemplate.fragments.CustomDialogListener;
import com.belatrix.kotlintemplate.fragments.MultichoiceDialog;
import com.belatrix.kotlintemplate.fragments.SelectionDialog;
import com.belatrix.kotlintemplate.fragments.SimpleDialog;
import com.belatrix.kotlintemplate.fragments.TransparentDialogFragment;


public class MainActivity extends AppCompatActivity  implements CustomDialogListener {

    private Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();

    }

    private void ui() {

        btnDialog= (Button) findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showSimpleDialog();

                //showSelectionDialog();
                //showMultichoiceDialog();
                //showCustomDialog();
                showTransparentDialog();
            }
        });
    }

    private void showMultichoiceDialog() {
        MultichoiceDialog dialog = new MultichoiceDialog();
        dialog.show(getSupportFragmentManager(), "MultichoiceDialog");
    }

    private void showSelectionDialog() {
        SelectionDialog dialog = new SelectionDialog();
        dialog.show(getSupportFragmentManager(), "SelectionDialog");
    }

    private void showSimpleDialog() {
        SimpleDialog dialog = new SimpleDialog();
        dialog.show(getSupportFragmentManager(), "SimpleDialog");
    }

    private void showCustomDialog() {
        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.show(getSupportFragmentManager(), "CustomDialogFragment");
    }

    private void showTransparentDialog() {
        TransparentDialogFragment dialog = new TransparentDialogFragment();
        dialog.show(getSupportFragmentManager(), "TransparentDialogFragment");
    }


    /**
     * COMUNICACION ENTRE EL DIALOGO CON LA ACTIVIDAD
     * @param object
     */
    @Override
    public void onAction(Object object) {

    }

    @Override
    public void onDialogPositive(Object object) {
        Toast.makeText(this,"Custom Dialog "+  getString(R.string.signin)+" "+object.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogNegative(Object object) {
        Toast.makeText(this,"Custom Dialog "+getString(R.string.cancel),Toast.LENGTH_SHORT).show();
    }
}
