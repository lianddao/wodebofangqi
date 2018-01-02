package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class aov {
    protected final String f5104a;
    protected final double f5105b;
    protected final double f5106c;
    protected final String f5107d;
    protected final Map<String, String> f5108e;

    public aov(Context context, String str, double d, String str2, Map<String, String> map) {
        this.f5104a = str;
        this.f5105b = ((double) System.currentTimeMillis()) / 1000.0d;
        this.f5106c = d;
        this.f5107d = str2;
        Map hashMap = new HashMap();
        if (!(map == null || map.isEmpty())) {
            hashMap.putAll(map);
        }
        if (mo739c()) {
            hashMap.put("analog", atz.m7161a(asm.m6975a()));
        }
        this.f5108e = m6490a(hashMap);
    }

    public aov(String str, double d, String str2, Map<String, String> map) {
        this(null, str, d, str2, map);
    }

    private static Map<String, String> m6490a(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 != null) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    public abstract apd mo737a();

    public abstract String mo738b();

    public abstract boolean mo739c();

    public String m6494d() {
        return this.f5104a;
    }

    public double m6495e() {
        return this.f5105b;
    }

    public double m6496f() {
        return this.f5106c;
    }

    public String m6497g() {
        return this.f5107d;
    }

    public Map<String, String> m6498h() {
        return this.f5108e;
    }

    public final boolean m6499i() {
        return mo737a() == apd.IMMEDIATE;
    }
}
