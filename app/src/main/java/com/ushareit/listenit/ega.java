package com.ushareit.listenit;

import android.app.Activity;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

class ega<TListenerType, TResult extends efs> {
    private final Queue<TListenerType> f11018a = new ConcurrentLinkedQueue();
    private final HashMap<TListenerType, czu> f11019b = new HashMap();
    private efm<TResult> f11020c;
    private int f11021d;
    private egd<TListenerType, TResult> f11022e;

    public ega(efm<TResult> com_ushareit_listenit_efm_TResult, int i, egd<TListenerType, TResult> com_ushareit_listenit_egd_TListenerType__TResult) {
        this.f11020c = com_ushareit_listenit_efm_TResult;
        this.f11021d = i;
        this.f11022e = com_ushareit_listenit_egd_TListenerType__TResult;
    }

    public void m17051a() {
        if ((this.f11020c.m16940m() & this.f11021d) != 0) {
            efs o = this.f11020c.m16942o();
            for (Object next : this.f11018a) {
                czu com_ushareit_listenit_czu = (czu) this.f11019b.get(next);
                if (com_ushareit_listenit_czu != null) {
                    com_ushareit_listenit_czu.m13543a(new egc(this, next, o));
                }
            }
        }
    }

    public void m17052a(Activity activity, Executor executor, TListenerType tListenerType) {
        boolean z = true;
        cfi.m11080a((Object) tListenerType);
        synchronized (this.f11020c.m16941n()) {
            boolean z2 = (this.f11020c.m16940m() & this.f11021d) != 0;
            this.f11018a.add(tListenerType);
            this.f11019b.put(tListenerType, new czu(executor));
            if (activity != null) {
                if (VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed()) {
                        z = false;
                    }
                    cfi.m11090b(z, "Activity is already destroyed!");
                }
                czn.m13514a().m13515a(activity, tListenerType, new egb(this, tListenerType));
            }
        }
        if (z2) {
            this.f11022e.mo2157a(tListenerType, this.f11020c.m16942o());
        }
    }

    public void m17053a(TListenerType tListenerType) {
        cfi.m11080a((Object) tListenerType);
        synchronized (this.f11020c.m16941n()) {
            this.f11019b.remove(tListenerType);
            this.f11018a.remove(tListenerType);
            czn.m13514a().m13516a(tListenerType);
        }
    }
}
