package com.belatrix.kotlintemplate;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.belatrix.kotlintemplate.services.SoundService;

public class MainServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlayer;
    private boolean state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);
        ui();
    }

    private void ui() {
        btnPlayer=(Button)findViewById(R.id.btnPlayer);
        btnPlayer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPlayer:
                if(state){
                    stopSoundService();
                }else{
                    startSoundService();
                }
                updateUI();
                state= !state;
                break;
        }
    }

    private void updateUI() {
        if(state){
            btnPlayer.setText("PLAY");
        }else{
            btnPlayer.setText("STOP");
        }
    }

    private void startSoundService(){
        Intent intent = new Intent(this, SoundService.class);
        startService(intent);
    }


    private void stopSoundService(){
        Intent intent = new Intent(this, SoundService.class);
        stopService(intent);
    }
}
