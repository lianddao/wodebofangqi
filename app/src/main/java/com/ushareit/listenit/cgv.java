package com.ushareit.listenit;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;

public abstract class cgv implements OnClickListener {
    public static cgv m11198a(Activity activity, Intent intent, int i) {
        return new cgw(intent, activity, i);
    }

    public static cgv m11199a(ah ahVar, Intent intent, int i) {
        return new cgx(intent, ahVar, i);
    }

    public static cgv m11200a(doe com_ushareit_listenit_doe, Intent intent, int i) {
        return new cgy(intent, com_ushareit_listenit_doe, i);
    }

    public abstract void mo1316a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo1316a();
            dialogInterface.dismiss();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services", e);
        }
    }
}
