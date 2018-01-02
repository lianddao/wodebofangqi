package com.ushareit.listenit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.util.Iterator;
import org.json.JSONObject;

public class app {
    private static app f5142a;
    private final SharedPreferences f5143b;

    public app(Context context) {
        this.f5143b = context.getApplicationContext().getSharedPreferences("com.facebook.ads.FEATURE_CONFIG", 0);
    }

    public static boolean m6619a(Context context) {
        return VERSION.SDK_INT >= 14 && atz.m7172a("com.google.android.exoplayer2", "ExoPlayer") && m6633o(context).m6638a("adnw_enable_exoplayer", false);
    }

    public static boolean m6620b(Context context) {
        return m6633o(context).m6638a("adnw_block_lockscreen", false);
    }

    public static boolean m6621c(Context context) {
        return m6633o(context).m6638a("show_metadata_rewarded_video", false);
    }

    public static boolean m6622d(Context context) {
        return VERSION.SDK_INT >= 19 && m6633o(context).m6638a("adnw_enable_iab", false);
    }

    public static boolean m6623e(Context context) {
        return m6633o(context).m6638a("adnw_debug_logging", false);
    }

    public static long m6624f(Context context) {
        return m6633o(context).m6635a("unified_logging_immediate_delay_ms", 500);
    }

    public static long m6625g(Context context) {
        return ((long) m6633o(context).m6634a("unified_logging_dispatch_interval_seconds", 300)) * 1000;
    }

    public static int m6626h(Context context) {
        return m6633o(context).m6634a("unified_logging_event_limit", -1);
    }

    public static boolean m6627i(Context context) {
        return m6633o(context).m6636a("video_and_endcard_autorotate", "autorotate_disabled").equals("autorotate_enabled");
    }

    public static boolean m6628j(Context context) {
        return m6633o(context).m6638a("show_play_pause_rewarded_video", false);
    }

    public static int m6629k(Context context) {
        return m6633o(context).m6634a("minimum_elapsed_time_after_impression", -1);
    }

    public static int m6630l(Context context) {
        return m6633o(context).m6634a("ad_viewability_tap_margin", 0);
    }

    public static boolean m6631m(Context context) {
        return m6633o(context).m6638a("visible_area_check_enabled", false);
    }

    public static int m6632n(Context context) {
        return m6633o(context).m6634a("visible_area_percentage", 50);
    }

    private static app m6633o(Context context) {
        if (f5142a == null) {
            synchronized (app.class) {
                if (f5142a == null) {
                    f5142a = new app(context);
                }
            }
        }
        return f5142a;
    }

    public int m6634a(String str, int i) {
        String string = this.f5143b.getString(str, String.valueOf(i));
        return (string == null || string.equals("null")) ? i : Integer.valueOf(string).intValue();
    }

    public long m6635a(String str, long j) {
        String string = this.f5143b.getString(str, String.valueOf(j));
        return (string == null || string.equals("null")) ? j : Long.valueOf(string).longValue();
    }

    public String m6636a(String str, String str2) {
        String string = this.f5143b.getString(str, str2);
        return (string == null || string.equals("null")) ? str2 : string;
    }

    public void m6637a(String str) {
        if (str != null && !str.isEmpty() && !str.equals("[]")) {
            Editor edit = this.f5143b.edit();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                edit.putString(str2, jSONObject.getString(str2));
            }
            edit.commit();
        }
    }

    public boolean m6638a(String str, boolean z) {
        String string = this.f5143b.getString(str, String.valueOf(z));
        return (string == null || string.equals("null")) ? z : Boolean.valueOf(string).booleanValue();
    }
}
