package com.ushareit.listenit;

import android.util.SparseArray;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class fau extends ScheduledThreadPoolExecutor {
    private static boolean f12349a = false;
    private static SparseArray<String> f12350b;

    static {
        f12350b = null;
        if (f12349a) {
            f12350b = new SparseArray();
        }
    }

    public fau(int i) {
        super(i);
    }

    public Future<?> mo2346a(Runnable runnable, long j, int i, String str) {
        if (f12349a && str != null) {
            f12350b.put(i, str);
        }
        return super.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    protected void m18742a(int i) {
        if (f12349a) {
            exu.m18430a(f12350b);
            exw.m18443a("TaskHelper", "before execute: " + ((String) f12350b.get(i)));
        }
    }

    protected void m18743a(int i, Throwable th) {
        if (f12349a) {
            exu.m18430a(f12350b);
            String str = (String) f12350b.get(i);
            exw.m18443a("TaskHelper", "before execute: " + str);
            if (th != null) {
                exw.m18456d("TaskHelper", "after execute: " + str + ", e = " + th.toString());
            } else {
                exw.m18443a("TaskHelper", "after execute: " + str);
            }
            f12350b.delete(i);
        }
    }
}
