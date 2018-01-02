package com.ushareit.listenit;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.analytics.pro.C0321x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class fbj {
    private static List<String> f12376a = new ArrayList();
    private static eyn f12377b = new eyn(new ArrayList(), true, 1000);
    private static StringBuilder f12378c = new StringBuilder();
    private static boolean f12379d = false;
    private static long f12380e = 0;

    public static int m18783a(Context context, String str) {
        f12376a.add(str);
        int a = fbr.m18808a(context, str);
        f12376a.remove(str);
        return a;
    }

    public static int m18784a(Context context, String str, int i) {
        int i2 = 0;
        try {
            if (context.getPackageManager().getPackageInfo(str, 0).versionCode >= i) {
                return 1;
            }
            return 2;
        } catch (NameNotFoundException e) {
            return i2;
        }
    }

    public static boolean m18787b(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static synchronized List<PackageInfo> m18785a(Context context, int i, String str) {
        List<PackageInfo> installedPackages;
        long j = 0;
        synchronized (fbj.class) {
            try {
                long j2 = f12380e;
                f12380e = System.currentTimeMillis();
                if (j2 != 0) {
                    j = (f12380e - j2) / 1000;
                }
                f12378c.append(str + "-" + j + " ");
                if (i != 0 || f12377b.m18556a()) {
                    installedPackages = context.getPackageManager().getInstalledPackages(i);
                    if (i == 0 && installedPackages != null) {
                        f12377b.m18555a(installedPackages);
                    }
                } else {
                    installedPackages = (List) f12377b.m18558c();
                }
            } catch (Throwable th) {
                m18786a(th.getMessage());
                f12378c = new StringBuilder();
                installedPackages = i == 0 ? (List) f12377b.m18558c() : new ArrayList();
            }
        }
        return installedPackages;
    }

    public static int m18782a(Context context) {
        int i = 1;
        try {
            exu.m18430a((Object) context);
            CharSequence packageName = context.getPackageName();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (VERSION.SDK_INT <= 19) {
                int i2;
                List runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks == null || runningTasks.isEmpty() || !packageName.equalsIgnoreCase(((RunningTaskInfo) runningTasks.get(0)).topActivity.getPackageName())) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                return i2;
            }
            Field declaredField;
            try {
                declaredField = RunningAppProcessInfo.class.getDeclaredField("processState");
            } catch (Throwable e) {
                exw.m18450b("PackageUtils", "getField processState exception", e);
                declaredField = null;
            }
            if (declaredField == null) {
                return -1;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                return 0;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    Integer valueOf;
                    try {
                        valueOf = Integer.valueOf(declaredField.getInt(runningAppProcessInfo));
                    } catch (Exception e2) {
                        valueOf = null;
                    }
                    if (valueOf == null) {
                        continue;
                    } else if (valueOf.intValue() == 2) {
                        if (!TextUtils.equals(runningAppProcessInfo.processName, packageName)) {
                            i = 0;
                        }
                        return i;
                    }
                }
            }
            return 0;
        } catch (Throwable e3) {
            exw.m18450b("PackageUtils", "getAppRunningStatus failed!", e3);
            return -1;
        }
    }

    private static void m18786a(String str) {
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(C0321x.aF, str);
            if (f12379d) {
                linkedHashMap.put("history", null);
            } else {
                linkedHashMap.put("history", f12378c.toString().trim());
                f12379d = true;
            }
            esr.m17820b(eys.m18562a(), "ERR_AboutPackageManager", linkedHashMap);
        } catch (Throwable th) {
        }
    }
}
