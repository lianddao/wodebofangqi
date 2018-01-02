package com.ushareit.listenit;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class chd implements Callback {
    final ArrayList<ceb> f8284a = new ArrayList();
    private final che f8285b;
    private final ArrayList<ceb> f8286c = new ArrayList();
    private final ArrayList<cec> f8287d = new ArrayList();
    private volatile boolean f8288e = false;
    private final AtomicInteger f8289f = new AtomicInteger(0);
    private boolean f8290g = false;
    private final Handler f8291h;
    private final Object f8292i = new Object();

    public chd(Looper looper, che com_ushareit_listenit_che) {
        this.f8285b = com_ushareit_listenit_che;
        this.f8291h = new Handler(looper, this);
    }

    public void m11212a() {
        this.f8288e = false;
        this.f8289f.incrementAndGet();
    }

    public void m11213a(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f8291h.getLooper()) {
            z = true;
        }
        cfi.m11086a(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f8291h.removeMessages(1);
        synchronized (this.f8292i) {
            this.f8290g = true;
            ArrayList arrayList = new ArrayList(this.f8286c);
            int i2 = this.f8289f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ceb com_ushareit_listenit_ceb = (ceb) it.next();
                if (!this.f8288e || this.f8289f.get() != i2) {
                    break;
                } else if (this.f8286c.contains(com_ushareit_listenit_ceb)) {
                    com_ushareit_listenit_ceb.mo1956a(i);
                }
            }
            this.f8284a.clear();
            this.f8290g = false;
        }
    }

    public void m11214a(Bundle bundle) {
        boolean z = true;
        cfi.m11086a(Looper.myLooper() == this.f8291h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f8292i) {
            cfi.m11085a(!this.f8290g);
            this.f8291h.removeMessages(1);
            this.f8290g = true;
            if (this.f8284a.size() != 0) {
                z = false;
            }
            cfi.m11085a(z);
            ArrayList arrayList = new ArrayList(this.f8286c);
            int i = this.f8289f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ceb com_ushareit_listenit_ceb = (ceb) it.next();
                if (!this.f8288e || !this.f8285b.mo2006h() || this.f8289f.get() != i) {
                    break;
                } else if (!this.f8284a.contains(com_ushareit_listenit_ceb)) {
                    com_ushareit_listenit_ceb.mo1957a(bundle);
                }
            }
            this.f8284a.clear();
            this.f8290g = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11215a(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r2 = r5.f8291h;
        r2 = r2.getLooper();
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r2 = "onConnectionFailure must only be called on the Handler thread";
        com.ushareit.listenit.cfi.m11086a(r0, r2);
        r0 = r5.f8291h;
        r0.removeMessages(r1);
        r1 = r5.f8292i;
        monitor-enter(r1);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0054 }
        r2 = r5.f8287d;	 Catch:{ all -> 0x0054 }
        r0.<init>(r2);	 Catch:{ all -> 0x0054 }
        r2 = r5.f8289f;	 Catch:{ all -> 0x0054 }
        r2 = r2.get();	 Catch:{ all -> 0x0054 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0054 }
    L_0x002c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0032:
        r0 = r3.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.ushareit.listenit.cec) r0;	 Catch:{ all -> 0x0054 }
        r4 = r5.f8288e;	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r4 = r5.f8289f;	 Catch:{ all -> 0x0054 }
        r4 = r4.get();	 Catch:{ all -> 0x0054 }
        if (r4 == r2) goto L_0x0048;
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x000e;
    L_0x0048:
        r4 = r5.f8287d;	 Catch:{ all -> 0x0054 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x002c;
    L_0x0050:
        r0.mo1954a(r6);	 Catch:{ all -> 0x0054 }
        goto L_0x002c;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.chd.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public void m11216a(ceb com_ushareit_listenit_ceb) {
        cfi.m11080a((Object) com_ushareit_listenit_ceb);
        synchronized (this.f8292i) {
            if (this.f8286c.contains(com_ushareit_listenit_ceb)) {
                String valueOf = String.valueOf(com_ushareit_listenit_ceb);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f8286c.add(com_ushareit_listenit_ceb);
            }
        }
        if (this.f8285b.mo2006h()) {
            this.f8291h.sendMessage(this.f8291h.obtainMessage(1, com_ushareit_listenit_ceb));
        }
    }

    public void m11217a(cec com_ushareit_listenit_cec) {
        cfi.m11080a((Object) com_ushareit_listenit_cec);
        synchronized (this.f8292i) {
            if (this.f8287d.contains(com_ushareit_listenit_cec)) {
                String valueOf = String.valueOf(com_ushareit_listenit_cec);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f8287d.add(com_ushareit_listenit_cec);
            }
        }
    }

    public void m11218b() {
        this.f8288e = true;
    }

    public void m11219b(ceb com_ushareit_listenit_ceb) {
        cfi.m11080a((Object) com_ushareit_listenit_ceb);
        synchronized (this.f8292i) {
            if (!this.f8286c.remove(com_ushareit_listenit_ceb)) {
                String valueOf = String.valueOf(com_ushareit_listenit_ceb);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found").toString());
            } else if (this.f8290g) {
                this.f8284a.add(com_ushareit_listenit_ceb);
            }
        }
    }

    public void m11220b(cec com_ushareit_listenit_cec) {
        cfi.m11080a((Object) com_ushareit_listenit_cec);
        synchronized (this.f8292i) {
            if (!this.f8287d.remove(com_ushareit_listenit_cec)) {
                String valueOf = String.valueOf(com_ushareit_listenit_cec);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            ceb com_ushareit_listenit_ceb = (ceb) message.obj;
            synchronized (this.f8292i) {
                if (this.f8288e && this.f8285b.mo2006h() && this.f8286c.contains(com_ushareit_listenit_ceb)) {
                    com_ushareit_listenit_ceb.mo1957a(this.f8285b.mo2007t());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
