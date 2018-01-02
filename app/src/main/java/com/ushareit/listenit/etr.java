package com.ushareit.listenit;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class etr {
    private static long f11835a = -1;

    public static void m17940a(eud com_ushareit_listenit_eud) {
        synchronized (etr.class) {
            long d = com_ushareit_listenit_eud.m17985d();
            if (d == 0) {
                d = new eug(eys.m18562a()).m17989a("event_sn", 0);
                if (d == 0) {
                    d = m17941b();
                }
            }
            f11835a = d + 1;
        }
    }

    public static void m17942b(eud com_ushareit_listenit_eud) {
        long d = com_ushareit_listenit_eud.m17985d();
        exu.m18433a(d >= 0);
        if (d != 0) {
            new eug(eys.m18562a()).m17996b("event_sn", d);
        }
    }

    public static long m17939a() {
        long j;
        if (exw.f12142a) {
            exu.m18433a(f11835a >= 0);
        }
        synchronized (etr.class) {
            j = f11835a;
            f11835a = 1 + j;
        }
        return j;
    }

    private static long m17941b() {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US);
        try {
            return Long.parseLong(String.format(Locale.US, "1%01d%02d%02d%02d%02d%02d0000000", new Object[]{Integer.valueOf(instance.get(1) % 10), Integer.valueOf(instance.get(2)), Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)), Integer.valueOf(instance.get(13))}));
        } catch (Exception e) {
            return 1000000000000000000L;
        }
    }
}
