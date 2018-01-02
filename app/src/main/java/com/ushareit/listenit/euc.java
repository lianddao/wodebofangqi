package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0321x;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

public class euc {
    private static etd f11879a;

    public static void m17971a(Context context, boolean z, Exception exception) {
        try {
            etd com_ushareit_listenit_etd = f11879a;
            if (com_ushareit_listenit_etd != null && esr.m17814a(100)) {
                String str = z ? "BL_UploadSuccess" : "BL_UploadFailedEx";
                String str2 = z ? "success" : "failed";
                String a = (z || exception == null) ? null : m17968a(exception.getMessage());
                HashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", str2);
                linkedHashMap.put(C0321x.aF, a);
                exw.m18443a("BeylaStats", "trackUploadResult, [event:" + str + ", result:" + str2 + ", error:" + a + "]");
                com_ushareit_listenit_etd.mo2289a(context, str, linkedHashMap);
            }
        } catch (Exception e) {
        }
    }

    public static void m17969a(Context context, long j) {
        try {
            etd com_ushareit_listenit_etd = f11879a;
            if (com_ushareit_listenit_etd != null) {
                long currentTimeMillis = System.currentTimeMillis();
                exz com_ushareit_listenit_eug = new eug(context);
                if (!com_ushareit_listenit_eug.m18000e("bl_stats_last_track_noupload_time")) {
                    com_ushareit_listenit_eug.m17996b("bl_stats_last_track_noupload_time", currentTimeMillis);
                }
                long a = com_ushareit_listenit_eug.m17989a("bl_stats_last_track_noupload_time", currentTimeMillis);
                if (j == 0) {
                    j = com_ushareit_listenit_eug.m17989a("bl_stats_last_succeed_time", currentTimeMillis);
                }
                com_ushareit_listenit_eug.m17996b("bl_stats_last_succeed_time", j);
                if (currentTimeMillis - a >= C0154a.f2953i) {
                    com_ushareit_listenit_eug.m17996b("bl_stats_last_track_noupload_time", currentTimeMillis);
                    if (currentTimeMillis - j >= C0154a.f2953i) {
                        com_ushareit_listenit_eug.m17996b("bl_stats_noupload_days", (currentTimeMillis - j) / C0154a.f2953i);
                        return;
                    }
                    currentTimeMillis = com_ushareit_listenit_eug.m17989a("bl_stats_noupload_days", 0);
                    if (currentTimeMillis != 0) {
                        com_ushareit_listenit_eug.m17990a("bl_stats_noupload_days");
                        if (esr.m17814a(100)) {
                            String valueOf = currentTimeMillis > 20 ? ">20" : String.valueOf(currentTimeMillis);
                            String str = "BL_NoUploadTime";
                            HashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("days", valueOf);
                            exw.m18443a("BeylaStats", "trackNoUploadTime, [event:" + str + ", days:" + valueOf + "]");
                            com_ushareit_listenit_etd.mo2289a(context, str, linkedHashMap);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void m17970a(Context context, Throwable th) {
        try {
            etd com_ushareit_listenit_etd = f11879a;
            if (com_ushareit_listenit_etd != null && th != null) {
                com_ushareit_listenit_etd.mo2290a(context, th);
                exw.m18443a("BeylaStats", "report Error, exception" + th.getMessage());
            }
        } catch (Exception e) {
        }
    }

    private static String m17968a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String toLowerCase = str.toLowerCase(Locale.US);
        if (toLowerCase.contains("unable to resolve host")) {
            return "Unable to resolve host";
        }
        if (toLowerCase.contains("read time out")) {
            return "Read time out";
        }
        if (toLowerCase.contains("ssl")) {
            return "SSL handshake aborted";
        }
        if (toLowerCase.contains("time out")) {
            return "Connection time out";
        }
        if (toLowerCase.contains("refuse")) {
            return "Connection refused";
        }
        return "other error";
    }
}
