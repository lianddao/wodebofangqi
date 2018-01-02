package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map.Entry;

public class fia extends etd {
    private static fic f12756a = new fic();

    public fia(boolean z, boolean z2) {
        super(z, z2);
    }

    public void mo2384a(Context context) {
    }

    public void mo2294d(Context context) {
        String name = context.getClass().getName();
        long currentTimeMillis = System.currentTimeMillis();
        if (name != null && name.equals(f12756a.f12757a)) {
            long j = currentTimeMillis - f12756a.f12758b;
        }
        f12756a.f12757a = name;
        f12756a.f12758b = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        eap.m16637a(context).m16638a("PageIn", bundle);
    }

    public void mo2295e(Context context) {
        String name = context.getClass().getName();
        if (name == null || !name.equals(f12756a.f12757a)) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - f12756a.f12758b;
            f12756a.f12758b = currentTimeMillis;
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            eap.m16637a(context).m16638a("PageOut", bundle);
        }
    }

    public void mo2287a(Context context, String str) {
        eap.m16637a(context).m16638a(str, null);
    }

    public void mo2288a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("label", str2);
        eap.m16637a(context).m16638a(str, bundle);
    }

    public void mo2289a(Context context, String str, HashMap<String, String> hashMap) {
        Bundle bundle = new Bundle();
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (!(str2 == null || str3 == null)) {
                bundle.putString(str2, str3);
            }
        }
        eap.m16637a(context).m16638a(str, bundle);
    }

    public static void m19218b(Context context, String str, String str2) {
        eap.m16637a(context).m16639a(str, str2);
    }

    public void mo2292c() {
    }

    public void mo2290a(Context context, Throwable th) {
    }
}
