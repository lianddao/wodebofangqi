package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class cru {
    public static cpz m12449a(cpz com_ushareit_listenit_cpz, Map<String, Object> map) {
        cpz a = cpz.m12232a();
        Iterator it = com_ushareit_listenit_cpz.iterator();
        cpz com_ushareit_listenit_cpz2 = a;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            com_ushareit_listenit_cpz2 = com_ushareit_listenit_cpz2.m12238a((cqq) entry.getKey(), m12451a((cxa) entry.getValue(), (Map) map));
        }
        return com_ushareit_listenit_cpz2;
    }

    public static cry m12450a(cry com_ushareit_listenit_cry, Map<String, Object> map) {
        cry com_ushareit_listenit_cry2 = new cry();
        com_ushareit_listenit_cry.m12462a(new cqq(""), new crv(com_ushareit_listenit_cry2, map));
        return com_ushareit_listenit_cry2;
    }

    public static cxa m12451a(cxa com_ushareit_listenit_cxa, Map<String, Object> map) {
        Object a = com_ushareit_listenit_cxa.mo1640f().mo1643a();
        if (a instanceof Map) {
            Map map2 = (Map) a;
            if (map2.containsKey(".sv")) {
                a = map.get((String) map2.get(".sv"));
            }
        }
        cxa a2 = cxg.m13289a(a);
        if (com_ushareit_listenit_cxa.mo1639e()) {
            a = m12452a(com_ushareit_listenit_cxa.mo1643a(), (Map) map);
            return (a.equals(com_ushareit_listenit_cxa.mo1643a()) && a2.equals(com_ushareit_listenit_cxa.mo1640f())) ? com_ushareit_listenit_cxa : cxd.m13276a(a, a2);
        } else if (com_ushareit_listenit_cxa.mo1635b()) {
            return com_ushareit_listenit_cxa;
        } else {
            cwf com_ushareit_listenit_cwf = (cwf) com_ushareit_listenit_cxa;
            crx com_ushareit_listenit_crx = new crx(com_ushareit_listenit_cwf);
            com_ushareit_listenit_cwf.m13159a(new crw(map, com_ushareit_listenit_crx));
            return !com_ushareit_listenit_crx.m12459a().mo1640f().equals(a2) ? com_ushareit_listenit_crx.m12459a().mo1645b(a2) : com_ushareit_listenit_crx.m12459a();
        }
    }

    public static Object m12452a(Object obj, Map<String, Object> map) {
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (!map2.containsKey(".sv")) {
            return obj;
        }
        String str = (String) map2.get(".sv");
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static Map<String, Object> m12453a(cyh com_ushareit_listenit_cyh) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(com_ushareit_listenit_cyh.mo1664a()));
        return hashMap;
    }
}
