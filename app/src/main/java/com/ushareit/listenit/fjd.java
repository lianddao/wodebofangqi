package com.ushareit.listenit;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.ushareit.listenit.service.PlayService;
import java.util.Locale;

public abstract class fjd extends AppWidgetProvider {
    public abstract RemoteViews mo752a(Context context);

    public abstract String mo753a();

    public abstract String mo754b();

    public abstract void mo755b(Context context);

    public abstract String mo756c();

    public abstract void mo757c(Context context);

    public abstract String mo758d();

    public abstract void mo759d(Context context);

    public abstract String mo760e();

    public abstract void mo761e(Context context);

    public abstract void mo762f(Context context);

    public abstract void mo763g(Context context);

    public void onReceive(Context context, Intent intent) {
        if (intent != null && !fbb.m18763c(intent.getAction())) {
            String action = intent.getAction();
            if (action.equals(mo753a())) {
                mo755b(context);
                mo757c(context);
            } else if (action.equals(mo758d())) {
                mo759d(context);
            } else if (action.equals(mo754b())) {
                mo761e(context);
            } else if (action.equals(mo756c())) {
                mo762f(context);
            } else if (action.equals(mo760e())) {
                mo763g(context);
            }
            super.onReceive(context, intent);
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        mo757c(context);
    }

    public void m6646a(Context context, Class<?> cls) {
        hhx.m23867a(new fje(this, context, cls));
    }

    public static PendingIntent m6640a(Context context, String str) {
        Intent intent = new Intent(str);
        intent.putExtra("extra_from", "widget");
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        return PendingIntent.getBroadcast(context, 2, intent, 134217728);
    }

    public static PendingIntent m6639a(Context context, int i) {
        Intent intent = new Intent(context, PlayService.class);
        intent.setAction("com.ushareit.listenit.action.remoteplayback" + i);
        intent.putExtra("extra_action", i);
        intent.putExtra("extra_from", "widget");
        return PendingIntent.getService(context, 2, intent, 134217728);
    }

    public static PendingIntent m6641b(Context context, String str) {
        Intent intent = new Intent(str);
        intent.putExtra("extra_from", "widget");
        return PendingIntent.getActivity(context, 2, intent, 134217728);
    }

    public static gum m6642h(Context context) {
        return ((ListenItApp) context.getApplicationContext()).m4930a();
    }

    public int m6643a(boolean z) {
        return z ? C0349R.drawable.appwidget_shuffle_enable_btn_bg : C0349R.drawable.appwidget_shuffle_disable_btn_bg;
    }

    public boolean m6656f() {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }
}
