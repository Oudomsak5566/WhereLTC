package com.example.hp.whereltc;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by HP on 14/12/2016.
 */

public class MyAlert {

    //Explicit
    private Context context;
    private String titleString, messageString;
    private int adAnInt;

    public MyAlert(Context context, String titleString, String messageString, int adAnInt) {
        this.context = context;
        this.titleString = titleString;
        this.messageString = messageString;
        this.adAnInt = adAnInt;

    }

    public void myDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(adAnInt);
        builder.setTitle(titleString);
        builder.setMessage(messageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();

    }
}
