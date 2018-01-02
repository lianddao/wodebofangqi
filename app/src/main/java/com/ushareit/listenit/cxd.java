package com.ushareit.listenit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cxd {
    public static int m13274a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa, cwc com_ushareit_listenit_cwc2, cxa com_ushareit_listenit_cxa2) {
        int compareTo = com_ushareit_listenit_cxa.compareTo(com_ushareit_listenit_cxa2);
        return compareTo != 0 ? compareTo : com_ushareit_listenit_cwc.m13143a(com_ushareit_listenit_cwc2);
    }

    public static cxa m13275a(Object obj) {
        return m13276a(obj, cxg.m13288a());
    }

    public static cxa m13276a(Object obj, cxa com_ushareit_listenit_cxa) {
        try {
            Map map;
            Object obj2;
            List list;
            Map hashMap;
            int i;
            String str;
            cxa a;
            Map hashMap2;
            if (obj instanceof Map) {
                map = (Map) obj;
                if (map.containsKey(".priority")) {
                    com_ushareit_listenit_cxa = cxg.m13289a(map.get(".priority"));
                }
                if (map.containsKey(".value")) {
                    obj2 = map.get(".value");
                    if (obj2 == null) {
                        return cwr.m13215j();
                    }
                    if (obj2 instanceof String) {
                        return new cxi((String) obj2, com_ushareit_listenit_cxa);
                    }
                    if (obj2 instanceof Long) {
                        return new cwy((Long) obj2, com_ushareit_listenit_cxa);
                    }
                    if (obj2 instanceof Integer) {
                        return new cwy(Long.valueOf((long) ((Integer) obj2).intValue()), com_ushareit_listenit_cxa);
                    }
                    if (obj2 instanceof Double) {
                        return new cwq((Double) obj2, com_ushareit_listenit_cxa);
                    }
                    if (obj2 instanceof Boolean) {
                        return new cwb((Boolean) obj2, com_ushareit_listenit_cxa);
                    }
                    if (!(obj2 instanceof Map) || (obj2 instanceof List)) {
                        if (obj2 instanceof Map) {
                            list = (List) obj2;
                            hashMap = new HashMap(list.size());
                            for (i = 0; i < list.size(); i++) {
                                str = i;
                                a = m13275a(list.get(i));
                                if (!a.mo1635b()) {
                                    hashMap.put(cwc.m13139a(str), a);
                                }
                            }
                            map = hashMap;
                        } else {
                            map = (Map) obj2;
                            if (map.containsKey(".sv")) {
                                return new cwp(map, com_ushareit_listenit_cxa);
                            }
                            hashMap2 = new HashMap(map.size());
                            for (String str2 : map.keySet()) {
                                if (!str2.startsWith(".")) {
                                    a = m13275a(map.get(str2));
                                    if (!a.mo1635b()) {
                                        hashMap2.put(cwc.m13139a(str2), a);
                                    }
                                }
                            }
                            map = hashMap2;
                        }
                        return map.isEmpty() ? cwr.m13215j() : new cwf(cnk.m11907a(map, cwf.f9256a), com_ushareit_listenit_cxa);
                    } else {
                        String str3 = "Failed to parse node with class ";
                        String valueOf = String.valueOf(obj2.getClass().toString());
                        throw new ecf(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                }
            }
            obj2 = obj;
            if (obj2 == null) {
                return cwr.m13215j();
            }
            if (obj2 instanceof String) {
                return new cxi((String) obj2, com_ushareit_listenit_cxa);
            }
            if (obj2 instanceof Long) {
                return new cwy((Long) obj2, com_ushareit_listenit_cxa);
            }
            if (obj2 instanceof Integer) {
                return new cwy(Long.valueOf((long) ((Integer) obj2).intValue()), com_ushareit_listenit_cxa);
            }
            if (obj2 instanceof Double) {
                return new cwq((Double) obj2, com_ushareit_listenit_cxa);
            }
            if (obj2 instanceof Boolean) {
                return new cwb((Boolean) obj2, com_ushareit_listenit_cxa);
            }
            if (obj2 instanceof Map) {
            }
            if (obj2 instanceof Map) {
                list = (List) obj2;
                hashMap = new HashMap(list.size());
                for (i = 0; i < list.size(); i++) {
                    str = i;
                    a = m13275a(list.get(i));
                    if (!a.mo1635b()) {
                        hashMap.put(cwc.m13139a(str), a);
                    }
                }
                map = hashMap;
            } else {
                map = (Map) obj2;
                if (map.containsKey(".sv")) {
                    return new cwp(map, com_ushareit_listenit_cxa);
                }
                hashMap2 = new HashMap(map.size());
                for (String str22 : map.keySet()) {
                    if (!str22.startsWith(".")) {
                        a = m13275a(map.get(str22));
                        if (!a.mo1635b()) {
                            hashMap2.put(cwc.m13139a(str22), a);
                        }
                    }
                }
                map = hashMap2;
            }
            if (map.isEmpty()) {
            }
        } catch (Throwable e) {
            throw new ecf("Failed to parse node", e);
        }
    }
}
