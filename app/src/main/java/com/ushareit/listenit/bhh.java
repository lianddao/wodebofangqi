package com.ushareit.listenit;

import java.util.LinkedList;

public abstract class bhh<I extends bhf, O extends bhg, E extends Exception> implements bhd<I, O, E> {
    private final Thread f6326a;
    private final Object f6327b = new Object();
    private final LinkedList<I> f6328c = new LinkedList();
    private final LinkedList<O> f6329d = new LinkedList();
    private final I[] f6330e;
    private final O[] f6331f;
    private int f6332g;
    private int f6333h;
    private I f6334i;
    private E f6335j;
    private boolean f6336k;
    private boolean f6337l;
    private int f6338m;

    protected abstract E mo1056a(I i, O o, boolean z);

    protected abstract I mo1059g();

    protected abstract O mo1060h();

    public /* synthetic */ Object mo952a() {
        return m8418e();
    }

    public /* synthetic */ Object mo954b() {
        return m8419f();
    }

    protected bhh(I[] iArr, O[] oArr) {
        int i = 0;
        this.f6330e = iArr;
        this.f6332g = iArr.length;
        for (int i2 = 0; i2 < this.f6332g; i2++) {
            this.f6330e[i2] = mo1059g();
        }
        this.f6331f = oArr;
        this.f6333h = oArr.length;
        while (i < this.f6333h) {
            this.f6331f[i] = mo1060h();
            i++;
        }
        this.f6326a = new bhi(this);
        this.f6326a.start();
    }

    protected final void m8411a(int i) {
        boolean z;
        int i2 = 0;
        if (this.f6332g == this.f6330e.length) {
            z = true;
        } else {
            z = false;
        }
        bsg.m9658b(z);
        bhf[] com_ushareit_listenit_bhfArr = this.f6330e;
        int length = com_ushareit_listenit_bhfArr.length;
        while (i2 < length) {
            com_ushareit_listenit_bhfArr[i2].m8400e(i);
            i2++;
        }
    }

    public final I m8418e() {
        I i;
        synchronized (this.f6327b) {
            bhf com_ushareit_listenit_bhf;
            mo1061i();
            bsg.m9658b(this.f6334i == null);
            if (this.f6332g == 0) {
                com_ushareit_listenit_bhf = null;
            } else {
                bhf[] com_ushareit_listenit_bhfArr = this.f6330e;
                int i2 = this.f6332g - 1;
                this.f6332g = i2;
                com_ushareit_listenit_bhf = com_ushareit_listenit_bhfArr[i2];
            }
            this.f6334i = com_ushareit_listenit_bhf;
            i = this.f6334i;
        }
        return i;
    }

    public final void m8412a(I i) {
        synchronized (this.f6327b) {
            mo1061i();
            bsg.m9656a(i == this.f6334i);
            this.f6328c.addLast(i);
            mo1062j();
            this.f6334i = null;
        }
    }

    public final O m8419f() {
        O o;
        synchronized (this.f6327b) {
            mo1061i();
            if (this.f6329d.isEmpty()) {
                o = null;
            } else {
                bhg com_ushareit_listenit_bhg = (bhg) this.f6329d.removeFirst();
            }
        }
        return o;
    }

    protected void mo1058a(O o) {
        synchronized (this.f6327b) {
            m8403b((bhg) o);
            mo1062j();
        }
    }

    public final void mo955c() {
        synchronized (this.f6327b) {
            this.f6336k = true;
            this.f6338m = 0;
            if (this.f6334i != null) {
                m8402b(this.f6334i);
                this.f6334i = null;
            }
            while (!this.f6328c.isEmpty()) {
                m8402b((bhf) this.f6328c.removeFirst());
            }
            while (!this.f6329d.isEmpty()) {
                m8403b((bhg) this.f6329d.removeFirst());
            }
        }
    }

    public void mo956d() {
        synchronized (this.f6327b) {
            this.f6337l = true;
            this.f6327b.notify();
        }
        try {
            this.f6326a.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void mo1061i() {
        if (this.f6335j != null) {
            throw this.f6335j;
        }
    }

    private void mo1062j() {
        if (m8408m()) {
            this.f6327b.notify();
        }
    }

    private void m8406k() {
        do {
            try {
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } while (m8407l());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m8407l() {
        /*
        r6 = this;
        r1 = 0;
        r2 = r6.f6327b;
        monitor-enter(r2);
    L_0x0004:
        r0 = r6.f6337l;	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r0 = r6.m8408m();	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x000e:
        r0 = r6.f6327b;	 Catch:{ all -> 0x0014 }
        r0.wait();	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r0 = r6.f6337l;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r0 = r1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = r6.f6328c;	 Catch:{ all -> 0x0014 }
        r0 = r0.removeFirst();	 Catch:{ all -> 0x0014 }
        r0 = (com.ushareit.listenit.bhf) r0;	 Catch:{ all -> 0x0014 }
        r3 = r6.f6331f;	 Catch:{ all -> 0x0014 }
        r4 = r6.f6333h;	 Catch:{ all -> 0x0014 }
        r4 = r4 + -1;
        r6.f6333h = r4;	 Catch:{ all -> 0x0014 }
        r3 = r3[r4];	 Catch:{ all -> 0x0014 }
        r4 = r6.f6336k;	 Catch:{ all -> 0x0014 }
        r5 = 0;
        r6.f6336k = r5;	 Catch:{ all -> 0x0014 }
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r2 = r0.m8384c();
        if (r2 == 0) goto L_0x0050;
    L_0x003c:
        r1 = 4;
        r3.m8382b(r1);
    L_0x0040:
        r1 = r6.f6327b;
        monitor-enter(r1);
        r2 = r6.f6336k;	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x006e;
    L_0x0047:
        r6.m8403b(r3);	 Catch:{ all -> 0x007e }
    L_0x004a:
        r6.m8402b(r0);	 Catch:{ all -> 0x007e }
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        r0 = 1;
        goto L_0x001d;
    L_0x0050:
        r2 = r0.b_();
        if (r2 == 0) goto L_0x005b;
    L_0x0056:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3.m8382b(r2);
    L_0x005b:
        r2 = r6.mo1056a(r0, r3, r4);
        r6.f6335j = r2;
        r2 = r6.f6335j;
        if (r2 == 0) goto L_0x0040;
    L_0x0065:
        r2 = r6.f6327b;
        monitor-enter(r2);
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        r0 = r1;
        goto L_0x001d;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r2 = r3.b_();	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x0081;
    L_0x0074:
        r2 = r6.f6338m;	 Catch:{ all -> 0x007e }
        r2 = r2 + 1;
        r6.f6338m = r2;	 Catch:{ all -> 0x007e }
        r6.m8403b(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        throw r0;
    L_0x0081:
        r2 = r6.f6338m;	 Catch:{ all -> 0x007e }
        r3.f6325b = r2;	 Catch:{ all -> 0x007e }
        r2 = 0;
        r6.f6338m = r2;	 Catch:{ all -> 0x007e }
        r2 = r6.f6329d;	 Catch:{ all -> 0x007e }
        r2.addLast(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bhh.l():boolean");
    }

    private boolean m8408m() {
        return !this.f6328c.isEmpty() && this.f6333h > 0;
    }

    private void m8402b(I i) {
        i.mo951a();
        bhf[] com_ushareit_listenit_bhfArr = this.f6330e;
        int i2 = this.f6332g;
        this.f6332g = i2 + 1;
        com_ushareit_listenit_bhfArr[i2] = i;
    }

    private void m8403b(O o) {
        o.mo951a();
        bhg[] com_ushareit_listenit_bhgArr = this.f6331f;
        int i = this.f6333h;
        this.f6333h = i + 1;
        com_ushareit_listenit_bhgArr[i] = o;
    }
}
