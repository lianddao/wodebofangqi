package com.ushareit.listenit.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.cloudsync.CloudSyncService;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.eyw;
import com.ushareit.listenit.gef;
import com.ushareit.listenit.glb;
import com.ushareit.listenit.gul;
import com.ushareit.listenit.gvj;

public class CommonReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        exw.m18443a("CommonReceiver", "network availablity changed event received");
        int a = glb.m22327a(context);
        int c = glb.m22330c(context);
        if (m26038a(context) && gef.m21805a().m21835e() && c != 0) {
            CloudSyncService.m11594b(c);
            glb.m22328a(context, a);
        }
        Pair a2 = eyw.m18568a(context);
        if (((Boolean) a2.first).booleanValue() || ((Boolean) a2.second).booleanValue()) {
            if (System.currentTimeMillis() - gvj.m22937e(context) < 300000) {
                exw.m18445a("CommonReceiver", "ignore too frequently network available event: %d ms", Long.valueOf(System.currentTimeMillis() - gvj.m22937e(context)));
                return;
            }
            try {
                gvj.m22921c(context, System.currentTimeMillis());
                Intent intent2 = new Intent(context, CommonService.class);
                intent2.putExtra("StartType", gul.ConnChange.m22821a());
                context.startService(intent2);
                return;
            } catch (Exception e) {
                return;
            }
        }
        exw.m18443a("CommonReceiver", "Has no network connection");
    }

    private boolean m26038a(Context context) {
        try {
            if (((ListenItApp) context.getApplicationContext()).m4930a() != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
