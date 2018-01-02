package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.pro.C0321x;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class euz {
    public static void m18091a(Context context, evp com_ushareit_listenit_evp) {
        if (com_ushareit_listenit_evp != null) {
            String str;
            if ("arrived".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportArrived";
            } else if ("executed".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportExecuted";
            } else if ("downloaded".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportDownloaded";
            } else if ("installed".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportInstalled";
            } else if ("completed".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportCompleted";
            } else if ("canceled".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportCanceled";
            } else if (C0321x.aF.equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportError";
            } else if ("expired".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportExpired";
            } else if ("showed".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportShowed";
            } else if ("clicked".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportClicked";
            } else if ("skipped".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportSkipped";
            } else if ("not_shown".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                str = "CMD_ReportNotShown";
            } else {
                return;
            }
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cmd_id", com_ushareit_listenit_evp.f11981a);
            if ("arrived".equalsIgnoreCase(com_ushareit_listenit_evp.f11982b)) {
                linkedHashMap.put("duration", null);
            } else {
                linkedHashMap.put("duration", etc.m17838a(((float) com_ushareit_listenit_evp.f11984d) / 1000.0f, new float[]{60.0f, 300.0f, 600.0f, 1200.0f, 1800.0f, 3600.0f, 7200.0f, 10800.0f, 18000.0f, 36000.0f, 86400.0f, 172800.0f, 259200.0f, 432000.0f, 864000.0f}));
            }
            if (fbb.m18761b(com_ushareit_listenit_evp.f11983c)) {
                linkedHashMap.put("detail", com_ushareit_listenit_evp.f11983c);
            } else {
                linkedHashMap.put("detail", null);
            }
            exw.m18449b("CMD.AnalyticsCommand", "collectStatus: " + com_ushareit_listenit_evp.toString());
            esr.m17812a(context, str, linkedHashMap, ete.class);
        }
    }

    public static void m18093a(Context context, String str, String str2, Long l, Integer num) {
        Object obj = null;
        try {
            float[] fArr = new float[]{DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, CloseButton.STROKE_WIDTH, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, CtaButton.TEXT_SIZE_SP, CloseButton.TEXT_SIZE_SP, 30.0f, 50.0f};
            Date date = new Date(System.currentTimeMillis());
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", str);
            linkedHashMap.put("portal", str2);
            linkedHashMap.put("network", etc.m17843a(eyw.m18568a(context)));
            linkedHashMap.put("duration", l == null ? null : etc.m17838a((float) (l.longValue() / 1000), fArr));
            String str3 = "count";
            if (num != null) {
                obj = String.valueOf(num);
            }
            linkedHashMap.put(str3, obj);
            linkedHashMap.put("hours", date.getHours() + "");
            exw.m18449b("CMD.AnalyticsCommand", "collectPullResult: " + linkedHashMap.toString());
            esr.m17811a(context, "CMD_PullResult", linkedHashMap, euo.m18007a(context, "cmd_report_rr", 1), 100);
        } catch (Exception e) {
        }
    }

    public static void m18094a(Context context, String str, String str2, String str3) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key", str);
        linkedHashMap.put("new_value", str2);
        linkedHashMap.put("old_value", str3);
        esr.m17812a(context, "CMD_UpdateSetting", linkedHashMap, ete.class);
    }

    public static void m18092a(Context context, String str, String str2) {
        Object obj;
        String str3;
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key", str);
        String str4 = "value";
        if (TextUtils.isEmpty(str2)) {
            obj = "null";
        } else {
            str3 = str2;
        }
        linkedHashMap.put(str4, obj);
        str3 = "CMD.AnalyticsCommand";
        StringBuilder append = new StringBuilder().append("collectQuerySetting key").append(str).append(" value = ");
        if (TextUtils.isEmpty(str2)) {
            str2 = "null";
        }
        exw.m18449b(str3, append.append(str2).toString());
        esr.m17812a(context, "CMD_QuerySetting", linkedHashMap, ete.class);
    }
}
