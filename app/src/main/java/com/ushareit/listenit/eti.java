package com.ushareit.listenit;

import android.os.Looper;
import java.lang.Thread.UncaughtExceptionHandler;

class eti implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f11778a = Thread.getDefaultUncaughtExceptionHandler();
    private final etj f11779b;

    public static void m17894a(etj com_ushareit_listenit_etj) {
        Thread.setDefaultUncaughtExceptionHandler(new eti(com_ushareit_listenit_etj));
    }

    private eti(etj com_ushareit_listenit_etj) {
        this.f11779b = com_ushareit_listenit_etj;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f11779b != null) {
            this.f11779b.mo2296a(thread, th);
        }
        if (m17895a(thread, th)) {
            if (this.f11779b != null) {
                this.f11779b.mo2297a(th);
            }
        } else if (m17896b(thread, th)) {
            if (this.f11779b != null) {
                this.f11779b.mo2297a(new Exception("UIException background:" + th.getMessage(), th));
            }
            System.exit(1);
        } else {
            this.f11778a.uncaughtException(thread, th);
        }
    }

    private boolean m17895a(Thread thread, Throwable th) {
        return thread != Looper.getMainLooper().getThread();
    }

    private boolean m17896b(Thread thread, Throwable th) {
        return thread == Looper.getMainLooper().getThread() && fbj.m18782a(eys.m18562a()) == 0;
    }
}
