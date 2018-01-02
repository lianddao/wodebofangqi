package com.miui.player.ui.controller;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.In;
import com.miui.player.meta.MetaManager;
import com.miui.player.service.MediaPlaybackService;
import com.miui.player.ui.MediaAppWidgetProvider_1x;
import com.miui.player.util.Utils;

public class WidgetController_1x {
    public static void linkButtons(Context context, RemoteViews views, boolean isPlaying) {
        ComponentName serviceName = new ComponentName(context, MediaPlaybackService.class);
        if (isPlaying) {
            views.setOnClickPendingIntent(C0329R.id.album_mask, PendingIntent.getActivity(context, 0, new Intent("com.miui.player.PLAYBACK_VIEWER"), 0));
        } else {
            views.setOnClickPendingIntent(C0329R.id.album_mask, PendingIntent.getActivity(context, 0, new Intent(In.ACTION_MUSIC_MAIN), 0));
        }
        Intent intent = new Intent(In.ACTION_TOGGLEPAUSE);
        intent.setComponent(serviceName);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
        views.setOnClickPendingIntent(C0329R.id.control_play, pendingIntent);
        views.setOnClickPendingIntent(C0329R.id.control_pause, pendingIntent);
        intent = new Intent(In.ACTION_NEXT);
        intent.setComponent(serviceName);
        views.setOnClickPendingIntent(C0329R.id.control_next, PendingIntent.getService(context, 0, intent, 0));
        intent = new Intent(In.ACTION_PREVIOUS);
        intent.setComponent(serviceName);
        views.setOnClickPendingIntent(C0329R.id.control_pre, PendingIntent.getService(context, 0, intent, 0));
        intent = new Intent(In.ACTION_TOGGLEFAVORITE);
        intent.setComponent(serviceName);
        pendingIntent = PendingIntent.getService(context, 0, intent, 0);
        views.setOnClickPendingIntent(C0329R.id.control_channel_on, pendingIntent);
        views.setOnClickPendingIntent(C0329R.id.control_channel_off, pendingIntent);
    }

    public static void updateViews(Context context, RemoteViews views, String trackName, String artistName, boolean isPlaying, boolean isChannel, boolean isFavorte) {
        String title = MetaManager.UNKNOWN_STRING;
        if (!Utils.isExternalStorageMounted() && MediaAppWidgetProvider_1x.isOnline()) {
            title = context.getString(C0329R.string.sdcard_busy_message);
        } else if (TextUtils.isEmpty(trackName)) {
            title = context.getString(C0329R.string.emptyplaylist);
        } else if (TextUtils.isEmpty(artistName)) {
            title = trackName;
        } else {
            title = String.format("%s-%s", new Object[]{trackName, artistName});
        }
        views.setTextViewText(C0329R.id.title, title);
        if (isPlaying) {
            views.setViewVisibility(C0329R.id.control_play, 8);
            views.setViewVisibility(C0329R.id.control_pause, 0);
        } else {
            views.setViewVisibility(C0329R.id.control_play, 0);
            views.setViewVisibility(C0329R.id.control_pause, 8);
        }
        if (isChannel) {
            views.setViewVisibility(C0329R.id.control_pre, 8);
            if (isFavorte) {
                views.setViewVisibility(C0329R.id.control_channel_on, 0);
                views.setViewVisibility(C0329R.id.control_channel_off, 8);
                return;
            }
            views.setViewVisibility(C0329R.id.control_channel_on, 8);
            views.setViewVisibility(C0329R.id.control_channel_off, 0);
            return;
        }
        views.setViewVisibility(C0329R.id.control_pre, 0);
        views.setViewVisibility(C0329R.id.control_channel_on, 8);
        views.setViewVisibility(C0329R.id.control_channel_off, 8);
    }
}
