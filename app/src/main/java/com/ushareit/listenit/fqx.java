package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fqx {
    public static gla m20491a() {
        List<glg> t = fqs.m20487t();
        int i = 0;
        for (glg com_ushareit_listenit_glg : t) {
            i = com_ushareit_listenit_glg.f14355w + i;
        }
        int e = fqk.m20379e();
        int f = fqk.m20380f();
        if (t.size() > e || i > f) {
            gla a = m20492a((List) t);
            if (a == null) {
                return a;
            }
            frf.m20678f();
            fiu.m19439a(eys.m18562a());
            return a;
        }
        Object ai = gvj.ai(eys.m18562a());
        if (TextUtils.isEmpty(ai)) {
            return null;
        }
        String[] split = ai.split("::");
        String str = split[0];
        if (split[1].equals("album")) {
            return fqs.m20463c(str);
        }
        return fqs.m20465d(str);
    }

    public static boolean m20495a(String str, int i) {
        Object ai = gvj.ai(eys.m18562a());
        if (TextUtils.isEmpty(ai)) {
            return false;
        }
        String[] split = ai.split("::");
        String str2 = split[0];
        ai = "";
        if (i == 5) {
            ai = "artist";
        }
        if (i == 6) {
            ai = "album";
        }
        if (str2.equals(str) && split[1].equals(r0)) {
            return true;
        }
        return false;
    }

    public static void m20493a(gla com_ushareit_listenit_gla) {
        if (com_ushareit_listenit_gla instanceof gkw) {
            m20494a(com_ushareit_listenit_gla.mo2562c());
        }
        if (com_ushareit_listenit_gla instanceof gkv) {
            m20497b(com_ushareit_listenit_gla.mo2562c());
        }
    }

    public static void m20496b() {
        gvj.m23031s(eys.m18562a(), "");
        frf.m20678f();
    }

    private static gla m20492a(List<glg> list) {
        gle com_ushareit_listenit_gle;
        List arrayList = new ArrayList();
        gle com_ushareit_listenit_gle2 = new gle();
        for (glg com_ushareit_listenit_glg : list) {
            int i = com_ushareit_listenit_glg.f14355w;
            com_ushareit_listenit_gle2.f14296a = com_ushareit_listenit_glg.f14340h;
            gle com_ushareit_listenit_gle3;
            if (arrayList.contains(com_ushareit_listenit_gle2)) {
                com_ushareit_listenit_gle3 = (gle) arrayList.get(arrayList.indexOf(com_ushareit_listenit_gle2));
                com_ushareit_listenit_gle3.f14298c += i;
            } else {
                com_ushareit_listenit_gle3 = new gle();
                com_ushareit_listenit_gle3.f14296a = com_ushareit_listenit_gle2.f14296a;
                com_ushareit_listenit_gle3.f14297b = 2;
                com_ushareit_listenit_gle3.f14298c = i;
                arrayList.add(com_ushareit_listenit_gle3);
            }
            com_ushareit_listenit_gle2.f14296a = com_ushareit_listenit_glg.f14339g;
            if (arrayList.contains(com_ushareit_listenit_gle2)) {
                com_ushareit_listenit_gle = (gle) arrayList.get(arrayList.indexOf(com_ushareit_listenit_gle2));
                com_ushareit_listenit_gle.f14298c += i;
            } else {
                com_ushareit_listenit_gle = new gle();
                com_ushareit_listenit_gle.f14296a = com_ushareit_listenit_gle2.f14296a;
                com_ushareit_listenit_gle.f14297b = 1;
                com_ushareit_listenit_gle.f14298c = i;
                arrayList.add(com_ushareit_listenit_gle);
            }
        }
        Collections.sort(arrayList, new fqy());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com_ushareit_listenit_gle = (gle) arrayList.get(i2);
            if (com_ushareit_listenit_gle.f14297b == 2) {
                if (!m20499d(com_ushareit_listenit_gle.f14296a)) {
                    gvj.m23031s(eys.m18562a(), com_ushareit_listenit_gle.f14296a + "::" + "album");
                    return fqs.m20463c(com_ushareit_listenit_gle.f14296a);
                }
            } else if (com_ushareit_listenit_gle.f14297b == 1 && !m20498c(com_ushareit_listenit_gle.f14296a)) {
                gvj.m23031s(eys.m18562a(), com_ushareit_listenit_gle.f14296a + "::" + "artist");
                return fqs.m20465d(com_ushareit_listenit_gle.f14296a);
            }
        }
        return null;
    }

    private static void m20494a(String str) {
        gvj.m23025q(eys.m18562a(), gvj.af(eys.m18562a()) + "::" + str);
    }

    private static void m20497b(String str) {
        gvj.m23027r(eys.m18562a(), gvj.ag(eys.m18562a()) + "::" + str);
    }

    private static boolean m20498c(String str) {
        for (String equals : gvj.af(eys.m18562a()).split("::")) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean m20499d(String str) {
        for (String equals : gvj.ag(eys.m18562a()).split("::")) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
