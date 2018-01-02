package com.ushareit.listenit;

import android.util.Log;

public abstract class cfx<TListener> {
    private TListener f8222a;
    private boolean f8223b = false;
    final /* synthetic */ cfs f8224d;

    public cfx(cfs com_ushareit_listenit_cfs, TListener tListener) {
        this.f8224d = com_ushareit_listenit_cfs;
        this.f8222a = tListener;
    }

    protected abstract void mo1304a(TListener tListener);

    protected abstract void mo1305b();

    public void m11121c() {
        synchronized (this) {
            Object obj = this.f8222a;
            if (this.f8223b) {
                String valueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (obj != null) {
            try {
                mo1304a(obj);
            } catch (RuntimeException e) {
                mo1305b();
                throw e;
            }
        }
        mo1305b();
        synchronized (this) {
            this.f8223b = true;
        }
        m11122d();
    }

    public void m11122d() {
        m11123e();
        synchronized (this.f8224d.f8063r) {
            this.f8224d.f8063r.remove(this);
        }
    }

    public void m11123e() {
        synchronized (this) {
            this.f8222a = null;
        }
    }
}
