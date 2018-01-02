package com.ushareit.listenit;

import android.text.TextUtils;
import com.facebook.ads.C0017i;

public class asf {
    public static String m6964a() {
        if (TextUtils.isEmpty(C0017i.m960a())) {
            return "https://graph.facebook.com/network_ads_common";
        }
        return String.format("https://graph.%s.facebook.com/network_ads_common", new Object[]{C0017i.m960a()});
    }

    public static String m6965b() {
        if (TextUtils.isEmpty(C0017i.m960a())) {
            return "https://www.facebook.com/adnw_logging/";
        }
        return String.format("https://www.%s.facebook.com/adnw_logging/", new Object[]{C0017i.m960a()});
    }
}
