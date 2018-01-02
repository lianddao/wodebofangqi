package com.ushareit.listenit;

import android.os.Build.VERSION;

public abstract class hgs {
    private hgv f15404a;
    private hgu f15405b;
    private hgt f15406c;
    private boolean f15407d = false;

    public abstract void mo2763a(float f);

    public abstract void mo2764a(int i);

    public abstract void mo2768a(String str);

    public abstract boolean mo2770a();

    public abstract boolean mo2771b();

    public abstract boolean mo2772c();

    public abstract int mo2773d();

    public abstract void mo2774e();

    public abstract void mo2775f();

    public abstract void mo2776g();

    public abstract float mo2777h();

    public abstract int mo2778i();

    public abstract int mo2779j();

    public abstract String mo2780k();

    public abstract boolean mo2781l();

    public void mo2767a(hgv com_ushareit_listenit_hgv) {
        this.f15404a = com_ushareit_listenit_hgv;
    }

    public void mo2766a(hgu com_ushareit_listenit_hgu) {
        this.f15405b = com_ushareit_listenit_hgu;
    }

    public void mo2765a(hgt com_ushareit_listenit_hgt) {
        this.f15406c = com_ushareit_listenit_hgt;
    }

    public void m23717b(boolean z) {
        if (this.f15406c != null) {
            this.f15406c.mo2471a(z);
        }
    }

    public void m23716b(int i) {
        if (this.f15405b != null) {
            this.f15405b.mo2470a(i);
        }
    }

    public void m23731n() {
        if (this.f15404a != null) {
            this.f15404a.mo2783a();
        }
    }

    public void m23719c(int i) {
        if (this.f15404a != null) {
            this.f15404a.mo2784a(i);
        }
    }

    public boolean mo2782m() {
        return this.f15407d && VERSION.SDK_INT >= 9;
    }

    public void mo2769a(boolean z) {
        this.f15407d = z;
    }
}
