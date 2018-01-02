package com.songbirdnest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;

public class PackageReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, SongbirdMedia.class);
        Bundle extras = intent.getExtras();
        Log.i(getClass().getSimpleName(), "Got Intent: " + intent.getAction());
        if (extras != null) {
            i.putExtra("action", intent.getAction());
            i.putExtra(SongbirdMedia.PASS_PACKAGE, intent.getDataString());
            context.startService(i);
        }
    }
}
