package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class cxh {
    static final /* synthetic */ boolean f9304a = (!cxh.class.desiredAssertionStatus());
    private final cqq f9305b;
    private final cqq f9306c;
    private final cxa f9307d;

    public cxh(cpg com_ushareit_listenit_cpg) {
        cqq com_ushareit_listenit_cqq = null;
        List a = com_ushareit_listenit_cpg.m12169a();
        this.f9305b = a != null ? new cqq(a) : null;
        List b = com_ushareit_listenit_cpg.m12170b();
        if (b != null) {
            com_ushareit_listenit_cqq = new cqq(b);
        }
        this.f9306c = com_ushareit_listenit_cqq;
        this.f9307d = cxd.m13275a(com_ushareit_listenit_cpg.m12171c());
    }

    private cxa m13291a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, cxa com_ushareit_listenit_cxa2) {
        Object obj = 1;
        int c = this.f9305b == null ? 1 : com_ushareit_listenit_cqq.m12341c(this.f9305b);
        int c2 = this.f9306c == null ? -1 : com_ushareit_listenit_cqq.m12341c(this.f9306c);
        Object obj2 = (this.f9305b == null || !com_ushareit_listenit_cqq.m12340b(this.f9305b)) ? null : 1;
        if (this.f9306c == null || !com_ushareit_listenit_cqq.m12340b(this.f9306c)) {
            obj = null;
        }
        if (c > 0 && c2 < 0 && r1 == null) {
            return com_ushareit_listenit_cxa2;
        }
        if (c > 0 && r1 != null && com_ushareit_listenit_cxa2.mo1639e()) {
            return com_ushareit_listenit_cxa2;
        }
        if (c <= 0 || c2 != 0) {
            if (obj2 != null || r1 != null) {
                Collection hashSet = new HashSet();
                for (cwz c3 : com_ushareit_listenit_cxa) {
                    hashSet.add(c3.m13267c());
                }
                for (cwz c32 : com_ushareit_listenit_cxa2) {
                    hashSet.add(c32.m13267c());
                }
                List<cwc> arrayList = new ArrayList(hashSet.size() + 1);
                arrayList.addAll(hashSet);
                if (!(com_ushareit_listenit_cxa2.mo1640f().mo1635b() && com_ushareit_listenit_cxa.mo1640f().mo1635b())) {
                    arrayList.add(cwc.m13142c());
                }
                cxa com_ushareit_listenit_cxa3 = com_ushareit_listenit_cxa;
                for (cwc com_ushareit_listenit_cwc : arrayList) {
                    cxa c4 = com_ushareit_listenit_cxa.mo1637c(com_ushareit_listenit_cwc);
                    cxa a = m13291a(com_ushareit_listenit_cqq.m12338a(com_ushareit_listenit_cwc), com_ushareit_listenit_cxa.mo1637c(com_ushareit_listenit_cwc), com_ushareit_listenit_cxa2.mo1637c(com_ushareit_listenit_cwc));
                    com_ushareit_listenit_cxa3 = a != c4 ? com_ushareit_listenit_cxa3.mo1631a(com_ushareit_listenit_cwc, a) : com_ushareit_listenit_cxa3;
                }
                return com_ushareit_listenit_cxa3;
            } else if (f9304a || c2 > 0 || c <= 0) {
                return com_ushareit_listenit_cxa;
            } else {
                throw new AssertionError();
            }
        } else if (!f9304a && r1 == null) {
            throw new AssertionError();
        } else if (f9304a || !com_ushareit_listenit_cxa2.mo1639e()) {
            return com_ushareit_listenit_cxa.mo1639e() ? cwr.m13215j() : com_ushareit_listenit_cxa;
        } else {
            throw new AssertionError();
        }
    }

    public cxa m13292a(cxa com_ushareit_listenit_cxa) {
        return m13291a(cqq.m12332a(), com_ushareit_listenit_cxa, this.f9307d);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9305b);
        String valueOf2 = String.valueOf(this.f9306c);
        String valueOf3 = String.valueOf(this.f9307d);
        return new StringBuilder(((String.valueOf(valueOf).length() + 55) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("RangeMerge{optExclusiveStart=").append(valueOf).append(", optInclusiveEnd=").append(valueOf2).append(", snap=").append(valueOf3).append("}").toString();
    }
}
