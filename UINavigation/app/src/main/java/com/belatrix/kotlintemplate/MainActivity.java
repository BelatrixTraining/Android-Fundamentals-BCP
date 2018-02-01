package com.belatrix.kotlintemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View cardvSwipeTabs;
    private View cardvNavDrawer;
    private View cardvVpager;
    private View cardBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardvSwipeTabs= findViewById(R.id.cardvSwipeTabs);
        cardvNavDrawer= findViewById(R.id.cardvNavDrawer);
        cardvVpager= findViewById(R.id.cardvVpager);
        cardBottomNav= findViewById(R.id.cardBottomNav);

        cardvSwipeTabs.setOnClickListener(this);
        cardvNavDrawer.setOnClickListener(this);
        cardvVpager.setOnClickListener(this);
        cardBottomNav.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cardvSwipeTabs:
                    gotoSwipeTabs();
                break;
            case R.id.cardvNavDrawer:
                    gotoNavDrawer();
                break;
            case R.id.cardvVpager:
                    gotoVPagerScreenSlides();
                break;
            case R.id.cardBottomNav:
                    goToCardBottomNav();
                break;
        }
    }

    private void gotoSwipeTabs() {
        startActivity(new Intent(this,SwipeTabsActivity.class));
    }

    private void gotoNavDrawer() {
        startActivity(new Intent(this,NavigationDrawerActivity.class));
    }

    private void gotoVPagerScreenSlides() {
        startActivity(new Intent(this,VPagerScreenSlidesActivity.class));
    }

    private void goToCardBottomNav() {
        startActivity(new Intent(this,BottomNavigationActivity.class));
    }
}
