package com.miui.player.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.miui.player.service.SleepModeManager;
import com.miui.player.util.Actions;

public class DeleteQuitTimerReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && Actions.ACTION_MUSIC_QUIT.equals(action)) {
            SleepModeManager.deleteTimer(context);
        }
    }
}
