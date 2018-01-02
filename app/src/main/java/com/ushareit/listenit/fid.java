package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fid {
    private static fid f12759b = null;
    private String f12760a;

    public static fid m19227a() {
        if (f12759b == null) {
            f12759b = new fid("fm_unknown");
        }
        return f12759b;
    }

    public static fid m19228a(Intent intent) {
        if (intent.hasExtra("PortalType")) {
            f12759b = new fid(intent.getStringExtra("PortalType"));
        } else {
            f12759b = new fid("fm_unknown");
        }
        return f12759b;
    }

    public static fid m19229a(String str) {
        if (TextUtils.isEmpty(str)) {
            f12759b = new fid("fm_unknown");
        } else {
            f12759b = new fid(str);
        }
        return f12759b;
    }

    private fid(String str) {
        this.f12760a = str;
    }

    public String toString() {
        if (TextUtils.isEmpty(this.f12760a)) {
            return "fm_unknown";
        }
        return this.f12760a;
    }

    public static void m19230a(Context context, fid com_ushareit_listenit_fid) {
        if (com_ushareit_listenit_fid != null) {
            gvj.m22906b(context);
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("portal", com_ushareit_listenit_fid.toString());
            linkedHashMap.put("times", String.valueOf(gvj.m22915c(context)));
            exw.m18449b("PortalType", "collectPortalInfo(): " + linkedHashMap.toString());
            esr.m17820b(context, "UF_PortalInfo", linkedHashMap);
        }
    }
}
