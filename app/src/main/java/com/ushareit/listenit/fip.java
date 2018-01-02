package com.ushareit.listenit;

import android.content.Context;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fip {
    private static String f12777a = "UI.AnalyticsManage";

    public static void m19369a(Context context, String str, int i) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(VastExtensionXmlManager.TYPE, gyn.m23181a(i));
        exw.m18443a(f12777a, str + ": " + linkedHashMap);
        esr.m17820b(context, str, linkedHashMap);
    }

    public static void m19370a(Context context, String str, int i, int i2) {
        HashMap linkedHashMap = new LinkedHashMap();
        try {
            int i3 = ((i2 / 5) + 1) * 5;
            linkedHashMap.put("pager", gyn.m23181a(i));
            linkedHashMap.put("count", (i3 - 5) + " ~ " + i3);
        } catch (Exception e) {
        }
        exw.m18443a(f12777a, str + ": " + linkedHashMap);
        esr.m17820b(context, str, linkedHashMap);
    }
}
