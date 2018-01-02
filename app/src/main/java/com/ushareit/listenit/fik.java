package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fik {
    private static String f12772a = "UI.AnalyticsEqualizer";

    public static void m19341a(Context context, String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, str2);
        exw.m18443a(f12772a, "collectEqualizerActionParams: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_EqualizerStrengthParams", linkedHashMap);
    }

    public static void m19343b(Context context, String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, str2);
        exw.m18443a(f12772a, "collectEqualizerValues: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_EqualizerValues", linkedHashMap);
    }

    public static void m19342a(Context context, boolean z) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", z ? "open" : "close");
        exw.m18443a(f12772a, "collectEanableEqualizerState: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_EqualizerEnableState", linkedHashMap);
    }

    public static void m19338a(Context context) {
        exw.m18443a(f12772a, "collectEanableEqualizer");
        esr.m17807a(context, "UF_EqualizerEnable");
    }

    public static void m19339a(Context context, int i, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("bandNum", "" + i);
        linkedHashMap.put("centerFreqs", str);
        exw.m18443a(f12772a, "collectEqualizerBands: " + linkedHashMap.toString());
        esr.m17809a(context, "UF_EqualizerBands", linkedHashMap);
    }

    public static boolean m19344b(Context context) {
        return esr.m17821b(context, "UF_EqualizerBands");
    }

    public static void m19340a(Context context, String str) {
        exw.m18443a(f12772a, "collectEqualizerFailure, " + str);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", str);
        esr.m17820b(context, "UF_EqualizerFailure", linkedHashMap);
    }
}
