package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class crs {
    private static final crs f8829a = new crs();
    private final Map<cqd, Map<String, cqt>> f8830b = new HashMap();

    public static cqt m12447a(cqd com_ushareit_listenit_cqd, crr com_ushareit_listenit_crr, ecl com_ushareit_listenit_ecl) {
        return f8829a.m12448b(com_ushareit_listenit_cqd, com_ushareit_listenit_crr, com_ushareit_listenit_ecl);
    }

    private cqt m12448b(cqd com_ushareit_listenit_cqd, crr com_ushareit_listenit_crr, ecl com_ushareit_listenit_ecl) {
        cqt com_ushareit_listenit_cqt;
        com_ushareit_listenit_cqd.m12271b();
        String str = com_ushareit_listenit_crr.f8825a;
        String str2 = com_ushareit_listenit_crr.f8827c;
        str2 = new StringBuilder((String.valueOf(str).length() + 9) + String.valueOf(str2).length()).append("https://").append(str).append("/").append(str2).toString();
        synchronized (this.f8830b) {
            if (!this.f8830b.containsKey(com_ushareit_listenit_cqd)) {
                this.f8830b.put(com_ushareit_listenit_cqd, new HashMap());
            }
            Map map = (Map) this.f8830b.get(com_ushareit_listenit_cqd);
            if (map.containsKey(str2)) {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
            com_ushareit_listenit_cqt = new cqt(com_ushareit_listenit_crr, com_ushareit_listenit_cqd, com_ushareit_listenit_ecl);
            map.put(str2, com_ushareit_listenit_cqt);
        }
        return com_ushareit_listenit_cqt;
    }
}
