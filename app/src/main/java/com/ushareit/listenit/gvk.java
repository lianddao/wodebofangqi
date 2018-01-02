package com.ushareit.listenit;

import android.content.Context;

public class gvk {
    public static String m23047a(Context context, String str) {
        return new exz(context).m17994b("AUTH_EXTRA_SDCARD_URI", "");
    }

    public static boolean m23048a() {
        return new exz(eys.m18562a()).m17992a("WIFI_DOWNLOAD_ONLY", false);
    }

    public static boolean m23049a(boolean z) {
        new exz(eys.m18562a()).m17997b("AUTO_LAUNCHER_PLAYER_ACTIVITY", z);
        return true;
    }

    public static boolean m23050b() {
        return new exz(eys.m18562a()).m17992a("AUTO_LAUNCHER_PLAYER_ACTIVITY", false);
    }

    public static boolean m23051b(boolean z) {
        new exz(eys.m18562a()).m17997b("AUTO_SCAN_FILTER", z);
        return true;
    }

    public static boolean m23052c() {
        return new exz(eys.m18562a()).m17992a("AUTO_SCAN_FILTER", true);
    }

    public static boolean m23053c(boolean z) {
        new exz(eys.m18562a()).m17997b("AUTO_MATCH_ALBUM_ART", z);
        return true;
    }

    public static boolean m23054d() {
        return new exz(eys.m18562a()).m17992a("AUTO_MATCH_ALBUM_ART", true);
    }

    public static boolean m23055d(boolean z) {
        new exz(eys.m18562a()).m17997b("KEY_CHARGING_LOCK_SCREEN", z);
        return true;
    }

    public static boolean m23057e() {
        return new exz(eys.m18562a()).m17992a("KEY_CHARGING_LOCK_SCREEN", true);
    }

    public static void m23056e(boolean z) {
        new exz(eys.m18562a()).m17997b("VOICE_CONTROLLER_BAR", z);
    }

    public static boolean m23058f() {
        return new exz(eys.m18562a()).m17992a("VOICE_CONTROLLER_BAR", true);
    }
}
