package com.belatrix.kotlintemplate.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.belatrix.kotlintemplate.R;


/**
 * Created by eduardomedina on 8/02/17.
 */

public class SoundService extends Service {
//public class SoundService extends IntentService {

    private MediaPlayer mediaPlayer;

    public SoundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer= MediaPlayer.create(this, R.raw.shrek_song);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
