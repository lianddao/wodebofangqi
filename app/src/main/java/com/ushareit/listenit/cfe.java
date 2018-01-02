package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class cfe {
    private static Object f8212a = new Object();
    private static boolean f8213b;
    private static String f8214c;
    private static int f8215d;

    public static String m11073a(Context context) {
        m11075c(context);
        return f8214c;
    }

    public static int m11074b(Context context) {
        m11075c(context);
        return f8215d;
    }

    private static void m11075c(Context context) {
        synchronized (f8212a) {
            if (f8213b) {
                return;
            }
            f8213b = true;
            try {
                Bundle bundle = dqc.m15265b(context).m15261a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f8214c = bundle.getString("com.google.app.id");
                f8215d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
