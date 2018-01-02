package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class etk {
    public static String f11780a;
    public static String f11781b;
    public static String f11782c;
    public static int f11783d;
    public static String f11784e;
    public static String f11785f;
    public static String f11786g;
    public static String f11787h;
    private static Set<String> f11788i;

    public static void m17899a(String str, String str2, int i, String str3, String str4) {
        f11780a = str;
        f11781b = str2;
        f11783d = i;
        f11782c = str3;
        f11784e = str4;
    }

    public static void m17898a(Context context, String str) {
        int i = 0;
        exu.m18430a((Object) context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                if (TextUtils.isEmpty(str)) {
                    str = fac.m18683a(context);
                }
                String c = fac.m18685c(context);
                String b = fac.m18684b(context);
                String str2 = null;
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    i = packageInfo.versionCode;
                    str2 = packageInfo.versionName;
                }
                m17899a(str, c, i, str2, b);
                f11788i = new HashSet(m17897a(packageManager, c));
                f11786g = new exz(context).m17993b("promotion_channel");
            }
        } catch (Exception e) {
        }
    }

    public static void m17901b(Context context, String str) {
        f11786g = str;
        new exz(context).m17991a("promotion_channel", f11786g);
    }

    public static boolean m17900a(String str) {
        if (f11788i == null || f11788i.isEmpty()) {
            return false;
        }
        return f11788i.contains(str);
    }

    private static List<String> m17897a(PackageManager packageManager, String str) {
        List<String> arrayList = new ArrayList();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return arrayList;
        }
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(launchIntentForPackage, 0)) {
            arrayList.add(resolveInfo.activityInfo.name);
        }
        return arrayList;
    }
}
