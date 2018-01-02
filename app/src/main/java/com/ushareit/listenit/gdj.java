package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ushareit.listenit.lockscreen.view.ScreenTimeView;

public class gdj extends BroadcastReceiver {
    final /* synthetic */ ScreenTimeView f13955a;

    public gdj(ScreenTimeView screenTimeView) {
        this.f13955a = screenTimeView;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.TIME_TICK".equals(intent.getAction())) {
            this.f13955a.m24578d();
        }
    }
}
