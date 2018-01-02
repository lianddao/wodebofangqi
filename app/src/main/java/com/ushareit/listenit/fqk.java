package com.ushareit.listenit;

import com.umeng.analytics.C0154a;

public class fqk {
    public static boolean m20375a() {
        if (gef.m21805a().m21838h() && euo.m18017a(eys.m18562a(), "show_login_button_in_navigation", false)) {
            return true;
        }
        return false;
    }

    public static boolean m20376b() {
        if (gef.m21805a().m21838h() && euo.m18017a(eys.m18562a(), "show_login_card_in_mainpage", true)) {
            return true;
        }
        return false;
    }

    public static int m20377c() {
        return euo.m18007a(eys.m18562a(), "sync_interval_when_start_app_in_wifi", 0);
    }

    public static int m20378d() {
        return euo.m18007a(eys.m18562a(), "sync_interval_when_network_change", 24);
    }

    public static int m20379e() {
        return euo.m18007a(eys.m18562a(), "song_number_trigger_playlist_recommend", 20);
    }

    public static int m20380f() {
        return euo.m18007a(eys.m18562a(), "play_count_trigger_playlist_recommend", 20);
    }

    public static boolean m20381g() {
        if (!gef.m21805a().m21838h()) {
            return false;
        }
        if (euo.m18017a(eys.m18562a(), "show_nearby_navigation_item_switch", false) || gvj.m22984j()) {
            return true;
        }
        return false;
    }

    public static boolean m20382h() {
        if (!m20385k()) {
            return false;
        }
        if (euo.m18017a(eys.m18562a(), "show_nearby_guide", false) || gvj.m22984j()) {
            return true;
        }
        return false;
    }

    public static long m20383i() {
        return euo.m18008a(eys.m18562a(), "nearby_click_load_more_times_in_app_running", 10);
    }

    public static long m20384j() {
        return euo.m18008a(eys.m18562a(), "nearby_data_valid_time", (long) C0154a.f2953i);
    }

    public static boolean m20385k() {
        return m20381g() && gvj.aq(eys.m18562a());
    }

    public static int m20386l() {
        return euo.m18007a(eys.m18562a(), "nearby_user_min_song_number", 50);
    }
}
