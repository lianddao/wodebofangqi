package com.ushareit.listenit;

import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;
import java.util.Random;

public class gyp {
    public static gum m23272a() {
        int i = 0;
        while (gys.m23310a() == null) {
            StringBuilder append = new StringBuilder().append("getPlayService: count=");
            int i2 = i + 1;
            exw.m18443a("PlayerUtils", append.append(i).toString());
            if (i2 > CtaButton.WIDTH_DIPS) {
                throw new gyq("getPlayServcie timeout");
            }
            try {
                Thread.sleep(200);
                i = i2;
            } catch (Exception e) {
                e.printStackTrace();
                i = i2;
            }
        }
        return gys.m23310a();
    }

    public static boolean m23285b() {
        return gys.m23310a() != null;
    }

    public static void m23277a(List<glg> list, int i, String str) {
        try {
            if (m23272a().mo2453j()) {
                m23283b(list, i, str);
            } else {
                m23278a(list, (glg) list.get(0), i, str);
            }
        } catch (gyq e) {
            m23275a("playAll");
        }
    }

    public static void m23283b(List<glg> list, int i, String str) {
        try {
            m23278a(list, (glg) list.get(new Random(System.currentTimeMillis()).nextInt(list.size())), i, str);
            m23272a().mo2436b(true);
        } catch (gyq e) {
            m23275a("shufflePlayAll");
        }
    }

    public static void m23278a(List<glg> list, glg com_ushareit_listenit_glg, int i, String str) {
        try {
            m23272a().mo2422a((List) list, com_ushareit_listenit_glg);
            gvj.m22920c(eys.m18562a(), i);
            gvj.m22909b(eys.m18562a(), str);
        } catch (gyq e) {
            m23275a("playQueue");
        }
    }

    public static void m23274a(glg com_ushareit_listenit_glg) {
        try {
            m23272a().mo2413a(com_ushareit_listenit_glg);
        } catch (gyq e) {
            m23275a("playSong");
        }
    }

    public static void m23286c() {
        try {
            m23272a().mo2442d();
        } catch (gyq e) {
            m23275a("playOrPause");
        }
    }

    public static void m23289d() {
        try {
            m23272a().mo2444e();
        } catch (gyq e) {
            m23275a("playPause");
        }
    }

    public static void m23291e() {
        try {
            m23272a().mo2451h();
        } catch (gyq e) {
            m23275a("next");
        }
    }

    public static void m23279a(boolean z) {
        try {
            m23272a().mo2424a(z);
        } catch (gyq e) {
            m23275a("prev");
        }
    }

    public static void m23273a(int i) {
        try {
            m23272a().mo2411a(i);
        } catch (gyq e) {
            m23275a("seek");
        }
    }

    public static int m23292f() {
        try {
            return m23272a().mo2454k();
        } catch (gyq e) {
            m23275a("getPlayMode");
            return 1;
        }
    }

    public static int m23293g() {
        try {
            return m23272a().mo2455l();
        } catch (gyq e) {
            m23275a("getNextPlayMode");
            return 1;
        }
    }

    public static void m23280b(int i) {
        try {
            m23272a().mo2426b(i);
        } catch (gyq e) {
            m23275a("setPlayMode");
        }
    }

    public static boolean m23294h() {
        try {
            return m23272a().mo2453j();
        } catch (gyq e) {
            m23275a("isShufflePlay");
            return false;
        }
    }

    public static void m23284b(boolean z) {
        try {
            m23272a().mo2436b(z);
        } catch (gyq e) {
            m23275a("setIsShufflePlay");
        }
    }

    public static void m23281b(glg com_ushareit_listenit_glg) {
        try {
            m23272a().mo2445e(com_ushareit_listenit_glg);
        } catch (gyq e) {
            m23275a("addNextPlaySong");
        }
    }

    public static void m23276a(List<glg> list) {
        try {
            m23272a().mo2421a((List) list);
        } catch (gyq e) {
            m23275a("addNextPlaySongs");
        }
    }

    public static void m23287c(glg com_ushareit_listenit_glg) {
        try {
            m23272a().mo2448f(com_ushareit_listenit_glg);
        } catch (gyq e) {
            m23275a("removeSong");
        }
    }

    public static void m23282b(List<glg> list) {
        try {
            m23272a().mo2435b((List) list);
        } catch (gyq e) {
            m23275a("removeSongs");
        }
    }

    public static void m23295i() {
        try {
            m23272a().mo2468y();
        } catch (gyq e) {
            m23275a("removeAllSongs");
        }
    }

    public static List<glg> m23296j() {
        try {
            return m23272a().mo2460q();
        } catch (gyq e) {
            m23275a("getPlayQueue");
            return null;
        }
    }

    public static int m23297k() {
        try {
            return m23272a().mo2462s();
        } catch (gyq e) {
            m23275a("getPlayQueueSize");
            return 0;
        }
    }

    public static long m23298l() {
        try {
            return m23272a().mo2464u();
        } catch (gyq e) {
            m23275a("getCurrSongId");
            return -1;
        }
    }

    public static int m23299m() {
        try {
            return m23272a().mo2463t();
        } catch (gyq e) {
            m23275a("getCurrPlayPosition");
            return 0;
        }
    }

    public static int m23300n() {
        try {
            return m23272a().mo2465v().f14337e;
        } catch (gyq e) {
            m23275a("getCurrSongDuration");
            return MoPubClientPositioning.NO_REPEAT;
        }
    }

    public static glg m23301o() {
        try {
            return m23272a().mo2465v();
        } catch (gyq e) {
            m23275a("getCurrSongItem");
            return null;
        }
    }

    public static boolean m23302p() {
        try {
            return m23272a().mo2425a();
        } catch (gyq e) {
            m23275a("isPlaying");
            return false;
        }
    }

    public static String m23303q() {
        return gvj.m22987k(eys.m18562a());
    }

    public static void m23304r() {
        gvj.m22909b(eys.m18562a(), "");
    }

    public static boolean m23305s() {
        int l = gvj.m22994l(eys.m18562a());
        return l == 4 || l == 8 || l == 18 || l == 17;
    }

    public static void m23288c(boolean z) {
        try {
            m23272a().mo2441c(z);
        } catch (gyq e) {
            m23275a("enableCrossFade");
        }
    }

    public static void m23290d(boolean z) {
        try {
            m23272a().mo2443d(z);
        } catch (gyq e) {
            m23275a("enableStartPauseFade");
        }
    }

    private static void m23275a(String str) {
        fii.m19322h(eys.m18562a(), str);
    }
}
