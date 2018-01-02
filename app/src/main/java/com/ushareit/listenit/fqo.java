package com.ushareit.listenit;

import android.os.Build.VERSION;
import com.google.firebase.auth.FirebaseAuth;

public class fqo {
    private static eeu f13242a;

    private static eeu m20416M() {
        if (f13242a == null) {
            try {
                f13242a = eeu.m16897a();
            } catch (IllegalStateException e) {
                eah.m16604a(eys.m18562a(), ean.m16631a(eys.m18562a()));
                f13242a = eeu.m16897a();
            }
            f13242a.m16908a((int) C0349R.xml.remote_config_defaults);
        }
        return f13242a;
    }

    public static void m20419a() {
        int i = 1;
        try {
            m20416M();
        } catch (Exception e) {
            i = 0;
        }
        if (i == 0) {
            hhx.m23869a(new fqp(), 0, 2000);
        } else {
            m20417N();
        }
    }

    private static void m20417N() {
        if (!gef.m21805a().m21838h() || !gyn.m23256m()) {
            return;
        }
        if (gef.m21805a().m21835e()) {
            m20418O();
            return;
        }
        FirebaseAuth.m2463a().m2483d().mo2124a(new fqq(System.currentTimeMillis()));
    }

    private static void m20418O() {
        m20416M().m16907a(43200).mo2124a(new fqr());
    }

    public static long m20420b() {
        String s = gvj.m23029s();
        if (!fbb.m18763c(s)) {
            try {
                return (long) Integer.parseInt(s);
            } catch (Exception e) {
            }
        }
        return m20416M().m16905a("recommend_timestamp");
    }

    public static boolean m20421c() {
        return VERSION.SDK_INT >= 12 && gef.m21805a().m21838h() && ((m20416M().m16915c("is_show_discovery") || gvj.m23028r()) && !fbb.m18763c(m20416M().m16911b("soundcloud_client_id")) && gvj.m23024q() > 0);
    }

    public static String m20422d() {
        return m20416M().m16911b("soundcloud_client_id");
    }

    public static boolean m20423e() {
        return m20416M().m16915c("is_show_flash_page_ad");
    }

    public static int m20424f() {
        return (int) m20416M().m16905a("load_flash_page_ad_time");
    }

    public static int m20425g() {
        return (int) m20416M().m16905a("show_flash_page_ad_time");
    }

    public static int m20426h() {
        return (int) m20416M().m16905a("show_flash_page_ad_times");
    }

    public static boolean m20427i() {
        return m20416M().m16915c("is_show_allsonglist_page_ad");
    }

    public static int m20428j() {
        return (int) m20416M().m16905a("show_allsonglist_page_ad_max_times");
    }

    public static int m20429k() {
        return (int) m20416M().m16905a("show_allsonglist_page_ad_times");
    }

    public static int m20430l() {
        return (int) m20416M().m16905a("show_allsonglist_page_ad_listen_delay");
    }

    public static boolean m20431m() {
        return m20416M().m16915c("is_show_play_page_ad");
    }

    public static int m20432n() {
        return (int) m20416M().m16905a("show_play_page_ad_max_times");
    }

    public static int m20433o() {
        return (int) m20416M().m16905a("show_play_page_ad_min_times");
    }

    public static int m20434p() {
        return (int) m20416M().m16905a("show_play_page_ad_times");
    }

    public static int m20435q() {
        return (int) m20416M().m16905a("show_play_page_ad_listen_delay");
    }

    public static int m20436r() {
        return (int) m20416M().m16905a("show_play_page_ad_delay");
    }

    public static int m20437s() {
        return (int) m20416M().m16905a("show_play_page_ad_duration");
    }

    public static int m20438t() {
        return (int) m20416M().m16905a("show_play_page_ad_interval");
    }

    public static boolean m20439u() {
        return m20416M().m16915c("is_show_switch_foreground_ad");
    }

    public static int m20440v() {
        return (int) m20416M().m16905a("show_switch_foreground_ad_max_times");
    }

    public static int m20441w() {
        return (int) m20416M().m16905a("show_switch_foreground_ad_min_times");
    }

    public static int m20442x() {
        return (int) m20416M().m16905a("show_switch_foreground_ad_times");
    }

    public static int m20443y() {
        return (int) m20416M().m16905a("show_switch_foreground_ad_listen_delay");
    }

    public static int m20444z() {
        return (int) m20416M().m16905a("show_switch_foreground_ad_interval");
    }

    public static boolean m20404A() {
        return m20416M().m16915c("is_show_lockscreen_ad");
    }

    public static int m20405B() {
        return (int) m20416M().m16905a("show_lockscreen_ad_times");
    }

    public static int m20406C() {
        return (int) m20416M().m16905a("show_lockscreen_ad_delay");
    }

    public static int m20407D() {
        return (int) m20416M().m16905a("show_lockscreen_ad_duration");
    }

    public static boolean m20408E() {
        return m20416M().m16915c("is_show_home_page_ad");
    }

    public static boolean m20409F() {
        return m20416M().m16915c("is_show_lockscreen_charging_page_ad");
    }

    public static int m20410G() {
        return (int) m20416M().m16905a("show_home_page_ad_listen_delay");
    }

    public static int m20411H() {
        return (int) m20416M().m16905a("show_ad_cycle_in_run_time");
    }

    public static int m20412I() {
        return (int) m20416M().m16905a("show_ad_over_listen_time");
    }
}
