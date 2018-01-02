package com.ushareit.listenit;

public class fre {
    public static int m20624a() {
        return frf.m20683i() + frg.m20700e();
    }

    public static int m20628b() {
        return frf.m20682h() + frg.m20698d();
    }

    public static boolean m20627a(glg com_ushareit_listenit_glg) {
        if (com_ushareit_listenit_glg == null) {
            return false;
        }
        return !gyn.m23260p(com_ushareit_listenit_glg.f14342j) ? frf.m20664b(com_ushareit_listenit_glg.f14334b) : frg.m20695b(com_ushareit_listenit_glg);
    }

    public static void m20626a(glg com_ushareit_listenit_glg, boolean z) {
        if (com_ushareit_listenit_glg != null) {
            if (gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
                frg.m20690a(com_ushareit_listenit_glg, z);
            } else {
                frf.m20648a(com_ushareit_listenit_glg, z);
            }
            fxh.aa();
        }
    }

    public static synchronized void m20625a(glg com_ushareit_listenit_glg, long j) {
        synchronized (fre.class) {
            if (gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
                frg.m20689a(com_ushareit_listenit_glg, j);
            } else {
                frf.m20662b(com_ushareit_listenit_glg, j);
            }
            fxh.aa();
        }
    }

    public static synchronized void m20629b(glg com_ushareit_listenit_glg) {
        synchronized (fre.class) {
            if (gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
                frg.m20699d(com_ushareit_listenit_glg);
            } else {
                frf.m20679f(com_ushareit_listenit_glg);
            }
            fxh.aa();
        }
    }
}
