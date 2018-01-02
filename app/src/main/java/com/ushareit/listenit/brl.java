package com.ushareit.listenit;

import java.util.Arrays;

public final class brl implements bra {
    private final boolean f7511a;
    private final int f7512b;
    private final byte[] f7513c;
    private final bqz[] f7514d;
    private int f7515e;
    private int f7516f;
    private int f7517g;
    private bqz[] f7518h;

    public brl(boolean z, int i) {
        this(z, i, 0);
    }

    public brl(boolean z, int i, int i2) {
        boolean z2;
        int i3 = 0;
        bsg.m9656a(i > 0);
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        bsg.m9656a(z2);
        this.f7511a = z;
        this.f7512b = i;
        this.f7517g = i2;
        this.f7518h = new bqz[(i2 + 100)];
        if (i2 > 0) {
            this.f7513c = new byte[(i2 * i)];
            while (i3 < i2) {
                this.f7518h[i3] = new bqz(this.f7513c, i3 * i);
                i3++;
            }
        } else {
            this.f7513c = null;
        }
        this.f7514d = new bqz[1];
    }

    public synchronized void m9589d() {
        if (this.f7511a) {
            m9584a(0);
        }
    }

    public synchronized void m9584a(int i) {
        Object obj = i < this.f7515e ? 1 : null;
        this.f7515e = i;
        if (obj != null) {
            mo1093b();
        }
    }

    public synchronized bqz mo1090a() {
        bqz com_ushareit_listenit_bqz;
        this.f7516f++;
        if (this.f7517g > 0) {
            bqz[] com_ushareit_listenit_bqzArr = this.f7518h;
            int i = this.f7517g - 1;
            this.f7517g = i;
            com_ushareit_listenit_bqz = com_ushareit_listenit_bqzArr[i];
            this.f7518h[this.f7517g] = null;
        } else {
            com_ushareit_listenit_bqz = new bqz(new byte[this.f7512b], 0);
        }
        return com_ushareit_listenit_bqz;
    }

    public synchronized void mo1091a(bqz com_ushareit_listenit_bqz) {
        this.f7514d[0] = com_ushareit_listenit_bqz;
        mo1092a(this.f7514d);
    }

    public synchronized void mo1092a(bqz[] com_ushareit_listenit_bqzArr) {
        if (this.f7517g + com_ushareit_listenit_bqzArr.length >= this.f7518h.length) {
            this.f7518h = (bqz[]) Arrays.copyOf(this.f7518h, Math.max(this.f7518h.length * 2, this.f7517g + com_ushareit_listenit_bqzArr.length));
        }
        for (bqz com_ushareit_listenit_bqz : com_ushareit_listenit_bqzArr) {
            boolean z;
            if (com_ushareit_listenit_bqz.f7480a == this.f7513c || com_ushareit_listenit_bqz.f7480a.length == this.f7512b) {
                z = true;
            } else {
                z = false;
            }
            bsg.m9656a(z);
            bqz[] com_ushareit_listenit_bqzArr2 = this.f7518h;
            int i = this.f7517g;
            this.f7517g = i + 1;
            com_ushareit_listenit_bqzArr2[i] = com_ushareit_listenit_bqz;
        }
        this.f7516f -= com_ushareit_listenit_bqzArr.length;
        notifyAll();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo1093b() {
        /*
        r7 = this;
        r1 = 0;
        monitor-enter(r7);
        r0 = r7.f7515e;	 Catch:{ all -> 0x005e }
        r2 = r7.f7512b;	 Catch:{ all -> 0x005e }
        r0 = com.ushareit.listenit.btc.m9760a(r0, r2);	 Catch:{ all -> 0x005e }
        r2 = 0;
        r3 = r7.f7516f;	 Catch:{ all -> 0x005e }
        r0 = r0 - r3;
        r3 = java.lang.Math.max(r2, r0);	 Catch:{ all -> 0x005e }
        r0 = r7.f7517g;	 Catch:{ all -> 0x005e }
        if (r3 < r0) goto L_0x0018;
    L_0x0016:
        monitor-exit(r7);
        return;
    L_0x0018:
        r0 = r7.f7513c;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0061;
    L_0x001c:
        r0 = r7.f7517g;	 Catch:{ all -> 0x005e }
        r0 = r0 + -1;
    L_0x0020:
        if (r1 > r0) goto L_0x004b;
    L_0x0022:
        r2 = r7.f7518h;	 Catch:{ all -> 0x005e }
        r4 = r2[r1];	 Catch:{ all -> 0x005e }
        r2 = r4.f7480a;	 Catch:{ all -> 0x005e }
        r5 = r7.f7513c;	 Catch:{ all -> 0x005e }
        if (r2 != r5) goto L_0x002f;
    L_0x002c:
        r1 = r1 + 1;
        goto L_0x0020;
    L_0x002f:
        r2 = r7.f7518h;	 Catch:{ all -> 0x005e }
        r5 = r2[r0];	 Catch:{ all -> 0x005e }
        r2 = r5.f7480a;	 Catch:{ all -> 0x005e }
        r6 = r7.f7513c;	 Catch:{ all -> 0x005e }
        if (r2 == r6) goto L_0x003c;
    L_0x0039:
        r0 = r0 + -1;
        goto L_0x0020;
    L_0x003c:
        r6 = r7.f7518h;	 Catch:{ all -> 0x005e }
        r2 = r1 + 1;
        r6[r1] = r5;	 Catch:{ all -> 0x005e }
        r5 = r7.f7518h;	 Catch:{ all -> 0x005e }
        r1 = r0 + -1;
        r5[r0] = r4;	 Catch:{ all -> 0x005e }
        r0 = r1;
        r1 = r2;
        goto L_0x0020;
    L_0x004b:
        r0 = java.lang.Math.max(r3, r1);	 Catch:{ all -> 0x005e }
        r1 = r7.f7517g;	 Catch:{ all -> 0x005e }
        if (r0 >= r1) goto L_0x0016;
    L_0x0053:
        r1 = r7.f7518h;	 Catch:{ all -> 0x005e }
        r2 = r7.f7517g;	 Catch:{ all -> 0x005e }
        r3 = 0;
        java.util.Arrays.fill(r1, r0, r2, r3);	 Catch:{ all -> 0x005e }
        r7.f7517g = r0;	 Catch:{ all -> 0x005e }
        goto L_0x0016;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x0061:
        r0 = r3;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.brl.b():void");
    }

    public synchronized int m9590e() {
        return this.f7516f * this.f7512b;
    }

    public int mo1094c() {
        return this.f7512b;
    }
}
