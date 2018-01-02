package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import java.lang.reflect.Method;

public class gzc {
    private static Method f14949a;

    static {
        f14949a = null;
        try {
            f14949a = Class.forName("android.view.Window").getMethod("romUI_setDarkStatusIcon", new Class[]{Boolean.TYPE});
        } catch (ClassNotFoundException e) {
            exw.m18449b("NotificationBarUtil", "Exception : " + e.toString());
        } catch (NoSuchMethodException e2) {
            exw.m18449b("NotificationBarUtil", "Exception : " + e2.toString());
        }
    }

    public static void m23341a(Activity activity, int i) {
        if (m23345a()) {
            Window window = activity.getWindow();
            m23342a(window);
            window.getDecorView().setBackgroundResource(i);
        }
    }

    public static void m23346b(Activity activity, int i) {
        m23343a(activity.getWindow(), i);
    }

    public static void m23343a(Window window, int i) {
        if (m23345a()) {
            m23342a(window);
            window.getDecorView().setBackgroundColor(i);
        }
    }

    public static boolean m23345a() {
        return VERSION.SDK_INT >= 19;
    }

    @TargetApi(19)
    private static void m23342a(Window window) {
        if (window != null) {
            window.setFlags(67108864, 67108864);
            m23344a(window, true);
        }
    }

    private static void m23344a(Window window, boolean z) {
        exw.m18449b("NotificationBarUtil", "setDarkStatus >> window : " + window + " ; dark : " + z + " ; methodSetDarkStatusIcon : " + f14949a);
        try {
            if (f14949a != null) {
                f14949a.invoke(window, new Object[]{Boolean.valueOf(z)});
            }
        } catch (Exception e) {
            exw.m18449b("NotificationBarUtil", "Exception : " + e.toString());
        }
    }
}
