package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class fa {
    private static Method f12296a;
    private static boolean f12297b;

    public static boolean m18679a(Drawable drawable, int i) {
        if (!f12297b) {
            try {
                f12296a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f12296a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f12297b = true;
        }
        if (f12296a != null) {
            try {
                f12296a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f12296a = null;
            }
        }
        return false;
    }
}
