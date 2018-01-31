package com.belatrix.bxtemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
    }


    private void ui() {
        findViewById(R.id.btnSimpleList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSimpleList();
            }
        });

        findViewById(R.id.btnSimpleGrid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSimpleGrid();
            }
        });

        findViewById(R.id.btnCustomList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoCustomList();
            }
        });


        findViewById(R.id.btnRecycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRecycler();
            }
        });

        findViewById(R.id.btnMoviegrid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoMoviewGrid();
            }
        });

        findViewById(R.id.btnRecyclerEvents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRecyclerEvents();
            }
        });

        findViewById(R.id.btnRecyclerTypes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRecyclerTypes();
            }
        });

        findViewById(R.id.btnDynamicContent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDynamicContent();
            }
        });
    }

    private void goToDynamicContent() {
        startActivity(new Intent(this,DynamicContentActivity.class));
    }

    private void gotoRecyclerTypes() {
        startActivity(new Intent(this,RecyclerMultipleActivity.class));
    }

    private void gotoRecyclerEvents() {
        startActivity(new Intent(this,RecyclerEventsActivity.class));
    }

    private void gotoRecycler() {
        startActivity(new Intent(this,RecyclerActivity.class));
    }

    private void gotoMoviewGrid() {
        startActivity(new Intent(this,MovieGridActivity.class));
    }

    private void gotoSimpleList() {
        startActivity(new Intent(this,SimpleListActivity.class));
    }

    private void gotoSimpleGrid() {
        startActivity(new Intent(this,SimpleGridActivity.class));
    }

    private void gotoCustomList() {
        startActivity(new Intent(this,CustomListActivity.class));
    }


    //Referencia
    //https://github.com/chiuki/android-recyclerview
}
