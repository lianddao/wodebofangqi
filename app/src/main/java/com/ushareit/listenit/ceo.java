package com.ushareit.listenit;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ceo<O extends cdk> {
    private final Context f8186a;
    private final doj f8187b;
    private final cdj<O> f8188c;
    private final O f8189d;
    private final dlp<O> f8190e;
    private final Looper f8191f;
    private final int f8192g;
    private final dnn f8193h;
    private final cdz f8194i;
    private final AtomicBoolean f8195j;
    private final AtomicInteger f8196k;
    private cdt f8197l;

    public ceo(Context context, cdj<O> com_ushareit_listenit_cdj_O, O o) {
        this(context, com_ushareit_listenit_cdj_O, o, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
    }

    public ceo(Context context, cdj<O> com_ushareit_listenit_cdj_O, O o, Looper looper) {
        this.f8195j = new AtomicBoolean(false);
        this.f8196k = new AtomicInteger(0);
        cfi.m11081a((Object) context, (Object) "Null context is not permitted.");
        cfi.m11081a((Object) com_ushareit_listenit_cdj_O, (Object) "Api must not be null.");
        cfi.m11081a((Object) looper, (Object) "Looper must not be null.");
        this.f8186a = context.getApplicationContext();
        this.f8188c = com_ushareit_listenit_cdj_O;
        this.f8189d = o;
        this.f8191f = looper;
        this.f8187b = new doj();
        this.f8190e = dlp.m14789a(this.f8188c, this.f8189d);
        this.f8194i = new dnt(this);
        Pair a = dnn.m15068a(this.f8186a, this);
        this.f8193h = (dnn) a.first;
        this.f8192g = ((Integer) a.second).intValue();
    }

    private <A extends cdq, T extends dlu<? extends ceg, A>> T m10972a(int i, T t) {
        t.m10800i();
        this.f8193h.m15089a(this, i, (dlu) t);
        return t;
    }

    private <TResult, A extends cdq> dzo<TResult> m10973a(int i, dos<A, TResult> com_ushareit_listenit_dos_A__TResult) {
        dzp com_ushareit_listenit_dzp = new dzp();
        this.f8193h.m15090a(this, i, com_ushareit_listenit_dos_A__TResult, com_ushareit_listenit_dzp);
        return com_ushareit_listenit_dzp.m16566a();
    }

    public cdt m10974a(Looper looper, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        if (!m10982d()) {
            if (this.f8188c.m10912e()) {
                cdw c = this.f8188c.m10910c();
                this.f8197l = new cfn(this.f8186a, looper, c.m10918b(), com_ushareit_listenit_ceb, com_ushareit_listenit_cec, cgs.m11177a(this.f8186a), c.m10919b(this.f8189d));
            } else {
                this.f8197l = this.f8188c.m10909b().mo1238a(this.f8186a, looper, cgs.m11177a(this.f8186a), this.f8189d, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
            }
        }
        return this.f8197l;
    }

    public <A extends cdq, T extends dlu<? extends ceg, A>> T m10975a(T t) {
        return m10972a(0, (dlu) t);
    }

    public <TResult, A extends cdq> dzo<TResult> m10976a(dos<A, TResult> com_ushareit_listenit_dos_A__TResult) {
        return m10973a(0, (dos) com_ushareit_listenit_dos_A__TResult);
    }

    public void m10977a() {
        boolean z = true;
        if (!this.f8195j.getAndSet(true)) {
            this.f8187b.m15163a();
            dnn com_ushareit_listenit_dnn = this.f8193h;
            int i = this.f8192g;
            if (this.f8196k.get() <= 0) {
                z = false;
            }
            com_ushareit_listenit_dnn.m15088a(i, z);
        }
    }

    public <A extends cdq, T extends dlu<? extends ceg, A>> T m10978b(T t) {
        return m10972a(1, (dlu) t);
    }

    public <TResult, A extends cdq> dzo<TResult> m10979b(dos<A, TResult> com_ushareit_listenit_dos_A__TResult) {
        return m10973a(1, (dos) com_ushareit_listenit_dos_A__TResult);
    }

    public void m10980b() {
        this.f8196k.incrementAndGet();
    }

    public void m10981c() {
        if (this.f8196k.decrementAndGet() == 0 && this.f8195j.get()) {
            this.f8193h.m15088a(this.f8192g, false);
        }
    }

    public boolean m10982d() {
        return this.f8197l != null;
    }

    public dlp<O> m10983e() {
        return this.f8190e;
    }

    public int m10984f() {
        return this.f8192g;
    }

    public cdz m10985g() {
        return this.f8194i;
    }

    public Looper m10986h() {
        return this.f8191f;
    }
}
