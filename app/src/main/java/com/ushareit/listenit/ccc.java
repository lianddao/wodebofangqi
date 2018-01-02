package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ccc extends du<Void> implements doo {
    private Semaphore f8102o = new Semaphore(0);
    private Set<cdz> f8103p;

    public ccc(Context context, Set<cdz> set) {
        super(context);
        this.f8103p = set;
    }

    public /* synthetic */ Object mo1264d() {
        return m10776t();
    }

    protected void mo1265j() {
        this.f8102o.drainPermits();
        m10755l();
    }

    public Void m10776t() {
        int i = 0;
        for (cdz a : this.f8103p) {
            i = a.mo2000a((doo) this) ? i + 1 : i;
        }
        try {
            this.f8102o.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public void mo1266u() {
        this.f8102o.release();
    }
}
