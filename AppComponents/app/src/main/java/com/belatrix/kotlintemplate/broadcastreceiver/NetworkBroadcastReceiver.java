package com.belatrix.kotlintemplate.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by eduardomedina on 7/02/17.
 */

public class NetworkBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG ="NetworkBroadcast";
    private final String INTENT_NAME= "NETWORK.WIFI";

    private final int STATUS_ON=1;
    private final int STATUS_OFF=0;


    @Override
    public void onReceive(Context context, Intent intent) {

         Intent mIntent = new Intent(INTENT_NAME);

        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {

            NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                Log.v(TAG, "WIFI ON ");

                mIntent.putExtra("STATUS", STATUS_ON);
                context.sendBroadcast(mIntent);


            } else if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) {
                Log.v(TAG, "WIFI OFF ");

                mIntent.putExtra("STATUS", STATUS_OFF);
                context.sendBroadcast(mIntent);

            }
        }
    }
}
