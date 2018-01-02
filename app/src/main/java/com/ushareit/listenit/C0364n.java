package com.ushareit.listenit;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class C0364n extends dw {
    public static void m25142a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0368u.m26493a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m25143a(Activity activity, String[] strArr, int i) {
        if (VERSION.SDK_INT >= 23) {
            C0366q.m25662a(activity, strArr, i);
        } else if (activity instanceof C0004p) {
            new Handler(Looper.getMainLooper()).post(new C0365o(strArr, activity, i));
        }
    }

    public static boolean m25144a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return C0366q.m25663a(activity, str);
        }
        return false;
    }
}
