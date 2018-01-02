package com.ushareit.listenit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.cb;
import com.facebook.internal.cj;
import com.umeng.analytics.C0154a;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class aho {
    private static volatile aho f4366a;
    private final ec f4367b;
    private final ahm f4368c;
    private AccessToken f4369d;
    private AtomicBoolean f4370e = new AtomicBoolean(false);
    private Date f4371f = new Date(0);

    aho(ec ecVar, ahm com_ushareit_listenit_ahm) {
        cj.m1640a((Object) ecVar, "localBroadcastManager");
        cj.m1640a((Object) com_ushareit_listenit_ahm, "accessTokenCache");
        this.f4367b = ecVar;
        this.f4368c = com_ushareit_listenit_ahm;
    }

    public static aho m5655a() {
        if (f4366a == null) {
            synchronized (aho.class) {
                if (f4366a == null) {
                    f4366a = new aho(ec.m16689a(ail.m5715f()), new ahm());
                }
            }
        }
        return f4366a;
    }

    public AccessToken m5664b() {
        return this.f4369d;
    }

    boolean m5665c() {
        AccessToken a = this.f4368c.m5650a();
        if (a == null) {
            return false;
        }
        m5657a(a, false);
        return true;
    }

    public void m5663a(AccessToken accessToken) {
        m5657a(accessToken, true);
    }

    private void m5657a(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.f4369d;
        this.f4369d = accessToken;
        this.f4370e.set(false);
        this.f4371f = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.f4368c.m5651a(accessToken);
            } else {
                this.f4368c.m5652b();
                cb.m1599b(ail.m5715f());
            }
        }
        if (!cb.m1590a((Object) accessToken2, (Object) accessToken)) {
            m5656a(accessToken2, accessToken);
        }
    }

    private void m5656a(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.f4367b.m16694a(intent);
    }

    public void m5666d() {
        if (m5661f()) {
            m5667e();
        }
    }

    private boolean m5661f() {
        if (this.f4369d == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (!this.f4369d.m682f().m5672a() || valueOf.longValue() - this.f4371f.getTime() <= C0154a.f2954j || valueOf.longValue() - this.f4369d.m683g().getTime() <= C0154a.f2953i) {
            return false;
        }
        return true;
    }

    private static GraphRequest m5654a(AccessToken accessToken, aix com_ushareit_listenit_aix) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), aji.GET, com_ushareit_listenit_aix);
    }

    private static GraphRequest m5659b(AccessToken accessToken, aix com_ushareit_listenit_aix) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", bundle, aji.GET, com_ushareit_listenit_aix);
    }

    void m5667e() {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            m5662g();
        } else {
            new Handler(Looper.getMainLooper()).post(new ahp(this));
        }
    }

    private void m5662g() {
        AccessToken accessToken = this.f4369d;
        if (accessToken != null && this.f4370e.compareAndSet(false, true)) {
            cj.m1637a();
            this.f4371f = new Date();
            Set hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            aje com_ushareit_listenit_aje = new aje(m5654a(accessToken, new ahq(this, new AtomicBoolean(false), hashSet, hashSet2)), m5659b(accessToken, new ahr(this, new aht())));
            com_ushareit_listenit_aje.m5756a(new ahs(this, accessToken, r3, r4, hashSet, hashSet2));
            com_ushareit_listenit_aje.m5766h();
        }
    }
}
