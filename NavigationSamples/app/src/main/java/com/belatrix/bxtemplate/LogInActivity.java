package com.belatrix.bxtemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends AppCompatActivity {

    private View btnNext,llaySignUp;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        extras();
        ui();
    }

    private void extras(){
        if(getIntent()!=null && getIntent().getExtras()!=null){
            Bundle bundle= getIntent().getExtras();
            userId= bundle.getString("USERID",null);
        }
    }
    private void ui() {
        btnNext= findViewById(R.id.btnNext);
        llaySignUp= findViewById(R.id.llaySignUp);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMain();
            }
        });

        llaySignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSignUp();
            }
        });
    }

    private void gotoMain() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void gotoSignUp() {
        Intent intent= new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}
