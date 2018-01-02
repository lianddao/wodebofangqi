package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fis {
    private static String f12781a = "UI.AnalyticsPlayList";

    public static void m19420a(Context context, int i) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("page", gyn.m23181a(i));
        exw.m18443a(f12781a, "collectPlaylistDragSort: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_PlaylistDragSort", linkedHashMap);
    }

    public static void m19423b(Context context, int i) {
        m19421a(context, gyn.m23181a(i) + "_addtoplaylist");
    }

    public static void m19421a(Context context, String str) {
        exw.m18443a(f12781a, "collectNewPlaylist: from=" + str);
        esr.m17808a(context, "UF_PlaylistNewPlaylist", str);
    }

    public static void m19424b(Context context, String str) {
        exw.m18443a(f12781a, "collectPlaylistName: " + str);
        esr.m17808a(context, "UF_PlaylistName", str);
    }

    public static void m19425c(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12781a, "collectActivePlaylistAction: " + linkedHashMap);
        esr.m17820b(context, "UF_ActivePlaylistAction", linkedHashMap);
    }

    public static void m19422a(Context context, String str, String str2) {
        exw.m18443a(f12781a, "collectPlaylistOperate: " + str2);
        esr.m17808a(context, "UF_PlaylistOperate", str2);
        esr.m17807a(context, str);
    }

    public static void m19426d(Context context, String str) {
        exw.m18443a(f12781a, "collectEnterAddToPlaylist: " + str);
        esr.m17808a(context, "UF_EnterAddToPlaylist", str);
    }
}
