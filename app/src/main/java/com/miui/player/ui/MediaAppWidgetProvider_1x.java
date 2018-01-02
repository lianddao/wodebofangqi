package com.miui.player.ui;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.In;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.AlbumManager;
import com.miui.player.ui.controller.WidgetController_1x;
import com.miui.player.util.Actions;
import com.miui.player.util.BitmapHelper;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.ServiceActions;
import com.miui.player.util.Utils;
import java.io.File;

public class MediaAppWidgetProvider_1x extends AppWidgetProvider {
    private static boolean sAlbumChange = true;
    private static Bitmap sCurrentAlbum = null;
    private static boolean sIsOnline;

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        if (!Utils.isExternalStorageMounted()) {
            onReceive(context, new Intent("android.intent.action.MEDIA_EJECT"));
        }
        context.startService(new Intent(In.ACTION_REQUEST_STATUS));
    }

    private void pushUpdate(Context context, RemoteViews views) {
        AppWidgetManager gm = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = gm.getAppWidgetIds(new ComponentName(context, getClass()));
        if (appWidgetIds != null) {
            gm.updateAppWidget(appWidgetIds, views);
        }
    }

    public boolean hasInstances(Context context) {
        return AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, getClass())).length > 0;
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (hasInstances(context)) {
            String action = intent.getAction();
            if (Actions.ACTION_FAVORITE_CHANGED.equals(action)) {
                context.startService(new Intent(ServiceActions.In.ACTION_REQUEST_FAVORITE));
            } else if ("android.intent.action.MEDIA_EJECT".equals(action) || Out.STATUS_PLAYBACK_COMPLETE.equals(action) || Out.STATUS_META_CHANGED.equals(action) || Out.STATUS_QUEUE_CHANGED.equals(action) || Out.STATUS_PLAYSTATE_CHANGED.equals(action) || ServiceActions.Out.ACTION_RESPONSE_FAVORITE.equals(action)) {
                boolean z;
                if (TextUtils.isEmpty(intent.getStringExtra("online_id"))) {
                    z = false;
                } else {
                    z = true;
                }
                sIsOnline = z;
                String extra = intent.getStringExtra(Out.KEY_OTHER);
                if (!Out.META_CHANGED_BUFFERED_OVER.equals(extra) && !Out.META_CHANGED_LYRIC.equals(extra)) {
                    boolean isChannel;
                    if (Out.META_CHANGED_TRACK.equals(extra) || Out.META_CHANGED_ALBUM.equals(extra) || "android.intent.action.MEDIA_EJECT".equals(action)) {
                        sAlbumChange = true;
                    }
                    RemoteViews views = new RemoteViews(context.getPackageName(), 2130903040);
                    updateAlbum(context, views, intent);
                    String trackName = intent.getStringExtra("track");
                    String artistName = intent.getStringExtra("artist");
                    boolean isPlaying = intent.getBooleanExtra(Out.KEY_PLAYING, false);
                    if (intent.getStringExtra("channel_name") != null) {
                        isChannel = true;
                    } else {
                        isChannel = false;
                    }
                    WidgetController_1x.updateViews(context, views, trackName, artistName, isPlaying, isChannel, intent.getBooleanExtra("favorite", false));
                    WidgetController_1x.linkButtons(context, views, isPlaying);
                    pushUpdate(context, views);
                }
            }
        }
    }

    private static void updateAlbum(Context context, RemoteViews views, Intent intent) {
        Drawable drawable = context.getResources().getDrawable(C0329R.drawable.widget_album_mask);
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        if (PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_DISPLAY_ALBUM)) {
            Bitmap bm = null;
            if (sAlbumChange) {
                String path = intent.getStringExtra(Out.KEY_ALBUM_PATH);
                Uri uri = (Uri) intent.getParcelableExtra(Out.KEY_ALBUM_URI);
                if (PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_ANDROID_ALBUM)) {
                    bm = AlbumManager.getBitmapFromUri(context, uri, width, height);
                }
                if (bm == null && path != null && new File(path).exists()) {
                    bm = AlbumManager.getBitmapFromFile(path, width, height);
                }
                if (bm != null) {
                    Bitmap filter = BitmapFactory.decodeResource(context.getResources(), C0329R.drawable.widget_album_filter);
                    if (filter != null) {
                        Bitmap clipped = BitmapHelper.transferMode(bm, filter, new PorterDuffXfermode(Mode.DST_OUT));
                        filter.recycle();
                        bm.recycle();
                        bm = clipped;
                    }
                }
                sAlbumChange = false;
                sCurrentAlbum = bm;
            } else {
                bm = sCurrentAlbum;
            }
            views.setImageViewBitmap(C0329R.id.album, bm);
        }
    }

    public static boolean isOnline() {
        return sIsOnline;
    }
}
