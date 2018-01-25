package com.belatrix.kotlintemplate.ui.events;

import android.view.View;

/**
 * Created by emedinaa on 14/08/17.
 */

public interface ClickListener{
    public void onClick(View view, int position);
    public void onLongClick(View view, int position);
}