package com.belatrix.kotlintemplate;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.belatrix.kotlintemplate.ui.OnTabListener;
import com.belatrix.kotlintemplate.ui.fragments.ATabFragment;
import com.belatrix.kotlintemplate.ui.fragments.BTabFragment;
import com.belatrix.kotlintemplate.ui.fragments.CTabFragment;

public class BottomNavigationActivity extends AppCompatActivity implements OnTabListener{

    private FragmentTransaction fragmentTransaction;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment= null;
                int tab=0;
                switch (item.getItemId()){
                    case R.id.action_favorites:
                        tab=0;
                        fragment= ATabFragment.newInstance(null,null);
                        break;
                    case R.id.action_schedules:
                        fragment= BTabFragment.newInstance(null,null);
                        tab=1;
                        break;
                    case R.id.action_music:
                        fragment= CTabFragment.newInstance(null,null);
                        tab=2;
                        break;
                }

                if(fragment!=null){
                    changeFragment(fragment);
                }
                return true;
            }
        });

        changeFragment(ATabFragment.newInstance(null,null));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
       super.onBackPressed();
    }

    private void changeFragment(Fragment fragment){
        fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment,null);
        fragmentTransaction.commit();
    }
}

