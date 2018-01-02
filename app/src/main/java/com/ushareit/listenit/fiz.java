package com.ushareit.listenit;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ushareit.listenit.appwidget.AppWidgetProvider4x1;
import com.ushareit.listenit.appwidget.AppWidgetProvider4x2;
import com.ushareit.listenit.appwidget.AppWidgetProvider4x4;

public class fiz {
    public static void m19503a() {
        Context a = eys.m18562a();
        if (m19504a(a, AppWidgetProvider4x1.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x1.update_all"));
        }
        if (m19504a(a, AppWidgetProvider4x2.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x2.update_all"));
        }
        if (m19504a(a, AppWidgetProvider4x4.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x4.update_all"));
        }
    }

    public static void m19505b() {
        Context a = eys.m18562a();
        if (m19504a(a, AppWidgetProvider4x1.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x1.update_progress"));
        }
        if (m19504a(a, AppWidgetProvider4x2.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x2.update_progress"));
        }
        if (m19504a(a, AppWidgetProvider4x4.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x4.update_progress"));
        }
    }

    public static void m19506c() {
        Context a = eys.m18562a();
        if (m19504a(a, AppWidgetProvider4x1.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x1.update_playmode"));
        }
        if (m19504a(a, AppWidgetProvider4x2.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x2.update_playmode"));
        }
        if (m19504a(a, AppWidgetProvider4x4.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x4.update_playmode"));
        }
    }

    public static void m19507d() {
        Context a = eys.m18562a();
        if (m19504a(a, AppWidgetProvider4x1.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x1.update_favorite"));
        }
        if (m19504a(a, AppWidgetProvider4x2.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x2.update_favorite"));
        }
        if (m19504a(a, AppWidgetProvider4x4.class)) {
            a.sendBroadcast(new Intent("com.ushareit.listenit.action.widget4x4.update_favorite"));
        }
    }

    private static boolean m19504a(Context context, Class<?> cls) {
        try {
            int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, cls));
            if (appWidgetIds == null || appWidgetIds.length <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
