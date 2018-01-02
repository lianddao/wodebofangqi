package com.ushareit.listenit;

import android.text.TextUtils;
import com.umeng.analytics.C0154a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class etf extends eyr {
    private String f11772a;
    private long f11773b;
    private long f11774c;
    private long f11775d;

    public void m17874a(String str, LinkedHashMap<String, String> linkedHashMap) {
        this.f11772a = str;
        this.f11773b = System.currentTimeMillis();
        this.f11775d = System.currentTimeMillis();
        m17868b(linkedHashMap);
    }

    public void m17872a() {
        if (this.f11775d == 0) {
            this.f11775d = System.currentTimeMillis();
        }
    }

    public void m17876b() {
        if (this.f11775d > 0) {
            this.f11774c += System.currentTimeMillis() - this.f11775d;
            this.f11775d = 0;
        }
    }

    public void m17877c() {
        m17875a(null);
    }

    public void m17875a(LinkedHashMap<String, String> linkedHashMap) {
        if (this.f11775d > 0) {
            this.f11774c += System.currentTimeMillis() - this.f11775d;
            this.f11775d = 0;
        }
        m17869c(linkedHashMap);
    }

    public void m17873a(String str, String str2) {
        m17718b(str, str2);
    }

    public String m17871a(String str) {
        return m17721d(str);
    }

    private void m17868b(LinkedHashMap<String, String> linkedHashMap) {
        HashMap linkedHashMap2 = new LinkedHashMap();
        if (linkedHashMap != null) {
            for (Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str)) {
                    linkedHashMap2.put(str, str2);
                }
            }
        }
        esr.m17820b(eys.m18562a(), "PV_Enter" + this.f11772a, linkedHashMap2);
    }

    private void m17869c(LinkedHashMap<String, String> linkedHashMap) {
        HashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("duration", m17870a(System.currentTimeMillis() - this.f11773b));
        linkedHashMap2.put("act_duration", m17870a(this.f11774c));
        if (linkedHashMap != null) {
            for (Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str)) {
                    linkedHashMap2.put(str, str2);
                }
            }
        }
        esr.m17820b(eys.m18562a(), "PV_Leave" + this.f11772a, linkedHashMap2);
    }

    public String m17870a(long j) {
        if (j < 1000) {
            return (Math.round(((double) j) / 100.0d) * 100) + "ms";
        }
        if (j < 60000) {
            return Math.round(((double) j) / 1000.0d) + "s";
        }
        if (j < C0154a.f2954j) {
            return Math.round(((double) j) / 60000.0d) + "m";
        }
        if (j < C0154a.f2953i) {
            return Math.round(((double) j) / 3600000.0d) + "h";
        }
        return Math.round(((double) j) / 8.64E7d) + "d";
    }
}
