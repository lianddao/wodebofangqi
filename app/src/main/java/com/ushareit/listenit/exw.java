package com.ushareit.listenit;

import android.util.Log;
import com.umeng.analytics.C0154a;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class exw {
    public static boolean f12142a;
    private static String f12143b = "AS.";
    private static exy f12144c = null;
    private static List<exy> f12145d = null;
    private static String f12146e = "com.ushareit.common.appertizers";
    private static String f12147f = "Logger";
    private static int f12148g = 4;
    private static long f12149h;

    public static void m18442a(String str) {
        f12143b = str;
        f12144c = new exx(2);
        m18448b();
        try {
            Class.forName(f12146e + "." + f12147f);
            f12142a = true;
        } catch (ClassNotFoundException e) {
            f12142a = false;
        }
        if (f12142a) {
            f12148g = 2;
        }
        m18454c("", "Logger Started, DebugVersion = " + f12142a);
    }

    public static boolean m18447a() {
        return f12148g <= 3;
    }

    public static void m18439a(int i) {
        f12148g = i;
    }

    public static String m18438a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void m18440a(int i, String str, String str2) {
        m18441a(i, str, str2, null);
    }

    public static void m18441a(int i, String str, String str2, Throwable th) {
        if (i >= f12148g) {
            String substring;
            String format;
            String str3 = f12143b + str;
            if (str3.length() > 23) {
                substring = str3.substring(0, 23);
            } else {
                substring = str3;
            }
            str3 = "";
            if (th == null) {
                format = String.format(Locale.US, "%s[%d] %s", new Object[]{m18453c(), Long.valueOf(Thread.currentThread().getId()), str2});
            } else {
                format = String.format(Locale.US, "%s[%d] %s - %s", new Object[]{m18453c(), Long.valueOf(Thread.currentThread().getId()), str2, m18438a(th)});
            }
            f12144c.mo2316a(i, substring, format);
            List<exy> list = f12145d;
            if (list != null) {
                for (exy a : list) {
                    a.mo2316a(i, substring, format);
                }
            }
        }
    }

    private static void m18448b() {
        Date date = new Date();
        long currentTimeMillis = System.currentTimeMillis();
        f12149h = (currentTimeMillis - (currentTimeMillis % 1000)) - ((((long) date.getSeconds()) + (((((long) date.getHours()) * 60) + ((long) date.getMinutes())) * 60)) * 1000);
    }

    private static String m18453c() {
        long currentTimeMillis = System.currentTimeMillis() - f12149h;
        int i = ((int) (currentTimeMillis / C0154a.f2954j)) % 24;
        int i2 = ((int) (currentTimeMillis / 60000)) % 60;
        int i3 = ((int) (currentTimeMillis / 1000)) % 60;
        int i4 = (int) (currentTimeMillis % 1000);
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public static void m18443a(String str, String str2) {
        m18440a(2, str, str2);
    }

    public static void m18445a(String str, String str2, Object... objArr) {
        m18440a(2, str, String.format(Locale.US, str2, objArr));
    }

    public static void m18449b(String str, String str2) {
        m18440a(3, str, str2);
    }

    public static void m18454c(String str, String str2) {
        m18440a(4, str, str2);
    }

    public static void m18451b(String str, String str2, Object... objArr) {
        m18440a(4, str, String.format(Locale.US, str2, objArr));
    }

    public static void m18456d(String str, String str2) {
        m18440a(5, str, str2);
    }

    public static void m18446a(String str, Throwable th) {
        m18440a(5, str, m18438a(th));
    }

    public static void m18444a(String str, String str2, Throwable th) {
        m18441a(5, str, str2, th);
    }

    public static void m18457e(String str, String str2) {
        m18440a(6, str, str2);
    }

    public static void m18452b(String str, Throwable th) {
        m18440a(6, str, m18438a(th));
    }

    public static void m18450b(String str, String str2, Throwable th) {
        m18441a(6, str, str2, th);
    }

    public static void m18455c(String str, String str2, Throwable th) {
        m18441a(7, str, str2, th);
    }
}
