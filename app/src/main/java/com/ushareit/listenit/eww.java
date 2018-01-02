package com.ushareit.listenit;

import android.content.Context;
import com.umeng.analytics.pro.C0321x;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class eww {
    public static void m18328a(Context context, String str, String str2, long j, String str3) {
        if (context != null) {
            try {
                if (esr.m17814a(1000)) {
                    HashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("result", str);
                    linkedHashMap.put("url", m18327a(str2));
                    linkedHashMap.put("duration", m18326a(j) + "");
                    linkedHashMap.put(C0321x.aF, str3);
                    esr.m17820b(context, "CLOUD_RequestResult", linkedHashMap);
                }
            } catch (Exception e) {
            }
        }
    }

    private static long m18326a(long j) {
        if (j < 10) {
            return j;
        }
        if (j < 1000) {
            return (j / 10) * 10;
        }
        if (j < 10000) {
            return (j / 100) * 100;
        }
        return (j / 1000) * 1000;
    }

    private static String m18327a(String str) {
        if (fbb.m18758a(str)) {
            return null;
        }
        int indexOf = str.indexOf("?");
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }
}
