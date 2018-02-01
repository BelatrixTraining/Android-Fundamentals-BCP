package com.belatrix.kotlintemplate.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.belatrix.kotlintemplate.R;

/**
 * Created by eduardomedina on 31/01/18.
 */

public class SelectionDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pick_color)
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        log("item "+which);
                    }
                });
        return builder.create();
    }

    private void log(String message){
        Log.d("CONSOLE",message);
    }
}
