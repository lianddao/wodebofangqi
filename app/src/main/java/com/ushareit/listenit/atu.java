package com.ushareit.listenit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class atu {
    private static Map<String, Long> f5462a = new ConcurrentHashMap();
    private static Map<String, Long> f5463b = new ConcurrentHashMap();
    private static Map<String, String> f5464c = new ConcurrentHashMap();

    private static long m7142a(String str, aoi com_ushareit_listenit_aoi) {
        if (f5462a.containsKey(str)) {
            return ((Long) f5462a.get(str)).longValue();
        }
        switch (atv.f5465a[com_ushareit_listenit_aoi.ordinal()]) {
            case 1:
                return 15000;
            case 2:
            case 3:
                return -1000;
            default:
                return -1000;
        }
    }

    public static void m7143a(long j, aom com_ushareit_listenit_aom) {
        f5462a.put(m7148d(com_ushareit_listenit_aom), Long.valueOf(j));
    }

    public static void m7144a(String str, aom com_ushareit_listenit_aom) {
        f5464c.put(m7148d(com_ushareit_listenit_aom), str);
    }

    public static boolean m7145a(aom com_ushareit_listenit_aom) {
        String d = m7148d(com_ushareit_listenit_aom);
        if (!f5463b.containsKey(d)) {
            return false;
        }
        return System.currentTimeMillis() - ((Long) f5463b.get(d)).longValue() < m7142a(d, com_ushareit_listenit_aom.m6479b());
    }

    public static void m7146b(aom com_ushareit_listenit_aom) {
        f5463b.put(m7148d(com_ushareit_listenit_aom), Long.valueOf(System.currentTimeMillis()));
    }

    public static String m7147c(aom com_ushareit_listenit_aom) {
        return (String) f5464c.get(m7148d(com_ushareit_listenit_aom));
    }

    private static String m7148d(aom com_ushareit_listenit_aom) {
        int i = 0;
        String str = "%s:%s:%s:%d:%d:%d";
        Object[] objArr = new Object[6];
        objArr[0] = com_ushareit_listenit_aom.m6478a();
        objArr[1] = com_ushareit_listenit_aom.m6479b();
        objArr[2] = com_ushareit_listenit_aom.f5070e;
        objArr[3] = Integer.valueOf(com_ushareit_listenit_aom.m6480c() == null ? 0 : com_ushareit_listenit_aom.m6480c().m1125b());
        if (com_ushareit_listenit_aom.m6480c() != null) {
            i = com_ushareit_listenit_aom.m6480c().m1124a();
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = Integer.valueOf(com_ushareit_listenit_aom.m6481d());
        return String.format(str, objArr);
    }
}
