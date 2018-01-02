package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class gch extends BroadcastReceiver {
    private gum f13913a;

    public gch(gum com_ushareit_listenit_gum) {
        this.f13913a = com_ushareit_listenit_gum;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                if (gvk.m23057e() && gcy.m21713a().m21721b()) {
                    if (!gcd.m21661a().m21678d()) {
                        gcd.m21661a().m21680f();
                    }
                    gyj.m23146a(context, 2);
                } else if (this.f13913a == null || !this.f13913a.mo2425a()) {
                    gcd.m21661a().m21679e();
                } else if (gvj.m22953f()) {
                    gcd.m21661a().m21679e();
                } else {
                    if (!gcd.m21661a().m21678d()) {
                        gcd.m21661a().m21680f();
                    }
                    gyj.m23146a(context, 1);
                }
                gcd.m21661a().m21676c(false);
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                gcd.m21661a().m21676c(true);
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {
                gcy.m21713a().m21720a(false);
            } else if ("android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                gcy.m21713a().m21720a(true);
                if (gvk.m23057e()) {
                    gyj.m23146a(context, 2);
                }
            } else if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                gcy.m21713a().m21718a(intent, context);
            }
        }
    }
}
