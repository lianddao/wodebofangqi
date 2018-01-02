package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class anj {
    private static final String f4931a = anj.class.getSimpleName();
    private static anj f4932b;
    private final Future<ara> f4933c;

    private anj(Context context) {
        this.f4933c = Executors.newSingleThreadExecutor().submit(new ank(this, context));
    }

    public static anj m6384a(Context context) {
        if (f4932b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f4932b == null) {
                    f4932b = new anj(applicationContext);
                }
            }
        }
        return f4932b;
    }

    private ara m6385a() {
        Throwable e;
        try {
            return (ara) this.f4933c.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        } catch (TimeoutException e4) {
            e = e4;
        }
        Log.e(f4931a, "Timed out waiting for cache server.", e);
        return null;
    }

    public void m6386a(String str) {
        ara a = m6385a();
        if (a != null) {
            a.m6875a(str);
        }
    }

    public String m6387b(String str) {
        ara a = m6385a();
        return a == null ? null : a.m6876b(str);
    }
}
