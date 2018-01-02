package com.ushareit.listenit.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Binder;
import android.os.IBinder;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fii;
import com.ushareit.listenit.fit;
import com.ushareit.listenit.fiy;
import com.ushareit.listenit.fiz;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.fnr;
import com.ushareit.listenit.fre;
import com.ushareit.listenit.fum;
import com.ushareit.listenit.fus;
import com.ushareit.listenit.gcd;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gnp;
import com.ushareit.listenit.gsg;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.guo;
import com.ushareit.listenit.guq;
import com.ushareit.listenit.gur;
import com.ushareit.listenit.gus;
import com.ushareit.listenit.gut;
import com.ushareit.listenit.guv;
import com.ushareit.listenit.guw;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gwk;
import com.ushareit.listenit.gys;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.hgq;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.receiver.RemotePlaybackReceiver;

public class PlayService extends Service {
    private Binder f16447a;
    private gum f16448b;
    private gsg f16449c;
    private fiy f16450d;
    private int f16451e;
    private ListenItApp f16452f;
    private guo f16453g = new gut(this);
    private hgq f16454h = new guv(this);

    public void onCreate() {
        super.onCreate();
        this.f16447a = new fnr(this);
        this.f16448b = (gum) this.f16447a;
        this.f16452f = (ListenItApp) getApplication();
        this.f16452f.m4932a(this.f16448b);
        this.f16448b.mo2416a(this.f16453g);
        this.f16448b.mo2418a(this.f16454h);
        m26055a(this.f16448b);
        if (!gvj.m23044y(getApplicationContext())) {
            if (guw.m22831a().m22848c() || fjf.f3909u > 0) {
                guw.m22831a().m22847b(getApplicationContext(), this.f16448b);
            }
        }
    }

    private void m26055a(gum com_ushareit_listenit_gum) {
        hhx.m23867a(new guq(this, com_ushareit_listenit_gum));
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (m26058a(intent)) {
            if (this.f16448b.mo2462s() == 0) {
                hhx.m23867a(new gur(this, intent, i, i2));
            } else {
                m26068a(intent, i, i2);
            }
        }
        return 1;
    }

    public void m26068a(Intent intent, int i, int i2) {
        boolean z = true;
        if (m26065d()) {
            m26063c();
        }
        int intExtra = intent.getIntExtra("extra_action", -1);
        String stringExtra = intent.getStringExtra("extra_from");
        switch (intExtra) {
            case 1:
            case 6:
                if (!this.f16448b.mo2425a()) {
                    fii.m19311c((Context) this, stringExtra);
                }
                this.f16448b.mo2450g();
                return;
            case 2:
                this.f16448b.mo2444e();
                return;
            case 3:
                if (!this.f16448b.mo2425a()) {
                    fii.m19311c((Context) this, stringExtra);
                }
                this.f16448b.mo2442d();
                return;
            case 4:
                fii.m19311c((Context) this, stringExtra);
                this.f16448b.mo2451h();
                return;
            case 5:
                fii.m19311c((Context) this, stringExtra);
                gum com_ushareit_listenit_gum = this.f16448b;
                if (fbb.m18763c(stringExtra) || !((stringExtra.equals("widget") || stringExtra.equals("notification")) && gvj.aj(getApplicationContext()))) {
                    z = false;
                }
                com_ushareit_listenit_gum.mo2424a(z);
                return;
            case 7:
                gnp.m22532a((Service) this);
                this.f16448b.mo2444e();
                if (m26065d()) {
                    stopSelf();
                    return;
                }
                return;
            case 8:
                glg v = this.f16448b.mo2465v();
                if (v != null) {
                    if (fre.m20627a(v)) {
                        z = false;
                    }
                    fre.m20626a(v, z);
                    m26061b(this.f16448b.mo2425a());
                    fii.m19321g(this, stringExtra);
                    return;
                }
                return;
            case 9:
                int l = this.f16448b.mo2455l();
                this.f16448b.mo2426b(l);
                heb.m23596a(m26049a(l), 0).show();
                return;
            case 10:
                if (this.f16448b.mo2453j()) {
                    z = false;
                }
                this.f16448b.mo2436b(z);
                fit.m19438f(this, stringExtra);
                heb.m23596a(m26051a(z), 0).show();
                return;
            case 11:
                m26061b(this.f16448b.mo2425a());
                fiz.m19503a();
                return;
            default:
                return;
        }
    }

    private int m26051a(boolean z) {
        return z ? C0349R.string.common_shuffle_enable_play : C0349R.string.common_shuffle_disable_play;
    }

    private boolean m26058a(Intent intent) {
        if (intent == null || fbb.m18763c(intent.getAction()) || !intent.getAction().contains("com.ushareit.listenit.action.remoteplayback") || !intent.hasExtra("extra_action")) {
            return false;
        }
        return true;
    }

    public IBinder onBind(Intent intent) {
        exw.m18449b("PlayService", "PlayerService onBind");
        return this.f16447a;
    }

    public void onRebind(Intent intent) {
        exw.m18449b("PlayService", "PlayerService onRebind, intent = " + (intent != null ? intent.getAction() : ""));
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        exw.m18449b("PlayService", "PlayerService onUnbind, intent = " + (intent != null ? intent.getAction() : "") + ", isnotifiCanceled=" + gnp.m22535a() + ", isPlaying=" + this.f16448b.mo2425a());
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        exw.m18443a("PlayService", "PlayerService Destroyed");
        this.f16452f.m4939e();
        gwk.m23063a().m23075c();
        this.f16448b.mo2430b(this.f16453g);
        this.f16448b.mo2408B();
        this.f16448b.mo2452i();
        m26060b();
        gcd.m21661a().m21673b();
        fus.m21026a().m21045b((Context) this);
        if (this.f16449c != null) {
            this.f16449c.m22682b(getApplicationContext());
        }
        fum.m20996a().m21007b();
        hhx.m23867a(new gus(this));
        if (this.f16450d != null) {
            this.f16450d.m19494a(getApplicationContext());
        }
        guw.m22831a().m22845a(getApplicationContext(), this.f16448b, true);
        fii.m19290a(getApplicationContext(), (long) this.f16451e);
        super.onDestroy();
    }

    private void m26054a() {
        try {
            ((AudioManager) getSystemService("audio")).registerMediaButtonEventReceiver(new ComponentName(getPackageName(), RemotePlaybackReceiver.class.getName()));
        } catch (Exception e) {
        }
    }

    @TargetApi(14)
    private void m26060b() {
        try {
            ((AudioManager) getSystemService("audio")).unregisterMediaButtonEventReceiver(new ComponentName(getPackageName(), RemotePlaybackReceiver.class.getName()));
        } catch (Exception e) {
        }
    }

    private void m26063c() {
        this.f16448b.mo2407A();
        this.f16448b.mo2469z();
        this.f16448b.mo2416a(this.f16453g);
    }

    private void m26061b(boolean z) {
        if (z || !gnp.m22535a()) {
            gnp.m22534a(this, this.f16448b.mo2465v(), z);
        }
    }

    private boolean m26065d() {
        return gys.m23310a() == null;
    }

    private int m26049a(int i) {
        switch (i) {
            case 2:
                return C0349R.string.common_play_mode_list_repeat;
            case 3:
                return C0349R.string.common_play_mode_song_repeat;
            default:
                return C0349R.string.common_play_mode_list;
        }
    }
}
