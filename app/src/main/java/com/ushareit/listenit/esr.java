package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public final class esr {
    private static Context f11721a = null;
    private static esq f11722b = null;
    private static esr f11723c = null;
    private List<etd> f11724d = null;

    public static void m17806a(Context context, esq com_ushareit_listenit_esq) {
        f11721a = context;
        f11722b = com_ushareit_listenit_esq;
    }

    private static esr m17822c() {
        if (f11723c == null) {
            synchronized (esr.class) {
                if (f11723c == null) {
                    exw.m18443a("Stats", "Stats inited");
                    f11723c = new esr(f11722b.mo2383a(f11721a));
                }
            }
        }
        return f11723c;
    }

    private esr(List<etd> list) {
        this.f11724d = list;
    }

    public static void m17805a(Context context) {
        for (etd a : m17822c().f11724d) {
            a.mo2384a(context);
        }
    }

    public static void m17818b(Context context) {
        for (etd b : m17822c().f11724d) {
            b.mo2291b(context);
        }
    }

    public static boolean m17816a(Context context, Class<?> cls) {
        for (etd com_ushareit_listenit_etd : m17822c().f11724d) {
            if (cls.isInstance(com_ushareit_listenit_etd)) {
                return com_ushareit_listenit_etd.mo2293c(context);
            }
        }
        return false;
    }

    public static void m17804a() {
        for (etd com_ushareit_listenit_etd : m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b()) {
                com_ushareit_listenit_etd.mo2292c();
            }
        }
    }

    public static boolean m17814a(int i) {
        return m17815a(1, i);
    }

    public static boolean m17815a(int i, int i2) {
        return new Random().nextInt(i2) < i;
    }

    public static void m17823c(Context context) {
        faq.m18738b(new ess("Stats", context));
    }

    public static void m17825d(Context context) {
        faq.m18738b(new esw("Stats", context));
    }

    public static void m17807a(Context context, String str) {
        faq.m18738b(new esx("Stats", context, str));
    }

    public static void m17808a(Context context, String str, String str2) {
        faq.m18738b(new esy("Stats", context, str, str2));
    }

    public static void m17819b(Context context, String str, String str2) {
        exz com_ushareit_listenit_exz = new exz(context);
        String str3 = "Analytics" + str;
        if (!com_ushareit_listenit_exz.m17992a(str3, false)) {
            faq.m18738b(new esz("Stats", context, str, str2, com_ushareit_listenit_exz, str3));
        }
    }

    public static void m17809a(Context context, String str, HashMap<String, String> hashMap) {
        exz com_ushareit_listenit_exz = new exz(context);
        String str2 = "Analytics" + str;
        if (!com_ushareit_listenit_exz.m17992a(str2, false)) {
            faq.m18738b(new eta("Stats", context, str, hashMap, com_ushareit_listenit_exz, str2));
        }
    }

    public static boolean m17821b(Context context, String str) {
        return new exz(context).m17992a("Analytics" + str, false);
    }

    public static void m17820b(Context context, String str, HashMap<String, String> hashMap) {
        faq.m18738b(new etb("Stats", context, str, hashMap));
    }

    public static void m17812a(Context context, String str, HashMap<String, String> hashMap, Class<?> cls) {
        faq.m18738b(new est("Stats", cls, context, str, hashMap));
    }

    public static void m17824c(Context context, String str, HashMap<String, String> hashMap) {
        m17810a(context, str, (HashMap) hashMap, 100);
    }

    public static void m17826d(Context context, String str, HashMap<String, String> hashMap) {
        m17810a(context, str, (HashMap) hashMap, 10);
    }

    public static void m17810a(Context context, String str, HashMap<String, String> hashMap, int i) {
        m17811a(context, str, hashMap, 1, i);
    }

    public static void m17811a(Context context, String str, HashMap<String, String> hashMap, int i, int i2) {
        if (m17815a(i, i2)) {
            faq.m18738b(new esu("Stats", context, str, hashMap));
        }
    }

    public static void m17813a(Context context, Throwable th) {
        faq.m18738b(new esv("Stats", context, th));
    }
}
