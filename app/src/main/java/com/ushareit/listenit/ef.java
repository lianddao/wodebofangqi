package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

class ef {
    final IntentFilter f10920a;
    final BroadcastReceiver f10921b;
    boolean f10922c;

    ef(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f10920a = intentFilter;
        this.f10921b = broadcastReceiver;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.f10921b);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.f10920a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
