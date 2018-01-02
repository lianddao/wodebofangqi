package com.ushareit.listenit;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public abstract class dma<R extends ceg> extends ced<R> {
    static final ThreadLocal<Boolean> f8104d = new dmb();
    private final Object f8105a;
    private final CountDownLatch f8106b;
    private final ArrayList<cee> f8107c;
    protected final dmc<R> f8108e;
    protected final WeakReference<cdz> f8109f;
    private ceh<? super R> f8110g;
    private final AtomicReference<doz> f8111h;
    private R f8112i;
    private dmd f8113j;
    private volatile boolean f8114k;
    private boolean f8115l;
    private boolean f8116m;
    private chp f8117n;
    private volatile dot<R> f8118o;
    private boolean f8119p;

    @Deprecated
    dma() {
        this.f8105a = new Object();
        this.f8106b = new CountDownLatch(1);
        this.f8107c = new ArrayList();
        this.f8111h = new AtomicReference();
        this.f8119p = false;
        this.f8108e = new dmc(Looper.getMainLooper());
        this.f8109f = new WeakReference(null);
    }

    protected dma(cdz com_ushareit_listenit_cdz) {
        this.f8105a = new Object();
        this.f8106b = new CountDownLatch(1);
        this.f8107c = new ArrayList();
        this.f8111h = new AtomicReference();
        this.f8119p = false;
        this.f8108e = new dmc(com_ushareit_listenit_cdz != null ? com_ushareit_listenit_cdz.mo2004c() : Looper.getMainLooper());
        this.f8109f = new WeakReference(com_ushareit_listenit_cdz);
    }

    private void mo1273a(R r) {
        this.f8112i = r;
        this.f8117n = null;
        this.f8106b.countDown();
        Status b = this.f8112i.mo260b();
        if (this.f8115l) {
            this.f8110g = null;
        } else if (this.f8110g != null) {
            this.f8108e.m14821a();
            this.f8108e.m14822a(this.f8110g, mo1276c());
        } else if (this.f8112i instanceof cef) {
            this.f8113j = new dmd();
        }
        Iterator it = this.f8107c.iterator();
        while (it.hasNext()) {
            ((cee) it.next()).m10964a(b);
        }
        this.f8107c.clear();
    }

    private void mo1275b() {
        doz com_ushareit_listenit_doz = (doz) this.f8111h.getAndSet(null);
        if (com_ushareit_listenit_doz != null) {
            com_ushareit_listenit_doz.mo2016a(this);
        }
    }

    private R mo1276c() {
        R r;
        boolean z = true;
        synchronized (this.f8105a) {
            if (this.f8114k) {
                z = false;
            }
            cfi.m11086a(z, (Object) "Result has already been consumed.");
            cfi.m11086a(m10795d(), (Object) "Result is not ready.");
            r = this.f8112i;
            this.f8112i = null;
            this.f8110g = null;
            this.f8114k = true;
        }
        mo1275b();
        return r;
    }

    public static void m10788c(ceg com_ushareit_listenit_ceg) {
        if (com_ushareit_listenit_ceg instanceof cef) {
            try {
                ((cef) com_ushareit_listenit_ceg).mo1297a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(com_ushareit_listenit_ceg);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public Integer mo1271a() {
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1272a(com.ushareit.listenit.ceh<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.f8105a;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.f8110g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.f8114k;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.ushareit.listenit.cfi.m11086a(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.f8118o;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.ushareit.listenit.cfi.m11086a(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.m10798g();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.m10795d();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.f8108e;	 Catch:{ all -> 0x0027 }
        r1 = r5.mo1276c();	 Catch:{ all -> 0x0027 }
        r0.m14822a(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.f8110g = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.dma.a(com.ushareit.listenit.ceh):void");
    }

    public void m10791a(doz com_ushareit_listenit_doz) {
        this.f8111h.set(com_ushareit_listenit_doz);
    }

    protected abstract R mo1278b(Status status);

    public final void m10793b(R r) {
        boolean z = true;
        synchronized (this.f8105a) {
            if (this.f8116m || this.f8115l || (m10795d() && m10801j())) {
                m10788c(r);
                return;
            }
            cfi.m11086a(!m10795d(), (Object) "Results have already been set");
            if (this.f8114k) {
                z = false;
            }
            cfi.m11086a(z, (Object) "Result has already been consumed");
            mo1273a((ceg) r);
        }
    }

    public final void m10794d(Status status) {
        synchronized (this.f8105a) {
            if (!m10795d()) {
                m10793b(mo1278b(status));
                this.f8116m = true;
            }
        }
    }

    public final boolean m10795d() {
        return this.f8106b.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m10796e() {
        /*
        r2 = this;
        r1 = r2.f8105a;
        monitor-enter(r1);
        r0 = r2.f8115l;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f8114k;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.f8117n;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.f8117n;	 Catch:{ RemoteException -> 0x002c }
        r0.m11252a();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.f8112i;	 Catch:{ all -> 0x0029 }
        m10788c(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.f8115l = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.f1690e;	 Catch:{ all -> 0x0029 }
        r0 = r2.mo1278b(r0);	 Catch:{ all -> 0x0029 }
        r2.mo1273a(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.dma.e():void");
    }

    public boolean m10797f() {
        boolean g;
        synchronized (this.f8105a) {
            if (((cdz) this.f8109f.get()) == null || !this.f8119p) {
                m10796e();
            }
            g = m10798g();
        }
        return g;
    }

    public boolean m10798g() {
        boolean z;
        synchronized (this.f8105a) {
            z = this.f8115l;
        }
        return z;
    }

    public void m10799h() {
        mo1272a(null);
    }

    public void m10800i() {
        boolean z = this.f8119p || ((Boolean) f8104d.get()).booleanValue();
        this.f8119p = z;
    }

    boolean m10801j() {
        return false;
    }
}
