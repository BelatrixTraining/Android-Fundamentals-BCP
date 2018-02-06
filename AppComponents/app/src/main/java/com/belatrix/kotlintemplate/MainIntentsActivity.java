package com.belatrix.kotlintemplate;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainIntentsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intents);
        ui();
    }

    private void ui() {
        findViewById(R.id.btnBrowser).setOnClickListener(this);
        findViewById(R.id.btnCamera).setOnClickListener(this);
        findViewById(R.id.btnGMaps).setOnClickListener(this);
        findViewById(R.id.btnPhone).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void callPhone(String phone){
        try{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+phone));
            startActivity(intent);
        }catch (ActivityNotFoundException e){}
    }

    private void gotoGMaps() {

        String lat= "-12.0696138";
        String lng= "-76.9386441";
        String name= "BCP Sede Central";

        String uri = "geo:" + lat + ","
                +lng + "?q=" + Uri.encode(name);


        startActivity(new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(uri)));
    }

    private void startCamera(){
        try {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void gotoBrowser(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.pe/"));
        startActivity(browserIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBrowser:
                gotoBrowser();
                break;

            case R.id.btnPhone:
                callPhone("014469667");
                break;

            case R.id.btnCamera:
                startCamera();
                break;

            case R.id.btnGMaps:
                gotoGMaps();
                break;
        }
    }
}
