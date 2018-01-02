package com.ushareit.listenit;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class chf {
    private static final Object f8293a = new Object();
    private static chf f8294b;

    public static chf m11221a(Context context) {
        synchronized (f8293a) {
            if (f8294b == null) {
                f8294b = new chg(context.getApplicationContext());
            }
        }
        return f8294b;
    }

    public abstract boolean mo1320a(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void mo1321b(String str, String str2, ServiceConnection serviceConnection, String str3);
}
