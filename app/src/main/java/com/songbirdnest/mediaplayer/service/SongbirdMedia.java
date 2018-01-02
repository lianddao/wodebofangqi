package com.songbirdnest.mediaplayer.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.audiofx.Equalizer;
import android.media.audiofx.Equalizer.Settings;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.provider.MediaStore.Audio.Albums;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.amazon.inapp.purchasing.PurchasingManager;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.analytics.Breadcrumbs;
import com.songbirdnest.billing.BillingHelper;
import com.songbirdnest.billing.InAppPurchases;
import com.songbirdnest.billing.db.HistoryTable;
import com.songbirdnest.broadcast.APIReceiver;
import com.songbirdnest.broadcast.ControllerMap;
import com.songbirdnest.database.Model.Podcast;
import com.songbirdnest.database.Model.Song;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Playlist;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.Songbird;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.BaseActivity;
import com.songbirdnest.mediaplayer.service.EqualizerSettings.PRESET_TYPE;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService.Stub;
import com.songbirdnest.util.Base64;
import com.songbirdnest.util.DecreaseVolume;
import com.songbirdnest.util.IncreaseVolume;
import com.songbirdnest.util.Logger;
import com.songbirdnest.util.MediaUtils;
import com.songbirdnest.util.PlaylistExportCheck;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SongbirdMedia extends Service {
    public static final String INTENT_KEY = "Intent";
    public static final int NEW_SONG = 4;
    public static final String PASS_ACTION = "action";
    public static final String PASS_PACKAGE = "package";
    public static final int PAUSED = 1;
    public static final int PHOTOSTREAM_FAIL = 7;
    public static final int PHOTOSTREAM_NO_RESULTS = 8;
    public static final int PHOTOSTREAM_READY = 6;
    public static final int PLAYING = 2;
    public static final int PODCAST_BACKUP = 1000;
    public static final int PROGRESS = 5;
    public static final int RESTART_MIN_THRESHOLD = 10000;
    private static final int SERVICE_NOTIFICATION_ID = 1;
    public static final int SKIP_TO_NEXT = 1;
    public static final int SKIP_TO_NONE = 0;
    public static final int SKIP_TO_PREVIOUS = -1;
    public static final int SONG_FINISH = 3;
    public static final int USER_NEXT = 32;
    public static final int USER_PREVIOUS = 33;
    ExecutorService aAPIExec = Executors.newFixedThreadPool(1);
    private AsyncTask<PlayableItem, Void, Bitmap> aAlbumExecute;
    private PendingIntent contentIntent;
    private Equalizer equalizer;
    private EqualizerSettings equalizerSettings = new EqualizerSettings();
    ControllerMap extMap;
    private PlayableItem item = new PlayableItem("<UNKNOWN>", null, -1, -1);
    private Intent lastActivity;
    private Integer mBindCount = Integer.valueOf(0);
    private IntentFilter mBluetoothFilter = null;
    private BroadcastReceiver mBluetoothReceiver = new C02049();
    private RemoteCallbackList<IMediaEventCallback> mCallbackList;
    private OnCompletionListener mCompletionListener = new C01942();
    private OnErrorListener mErrorListener = new C01963();
    private Handler mHandler = new Handler();
    public boolean mHeadsetConnected = false;
    private IntentFilter mHeadsetFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
    private BroadcastReceiver mHeadsetReceiver = new C02038();
    Runnable mInitRunnables = new C02006();
    MediaPlayer mMediaPlayer;
    private IntentFilter mMediaScannerFilter = new IntentFilter("android.intent.action.MEDIA_EJECT");
    private BroadcastReceiver mMediaScannerReceiver = new C02027();
    private SongbirdMediaService mMediaService = null;
    private IBinder mMediaServiceBinder = null;
    PlayerMetaData mMetaData;
    private boolean mNotficationActive;
    private Notification mNotification;
    private NotificationManager mNotificationManager;
    private PhoneStateListener mPhoneStateListener = new C01921();
    PlayerState mPlayerState;
    private Playlist mPlaylist = null;
    private Cursor mPlaylistCursor = null;
    private ContentObserver mPlaylistObserver = new ContentObserver(this.mHandler) {
        public void onChange(boolean aSelfChange) {
            if (SongbirdMedia.this.mPlaylist == null) {
                Log.w(getClass().getName(), "mPlaylist was null during onChange!");
                return;
            }
            PlayableItem item = new PlayableItem("<UNKNOWN>", null, -1, -1);
            try {
                item = SongbirdMedia.this.mMediaService.getCurrentItem();
            } catch (Exception e) {
                e.printStackTrace();
                item = null;
            }
            Playlist playlist = SongbirdMedia.this.mPlaylist;
            Cursor cursor = SongbirdMedia.this.createCursorFromPlaylist(playlist);
            if (item != null) {
                int itemPlaylistIdColumn = cursor.getColumnIndex("_id");
                int itemIdColumn = cursor.getColumnIndex("audio_id");
                int itemPosition = -1;
                while (cursor.moveToNext()) {
                    int itemId = cursor.getInt(itemIdColumn);
                    if (item.mPlaylistItemID == cursor.getInt(itemPlaylistIdColumn) && item.mID == itemId) {
                        itemPosition = cursor.getPosition();
                        break;
                    }
                }
                SongbirdMedia.this.updatePlayableList(Utils.createPlayableListFromCursor(cursor), itemPosition, playlist, cursor);
            }
        }
    };
    private PodcastCheck mPodcastCheck;
    private ServicePrefs mServicePrefs;
    public boolean mShouldBePlaying = false;
    IntentFilter mStateFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
    BroadcastReceiver mStateReceiver = new C01985();
    private TelephonyManager mTelephonyManager;
    UIState mUIState;
    WakeLock mWakeLock;
    private Intent notificationIntent;
    private boolean playRing = false;
    int restorePosition = 0;

    class C01921 extends PhoneStateListener {
        int aCurrentState = -1;
        int aLastVolumeSetting = 0;

        C01921() {
        }

        public void onCallStateChanged(int aState, String aIncomingNumber) {
            super.onCallStateChanged(aState, aIncomingNumber);
            if (SongbirdMedia.this.mMediaService != null && aState != this.aCurrentState) {
                this.aCurrentState = aState;
                boolean isPlaying;
                try {
                    isPlaying = SongbirdMedia.this.mMediaService.isPlaying();
                } catch (RemoteException e) {
                    isPlaying = false;
                }
                AudioManager aManager = (AudioManager) SongbirdMedia.this.getSystemService("audio");
                if (aState == 0 && SongbirdMedia.this.playRing) {
                    SongbirdMedia.this.playRing = false;
                    SongbirdMedia.this.mShouldBePlaying = true;
                    try {
                        SongbirdMedia.this.mMediaService.play();
                    } catch (RemoteException e2) {
                    }
                    SongbirdMedia.this.mHandler.post(new IncreaseVolume(aManager, SongbirdMedia.this.mHandler, this.aLastVolumeSetting));
                } else if (aState != 0 && isPlaying) {
                    this.aLastVolumeSetting = aManager.getStreamVolume(3);
                    SongbirdMedia.this.mHandler.post(new DecreaseVolume(aManager, SongbirdMedia.this.mHandler, SongbirdMedia.this.mMediaService));
                    SongbirdMedia.this.mShouldBePlaying = false;
                    SongbirdMedia.this.playRing = true;
                }
            }
        }
    }

    class C01942 implements OnCompletionListener {

        class C01931 implements Runnable {
            C01931() {
            }

            public void run() {
                SongbirdMedia.this.next(true);
            }
        }

        C01942() {
        }

        public void onCompletion(MediaPlayer mp) {
            SongbirdMedia.this.mHandler.post(new C01931());
        }
    }

    class C01963 implements OnErrorListener {

        class C01951 implements Runnable {
            C01951() {
            }

            public void run() {
                if (SongbirdMedia.this.mShouldBePlaying) {
                    SongbirdMedia.this.next(false);
                } else if (Environment.getExternalStorageState().equals("mounted")) {
                    SongbirdMedia.this.setBookmarkIfNeeded(SongbirdMedia.this.item);
                    SongbirdMedia.this.restartCurrent(false);
                }
            }
        }

        C01963() {
        }

        public boolean onError(MediaPlayer aMediaPlayer, int aWhat, int aExtra) {
            switch (aWhat) {
                case PurchasingManager.ITEM_DATA_REQUEST_MAX_SKUS /*100*/:
                    Breadcrumbs.add(Analytics.EVENT_MEDIA_SERVER_DEATH);
                    SongbirdMedia.this.mMediaPlayer.release();
                    SongbirdMedia.this.mMediaPlayer = new MediaPlayer();
                    SongbirdMedia.this.mMediaPlayer.setWakeMode(SongbirdMedia.this, 1);
                    SongbirdMedia.this.mServicePrefs.reinitMedia();
                    SongbirdMedia.this.mHandler.postDelayed(new C01951(), 2000);
                    return true;
                default:
                    return false;
            }
        }
    }

    class C01985 extends BroadcastReceiver {
        C01985() {
        }

        public void onReceive(Context context, Intent intent) {
            String aAction = intent.getAction();
            if (!aAction.equals("android.intent.action.MEDIA_EJECT") || !aAction.equals("android.intent.action.MEDIA_MOUNTED")) {
                return;
            }
            if (aAction.equals("android.intent.action.MEDIA_MOUNTED")) {
                if (!SongbirdMedia.this.mServicePrefs.isServiceInitalized()) {
                    SongbirdMedia.this.mInitRunnables.run();
                }
            } else if (aAction.equals("android.intent.action.MEDIA_EJECT")) {
                if (SongbirdMedia.this.mMediaPlayer != null) {
                    SongbirdMedia.this.mShouldBePlaying = false;
                    SongbirdMedia.this.mMediaPlayer.reset();
                }
                SongbirdMedia.this.mServicePrefs.setServiceInitalized(false);
            }
        }
    }

    class C02006 implements Runnable {
        C02006() {
        }

        public void run() {
            SongbirdMedia.this.mServicePrefs.setServiceInitalized(true);
            try {
                SongbirdMedia.this.restoreQueue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (SongbirdMedia.this.mPodcastCheck == null) {
                SongbirdMedia.this.mPodcastCheck = new PodcastCheck(SongbirdMedia.this.getApplicationContext()) {
                    protected void onPostExecute(Boolean result) {
                        if (!result.booleanValue()) {
                            SongbirdMedia.this.mPodcastCheck = new PodcastCheck(SongbirdMedia.this.getApplicationContext());
                            SongbirdMedia.this.mPodcastCheck.execute(new Void[]{(Void) null});
                        }
                        SongbirdMedia.this.sendBroadcast(new Intent(Constants.PODCAST_UPDATE));
                        SongbirdMedia.this.mPodcastCheck = null;
                    }
                };
                SongbirdMedia.this.mPodcastCheck.execute(new Void[]{(Void) null});
            }
            new PlaylistExportCheck(SongbirdMedia.this.getApplicationContext()).execute(new Void[]{(Void) null});
        }
    }

    class C02027 extends BroadcastReceiver {
        C02027() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.MEDIA_EJECT")) {
                SongbirdMedia.this.mNotificationManager.cancel(1);
                SongbirdMedia.this.mNotficationActive = false;
                try {
                    if (SongbirdMedia.this.mMediaService.isPlaying() || SongbirdMedia.this.mMediaService.isPaused()) {
                        SongbirdMedia.this.stopForeground(true);
                        SongbirdMedia.this.mMetaData.setSongPosition(SongbirdMedia.this.mMediaPlayer.getCurrentPosition());
                        SongbirdMedia.this.pausePlayback();
                        SongbirdMedia.this.mMediaPlayer.reset();
                    }
                    SongbirdMedia.this.saveQueue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (intent.getAction().equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                try {
                    if (SongbirdMedia.this.mPodcastCheck == null) {
                        SongbirdMedia.this.mPodcastCheck = new PodcastCheck(SongbirdMedia.this.getApplicationContext()) {
                            protected void onPostExecute(Boolean result) {
                                if (!result.booleanValue()) {
                                    SongbirdMedia.this.mPodcastCheck = new PodcastCheck(SongbirdMedia.this.getApplicationContext());
                                    SongbirdMedia.this.mPodcastCheck.execute(new Void[]{(Void) null});
                                }
                                SongbirdMedia.this.sendBroadcast(new Intent(Constants.PODCAST_UPDATE));
                                SongbirdMedia.this.mPodcastCheck = null;
                            }
                        };
                        SongbirdMedia.this.mPodcastCheck.execute(new Void[]{(Void) null});
                    }
                    Utils.pruneGenres(context.getContentResolver());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    SongbirdMedia.this.restoreQueue();
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
        }
    }

    class C02038 extends BroadcastReceiver {
        C02038() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra(HistoryTable.HISTORY_STATE)) {
                int state = intent.getIntExtra(HistoryTable.HISTORY_STATE, 0);
                if (SongbirdMedia.this.mHeadsetConnected && state == 0) {
                    SongbirdMedia.this.mHeadsetConnected = false;
                    SongbirdMedia.this.playRing = false;
                    if (SongbirdMedia.this.mMediaPlayer.isPlaying()) {
                        SongbirdMedia.this.pausePlayback();
                    }
                } else if (!SongbirdMedia.this.mHeadsetConnected) {
                    if (state == 1 || state == 2 || state == 3) {
                        SongbirdMedia.this.mHeadsetConnected = true;
                    }
                }
            }
        }
    }

    class C02049 extends BroadcastReceiver {
        C02049() {
        }

        public void onReceive(Context aContext, Intent aIntent) {
            String action = aIntent.getAction();
            if (action != null) {
                Bundle extras = aIntent.getExtras();
                if (extras != null) {
                    int deviceClass = ((BluetoothDevice) extras.get("android.bluetooth.device.extra.DEVICE")).getBluetoothClass().getDeviceClass();
                    if (deviceClass != 1048 && deviceClass != 1028 && deviceClass != 1056) {
                        return;
                    }
                    if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                        SongbirdMedia.this.mHeadsetConnected = true;
                    } else if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                        SongbirdMedia.this.mHeadsetConnected = false;
                        if (SongbirdMedia.this.mMediaPlayer.isPlaying()) {
                            SongbirdMedia.this.pausePlayback();
                        }
                    }
                }
            }
        }
    }

    private class SongbirdMediaStub extends Stub {
        private SongbirdMediaStub() {
        }

        public int getAudioId() throws RemoteException {
            return SongbirdMedia.this.mMediaPlayer.getAudioSessionId();
        }

        public int duration() throws RemoteException {
            if (SongbirdMedia.this.mMediaPlayer.isPlaying() && SongbirdMedia.this.mMetaData.getCurrentDuration() == 0) {
                SongbirdMedia.this.mMetaData.setCurrentDuration(SongbirdMedia.this.mMediaPlayer.getDuration());
            }
            return SongbirdMedia.this.mMetaData.getCurrentDuration();
        }

        public String getAlbumName() throws RemoteException {
            return SongbirdMedia.this.mMetaData.getCurrentAlbum();
        }

        public String getArtistName() throws RemoteException {
            return SongbirdMedia.this.mMetaData.getCurrentArtist();
        }

        public int getListPosition() throws RemoteException {
            if (SongbirdMedia.this.mPlayerState.getActiveList() == null) {
                return -1;
            }
            int listPosition = !SongbirdMedia.this.mPlayerState.isShuffleEnabled() ? SongbirdMedia.this.mPlayerState.getListPosition() : SongbirdMedia.this.mPlayerState.getPlayableList().indexOf(SongbirdMedia.this.mPlayerState.getShuffledPlayableList().get(SongbirdMedia.this.mPlayerState.getListPosition()));
            if (backToListFromSearch()) {
                return 0 - playableID();
            }
            return listPosition;
        }

        private boolean backToListFromSearch() {
            if (Constants.TOP_MENU_SONGS.equals(SongbirdMedia.this.mUIState.getBackToListActivity()) && "-1".equals(SongbirdMedia.this.mUIState.getBackToListToken())) {
                return true;
            }
            if (Constants.TOP_MENU_PODCASTS.equals(SongbirdMedia.this.mUIState.getBackToListActivity()) && "-1".equals(SongbirdMedia.this.mUIState.getBackToListToken())) {
                return true;
            }
            return false;
        }

        private int playableID() {
            return SongbirdMedia.this.mPlayerState.getActiveItem().mID;
        }

        public int getRandom() throws RemoteException {
            if (SongbirdMedia.this.mPlayerState.isShuffleEnabled()) {
                return 1;
            }
            return 2;
        }

        public int getTrackID() throws RemoteException {
            if (SongbirdMedia.this.mPlayerState.getActiveList() == null) {
                return -1;
            }
            return SongbirdMedia.this.mPlayerState.getActiveItem().mID;
        }

        public PlayableItem getCurrentItem() throws RemoteException {
            return SongbirdMedia.this.mPlayerState.getActiveItem();
        }

        public String getTrackName() throws RemoteException {
            return SongbirdMedia.this.mMetaData.getCurrentTitle();
        }

        public boolean isPaused() throws RemoteException {
            return !SongbirdMedia.this.mMediaPlayer.isPlaying();
        }

        public boolean isPlaying() throws RemoteException {
            return SongbirdMedia.this.mShouldBePlaying;
        }

        public void next() throws RemoteException {
            Breadcrumbs.add(Analytics.EVENT_NEXT);
            SongbirdMedia.this.next(false);
        }

        public void pause() throws RemoteException {
            if (SongbirdMedia.this.mPlayerState.getActiveList() != null) {
                SongbirdMedia.this.pausePlayback();
                if (SongbirdMedia.this.mWakeLock.isHeld()) {
                    SongbirdMedia.this.mWakeLock.release();
                }
            }
        }

        public void play() throws RemoteException {
            if (SongbirdMedia.this.mPlayerState.getActiveList() == null || SongbirdMedia.this.mPlayerState.getActiveList().size() <= 0) {
                SongbirdMedia.this.startInitial();
            } else {
                SongbirdMedia.this.startPlayback();
            }
        }

        public int position() throws RemoteException {
            if (SongbirdMedia.this.mPlayerState.getActiveList() == null) {
                return 0;
            }
            if (SongbirdMedia.this.mMediaPlayer.isPlaying()) {
                SongbirdMedia.this.mMetaData.setSongPosition(SongbirdMedia.this.mMediaPlayer.getCurrentPosition());
            }
            return SongbirdMedia.this.mMetaData.getSongPosition();
        }

        public void prev() throws RemoteException {
            Breadcrumbs.add(Analytics.EVENT_PREVIOUS);
            if (SongbirdMedia.this.mMetaData.getSongPosition() >= 10000) {
                SongbirdMedia.this.mMetaData.setSongPosition(0);
                SongbirdMedia.this.setBookmarkIfNeeded(SongbirdMedia.this.item);
                SongbirdMedia.this.restartCurrent(true);
                return;
            }
            SongbirdMedia.this.previous();
        }

        public void registerCallback(IMediaEventCallback aCallback) throws RemoteException {
            aCallback.onMediaMessage(4);
            if (SongbirdMedia.this.mMediaPlayer.isPlaying()) {
                aCallback.onMediaMessage(2);
            }
            SongbirdMedia.this.mCallbackList.register(aCallback);
        }

        public void unregisterCallback(IMediaEventCallback aCallback) throws RemoteException {
            SongbirdMedia.this.mCallbackList.unregister(aCallback);
        }

        public void reset() {
            try {
                pause();
            } catch (RemoteException e) {
            }
            SongbirdMedia.this.mMediaPlayer.reset();
            SongbirdMedia.this.mPlayerState.setPlayableList(null);
            SongbirdMedia.this.mPlayerState.setListPosition(0);
            try {
                setRandom(2);
                setRepeat(1);
            } catch (RemoteException e2) {
            }
            PlayQueueDatabase pqd = new PlayQueueDatabase(SongbirdMedia.this.getApplicationContext());
            pqd.clear();
            pqd.close();
        }

        public int seek(int pos) throws RemoteException {
            if (SongbirdMedia.this.mMediaPlayer != null) {
                if (pos < 0) {
                    SongbirdMedia.this.previous();
                    pos = 0;
                } else if (pos > SongbirdMedia.this.mMediaPlayer.getDuration()) {
                    next();
                    pos = 0;
                } else {
                    SongbirdMedia.this.mMediaPlayer.seekTo(pos);
                }
            }
            SongbirdMedia.this.mMetaData.setSongPosition(pos);
            SongbirdMedia.this.setBookmarkIfNeeded(SongbirdMedia.this.item);
            SongbirdMedia.this.callCallbacks(5);
            return 0;
        }

        public void setCurrentList(String activity, String token) throws RemoteException {
            SongbirdMedia.this.mUIState.setBackToListActivity(activity);
            SongbirdMedia.this.mUIState.setBackToListToken(token);
            SongbirdMedia.this.saveState();
        }

        public void setRandom(int random) throws RemoteException {
            SongbirdMedia.this.setRandom(random, false);
            SongbirdMedia.this.saveQueue();
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            try {
                return super.onTransact(code, data, reply, flags);
            } catch (RuntimeException e) {
                Logger.error(this, "Unexpected remote exception", e);
                Analytics.getAnalytics().trackError(Analytics.EVENT_UNCAUGHTEXCEPTION, e);
                throw e;
            }
        }

        public void setPlayableListPosition(int aPosition) throws RemoteException {
            if (SongbirdMedia.this.mPlayerState.getActiveList() != null && aPosition <= SongbirdMedia.this.mPlayerState.getActiveList().size()) {
                if (SongbirdMedia.this.mMediaPlayer.isPlaying()) {
                    SongbirdMedia.this.mMediaPlayer.pause();
                    SongbirdMedia.this.mMediaPlayer.stop();
                    SongbirdMedia.this.mMediaPlayer.reset();
                }
                try {
                    SongbirdMedia.this.mPlayerState.setListPosition(aPosition);
                    SongbirdMedia.this.preparePlayback(true, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public int getPlayableListSize() throws RemoteException {
            if (SongbirdMedia.this.mPlayerState.getActiveList() == null) {
                return 0;
            }
            return SongbirdMedia.this.mPlayerState.getActiveList().size();
        }

        public void setPlayableList(List<PlayableItem> aList, int aPosition) throws RemoteException {
            SongbirdMedia.this.setPlayableListInternal(aList, aPosition, false, true, null);
        }

        public void setShuffledPlayableList(List<PlayableItem> aList) throws RemoteException {
            SongbirdMedia.this.setPlayableListInternal(aList, 0, true, true, null);
        }

        public void setPlayablePlaylist(Playlist aPlaylist, int aPlaylistPosition, boolean aShuffle) throws RemoteException {
            Cursor cursor = SongbirdMedia.this.createCursorFromPlaylist(aPlaylist);
            SongbirdMedia.this.setPlayableListInternal(Utils.createPlayableListFromCursor(cursor), aPlaylistPosition, aShuffle, true, cursor);
            SongbirdMedia.this.mPlaylist = aPlaylist;
        }

        public void stop() throws RemoteException {
            SongbirdMedia.this.mMediaPlayer.stop();
        }

        public String getCurrentListActivity() throws RemoteException {
            return SongbirdMedia.this.mUIState.getBackToListActivity();
        }

        public String getCurrentListToken() throws RemoteException {
            return SongbirdMedia.this.mUIState.getBackToListToken();
        }

        public void setRepeat(int state) throws RemoteException {
            SongbirdMedia.this.processRepeatChange(state);
        }

        public int getRepeat() throws RemoteException {
            return SongbirdMedia.this.mPlayerState.getRepeatState();
        }

        public void setPhotostream(int state) throws RemoteException {
            SongbirdMedia.this.mUIState.setPhotostreamState(state);
        }

        public int getPhotostream() throws RemoteException {
            return SongbirdMedia.this.mUIState.getPhotostreamState();
        }

        public int getCurrentSongToken() throws RemoteException {
            return SongbirdMedia.this.mMetaData.getTrackToken();
        }

        public void setLastActivity(Intent myActivity) throws RemoteException {
            SongbirdMedia.this.lastActivity = (Intent) myActivity.clone();
            if (SongbirdMedia.this.mNotficationActive) {
                SongbirdMedia.this.fireNotification();
            }
        }

        public void getPhotoImage(final IPhotoStreamCallback aAlbumArtCallback, int aTargetImage) throws RemoteException {
            if (SongbirdMedia.this.aAlbumExecute != null) {
                SongbirdMedia.this.aAlbumExecute.cancel(true);
            }
            SongbirdMedia.this.mHandler.post(new Runnable() {

                class C02051 extends AsyncTask<PlayableItem, Void, Bitmap> {
                    C02051() {
                    }

                    protected Bitmap doInBackground(PlayableItem... params) {
                        return SongbirdMedia.this.setAlbumArt(params[0]);
                    }

                    protected void onPostExecute(Bitmap result) {
                        try {
                            if (aAlbumArtCallback != null) {
                                aAlbumArtCallback.imageDone(result);
                                SongbirdMedia.this.callCallbacks(6);
                            }
                        } catch (RemoteException e) {
                        }
                    }

                    protected void onCancelled() {
                        SongbirdMedia.this.aAlbumExecute = null;
                    }
                }

                public void run() {
                    try {
                        SongbirdMedia.this.aAlbumExecute = new C02051().execute(new PlayableItem[]{SongbirdMediaStub.this.getCurrentItem()});
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public int getPhotostreamSize() throws RemoteException {
            return 0;
        }

        public void setEQEnabled(boolean enabled) throws RemoteException {
            if (SongbirdMedia.this.equalizer != null) {
                SongbirdMedia.this.equalizer.setEnabled(enabled);
                SongbirdMedia.this.equalizerSettings.setEnabled(enabled);
            }
        }

        public boolean isEQEnabled() throws RemoteException {
            if (SongbirdMedia.this.equalizer != null && SongbirdMedia.this.equalizerSettings.isEnabled() && BillingHelper.isBillingAvailable(SongbirdMedia.this, InAppPurchases.EQUALIZER)) {
                return true;
            }
            return false;
        }

        public void usePreset(int preset) throws RemoteException {
            if (SongbirdMedia.this.equalizer == null) {
                return;
            }
            if (SongbirdMedia.this.equalizer.getNumberOfPresets() < preset) {
                Logger.error((Object) this, "SongbirdMedia:usePreset Invalid preset # " + preset);
                return;
            }
            SongbirdMedia.this.equalizer.usePreset((short) preset);
            SongbirdMedia.this.equalizerSettings.setup(SongbirdMedia.this.equalizer);
            SongbirdMedia.this.equalizerSettings.setPresetType(PRESET_TYPE.SYSTEM);
        }

        public void setPresetType(int presetType) throws RemoteException {
            if (SongbirdMedia.this.equalizer != null) {
                switch (presetType) {
                    case 0:
                        SongbirdMedia.this.equalizerSettings.setPresetType(PRESET_TYPE.SYSTEM);
                        return;
                    case 1:
                        SongbirdMedia.this.equalizerSettings.setPresetType(PRESET_TYPE.CUSTOM);
                        return;
                    default:
                        return;
                }
            }
        }

        public void setBandLevel(int band, int level) throws RemoteException {
            if (SongbirdMedia.this.equalizer != null) {
                SongbirdMedia.this.equalizer.setBandLevel((short) band, (short) level);
                SongbirdMedia.this.equalizerSettings.setBandLevel((short) band, (short) level);
            }
        }

        public EqualizerSettings getEQSettings() throws RemoteException {
            return SongbirdMedia.this.equalizerSettings;
        }

        public void saveEQSettings() throws RemoteException {
            SharedPreferences prefs = SongbirdMedia.this.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
            if (SongbirdMedia.this.equalizer != null) {
                Editor edit = prefs.edit();
                edit.putString(PrefKeys.sCurrentPresetSettings, SongbirdMedia.this.equalizer.getProperties().toString());
                edit.putBoolean(PrefKeys.sCurrentEQ_status, SongbirdMedia.this.equalizerSettings.isEnabled());
                edit.putString(PrefKeys.sCurrentPresetType, SongbirdMedia.this.equalizerSettings.getPresetType().name());
                edit.putInt(PrefKeys.sCurrentPresetIndex, SongbirdMedia.this.equalizerSettings.getCurrentPreset());
                edit.commit();
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        Log.i("SongbirdMediaService", "Starting up.");
        if (BaseActivity.externalPrefExists(fileList())) {
            try {
                this.extMap = new ControllerMap(new BufferedInputStream(openFileInput(PrefKeys.PREFS_EXTERNAL), FacebookAPI.FACEBOOK_AUTHORIZE_RESULT_CODE));
            } catch (Exception e) {
                e.printStackTrace();
                deleteFile(PrefKeys.PREFS_EXTERNAL);
            }
        }
        if (this.extMap == null) {
            this.extMap = new ControllerMap();
        }
        this.mMediaPlayer = new MediaPlayer();
        this.mMediaPlayer.setWakeMode(this, 1);
        setupEQ();
        this.mMetaData = new PlayerMetaData();
        this.mPlayerState = new PlayerState();
        this.mUIState = new UIState();
        this.mServicePrefs = new ServicePrefs(getApplicationContext(), this.mMetaData, this);
        this.mCallbackList = new RemoteCallbackList();
        this.mMediaScannerFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        this.mMediaScannerFilter.addDataScheme("file");
        registerReceiver(this.mMediaScannerReceiver, this.mMediaScannerFilter);
        registerReceiver(this.mHeadsetReceiver, this.mHeadsetFilter);
        this.mBluetoothFilter = new IntentFilter();
        this.mBluetoothFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        this.mBluetoothFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        this.mBluetoothFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        registerReceiver(this.mBluetoothReceiver, this.mBluetoothFilter);
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        this.mTelephonyManager = (TelephonyManager) getSystemService("phone");
        this.mStateFilter.addAction("android.intent.action.MEDIA_EJECT");
        this.mStateFilter.addDataScheme("file");
        registerReceiver(this.mStateReceiver, this.mStateFilter);
        this.mNotificationManager.cancelAll();
        this.mTelephonyManager.listen(this.mPhoneStateListener, 32);
        this.mWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "SongbirdService");
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.mInitRunnables.run();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        setBookmarkIfNeeded(this.item);
        Log.i("SongbirdMediaService", "Shutting down.");
        this.aAPIExec.shutdown();
        unregisterReceiver(this.mMediaScannerReceiver);
        unregisterReceiver(this.mHeadsetReceiver);
        unregisterReceiver(this.mBluetoothReceiver);
        this.mServicePrefs.unregisterMediaButtonReceiver();
        this.mMediaPlayer.reset();
        this.mMediaPlayer.release();
        if (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        if (this.mNotificationManager != null) {
            this.mNotificationManager.cancelAll();
        }
        this.mTelephonyManager.listen(this.mPhoneStateListener, 0);
        this.mServicePrefs.unregisterReceivers();
        saveQueue();
    }

    public IBinder onBind(Intent intent) {
        Integer num = this.mBindCount;
        this.mBindCount = Integer.valueOf(this.mBindCount.intValue() + 1);
        Log.i("SongbirdMediaService", "Bind Count: " + this.mBindCount.toString());
        if (this.mMediaServiceBinder == null) {
            this.mMediaServiceBinder = new SongbirdMediaStub();
        }
        this.mMediaService = (SongbirdMediaService) this.mMediaServiceBinder;
        return this.mMediaServiceBinder;
    }

    private void startInitial() {
        Cursor songCursor = MediaUtils.getMediaStoreMergeCursor(this, new String[]{"_id", "title_key"}, Song.getFilterSelection(), Song.getFilterArgs(), "title_key ASC");
        List<PlayableItem> playableList = Utils.createPlayableListFromCursor(songCursor);
        try {
            this.mMediaService.setCurrentList(Constants.TOP_MENU_SONGS, "");
            this.mMediaService.setShuffledPlayableList(playableList);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        songCursor.close();
    }

    private Bitmap setAlbumArt(PlayableItem aItem) {
        if (aItem.mStorageUri == null) {
            return setDefaultAlbumArt(null);
        }
        Bitmap folderBitmap = getAlbumArtFromPlayable(aItem);
        if (folderBitmap != null) {
            return folderBitmap;
        }
        Cursor albumCursor = getContentResolver().query(aItem.mStorageUri, new String[]{"album_key"}, "_id = ?", new String[]{Integer.toString(aItem.mID)}, null);
        if (albumCursor == null || !albumCursor.moveToFirst()) {
            return setDefaultAlbumArt(aItem);
        }
        int column = albumCursor.getColumnIndexOrThrow("album_key");
        String[] albumArtProj = new String[]{"album_art"};
        String[] albumArtArgs = new String[]{albumCursor.getString(column)};
        albumCursor.close();
        Cursor artCursor = getContentResolver().query(Albums.getContentUri(aItem.mStorageVolume), albumArtProj, "album_key = ?", albumArtArgs, null);
        artCursor.moveToFirst();
        if (artCursor.getCount() == 0) {
            artCursor.close();
            return setDefaultAlbumArt(aItem);
        }
        column = artCursor.getColumnIndexOrThrow("album_art");
        if (artCursor.getString(column) != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(artCursor.getString(column));
            if (bitmap != null) {
                artCursor.close();
                return bitmap;
            }
        }
        artCursor.close();
        return setDefaultAlbumArt(aItem);
    }

    private Bitmap podcastArt(PlayableItem aItem) {
        Bitmap aRet = null;
        if (aItem == null) {
            return null;
        }
        try {
            Cursor albumCursor = getContentResolver().query(aItem.mStorageUri, new String[]{"_data", "album_key"}, "_id = ?", new String[]{Integer.toString(aItem.mID)}, null);
            albumCursor.moveToFirst();
            int aCol = albumCursor.getColumnIndex("album_key");
            PodcastAlbumArtHelper ahelper = new PodcastAlbumArtHelper(getApplicationContext());
            ahelper.open();
            aRet = ahelper.getArtwork(albumCursor.getString(aCol));
            ahelper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aRet;
    }

    private Bitmap setDefaultAlbumArt(PlayableItem aItem) {
        Bitmap ret = null;
        if (this.mUIState.getBackToListActivity().equals(Constants.TOP_MENU_PODCASTS)) {
            ret = podcastArt(aItem);
        }
        return ret != null ? ret : BitmapFactory.decodeResource(getResources(), C0116R.drawable.generic_album_big);
    }

    private Bitmap getAlbumArtFromPlayable(PlayableItem aItem) {
        return Utils.getAlbumArtFromFolder(getPlayablePath(aItem), getPlayableAlbumKey(aItem));
    }

    public boolean onUnbind(Intent intent) {
        Integer num = this.mBindCount;
        this.mBindCount = Integer.valueOf(this.mBindCount.intValue() - 1);
        Log.i("SongbirdMediaService", "Bind Count: " + this.mBindCount.toString());
        return false;
    }

    private synchronized void callCallbacks(int aEvent) {
        int callbackCount = this.mCallbackList.beginBroadcast();
        for (int current = 0; current < callbackCount; current++) {
            try {
                ((IMediaEventCallback) this.mCallbackList.getBroadcastItem(current)).onMediaMessage(aEvent);
            } catch (RemoteException e) {
            }
        }
        this.mCallbackList.finishBroadcast();
    }

    private void fireNotification() {
        Context context = getApplicationContext();
        if (this.lastActivity == null) {
            this.notificationIntent = new Intent(context, Songbird.class);
        } else {
            this.notificationIntent = this.lastActivity;
        }
        this.notificationIntent.addFlags(335544320);
        this.contentIntent = PendingIntent.getActivity(context, 0, this.notificationIntent, 268435456);
        this.mNotification = new Notification();
        this.mNotification.icon = C0116R.drawable.songbird_logo;
        this.mNotification.when = 0;
        this.mNotification.setLatestEventInfo(context, "Songbird", this.mMetaData.getCurrentTitle() + " - " + this.mMetaData.getCurrentArtist(), this.contentIntent);
        Notification notification = this.mNotification;
        notification.flags |= 2;
        this.mNotificationManager.notify(1, this.mNotification);
        startForeground(1, this.mNotification);
    }

    private void nextLocation() {
        if (this.mPlayerState.getActiveList() != null && this.mPlayerState.getRepeatState() != 3) {
            if (this.mPlayerState.getListPosition() < this.mPlayerState.getActiveList().size() - 1) {
                this.mPlayerState.incrementListPosition();
            } else if (this.mPlayerState.getRepeatState() != 2) {
                this.mMetaData.setSongPosition(0);
            } else if (this.mPlayerState.isShuffleEnabled()) {
                setRandom(1, true);
            } else {
                this.mPlayerState.setListPosition(0);
            }
        }
    }

    private void next(boolean aSongFinished) {
        if (this.mPlayerState.getActiveList() != null) {
            if (aSongFinished) {
                this.mMetaData.setSongPosition(0);
            }
            setBookmarkIfNeeded(this.item);
            if (this.mPlayerState.getRepeatState() == 3) {
                try {
                    restartCurrent(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                saveQueuePosition();
                return;
            }
            if (this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.pause();
            }
            this.mMediaPlayer.reset();
            if (this.mPlayerState.getListPosition() < this.mPlayerState.getActiveList().size() - 1) {
                this.mPlayerState.incrementListPosition();
                preparePlayback(true, 1);
            } else if ((this.mPlayerState.getRepeatState() == 2 && !this.mPlayerState.isShuffleEnabled()) || (!this.mPlayerState.isShuffleEnabled() && !aSongFinished)) {
                this.mPlayerState.setListPosition(0);
                preparePlayback(true, 1);
            } else if (!(this.mPlayerState.getRepeatState() == 2 && this.mPlayerState.isShuffleEnabled()) && (!this.mPlayerState.isShuffleEnabled() || aSongFinished)) {
                if (this.mWakeLock.isHeld()) {
                    this.mWakeLock.release();
                }
                this.mMetaData.setSongPosition(0);
                preparePlayback(false, 1);
                this.mNotificationManager.cancel(1);
                this.mNotficationActive = false;
                callCallbacks(3);
                stopForeground(true);
            } else {
                setRandom(1, true);
                preparePlayback(true, 1);
            }
            if (!aSongFinished) {
                callCallbacks(32);
            }
            saveQueuePosition();
        }
    }

    private void setRandom(int aRandomState, boolean aShuffle) {
        if (aRandomState != 1 && aRandomState != 2) {
            return;
        }
        if (aRandomState == 1) {
            this.mPlayerState.setShuffleEnabled(true);
            this.mPlayerState.setListPosition(0);
            if (aShuffle) {
                this.mPlayerState.fullShuffle();
            }
        } else if (aRandomState == 2) {
            this.mPlayerState.setShuffleEnabled(false);
        }
    }

    private void processRepeatChange(int aRepeatState) {
        if (this.mPlayerState.getRepeatState() != aRepeatState) {
            if (aRepeatState == 1 || aRepeatState == 2 || aRepeatState == 3) {
                this.mPlayerState.setRepeatState(aRepeatState);
            }
        }
    }

    private void setPlayableListInternal(List<PlayableItem> aList, int aPosition, boolean aShuffle, boolean aStartPlayback, Cursor aPlaylistCursor) {
        Breadcrumbs.add(Analytics.EVENT_LIST_CHANGE);
        if (aList.size() != 0) {
            setBookmarkIfNeeded(this.item);
            if (aPlaylistCursor == null) {
                unregisterContentObserver();
            } else {
                registerContentObserver(aPlaylistCursor);
            }
            if (this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.pause();
            }
            this.mMediaPlayer.reset();
            this.mPlayerState.setPlayableList(aList);
            if (aShuffle) {
                setRandom(1, true);
            } else {
                this.mPlayerState.setListPosition(aPosition);
                this.mPlayerState.setShuffleEnabled(false);
            }
            preparePlayback(aStartPlayback, 1);
            this.mServicePrefs.firePopulate(ServicePrefs.MUSIC_APP_QUEUE_CHANGED_ACTION);
            saveQueue();
        }
    }

    private void updatePlayableList(List<PlayableItem> aList, int aPosition, Playlist aPlaylist, Cursor aPlaylistCursor) {
        if (aList.size() != 0 && aPlaylistCursor != null) {
            registerContentObserver(aPlaylistCursor);
            this.mPlaylist = aPlaylist;
            this.mPlayerState.setPlayableList(aList);
            if (this.mPlayerState.isShuffleEnabled()) {
                setRandom(1, true);
            } else if (aPosition == -1) {
                this.mPlayerState.decrementListPosition();
            } else {
                this.mPlayerState.setListPosition(aPosition);
            }
            this.mServicePrefs.firePopulate(ServicePrefs.MUSIC_APP_QUEUE_CHANGED_ACTION);
            saveQueue();
        }
    }

    private Cursor createCursorFromPlaylist(Playlist aPlaylist) {
        return MediaUtils.getMediaStoreMergeCursorForPlaylist((Context) this, new String[]{"_id", "audio_id", "play_order"}, null, null, "play_order ASC", aPlaylist.mPlaylistId.longValue());
    }

    private void registerContentObserver(Cursor aPlaylistCursor) {
        unregisterContentObserver();
        if (aPlaylistCursor != null) {
            this.mPlaylistCursor = aPlaylistCursor;
            this.mPlaylistCursor.registerContentObserver(this.mPlaylistObserver);
        }
    }

    private void unregisterContentObserver() {
        if (this.mPlaylistCursor != null) {
            this.mPlaylistCursor.unregisterContentObserver(this.mPlaylistObserver);
            this.mPlaylistCursor.close();
            this.mPlaylistCursor = null;
            this.mPlaylist = null;
        }
    }

    private void saveState() {
        Editor editor = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
        editor.putBoolean(PrefKeys.SHUFFLE_ENABLED, this.mPlayerState.isShuffleEnabled());
        editor.putInt(PrefKeys.REPEAT_MODE, this.mPlayerState.getRepeatState());
        editor.putString(PrefKeys.BACK_TO_LIST_VIEW, this.mUIState.getBackToListActivity());
        editor.putString(PrefKeys.BACK_TO_LIST_TOKEN, Base64.encodeBytes(this.mUIState.getBackToListToken().getBytes()));
        editor.commit();
    }

    private void restoreState() {
        SharedPreferences prefs = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
        this.mPlayerState.setShuffleEnabled(prefs.getBoolean(PrefKeys.SHUFFLE_ENABLED, false));
        this.mPlayerState.setRepeatState(prefs.getInt(PrefKeys.REPEAT_MODE, 1));
        this.mUIState.setBackToListActivity(prefs.getString(PrefKeys.BACK_TO_LIST_VIEW, Constants.TOP_MENU_SONGS));
        try {
            this.mUIState.setBackToListToken(new String(Base64.decode(prefs.getString(PrefKeys.BACK_TO_LIST_TOKEN, "").getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveQueue() {
    }

    private void saveQueuePosition() {
        PlayQueueDatabase pqd = new PlayQueueDatabase(this);
        pqd.updateQueuePosition(this.mPlayerState.getActiveItem(), this.mPlayerState.getListPosition(), this.mMetaData.getSongPosition());
        pqd.close();
    }

    private void restoreQueue() {
    }

    private void startPlayback() {
        this.mShouldBePlaying = true;
        if (!this.mWakeLock.isHeld()) {
            this.mWakeLock.acquire();
        }
        this.mMediaPlayer.start();
        callCallbacks(2);
        if (this.mNotification != null) {
            this.mNotificationManager.notify(1, this.mNotification);
            this.mNotficationActive = true;
        }
        this.mServicePrefs.firePopulate(ServicePrefs.MUSIC_APP_PLAYSTATE_CHANGED_ACTION);
        this.mServicePrefs.firePopulate(ServicePrefs.SCROBBLEDROID_MUSIC_STATUS_ACTION);
        Analytics.getAnalytics().queueEvent(Analytics.EVENT_PLAYBACK_INITIATED, null, null);
    }

    private void prepareMetadata(PlayableItem aItem) {
        try {
            Cursor cursor = getContentResolver().query(aItem.mStorageUri, new String[]{"_data", "artist", "title", "album", "duration", "title_key", "_id"}, "_id = ?", new String[]{Integer.toString(aItem.mID)}, null);
            cursor.moveToFirst();
            if (cursor.getCount() == 0) {
                cursor.close();
                return;
            }
            this.mMetaData.setCurrentArtist(cursor.getString(cursor.getColumnIndexOrThrow("artist")));
            this.mMetaData.setCurrentTitle(cursor.getString(cursor.getColumnIndexOrThrow("title")));
            this.mMetaData.setCurrentAlbum(cursor.getString(cursor.getColumnIndexOrThrow("album")));
            this.mMetaData.setCurrentDuration(cursor.getInt(cursor.getColumnIndexOrThrow("duration")));
            this.mMetaData.setTrackToken(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            cursor.close();
            if (this.mShouldBePlaying) {
                fireNotification();
            }
            callCallbacks(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPlayablePath(PlayableItem aItem) {
        Cursor cursor = getPlayableCursor(aItem);
        if (cursor == null) {
            return null;
        }
        int column = cursor.getColumnIndex("_data");
        if (column == -1) {
            cursor.close();
            return null;
        }
        String playablePath = cursor.getString(column);
        cursor.close();
        return playablePath;
    }

    private String getPlayableAlbumKey(PlayableItem aItem) {
        Cursor cursor = getPlayableCursor(aItem);
        if (cursor == null) {
            return null;
        }
        int column = cursor.getColumnIndex("album_key");
        if (column == -1) {
            cursor.close();
            return null;
        }
        String playablePath = cursor.getString(column);
        cursor.close();
        return playablePath;
    }

    private Cursor getPlayableCursor(PlayableItem aItem) {
        if (aItem == null || aItem.mStorageUri == null || aItem.mStorageVolume == null) {
            return null;
        }
        Cursor cursor = getContentResolver().query(aItem.mStorageUri, new String[]{"_data", "album_key"}, "_id = ?", new String[]{Integer.toString(aItem.mID)}, null);
        if (cursor == null) {
            return null;
        }
        if (cursor.moveToFirst() && cursor.getCount() != 0) {
            return cursor;
        }
        cursor.close();
        return null;
    }

    private void setBookmarkIfNeeded(PlayableItem playableItem) {
        if (playableItem != null) {
            int id = playableItem.mID;
            Uri contentUri = playableItem.mStorageUri;
            if (Podcast.isPodcast(this, id)) {
                Podcast.setBookmark(this, id, contentUri, this.mMetaData.getSongPosition() < PODCAST_BACKUP ? 0 : this.mMetaData.getSongPosition() - 1000);
            }
        }
    }

    private long getBookmarkIfNeeded(PlayableItem playableItem) {
        if (playableItem == null) {
            return 0;
        }
        int id = playableItem.mID;
        if (Podcast.isPodcast(this, id)) {
            return Podcast.getBookmark(this, id);
        }
        if (this.restorePosition == 0) {
            return 0;
        }
        int passBack = this.restorePosition;
        this.restorePosition = 0;
        return (long) passBack;
    }

    private void preparePlayback(boolean aStartPlayback, int aSkipToOnError) {
        int errorCount = 0;
        int listSize = 0;
        boolean aErrorOccured;
        do {
            aErrorOccured = false;
            try {
                this.item = new PlayableItem("<UNKNOWN>", null, -1, -1);
                this.item = this.mPlayerState.getActiveItem();
                listSize = this.mPlayerState.getActiveList().size();
                String aPath = getPlayablePath(this.item);
                if (aPath != null && this.item.mStorageUri != null) {
                    this.mMetaData.setSongPosition((int) getBookmarkIfNeeded(this.item));
                    this.mMediaPlayer.reset();
                    this.mMediaPlayer.setAudioStreamType(3);
                    this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                    this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                    this.mMediaPlayer.setDataSource(aPath);
                    this.mMediaPlayer.prepare();
                    this.mMediaPlayer.seekTo(this.mMetaData.getSongPosition());
                    this.mShouldBePlaying = aStartPlayback;
                    prepareMetadata(this.item);
                    if (aStartPlayback) {
                        this.mServicePrefs.firePopulate(ServicePrefs.MUSIC_APP_METADATA_ACTION);
                        startPlayback();
                    }
                    if (aErrorOccured) {
                        switch (aSkipToOnError) {
                            case -1:
                                Log.i(getClass().getSimpleName(), "Attempting Previous");
                                previousLocation();
                                continue;
                            case 1:
                                Log.i(getClass().getSimpleName(), "Attempting next");
                                nextLocation();
                                continue;
                            default:
                                continue;
                        }
                    }
                } else {
                    return;
                }
            } catch (Exception e) {
                errorCount++;
                if (errorCount <= listSize) {
                    e.printStackTrace();
                    aErrorOccured = true;
                } else {
                    return;
                }
            }
        } while (aErrorOccured);
    }

    private void setupEQ() {
        if (VERSION.SDK_INT >= 9) {
            try {
                this.equalizer = new Equalizer(0, this.mMediaPlayer.getAudioSessionId());
                SharedPreferences prefs = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
                boolean isOn = prefs.getBoolean(PrefKeys.sCurrentEQ_status, true);
                this.equalizerSettings.setEnabled(isOn);
                String settings = prefs.getString(PrefKeys.sCurrentPresetSettings, null);
                if (!(settings == null || this.equalizer == null)) {
                    this.equalizer.setProperties(new Settings(settings));
                }
                String presetType = prefs.getString(PrefKeys.sCurrentPresetType, null);
                PRESET_TYPE type = PRESET_TYPE.SYSTEM;
                if (presetType != null) {
                    type = PRESET_TYPE.valueOf(presetType);
                    this.equalizerSettings.setPresetType(type);
                }
                int presetIndex = prefs.getInt(PrefKeys.sCurrentPresetIndex, -1);
                if (presetIndex != -1 && type == PRESET_TYPE.SYSTEM) {
                    this.equalizer.usePreset((short) presetIndex);
                }
                this.equalizer.setEnabled(isOn);
                this.equalizerSettings.setup(this.equalizer);
            } catch (Exception e) {
                Logger.error(this, "Problems setting up Equalizer", e);
            }
        }
    }

    private void restartCurrent(boolean aStartPlayback) {
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
        this.mMediaPlayer.reset();
        preparePlayback(aStartPlayback, 1);
    }

    private void pausePlayback() {
        this.mShouldBePlaying = false;
        saveQueuePosition();
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
        this.mNotificationManager.cancel(1);
        this.mNotficationActive = false;
        stopForeground(true);
        callCallbacks(1);
        this.mServicePrefs.firePopulate(ServicePrefs.MUSIC_APP_PLAYSTATE_CHANGED_ACTION);
        this.mServicePrefs.fireNoPopulate(ServicePrefs.SCROBBLEDROID_MUSIC_STATUS_ACTION);
    }

    private void previousLocation() {
        if (this.mPlayerState.getActiveList() != null && this.mPlayerState.getRepeatState() != 3) {
            if (this.mPlayerState.getListPosition() > 0) {
                this.mPlayerState.decrementListPosition();
            } else if (this.mPlayerState.getRepeatState() != 2) {
            } else {
                if (this.mPlayerState.isShuffleEnabled()) {
                    setRandom(1, true);
                    this.mPlayerState.setListPosition(0);
                    return;
                }
                this.mPlayerState.setListPosition(this.mPlayerState.getActiveList().size() - 1);
            }
        }
    }

    private void previous() {
        if (this.mPlayerState.getActiveList() != null) {
            boolean wasPlaying = this.mMediaPlayer.isPlaying();
            if (this.mPlayerState.getRepeatState() == 3) {
                try {
                    restartCurrent(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (this.mPlayerState.getListPosition() > 0) {
                if (wasPlaying) {
                    this.mMediaPlayer.pause();
                }
                this.mMediaPlayer.reset();
                this.mPlayerState.decrementListPosition();
                try {
                    preparePlayback(true, -1);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (this.mPlayerState.getRepeatState() == 2 && !this.mPlayerState.isShuffleEnabled()) {
                this.mPlayerState.setListPosition(this.mPlayerState.getActiveList().size() - 1);
                preparePlayback(true, -1);
                saveQueuePosition();
            } else if (this.mPlayerState.getRepeatState() == 2 && this.mPlayerState.isShuffleEnabled()) {
                setRandom(1, true);
                this.mPlayerState.setListPosition(0);
                preparePlayback(true, -1);
                saveQueue();
            } else {
                if (this.mMediaPlayer.isPlaying()) {
                    pausePlayback();
                }
                restartCurrent(true);
                saveQueuePosition();
            }
        }
    }

    private void handleCommand(Intent iIntent) {
        Bundle iCommand = iIntent.getExtras();
        boolean retValue = true;
        if (iCommand != null) {
            if (iCommand.containsKey(INTENT_KEY)) {
                Intent aIntent = (Intent) iCommand.getParcelable(INTENT_KEY);
                if (aIntent.getAction().equals("android.intent.action.MEDIA_BUTTON")) {
                    this.mServicePrefs.mediaAttempt(aIntent);
                    return;
                }
            }
            String resultCallback = iCommand.getString(APIReceiver.PARAM_RESULT_ENTRY);
            Breadcrumbs.add(Analytics.EVENT_BROADCAST);
            String method = iCommand.getString(APIReceiver.METHOD_NAME);
            if (method == null) {
                method = "";
            }
            if (!method.equals(APIReceiver.PLAY)) {
                if (!method.equals(APIReceiver.PAUSE)) {
                    if (method.equals(APIReceiver.PREVIOUS)) {
                        previous();
                    } else {
                        if (method.equals(APIReceiver.NEXT)) {
                            next(false);
                        } else {
                            if (method.equals(APIReceiver.MENU_ADD)) {
                                this.extMap.processMenuAdd(iCommand.getString(APIReceiver.PARAM_MENU_ID), iCommand.getString(APIReceiver.PARAM_MENU_TEXT), (Bitmap) iCommand.getParcelable(APIReceiver.PARAM_MENU_ICON), iCommand.getString(APIReceiver.PARAM_MENU_TYPE), iCommand.getString(APIReceiver.PARAM_MENU_ACTION), (ComponentName) iCommand.getParcelable(APIReceiver.PARAM_MENU_COMPONENT), resultCallback);
                                writePreferences();
                            } else {
                                if (method.equals(APIReceiver.MENU_REMOVE)) {
                                    this.extMap.processMenuRemove(iCommand.getString(APIReceiver.PARAM_MENU_ID), resultCallback);
                                    writePreferences();
                                } else {
                                    if (method.equals(APIReceiver.MENU_REMOVE_ALL)) {
                                        this.extMap.removeMenuItems(resultCallback);
                                        writePreferences();
                                    } else {
                                        if (method.equals(APIReceiver.SETTING_ADD_CATEGORY)) {
                                            this.extMap.processSettingNewCat(iCommand.getString(APIReceiver.PARAM_CATEGORY_KEY), iCommand.getString(APIReceiver.PARAM_CATEGORY_TITLE), resultCallback);
                                            writePreferences();
                                        } else {
                                            if (method.equals(APIReceiver.SETTING_ADD_ITEM)) {
                                                retValue = this.extMap.processSettingNewItem(iCommand.getString(APIReceiver.PARAM_ITEM_ID), iCommand.getString(APIReceiver.PARAM_ITEM_HEADER), iCommand.getString(APIReceiver.PARAM_ITEM_DESC), (Bitmap) iCommand.getParcelable(APIReceiver.PARAM_ITEM_ICON), iCommand.getString(APIReceiver.PARAM_ITEM_ACTION_TYPE), iCommand.getString(APIReceiver.PARAM_ITEM_ACTION), iCommand.getString(APIReceiver.PARAM_CATEGORY_KEY), iCommand.getString(APIReceiver.PARAM_CATEGORY_TITLE), (ComponentName) iCommand.getParcelable(APIReceiver.PARAM_MENU_COMPONENT), resultCallback);
                                                writePreferences();
                                            } else {
                                                if (method.equals(APIReceiver.SETTING_REMOVE_ALL_ITEMS)) {
                                                    this.extMap.clearCustomSettings(resultCallback);
                                                    writePreferences();
                                                } else {
                                                    if (method.equals(APIReceiver.SETTING_REMOVE_CATEGORY)) {
                                                        this.extMap.removeCategory(iCommand.getString(APIReceiver.PARAM_CATEGORY_KEY), resultCallback);
                                                        writePreferences();
                                                    } else {
                                                        if (method.equals(APIReceiver.SETTING_REMOVE_ITEM)) {
                                                            this.extMap.removeSettingItem(iCommand.getString(APIReceiver.PARAM_ITEM_ID), resultCallback);
                                                            writePreferences();
                                                        } else {
                                                            if (method.equals(APIReceiver.REGISTER_CLEANUP)) {
                                                                this.extMap.addPackageCheck(iCommand.getString(APIReceiver.PARAM_CLEAN_PACKAGE), resultCallback);
                                                                writePreferences();
                                                            } else {
                                                                if (iCommand.getString("action") != null) {
                                                                    if (iCommand.getString("action").equals("android.intent.action.PACKAGE_REMOVED")) {
                                                                        this.extMap.packageDeleted(iCommand.getString(PASS_PACKAGE));
                                                                        writePreferences();
                                                                        return;
                                                                    }
                                                                }
                                                                if (method.equals(APIReceiver.METHOD_FULL_SENSOR)) {
                                                                    boolean reverseRequest = iCommand.getBoolean(APIReceiver.PARAM_FULL_ENABLED);
                                                                    Editor edit = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).edit();
                                                                    edit.putBoolean(PrefKeys.ENABLE_FULL_SENSOR, reverseRequest);
                                                                    edit.commit();
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (this.mPlayerState.getActiveList() != null) {
                    pausePlayback();
                }
            } else if (this.mPlayerState.getActiveList() != null) {
                startPlayback();
            } else {
                startInitial();
            }
        }
        callRegistered(iIntent, retValue);
    }

    private void callRegistered(Intent oIntent, boolean result) {
        if (oIntent.getExtras() != null) {
            Intent i = new Intent(oIntent.getExtras().getString(APIReceiver.PARAM_RESULT_ENTRY));
            i.putExtra(APIReceiver.RESULT, result);
            i.putExtra(APIReceiver.PARAM_RESULT_INTENT, oIntent);
            sendBroadcast(i);
        }
    }

    private void writePreferences() {
        try {
            this.extMap.writePreferences(openFileOutput(PrefKeys.PREFS_EXTERNAL, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int onStartCommand(final Intent intent, int flags, int startId) {
        if (!(intent == null || intent.getExtras() == null)) {
            this.aAPIExec.execute(new Runnable() {
                public void run() {
                    SongbirdMedia.this.handleCommand(intent);
                }
            });
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
