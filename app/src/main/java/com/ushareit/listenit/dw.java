package com.ushareit.listenit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.TypedValue;

public class dw {
    private static final Object f10454a = new Object();
    private static TypedValue f10455b;

    public static final Drawable m15879a(Context context, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            return dx.m16168a(context, i);
        }
        if (i2 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f10454a) {
            if (f10455b == null) {
                f10455b = new TypedValue();
            }
            context.getResources().getValue(i, f10455b, true);
            i2 = f10455b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static final int m15880b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return dy.m16368a(context, i);
        }
        return context.getResources().getColor(i);
    }

    public static int m15878a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
}
