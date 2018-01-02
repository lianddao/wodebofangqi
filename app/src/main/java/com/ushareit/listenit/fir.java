package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.umeng.analytics.C0154a;
import java.io.File;
import java.util.Locale;

public class fir {
    private static String f12778a = "UIAnalyticsNearby";
    private static final int[] f12779b = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 25, 30, 40, 50, 70, 90, 120, CtaButton.WIDTH_DIPS, 200, 2000};
    private static final int[] f12780c = new int[]{1, 2, 3, 4, 5, 10, 20, 30, 50, 80, 120, 180, 300, 480, 600, 1200, 1800, 3600};

    public static void m19376a() {
        exw.m18443a(f12778a, "collectNearbyOpenNavigation");
        esr.m17807a(eys.m18562a(), "UF_NearbyOpenNavigation");
    }

    public static void m19380b() {
        exw.m18443a(f12778a, "collectNearbyShow");
        esr.m17807a(eys.m18562a(), "UF_NearbyShow");
    }

    public static void m19384c() {
        exw.m18443a(f12778a, "collectNearbyStart");
        esr.m17807a(eys.m18562a(), "UF_NearbyStart");
    }

    public static void m19378a(String str) {
        exw.m18443a(f12778a, "collectNearbyClickLogin, from=" + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyClickLogin", str);
    }

    public static void m19382b(String str) {
        exw.m18443a(f12778a, "collectNearbyLoginSuccess, from=" + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoginSuccess", str);
    }

    public static void m19379a(boolean z) {
        String str = z ? "yes" : "no";
        exw.m18443a(f12778a, "collectNearbyClickUser, " + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyClickUser", str);
    }

    public static void m19383b(boolean z) {
        String str = z ? "yes" : "no";
        exw.m18443a(f12778a, "collectNearbyClickSharelist, " + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyClickSharelist", str);
    }

    public static void m19388d() {
        exw.m18443a(f12778a, "collectNearbyCollectSong");
        esr.m17807a(eys.m18562a(), "UF_NearbyCollectSong");
    }

    public static void m19392e() {
        exw.m18443a(f12778a, "collectNearbyCollectPlaylist");
        esr.m17807a(eys.m18562a(), "UF_NearbyCollectPlaylist");
    }

    public static void m19395f() {
        exw.m18443a(f12778a, "collectNearbyCollectAll");
        esr.m17807a(eys.m18562a(), "UF_NearbyCollectAll");
    }

    public static void m19398g() {
        exw.m18443a(f12778a, "collectNearbyLoadMore");
        esr.m17807a(eys.m18562a(), "UF_NearbyLoadMore");
    }

    public static void m19387c(boolean z) {
        exw.m18443a(f12778a, "collectNearbyGetLocation");
        esr.m17808a(eys.m18562a(), "UF_NearbyGetLocation", z ? "ok" : "no");
    }

    public static void m19386c(String str) {
        exw.m18443a(f12778a, "collectNearbyUserFrom, from=" + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyUserFrom", str);
    }

    public static void m19391d(boolean z) {
        exw.m18443a(f12778a, "collectNearbySetPrivacyPlaylist, " + z);
        esr.m17808a(eys.m18562a(), "UF_NearbySetPrivacyPlaylist", z ? "true" : "false");
    }

    public static void m19401h() {
        String u = m19419u();
        boolean t = m19418t();
        exw.m18443a(f12778a, "collectUploadShareList, countryCode=" + u + ", avator=" + t);
        esr.m17807a(eys.m18562a(), "UF_UploadShareList");
        esr.m17819b(eys.m18562a(), "UF_SharePlaylistUserCountryCode", u);
        esr.m17808a(eys.m18562a(), "UF_NearbyExistUserAvator", t ? "true" : "false");
    }

    private static boolean m19418t() {
        return new File(gyn.m23238f()).exists();
    }

    public static void m19377a(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyExistUserAvator, level=" + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyDownloadUserAvatorTime", k);
    }

    public static void m19381b(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyGetLocationUsedTime, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyGetLocationUsedTime", k);
    }

    private static String m19419u() {
        String a = fbb.m18751a(eys.m18562a());
        if (TextUtils.isEmpty(a)) {
            a = eys.m18562a().getResources().getConfiguration().locale.getCountry();
        }
        if (TextUtils.isEmpty(a)) {
            a = "xxx";
        }
        return a.toLowerCase(Locale.US);
    }

    public static void m19404i() {
        if (System.currentTimeMillis() - gvj.au(eys.m18562a()) > C0154a.f2953i) {
            String a = m19375a(gvj.m22986k());
            String a2 = m19375a(gvj.m23002m());
            String a3 = m19375a(frc.m20594c());
            exw.m18443a(f12778a, "collectNearbyUserBehavor, collectSongNumber=" + a + ", collectPlaylistNumber=" + a2 + ", loadUserNubmer=" + a3);
            esr.m17808a(eys.m18562a(), "UF_NearbyCollectSongNumber", a);
            esr.m17808a(eys.m18562a(), "UF_NearbyCollectPlaylistNumber", a2);
            esr.m17808a(eys.m18562a(), "UF_NearbyLoadUserNumber", a3);
            gvj.m23022p(eys.m18562a(), System.currentTimeMillis());
        }
    }

    public static void m19385c(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyStayUserPageTime, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyStayUserPageTime", k);
    }

    public static void m19389d(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyStayPlaylistPageTime, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyStayPlaylistPageTime", k);
    }

    public static void m19393e(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyStaySongPageTime, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyStaySongPageTime", k);
    }

    public static void m19396f(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyLoadUserSuccess, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadUserSuccess", k);
    }

    public static void m19399g(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyLoadRobotSuccess, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadRobotSuccess", k);
    }

    public static void m19402h(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyLoadPlaylistSuccess, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadPlaylistSuccess", k);
    }

    public static void m19405i(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyLoadSongSuccess, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadSongSuccess", k);
    }

    public static void m19407j(long j) {
        String k = m19408k(j);
        exw.m18443a(f12778a, "collectNearbyLoadSongIdsSuccess, " + k);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadSongIdsSuccess", k);
    }

    public static void m19390d(String str) {
        exw.m18443a(f12778a, "collectNearbyLoadUserFailure, " + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadUserFailure", str);
    }

    public static void m19394e(String str) {
        exw.m18443a(f12778a, "collectNearbyLoadRobotFailure, " + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadRobotFailure", str);
    }

    public static void m19406j() {
        exw.m18443a(f12778a, "collectNearbyLoadNoUsers");
        esr.m17807a(eys.m18562a(), "UF_NearbyLoadNoUsers");
    }

    public static void m19397f(String str) {
        exw.m18443a(f12778a, "collectNearbyLoadPlaylistFailure, " + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadPlaylistFailure", str);
    }

    public static void m19409k() {
        exw.m18443a(f12778a, "collectNearbyLoadNoPlaylists");
        esr.m17807a(eys.m18562a(), "UF_NearbyLoadNoPlaylist");
    }

    public static void m19400g(String str) {
        exw.m18443a(f12778a, "collectNearbyLoadSongFailure, " + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadSongFailure", str);
    }

    public static void m19403h(String str) {
        exw.m18443a(f12778a, "collectNearbyLoadSongIdsFailure, " + str);
        esr.m17808a(eys.m18562a(), "UF_NearbyLoadSongIdsFailure", str);
    }

    public static void m19410l() {
        exw.m18443a(f12778a, "collectNearbyLoadNoSongs");
        esr.m17807a(eys.m18562a(), "UF_NearbyLoadNoSongs");
    }

    public static void m19411m() {
        exw.m18443a(f12778a, "collectABTestShowDownload");
        esr.m17807a(eys.m18562a(), "UF_ABTestShowDownload");
    }

    public static void m19412n() {
        exw.m18443a(f12778a, "collectABTestShowNearby");
        esr.m17807a(eys.m18562a(), "UF_ABTestShowNearby");
    }

    public static void m19413o() {
        exw.m18443a(f12778a, "collectShowNearbyGuide");
        esr.m17808a(eys.m18562a(), "UF_ShowNearbyGuide", fhy.m19213a() ? "download" : "nearby");
    }

    public static void m19414p() {
        exw.m18443a(f12778a, "collectEnterDownloadNearbyMusicGuide");
        esr.m17807a(eys.m18562a(), "UF_EnterDownloadNearbyMusicGuide");
    }

    public static void m19415q() {
        exw.m18443a(f12778a, "collectEnterNearbyGuide");
        esr.m17807a(eys.m18562a(), "UF_EnterNearbyGuide");
    }

    public static void m19416r() {
        exw.m18443a(f12778a, "collectNotInterestedInDownloadNearbyMusic");
        esr.m17807a(eys.m18562a(), "UF_NotInterestedInDownloadNearbyMusic");
    }

    public static void m19417s() {
        exw.m18443a(f12778a, "collectNotInterestedInNearby");
        esr.m17807a(eys.m18562a(), "UF_NotInterestedInNearby");
    }

    private static String m19375a(int i) {
        int i2 = 0;
        String str = "other";
        for (int i3 = 0; i3 < f12779b.length; i3++) {
            int i4 = f12779b[i3];
            if (i < i4) {
                if (i3 > 0) {
                    i2 = f12779b[i3 - 1];
                }
                return "[" + i2 + ", " + i4 + ")";
            }
        }
        return str;
    }

    public static String m19408k(long j) {
        int i = 0;
        int i2 = (int) (j / 1000);
        String str = "other";
        for (int i3 = 0; i3 < f12780c.length; i3++) {
            int i4 = f12780c[i3];
            if (i2 < i4) {
                if (i3 > 0) {
                    i = f12780c[i3 - 1];
                }
                return "[" + i + ", " + i4 + ")";
            }
        }
        return str;
    }
}
