package com.ushareit.listenit.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ushareit.listenit.esr;
import com.ushareit.listenit.ete;
import com.ushareit.listenit.exw;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UtmSourceBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        exw.m18454c("UtmSourceReceiver", "start parse referrer");
        if (intent.hasExtra("referrer")) {
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra != null && stringExtra.length() > 0) {
                try {
                    Map a = m6364a(URLDecoder.decode(stringExtra, "UTF-8"));
                    if (a != null) {
                        String str;
                        String str2;
                        String str3;
                        String str4;
                        String str5;
                        stringExtra = (String) a.get("utm_source");
                        if (stringExtra == null) {
                            str = "unknown";
                        } else {
                            str = stringExtra;
                        }
                        stringExtra = (String) a.get("utm_campaign");
                        if (stringExtra == null) {
                            str2 = "unknown";
                        } else {
                            str2 = stringExtra;
                        }
                        stringExtra = (String) a.get("utm_medium");
                        if (stringExtra == null) {
                            str3 = "unknown";
                        } else {
                            str3 = stringExtra;
                        }
                        stringExtra = (String) a.get("utm_term");
                        if (stringExtra == null) {
                            str4 = "unknown";
                        } else {
                            str4 = stringExtra;
                        }
                        stringExtra = (String) a.get("utm_content");
                        if (stringExtra == null) {
                            str5 = "unknown";
                        } else {
                            str5 = stringExtra;
                        }
                        if (str != null && str.length() > 0) {
                            exw.m18454c("UtmSourceReceiver", "utmSource: " + str);
                            ete.m17858b(context, str);
                        }
                        m6365a(context, str, str2, str3, str4, str5);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private void m6365a(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("source", str);
            linkedHashMap.put("campaign", str2);
            linkedHashMap.put("medium", str3);
            linkedHashMap.put("term", str4);
            linkedHashMap.put("content", str5);
            esr.m17820b(context, "Receive_UTMSource", linkedHashMap);
            exw.m18449b("UtmSourceReceiver", "source : " + str + ", campaign : " + str2 + ", medium : " + str3 + ", term : " + str4 + ", content : " + str5);
        } catch (Exception e) {
        }
    }

    private Map<String, String> m6364a(String str) {
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("&");
        if (split.length == 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        int i = 0;
        while (i < split.length) {
            Object obj2;
            String str2 = split[i];
            String[] split2 = str2.split("=");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
                obj2 = split2[0];
            } else if (obj != null) {
                hashMap.put(obj, ((String) hashMap.get(obj)) + "&" + str2);
                obj2 = obj;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        return hashMap;
    }
}
