package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class etg implements etj {
    private static etg f11776a = null;
    private ets f11777b;

    public static synchronized etg m17880a() {
        etg com_ushareit_listenit_etg;
        synchronized (etg.class) {
            if (f11776a == null) {
                f11776a = new etg();
            }
            com_ushareit_listenit_etg = f11776a;
        }
        return com_ushareit_listenit_etg;
    }

    public static void m17882a(String str) {
        etk.f11785f = str;
    }

    public static void m17881a(Context context, String str) {
        etk.m17901b(context, str);
    }

    protected etg() {
        eti.m17894a(this);
    }

    public synchronized void m17891b(Context context, String str) {
        etk.m17898a(context, str);
        m17883c(context);
    }

    public void m17884a(Context context) {
        this.f11777b.m17954a(etl.m17902a(context.getClass().getName()));
    }

    public void m17890b(Context context) {
        eto b = etl.m17905b(context.getClass().getName());
        if (b != null) {
            this.f11777b.m17954a(b);
        }
    }

    @Deprecated
    public void m17886a(String str, String str2, long j, Map<String, String> map) {
        List arrayList = new ArrayList();
        for (Entry entry : map.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        }
        m17885a(str, str2, j, arrayList);
    }

    public void m17885a(String str, String str2, long j, List<Pair<String, String>> list) {
        String str3 = "[\\n\u0001]";
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replaceAll("[\\n\u0001]", " ");
        }
        List list2 = null;
        if (list != null) {
            List arrayList = new ArrayList();
            for (Pair pair : list) {
                Object obj;
                Object obj2 = pair.first;
                if (TextUtils.isEmpty((CharSequence) pair.second)) {
                    obj = (String) pair.second;
                } else {
                    obj = ((String) pair.second).replaceAll("[\\n\u0001]", " ");
                }
                arrayList.add(new Pair(obj2, obj));
            }
            list2 = arrayList;
        }
        this.f11777b.m17954a(etl.m17903a(str, str2, j, list2));
    }

    public void m17889b() {
        this.f11777b.m17955a(eua.DEFAULT);
    }

    public boolean m17892c() {
        return this.f11777b.m17956b(eua.DEFAULT);
    }

    public void m17893d() {
        this.f11777b.m17955a(eua.QUIT_APP);
    }

    public synchronized void finalize() {
        this.f11777b.m17953a();
        try {
            super.finalize();
        } catch (Throwable th) {
        }
    }

    private void m17883c(Context context) {
        this.f11777b = new ets(context);
        this.f11777b.m17955a(eua.ENTER_APP);
    }

    public void mo2296a(Thread thread, Throwable th) {
        try {
            eto a = etl.m17904a(th);
            if (a != null) {
                this.f11777b.m17954a(a);
                exw.m18443a("BeylaTracker", "add exception:" + th.getMessage());
            }
        } catch (Exception e) {
        }
    }

    public void mo2297a(Throwable th) {
        euc.m17970a(eys.m18562a(), th);
    }
}
