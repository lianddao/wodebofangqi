package com.ushareit.listenit;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ext {
    public static void m18429a(Context context, boolean z) {
        String str;
        if (z) {
            try {
                str = "ERR_M_GetExtFilesDirs";
            } catch (Exception e) {
                return;
            }
        }
        str = "ERR_M_GetExtFilesDir";
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdk_int", String.valueOf(VERSION.SDK_INT));
        linkedHashMap.put("release", VERSION.RELEASE);
        linkedHashMap.put("model", Build.MODEL);
        linkedHashMap.put("manu", Build.MANUFACTURER);
        esr.m17820b(context, str, linkedHashMap);
    }

    public static void m18428a(Context context) {
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sdk_int", String.valueOf(VERSION.SDK_INT));
            linkedHashMap.put("release", VERSION.RELEASE);
            linkedHashMap.put("model", Build.MODEL);
            linkedHashMap.put("manu", Build.MANUFACTURER);
            esr.m17820b(context, "ERR_C_DocConstract_NotFound", linkedHashMap);
        } catch (Exception e) {
        }
    }
}
