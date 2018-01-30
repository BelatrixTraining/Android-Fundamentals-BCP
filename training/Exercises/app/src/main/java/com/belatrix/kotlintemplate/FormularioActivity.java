package com.belatrix.kotlintemplate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by emedinaa on 25/01/18.
 */

public class FormularioActivity extends Activity {

    /*
      Pasos

      1. Declarar variables con los elementos de la UI
      2. Inicializar variables
      3. Declarar eventos
      4. Capturar los datos de entrada del usuario
      5. Crear metodos con las operaciones
      6. Mostrar resultados
   */

    private EditText eteName, eteEmail, etePassword1, etePassword2;
    private Button butSignUp;


    private String name, email, password1,password2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ui();
    }

    private void ui() {
        eteName= (EditText) findViewById(R.id.eteName);
        eteEmail= (EditText) findViewById(R.id.eteEmail);
        etePassword1= (EditText) findViewById(R.id.etePassword1);
        etePassword2= (EditText) findViewById(R.id.etePassword2);
        butSignUp= (Button) findViewById(R.id.butSignUp);

        //eventos
        butSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateForm()){
                    //enviar al servidor
                    sendServer();
                }else{
                    showErrorMessage();
                }
            }
        });
    }

    private boolean validateForm(){

        eteName.setError(null);

        //name= Integer.parseInt(eteName.getText().toString().trim());
        name= eteName.getText().toString().trim();
        email= eteEmail.getText().toString().trim();
        password1= etePassword1.getText().toString().trim();
        password2= etePassword2.getText().toString().trim();

        if(name==null || name.isEmpty())
        {
            eteName.setError("Campo inválido");
            return false;
        }
        if(email==null || email.isEmpty())
        {
            return false;
        }

        if(password1==null || password1.isEmpty())
        {
            return false;
        }

        if(password2==null || password2.isEmpty())
        {
            return false;
        }

        /*if(!isEmail(email)){
           return false;
        }*/

        if(!password1.equals(password2)){
            return false;
        }
        return true;
    }

    private void  sendServer(){
        Toast.makeText(this,"Enviando al server",
                Toast.LENGTH_LONG).show();
    }

    private void  showErrorMessage(){
        Toast.makeText(this,"Validar campos",
                Toast.LENGTH_LONG).show();
    }
}
