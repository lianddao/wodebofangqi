package com.ushareit.listenit;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class hkd implements hjl {
    private final ConcurrentMap<String, hjm> f15568a = new ConcurrentHashMap();

    hkd() {
    }

    public hjm mo2797a(String str) {
        String b = m24038b(str);
        hjm com_ushareit_listenit_hjm = (hjm) this.f15568a.get(b);
        if (com_ushareit_listenit_hjm != null) {
            return com_ushareit_listenit_hjm;
        }
        hkc com_ushareit_listenit_hkc = new hkc(b);
        com_ushareit_listenit_hjm = (hjm) this.f15568a.putIfAbsent(b, com_ushareit_listenit_hkc);
        if (com_ushareit_listenit_hjm == null) {
            return com_ushareit_listenit_hkc;
        }
        return com_ushareit_listenit_hjm;
    }

    static String m24038b(String str) {
        int i = 0;
        if (str == null) {
            return "null";
        }
        int length = str.length();
        if (length <= 23) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(26);
        int i2 = 0;
        do {
            int indexOf = str.indexOf(46, i);
            if (indexOf != -1) {
                stringBuilder.append(str.charAt(i));
                if (indexOf - i > 1) {
                    stringBuilder.append('*');
                }
                stringBuilder.append('.');
                i = indexOf + 1;
                i2 = stringBuilder.length();
            } else {
                indexOf = length - i;
                if (i2 == 0 || i2 + indexOf > 23) {
                    return m24039c(str);
                }
                stringBuilder.append(str, i, length);
                return stringBuilder.toString();
            }
        } while (i2 <= 23);
        return m24039c(str);
    }

    private static String m24039c(String str) {
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || length - (lastIndexOf + 1) > 23) ? '*' + str.substring((length - 23) + 1) : str.substring(lastIndexOf + 1);
    }
}
