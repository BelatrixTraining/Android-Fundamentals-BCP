package com.belatrix.kotlintemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by eduardomedina on 31/01/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected void next(Class<?> activityClass, Bundle bundle, boolean destroy){
        Intent intent= new Intent(this, activityClass);
        if(bundle!=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
