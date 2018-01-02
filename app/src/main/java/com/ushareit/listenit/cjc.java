package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;

class cjc {
    private static Context f8363a;

    static synchronized void m11428a(Context context) {
        synchronized (cjc.class) {
            if (f8363a != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f8363a = context.getApplicationContext();
            }
        }
    }
}
