package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class fel {
    private static final String f12542a = fel.class.getSimpleName();

    public static List<String> m18955a() {
        return m18956a("ad_group_flash_page", m18963h());
    }

    public static List<String> m18957b() {
        return m18956a("ad_group_play_page", m18964i());
    }

    public static List<String> m18958c() {
        return m18956a("ad_group_allsonglist_page", m18965j());
    }

    public static List<String> m18959d() {
        return m18956a("ad_group_switch_foreground", m18966k());
    }

    public static List<String> m18960e() {
        return m18956a("ad_group_home_page", m18967l());
    }

    public static List<String> m18961f() {
        return m18956a("ad_group_lockscreen_page", m18968m());
    }

    public static List<String> m18962g() {
        return m18956a("ad_group_lockscreen_charging_page", m18969n());
    }

    private static List<String> m18963h() {
        List arrayList = new ArrayList();
        arrayList.add("ad:mopub_b_57b3643af1504ab2a5740983bb3367c2&&n");
        return arrayList;
    }

    private static List<String> m18964i() {
        List arrayList = new ArrayList();
        arrayList.add("ad:facebook_s_507254669466735_694700140722186&&n");
        return arrayList;
    }

    private static List<String> m18965j() {
        List arrayList = new ArrayList();
        arrayList.add("ad:mopub_n_8c0064147c824640ad9663e45346a881&&n");
        return arrayList;
    }

    private static List<String> m18966k() {
        List arrayList = new ArrayList();
        arrayList.add("ad:mopub_b_d2f78a4fba4f4a409c45a8dfa36e8051&&i");
        return arrayList;
    }

    private static List<String> m18967l() {
        List arrayList = new ArrayList();
        arrayList.add("ad:mopub_n_8c0064147c824640ad9663e45346a881&&n");
        return arrayList;
    }

    private static List<String> m18968m() {
        List arrayList = new ArrayList();
        arrayList.add("ad:mopub_s_efc7cb5bc62b4c6589181875c9423dc7&&n");
        return arrayList;
    }

    private static List<String> m18969n() {
        List arrayList = new ArrayList();
        arrayList.add("ad:mopub_b_182fabd924bd4165a371f30ef8fccfb6&&n");
        return arrayList;
    }

    private static List<String> m18956a(String str, List<String> list) {
        String a = euo.m18011a(eys.m18562a(), str, "");
        if (fbb.m18763c(a)) {
            return list;
        }
        try {
            JSONArray jSONArray = new JSONArray(a).optJSONObject(0).getJSONArray("types");
            int length = jSONArray.length();
            List<String> arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.optString(i));
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return list;
        } catch (Throwable e) {
            e.printStackTrace();
            exw.m18457e(f12542a, "getAdConfig, error=" + exw.m18438a(e));
            return list;
        }
    }
}
