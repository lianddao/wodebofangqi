package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fio {
    private static String f12776a = "UI.AnalyticsMain";

    public static void m19366a(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12776a, "collectMainLaunchAction(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_MainLaunchAction", linkedHashMap);
    }

    public static void m19367b(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12776a, "collectMainSearchAction(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_MainSearchAction", linkedHashMap);
    }

    public static void m19368c(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12776a, "collectMainScanAction(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_MainScanAction", linkedHashMap);
    }
}
