package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.internal.view.C0053i;
import java.io.Serializable;

public class ala extends BroadcastReceiver {
    private Context f4623a;
    private C0053i f4624b;
    private boolean f4625c = false;

    public ala(C0053i c0053i, Context context) {
        this.f4624b = c0053i;
        this.f4623a = context;
    }

    public void m5953a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f4624b.getUniqueId());
        intentFilter.addAction("videoInterstitalEvent:" + this.f4624b.getUniqueId());
        ec.m16689a(this.f4623a).m16693a(this, intentFilter);
    }

    public void m5954b() {
        try {
            ec.m16689a(this.f4623a).m16692a((BroadcastReceiver) this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        String[] split = intent.getAction().split(":");
        if (split.length != 2 || !split[1].equals(this.f4624b.getUniqueId())) {
            return;
        }
        if (split[0].equals("com.facebook.ads.interstitial.displayed")) {
            if (this.f4624b.getListener() != null) {
                this.f4624b.getListener().mo89g();
                this.f4624b.getListener().mo83a();
            }
        } else if (split[0].equals("videoInterstitalEvent")) {
            Serializable serializableExtra = intent.getSerializableExtra("event");
            if (serializableExtra instanceof awf) {
                if (this.f4624b.getListener() != null) {
                    this.f4624b.getListener().mo88f();
                    this.f4624b.getListener().mo83a();
                }
                if (this.f4625c) {
                    this.f4624b.m1103a(1);
                } else {
                    this.f4624b.m1103a(((awf) serializableExtra).m7258b());
                }
                this.f4624b.setVisibility(0);
                this.f4624b.mo151d();
            } else if (serializableExtra instanceof avv) {
                if (this.f4624b.getListener() != null) {
                    this.f4624b.getListener().mo86d();
                }
            } else if (serializableExtra instanceof avw) {
                if (this.f4624b.getListener() != null) {
                    this.f4624b.getListener().mo87e();
                }
            } else if (serializableExtra instanceof avr) {
                if (this.f4624b.getListener() != null) {
                    this.f4624b.getListener().mo90h();
                }
                this.f4625c = true;
            } else if (serializableExtra instanceof avz) {
                if (this.f4624b.getListener() != null) {
                    this.f4624b.getListener().mo85c();
                }
                this.f4625c = false;
            } else if ((serializableExtra instanceof avx) && this.f4624b.getListener() != null) {
                this.f4624b.getListener().mo84b();
            }
        }
    }
}
