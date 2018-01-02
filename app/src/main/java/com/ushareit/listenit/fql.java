package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.volley.BuildConfig;
import java.io.File;
import java.util.Locale;

public class fql {
    private static Context f13233a = null;

    public static void m20388a(Context context) {
        f13233a = context;
    }

    public static String m20387a() {
        return "LISTENit";
    }

    public static boolean m20390b() {
        if (f13233a == null) {
            return false;
        }
        try {
            if (f13233a.getPackageManager().getPackageInfo(f13233a.getPackageName(), 0).versionCode == 1) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static String m20391c() {
        String language = Locale.getDefault().getLanguage();
        String str = "www.ushareit.com";
        if (language.equalsIgnoreCase("zh") || language.equalsIgnoreCase("zh_CN") || language.equalsIgnoreCase("zh_TW") || language.equalsIgnoreCase("zh_HK")) {
            return "www.ushareit.cn";
        }
        return str;
    }

    public static String m20392d() {
        String str = BuildConfig.VERSION_NAME;
        if (f13233a != null) {
            try {
                str = f13233a.getPackageManager().getPackageInfo(f13233a.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
            }
        }
        return str;
    }

    public static eyh m20389b(Context context) {
        eyk c = eyj.m18516c(context);
        String str = "/LISTENit/";
        if (c.f12182h) {
            return eyh.m18491a(c.f12178d + str);
        }
        if (c.f12180f) {
            return eyh.m18491a(c.f12178d + str);
        }
        if (c.f12181g) {
            return eyh.m18490a(new File(eye.m18475a(context, c.f12178d), "LISTENit"));
        }
        if (!c.f12183i) {
            return eyh.m18490a(new File(eye.m18479b(f13233a, c.f12178d), "LISTENit"));
        }
        Object a = gvk.m23047a(context, "");
        if (TextUtils.isEmpty(a)) {
            return eyh.m18491a(c.f12178d + str);
        }
        return eyh.m18488a(eyh.m18489a(fl.m19696b(context, Uri.parse(a))), "LISTENit");
    }
}
