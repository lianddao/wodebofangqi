package com.songbirdnest.mediaplayer.appwidget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.MediaStore.Audio.Albums;
import android.widget.RemoteViews;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.service.IMediaEventCallback.Stub;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;

public class SmallPlayerWidget extends AppWidgetProvider {

    public static final class UpdateService extends Service {
        public static final String ACTION_WIDGET_ALBUM_ART_PRESSED = "com.songbirdnest.mediaplayer.PlayerAppWidgetControl:AlbumArtPressed";
        public static final String ACTION_WIDGET_NEXT = "com.songbirdnest.mediaplayer.PlayerAppWidgetControl:Next";
        public static final String ACTION_WIDGET_PLAY = "com.songbirdnest.mediaplayer.PlayerAppWidgetControl:Play";
        public static final String ACTION_WIDGET_PREVIOUS = "com.songbirdnest.mediaplayer.PlayerAppWidgetControl:Previous";
        private static final int sServiceMode = 1;
        private boolean mConnected;
        private boolean mConnecting;
        private ServiceConnection mConnection = null;
        private Stub mMediaEventListener = new C01692();
        private BroadcastReceiver mReceiver = new C01681();
        private SongbirdMediaService mService = null;

        class C01681 extends BroadcastReceiver {
            C01681() {
            }

            public void onReceive(Context aContext, Intent aIntent) {
                String command = aIntent.getAction();
                if (command.compareTo(UpdateService.ACTION_WIDGET_NEXT) == 0) {
                    UpdateService.this.handleNextIntent();
                } else if (command.compareTo(UpdateService.ACTION_WIDGET_PREVIOUS) == 0) {
                    UpdateService.this.handlePreviousIntent();
                } else if (command.compareTo(UpdateService.ACTION_WIDGET_PLAY) == 0) {
                    UpdateService.this.handlePlayPauseIntent();
                } else if (command.compareTo(UpdateService.ACTION_WIDGET_ALBUM_ART_PRESSED) == 0) {
                    UpdateService.this.handleAlbumArtPressedIntent();
                }
            }
        }

        class C01692 extends Stub {
            C01692() {
            }

            public void onMediaMessage(int aEvent) {
                switch (aEvent) {
                    case 1:
                        UpdateService.this.pushUpdatedViews(UpdateService.this.updateViews(UpdateService.this));
                        return;
                    case 2:
                        UpdateService.this.pushUpdatedViews(UpdateService.this.updateViews(UpdateService.this));
                        return;
                    case 3:
                        UpdateService.this.pushUpdatedViews(UpdateService.this.updateViews(UpdateService.this));
                        return;
                    case 4:
                        UpdateService.this.pushUpdatedViews(UpdateService.this.updateViews(UpdateService.this));
                        return;
                    default:
                        return;
                }
            }
        }

        class C01703 implements ServiceConnection {
            C01703() {
            }

            public void onServiceConnected(ComponentName aName, IBinder aService) {
                UpdateService.this.mConnecting = false;
                UpdateService.this.mService = SongbirdMediaService.Stub.asInterface(aService);
                UpdateService.this.mConnected = true;
                try {
                    UpdateService.this.mService.registerCallback(UpdateService.this.mMediaEventListener);
                } catch (RemoteException e) {
                }
            }

            public void onServiceDisconnected(ComponentName name) {
                UpdateService.this.mConnecting = false;
                UpdateService.this.mService = null;
                UpdateService.this.mConnected = false;
            }
        }

        public void onCreate() {
            bindMediaService(this);
            IntentFilter filter = new IntentFilter();
            filter.addAction(ACTION_WIDGET_ALBUM_ART_PRESSED);
            filter.addAction(ACTION_WIDGET_PLAY);
            filter.addAction(ACTION_WIDGET_NEXT);
            filter.addAction(ACTION_WIDGET_PREVIOUS);
            registerReceiver(this.mReceiver, filter);
        }

        public void onStart(Intent aIntent, int aStartId) {
            pushUpdatedViews(updateViews(this));
        }

        public int onStartCommand(Intent aIntent, int aFlags, int aStartId) {
            super.onStartCommand(aIntent, aFlags, aStartId);
            return 1;
        }

        public void onDestroy() {
            unbindMediaService(this);
            try {
                unregisterReceiver(this.mReceiver);
            } catch (Exception e) {
            }
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        private void bindMediaService(Context aContext) {
            if (!this.mConnected && !this.mConnecting) {
                this.mConnecting = true;
                if (this.mConnection == null) {
                    this.mConnection = new C01703();
                }
                Intent i = new Intent(aContext, SongbirdMedia.class);
                aContext.startService(i);
                aContext.bindService(i, this.mConnection, 1);
            }
        }

        private void unbindMediaService(Context aContext) {
            if (this.mConnected) {
                try {
                    this.mService.unregisterCallback(this.mMediaEventListener);
                } catch (RemoteException e) {
                }
                aContext.unbindService(this.mConnection);
                this.mConnected = false;
            }
        }

        private RemoteViews updateViews(Context aContext) {
            RemoteViews updateViews = new RemoteViews(aContext.getPackageName(), C0116R.layout.small_player_appwidget);
            updatePlayPauseState(updateViews);
            updateAlbumArtState(updateViews, false);
            updateArtistAndTitleState(updateViews, aContext);
            return updateViews;
        }

        private void updatePendingIntents(RemoteViews aUpdateViews) {
            aUpdateViews.setOnClickPendingIntent(C0116R.id.small_appwidget_previous, makePendingIntent(ACTION_WIDGET_PREVIOUS));
            aUpdateViews.setOnClickPendingIntent(C0116R.id.small_appwidget_play_pause, makePendingIntent(ACTION_WIDGET_PLAY));
            aUpdateViews.setOnClickPendingIntent(C0116R.id.small_appwidget_next, makePendingIntent(ACTION_WIDGET_NEXT));
            aUpdateViews.setOnClickPendingIntent(C0116R.id.small_appwidget_art, makePendingIntent(ACTION_WIDGET_ALBUM_ART_PRESSED));
        }

        private PendingIntent makePendingIntent(String aAction) {
            Intent i = new Intent();
            i.setAction(aAction);
            i.putExtra("appWidgetIds", AppWidgetManager.getInstance(this).getAppWidgetIds(new ComponentName(this, SmallPlayerWidget.class)));
            return PendingIntent.getBroadcast(this, 0, i, 134217728);
        }

        private void updatePlayPauseState(RemoteViews aViews) {
            if (getIsPlaying()) {
                aViews.setImageViewResource(C0116R.id.small_appwidget_play_pause, C0116R.drawable.widget_pause);
            } else {
                aViews.setImageViewResource(C0116R.id.small_appwidget_play_pause, C0116R.drawable.widget_play);
            }
        }

        private void updateAlbumArtState(RemoteViews aViews, boolean aAlbumArtPressed) {
            if (checkServiceStatus()) {
                Resources res = getApplicationContext().getResources();
                PlayableItem item = getCurrentItem();
                String albumArtString = null;
                Bitmap albumArtBitmap = null;
                if (item != null) {
                    try {
                        Cursor cursor = getContentResolver().query(item.mStorageUri, new String[]{"album_key"}, "_id = ?", new String[]{Integer.toString(item.mID)}, null);
                        if (cursor == null || cursor.getCount() <= 0) {
                            cursor.close();
                        } else {
                            cursor.moveToFirst();
                            String albumKey = cursor.getString(cursor.getColumnIndex("album_key"));
                            cursor.close();
                            cursor = getContentResolver().query(Albums.getContentUri(item.mStorageVolume), new String[]{"album_art"}, "album_key = ?", new String[]{albumKey}, null);
                            if (cursor == null || cursor.getCount() <= 0) {
                                cursor.close();
                            } else {
                                cursor.moveToFirst();
                                albumArtString = cursor.getString(cursor.getColumnIndex("album_art"));
                                cursor.close();
                            }
                        }
                    } catch (Exception e) {
                        albumArtString = null;
                    }
                }
                if (albumArtString != null) {
                    albumArtBitmap = BitmapFactory.decodeFile(albumArtString);
                }
                if (albumArtBitmap == null) {
                    albumArtBitmap = BitmapFactory.decodeResource(res, C0116R.drawable.widget_art_fallback_image);
                }
                if (albumArtBitmap != null) {
                    Bitmap maskBitmap = BitmapFactory.decodeResource(res, C0116R.drawable.widget_art_alpha_mask);
                    Bitmap overlayBitmap = BitmapFactory.decodeResource(res, aAlbumArtPressed ? C0116R.drawable.widget_art_overlay_pressed : C0116R.drawable.widget_art_overlay_default);
                    int dstw = maskBitmap.getWidth();
                    int dsth = maskBitmap.getHeight();
                    int srcw = albumArtBitmap.getWidth();
                    int srch = albumArtBitmap.getHeight();
                    int ovrw = overlayBitmap.getWidth();
                    int ovrh = overlayBitmap.getHeight();
                    float src_aspect = ((float) srcw) / ((float) srch);
                    float dst_aspect = ((float) dstw) / ((float) dsth);
                    Rect rect = new Rect(0, 0, srcw, srch);
                    rect = new Rect(0, 0, ovrw, ovrh);
                    Bitmap composite = Bitmap.createBitmap(dstw, dsth, Config.ARGB_8888);
                    Canvas canvas = new Canvas(composite);
                    Paint paint = new Paint(1);
                    paint.setFilterBitmap(false);
                    if (src_aspect > dst_aspect) {
                        int scaledWidth = (int) (((float) dsth) * src_aspect);
                        rect = new Rect((-(scaledWidth - dstw)) / 2, 0, ((scaledWidth - dstw) / 2) + dstw, dsth);
                    } else {
                        int scaledHeight = (int) (((float) dstw) / src_aspect);
                        rect = new Rect(0, (-(scaledHeight - dsth)) / 2, dstw, ((scaledHeight - dsth) / 2) + dsth);
                    }
                    canvas.drawBitmap(albumArtBitmap, rect, dst, paint);
                    canvas.drawBitmap(overlayBitmap, rect, rect, paint);
                    paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                    canvas.drawBitmap(maskBitmap, 0.0f, 0.0f, paint);
                    paint.setXfermode(null);
                    aViews.setImageViewBitmap(C0116R.id.small_appwidget_art, composite);
                }
            }
        }

        private void updateArtistAndTitleState(RemoteViews aViews, Context aContext) {
            if (checkServiceStatus()) {
                String artistName = "";
                try {
                    artistName = this.mService.getArtistName();
                } catch (Exception e) {
                    artistName = aContext.getString(C0116R.string.unknown);
                }
                String songName = "";
                try {
                    songName = this.mService.getTrackName();
                } catch (Exception e2) {
                    songName = aContext.getString(C0116R.string.unknown);
                }
                if (getIsPlaying()) {
                    aViews.setViewVisibility(C0116R.id.small_appwidget_fallback_logo, 4);
                    aViews.setViewVisibility(C0116R.id.small_appwidget_media_info, 0);
                }
                aViews.setTextViewText(C0116R.id.small_appwidget_artist_name, artistName);
                aViews.setTextViewText(C0116R.id.small_appwidget_song_name, songName);
            }
        }

        private void pushUpdatedViews(RemoteViews aViews) {
            updatePendingIntents(aViews);
            AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(this, SmallPlayerWidget.class), aViews);
        }

        private void handlePreviousIntent() {
            if (checkServiceStatus()) {
                try {
                    this.mService.prev();
                } catch (Exception e) {
                }
            }
        }

        private void handleNextIntent() {
            if (checkServiceStatus()) {
                try {
                    this.mService.next();
                } catch (Exception e) {
                }
            }
        }

        private void handlePlayPauseIntent() {
            if (checkServiceStatus()) {
                try {
                    if (getIsPlaying()) {
                        this.mService.pause();
                    } else {
                        this.mService.play();
                    }
                } catch (Exception e) {
                }
            }
        }

        private void handleAlbumArtPressedIntent() {
            if (checkServiceStatus()) {
                RemoteViews updateViews = new RemoteViews(getPackageName(), C0116R.layout.small_player_appwidget);
                updateAlbumArtState(updateViews, true);
                pushUpdatedViews(updateViews);
                String currentActivity = null;
                String currentActivityToken = null;
                try {
                    currentActivity = this.mService.getCurrentListActivity();
                    currentActivityToken = this.mService.getCurrentListToken();
                } catch (Exception e) {
                }
                Intent i = Utils.buildIntent(currentActivity, currentActivityToken, true, this);
                if (getCurrentItem() != null) {
                    i.putExtra(Constants.EXTRA_DRAWER_SHOULD_OPEN, true);
                }
                i.setFlags(335544320);
                startActivity(i);
                updateViews = new RemoteViews(getPackageName(), C0116R.layout.small_player_appwidget);
                updateAlbumArtState(updateViews, false);
                pushUpdatedViews(updateViews);
            }
        }

        private boolean checkServiceStatus() {
            if (this.mService != null) {
                return true;
            }
            this.mConnected = false;
            bindMediaService(this);
            return false;
        }

        private boolean getIsPlaying() {
            if (!checkServiceStatus()) {
                return false;
            }
            try {
                return this.mService.isPlaying();
            } catch (Exception e) {
                return false;
            }
        }

        private PlayableItem getCurrentItem() {
            try {
                return this.mService.getCurrentItem();
            } catch (Exception e) {
                return null;
            }
        }
    }

    public void onEnabled(Context aContext) {
        super.onEnabled(aContext);
        Analytics.getAnalytics().trackEvent(Analytics.EVENT_4X1_WIDGET_ON);
    }

    public void onDisabled(Context aContext) {
        super.onDisabled(aContext);
        aContext.stopService(new Intent(aContext, UpdateService.class));
    }

    public void onDeleted(Context aContext, int[] aAppWidgetIds) {
        super.onDeleted(aContext, aAppWidgetIds);
        Analytics.getAnalytics().trackEvent(Analytics.EVENT_4X1_WIDGET_OFF);
    }

    public void onReceive(Context aContext, Intent aIntent) {
        super.onReceive(aContext, aIntent);
    }

    public void onUpdate(Context aContext, AppWidgetManager aManager, int[] aAppWidgetIds) {
        aContext.startService(new Intent(aContext, UpdateService.class));
    }
}
