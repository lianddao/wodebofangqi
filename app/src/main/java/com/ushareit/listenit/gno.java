package com.ushareit.listenit;

import com.mopub.mobileads.VastIconXmlManager;
import java.util.Map;
import java.util.TreeMap;

public class gno extends gnn {
    private static gno f14471a;

    private gno() {
    }

    public static gno m22524a() {
        if (f14471a == null) {
            f14471a = new gno();
        }
        return f14471a;
    }

    public Map<String, String> m22525a(String str, int i) {
        Map treeMap = new TreeMap();
        treeMap.put("client_id", fqo.m20422d());
        treeMap.put("linked_partitioning", String.valueOf(i));
        treeMap.put(VastIconXmlManager.OFFSET, String.valueOf(i * 10));
        treeMap.put("limit", String.valueOf(10));
        treeMap.put("q", str);
        return treeMap;
    }

    public String m22526b() {
        return "https://api-v2.soundcloud.com" + "/search" + "/tracks?";
    }

    public String m22527b(String str, int i) {
        return m22523a(m22526b(), m22525a(str, i));
    }
}
