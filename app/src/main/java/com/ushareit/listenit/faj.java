package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public enum faj {
    IMEI('i'),
    SOC('s'),
    MAC('m'),
    UUID('u'),
    ANDROID('a'),
    BUILD('b'),
    UNKNOWN('u');
    
    private static final Map<Character, faj> f12319i = null;
    private char f12321h;

    static {
        f12319i = new HashMap();
        faj[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            faj com_ushareit_listenit_faj = values[i];
            f12319i.put(Character.valueOf(com_ushareit_listenit_faj.f12321h), com_ushareit_listenit_faj);
            i++;
        }
    }

    public static faj m18713a(char c) {
        faj com_ushareit_listenit_faj = (faj) f12319i.get(Character.valueOf(c));
        return com_ushareit_listenit_faj == null ? UNKNOWN : com_ushareit_listenit_faj;
    }

    private faj(char c) {
        this.f12321h = c;
    }

    public char m18714a() {
        return this.f12321h;
    }

    public String m18715b() {
        switch (fai.f12311a[ordinal()]) {
            case 1:
                return "imei";
            case 2:
                return "soc";
            case 3:
                return "mac";
            case 4:
                return "uuid";
            case 5:
                return "android_id";
            case 6:
                return "build";
            default:
                return "unknown";
        }
    }
}
