package com.ushareit.listenit;

import android.content.Context;

public final class fan {
    private static boolean f12325a = false;
    private static boolean f12326b = false;

    public static String m18725a() {
        return m18727a(eys.m18562a()) ? "http://54.223.197.126:8090/relayserver" : "http://cf.ushareit.com/relayserver";
    }

    public static String m18728b() {
        return m18727a(eys.m18562a()) ? "http://54.223.197.126:8050" : "http://cm.ushareit.com/relayserver";
    }

    public static boolean m18727a(Context context) {
        if (!f12326b) {
            exu.m18430a((Object) context);
            exz com_ushareit_listenit_exz = new exz(context);
            if (com_ushareit_listenit_exz.m18000e("USE_TEST_SERVERS")) {
                f12325a = com_ushareit_listenit_exz.m17992a("USE_TEST_SERVERS", f12325a);
            } else if ("TEST_SERVERS".equalsIgnoreCase(fac.m18682a())) {
                f12325a = true;
            }
            f12326b = true;
        }
        return f12325a;
    }

    public static void m18726a(Context context, boolean z) {
        f12325a = z;
        f12326b = true;
        new exz(context).m17997b("USE_TEST_SERVERS", f12325a);
    }
}
