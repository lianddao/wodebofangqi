package com.ushareit.listenit;

import android.util.Log;
import java.io.File;

class vm<A, T, Z> {
    private static final vo f17039a = new vo();
    private final wc f17040b;
    private final int f17041c;
    private final int f17042d;
    private final vc<A> f17043e;
    private final aeb<A, T> f17044f;
    private final uz<T> f17045g;
    private final adb<T, Z> f17046h;
    private final vn f17047i;
    private final vq f17048j;
    private final tv f17049k;
    private final vo f17050l;
    private volatile boolean f17051m;

    public vm(wc wcVar, int i, int i2, vc<A> vcVar, aeb<A, T> com_ushareit_listenit_aeb_A__T, uz<T> uzVar, adb<T, Z> com_ushareit_listenit_adb_T__Z, vn vnVar, vq vqVar, tv tvVar) {
        this(wcVar, i, i2, vcVar, com_ushareit_listenit_aeb_A__T, uzVar, com_ushareit_listenit_adb_T__Z, vnVar, vqVar, tvVar, f17039a);
    }

    vm(wc wcVar, int i, int i2, vc<A> vcVar, aeb<A, T> com_ushareit_listenit_aeb_A__T, uz<T> uzVar, adb<T, Z> com_ushareit_listenit_adb_T__Z, vn vnVar, vq vqVar, tv tvVar, vo voVar) {
        this.f17040b = wcVar;
        this.f17041c = i;
        this.f17042d = i2;
        this.f17043e = vcVar;
        this.f17044f = com_ushareit_listenit_aeb_A__T;
        this.f17045g = uzVar;
        this.f17046h = com_ushareit_listenit_adb_T__Z;
        this.f17047i = vnVar;
        this.f17048j = vqVar;
        this.f17049k = tvVar;
        this.f17050l = voVar;
    }

    public wk<Z> m26721a() {
        if (!this.f17048j.m26730b()) {
            return null;
        }
        long a = afq.m5477a();
        wk a2 = m26712a(this.f17040b);
        if (Log.isLoggable("DecodeJob", 2)) {
            m26715a("Decoded transformed from cache", a);
        }
        long a3 = afq.m5477a();
        wk<Z> d = m26719d(a2);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return d;
        }
        m26715a("Transcoded transformed from cache", a3);
        return d;
    }

    public wk<Z> m26722b() {
        if (!this.f17048j.m26729a()) {
            return null;
        }
        long a = afq.m5477a();
        wk a2 = m26712a(this.f17040b.m26766a());
        if (Log.isLoggable("DecodeJob", 2)) {
            m26715a("Decoded source from cache", a);
        }
        return m26713a(a2);
    }

    public wk<Z> m26723c() {
        return m26713a(m26720e());
    }

    public void m26724d() {
        this.f17051m = true;
        this.f17043e.mo587c();
    }

    private wk<Z> m26713a(wk<T> wkVar) {
        long a = afq.m5477a();
        wk c = m26718c(wkVar);
        if (Log.isLoggable("DecodeJob", 2)) {
            m26715a("Transformed resource from source", a);
        }
        m26717b(c);
        a = afq.m5477a();
        wk<Z> d = m26719d(c);
        if (Log.isLoggable("DecodeJob", 2)) {
            m26715a("Transcoded transformed from source", a);
        }
        return d;
    }

    private void m26717b(wk<T> wkVar) {
        if (wkVar != null && this.f17048j.m26730b()) {
            long a = afq.m5477a();
            this.f17047i.mo3113a().mo3136a(this.f17040b, new vp(this, this.f17044f.mo564d(), wkVar));
            if (Log.isLoggable("DecodeJob", 2)) {
                m26715a("Wrote transformed from source to cache", a);
            }
        }
    }

    private wk<T> m26720e() {
        try {
            long a = afq.m5477a();
            Object a2 = this.f17043e.mo584a(this.f17049k);
            if (Log.isLoggable("DecodeJob", 2)) {
                m26715a("Fetched data", a);
            }
            if (this.f17051m) {
                return null;
            }
            wk<T> a3 = m26714a(a2);
            this.f17043e.mo585a();
            return a3;
        } finally {
            this.f17043e.mo585a();
        }
    }

    private wk<T> m26714a(A a) {
        if (this.f17048j.m26729a()) {
            return m26716b((Object) a);
        }
        long a2 = afq.m5477a();
        wk<T> a3 = this.f17044f.mo562b().mo565a(a, this.f17041c, this.f17042d);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return a3;
        }
        m26715a("Decoded from source", a2);
        return a3;
    }

    private wk<T> m26716b(A a) {
        long a2 = afq.m5477a();
        this.f17047i.mo3113a().mo3136a(this.f17040b.m26766a(), new vp(this, this.f17044f.mo563c(), a));
        if (Log.isLoggable("DecodeJob", 2)) {
            m26715a("Wrote source to cache", a2);
        }
        a2 = afq.m5477a();
        wk<T> a3 = m26712a(this.f17040b.m26766a());
        if (Log.isLoggable("DecodeJob", 2) && a3 != null) {
            m26715a("Decoded source from cache", a2);
        }
        return a3;
    }

    private wk<T> m26712a(uv uvVar) {
        wk<T> wkVar = null;
        File a = this.f17047i.mo3113a().mo3135a(uvVar);
        if (a != null) {
            try {
                wkVar = this.f17044f.mo561a().mo565a(a, this.f17041c, this.f17042d);
                if (wkVar == null) {
                    this.f17047i.mo3113a().mo3137b(uvVar);
                }
            } catch (Throwable th) {
                if (wkVar == null) {
                    this.f17047i.mo3113a().mo3137b(uvVar);
                }
            }
        }
        return wkVar;
    }

    private wk<T> m26718c(wk<T> wkVar) {
        if (wkVar == null) {
            return null;
        }
        wk<T> a = this.f17045g.mo556a(wkVar, this.f17041c, this.f17042d);
        if (wkVar.equals(a)) {
            return a;
        }
        wkVar.mo555d();
        return a;
    }

    private wk<Z> m26719d(wk<T> wkVar) {
        if (wkVar == null) {
            return null;
        }
        return this.f17046h.mo588a(wkVar);
    }

    private void m26715a(String str, long j) {
        Log.v("DecodeJob", str + " in " + afq.m5476a(j) + ", key: " + this.f17040b);
    }
}
