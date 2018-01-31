package com.belatrix.bxtemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by emedinaa on 15/02/17.
 */

public class BaseActivity extends AppCompatActivity {

    protected void next(Class<?> activityClass, Bundle bundle, boolean destroy){
        Intent intent= new Intent(this, activityClass);
        if(bundle!=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
