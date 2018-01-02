package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class ecl {
    private static final Map<String, ecl> f10831a = new HashMap();
    private final eah f10832b;
    private final crr f10833c;
    private final cqg f10834d;
    private cqt f10835e;

    private ecl(eah com_ushareit_listenit_eah, crr com_ushareit_listenit_crr, cqg com_ushareit_listenit_cqg) {
        this.f10832b = com_ushareit_listenit_eah;
        this.f10833c = com_ushareit_listenit_crr;
        this.f10834d = com_ushareit_listenit_cqg;
    }

    public static ecl m16738a() {
        return m16739a(eah.m16613d());
    }

    public static synchronized ecl m16739a(eah com_ushareit_listenit_eah) {
        ecl com_ushareit_listenit_ecl;
        synchronized (ecl.class) {
            if (!f10831a.containsKey(com_ushareit_listenit_eah.m16624b())) {
                String c = com_ushareit_listenit_eah.m16625c().m16634c();
                if (c == null) {
                    throw new ecf("Failed to get FirebaseDatabase instance: FirebaseApp object has no DatabaseURL in its FirebaseOptions object.");
                }
                cyq a = cyr.m13385a(c);
                if (a.f9370b.m12347h()) {
                    cqg com_ushareit_listenit_cqg = new cqg();
                    if (!com_ushareit_listenit_eah.m16626e()) {
                        com_ushareit_listenit_cqg.mo1550c(com_ushareit_listenit_eah.m16624b());
                    }
                    com_ushareit_listenit_cqg.m12288a(com_ushareit_listenit_eah);
                    f10831a.put(com_ushareit_listenit_eah.m16624b(), new ecl(com_ushareit_listenit_eah, a.f9369a, com_ushareit_listenit_cqg));
                } else {
                    String valueOf = String.valueOf(a.f9370b.toString());
                    throw new ecf(new StringBuilder((String.valueOf(c).length() + 114) + String.valueOf(valueOf).length()).append("Configured Database URL '").append(c).append("' is invalid. It should point to the root of a Firebase Database but it includes a path: ").append(valueOf).toString());
                }
            }
            com_ushareit_listenit_ecl = (ecl) f10831a.get(com_ushareit_listenit_eah.m16624b());
        }
        return com_ushareit_listenit_ecl;
    }

    public static String m16740c() {
        return "3.0.0";
    }

    private synchronized void m16741d() {
        if (this.f10835e == null) {
            this.f10835e = crs.m12447a(this.f10834d, this.f10833c, this);
        }
    }

    public ecg m16742b() {
        m16741d();
        return new ecg(this.f10835e, cqq.m12332a());
    }
}
