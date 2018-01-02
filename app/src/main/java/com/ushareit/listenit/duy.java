package com.ushareit.listenit;

abstract class duy extends dyt {
    private boolean f10365a;

    duy(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
        this.n.m16438a(this);
    }

    boolean m15694a() {
        return this.f10365a;
    }

    boolean m15695b() {
        return false;
    }

    protected void m15696c() {
        if (!m15694a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m15697d() {
        if (this.f10365a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo2080e();
        this.n.m16428J();
        this.f10365a = true;
    }

    protected abstract void mo2080e();
}
