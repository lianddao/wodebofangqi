package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

public final class fac {
    public static String m18683a(Context context) {
        String str = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                str = applicationInfo.metaData.getString("BEYLA_APPTOKEN");
            }
        } catch (Exception e) {
        }
        return str;
    }

    public static String m18682a() {
        return m18684b(eys.m18562a());
    }

    public static String m18684b(Context context) {
        String str = "default";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return str;
            }
            String str2 = "";
            if (applicationInfo.metaData.containsKey("BEYLA_CHANNEL")) {
                str2 = fbb.m18752a(applicationInfo.metaData, "BEYLA_CHANNEL");
            } else if (applicationInfo.metaData.containsKey("UMENG_CHANNEL")) {
                str2 = fbb.m18752a(applicationInfo.metaData, "UMENG_CHANNEL");
            } else if (applicationInfo.metaData.containsKey("lenovo:channel")) {
                str2 = fbb.m18752a(applicationInfo.metaData, "lenovo:channel");
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            return str;
        } catch (Exception e) {
        }
    }

    public static String m18685c(Context context) {
        String packageName = context.getPackageName();
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return packageName;
            }
            String str = "";
            if (applicationInfo.metaData.containsKey("CLOUD_APPID")) {
                str = fbb.m18752a(applicationInfo.metaData, "CLOUD_APPID");
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return packageName;
        } catch (Exception e) {
        }
    }
}
