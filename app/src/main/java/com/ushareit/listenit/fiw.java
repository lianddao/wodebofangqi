package com.ushareit.listenit;

import android.content.Context;
import android.util.Pair;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.HashMap;

public class fiw {
    private static int[] f12785a = new int[]{1, 2, 3, 4, 5, 10, 15, 20, 30, 50, 80, 100, CtaButton.WIDTH_DIPS, 200, 300, 500, 1000};

    public static void m19456a(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectShowSyncFeature");
        esr.m17807a(context, "UF_ShowSyncFeature");
    }

    public static void m19462b(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectHasGooglePlayService");
        esr.m17807a(context, "UF_HasGooglePlayService");
    }

    public static void m19457a(Context context, int i) {
        exw.m18443a("UIAnalyticsSync", "collectEnableSync, syncMode=" + i);
        String str = "UF_ProfileClickSync";
        String str2 = i == 0 ? "light" : i == 2 ? "force" : "auto";
        esr.m17808a(context, str, str2);
    }

    public static void m19460a(Context context, boolean z) {
        exw.m18443a("UIAnalyticsSync", "collectAutoSyncInWifi");
        esr.m17808a(context, "UF_ProfileAutoSyncInWifi", z ? "enable" : "disable");
    }

    public static void m19467c(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectUserRename");
        esr.m17807a(context, "UF_ProfileRename");
    }

    public static void m19470d(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectUserReplaceAvatar");
        esr.m17807a(context, "UF_ProfileReplaceAvatar");
    }

    public static void m19465b(Context context, boolean z) {
        exw.m18443a("UIAnalyticsSync", "collectSyncPlaylistResult: result=" + z);
        esr.m17808a(context, "UF_SyncPlaylistResult", z ? "success" : "failure");
    }

    public static void m19472e(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectDownloadSongSuccess");
        esr.m17807a(context, "UF_SyncDownloadSongSuccess");
    }

    public static void m19458a(Context context, String str) {
        exw.m18443a("UIAnalyticsSync", "collectDownloadSongFailure: " + str);
        esr.m17808a(context, "UF_SyncDownloadSongFailure", str);
    }

    public static void m19474f(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectUploadSongSuccess");
        esr.m17807a(context, "UF_SyncUploadSongSuccess");
    }

    public static void m19464b(Context context, String str) {
        exw.m18443a("UIAnalyticsSync", "collectUploadSongFailure: " + str);
        esr.m17808a(context, "UF_SyncUploadSongFailure", str);
    }

    public static void m19469c(Context context, String str) {
        exw.m18443a("UIAnalyticsSync", "collectLoginResult: from=" + str);
        esr.m17808a(context, "UF_LoginResult", str);
    }

    public static void m19471d(Context context, String str) {
        exw.m18443a("UIAnalyticsSync", "collectLoginFailure: from=" + str);
        esr.m17808a(context, "UF_LoginFailure", str);
    }

    public static void m19459a(Context context, String str, long j) {
        String k = fir.m19408k(j);
        exw.m18443a("UIAnalyticsSync", "collectLoginSuccessUsedTime: " + k + ", from=" + str);
        HashMap hashMap = new HashMap(2);
        hashMap.put("from", str);
        hashMap.put("usedTime", k);
        esr.m17820b(context, "UF_LoginSuccessUsedTime", hashMap);
    }

    public static void m19476g(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectLogout");
        esr.m17807a(context, "UF_Logout");
    }

    public static void m19478h(Context context) {
        Pair a = eyw.m18568a(context);
        String str = ((Boolean) a.second).booleanValue() ? "wifi" : ((Boolean) a.first).booleanValue() ? "mobile" : "no";
        exw.m18443a("UIAnalyticsSync", "collectStartNetWorkState: " + str);
        esr.m17808a(context, "UF_StartNetWorkState", str);
    }

    public static void m19473e(Context context, String str) {
        exw.m18443a("UIAnalyticsSync", "collectSyncFrom: from=" + str);
        esr.m17808a(context, "UF_SyncFrom", str);
    }

    public static void m19479i(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectLoginUser");
        esr.m17807a(context, "UF_LoginUser");
    }

    public static void m19480j(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectClickLogin");
        esr.m17807a(context, "UF_ClickLogin");
    }

    public static void m19475f(Context context, String str) {
        exw.m18443a("UIAnalyticsSync", "collectCancelLogin, " + str);
        esr.m17808a(context, "UF_CancelLogin", str);
    }

    public static void m19481k(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectClickLoginFacebook");
        esr.m17807a(context, "UF_ClickLoginFacebook");
    }

    public static void m19482l(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectClickLoginGoogle");
        esr.m17807a(context, "UF_ClickLoginGoogle");
    }

    public static void m19483m(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectClickLoginEmail");
        esr.m17807a(context, "UF_ClickLoginEmail");
    }

    public static void m19477g(Context context, String str) {
        exw.m18443a("UIAnalyticsSync", "collectCheckLibraryCache, error=" + str);
        esr.m17808a(context, "UF_CheckLibraryCache", str);
    }

    public static void m19455a(long j, long j2, boolean z) {
        String str = j == j2 ? "local" : j2 == 0 ? "relogin" : "cloud";
        str = z ? str + "-usecache" : str + "-nocache";
        exw.m18443a("UIAnalyticsSync", "collectSyncLibrarySongFrom: from=" + str);
        esr.m17808a(eys.m18562a(), "UF_SyncLibSongFrom", str);
    }

    public static void m19461b(long j, long j2, boolean z) {
        String str = j == j2 ? "local" : j2 == 0 ? "relogin" : "cloud";
        str = z ? str + "-usecache" : str + "-nocache";
        exw.m18443a("UIAnalyticsSync", "collectSyncPlaylistFrom: from=" + str);
        esr.m17808a(eys.m18562a(), "UF_SyncPlaylistFrom", str);
    }

    public static void m19466c(long j, long j2, boolean z) {
        String str = j == j2 ? "local" : j2 == 0 ? "relogin" : "cloud";
        str = z ? str + "-usecache" : str + "-nocache";
        exw.m18443a("UIAnalyticsSync", "collectSyncUserInfoFrom: from=" + str);
        esr.m17808a(eys.m18562a(), "UF_SyncUserInfoFrom", str);
    }

    public static void m19484n(Context context) {
        exw.m18443a("UIAnalyticsSync", "collectDownloadAvator");
        esr.m17807a(eys.m18562a(), "UF_DownloadAvator");
    }

    public static void m19463b(Context context, int i) {
        exw.m18443a("UIAnalyticsSync", "collectDownloadSongs: songCount=" + i);
        esr.m17808a(context, "UF_DownloadLibSongs", m19454a(i));
    }

    public static void m19468c(Context context, int i) {
        exw.m18443a("UIAnalyticsSync", "collectDownloadPlaylistSongs: songCount=" + i);
        esr.m17808a(context, "UF_DownloadPlaylistSongs", m19454a(i));
    }

    private static String m19454a(int i) {
        String str = "other";
        for (int i2 : f12785a) {
            if (i < i2) {
                return "<" + i2;
            }
        }
        return str;
    }
}
