package com.belatrix.bxtemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.belatrix.bxtemplate.adapter.MultipleRecyclerAdapter;
import com.belatrix.bxtemplate.model.TypeEntity;
import com.belatrix.bxtemplate.storage.Multiple;

import java.util.List;

public class RecyclerMultipleActivity extends AppCompatActivity {


    private RecyclerView rviewMultiple;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_multiple);
        ui();
        getObjects();
    }

    private void getObjects() {

        Multiple multipleRepo= new Multiple();
        List<TypeEntity> objects= multipleRepo.getObjects();

        // specify an adapter (see also next example)
        adapter = new MultipleRecyclerAdapter(objects);
        rviewMultiple.setAdapter(adapter);

    }

    private void ui() {
        rviewMultiple= (RecyclerView) findViewById(R.id.rviewMultiple);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rviewMultiple.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);

        // use a grid layout manager
        //mLayoutManager = new GridLayoutManager(this,2);

        rviewMultiple.setLayoutManager(mLayoutManager);
    }
}
