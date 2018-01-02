package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class euo {
    private static boolean f11899a = false;
    private static exz f11900b = null;
    private static exz f11901c = null;

    public static void m18014a(Context context, List<String> list, List<String> list2) {
        faq.m18736a(new eup("Cloud.Init", context, list, list2));
    }

    public static synchronized boolean m18019a(Context context, boolean z, List<String> list, List<String> list2) {
        boolean a;
        synchronized (euo.class) {
            a = m18018a(context, "network_connected", z, list, list2);
        }
        return a;
    }

    public static synchronized boolean m18018a(Context context, String str, boolean z, List<String> list, List<String> list2) {
        boolean z2;
        synchronized (euo.class) {
            exv a = eus.m18026a(context);
            if (!z) {
                if (!a.mo2318a()) {
                    z2 = false;
                } else if (f11899a) {
                    z2 = true;
                }
            }
            Object obj = (list == null || list.size() <= 0) ? null : 1;
            if (list2 == null || list2.size() <= 0) {
                r6 = null;
            } else {
                r6 = 1;
            }
            try {
                List arrayList = new ArrayList();
                arrayList.add("cfg_pd");
                arrayList.add("cfg_pd_wifi");
                arrayList.add("cfg_pd_mobile");
                arrayList.add("cfg_pd_alarm");
                arrayList.add("cmd_pd");
                arrayList.add("cmd_pd_wifi");
                arrayList.add("cmd_pd_mobile");
                arrayList.add("cmd_pd_alarm");
                arrayList.add("cmd_preset_mad");
                arrayList.add("cmd_preset_lmad");
                arrayList.add("cmd_preset_nd");
                arrayList.add("cmd_report_detail");
                arrayList.add("cmd_report_sd");
                arrayList.add("cmd_report_rr");
                arrayList.add("cmd_report_ct");
                arrayList.add("safe_version");
                arrayList.add("beyla_use_https");
                if (obj != null) {
                    arrayList.addAll(list);
                }
                if (r6 != null) {
                    arrayList.addAll(list2);
                }
                boolean a2 = m18016a(context, str, arrayList);
                a.mo2317a(a2);
                if (r6 != null) {
                    for (String a3 : list2) {
                        eus.m18027a(context, a3, 0, 0).mo2317a(a2);
                    }
                }
                if (a2) {
                    f11899a = true;
                    z2 = f11899a;
                }
            } catch (Exception e) {
                a.mo2317a(false);
                Object obj2;
                if (obj2 != null) {
                    for (String a32 : list2) {
                        eus.m18027a(context, a32, 0, 0).mo2317a(false);
                    }
                }
            }
            z2 = false;
        }
        return z2;
    }

    public static boolean m18015a(Context context, String str) {
        return m18009a(context).m18000e(str);
    }

    public static String m18021b(Context context, String str) {
        return m18009a(context).m17994b(str, "");
    }

    public static String m18011a(Context context, String str, String str2) {
        return m18009a(context).m17994b(str, str2);
    }

    public static int m18007a(Context context, String str, int i) {
        return m18009a(context).m17988a(str, i);
    }

    public static long m18008a(Context context, String str, long j) {
        return m18009a(context).m17989a(str, j);
    }

    public static boolean m18017a(Context context, String str, boolean z) {
        return m18009a(context).m17992a(str, z);
    }

    private static boolean m18016a(Context context, String str, List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ezt a = m18010a(context, (List) list);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a.m18642b() != 200) {
                exw.m18449b("CFG.Main", "getConfigsFromCloud(): Get configs failed and status code = " + a.m18642b());
                m18012a(context, "failed_status_" + a.m18642b(), str, currentTimeMillis2);
                return false;
            }
            String a2 = a.m18641a();
            if (fbb.m18758a(a2)) {
                exw.m18449b("CFG.Main", "getConfigsFromCloud(): The json is empty.");
                m18012a(context, "failed_json_empty", str, currentTimeMillis2);
                return false;
            }
            JSONObject jSONObject = new JSONObject(a2);
            int i = jSONObject.getInt("result");
            if (i != 0) {
                exw.m18449b("CFG.Main", "getConfigsFromCloud(): Get configs failed and result = " + i + ", msg = " + jSONObject.getString("error_info"));
                m18012a(context, "failed_result_" + i, str, currentTimeMillis2);
                return false;
            } else if (jSONObject.has("configs")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("configs");
                exw.m18449b("CFG.Main", "configs = " + jSONObject2.toString());
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    a2 = (String) keys.next();
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(a2);
                    Iterator keys2 = jSONObject3.keys();
                    if (keys2.hasNext()) {
                        String str2 = (String) keys2.next();
                        m18013a(context, a2, jSONObject3.getString(str2), str2);
                    }
                }
                m18012a(context, "success", str, currentTimeMillis2);
                return true;
            } else {
                m18012a(context, "success_empty", str, currentTimeMillis2);
                return true;
            }
        } catch (IOException e) {
            m18012a(context, "failed_IOException", str, System.currentTimeMillis() - currentTimeMillis);
            return false;
        } catch (JSONException e2) {
            m18012a(context, "failed_JSONException", str, System.currentTimeMillis() - currentTimeMillis);
            return false;
        }
    }

    private static ezt m18010a(Context context, List<String> list) {
        ezn com_ushareit_listenit_ezn = new ezn(fan.m18725a() + "/config", "/2/configs");
        Map hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        Map g = m18020b(context).m18001g();
        for (String str : list) {
            Object obj = g.get(str);
            if (obj == null) {
                jSONObject.put(str, 0);
            } else {
                jSONObject.put(str, obj);
            }
        }
        hashMap.put("items", jSONObject.toString());
        hashMap.put("params", ewz.m18329a(context).toString());
        return ewy.m18132a(com_ushareit_listenit_ezn.toString(), hashMap, 1);
    }

    private static void m18013a(Context context, String str, String str2, String str3) {
        m18009a(context).m17991a(str, str2);
        if (!TextUtils.isEmpty(str3)) {
            m18020b(context).m17991a(str, str3);
        }
    }

    private static exz m18009a(Context context) {
        if (f11900b == null) {
            f11900b = new exz(context, "ccf");
        }
        return f11900b;
    }

    private static exz m18020b(Context context) {
        if (f11901c == null) {
            f11901c = new exz(context, "ccf_ver");
        }
        return f11901c;
    }

    public static void m18012a(Context context, String str, String str2, long j) {
        try {
            float[] fArr = new float[]{DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, CloseButton.STROKE_WIDTH, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, CtaButton.TEXT_SIZE_SP, CloseButton.TEXT_SIZE_SP, 30.0f, 50.0f};
            if (j < 0 || j > 120000) {
                j = -1;
            }
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", str);
            linkedHashMap.put("portal", str2);
            linkedHashMap.put("network", etc.m17843a(eyw.m18568a(context)));
            linkedHashMap.put("duration", j == -1 ? "-1" : etc.m17838a((float) (j / 1000), fArr));
            exw.m18449b("CFG.Main", "collectPullResult: " + linkedHashMap.toString());
            esr.m17824c(context, "CFG_PullResult", linkedHashMap);
        } catch (Exception e) {
        }
    }
}
