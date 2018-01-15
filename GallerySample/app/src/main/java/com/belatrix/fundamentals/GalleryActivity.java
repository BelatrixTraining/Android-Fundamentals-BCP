package com.belatrix.fundamentals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {

    private ImageView img;
    private Button btnImg;
    private TextView txtImg;

    private int count;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ui();
        init();
    }

    private void init(){

        images= new int[]{
                R.drawable.sample_0,
                R.drawable.sample_1,
                R.drawable.sample_2,
                R.drawable.sample_3,
                R.drawable.sample_4,
                R.drawable.sample_5,
                R.drawable.sample_6,
                R.drawable.sample_7};

        img.setImageResource(images[0]);
        count=0;
        txtImg.setText("Imagen " + count);

        //Events
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count++;
                if (count >= images.length) {
                    count = 0;
                }
                img.setImageResource(images[count]);
                txtImg.setText("Imagen " + count);
                Log.v("CONSOLE", " count " + count);

                //count--;
            }
        });
    }

    /**
     * Declarar los elementos de la UI
     */
    private void ui() {
        img= (ImageView) findViewById(R.id.img);
        btnImg= (Button)findViewById(R.id.button);
        txtImg = (TextView)findViewById(R.id.txtImg);
    }

    /**
     * Evento de click desde la UI
     */
    public void  click_handler(View v)
    {
        //Log.v("CONSOLE", "Hello Bx !");

         /*
        Toast.makeText(this, "Hello Bx !", Toast.LENGTH_LONG).show();
         */

        count++;
        //count--;
        int imageId= 0;

        if(count<images.length){

           imageId= images[count];
           img.setImageResource(imageId);
           if(count==images.length-1){
               count=0;
           }
        }

        Log.v("CONSOLE", "imageId "+imageId);
    }

}
