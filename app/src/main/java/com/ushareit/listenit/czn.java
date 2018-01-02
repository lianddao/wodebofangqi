package com.ushareit.listenit;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class czn {
    private static final czn f9426a = new czn();
    private final Map<Object, czo> f9427b = new HashMap();
    private final Object f9428c = new Object();

    private czn() {
    }

    public static czn m13514a() {
        return f9426a;
    }

    public void m13515a(Activity activity, Object obj, Runnable runnable) {
        synchronized (this.f9428c) {
            czo com_ushareit_listenit_czo = new czo(activity, runnable, obj);
            czp.m13529a(activity).m13531a(com_ushareit_listenit_czo);
            this.f9427b.put(obj, com_ushareit_listenit_czo);
        }
    }

    public void m13516a(Object obj) {
        synchronized (this.f9428c) {
            czo com_ushareit_listenit_czo = (czo) this.f9427b.get(obj);
            if (com_ushareit_listenit_czo != null) {
                czp.m13529a(com_ushareit_listenit_czo.m13517a()).m13532b(com_ushareit_listenit_czo);
            }
        }
    }
}
