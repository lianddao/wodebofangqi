package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;

public class rw implements qg {
    final /* synthetic */ RecyclerView f16436a;

    public rw(RecyclerView recyclerView) {
        this.f16436a = recyclerView;
    }

    public sv mo3054a(int i) {
        sv a = this.f16436a.m513a(i, true);
        if (a == null || this.f16436a.f350c.m25803c(a.itemView)) {
            return null;
        }
        return a;
    }

    public void mo3055a(int i, int i2) {
        this.f16436a.m519a(i, i2, true);
        this.f16436a.f354g = true;
        ss.m26187a(this.f16436a.f353f, i2);
    }

    public void mo3058b(int i, int i2) {
        this.f16436a.m519a(i, i2, false);
        this.f16436a.f354g = true;
    }

    public void mo3056a(int i, int i2, Object obj) {
        this.f16436a.m518a(i, i2, obj);
        this.f16436a.f355h = true;
    }

    public void mo3057a(qh qhVar) {
        m26024c(qhVar);
    }

    void m26024c(qh qhVar) {
        switch (qhVar.f16329a) {
            case 1:
                this.f16436a.f362q.mo51a(this.f16436a, qhVar.f16330b, qhVar.f16332d);
                return;
            case 2:
                this.f16436a.f362q.mo59b(this.f16436a, qhVar.f16330b, qhVar.f16332d);
                return;
            case 4:
                this.f16436a.f362q.mo53a(this.f16436a, qhVar.f16330b, qhVar.f16332d, qhVar.f16331c);
                return;
            case 8:
                this.f16436a.f362q.mo52a(this.f16436a, qhVar.f16330b, qhVar.f16332d, 1);
                return;
            default:
                return;
        }
    }

    public void mo3059b(qh qhVar) {
        m26024c(qhVar);
    }

    public void mo3060c(int i, int i2) {
        this.f16436a.m538e(i, i2);
        this.f16436a.f354g = true;
    }

    public void mo3061d(int i, int i2) {
        this.f16436a.m534d(i, i2);
        this.f16436a.f354g = true;
    }
}
