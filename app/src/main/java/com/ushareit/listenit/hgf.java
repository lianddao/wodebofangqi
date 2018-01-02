package com.ushareit.listenit;

import android.os.Build.VERSION;
import com.umeng.analytics.pro.C0321x;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class hgf {
    private static String f15398a = hgf.class.getSimpleName();

    public static void m23696a(boolean z, boolean z2) {
        exw.m18443a(f15398a, "collectPlayMediaType, isStream=" + z + ", isCached=" + z2);
        HashMap linkedHashMap = new LinkedHashMap();
        String str = "media";
        Object obj = !z ? "file" : z2 ? "stream-cached" : "stream-uncached";
        linkedHashMap.put(str, obj);
        esr.m17820b(eys.m18562a(), "UF_PlayMediaKind", linkedHashMap);
    }

    public static void m23695a(String str) {
        String b = hhh.m23860b(str);
        if (fbb.m18763c(b)) {
            b = "null";
        }
        exw.m18443a(f15398a, "collectMediaMimetype, mimetype=" + b);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("mimetype", b);
        esr.m17820b(eys.m18562a(), "UF_PlayMediaMimetype", linkedHashMap);
    }

    public static void m23693a(int i, int i2, boolean z, String str, boolean z2) {
        HashMap linkedHashMap = new LinkedHashMap();
        if (z) {
            str = "stream," + (z2 ? "cached," : "uncached,") + (hhh.m23858a() ? "net" : "nonet");
        }
        String str2 = str + ", v=" + VERSION.SDK_INT;
        linkedHashMap.put(C0321x.aF, "[" + i + "," + i2 + "]{" + str2 + "}");
        esr.m17820b(eys.m18562a(), "UF_PlayMediaError", linkedHashMap);
        exw.m18443a(f15398a, "collectPlayMediaError, error=" + str2);
    }

    public static void m23698b(String str) {
        exw.m18443a(f15398a, "collectPlayMediaError, errorMessage=" + str);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("message", str);
        esr.m17820b(eys.m18562a(), "UF_PlayMediaError", linkedHashMap);
    }

    public static void m23694a(long j, boolean z, boolean z2) {
        String a = hge.m23691a(j);
        exw.m18443a(f15398a, "collectPrepareMediaTime, " + a);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("level", a);
        String str = "media";
        Object obj = !z ? "file" : z2 ? "stream-cached" : "stream-uncached";
        linkedHashMap.put(str, obj);
        esr.m17820b(eys.m18562a(), "UF_PrepareMediaTime", linkedHashMap);
    }

    public static void m23699b(boolean z, boolean z2) {
        exw.m18443a(f15398a, "collectStartMediaPLayer, isStream=" + z);
        HashMap linkedHashMap = new LinkedHashMap();
        String str = "media";
        Object obj = !z ? "file" : z2 ? "stream-cached" : "stream-uncached";
        linkedHashMap.put(str, obj);
        esr.m17820b(eys.m18562a(), "UF_StartPlayMedia", linkedHashMap);
    }

    public static void m23692a() {
        exw.m18443a(f15398a, "collectGetProxyUrlSuccess");
        esr.m17807a(eys.m18562a(), "UF_GetProxyUrlSuccess");
    }

    public static void m23697b() {
        exw.m18443a(f15398a, "collectGetProxyUrlFailure");
        esr.m17807a(eys.m18562a(), "UF_GetProxyUrlFailure");
    }

    public static void m23700c() {
        exw.m18443a(f15398a, "collectCacheStreamSuccess");
        esr.m17807a(eys.m18562a(), "UF_CacheStreamSuccess");
    }

    public static void m23701d() {
        exw.m18443a(f15398a, "collectBufferLack");
        esr.m17807a(eys.m18562a(), "UF_BufferLack");
    }
}
