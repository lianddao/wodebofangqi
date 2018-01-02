package com.xiaomi.music.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.google.android.collect.Sets;
import java.util.Set;
import java.util.concurrent.Callable;

public class ScheduleExecutor {
    private static final Set<String> KEY_IN_APP_LIFE_CYCLE = Sets.newHashSet();
    public static final long PERIOD_A_DAY = 86400;
    static final String TAG = "ScheduleExecutor";

    private ScheduleExecutor() {
    }

    public static boolean executeOnceInPeriod(Context context, String key, long period, Callable<Boolean> callable) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        long last = sp.getLong(key, 0);
        long current = System.currentTimeMillis();
        if (current < last || current > last + period) {
            try {
                if (((Boolean) callable.call()).booleanValue()) {
                    sp.edit().putLong(key, current).apply();
                }
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static boolean executeOnceInProgressLifeCycle(String key, Runnable run) {
        boolean needExecute;
        synchronized (KEY_IN_APP_LIFE_CYCLE) {
            needExecute = KEY_IN_APP_LIFE_CYCLE.add(key);
        }
        if (needExecute) {
            run.run();
        }
        return needExecute;
    }

    public static void executeOnceInAppLifeCycle(Context context, String key, Callable<Boolean> callable) {
        if (!PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, false)) {
            try {
                if (((Boolean) callable.call()).booleanValue()) {
                    setKeyInAppLifeCycle(context, key);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void unsetKeyInAppLifeCycle(Context context, String key) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(key, false);
        editor.apply();
    }

    public static void setKeyInAppLifeCycle(Context context, String key) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(key, true);
        editor.apply();
    }
}
