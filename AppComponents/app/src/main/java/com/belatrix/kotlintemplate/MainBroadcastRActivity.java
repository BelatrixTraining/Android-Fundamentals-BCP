package com.belatrix.kotlintemplate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainBroadcastRActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final String INTENT_NAME= "NETWORK.WIFI";
    private final int STATUS_ON=1;
    private final int STATUS_OFF=0;

    private BroadcastReceiver mIntentReceiver;
    private View vStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broadcast_r);

        ui();

        mIntentReceiver= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int status  = intent.getIntExtra("STATUS",-1);
                Log.v(TAG, "status "+status);

                if(status==STATUS_ON){
                    wifiOn();
                }else if(status== STATUS_OFF){
                    wifiOff();
                }

            }
        };

        IntentFilter intentFilter = new IntentFilter(INTENT_NAME);
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        registerReceiver(mIntentReceiver,intentFilter);
    }

    public void wifiOn() {
        vStatus.setBackgroundColor(Color.parseColor("#C0CA33"));
    }


    public void wifiOff() {
        vStatus.setBackgroundColor(Color.parseColor("#FF1744"));
    }

    private void ui() {
        vStatus= findViewById(R.id.vStatus);
    }
}
