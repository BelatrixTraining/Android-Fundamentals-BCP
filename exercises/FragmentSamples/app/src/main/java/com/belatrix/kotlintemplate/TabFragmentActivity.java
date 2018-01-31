package com.belatrix.kotlintemplate;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.belatrix.kotlintemplate.fragments.ShoppingFragment;
import com.belatrix.kotlintemplate.fragments.VideosFragment;
import com.belatrix.kotlintemplate.fragments.WebFragment;
import com.belatrix.kotlintemplate.listeners.OnTabNavListener;

import java.util.ArrayList;
import java.util.List;

public class TabFragmentActivity extends AppCompatActivity implements OnTabNavListener, View.OnClickListener {

    private final int FRAGMENT_WEB=0;
    private final int FRAGMENT_SHOPPING=1;
    private final int FRAGMENT_VIDEOS=2;

    private TextView tviWeb,tviShopping,tviVideos;
    private List<View> indicatorViews;
    private List<TextView> titleViews;
    private int currentIndicator=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fragment);
        getSupportActionBar().hide();
        ui();

        selectFirst();
    }

    private void selectFirst() {
        Bundle bundle= new Bundle();
        int fragmentId=FRAGMENT_WEB;
        updateUI(fragmentId);
        changeFragment(bundle,fragmentId);
    }

    private void updateUI(int fragmentId) {
        if(currentIndicator>=0){
            indicatorViews.get(currentIndicator).setBackgroundColor(Color.TRANSPARENT);
            titleViews.get(currentIndicator).setInputType(Typeface.NORMAL);
        }
        indicatorViews.get(fragmentId).setBackgroundColor(Color.parseColor("#ffeb3b"));
        titleViews.get(fragmentId).setInputType(Typeface.BOLD);
        currentIndicator= fragmentId;
    }

    private void ui() {
        indicatorViews= new ArrayList<>();
        indicatorViews.add(findViewById(R.id.iviWeb));
        indicatorViews.add(findViewById(R.id.iviShopping));
        indicatorViews.add(findViewById(R.id.iviVideos));

        titleViews= new ArrayList<>();
        titleViews.add((TextView) findViewById(R.id.tviWeb));
        titleViews.add((TextView)findViewById(R.id.tviShopping));
        titleViews.add((TextView)findViewById(R.id.tviVideos));
        //events

        for (TextView textView:titleViews) {
            textView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Bundle bundle= new Bundle();
        int fragmentId=FRAGMENT_WEB;

        switch (view.getId()){
            case R.id.tviWeb:
                fragmentId=FRAGMENT_WEB;
                break;

            case R.id.tviShopping:
                fragmentId=FRAGMENT_SHOPPING;
                break;

            case R.id.tviVideos:
                fragmentId=FRAGMENT_VIDEOS;
                break;
        }

        updateUI(fragmentId);
        changeFragment(bundle,fragmentId);
    }

    private void changeFragment(Bundle bundle, int fragmentId) {

        Fragment fragment= factoryFragment(bundle,fragmentId);
        //fragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flayContainer, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    private Fragment factoryFragment(Bundle bundle,int fragmentId) {
        switch (fragmentId){
            case FRAGMENT_WEB:
                return WebFragment.newInstance(bundle);
            case FRAGMENT_SHOPPING:
                return ShoppingFragment.newInstance(bundle);
            case FRAGMENT_VIDEOS:
                return VideosFragment.newInstance(bundle);
        }
        return null;
    }


}
