package com.ushareit.listenit;

import android.util.Log;
import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

class arm {
    private final arr f5201a;
    private final aql f5202b;
    private final Object f5203c = new Object();
    private final Object f5204d = new Object();
    private final AtomicInteger f5205e;
    private volatile Thread f5206f;
    private volatile boolean f5207g;
    private volatile int f5208h = -1;

    public arm(arr com_ushareit_listenit_arr, aql com_ushareit_listenit_aql) {
        this.f5201a = (arr) arl.m6900a(com_ushareit_listenit_arr);
        this.f5202b = (aql) arl.m6900a(com_ushareit_listenit_aql);
        this.f5205e = new AtomicInteger();
    }

    private void m6828b() {
        int i = this.f5205e.get();
        if (i >= 1) {
            this.f5205e.set(0);
            throw new arp("Error reading source " + i + " times");
        }
    }

    private void m6829b(long j, long j2) {
        m6839a(j, j2);
        synchronized (this.f5203c) {
            this.f5203c.notifyAll();
        }
    }

    private synchronized void m6830c() {
        Object obj = (this.f5206f == null || this.f5206f.getState() == State.TERMINATED) ? null : 1;
        if (!(this.f5207g || this.f5202b.mo782d() || obj != null)) {
            this.f5206f = new Thread(new aro(), "Source reader for " + this.f5201a);
            this.f5206f.start();
        }
    }

    private void m6831d() {
        synchronized (this.f5203c) {
            try {
                this.f5203c.wait(1000);
            } catch (Throwable e) {
                throw new arp("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6832e() {
        /*
        r8 = this;
        r3 = -1;
        r1 = 0;
        r0 = r8.f5202b;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r1 = r0.mo777a();	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = r8.f5201a;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0.mo790a(r1);	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = r8.f5201a;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r2 = r0.mo788a();	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x003f }
    L_0x0017:
        r4 = r8.f5201a;	 Catch:{ Throwable -> 0x003f }
        r4 = r4.mo789a(r0);	 Catch:{ Throwable -> 0x003f }
        if (r4 == r3) goto L_0x005e;
    L_0x001f:
        r5 = r8.f5204d;	 Catch:{ Throwable -> 0x003f }
        monitor-enter(r5);	 Catch:{ Throwable -> 0x003f }
        r6 = r8.m6834g();	 Catch:{ all -> 0x0051 }
        if (r6 == 0) goto L_0x0032;
    L_0x0028:
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        r8.m6835h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m6829b(r0, r2);
    L_0x0031:
        return;
    L_0x0032:
        r6 = r8.f5202b;	 Catch:{ all -> 0x0051 }
        r6.mo779a(r0, r4);	 Catch:{ all -> 0x0051 }
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        r1 = r1 + r4;
        r4 = (long) r1;
        r6 = (long) r2;
        r8.m6829b(r4, r6);	 Catch:{ Throwable -> 0x003f }
        goto L_0x0017;
    L_0x003f:
        r0 = move-exception;
    L_0x0040:
        r3 = r8.f5205e;	 Catch:{ all -> 0x0054 }
        r3.incrementAndGet();	 Catch:{ all -> 0x0054 }
        r8.m6840a(r0);	 Catch:{ all -> 0x0054 }
        r8.m6835h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m6829b(r0, r2);
        goto L_0x0031;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        throw r0;	 Catch:{ Throwable -> 0x003f }
    L_0x0054:
        r0 = move-exception;
    L_0x0055:
        r8.m6835h();
        r4 = (long) r1;
        r2 = (long) r2;
        r8.m6829b(r4, r2);
        throw r0;
    L_0x005e:
        r8.m6833f();	 Catch:{ Throwable -> 0x003f }
        r8.m6835h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m6829b(r0, r2);
        goto L_0x0031;
    L_0x006a:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0055;
    L_0x006d:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.arm.e():void");
    }

    private void m6833f() {
        synchronized (this.f5204d) {
            if (!m6834g() && this.f5202b.mo777a() == this.f5201a.mo788a()) {
                this.f5202b.mo781c();
            }
        }
    }

    private boolean m6834g() {
        return Thread.currentThread().isInterrupted() || this.f5207g;
    }

    private void m6835h() {
        try {
            this.f5201a.mo791b();
        } catch (Throwable e) {
            m6840a(new arp("Error closing source " + this.f5201a, e));
        }
    }

    public int m6836a(byte[] bArr, long j, int i) {
        arq.m6906a(bArr, j, i);
        while (!this.f5202b.mo782d() && ((long) this.f5202b.mo777a()) < ((long) i) + j && !this.f5207g) {
            m6830c();
            m6831d();
            m6828b();
        }
        int a = this.f5202b.mo778a(bArr, j, i);
        if (this.f5202b.mo782d() && this.f5208h != 100) {
            this.f5208h = 100;
            mo786a(100);
        }
        return a;
    }

    public void m6837a() {
        synchronized (this.f5204d) {
            Log.d("ProxyCache", "Shutdown proxy for " + this.f5201a);
            try {
                this.f5207g = true;
                if (this.f5206f != null) {
                    this.f5206f.interrupt();
                }
                this.f5202b.mo780b();
            } catch (Throwable e) {
                m6840a(e);
            }
        }
    }

    protected void mo786a(int i) {
    }

    protected void m6839a(long j, long j2) {
        Object obj = 1;
        int i = ((j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) == 0 ? 1 : null) != null ? 100 : (int) ((100 * j) / j2);
        Object obj2 = i != this.f5208h ? 1 : null;
        if (j2 < 0) {
            obj = null;
        }
        if (!(obj == null || obj2 == null)) {
            mo786a(i);
        }
        this.f5208h = i;
    }

    protected final void m6840a(Throwable th) {
        if (th instanceof ark) {
            Log.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            Log.e("ProxyCache", "ProxyCache error", th);
        }
    }
}
