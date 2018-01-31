package com.belatrix.bxtemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    private View btnNext;
    private View iviBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ui();
    }

    private void ui() {
        btnNext= findViewById(R.id.btnNext);
        iviBack= findViewById(R.id.iviBack);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMain();
            }
        });

        iviBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoLogIn();
            }
        });
    }

    private void gotoMain() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void gotoLogIn() {
        //Intent intent= new Intent(this,LogInActivity.class);
        //startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //gotoLogIn();
    }
}
