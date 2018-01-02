package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fih {
    private static String f12767a = "UI.AnalyticsPlayList";

    public static void m19282a(Context context, int i) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("page", m19281a(i));
        exw.m18443a(f12767a, "collectSwitchPage(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_ALLSongSwitchPage", linkedHashMap);
    }

    private static String m19281a(int i) {
        String str = "unknown";
        switch (i) {
            case 0:
                return "all";
            case 1:
                return "artist";
            case 2:
                return "album";
            case 3:
                return "folder";
            default:
                return str;
        }
    }
}
