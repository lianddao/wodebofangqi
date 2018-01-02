package com.ushareit.listenit;

import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

class agp {
    private static final hjm f4296a = hjn.m23936a("ProxyCache");
    private final agu f4297b;
    private final afw f4298c;
    private final Object f4299d = new Object();
    private final Object f4300e = new Object();
    private final AtomicInteger f4301f;
    private volatile Thread f4302g;
    private volatile boolean f4303h;
    private volatile int f4304i = -1;

    public agp(agu com_ushareit_listenit_agu, afw com_ushareit_listenit_afw) {
        this.f4297b = (agu) ago.m5589a((Object) com_ushareit_listenit_agu);
        this.f4298c = (afw) ago.m5589a((Object) com_ushareit_listenit_afw);
        this.f4301f = new AtomicInteger();
    }

    public int m5523a(byte[] bArr, long j, int i) {
        agt.m5597a(bArr, j, i);
        while (!this.f4298c.mo627d() && this.f4298c.mo623a() < ((long) i) + j && !this.f4303h) {
            m5516c();
            m5517d();
            m5514b();
        }
        int a = this.f4298c.mo622a(bArr, j, i);
        if (this.f4298c.mo627d() && this.f4304i != 100) {
            this.f4304i = 100;
            mo616a(100);
        }
        return a;
    }

    private void m5514b() {
        int i = this.f4301f.get();
        if (i >= 1) {
            this.f4301f.set(0);
            throw new ags("Error reading source " + i + " times");
        }
    }

    public void m5524a() {
        synchronized (this.f4300e) {
            f4296a.mo2789a("Shutdown proxy for " + this.f4297b);
            try {
                this.f4303h = true;
                if (this.f4302g != null) {
                    this.f4302g.interrupt();
                }
                this.f4298c.mo625b();
            } catch (Throwable e) {
                m5527a(e);
            }
        }
    }

    private synchronized void m5516c() {
        Object obj = (this.f4302g == null || this.f4302g.getState() == State.TERMINATED) ? null : 1;
        if (!(this.f4303h || this.f4298c.mo627d() || obj != null)) {
            this.f4302g = new Thread(new agr(), "Source reader for " + this.f4297b);
            this.f4302g.start();
        }
    }

    private void m5517d() {
        synchronized (this.f4299d) {
            try {
                this.f4299d.wait(1000);
            } catch (Throwable e) {
                throw new ags("Waiting source data is interrupted!", e);
            }
        }
    }

    private void m5515b(long j, long j2) {
        m5526a(j, j2);
        synchronized (this.f4299d) {
            this.f4299d.notifyAll();
        }
    }

    protected void m5526a(long j, long j2) {
        Object obj = 1;
        int i = ((j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) == 0 ? 1 : null) != null ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        Object obj2;
        if (i != this.f4304i) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (j2 < 0) {
            obj = null;
        }
        if (!(obj == null || r3 == null)) {
            mo616a(i);
        }
        this.f4304i = i;
    }

    protected void mo616a(int i) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5518e() {
        /*
        r8 = this;
        r4 = -1;
        r2 = 0;
        r0 = r8.f4298c;	 Catch:{ Throwable -> 0x003f }
        r2 = r0.mo623a();	 Catch:{ Throwable -> 0x003f }
        r0 = r8.f4297b;	 Catch:{ Throwable -> 0x003f }
        r0.mo620a(r2);	 Catch:{ Throwable -> 0x003f }
        r0 = r8.f4297b;	 Catch:{ Throwable -> 0x003f }
        r4 = r0.mo619a();	 Catch:{ Throwable -> 0x003f }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x003f }
    L_0x0019:
        r1 = r8.f4297b;	 Catch:{ Throwable -> 0x003f }
        r1 = r1.mo618a(r0);	 Catch:{ Throwable -> 0x003f }
        r6 = -1;
        if (r1 == r6) goto L_0x005a;
    L_0x0022:
        r6 = r8.f4300e;	 Catch:{ Throwable -> 0x003f }
        monitor-enter(r6);	 Catch:{ Throwable -> 0x003f }
        r7 = r8.m5521h();	 Catch:{ all -> 0x004f }
        if (r7 == 0) goto L_0x0033;
    L_0x002b:
        monitor-exit(r6);	 Catch:{ all -> 0x004f }
        r8.m5522i();
        r8.m5515b(r2, r4);
    L_0x0032:
        return;
    L_0x0033:
        r7 = r8.f4298c;	 Catch:{ all -> 0x004f }
        r7.mo624a(r0, r1);	 Catch:{ all -> 0x004f }
        monitor-exit(r6);	 Catch:{ all -> 0x004f }
        r6 = (long) r1;
        r2 = r2 + r6;
        r8.m5515b(r2, r4);	 Catch:{ Throwable -> 0x003f }
        goto L_0x0019;
    L_0x003f:
        r0 = move-exception;
        r1 = r8.f4301f;	 Catch:{ all -> 0x0052 }
        r1.incrementAndGet();	 Catch:{ all -> 0x0052 }
        r8.m5527a(r0);	 Catch:{ all -> 0x0052 }
        r8.m5522i();
        r8.m5515b(r2, r4);
        goto L_0x0032;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x004f }
        throw r0;	 Catch:{ Throwable -> 0x003f }
    L_0x0052:
        r0 = move-exception;
        r8.m5522i();
        r8.m5515b(r2, r4);
        throw r0;
    L_0x005a:
        r8.m5520g();	 Catch:{ Throwable -> 0x003f }
        r8.m5519f();	 Catch:{ Throwable -> 0x003f }
        r8.m5522i();
        r8.m5515b(r2, r4);
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.agp.e():void");
    }

    private void m5519f() {
        this.f4304i = 100;
        mo616a(this.f4304i);
    }

    private void m5520g() {
        synchronized (this.f4300e) {
            if (!m5521h() && this.f4298c.mo623a() == this.f4297b.mo619a()) {
                this.f4298c.mo626c();
            }
        }
    }

    private boolean m5521h() {
        return Thread.currentThread().isInterrupted() || this.f4303h;
    }

    private void m5522i() {
        try {
            this.f4297b.mo621b();
        } catch (Throwable e) {
            m5527a(new ags("Error closing source " + this.f4297b, e));
        }
    }

    protected final void m5527a(Throwable th) {
        if (th instanceof agk) {
            f4296a.mo2789a("ProxyCache is interrupted");
        } else {
            f4296a.mo2792a("ProxyCache error", th);
        }
    }
}
