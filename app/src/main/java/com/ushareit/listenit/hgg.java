package com.ushareit.listenit;

import android.content.Context;

public class hgg {
    private static agb f15399a;

    private static synchronized agb m23705b() {
        agb com_ushareit_listenit_agb;
        synchronized (hgg.class) {
            if (f15399a == null) {
                f15399a = m23702a(eys.m18562a());
            }
            com_ushareit_listenit_agb = f15399a;
        }
        return com_ushareit_listenit_agb;
    }

    public static boolean m23704a(String str) {
        if (fbb.m18763c(str)) {
            return false;
        }
        return m23705b().m5555b(str);
    }

    public static String m23706b(String str) {
        if (fbb.m18763c(str)) {
            return str;
        }
        String a = m23705b().m5552a(str);
        if (a.equals(str)) {
            hgf.m23697b();
            m23703a();
            a = m23705b().m5552a(str);
        } else {
            hgf.m23692a();
        }
        return a;
    }

    public static synchronized void m23703a() {
        synchronized (hgg.class) {
            if (f15399a != null) {
                m23705b().m5554a();
                f15399a = null;
            }
        }
    }

    private static agb m23702a(Context context) {
        return new agd(context).m5558a(1073741824).m5557a();
    }
}
