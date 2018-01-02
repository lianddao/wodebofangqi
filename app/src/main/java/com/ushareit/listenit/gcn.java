package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;
import java.util.Calendar;

public class gcn extends BroadcastReceiver {
    final /* synthetic */ MusicLockScreenView f13919a;

    public gcn(MusicLockScreenView musicLockScreenView) {
        this.f13919a = musicLockScreenView;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f13919a.f15682x && intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
            this.f13919a.f15679u = Calendar.getInstance();
        }
        this.f13919a.m24510f();
    }
}
