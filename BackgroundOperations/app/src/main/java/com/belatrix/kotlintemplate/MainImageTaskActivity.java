package com.belatrix.kotlintemplate;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.belatrix.kotlintemplate.asynctask.ImageTask;

import java.net.URL;

public class MainImageTaskActivity extends AppCompatActivity {

    private ImageView iviLogo;
    private ImageTask imageTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_image_task);
        iviLogo= (ImageView)findViewById(R.id.iviLogo);

        downloadImage();
    }

    private void downloadImage() {
        /*"https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg",
                "https://lh4.googleusercontent.com/--dq8niRp7W4/URquVgmXvgI/AAAAAAAAAbs/-gnuLQfNnBA/s1024/A%252520Song%252520of%252520Ice%252520and%252520Fire.jpg",
                "https://lh5.googleusercontent.com/-7qZeDtRKFKc/URquWZT1gOI/AAAAAAAAAbs/hqWgteyNXsg/s1024/Another%252520Rockaway%252520Sunset.jpg",
                "https://lh3.googleusercontent.com/--L0Km39l5J8/URquXHGcdNI/AAAAAAAAAbs/3ZrSJNrSomQ/s1024/Antelope%252520Butte.jpg",
                "https://lh6.googleusercontent.com/-8HO-4vIFnlw/URquZnsFgtI/AAAAAAAAAbs/WT8jViTF7vw/s1024/Antelope%252520Hallway.jpg",
                "https://lh4.googleusercontent.com/-WIuWgVcU3Qw/URqubRVcj4I/AAAAAAAAAbs/YvbwgGjwdIQ/s1024/Antelope%252520Walls.jpg"*/
        try{
            URL url = new URL("https://lh6.googleusercontent.com/-8HO-4vIFnlw/URquZnsFgtI/AAAAAAAAAbs/WT8jViTF7vw/s1024/Antelope%252520Hallway.jpg");
            imageTask = new ImageTask(this, iviLogo);
            imageTask.execute(url);
        }catch (Exception e){
            Log.v("Error",e.toString());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(imageTask !=null && imageTask.getStatus()!= AsyncTask.Status.FINISHED){
            imageTask.cancel(true);
        }
    }
}
