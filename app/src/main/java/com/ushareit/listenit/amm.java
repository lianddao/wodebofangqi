package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.C0016g;

public class amm extends BroadcastReceiver {
    private String f4864a;
    private Context f4865b;
    private aky f4866c;
    private akx f4867d;

    public amm(Context context, String str, akx com_ushareit_listenit_akx, aky com_ushareit_listenit_aky) {
        this.f4865b = context;
        this.f4864a = str;
        this.f4866c = com_ushareit_listenit_aky;
        this.f4867d = com_ushareit_listenit_akx;
    }

    public void m6320a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.f4864a);
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f4864a);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.f4864a);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.f4864a);
        intentFilter.addAction("com.facebook.ads.interstitial.error:" + this.f4864a);
        ec.m16689a(this.f4865b).m16693a(this, intentFilter);
    }

    public void m6321b() {
        try {
            ec.m16689a(this.f4865b).m16692a((BroadcastReceiver) this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        Object obj = intent.getAction().split(":")[0];
        if (this.f4866c != null && obj != null) {
            if ("com.facebook.ads.interstitial.clicked".equals(obj)) {
                this.f4866c.mo644a(this.f4867d, null, true);
            } else if ("com.facebook.ads.interstitial.dismissed".equals(obj)) {
                this.f4866c.mo647d(this.f4867d);
            } else if ("com.facebook.ads.interstitial.displayed".equals(obj)) {
                this.f4866c.mo646c(this.f4867d);
            } else if ("com.facebook.ads.interstitial.impression.logged".equals(obj)) {
                this.f4866c.mo645b(this.f4867d);
            } else if ("com.facebook.ads.interstitial.error".equals(obj)) {
                this.f4866c.mo643a(this.f4867d, C0016g.f613e);
            }
        }
    }
}
