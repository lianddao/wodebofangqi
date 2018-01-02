package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class cjt implements dqj {
    private final Map<String, TreeMap<String, byte[]>> f8378a;
    private final Status f8379b;
    private final long f8380c;

    public cjt(Status status, Map<String, TreeMap<String, byte[]>> map) {
        this(status, map, -1);
    }

    public cjt(Status status, Map<String, TreeMap<String, byte[]>> map, long j) {
        this.f8379b = status;
        this.f8378a = map;
        this.f8380c = j;
    }

    public long mo1383a() {
        return this.f8380c;
    }

    public boolean m11474a(String str, String str2) {
        return (this.f8378a == null || this.f8378a.get(str2) == null) ? false : ((TreeMap) this.f8378a.get(str2)).get(str) != null;
    }

    public byte[] mo1384a(String str, byte[] bArr, String str2) {
        return m11474a(str, str2) ? (byte[]) ((TreeMap) this.f8378a.get(str2)).get(str) : bArr;
    }

    public Status mo260b() {
        return this.f8379b;
    }

    public Map<String, Set<String>> mo1385c() {
        Map<String, Set<String>> hashMap = new HashMap();
        if (this.f8378a != null) {
            for (String str : this.f8378a.keySet()) {
                Map map = (Map) this.f8378a.get(str);
                if (map != null) {
                    hashMap.put(str, map.keySet());
                }
            }
        }
        return hashMap;
    }
}
