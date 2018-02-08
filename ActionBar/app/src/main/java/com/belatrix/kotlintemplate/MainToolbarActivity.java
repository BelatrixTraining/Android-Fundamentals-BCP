package com.belatrix.kotlintemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_toolbar);
        ui();
    }

    private void ui() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    // BEGIN_INCLUDE (handle_cancel)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.cancel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cancel:
                // "Cancel"
                finish();
                return true;
            case R.id.done:
                Log.v("CONSOLE","DONE");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // END_INCLUDE (handle_cancel)
}
