package com.ushareit.listenit;

import android.util.Log;

public class bze {
    public static void m10485a(String str) {
        if (m10487a(3)) {
            Log.d("Ads", str);
        }
    }

    public static void m10486a(String str, Throwable th) {
        if (m10487a(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static boolean m10487a(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }

    public static void m10488b(String str) {
        if (m10487a(6)) {
            Log.e("Ads", str);
        }
    }

    public static void m10489b(String str, Throwable th) {
        if (m10487a(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void m10490c(String str) {
        if (m10487a(5)) {
            Log.w("Ads", str);
        }
    }

    public static void m10491c(String str, Throwable th) {
        if (m10487a(5)) {
            Log.w("Ads", str, th);
        }
    }
}
