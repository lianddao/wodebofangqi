package com.ushareit.listenit;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.umeng.analytics.C0154a;
import java.util.Date;
import java.util.Random;

public class eut {
    private static final Pair<Long, Long> f11905a = new Pair(Long.valueOf(m18030a(9, 30, 0)), Long.valueOf(m18030a(14, 30, 0)));
    private static final Pair<Long, Long> f11906b = new Pair(Long.valueOf(m18030a(17, 30, 0)), Long.valueOf(m18030a(21, 30, 0)));

    public static synchronized void m18032a(Context context) {
        synchronized (eut.class) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                Intent intent = new Intent("com.ushareit.cmd.action.COMMAND_ALARM");
                intent.setPackage(context.getPackageName());
                PendingIntent service = PendingIntent.getService(context, 0, intent, 134217728);
                alarmManager.cancel(service);
                eve a = eve.m18153a();
                long e = a.m18162e();
                if (e == 0) {
                    e = m18034b(context);
                    exw.m18449b("CMD.Alarm", "new alarm: " + new Date(e).toString());
                    a.m18161d(e);
                }
                alarmManager.set(0, e, service);
                exw.m18449b("CMD.Alarm", "update alarm: " + new Date(e).toString());
            }
        }
    }

    private static long m18034b(Context context) {
        Date date = new Date(eve.m18153a().m18160d());
        long date2 = (long) date.getDate();
        long a = m18030a(date.getHours(), date.getMinutes(), date.getSeconds());
        long currentTimeMillis = System.currentTimeMillis();
        Date date3 = new Date(currentTimeMillis);
        long date4 = (long) date3.getDate();
        long a2 = m18030a(date3.getHours(), date3.getMinutes(), date3.getSeconds());
        int a3 = m18029a(a2, f11905a, 0);
        int a4 = m18029a(a, f11905a, 0);
        if (a3 < 0 || (a3 == 0 && (date2 != date4 || a4 != 0))) {
            return m18031a(currentTimeMillis - a2, f11905a);
        }
        a3 = m18029a(a2, f11906b, 0);
        int a5 = m18029a(a, f11906b, 0);
        if (a3 < 0 || (a3 == 0 && (date2 != date4 || a5 != 0))) {
            return m18031a(currentTimeMillis - a2, f11906b);
        }
        return m18031a((currentTimeMillis - a2) + C0154a.f2953i, f11905a);
    }

    public static boolean m18033a(long j) {
        Date date = new Date(j);
        long a = m18030a(date.getHours(), date.getMinutes(), date.getSeconds());
        return m18029a(a, f11905a, 120000) == 0 || m18029a(a, f11906b, 120000) == 0;
    }

    public static long m18031a(long j, Pair<Long, Long> pair) {
        return (((Long) pair.first).longValue() + j) + Math.abs(new Random().nextLong() % (((Long) pair.second).longValue() - ((Long) pair.first).longValue()));
    }

    private static int m18029a(long j, Pair<Long, Long> pair, long j2) {
        if (j < ((Long) pair.first).longValue() - j2) {
            return -1;
        }
        if (j > ((Long) pair.second).longValue() + j2) {
            return 1;
        }
        return 0;
    }

    private static long m18030a(int i, int i2, int i3) {
        return (long) (((((i * 60) + i2) * 60) + i3) * 1000);
    }
}
