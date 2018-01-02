package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class eei extends BroadcastReceiver {
    final /* synthetic */ int f10871a;
    final /* synthetic */ FirebaseInstanceIdService f10872b;

    public eei(FirebaseInstanceIdService firebaseInstanceIdService, int i) {
        this.f10872b = firebaseInstanceIdService;
        this.f10871a = i;
    }

    public void onReceive(Context context, Intent intent) {
        if (FirebaseInstanceIdService.m2590c(context)) {
            if (this.f10872b.f2031f) {
                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
            }
            this.f10872b.getApplicationContext().unregisterReceiver(this);
            context.sendBroadcast(FirebaseInstanceIdService.m2589c(this.f10871a));
        }
    }
}
