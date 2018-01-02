package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.util.Locale;

public class gnp {
    private static boolean f14472a = true;
    private static ImageView f14473b = new ImageView(eys.m18562a());

    public static void m22534a(Service service, glg com_ushareit_listenit_glg, boolean z) {
        int a = m22528a((Context) service);
        m22542c(service, com_ushareit_listenit_glg, null, z);
        fzi.m21402a((Context) service, (gla) com_ushareit_listenit_glg, f14473b, tv.HIGH, a, new gnq(service, com_ushareit_listenit_glg, z));
    }

    private static int m22528a(Context context) {
        return VERSION.SDK_INT >= 16 ? (int) context.getResources().getDimension(C0349R.dimen.common_dimens_128dp) : (int) context.getResources().getDimension(C0349R.dimen.common_dimens_64dp);
    }

    private static void m22542c(Service service, glg com_ushareit_listenit_glg, Bitmap bitmap, boolean z) {
        hhx.m23867a(new gnr("showMiniPlayerNotification", service, com_ushareit_listenit_glg, bitmap, z));
    }

    private static void m22543d(Service service, glg com_ushareit_listenit_glg, Bitmap bitmap, boolean z) {
        Notification a;
        if (VERSION.SDK_INT >= 16) {
            a = m22529a((Context) service, com_ushareit_listenit_glg, bitmap, z);
        } else {
            a = m22536b((Context) service, com_ushareit_listenit_glg, bitmap, z);
        }
        service.startForeground(10000001, a);
        f14472a = false;
    }

    @TargetApi(16)
    public static Notification m22529a(Context context, glg com_ushareit_listenit_glg, Bitmap bitmap, boolean z) {
        boolean a = fre.m20627a(com_ushareit_listenit_glg);
        ca caVar = new ca(context);
        caVar.m10539a(true);
        caVar.m10543b(false);
        caVar.m10546c(com_ushareit_listenit_glg.f14338f);
        caVar.m10545c(2);
        if (VERSION.SDK_INT >= 21) {
            caVar.m10534a((int) C0349R.drawable.notification_small_icon);
        } else {
            caVar.m10534a((int) C0349R.drawable.ic_header);
        }
        caVar.m10537a(m22541c(context, com_ushareit_listenit_glg, bitmap, z));
        caVar.m10536a(m22537b(context.getApplicationContext(), "com.ushareit.listenit.action.NOTIFICATION"));
        Notification a2 = caVar.m10533a();
        a2.bigContentView = m22531a(context, com_ushareit_listenit_glg, bitmap, z, a);
        a2.flags = 98;
        return a2;
    }

    public static Notification m22536b(Context context, glg com_ushareit_listenit_glg, Bitmap bitmap, boolean z) {
        ca caVar = new ca(context);
        caVar.m10539a(true);
        caVar.m10543b(false);
        caVar.m10546c(com_ushareit_listenit_glg.f14338f);
        caVar.m10545c(2);
        caVar.m10534a((int) C0349R.drawable.ic_header);
        caVar.m10537a(m22541c(context, com_ushareit_listenit_glg, bitmap, z));
        caVar.m10536a(m22537b(context.getApplicationContext(), "com.ushareit.listenit.action.NOTIFICATION"));
        Notification a = caVar.m10533a();
        a.contentView = m22541c(context, com_ushareit_listenit_glg, bitmap, z);
        a.flags = 98;
        return a;
    }

    private static RemoteViews m22531a(Context context, glg com_ushareit_listenit_glg, Bitmap bitmap, boolean z, boolean z2) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0349R.layout.miniplayer_big_notification);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(C0349R.id.albumart, bitmap);
        }
        remoteViews.setTextViewText(C0349R.id.song_name, com_ushareit_listenit_glg.f14338f);
        remoteViews.setTextViewText(C0349R.id.artist_name, com_ushareit_listenit_glg.f14339g);
        if (m22540b(context)) {
            remoteViews.setImageViewResource(C0349R.id.play, z ? C0349R.drawable.notification_white_pause_bg : C0349R.drawable.notification_white_play_bg);
            if (m22539b()) {
                remoteViews.setImageViewResource(C0349R.id.play_next, C0349R.drawable.notification_white_prev_bg);
                remoteViews.setImageViewResource(C0349R.id.play_prev, C0349R.drawable.notification_white_next_bg);
            } else {
                remoteViews.setImageViewResource(C0349R.id.play_next, C0349R.drawable.notification_white_next_bg);
                remoteViews.setImageViewResource(C0349R.id.play_prev, C0349R.drawable.notification_white_prev_bg);
            }
            remoteViews.setImageViewResource(C0349R.id.favorite, z2 ? C0349R.drawable.notification_white_favorite_selected_bg : C0349R.drawable.notification_white_favorite_unselected_bg);
            remoteViews.setImageViewResource(C0349R.id.close, C0349R.drawable.notification_white_close_bg);
        } else {
            remoteViews.setImageViewResource(C0349R.id.play, z ? C0349R.drawable.notification_black_pause_bg : C0349R.drawable.notification_black_play_bg);
            if (m22539b()) {
                remoteViews.setImageViewResource(C0349R.id.play_next, C0349R.drawable.notification_black_prev_bg);
                remoteViews.setImageViewResource(C0349R.id.play_prev, C0349R.drawable.notification_black_next_bg);
            } else {
                remoteViews.setImageViewResource(C0349R.id.play_next, C0349R.drawable.notification_black_next_bg);
                remoteViews.setImageViewResource(C0349R.id.play_prev, C0349R.drawable.notification_black_prev_bg);
            }
            remoteViews.setImageViewResource(C0349R.id.favorite, z2 ? C0349R.drawable.notification_black_favorite_selected_bg : C0349R.drawable.notification_black_favorite_unselected_bg);
            remoteViews.setImageViewResource(C0349R.id.close, C0349R.drawable.notification_black_close_bg);
        }
        remoteViews.setOnClickPendingIntent(C0349R.id.play, m22530a(context, "com.ushareit.listenit.action.playpause"));
        remoteViews.setOnClickPendingIntent(C0349R.id.play_next, m22530a(context, "com.ushareit.listenit.action.playnext"));
        remoteViews.setOnClickPendingIntent(C0349R.id.play_prev, m22530a(context, "com.ushareit.listenit.action.playprev"));
        remoteViews.setOnClickPendingIntent(C0349R.id.favorite, m22530a(context, "com.ushareit.listenit.action.favorite"));
        remoteViews.setOnClickPendingIntent(C0349R.id.close, m22530a(context, "com.ushareit.listenit.action.close"));
        return remoteViews;
    }

    @SuppressLint({"InlinedApi"})
    private static boolean m22539b() {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }

    private static RemoteViews m22541c(Context context, glg com_ushareit_listenit_glg, Bitmap bitmap, boolean z) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0349R.layout.miniplayer_notification);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(C0349R.id.albumart, bitmap);
        }
        remoteViews.setTextViewText(C0349R.id.song_name, com_ushareit_listenit_glg.f14338f);
        remoteViews.setTextViewText(C0349R.id.artist_name, com_ushareit_listenit_glg.f14339g);
        if (m22540b(context)) {
            remoteViews.setImageViewResource(C0349R.id.play_prev, C0349R.drawable.notification_white_prev_bg);
            remoteViews.setImageViewResource(C0349R.id.play, z ? C0349R.drawable.notification_white_pause_bg : C0349R.drawable.notification_white_play_bg);
            remoteViews.setImageViewResource(C0349R.id.play_next, C0349R.drawable.notification_white_next_bg);
            remoteViews.setImageViewResource(C0349R.id.close, C0349R.drawable.notification_white_close_bg);
        } else {
            remoteViews.setImageViewResource(C0349R.id.play_prev, C0349R.drawable.notification_black_prev_bg);
            remoteViews.setImageViewResource(C0349R.id.play, z ? C0349R.drawable.notification_black_pause_bg : C0349R.drawable.notification_black_play_bg);
            remoteViews.setImageViewResource(C0349R.id.play_next, C0349R.drawable.notification_black_next_bg);
            remoteViews.setImageViewResource(C0349R.id.close, C0349R.drawable.notification_black_close_bg);
        }
        remoteViews.setOnClickPendingIntent(C0349R.id.play, m22530a(context, "com.ushareit.listenit.action.playpause"));
        remoteViews.setOnClickPendingIntent(C0349R.id.play_prev, m22530a(context, "com.ushareit.listenit.action.playprev"));
        remoteViews.setOnClickPendingIntent(C0349R.id.play_next, m22530a(context, "com.ushareit.listenit.action.playnext"));
        remoteViews.setOnClickPendingIntent(C0349R.id.close, m22530a(context, "com.ushareit.listenit.action.close"));
        return remoteViews;
    }

    private static boolean m22540b(Context context) {
        int defaultColor;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C0349R.style.NotificationStyle.Title, new int[]{16842904});
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        obtainStyledAttributes.recycle();
        if (colorStateList != null) {
            defaultColor = colorStateList.getDefaultColor();
        } else {
            defaultColor = 0;
        }
        double d = ((double) ((defaultColor >> 8) & 255)) * 0.587d;
        if (((int) ((((double) (defaultColor & 255)) * 0.114d) + (d + (0.299d * ((double) ((defaultColor >> 16) & 255)))))) > 128) {
            return true;
        }
        return false;
    }

    public static void m22532a(Service service) {
        service.stopForeground(true);
        f14472a = true;
    }

    public static boolean m22535a() {
        return f14472a;
    }

    private static PendingIntent m22530a(Context context, String str) {
        Intent intent = new Intent(str);
        intent.putExtra("extra_from", "notification");
        return PendingIntent.getBroadcast(context, 1, intent, 134217728);
    }

    private static PendingIntent m22537b(Context context, String str) {
        Intent intent = new Intent(str);
        intent.putExtra("extra_from", "notification");
        return PendingIntent.getActivity(context, 1, intent, 134217728);
    }
}
