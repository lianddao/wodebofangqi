package com.ushareit.listenit;

public class cyn {
    static final /* synthetic */ boolean f9364a = (!cyn.class.desiredAssertionStatus());

    private static long m13375a(cwv<?> com_ushareit_listenit_cwv_) {
        long j = 8;
        if (!((com_ushareit_listenit_cwv_ instanceof cwq) || (com_ushareit_listenit_cwv_ instanceof cwy))) {
            if (com_ushareit_listenit_cwv_ instanceof cwb) {
                j = 4;
            } else if (com_ushareit_listenit_cwv_ instanceof cxi) {
                j = (long) (((String) com_ushareit_listenit_cwv_.mo1643a()).length() + 2);
            } else {
                String valueOf = String.valueOf(com_ushareit_listenit_cwv_.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown leaf node type: ").append(valueOf).toString());
            }
        }
        if (com_ushareit_listenit_cwv_.mo1640f().mo1635b()) {
            return j;
        }
        return m13375a((cwv) com_ushareit_listenit_cwv_.mo1640f()) + (24 + j);
    }

    public static long m13376a(cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cxa.mo1635b()) {
            return 4;
        }
        if (com_ushareit_listenit_cxa.mo1639e()) {
            return m13375a((cwv) com_ushareit_listenit_cxa);
        }
        if (f9364a || (com_ushareit_listenit_cxa instanceof cwf)) {
            long j = 1;
            for (cwz com_ushareit_listenit_cwz : com_ushareit_listenit_cxa) {
                j = m13376a(com_ushareit_listenit_cwz.m13268d()) + ((j + ((long) com_ushareit_listenit_cwz.m13267c().m13144d().length())) + 4);
            }
            return !com_ushareit_listenit_cxa.mo1640f().mo1635b() ? (j + 12) + m13375a((cwv) com_ushareit_listenit_cxa.mo1640f()) : j;
        } else {
            String valueOf = String.valueOf(com_ushareit_listenit_cxa.getClass());
            throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unexpected node type: ").append(valueOf).toString());
        }
    }

    public static int m13377b(cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cxa.mo1635b()) {
            return 0;
        }
        if (com_ushareit_listenit_cxa.mo1639e()) {
            return 1;
        }
        if (f9364a || (com_ushareit_listenit_cxa instanceof cwf)) {
            int i = 0;
            for (cwz d : com_ushareit_listenit_cxa) {
                i = m13377b(d.m13268d()) + i;
            }
            return i;
        }
        String valueOf = String.valueOf(com_ushareit_listenit_cxa.getClass());
        throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unexpected node type: ").append(valueOf).toString());
    }
}
