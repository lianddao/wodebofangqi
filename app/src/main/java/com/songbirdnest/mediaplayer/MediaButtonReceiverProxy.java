package com.songbirdnest.mediaplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;

public class MediaButtonReceiverProxy extends BroadcastReceiver {
    public void onReceive(Context pContext, Intent pIntent) {
        if (pIntent.getAction().equals("android.intent.action.MEDIA_BUTTON") && pContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getBoolean(PrefKeys.DEFAULT_MEDIA_BUTTON_RECEIVER, true)) {
            Intent aIntent = new Intent(pContext, SongbirdMedia.class);
            aIntent.putExtra(SongbirdMedia.INTENT_KEY, pIntent);
            pContext.startService(aIntent);
            abortBroadcast();
        }
    }
}
