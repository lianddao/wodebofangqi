package com.ushareit.listenit;

import android.content.Context;
import android.util.Pair;
import com.mopub.mobileads.FacebookInterstitial;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class esh {
    public static void m17758a(Context context, ese com_ushareit_listenit_ese, Pair<Boolean, Boolean> pair) {
        if (context != null) {
            try {
                HashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("group_id", com_ushareit_listenit_ese.f11685b);
                linkedHashMap.put("ad_id", com_ushareit_listenit_ese.f11684a + "_" + com_ushareit_listenit_ese.f11686c);
                linkedHashMap.put("network", etc.m17843a((Pair) pair));
                exw.m18449b("AD.Stats", "collectAdStartLoad: " + linkedHashMap.toString());
                esr.m17826d(context, "AD_StartLoad", linkedHashMap);
            } catch (Exception e) {
            }
        }
    }

    public static void m17761a(Context context, ese com_ushareit_listenit_ese, String str, esd com_ushareit_listenit_esd, Pair<Boolean, Boolean> pair) {
        if (context != null) {
            try {
                float[] fArr = new float[]{DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, CloseButton.STROKE_WIDTH, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, CtaButton.TEXT_SIZE_SP, CloseButton.TEXT_SIZE_SP, 30.0f, 50.0f};
                HashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", str + "_" + com_ushareit_listenit_ese.f11685b);
                linkedHashMap.put("group_id", com_ushareit_listenit_ese.f11685b);
                linkedHashMap.put("ad_id", com_ushareit_listenit_ese.f11684a + "_" + com_ushareit_listenit_ese.f11686c);
                linkedHashMap.put("network", etc.m17843a((Pair) pair));
                linkedHashMap.put("failed_msg", com_ushareit_listenit_esd == null ? null : esd.m17711a(com_ushareit_listenit_esd.mo2345a()));
                linkedHashMap.put("failed_msg_detail", com_ushareit_listenit_esd == null ? null : com_ushareit_listenit_esd.getMessage());
                long b = com_ushareit_listenit_ese.m17716b("endTime", -1);
                long b2 = com_ushareit_listenit_ese.m17716b("startTime", -1);
                if (b - b2 <= 0 || b2 == -1) {
                    linkedHashMap.put("duration", null);
                } else {
                    linkedHashMap.put("duration", com_ushareit_listenit_ese.f11684a + "_" + etc.m17838a((float) ((b - b2) / 1000), fArr));
                }
                exw.m18449b("AD.Stats", "collectAdLoadResult: " + linkedHashMap.toString());
                esr.m17826d(context, "AD_LoadResult", linkedHashMap);
            } catch (Exception e) {
            }
        }
    }

    public static void m17760a(Context context, ese com_ushareit_listenit_ese, esd com_ushareit_listenit_esd, Pair<Boolean, Boolean> pair) {
        Object obj = null;
        try {
            float[] fArr = new float[]{DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, CloseButton.STROKE_WIDTH, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, CtaButton.TEXT_SIZE_SP, CloseButton.TEXT_SIZE_SP, 30.0f, 50.0f};
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("group_id", com_ushareit_listenit_ese.f11685b);
            linkedHashMap.put("ad_id", com_ushareit_listenit_ese.f11684a + "_" + com_ushareit_listenit_ese.f11686c);
            linkedHashMap.put("network", etc.m17843a((Pair) pair));
            linkedHashMap.put("failed_msg", com_ushareit_listenit_esd == null ? null : esd.m17711a(com_ushareit_listenit_esd.mo2345a()));
            String str = "failed_msg_detail";
            if (com_ushareit_listenit_esd != null) {
                obj = com_ushareit_listenit_esd.getMessage();
            }
            linkedHashMap.put(str, obj);
            long currentTimeMillis = System.currentTimeMillis();
            long b = com_ushareit_listenit_ese.m17716b("startTime", -1);
            if (currentTimeMillis - b <= 0 || b == -1) {
                linkedHashMap.put("duration", null);
            } else {
                linkedHashMap.put("duration", com_ushareit_listenit_ese.f11684a + "_" + etc.m17838a((float) ((currentTimeMillis - b) / 1000), fArr));
            }
            exw.m18449b("AD.Stats", "collectAdLoadError: " + linkedHashMap.toString());
            esr.m17826d(context, "AD_LoadError", linkedHashMap);
        } catch (Exception e) {
        }
    }

    public static void m17759a(Context context, ese com_ushareit_listenit_ese, esd com_ushareit_listenit_esd) {
        if (context != null) {
            try {
                HashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("group_id", com_ushareit_listenit_ese.f11685b);
                linkedHashMap.put("ad_id", com_ushareit_listenit_ese.f11684a + "_" + com_ushareit_listenit_ese.f11686c);
                linkedHashMap.put("failed_msg", com_ushareit_listenit_esd == null ? null : esd.m17711a(com_ushareit_listenit_esd.mo2345a()));
                exw.m18449b("AD.Stats", "collectAdNotSupport: " + linkedHashMap.toString());
                esr.m17820b(context, "AD_NotSupport", linkedHashMap);
            } catch (Exception e) {
            }
        }
    }

    public static void m17764a(Context context, boolean z) {
        if (context != null) {
            try {
                HashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("reachable", z ? "reachable" : "unreachable");
                exw.m18449b("AD.Stats", "collectAdCheckReachable: " + linkedHashMap.toString());
                esr.m17820b(context, "AD_CheckReachable", linkedHashMap);
            } catch (Exception e) {
            }
        }
    }

    public static void m17762a(Context context, ese com_ushareit_listenit_ese, Throwable th) {
        if (context != null && com_ushareit_listenit_ese != null && th != null) {
            try {
                HashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("group_id", com_ushareit_listenit_ese.f11685b);
                linkedHashMap.put(FacebookInterstitial.PLACEMENT_ID_KEY, com_ushareit_listenit_ese.f11686c);
                linkedHashMap.put("err_stack", m17757a(th));
                exw.m18449b("AD.Stats", "collectAdLoadException: " + linkedHashMap.toString());
                esr.m17820b(context, "ERR_AdLoadException", linkedHashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void m17763a(Context context, String str, String str2, Throwable th) {
        if (context != null && th != null) {
            try {
                HashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("group_id", str);
                linkedHashMap.put("placement", str2);
                linkedHashMap.put("err_stack", m17757a(th));
                exw.m18449b("AD.Stats", "collectAdNotifyException: " + linkedHashMap.toString());
                esr.m17820b(context, "ERR_AdNotifyException", linkedHashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String m17757a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder(4096);
        stringBuilder.append(th.getMessage()).append("\\n");
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            stringBuilder.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("() ").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append("\\n");
        }
        return stringBuilder.length() >= 4096 ? stringBuilder.toString().substring(0, 4096) : stringBuilder.toString();
    }
}
