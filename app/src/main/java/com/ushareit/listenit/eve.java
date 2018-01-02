package com.ushareit.listenit;

import android.content.Context;

public class eve extends exz {
    private static eve f11932a = null;

    public static synchronized eve m18153a() {
        eve com_ushareit_listenit_eve;
        synchronized (eve.class) {
            if (f11932a == null) {
                f11932a = new eve(eys.m18562a());
            }
            com_ushareit_listenit_eve = f11932a;
        }
        return com_ushareit_listenit_eve;
    }

    private eve(Context context) {
        super(context, "cmd");
    }

    public long m18156b() {
        if (m18000e("last_manual_act_t")) {
            return m17989a("last_manual_act_t", 0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        m17996b("last_manual_act_t", currentTimeMillis);
        return currentTimeMillis;
    }

    public void m18155a(long j) {
        m17996b("last_manual_act_t", j);
    }

    public long m18158c() {
        return m17989a("last_show_notify_t", 0);
    }

    public void m18157b(long j) {
        m17996b("last_show_notify_t", j);
    }

    public long m18160d() {
        return m17989a("last_succ_alarm_t", 0);
    }

    public void m18159c(long j) {
        m17996b("last_succ_alarm_t", j);
    }

    public long m18162e() {
        return m17989a("next_alarm_t", 0);
    }

    public void m18161d(long j) {
        m17996b("next_alarm_t", j);
    }

    public static boolean m18154a(Context context) {
        return euo.m18017a(context, "cmd_report_detail", false);
    }

    public boolean m18163f() {
        return m17992a("auto_update_install", true);
    }
}
