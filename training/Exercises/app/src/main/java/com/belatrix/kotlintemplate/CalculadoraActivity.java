package com.belatrix.kotlintemplate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by emedinaa on 25/01/18.
 */

public class CalculadoraActivity extends Activity {

    /*
        Pasos

        1. Declarar variables con los elementos de la UI
        2. Inicializar variables
        3. Declarar eventos
        4. Capturar los datos de entrada del usuario
        5. Crear metodos con las operaciones
        6. Mostrar resultados
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
    }
}
