package com.ushareit.listenit;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.ads.C0074z;
import com.mopub.mobileads.MoPubInterstitial;

public class fet {
    public static void m19018a(Context context, fen com_ushareit_listenit_fen) {
        fep.m19002a().m19009a(context, new ffk(fel.m18955a(), "flash_page"), com_ushareit_listenit_fen);
    }

    public static void m19017a(Context context) {
        fep.m19002a().m19008a(context, new ffk(fel.m18955a(), "flash_page"));
    }

    public static void m19025b(Context context, fen com_ushareit_listenit_fen) {
        fep.m19002a().m19009a(context, new ffk(fel.m18958c(), "all_song_list_page"), com_ushareit_listenit_fen);
    }

    public static void m19028c(Context context, fen com_ushareit_listenit_fen) {
        fep.m19002a().m19009a(context, new ffk(fel.m18957b(), "play_page"), com_ushareit_listenit_fen);
    }

    public static void m19024b(Context context) {
        fep.m19002a().m19008a(context, new ffk(fel.m18957b(), "play_page"));
    }

    public static void m19031d(Context context, fen com_ushareit_listenit_fen) {
        fep.m19002a().m19009a(context, new ffk(fel.m18961f(), "lockscreen_page"), com_ushareit_listenit_fen);
    }

    public static void m19027c(Context context) {
        fep.m19002a().m19008a(context, new ffk(fel.m18961f(), "lockscreen_page"));
    }

    public static boolean m19022a() {
        return m19023a(new ffk(fel.m18961f(), "lockscreen_page"));
    }

    public static void m19030d(Context context) {
        m19034e(context, new feu(1000));
    }

    public static void m19034e(Context context, fen com_ushareit_listenit_fen) {
        fep.m19002a().m19009a(context, new ffk(fel.m18959d(), "switch_foreground"), com_ushareit_listenit_fen);
    }

    public static void m19033e(Context context) {
        fep.m19002a().m19008a(context, new ffk(fel.m18959d(), "switch_foreground"));
    }

    public static void m19036f(Context context, fen com_ushareit_listenit_fen) {
        fep.m19002a().m19009a(context, new ffk(fel.m18960e(), "home_page"), com_ushareit_listenit_fen);
    }

    public static void m19037g(Context context, fen com_ushareit_listenit_fen) {
        fep.m19002a().m19009a(context, new ffk(fel.m18962g(), "charging_page"), com_ushareit_listenit_fen);
    }

    public static void m19035f(Context context) {
        fep.m19002a().m19008a(context, new ffk(fel.m18962g(), "charging_page"));
    }

    public static boolean m19026b() {
        return m19023a(new ffk(fel.m18962g(), "charging_page"));
    }

    public static boolean m19023a(ffk com_ushareit_listenit_ffk) {
        return fep.m19002a().m19010a(com_ushareit_listenit_ffk);
    }

    public static boolean m19029c() {
        return m19023a(new ffk(fel.m18955a(), "flash_page"));
    }

    public static boolean m19032d() {
        return m19023a(new ffk(fel.m18959d(), "switch_foreground"));
    }

    public static void m19019a(ViewGroup viewGroup, esi com_ushareit_listenit_esi, ffl com_ushareit_listenit_ffl) {
        if (com_ushareit_listenit_ffl.f12605j.equals("n")) {
            fgx.m19161a(viewGroup, com_ushareit_listenit_ffl).m19165a(com_ushareit_listenit_esi);
        } else if (com_ushareit_listenit_ffl.f12605j.equals("i")) {
            m19021a(com_ushareit_listenit_esi, com_ushareit_listenit_ffl);
        }
    }

    public static void m19020a(ViewGroup viewGroup, esi com_ushareit_listenit_esi, ffl com_ushareit_listenit_ffl, fev com_ushareit_listenit_fev) {
        if (com_ushareit_listenit_ffl.f12605j.equals("n")) {
            fgx.m19161a(viewGroup, com_ushareit_listenit_ffl).m19166a(com_ushareit_listenit_esi, com_ushareit_listenit_fev);
        } else if (com_ushareit_listenit_ffl.f12605j.equals("i")) {
            m19021a(com_ushareit_listenit_esi, com_ushareit_listenit_ffl);
        }
    }

    public static void m19021a(esi com_ushareit_listenit_esi, ffl com_ushareit_listenit_ffl) {
        Object c = com_ushareit_listenit_esi.m17769c();
        if (c != null) {
            String str = com_ushareit_listenit_ffl.a;
            Object obj = -1;
            switch (str.hashCode()) {
                case -963929852:
                    if (str.equals("admobapp")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -963927963:
                    if (str.equals("admobcon")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 92668925:
                    if (str.equals("admob")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 104081947:
                    if (str.equals("mopub")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 497130182:
                    if (str.equals("facebook")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    if (((C0074z) c).m1171c()) {
                        ((C0074z) c).m1172d();
                        exw.m18457e("sdf", "show facebook intertitail adWrapper");
                        return;
                    }
                    return;
                case 1:
                case 2:
                case 3:
                    if (((buc) c).m9872b()) {
                        ((buc) c).m9873c();
                        return;
                    }
                    return;
                case 4:
                    if (((MoPubInterstitial) c).isReady()) {
                        ((MoPubInterstitial) c).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
