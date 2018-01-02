package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fiq {
    public static void m19371a(Context context, int i, gla com_ushareit_listenit_gla) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("page", gyn.m23181a(i));
        linkedHashMap.put("name", com_ushareit_listenit_gla.mo2562c());
        exw.m18443a("UI.AnalyticsMenu", "collectPopupMenu: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_PopupMenu", linkedHashMap);
    }

    public static void m19373a(Context context, String str, int i, String str2, String str3) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("page", gyn.m23181a(i));
        linkedHashMap.put("name", str2);
        linkedHashMap.put("from", str3);
        exw.m18443a("UI.AnalyticsMenu", str + ": " + linkedHashMap.toString());
        esr.m17820b(context, str, linkedHashMap);
    }

    public static void m19372a(Context context, String str, int i, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("page", gyn.m23181a(i));
        linkedHashMap.put("from", str2);
        exw.m18443a("UI.AnalyticsMenu", str + ": " + linkedHashMap.toString());
        esr.m17820b(context, str, linkedHashMap);
    }

    public static void m19374a(Context context, String str, String str2) {
        exw.m18443a("UI.AnalyticsMenu", str + ": " + str2);
        esr.m17808a(context, str, str2);
    }
}
