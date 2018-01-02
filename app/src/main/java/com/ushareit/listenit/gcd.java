package com.ushareit.listenit;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.os.Build.VERSION;
import android.widget.ImageView;
import com.ushareit.listenit.receiver.RemotePlaybackReceiver;
import java.util.ArrayList;
import java.util.List;

public class gcd {
    private static String f13895a = "KeyguardController";
    private static gcd f13896b = new gcd();
    private Context f13897c = eys.m18562a();
    private RemoteControlClient f13898d;
    private AudioManager f13899e;
    private ComponentName f13900f;
    private gum f13901g;
    private ImageView f13902h;
    private gch f13903i;
    private KeyguardManager f13904j;
    private KeyguardLock f13905k;
    private List<gcg> f13906l = new ArrayList();
    private boolean f13907m = true;
    private boolean f13908n;
    private boolean f13909o = false;
    private guo f13910p = new gcf(this);

    private gcd() {
        boolean z = true;
        if (VERSION.SDK_INT >= 14) {
            z = false;
        }
        this.f13908n = z;
        this.f13907m = gvj.m22953f();
        this.f13902h = new ImageView(this.f13897c);
    }

    public static gcd m21661a() {
        if (f13896b == null) {
            f13896b = new gcd();
        }
        return f13896b;
    }

    public void m21671a(gum com_ushareit_listenit_gum) {
        this.f13901g = com_ushareit_listenit_gum;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.f13903i = new gch(com_ushareit_listenit_gum);
        this.f13897c.registerReceiver(this.f13903i, intentFilter);
        if (this.f13907m) {
            m21666g();
        }
    }

    public void m21673b() {
        try {
            if (this.f13903i != null) {
                this.f13897c.unregisterReceiver(this.f13903i);
            }
            if (this.f13907m) {
                m21667h();
            }
            this.f13901g = null;
        } catch (Exception e) {
        }
    }

    public void m21672a(boolean z) {
        if (z != this.f13907m) {
            this.f13907m = z;
            if (this.f13907m) {
                m21666g();
                if (this.f13901g != null && this.f13901g.mo2425a()) {
                    m21663a(this.f13901g.mo2465v());
                    return;
                }
                return;
            }
            m21667h();
        }
    }

    public boolean m21677c() {
        return this.f13909o;
    }

    public void m21674b(boolean z) {
        this.f13909o = z;
    }

    private void m21666g() {
        if (!this.f13908n) {
            this.f13900f = new ComponentName(this.f13897c.getPackageName(), RemotePlaybackReceiver.class.getName());
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(this.f13900f);
            this.f13898d = new RemoteControlClient(PendingIntent.getBroadcast(this.f13897c, 0, intent, 0));
            this.f13898d.setTransportControlFlags(189);
            this.f13899e = (AudioManager) this.f13897c.getSystemService("audio");
            try {
                this.f13899e.registerRemoteControlClient(this.f13898d);
            } catch (Exception e) {
            }
            this.f13901g.mo2416a(this.f13910p);
        }
    }

    private void m21667h() {
        if (this.f13898d != null && VERSION.SDK_INT >= 14) {
            this.f13898d.setPlaybackState(1);
            this.f13899e.unregisterRemoteControlClient(this.f13898d);
            this.f13901g.mo2430b(this.f13910p);
            this.f13898d = null;
        }
    }

    public void m21670a(gcg com_ushareit_listenit_gcg) {
        if (com_ushareit_listenit_gcg != null && !this.f13906l.contains(com_ushareit_listenit_gcg)) {
            this.f13906l.add(com_ushareit_listenit_gcg);
        }
    }

    public boolean m21675b(gcg com_ushareit_listenit_gcg) {
        return this.f13906l.remove(com_ushareit_listenit_gcg);
    }

    public void m21676c(boolean z) {
        if (z) {
            for (gcg a : this.f13906l) {
                a.mo2363a();
            }
            return;
        }
        for (gcg a2 : this.f13906l) {
            a2.mo2364b();
        }
    }

    private void m21668i() {
        if (VERSION.SDK_INT >= 14) {
            this.f13898d.setPlaybackState(2);
        }
    }

    private void m21663a(glg com_ushareit_listenit_glg) {
        if (com_ushareit_listenit_glg != null && this.f13898d != null && VERSION.SDK_INT >= 14) {
            this.f13898d.setPlaybackState(3);
            MetadataEditor editMetadata = this.f13898d.editMetadata(false);
            editMetadata.putString(7, com_ushareit_listenit_glg.f14338f);
            editMetadata.putString(1, com_ushareit_listenit_glg.f14340h);
            editMetadata.putString(2, com_ushareit_listenit_glg.f14339g);
            editMetadata.putLong(9, (long) com_ushareit_listenit_glg.f14337e);
            editMetadata.apply();
            fzi.m21402a(eys.m18562a(), (gla) com_ushareit_listenit_glg, this.f13902h, tv.NORMAL, 320, new gce(this));
        }
    }

    public boolean m21678d() {
        if (this.f13904j == null) {
            this.f13904j = (KeyguardManager) this.f13897c.getSystemService("keyguard");
        }
        if (VERSION.SDK_INT >= 16) {
            return this.f13904j.isKeyguardSecure();
        }
        return false;
    }

    public void m21679e() {
        try {
            m21669j().reenableKeyguard();
        } catch (Exception e) {
        }
    }

    public void m21680f() {
        try {
            m21669j().disableKeyguard();
        } catch (Exception e) {
        }
    }

    private KeyguardLock m21669j() {
        if (this.f13905k == null) {
            if (this.f13904j == null) {
                this.f13904j = (KeyguardManager) this.f13897c.getSystemService("keyguard");
            }
            this.f13905k = this.f13904j.newKeyguardLock("listenit");
        }
        return this.f13905k;
    }
}
