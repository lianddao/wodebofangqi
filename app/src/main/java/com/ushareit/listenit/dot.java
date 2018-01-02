package com.ushareit.listenit;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

public class dot<R extends ceg> extends cek<R> implements ceh<R> {
    private cej<? super R, ? extends ceg> f10103a;
    private dot<? extends ceg> f10104b;
    private volatile cei<? super R> f10105c;
    private ced<R> f10106d;
    private final Object f10107e;
    private Status f10108f;
    private final WeakReference<cdz> f10109g;
    private final dov f10110h;
    private boolean f10111i;

    private void m15188a(Status status) {
        synchronized (this.f10107e) {
            this.f10108f = status;
            m15193b(this.f10108f);
        }
    }

    private void m15192b() {
        if (this.f10103a != null || this.f10105c != null) {
            cdz com_ushareit_listenit_cdz = (cdz) this.f10109g.get();
            if (!(this.f10111i || this.f10103a == null || com_ushareit_listenit_cdz == null)) {
                com_ushareit_listenit_cdz.mo1999a(this);
                this.f10111i = true;
            }
            if (this.f10108f != null) {
                m15193b(this.f10108f);
            } else if (this.f10106d != null) {
                this.f10106d.mo1272a(this);
            }
        }
    }

    private void m15193b(Status status) {
        synchronized (this.f10107e) {
            if (this.f10103a != null) {
                Status a = this.f10103a.m10969a(status);
                cfi.m11081a((Object) a, (Object) "onFailure must not return null");
                this.f10104b.m15188a(a);
            } else if (m15196c()) {
                this.f10105c.m10967a(status);
            }
        }
    }

    private void m15194b(ceg com_ushareit_listenit_ceg) {
        if (com_ushareit_listenit_ceg instanceof cef) {
            try {
                ((cef) com_ushareit_listenit_ceg).mo1297a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(com_ushareit_listenit_ceg);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean m15196c() {
        return (this.f10105c == null || ((cdz) this.f10109g.get()) == null) ? false : true;
    }

    void m15199a() {
        this.f10105c = null;
    }

    public void m15200a(ced<?> com_ushareit_listenit_ced_) {
        synchronized (this.f10107e) {
            this.f10106d = com_ushareit_listenit_ced_;
            m15192b();
        }
    }

    public void mo2008a(R r) {
        synchronized (this.f10107e) {
            if (!r.mo260b().m2257f()) {
                m15188a(r.mo260b());
                m15194b((ceg) r);
            } else if (this.f10103a != null) {
                dom.m15166a().submit(new dou(this, r));
            } else if (m15196c()) {
                this.f10105c.m10968b(r);
            }
        }
    }
}
