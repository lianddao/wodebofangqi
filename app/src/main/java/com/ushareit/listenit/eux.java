package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import com.mopub.common.Constants;
import java.util.ArrayList;
import java.util.List;

public class eux extends ewx {
    public static Bitmap m18067a(evi com_ushareit_listenit_evi) {
        String str = com_ushareit_listenit_evi.f11958f;
        if (str.startsWith(Constants.HTTP)) {
            return ewx.m18063a(str, m18084d(com_ushareit_listenit_evi));
        }
        return m18068a(str);
    }

    public static void m18077b(evi com_ushareit_listenit_evi) {
        ewx.m18066b(com_ushareit_listenit_evi.f11958f, m18084d(com_ushareit_listenit_evi));
    }

    public static void m18070a(ewf com_ushareit_listenit_ewf) {
        ewx.m18066b(m18087e(com_ushareit_listenit_ewf), m18088f(com_ushareit_listenit_ewf));
    }

    public static void m18073a(ewf com_ushareit_listenit_ewf, boolean z) {
        ewx.m18066b(m18085d(com_ushareit_listenit_ewf, z), m18081c(com_ushareit_listenit_ewf, z));
    }

    public static void m18071a(ewf com_ushareit_listenit_ewf, int i) {
        ewx.m18066b(m18076b(com_ushareit_listenit_ewf, i), m18080c(com_ushareit_listenit_ewf, i));
    }

    public static void m18072a(ewf com_ushareit_listenit_ewf, fcb com_ushareit_listenit_fcb) {
        ewx.m18066b(m18069a(com_ushareit_listenit_fcb), m18075b(com_ushareit_listenit_ewf, com_ushareit_listenit_fcb));
    }

    public static boolean m18074a(Context context, ewf com_ushareit_listenit_ewf) {
        if (fbb.m18760b(context) != fbc.DEVICE_PAD) {
            return false;
        }
        ewl s = com_ushareit_listenit_ewf.m18287s();
        if (s == null) {
            return false;
        }
        if (s instanceof ewk) {
            return ((ewk) s).m18301a();
        }
        return s instanceof ewj ? ((ewj) s).m18298a() : false;
    }

    private static Bitmap m18068a(String str) {
        try {
            return ewx.m18062a(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            throw new fci(101, "resource id error.");
        }
    }

    private static String m18087e(ewf com_ushareit_listenit_ewf) {
        ewl s = com_ushareit_listenit_ewf.m18287s();
        if (s == null || !(s instanceof ewq)) {
            return "";
        }
        return ((ewq) s).m18296g();
    }

    protected static String m18069a(fcb com_ushareit_listenit_fcb) {
        if (com_ushareit_listenit_fcb instanceof exf) {
            return ((exf) com_ushareit_listenit_fcb).mo2308a().f12098c;
        }
        return "";
    }

    private static String m18085d(ewf com_ushareit_listenit_ewf, boolean z) {
        ewl s = com_ushareit_listenit_ewf.m18287s();
        if (s == null || !(s instanceof ewk)) {
            return "";
        }
        ewk com_ushareit_listenit_ewk = (ewk) s;
        if (z && com_ushareit_listenit_ewk.m18301a()) {
            return com_ushareit_listenit_ewk.m18302b();
        }
        return com_ushareit_listenit_ewk.m18296g();
    }

    private static String m18076b(ewf com_ushareit_listenit_ewf, int i) {
        ewl s = com_ushareit_listenit_ewf.m18287s();
        if (s == null || !(s instanceof ewn)) {
            return "";
        }
        return ((ewn) s).m18307a(i);
    }

    public static boolean m18082c(evi com_ushareit_listenit_evi) {
        eyh d = m18084d(com_ushareit_listenit_evi);
        return d != null && d.mo2328c();
    }

    private static eyh m18084d(evi com_ushareit_listenit_evi) {
        return ewx.m18065a(com_ushareit_listenit_evi.f11953a + "_cmd_notify", "cmd");
    }

    private static eyh m18088f(ewf com_ushareit_listenit_ewf) {
        return ewx.m18065a(com_ushareit_listenit_ewf.m18099a(), "cmd");
    }

    public static boolean m18079b(ewf com_ushareit_listenit_ewf, boolean z) {
        eyh c = m18081c(com_ushareit_listenit_ewf, z);
        return c != null && c.mo2328c();
    }

    public static eyh m18081c(ewf com_ushareit_listenit_ewf, boolean z) {
        return ewx.m18065a(com_ushareit_listenit_ewf.m18099a() + (z ? "_land" : ""), "cmd");
    }

    private static eyh m18080c(ewf com_ushareit_listenit_ewf, int i) {
        return ewx.m18065a(com_ushareit_listenit_ewf.m18099a() + "_" + i, "cmd");
    }

    private static eyh m18075b(ewf com_ushareit_listenit_ewf, fcb com_ushareit_listenit_fcb) {
        return ewx.m18065a(com_ushareit_listenit_ewf.m18099a() + "_" + com_ushareit_listenit_fcb.m18339g() + "_" + com_ushareit_listenit_fcb.m18337e().toString(), "cmd");
    }

    public static void m18078b(ewf com_ushareit_listenit_ewf) {
        ewx.m18066b(m18089g(com_ushareit_listenit_ewf), m18090h(com_ushareit_listenit_ewf));
    }

    private static String m18089g(ewf com_ushareit_listenit_ewf) {
        ewl s = com_ushareit_listenit_ewf.m18287s();
        if (s != null) {
            return s.m18290d();
        }
        return "";
    }

    public static boolean m18083c(ewf com_ushareit_listenit_ewf) {
        eyh h = m18090h(com_ushareit_listenit_ewf);
        return h != null && h.mo2328c();
    }

    private static eyh m18090h(ewf com_ushareit_listenit_ewf) {
        return ewx.m18065a(com_ushareit_listenit_ewf.m18099a() + "_bg", "cmd");
    }

    public static List<eyh> m18086d(ewf com_ushareit_listenit_ewf) {
        List<eyh> arrayList = new ArrayList();
        ewl s = com_ushareit_listenit_ewf.m18287s();
        if (s == null) {
            return arrayList;
        }
        eyh f;
        switch (euy.f11912a[com_ushareit_listenit_ewf.m18285q().ordinal()]) {
            case 1:
            case 2:
            case 3:
                f = m18088f(com_ushareit_listenit_ewf);
                if (f != null && f.mo2328c()) {
                    arrayList.add(f);
                    break;
                }
            case 4:
            case 5:
                f = m18088f(com_ushareit_listenit_ewf);
                if (f != null && f.mo2328c()) {
                    arrayList.add(f);
                }
                f = m18081c(com_ushareit_listenit_ewf, true);
                if (f != null && f.mo2328c()) {
                    arrayList.add(f);
                    break;
                }
            case 6:
                if (s instanceof ewn) {
                    ewn com_ushareit_listenit_ewn = (ewn) s;
                    for (int i = 0; i < com_ushareit_listenit_ewn.m18306a(); i++) {
                        eyh c = m18080c(com_ushareit_listenit_ewf, i);
                        if (c != null && c.mo2328c()) {
                            arrayList.add(c);
                        }
                    }
                    break;
                }
                break;
        }
        return arrayList;
    }
}
