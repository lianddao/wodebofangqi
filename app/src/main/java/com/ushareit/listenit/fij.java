package com.ushareit.listenit;

import com.umeng.analytics.pro.C0321x;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fij {
    private static String f12771a = "UIAnalyticsDiscovery";

    public static void m19323a() {
        exw.m18443a(f12771a, "collectShowDiscovery");
        esr.m17807a(eys.m18562a(), "UF_ShowDiscovery");
    }

    public static void m19327b() {
        exw.m18443a(f12771a, "collectStartDiscovery");
        esr.m17807a(eys.m18562a(), "UF_StartDiscovery");
    }

    public static void m19325a(long j) {
        String a = hge.m23691a(j);
        exw.m18443a(f12771a, "collectLoadDiscoveryDataSuccess, usedTimeLevel=" + a);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("usedTime", a);
        esr.m17820b(eys.m18562a(), "UF_LoadDiscoveryDataSuccess", linkedHashMap);
    }

    public static void m19330c() {
        exw.m18443a(f12771a, "collectShowDiscoveryContent");
        esr.m17807a(eys.m18562a(), "UF_ShowDiscoveryContent");
    }

    public static void m19326a(String str) {
        exw.m18443a(f12771a, "collectLoadDiscoveryDataFailure, " + str);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", str);
        esr.m17820b(eys.m18562a(), "UF_LoadDiscoveryDataFailure", linkedHashMap);
    }

    public static void m19324a(int i) {
        exw.m18443a(f12771a, "collectClickRecommendPlaylist, cardid=" + i);
        String b = frj.m20713b();
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("card", "" + i);
        linkedHashMap.put(b, "" + i);
        esr.m17820b(eys.m18562a(), "UF_ClickRecommendPlaylist", linkedHashMap);
    }

    public static void m19329b(String str) {
        exw.m18443a(f12771a, "collectClickStreamSongMenu, " + str);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        esr.m17820b(eys.m18562a(), "UF_ClickStreamSongMenu", linkedHashMap);
    }

    public static void m19332d() {
        exw.m18443a(f12771a, "collectPlayStreamSong");
        esr.m17807a(eys.m18562a(), "UF_PlayStreamSong");
    }

    public static void m19334e() {
        exw.m18443a(f12771a, "collectRealPlayStreamSong");
        esr.m17807a(eys.m18562a(), "UF_RealPlayStreamSong");
    }

    public static void m19328b(long j) {
        String a = hge.m23691a(j);
        exw.m18443a(f12771a, "collectSignInAnonymouslySuccess, usedTimeLevel=" + a);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("usedTime", a);
        esr.m17820b(eys.m18562a(), "UF_SignInAnonymouslySuccess", linkedHashMap);
    }

    public static void m19331c(String str) {
        exw.m18443a(f12771a, "collectSignInAnonymouslyFailure, " + str);
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", str);
        esr.m17820b(eys.m18562a(), "UF_SignInAnonymouslyFailure", linkedHashMap);
    }

    public static void m19335f() {
        exw.m18443a(f12771a, "collectPlayVideo");
        esr.m17807a(eys.m18562a(), "UF_PlayVideo");
    }

    public static void m19336g() {
        exw.m18443a(f12771a, "collectRealPlayVideo");
        esr.m17807a(eys.m18562a(), "UF_RealPlayVideo");
    }

    public static void m19333d(String str) {
        exw.m18443a(f12771a, "collectPlayVideoError");
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(C0321x.aF, str);
        esr.m17820b(eys.m18562a(), "UF_PlayVideoError", linkedHashMap);
    }

    public static void m19337h() {
        exw.m18443a(f12771a, "collectPrepareVideo");
        esr.m17807a(eys.m18562a(), "UF_PrepareVideo");
    }
}
