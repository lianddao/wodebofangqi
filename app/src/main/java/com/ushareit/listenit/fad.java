package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class fad {
    private static List<String> f12301a = new ArrayList();

    public static void m18688a(Context context, String str, String str2, String str3, boolean z) {
        String str4;
        try {
            str4 = TextUtils.isEmpty(str3) ? "" : "%26utm_medium%3D" + str3 + "%26utm_campaign%3D" + str3;
            if (TextUtils.isEmpty(str2)) {
                str4 = fbp.m18800a("market://details?id=%s", str);
            } else {
                str4 = fbp.m18800a("market://details?id=%s&%s", str, "referrer=utm_source%3D" + str2 + str4);
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str4));
            if (z || m18691a(context, intent, "com.android.vending")) {
                intent.setPackage("com.android.vending");
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            m18689a(context, str4, str, false);
        } catch (Exception e) {
            try {
                str4 = TextUtils.isEmpty(str3) ? "" : "%26utm_medium%3D" + str3 + "%26utm_campaign%3D" + str3;
                if (TextUtils.isEmpty(str2)) {
                    str4 = fbp.m18800a("https://play.google.com/store/apps/details?id=%s", str);
                } else {
                    str4 = fbp.m18800a("https://play.google.com/store/apps/details?id=%s&%s", str, "referrer=utm_source%3D" + str2 + str4);
                }
                m18692a(context, str4, true);
                m18689a(context, str4, str, true);
            } catch (Exception e2) {
            }
        }
    }

    public static void m18687a(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("fb://page/" + str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            m18692a(context, "https://www.facebook.com/" + str2, true);
        }
    }

    static {
        f12301a.add("com.android.chrome");
        f12301a.add("com.opera.browser");
        f12301a.add("com.opera.mini.android");
        f12301a.add("com.opera.mini.native");
        f12301a.add("com.UCMobile");
        f12301a.add("com.UCMobile.intl");
        f12301a.add("com.uc.browser.en");
        f12301a.add("com.UCMobile.internet.org");
        f12301a.add("com.uc.browser.hd");
        f12301a.add("org.mozilla.firefox");
        f12301a.add("com.tencent.mtt");
        f12301a.add("com.qihoo.browser");
        f12301a.add("com.baidu.browser.apps");
        f12301a.add("sogou.mobile.explorer");
        f12301a.add("com.zui.browser");
        f12301a.add("com.oupeng.browser");
        f12301a.add("com.oupeng.mini.android");
    }

    public static boolean m18692a(Context context, String str, boolean z) {
        return m18693a(context, str, z, 0);
    }

    public static boolean m18693a(Context context, String str, boolean z, int i) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (z) {
            intent.addFlags(268435456);
        }
        return m18690a(context, intent, i, f12301a);
    }

    private static boolean m18690a(Context context, Intent intent, int i, List<String> list) {
        boolean z;
        try {
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveInfo = null;
            if (!m18694a(resolveActivity, queryIntentActivities)) {
                resolveInfo = m18686a(packageManager, queryIntentActivities, (List) list);
            }
            if (resolveInfo != null) {
                intent.setPackage(resolveInfo.activityInfo.packageName);
            }
            try {
                context.startActivity(intent);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        } catch (Exception e2) {
            exw.m18449b("AppStarter", e2.toString());
            z = false;
        }
        if (!z && i > 0) {
            Toast.makeText(context, i, 0).show();
        }
        return z;
    }

    public static boolean m18694a(ResolveInfo resolveInfo, List<ResolveInfo> list) {
        if (resolveInfo == null || list == null || list.size() < 1) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            ResolveInfo resolveInfo2 = (ResolveInfo) list.get(i);
            if (resolveInfo2.activityInfo.name.equals(resolveInfo.activityInfo.name) && resolveInfo2.activityInfo.packageName.equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    private static ResolveInfo m18686a(PackageManager packageManager, List<ResolveInfo> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        if (list2 != null && list.size() > 1) {
            Collections.sort(list, new fae(list2));
        }
        return (ResolveInfo) list.get(0);
    }

    private static boolean m18691a(Context context, Intent intent, String str) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            if (resolveInfo.activityInfo.packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void m18689a(Context context, String str, String str2, boolean z) {
        if (context != null) {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("url", str);
            linkedHashMap.put("pkg_name", str2);
            linkedHashMap.put("start_way", z ? "browser" : "market_app");
            exw.m18449b("AppStarter", "collectStartAppMarket: " + linkedHashMap.toString());
            esr.m17820b(context, "StartAppMarket", linkedHashMap);
        }
    }
}
