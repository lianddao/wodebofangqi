package com.ushareit.listenit;

public final class buf {
    private final Object f7768a = new Object();
    private bvc f7769b;
    private bug f7770c;

    public bvc m9878a() {
        bvc com_ushareit_listenit_bvc;
        synchronized (this.f7768a) {
            com_ushareit_listenit_bvc = this.f7769b;
        }
        return com_ushareit_listenit_bvc;
    }

    public void m9879a(bug com_ushareit_listenit_bug) {
        cfi.m11081a((Object) com_ushareit_listenit_bug, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f7768a) {
            this.f7770c = com_ushareit_listenit_bug;
            if (this.f7769b == null) {
                return;
            }
            try {
                this.f7769b.mo1107a(new bvz(com_ushareit_listenit_bug));
            } catch (Throwable e) {
                bze.m10489b("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public void m9880a(bvc com_ushareit_listenit_bvc) {
        synchronized (this.f7768a) {
            this.f7769b = com_ushareit_listenit_bvc;
            if (this.f7770c != null) {
                m9879a(this.f7770c);
            }
        }
    }

    public boolean m9881b() {
        boolean z;
        synchronized (this.f7768a) {
            z = this.f7769b != null;
        }
        return z;
    }
}
