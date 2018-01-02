package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public final class faq {
    private static Handler f12329a = new far(Looper.getMainLooper());
    private static fau f12330b = new fau(1);
    private static fau f12331c = new fau(5);
    private static ExecutorService f12332d = Executors.newCachedThreadPool();
    private static ExecutorService f12333e = Executors.newCachedThreadPool();
    private static ExecutorService f12334f = Executors.newCachedThreadPool();
    private static ExecutorService f12335g = Executors.newCachedThreadPool();
    private static fav f12336h = new fav(2, 24);
    private static fav f12337i = new fav(2, 48);
    private static fav f12338j = new fav(1, 48);
    private static fau f12339k = new fau(1);
    private static fau f12340l = new fau(5);

    public static fay m18735a(fay com_ushareit_listenit_fay) {
        return m18734a(fat.MULTIPLE, com_ushareit_listenit_fay, 0, 0, null);
    }

    public static fay m18734a(fat com_ushareit_listenit_fat, fay com_ushareit_listenit_fay, long j, long j2, String str) {
        boolean z = false;
        exu.m18430a((Object) com_ushareit_listenit_fay);
        boolean z2 = j >= 0 && j2 >= 0;
        exu.m18433a(z2);
        eyo com_ushareit_listenit_eyo = new eyo(com_ushareit_listenit_fay);
        if (com_ushareit_listenit_fat == fat.SINGLE) {
            z = true;
        }
        com_ushareit_listenit_fay.f11677c = z;
        if (!(com_ushareit_listenit_fay instanceof faz)) {
            try {
                fau com_ushareit_listenit_fau = com_ushareit_listenit_fay.f11677c ? f12330b : com_ushareit_listenit_fat == fat.PLOADER ? f12336h : com_ushareit_listenit_fat == fat.OLOADER ? f12337i : f12331c;
                com_ushareit_listenit_fay.f11678d = com_ushareit_listenit_fau.mo2346a(new fas(com_ushareit_listenit_eyo, com_ushareit_listenit_fau, j2), j, com_ushareit_listenit_fay.f11676b, str);
                return com_ushareit_listenit_fay;
            } catch (RejectedExecutionException e) {
                exw.m18456d("TaskHelper", e.toString());
                return null;
            }
        } else if (com_ushareit_listenit_fay.m17707b()) {
            return com_ushareit_listenit_fay;
        } else {
            if (j2 == 0 && Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    com_ushareit_listenit_fay.mo2281a(null);
                    return com_ushareit_listenit_fay;
                } catch (Exception e2) {
                    return com_ushareit_listenit_fay;
                } catch (Throwable th) {
                    esr.m17813a(eys.m18562a(), th);
                    exw.m18452b("TaskHelper", th);
                    return com_ushareit_listenit_fay;
                }
            }
            f12329a.sendMessageDelayed(f12329a.obtainMessage(1, com_ushareit_listenit_eyo), j2 + j);
            return com_ushareit_listenit_fay;
        }
    }

    public static void m18736a(faw com_ushareit_listenit_faw) {
        exu.m18430a((Object) com_ushareit_listenit_faw);
        try {
            f12333e.submit(com_ushareit_listenit_faw.m17794b());
        } catch (RejectedExecutionException e) {
            exw.m18456d("TaskHelper", e.toString());
        }
    }

    public static void m18738b(faw com_ushareit_listenit_faw) {
        exu.m18430a((Object) com_ushareit_listenit_faw);
        try {
            f12339k.submit(com_ushareit_listenit_faw.m17794b());
        } catch (RejectedExecutionException e) {
            exw.m18456d("TaskHelper", e.toString());
        }
    }
}
