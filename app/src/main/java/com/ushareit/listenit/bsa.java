package com.ushareit.listenit;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class bsa {
    private final ExecutorService f7588a;
    private bsc<? extends bsd> f7589b;
    private IOException f7590c;

    public bsa(String str) {
        this.f7588a = btc.m9767a(str);
    }

    public <T extends bsd> long m9641a(T t, bsb<T> com_ushareit_listenit_bsb_T, int i) {
        Looper myLooper = Looper.myLooper();
        bsg.m9658b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new bsc(this, myLooper, t, com_ushareit_listenit_bsb_T, i, elapsedRealtime).m9651a(0);
        return elapsedRealtime;
    }

    public boolean m9644a() {
        return this.f7589b != null;
    }

    public void m9645b() {
        this.f7589b.m9652a(false);
    }

    public void m9643a(Runnable runnable) {
        if (this.f7589b != null) {
            this.f7589b.m9652a(true);
        }
        if (runnable != null) {
            this.f7588a.submit(runnable);
        }
        this.f7588a.shutdown();
    }

    public void m9646c() {
        m9642a(Integer.MIN_VALUE);
    }

    public void m9642a(int i) {
        if (this.f7590c != null) {
            throw this.f7590c;
        } else if (this.f7589b != null) {
            bsc com_ushareit_listenit_bsc = this.f7589b;
            if (i == Integer.MIN_VALUE) {
                i = this.f7589b.f7591a;
            }
            com_ushareit_listenit_bsc.m9650a(i);
        }
    }
}
