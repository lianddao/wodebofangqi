package com.ushareit.listenit;

import com.mopub.common.Constants;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class fie {
    private static final String f12761a = fie.class.getSimpleName();
    private static final int[] f12762b = new int[]{1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 40, 50, 60, 70, 80, 90, 100, 120, CtaButton.WIDTH_DIPS, 180, 300, 480, 600, 1200, 1800, 3600};
    private static final int[] f12763c = new int[]{5, 10, 15, 20, 25, 30, 40, 50, 60, 80, 100, 120, CtaButton.WIDTH_DIPS, 180, 210, 250, 300, 350, 400, 450, 500, 600, 800, 1000, 1200, 1500, 1800, 3600};
    private static boolean f12764d = false;
    private static ffl f12765e;

    public static void m19236a(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        exw.m18457e(f12761a, "collectStartLoadFacebookNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_FB_StartLoadAd", linkedHashMap);
    }

    public static void m19243b(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        exw.m18457e(f12761a, "collectStartLoadFacebookIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_FB_StartLoadAd", linkedHashMap);
    }

    public static void m19237a(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectLoadFacebookNativeAdSuccess, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_FB_LoadAdSuccess", linkedHashMap);
    }

    public static void m19244b(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectLoadFacebookIntertitialAdSuccess, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_FB_LoadAdSuccess", linkedHashMap);
    }

    public static void m19238a(String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("reason", str2);
        exw.m18457e(f12761a, "collectLoadFacebookNativeAdFailure, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_FB_LoadAdFailure", linkedHashMap);
    }

    public static void m19245b(String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("reason", str2);
        exw.m18457e(f12761a, "collectLoadFacebookIntertitialAdFailure, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_FB_LoadAdFailure", linkedHashMap);
    }

    public static void m19234a(ffl com_ushareit_listenit_ffl) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", com_ushareit_listenit_ffl.c);
        exw.m18457e(f12761a, "collectShowFacebookNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_FB_ShowAd", linkedHashMap);
        m19253d(com_ushareit_listenit_ffl);
    }

    public static void m19249c(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        exw.m18457e(f12761a, "collectShowFacebookIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_FB_ShowAd", linkedHashMap);
    }

    public static void m19250c(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectImpressFacebookNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_FB_ImpressAd", linkedHashMap);
    }

    public static void m19256d(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectImpressFacebookIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_FB_ImpressAd", linkedHashMap);
    }

    public static void m19235a(ffl com_ushareit_listenit_ffl, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", com_ushareit_listenit_ffl.c);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectClickFacebookNativeAd, params=" + linkedHashMap + ", aditem=" + com_ushareit_listenit_ffl.mo2366a());
        esr.m17820b(eys.m18562a(), "ADN_FB_ClickAd", linkedHashMap);
        m19258e(com_ushareit_listenit_ffl);
    }

    public static void m19261e(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectClickFacebookIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_FB_ClickAd", linkedHashMap);
    }

    public static void m19242b(ffl com_ushareit_listenit_ffl, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", com_ushareit_listenit_ffl.c);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectCloseFacebookNativeAd, params=" + linkedHashMap + ", aditem=" + com_ushareit_listenit_ffl.mo2366a());
        esr.m17820b(eys.m18562a(), "ADN_FB_CloseAd", linkedHashMap);
        m19263f(com_ushareit_listenit_ffl);
    }

    public static void m19265f(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectCloseFacebookIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_FB_CloseAd", linkedHashMap);
    }

    public static void m19255d(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        exw.m18457e(f12761a, "collectStartLoadAdMobNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_AM_StartLoadAd", linkedHashMap);
    }

    public static void m19260e(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        exw.m18457e(f12761a, "collectStartLoadAdMobIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_AM_StartLoadAd", linkedHashMap);
    }

    public static void m19268g(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectLoadAdMobNativeAdSuccess, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_AM_LoadAdSuccess", linkedHashMap);
    }

    public static void m19270h(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectLoadAdMobIntertitialAdSuccess, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_AM_LoadAdSuccess", linkedHashMap);
    }

    public static void m19251c(String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("reason", str2);
        exw.m18457e(f12761a, "collectLoadAdMobNativeAdFailure, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_AM_LoadAdFailure", linkedHashMap);
    }

    public static void m19257d(String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("reason", str2);
        exw.m18457e(f12761a, "collectLoadAdMobIntertitialAdFailure, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_AM_LoadAdFailure", linkedHashMap);
    }

    public static void m19241b(ffl com_ushareit_listenit_ffl) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", com_ushareit_listenit_ffl.c);
        exw.m18457e(f12761a, "collectShowAdMobNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_AM_ShowAd", linkedHashMap);
        m19253d(com_ushareit_listenit_ffl);
    }

    public static void m19264f(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        exw.m18457e(f12761a, "collectShowAdMobIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_AM_ShowAd", linkedHashMap);
    }

    public static void m19248c(ffl com_ushareit_listenit_ffl, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", com_ushareit_listenit_ffl.c);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectClickAdMobNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_AM_ClickAd", linkedHashMap);
        m19258e(com_ushareit_listenit_ffl);
    }

    public static void m19271i(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectClickAdMobIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_AM_ClickAd", linkedHashMap);
    }

    public static void m19254d(ffl com_ushareit_listenit_ffl, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", com_ushareit_listenit_ffl.c);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectCloseAdMobNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_AM_CloseAd", linkedHashMap);
        m19263f(com_ushareit_listenit_ffl);
    }

    public static void m19272j(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectCloseAdMobIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_AM_CloseAd", linkedHashMap);
    }

    public static void m19267g(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        exw.m18457e(f12761a, "collectStartLoadMoPubIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_MP_StartLoadAd", linkedHashMap);
    }

    public static void m19273k(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectLoadMoPubNativeAdSuccess, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_MP_LoadAdSuccess", linkedHashMap);
    }

    public static void m19274l(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectLoadMoPubIntertitialAdSuccess, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_MP_LoadAdSuccess", linkedHashMap);
    }

    public static void m19262e(String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("reason", str2);
        exw.m18457e(f12761a, "collectLoadMoPubNativeAdFailure, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_MP_LoadAdFailure", linkedHashMap);
    }

    public static void m19266f(String str, String str2) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("reason", str2);
        exw.m18457e(f12761a, "collectLoadMoPubIntertitialAdFailure, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_MP_LoadAdFailure", linkedHashMap);
    }

    public static void m19247c(ffl com_ushareit_listenit_ffl) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", com_ushareit_listenit_ffl.c);
        exw.m18457e(f12761a, "collectShowMoPubNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_MP_ShowAd", linkedHashMap);
        m19253d(com_ushareit_listenit_ffl);
    }

    public static void m19269h(String str) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        exw.m18457e(f12761a, "collectShowMoPubIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_MP_ShowAd", linkedHashMap);
    }

    public static void m19259e(ffl com_ushareit_listenit_ffl, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", com_ushareit_listenit_ffl.c);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectClickMoPubNativeAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADN_MP_ClickAd", linkedHashMap);
        m19258e(com_ushareit_listenit_ffl);
    }

    public static void m19275m(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectClickMoPubIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_MP_ClickAd", linkedHashMap);
    }

    public static void m19276n(String str, long j) {
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adid", str);
        linkedHashMap.put("timeUsedInSec", m19232a(j));
        exw.m18457e(f12761a, "collectCloseMoPubIntertitialAd, params=" + linkedHashMap);
        esr.m17820b(eys.m18562a(), "ADI_MP_CloseAd", linkedHashMap);
    }

    public static String m19232a(long j) {
        int i = 0;
        int i2 = (int) (j / 1000);
        String str = "other";
        for (int i3 = 0; i3 < f12762b.length; i3++) {
            int i4 = f12762b[i3];
            if (i2 < i4) {
                if (i3 > 0) {
                    i = f12762b[i3 - 1];
                }
                return "[" + i + ", " + i4 + ")";
            }
        }
        return str;
    }

    public static String m19231a(int i) {
        int i2 = 0;
        int i3 = i / 1000;
        String str = "other";
        for (int i4 = 0; i4 < f12763c.length; i4++) {
            int i5 = f12763c[i4];
            if (i3 < i5) {
                if (i4 > 0) {
                    i2 = f12763c[i4 - 1];
                }
                return "[" + i2 + ", " + i5 + ")";
            }
        }
        return str;
    }

    public static void m19253d(ffl com_ushareit_listenit_ffl) {
        exw.m18457e("dsf", "onAdShow. collect, placement=" + com_ushareit_listenit_ffl.f12607l);
        String str = com_ushareit_listenit_ffl.f12607l;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1877643078:
                if (str.equals("play_page")) {
                    obj = 2;
                    break;
                }
                break;
            case -1194876546:
                if (str.equals("flash_page")) {
                    obj = null;
                    break;
                }
                break;
            case 1226023031:
                if (str.equals("lockscreen_page")) {
                    obj = 5;
                    break;
                }
                break;
            case 1587035950:
                if (str.equals("switch_foreground")) {
                    obj = 3;
                    break;
                }
                break;
            case 2063193412:
                if (str.equals("all_song_list_page")) {
                    obj = 1;
                    break;
                }
                break;
            case 2118081007:
                if (str.equals("home_page")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                gvj.m22947f(gvj.m23037v() - 1);
                break;
            case 1:
                gvj.m22938e(gvj.m23035u() - 1);
                break;
            case 2:
                gvj.m22955g(gvj.m23039w() - 1);
                break;
            case 3:
                gvj.m22963h(gvj.m23041x() - 1);
                break;
            case 5:
                gvj.m22971i(gvj.m23043y() - 1);
                break;
        }
        if (com_ushareit_listenit_ffl != null) {
            esr.m17808a(eys.m18562a(), "AD_Show", com_ushareit_listenit_ffl.f12607l);
        }
    }

    public static void m19258e(ffl com_ushareit_listenit_ffl) {
        f12764d = true;
        f12765e = com_ushareit_listenit_ffl;
        fjf.m4854l();
        hhx.m23869a(new fif("clickNativeAd"), 0, Constants.TEN_SECONDS_MILLIS);
        if (com_ushareit_listenit_ffl != null) {
            esr.m17808a(eys.m18562a(), "AD_Click", com_ushareit_listenit_ffl.f12607l);
        }
    }

    public static void m19233a() {
        if (f12764d && f12765e != null) {
            f12764d = false;
            String str = f12765e.f12607l;
            boolean z = true;
            switch (str.hashCode()) {
                case -1877643078:
                    if (str.equals("play_page")) {
                        z = true;
                        break;
                    }
                    break;
                case -1194876546:
                    if (str.equals("flash_page")) {
                        z = false;
                        break;
                    }
                    break;
                case 1587035950:
                    if (str.equals("switch_foreground")) {
                        z = true;
                        break;
                    }
                    break;
                case 2063193412:
                    if (str.equals("all_song_list_page")) {
                        z = true;
                        break;
                    }
                    break;
                case 2118081007:
                    if (str.equals("home_page")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case true:
                    gvj.m22968h(true);
                    gvj.m22938e(0);
                    m19240b();
                    break;
                case true:
                    gvj.m22976i(true);
                    gvj.m22955g(0);
                    m19246c();
                    break;
                case true:
                    gvj.m22983j(true);
                    gvj.m22963h(0);
                    m19252d();
                    break;
                case true:
                    fez.f12566a = true;
                    break;
            }
            esr.m17808a(eys.m18562a(), "AD_Left", str);
        }
    }

    public static void m19240b() {
        if (gyp.m23285b()) {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("listenTime", m19231a(gyp.m23272a().mo2410D()));
            exw.m18457e(f12761a, "collectClickAllSongListAdListenDelay, params=" + linkedHashMap);
            esr.m17820b(eys.m18562a(), "AD_ClickAllSongListAdListenDelay", linkedHashMap);
        }
    }

    public static void m19246c() {
        if (gyp.m23285b()) {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("listenTime", m19231a(gyp.m23272a().mo2410D()));
            exw.m18457e(f12761a, "collectClickPlayPageAdListenDelay, params=" + linkedHashMap);
            esr.m17820b(eys.m18562a(), "AD_ClickPlayPageAdListenDelay", linkedHashMap);
        }
    }

    public static void m19252d() {
        if (gyp.m23285b()) {
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("listenTime", m19231a(gyp.m23272a().mo2410D()));
            exw.m18457e(f12761a, "collectClickInterstitialAdListenDelay, params=" + linkedHashMap);
            esr.m17820b(eys.m18562a(), "AD_ClickInterstitialAdListenDelay", linkedHashMap);
        }
    }

    public static void m19263f(ffl com_ushareit_listenit_ffl) {
        exw.m18457e("dsf", "onAdClose. collect, placement=" + com_ushareit_listenit_ffl.f12607l);
        String str = com_ushareit_listenit_ffl.f12607l;
        boolean z = true;
        switch (str.hashCode()) {
            case -1877643078:
                if (str.equals("play_page")) {
                    z = true;
                    break;
                }
                break;
            case -1194876546:
                if (str.equals("flash_page")) {
                    z = false;
                    break;
                }
                break;
            case 1587035950:
                if (str.equals("switch_foreground")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case true:
                gvj.m22993k(true);
                return;
            case true:
                gvj.m23001l(true);
                return;
            default:
                return;
        }
    }
}
