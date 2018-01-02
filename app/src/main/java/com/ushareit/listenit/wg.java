package com.ushareit.listenit;

import android.util.Log;

class wg implements yk, Runnable {
    private final tv f17119a;
    private final wh f17120b;
    private final vm<?, ?, ?> f17121c;
    private wi f17122d = wi.CACHE;
    private volatile boolean f17123e;

    public wg(wh whVar, vm<?, ?, ?> vmVar, tv tvVar) {
        this.f17120b = whVar;
        this.f17121c = vmVar;
        this.f17119a = tvVar;
    }

    public void m26783a() {
        this.f17123e = true;
        this.f17121c.m26724d();
    }

    public void run() {
        Exception exception = null;
        if (!this.f17123e) {
            wk d;
            try {
                d = m26780d();
            } catch (Throwable e) {
                if (Log.isLoggable("EngineRunnable", 2)) {
                    Log.v("EngineRunnable", "Exception decoding", e);
                }
                Throwable th = e;
                Object obj = null;
            }
            if (this.f17123e) {
                if (d != null) {
                    d.mo555d();
                }
            } else if (d == null) {
                m26778a(exception);
            } else {
                m26777a(d);
            }
        }
    }

    private boolean m26779c() {
        return this.f17122d == wi.CACHE;
    }

    private void m26777a(wk wkVar) {
        this.f17120b.mo597a(wkVar);
    }

    private void m26778a(Exception exception) {
        if (m26779c()) {
            this.f17122d = wi.SOURCE;
            this.f17120b.mo3114b(this);
            return;
        }
        this.f17120b.mo598a(exception);
    }

    private wk<?> m26780d() {
        if (m26779c()) {
            return m26781e();
        }
        return m26782f();
    }

    private wk<?> m26781e() {
        wk<?> a;
        try {
            a = this.f17121c.m26721a();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            a = null;
        }
        if (a == null) {
            return this.f17121c.m26722b();
        }
        return a;
    }

    private wk<?> m26782f() {
        return this.f17121c.m26723c();
    }

    public int mo3116b() {
        return this.f17119a.ordinal();
    }
}
