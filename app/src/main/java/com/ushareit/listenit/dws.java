package com.ushareit.listenit;

import android.os.Handler;

abstract class dws {
    private static volatile Handler f10410b;
    private final dyf f10411a;
    private final Runnable f10412c = new dwt(this);
    private volatile long f10413d;
    private boolean f10414e = true;

    dws(dyf com_ushareit_listenit_dyf) {
        cfi.m11080a((Object) com_ushareit_listenit_dyf);
        this.f10411a = com_ushareit_listenit_dyf;
    }

    private Handler m15824d() {
        if (f10410b != null) {
            return f10410b;
        }
        Handler handler;
        synchronized (dws.class) {
            if (f10410b == null) {
                f10410b = new Handler(this.f10411a.m16467r().getMainLooper());
            }
            handler = f10410b;
        }
        return handler;
    }

    public abstract void mo2099a();

    public void m15826a(long j) {
        m15828c();
        if (j >= 0) {
            this.f10413d = this.f10411a.m16468s().mo1370a();
            if (!m15824d().postDelayed(this.f10412c, j)) {
                this.f10411a.m16455f().m16242f().m16264a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public boolean m15827b() {
        return this.f10413d != 0;
    }

    public void m15828c() {
        this.f10413d = 0;
        m15824d().removeCallbacks(this.f10412c);
    }
}
