package com.belatrix.kotlintemplate;

/**
 * Created by emedinaa on 7/10/17.
 */

public interface MyFragmentCallback {

    //Escenario(1)
    void comunicarFragmentconActivity(String message);

    //Escenario(2)
    void comunicarActivityconFragment();
}
