package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.analytics.C0154a;
import java.lang.reflect.Method;

public class gda {
    public static boolean m21728a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    public static double m21729b(Context context) {
        try {
            Class cls = Class.forName("com.android.internal.os.PowerProfile");
            Object newInstance = cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            Method declaredMethod = cls.getDeclaredMethod("getBatteryCapacity", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Double) declaredMethod.invoke(newInstance, new Object[0])).doubleValue();
        } catch (Exception e) {
            return 1500.0d;
        }
    }

    public static String m21726a(Context context, int i, int i2) {
        if (i2 != 1 && i2 != 2 && i2 != 4) {
            return null;
        }
        long min = Math.min(i2 == 1 ? gvj.m22927d(54000) : gvj.m22946f(108000), i2 == 1 ? 216000 : 432000);
        if (min != 0) {
            return m21727a(context, min * ((long) (100 - i)), i);
        }
        double b = m21729b(context);
        return m21727a(context, (long) (((b - ((((double) i) * b) / 100.0d)) / ((double) (i2 == 1 ? 1000.0f : 500.0f))) * 3600000.0d), i);
    }

    public static String m21727a(Context context, long j, int i) {
        int i2;
        int i3;
        if (j > C0154a.f2954j) {
            i2 = (int) (j / C0154a.f2954j);
            j -= (long) (3600000 * i2);
            i3 = i2;
        } else {
            i3 = 0;
        }
        i2 = i == 100 ? 0 : Math.max(1, (int) (j / 60000));
        if (i3 > 0) {
            return context.getResources().getString(C0349R.string.screen_remain_charging_hr, new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        }
        return context.getString(C0349R.string.screen_remain_charging_min, new Object[]{Integer.valueOf(i2)});
    }

    public static int m21725a(int i) {
        if (i >= 0 && i <= 80) {
            return C0349R.string.screen_charging_speed_status;
        }
        if (i > 80 && i <= 95) {
            return C0349R.string.screen_charging_continue_status;
        }
        if (i <= 95 || i >= 100) {
            return C0349R.string.screen_charging_fully_status;
        }
        return C0349R.string.screen_charging_trickle_status;
    }
}
