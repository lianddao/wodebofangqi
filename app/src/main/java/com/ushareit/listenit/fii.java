package com.ushareit.listenit;

import android.content.Context;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0321x;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class fii {
    private static String f12768a = "UI.AnalyticsCommon";
    private static final int[] f12769b = new int[]{5, 10, 15, 20, 25, 30, 40, 50, 60, 80, 100, 125, CtaButton.WIDTH_DIPS, 200, 250, 300, 400, 600, 1000, 1500, 2000};
    private static final int[] f12770c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 25, 30, 40, 50, 70, 90, 120, CtaButton.WIDTH_DIPS, 200};

    public static void m19286a(Context context) {
        esr.m17807a(context, "UF_MainStartUp");
        long a = gvj.m22890a(context);
        if (a != 0) {
            esr.m17808a(context, "UF_MainStartUpInterval", String.valueOf((int) ((System.currentTimeMillis() - a) / C0154a.f2953i)));
        }
        if (m19318e(context)) {
            gvj.m22908b(context, (long) (gvj.m22926d(context) + 1));
            return;
        }
        int d = gvj.m22926d(context);
        if (d != 0) {
            esr.m17808a(context, "UF_MainStartUpNumSingleDay", String.valueOf(d));
        }
        gvj.m22908b(context, 1);
    }

    private static boolean m19318e(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).equals(simpleDateFormat.format(Long.valueOf(gvj.m22890a(context))));
    }

    public static void m19297a(Context context, String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        linkedHashMap.put("from", str2);
        exw.m18443a(f12768a, "collectClickNavigationItem(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_NavigationItemAction", linkedHashMap);
    }

    public static void m19295a(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12768a, "collectClickSettingItem(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_SettingItemAction", linkedHashMap);
    }

    public static void m19304b(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        exw.m18443a(f12768a, "collectClickAboutItem(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_AboutItemAction", linkedHashMap);
    }

    public static void m19293a(Context context, gla com_ushareit_listenit_gla) {
        if (com_ushareit_listenit_gla != null) {
            glg com_ushareit_listenit_glg = (glg) com_ushareit_listenit_gla;
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", com_ushareit_listenit_glg.f14338f);
            linkedHashMap.put("artist", com_ushareit_listenit_glg.f14339g);
            linkedHashMap.put("album", com_ushareit_listenit_glg.f14340h);
            exw.m18443a(f12768a, "collectPlaySong: " + linkedHashMap.toString());
            esr.m17820b(context, "UF_CommonPlaySong", linkedHashMap);
        }
    }

    public static void m19311c(Context context, String str) {
        exw.m18443a(f12768a, "collectPlayFrom: " + str);
        esr.m17808a(context, "UF_CommonPlayFrom", str);
    }

    public static void m19287a(Context context, int i) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("page", gyn.m23181a(i));
        exw.m18443a(f12768a, "collectEnterManage: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_CommonManage", linkedHashMap);
    }

    public static void m19288a(Context context, int i, gla com_ushareit_listenit_gla) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(VastExtensionXmlManager.TYPE, gyn.m23181a(i));
        linkedHashMap.put("name", com_ushareit_listenit_gla.mo2562c());
        exw.m18443a(f12768a, "collectEnterList(): " + linkedHashMap.toString());
        esr.m17820b(context, "UF_CommonEnterList", linkedHashMap);
    }

    public static void m19316d(Context context, String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("from", str);
        exw.m18443a(f12768a, "collectScan: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_CommonScan", linkedHashMap);
    }

    public static void m19290a(Context context, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("timeInMin", hge.m23691a(j));
        exw.m18457e(f12768a, "collectUserPlayTime: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_CommonUserPlayTime", linkedHashMap);
    }

    public static void m19291a(Context context, long j, int i) {
        if (i != gvj.m22865F(context)) {
            gvj.m22980j(context, i);
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("timeInMs", hge.m23691a(j));
            linkedHashMap.put("count", hge.m23690a(i));
            exw.m18443a(f12768a, "collectUserScanResult: " + linkedHashMap.toString());
            esr.m17820b(context, "UF_CommonUserScanResult1", linkedHashMap);
            m19319f(context);
            m19315d(context, i);
        }
    }

    private static void m19319f(Context context) {
        List<gkz> l = fqs.m20479l();
        List D = gvj.m22860D(context);
        exw.m18443a(f12768a, "allPaths=" + D);
        Object obj = null;
        for (gkz com_ushareit_listenit_gkz : l) {
            if (!D.contains(com_ushareit_listenit_gkz.f14279c)) {
                esr.m17808a(context, "UF_CommonUserSongPath", com_ushareit_listenit_gkz.f14279c);
                D.add(com_ushareit_listenit_gkz.f14279c);
                obj = 1;
                exw.m18443a(f12768a, "new path=" + com_ushareit_listenit_gkz.f14279c);
            }
            obj = obj;
        }
        if (obj != null) {
            gvj.m22899a(context, D);
        }
    }

    public static void m19296a(Context context, String str, int i) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        linkedHashMap.put("starNum", String.valueOf(i));
        exw.m18443a(f12768a, "collectRateResult: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_CommonRateResult", linkedHashMap);
    }

    public static void m19303b(Context context, int i) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("time", "" + i);
        exw.m18443a(f12768a, "collectSleepTimer: " + linkedHashMap.toString());
        esr.m17820b(context, "UF_CommonSleepTimer", linkedHashMap);
    }

    public static void m19317e(Context context, String str) {
        exw.m18443a(f12768a, "collectScreenLockSelected: " + str);
        esr.m17808a(context, "UF_CommonScreenLockSelected", str);
    }

    public static void m19289a(Context context, int i, List<glc> list, int i2, int i3, int i4) {
        Object obj = 1;
        int size = list.size();
        int q = gvj.m23023q(context);
        Object obj2 = (q != -1 || i3 <= 0) ? null : 1;
        if (size == q) {
            obj = null;
        }
        if (obj2 != null || r0 != null) {
            gvj.m22956g(context, size);
            int a = m19283a((List) list);
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(fnl.SONG_NUMBER, m19284a(i));
            linkedHashMap.put("playlist_count", String.valueOf(size));
            linkedHashMap.put("playlist_song_count", m19284a(a));
            linkedHashMap.put("favorite_count", m19284a(i2));
            linkedHashMap.put("recent_count", m19284a(i3));
            linkedHashMap.put("most_count", m19284a(i4));
            exw.m18443a(f12768a, "collectUserPlaylistAndSongInfo: " + linkedHashMap.toString());
            esr.m17820b(context, "UF_CommonUserPlaylistAndSongInfo", linkedHashMap);
        }
    }

    private static int m19283a(List<glc> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (glc com_ushareit_listenit_glc : list) {
            i = com_ushareit_listenit_glc.f14289i + i;
        }
        return i / size;
    }

    private static String m19284a(int i) {
        String str = "other";
        for (int i2 : f12769b) {
            if (i <= i2) {
                return "<=" + i2;
            }
        }
        return str;
    }

    public static void m19292a(Context context, fiy com_ushareit_listenit_fiy) {
        String s = gvj.m23030s(context);
        String a = gyn.m23179a();
        if (fbb.m18763c(s)) {
            gvj.m22931d(context, a);
        } else if (!a.equals(s)) {
            gvj.m22931d(context, a);
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("playlist_song", m19300b(com_ushareit_listenit_fiy.m19493a()));
            linkedHashMap.put("favorite_song", m19300b(com_ushareit_listenit_fiy.m19496b()));
            linkedHashMap.put("mostplayed_song", m19300b(com_ushareit_listenit_fiy.m19498c()));
            linkedHashMap.put("recentplayed_song", m19300b(com_ushareit_listenit_fiy.m19499d()));
            linkedHashMap.put("all_song", m19300b(com_ushareit_listenit_fiy.m19500e()));
            linkedHashMap.put("folder_song", m19300b(com_ushareit_listenit_fiy.m19502g()));
            linkedHashMap.put("other", m19300b(com_ushareit_listenit_fiy.m19501f()));
            exw.m18443a(f12768a, "collectUserListenBehavor: " + linkedHashMap.toString());
            esr.m17820b(context, "UF_CommonUserListenBehavor1", linkedHashMap);
            com_ushareit_listenit_fiy.m19497b(context);
        }
    }

    private static String m19300b(int i) {
        String str = "other";
        for (int i2 : f12770c) {
            if (i <= i2) {
                return "<=" + i2;
            }
        }
        return str;
    }

    public static void m19294a(Context context, gla com_ushareit_listenit_gla, int i) {
        if (com_ushareit_listenit_gla != null && (com_ushareit_listenit_gla instanceof glg)) {
            glg com_ushareit_listenit_glg = (glg) com_ushareit_listenit_gla;
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", com_ushareit_listenit_glg.f14338f);
            linkedHashMap.put("artist", com_ushareit_listenit_glg.f14339g);
            linkedHashMap.put("album", com_ushareit_listenit_glg.f14340h);
            linkedHashMap.put("from", gyn.m23181a(i));
            exw.m18443a(f12768a, "collectShareSong(): " + linkedHashMap.toString());
            esr.m17820b(context, "UF_CommonShareSong", linkedHashMap);
        }
    }

    private static void m19315d(Context context, int i) {
        String c = m19307c(i);
        exw.m18443a(f12768a, "collectUserSongCountProperty:  " + c);
        fia.m19218b(context, fnl.SONG_NUMBER, c);
    }

    private static String m19307c(int i) {
        int i2 = 0;
        while (i2 < f12769b.length) {
            if (i < f12769b[i2]) {
                break;
            }
            i2++;
        }
        i2 = 0;
        if (i2 > 0) {
            return f12769b[i2 - 1] + "-" + f12769b[i2];
        }
        return "0";
    }

    public static void m19305b(Context context, String str, String str2) {
        try {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("opt_type", str);
            linkedHashMap.put("name", str2);
            esr.m17820b(context, "ERR_GP_RATE_FLOATING_VIEW", linkedHashMap);
        } catch (Exception e) {
        }
    }

    public static void m19298a(Context context, boolean z) {
        exw.m18443a(f12768a, "collectDarkTheme: " + z);
        esr.m17808a(context, "UF_DarkTheme", z ? "enable" : "disable");
    }

    public static void m19310c(Context context, int i) {
        exw.m18443a(f12768a, "collectColorTheme: " + i);
        esr.m17808a(context, "UF_ColorTheme", "" + i);
    }

    public static void m19320f(Context context, String str) {
        exw.m18443a(f12768a, "collectAudioCutter: " + str);
        esr.m17808a(context, "UF_AudioCutter", str);
    }

    public static void m19302b(Context context) {
        exw.m18443a(f12768a, "collectSaveAudioCutter");
        esr.m17807a(context, "UF_SaveAudioCutter");
    }

    public static void m19321g(Context context, String str) {
        exw.m18443a(f12768a, "collectFavorite");
        esr.m17808a(context, "UF_CommonFavorite", str);
    }

    public static void m19322h(Context context, String str) {
        exw.m18443a(f12768a, "collectGetPlayServiceTimeout, from=" + str);
        esr.m17808a(context, "UF_CommonGetPlayServiceTimeout", str);
    }

    public static void m19309c(Context context) {
        exw.m18443a(f12768a, "collectAdjustVolume");
        esr.m17807a(context, "UF_AdjustVolume");
    }

    public static void m19314d(Context context) {
        exw.m18443a(f12768a, "collectAdjustBooster");
        esr.m17807a(context, "UF_AdjustBooster");
    }

    public static void m19299a(String str) {
        exw.m18443a(f12768a, "collectVolumeBoosterSwitch, action=" + str);
        esr.m17808a(eys.m18562a(), "UF_VolumeBoosterSwitch", str);
    }

    public static void m19285a() {
        exw.m18443a(f12768a, "collectReceiveVolumeChangedEvent");
        esr.m17807a(eys.m18562a(), "UF_ReceiveVolumeChangedEvent");
    }

    public static void m19306b(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("from", str);
        exw.m18443a(f12768a, "collectShareFrom(): " + linkedHashMap.toString());
        esr.m17820b(eys.m18562a(), "UF_CommonShareFrom", linkedHashMap);
    }

    public static void m19312c(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(C0321x.aF, str);
        exw.m18443a(f12768a, "collectImageLoadError(): " + linkedHashMap.toString());
        esr.m17820b(eys.m18562a(), "UF_CommonImageLoadError", linkedHashMap);
    }

    public static void m19301b() {
        esr.m17807a(eys.m18562a(), "UF_CommonStartFromBackground");
    }

    public static void m19308c() {
        esr.m17807a(eys.m18562a(), "UF_CommonStartPlayPage");
    }

    public static void m19313d() {
        esr.m17807a(eys.m18562a(), "UF_CommonStartAllSongPage");
    }
}
