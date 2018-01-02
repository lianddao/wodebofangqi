package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fit {
    private static String f12782a = "UI.AnalyticsPlayer";

    public static void m19427a(Context context) {
        exw.m18443a(f12782a, "collectPlayerLaunchPlayer");
        esr.m17807a(context, "UF_MiniPlayerLaunchPlayer");
    }

    public static void m19429a(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12782a, "collectPlayerAction: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_PlayerPlayAction", linkedHashMap);
    }

    public static void m19433b(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12782a, "collectPlayerMoreAction: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_PlayerMoreAction", linkedHashMap);
    }

    public static void m19435c(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12782a, "collectMiniPlayerAction: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_MiniPlayerPlayAction", linkedHashMap);
    }

    public static void m19436d(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("from", str);
        exw.m18443a(f12782a, "collectPopupPlaylist: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_MiniPlayerPopupPlaylist", linkedHashMap);
    }

    public static void m19430a(Context context, String str, glg com_ushareit_listenit_glg) {
        if (com_ushareit_listenit_glg != null) {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("action", str);
            linkedHashMap.put("name", com_ushareit_listenit_glg.f14338f);
            linkedHashMap.put("artist", com_ushareit_listenit_glg.f14339g);
            linkedHashMap.put("album", com_ushareit_listenit_glg.f14340h);
            exw.m18443a(f12782a, "collectPlayerFavorite(): " + linkedHashMap.toString());
            esr.m17820b(context, "UF_PlayerFavorite", linkedHashMap);
        }
    }

    public static void m19437e(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12782a, "collectPlayerBack(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_PlayerBack", linkedHashMap);
    }

    public static void m19432b(Context context) {
        exw.m18443a(f12782a, "collectPlayerAddToPlaylist");
        esr.m17807a(context, "UF_PlayerAddToPlaylist");
    }

    public static void m19434c(Context context) {
        exw.m18443a(f12782a, "collectPlayerSeekPos");
        esr.m17807a(context, "UF_PlayerSeekPos");
    }

    public static void m19438f(Context context, String str) {
        exw.m18443a(f12782a, "collectPlayerShufflePlay: " + str);
        esr.m17808a(context, "UF_PlayerShufflePlay", str);
    }

    public static void m19428a(Context context, int i, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        Object obj = "unknown";
        switch (i) {
            case 1:
                obj = "order";
                break;
            case 2:
                obj = "list_loop";
                break;
            case 3:
                obj = "song_loop";
                break;
        }
        linkedHashMap.put("mode", obj);
        exw.m18443a(f12782a, "collectPlayerPlayMode(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_PlayerPlayMode", linkedHashMap);
    }

    public static void m19431a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", str);
        hashMap.put("action", str2);
        exw.m18443a(f12782a, "collectPlayerScrollPlay: " + hashMap.toString());
        esr.m17820b(eys.m18562a(), "UF_PlayerScrollPlay", hashMap);
    }
}
