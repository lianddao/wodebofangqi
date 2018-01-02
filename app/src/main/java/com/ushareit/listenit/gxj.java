package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class gxj {
    public static Drawable m23085a(Context context, gxl com_ushareit_listenit_gxl) {
        if (context == null || com_ushareit_listenit_gxl == null || com_ushareit_listenit_gxl.f14863d == null) {
            return null;
        }
        return com_ushareit_listenit_gxl.f14863d.loadIcon(context.getPackageManager());
    }

    public static List<gxl> m23086a(Context context, int i) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.setPackage("com.facebook.katana");
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, i);
        List<gxl> arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            gxl com_ushareit_listenit_gxl = new gxl();
            com_ushareit_listenit_gxl.f14860a = resolveInfo.loadLabel(packageManager).toString();
            com_ushareit_listenit_gxl.f14861b = resolveInfo.activityInfo.packageName;
            com_ushareit_listenit_gxl.f14862c = resolveInfo.loadLabel(packageManager).toString();
            com_ushareit_listenit_gxl.f14864e = resolveInfo.activityInfo.name;
            com_ushareit_listenit_gxl.f14863d = resolveInfo;
            arrayList.add(com_ushareit_listenit_gxl);
        }
        return arrayList;
    }

    public static List<gxl> m23087a(Context context, Intent intent, int i) {
        Object obj;
        List<gxl> b = m23090b(context, intent, i);
        for (gxl com_ushareit_listenit_gxl : b) {
            if (com_ushareit_listenit_gxl.f14861b.equals("com.facebook.katana")) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            Collection a = m23086a(context, i);
            if (a != null && a.size() > 0) {
                b.addAll(a);
            }
        }
        Collections.sort(b, new gxk(Arrays.asList(context.getResources().getStringArray(C0349R.array.share_app_order))));
        return b;
    }

    public static List<gxl> m23090b(Context context, Intent intent, int i) {
        List arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, i)) {
            gxl com_ushareit_listenit_gxl = new gxl();
            com_ushareit_listenit_gxl.f14860a = resolveInfo.loadLabel(packageManager).toString();
            com_ushareit_listenit_gxl.f14861b = resolveInfo.activityInfo.packageName;
            com_ushareit_listenit_gxl.f14862c = resolveInfo.loadLabel(packageManager).toString();
            com_ushareit_listenit_gxl.f14864e = resolveInfo.activityInfo.name;
            com_ushareit_listenit_gxl.f14863d = resolveInfo;
            if (com_ushareit_listenit_gxl.f14861b.startsWith("com.lenovo.anyshare")) {
                arrayList.add(0, com_ushareit_listenit_gxl);
            } else {
                arrayList.add(com_ushareit_listenit_gxl);
            }
        }
        return m23088a(arrayList, context);
    }

    private static List<gxl> m23088a(List<gxl> list, Context context) {
        List arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        List asList = Arrays.asList(context.getResources().getStringArray(C0349R.array.share_app_order));
        for (int i = 0; i < asList.size(); i++) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                gxl com_ushareit_listenit_gxl = (gxl) list.get(i2);
                if (((String) asList.get(i)).equals(com_ushareit_listenit_gxl.f14861b)) {
                    arrayList.add(com_ushareit_listenit_gxl);
                } else if (!(arrayList2.contains(com_ushareit_listenit_gxl) || asList.contains(com_ushareit_listenit_gxl.f14861b))) {
                    arrayList2.add(com_ushareit_listenit_gxl);
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public static long m23084a() {
        return System.currentTimeMillis() / 10000;
    }

    public static int m23089b() {
        int i = 0;
        Context a = eys.m18562a();
        try {
            return a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static int m23083a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
