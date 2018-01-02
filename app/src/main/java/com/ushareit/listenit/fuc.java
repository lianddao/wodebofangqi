package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fuc extends BroadcastReceiver {
    final /* synthetic */ EqualizerActivity f13511a;

    public fuc(EqualizerActivity equalizerActivity) {
        this.f13511a = equalizerActivity;
    }

    public void onReceive(Context context, Intent intent) {
        this.f13511a.m17526s();
    }
}
