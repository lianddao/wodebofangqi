package com.ushareit.listenit;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class cqh {
    static final /* synthetic */ boolean f8710a = (!cqh.class.desiredAssertionStatus());
    private AtomicBoolean f8711b = new AtomicBoolean(false);
    private cqi f8712c;
    private boolean f8713d = false;

    public abstract cqh mo1580a(cvg com_ushareit_listenit_cvg);

    public abstract cuw mo1581a(cuv com_ushareit_listenit_cuv, cvg com_ushareit_listenit_cvg);

    public abstract cvg mo1582a();

    public void m12293a(cqi com_ushareit_listenit_cqi) {
        if (!f8710a && m12300c()) {
            throw new AssertionError();
        } else if (f8710a || this.f8712c == null) {
            this.f8712c = com_ushareit_listenit_cqi;
        } else {
            throw new AssertionError();
        }
    }

    public abstract void mo1583a(cuw com_ushareit_listenit_cuw);

    public abstract void mo1584a(ece com_ushareit_listenit_ece);

    public void m12296a(boolean z) {
        this.f8713d = z;
    }

    public abstract boolean mo1585a(cqh com_ushareit_listenit_cqh);

    public abstract boolean mo1586a(cuy com_ushareit_listenit_cuy);

    public void m12299b() {
        if (this.f8711b.compareAndSet(false, true) && this.f8712c != null) {
            this.f8712c.mo1588a(this);
            this.f8712c = null;
        }
    }

    public boolean m12300c() {
        return this.f8711b.get();
    }

    public boolean m12301d() {
        return this.f8713d;
    }
}
