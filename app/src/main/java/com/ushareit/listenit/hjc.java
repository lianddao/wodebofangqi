package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class hjc {
    public static void m23926a(Context context, int i, int i2) {
        if (context != null) {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cur_ver", i + "");
            linkedHashMap.put("new_ver", i2 + "");
            exw.m18449b("UpdateStats", "collectUpdateDlgShowed: " + linkedHashMap.toString());
            esr.m17820b(context, "UF_UpdateDlgShowed", linkedHashMap);
        }
    }

    public static void m23927a(Context context, int i, int i2, boolean z, boolean z2) {
        if (context != null) {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", z ? "cancel" : "confirm");
            linkedHashMap.put("cur_ver", i + "");
            linkedHashMap.put("new_ver", i2 + "");
            linkedHashMap.put("ignored", z ? String.valueOf(z2) : null);
            exw.m18449b("UpdateStats", "collectUpdateDlgClicked: " + linkedHashMap.toString());
            esr.m17820b(context, "UF_UpdateDlgClicked", linkedHashMap);
        }
    }
}
