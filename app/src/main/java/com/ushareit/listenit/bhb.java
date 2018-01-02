package com.ushareit.listenit;

public abstract class bhb {
    private int f6305a;

    public void mo951a() {
        this.f6305a = 0;
    }

    public final boolean b_() {
        return m8385d(Integer.MIN_VALUE);
    }

    public final boolean m8384c() {
        return m8385d(4);
    }

    public final void a_(int i) {
        this.f6305a = i;
    }

    public final void m8382b(int i) {
        this.f6305a |= i;
    }

    public final void m8383c(int i) {
        this.f6305a &= i ^ -1;
    }

    protected final boolean m8385d(int i) {
        return (this.f6305a & i) == i;
    }
}
