package com.ushareit.listenit;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class alh {
    private static final Set<alk> f4657a = new HashSet();
    private static final Map<arz, String> f4658b = new ConcurrentHashMap();

    static {
        for (alk com_ushareit_listenit_alk : alk.m6050a()) {
            Class cls;
            switch (ali.f4659a[com_ushareit_listenit_alk.f4679l.ordinal()]) {
                case 1:
                    cls = akv.class;
                    break;
                case 2:
                    cls = akx.class;
                    break;
                case 3:
                    cls = amp.class;
                    break;
                case 4:
                    cls = aml.class;
                    break;
                case 5:
                    cls = amr.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (cls != null) {
                Class cls2 = com_ushareit_listenit_alk.f4676i;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName(com_ushareit_listenit_alk.f4677j);
                    } catch (ClassNotFoundException e) {
                    }
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    f4657a.add(com_ushareit_listenit_alk);
                }
            }
        }
    }

    public static aku m6045a(alj com_ushareit_listenit_alj, arz com_ushareit_listenit_arz) {
        try {
            alk b = m6048b(com_ushareit_listenit_alj, com_ushareit_listenit_arz);
            if (b != null && f4657a.contains(b)) {
                Class cls = b.f4676i;
                if (cls == null) {
                    cls = Class.forName(b.f4677j);
                }
                return (aku) cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static aku m6046a(String str, arz com_ushareit_listenit_arz) {
        return m6045a(alj.m6049a(str), com_ushareit_listenit_arz);
    }

    public static String m6047a(arz com_ushareit_listenit_arz) {
        if (f4658b.containsKey(com_ushareit_listenit_arz)) {
            return (String) f4658b.get(com_ushareit_listenit_arz);
        }
        Set hashSet = new HashSet();
        for (alk com_ushareit_listenit_alk : f4657a) {
            if (com_ushareit_listenit_alk.f4679l == com_ushareit_listenit_arz) {
                hashSet.add(com_ushareit_listenit_alk.f4678k.toString());
            }
        }
        String a = atg.m7126a(hashSet, ",");
        f4658b.put(com_ushareit_listenit_arz, a);
        return a;
    }

    private static alk m6048b(alj com_ushareit_listenit_alj, arz com_ushareit_listenit_arz) {
        for (alk com_ushareit_listenit_alk : f4657a) {
            if (com_ushareit_listenit_alk.f4678k == com_ushareit_listenit_alj && com_ushareit_listenit_alk.f4679l == com_ushareit_listenit_arz) {
                return com_ushareit_listenit_alk;
            }
        }
        return null;
    }
}
