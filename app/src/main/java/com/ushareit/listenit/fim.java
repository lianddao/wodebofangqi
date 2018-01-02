package com.ushareit.listenit;

import android.content.Context;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fim {
    private static String f12774a = "UI.UIAnalyticsLockScreen";

    public static void m19346a(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12774a, "collectLockScreenAction: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_LockScreenAction", linkedHashMap);
    }

    public static void m19347b(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(VastExtensionXmlManager.TYPE, str);
        exw.m18443a(f12774a, "collectLockScreenType: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_LockScreenType", linkedHashMap);
    }

    public static void m19348c(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("time", str);
        exw.m18443a(f12774a, "LockScreenShowDuration: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_LockScreenShowDuration", linkedHashMap);
    }
}
