package com.ushareit.listenit;

import android.app.Activity;

class C0366q {
    public static void m25662a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C0005s) {
            ((C0005s) activity).mo65a(i);
        }
        activity.requestPermissions(strArr, i);
    }

    public static boolean m25663a(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
