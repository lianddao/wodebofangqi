package com.ushareit.listenit;

import java.util.Iterator;
import java.util.List;

public class fjy {
    private static ecg f12820a;
    private static ecg f12821b;
    private static String f12822c = "";

    public static ecg m19572a(String str) {
        return ecl.m16738a().m16742b().m16736a("users").m16736a(str).m16736a("sharelists");
    }

    public static ecg m19573a(String str, String str2) {
        return ecl.m16738a().m16742b().m16736a("users").m16736a(str).m16736a("playlists").m16736a(str2).m16736a(fnk.KEY_SONGS);
    }

    public static ecg m19575b(String str, String str2) {
        return ecl.m16738a().m16742b().m16736a("users").m16736a(str).m16736a("songs").m16736a(str2);
    }

    public static ecg m19571a() {
        if (f12820a == null || fbb.m18763c(f12822c) || !f12822c.equals(fle.m19717b().m19747m())) {
            f12820a = ecl.m16738a().m16742b().m16736a("users").m16736a(fle.m19717b().m19747m());
            f12822c = fle.m19717b().m19747m();
        }
        return f12820a;
    }

    public static ecg m19574b() {
        if (f12821b == null) {
            f12821b = ecl.m16738a().m16742b().m16736a("nearby").m16736a(gyn.m23252k());
        }
        return f12821b;
    }

    public static ecg m19576c() {
        return ecl.m16738a().m16742b().m16736a("nearby").m16736a("robots");
    }

    String m19577a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append("/").append(append);
        }
        return stringBuilder.toString();
    }

    public glg m19578b(String str) {
        List<glg> b = fqs.m20462b(str);
        for (glg com_ushareit_listenit_glg : b) {
            if (com_ushareit_listenit_glg.f14349q > 0) {
                return com_ushareit_listenit_glg;
            }
            if (com_ushareit_listenit_glg.f14336d == 0) {
                return com_ushareit_listenit_glg;
            }
        }
        for (glg com_ushareit_listenit_glg2 : b) {
            if (com_ushareit_listenit_glg2.f14350r > 0) {
                return com_ushareit_listenit_glg2;
            }
        }
        Iterator it = b.iterator();
        if (it.hasNext()) {
            return (glg) it.next();
        }
        return null;
    }

    public List<glg> m19579c(String str) {
        return fqs.m20462b(str);
    }
}
