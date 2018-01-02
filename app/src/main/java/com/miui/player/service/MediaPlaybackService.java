package com.miui.player.service;

import android.accounts.Account;
import android.app.INotificationManagerProxy;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.storage.StorageVolume;
import android.preference.PreferenceManager;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.baidu.music.download.DownloadStatus;
import com.baidu.utils.FileUtil;
import com.google.android.collect.Lists;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions;
import com.miui.player.PlayerActions.Out;
import com.miui.player.airkan.DeviceController;
import com.miui.player.asyncplayer.AirkanPlayer;
import com.miui.player.asyncplayer.AirkanPlayer.AirkanPlayerCallback;
import com.miui.player.asyncplayer.AsyncMusicPlayer;
import com.miui.player.asyncplayer.BufferedMediaPlayer;
import com.miui.player.asyncplayer.BufferedMediaPlayer.OnBlockingChangedListener;
import com.miui.player.asyncplayer.BufferedMediaPlayer.OnBufferedPositionChangedListener;
import com.miui.player.asyncplayer.BufferedMediaPlayer.OnDownloadCompletedListener;
import com.miui.player.asyncplayer.BufferedMediaPlayer.RemoteControlInfo;
import com.miui.player.asyncplayer.BufferedMediaPlayer.ShowLinkListener;
import com.miui.player.asyncplayer.OnlinePlayDeniedException;
import com.miui.player.asyncplayer.PlayerStub;
import com.miui.player.asyncplayer.PlayerStub.AsyncPrepareListener;
import com.miui.player.asyncplayer.PlayerStub.PrepareInfo;
import com.miui.player.meta.AlbumManager;
import com.miui.player.meta.Audio;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.MediaFileManager;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ID3Correcter;
import com.miui.player.network.ID3Correcter.AsyncCorrectID3Task;
import com.miui.player.network.ImageDownloader;
import com.miui.player.network.LyricDownloader.LyricAsyncCallback;
import com.miui.player.network.MP3Downloader;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.network.StatHelper;
import com.miui.player.plugin.onlinelyric.LyricContent;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.OnlineAudioDetailHelper;
import com.miui.player.provider.PlayerProvider;
import com.miui.player.provider.PlayerProviderUtils;
import com.miui.player.provider.PlayerStore;
import com.miui.player.provider.PlayerStore.MiuiNowPlayingAudio;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Members;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.provider.StatisticsHelper;
import com.miui.player.receiver.MediaButtonIntentReceiver;
import com.miui.player.reporter.OnlineMusicReporter;
import com.miui.player.reporter.OnlinePlayStatstics;
import com.miui.player.service.IMediaPlaybackService.Stub;
import com.miui.player.ui.EqualizerActivity;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.model.AlbumListAdapter;
import com.miui.player.util.Actions;
import com.miui.player.util.FolderProvider;
import com.miui.player.util.PlaylistRecoverer;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.ServiceActions;
import com.miui.player.util.ServiceActions.In;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.StorageCache;
import com.miui.player.util.ThreadManager;
import com.miui.player.util.ThreadManager.AsyncRequestCallback;
import com.miui.player.util.Utils;
import com.miui.player.util.VolumeAlertHelper;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.cloud.AccountUtils;
import com.xiaomi.music.cloud.CloudEngine;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.MusicCloudServerException;
import com.xiaomi.music.cloud.model.PlayQueue;
import com.xiaomi.music.cloud.model.PlayStatus;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import miui.os.Environment;
import miui.provider.MusicSearchProvider.MusicMeta;
import org.json.JSONException;

public class MediaPlaybackService extends Service implements AirkanPlayerCallback {
    private static final String ACTION_TOGGLEPAUSE_UNREMOVE_NOTIFICATION = "service.togglepause.unremove_notification";
    private static final int BACKWARD_FORWARD_DELTA = 5000;
    private static final int BACKWARD_FORWARD_QUICK_DELTA = 10000;
    private static final int BACKWARD_FORWARD_QUICK_MODE_THRESHOLD = 10;
    private static final int BACKWARD_FORWARD_VALID_DURTION = 2000;
    private static final int IDLE_BACKGROUND = 1;
    private static final int IDLE_DELAY = 60000;
    private static final int IDLE_KILL_PROCESS = 2;
    private static final int INSTANT_KILL_DELAY = 1000;
    private static final int INSTANT_KILL_SIGNAL = 1;
    private static final String KEY_REPEAT_MODE = "repeatmode_bak";
    private static final String KEY_SHUFFLE_MODE = "shufflemode_bak";
    private static final int KILL_PROCESS_DELAY = 5000;
    private static final String[] LOCAL_CURSOR_COLS = new String[]{"audio._id AS _id", "artist", "album", "title", "_data", "album_id", Columns.ARTIST_ID};
    static final String LOGTAG = MediaPlaybackService.class.getName();
    private static final int LOOP_TRY_MEDIAPROVIDER = 11;
    private static final int LOOP_TRY_MOUNTED = 10;
    private static final int MIN_SONG_SIZE = 1048576;
    private static final int MSG_DOWNLOAD_ALBUM = 1;
    private static final int MSG_DOWNLOAD_LYRIC = 2;
    private static final int MSG_ID3_CHANGED = 3;
    private static final String[] ONLINE_CURSOR_COLS = new String[]{"_id", "artist", "album", "title", "_data", "mi_online_id"};
    private static final int PLAYBACKSERVICE_NOTIFICATION = 2;
    private static final int PLAYBACKSERVICE_STATUS = 1;
    private static final int RELEASE_WAKELOCK = 2;
    private static final int RELEASE_WAKELOCK_DELAY = 5000;
    private static final int SERVER_DIED = 3;
    public static final String TEMP_ALBUM_NAME = "ablum.jpg";
    private static final int TRACK_ENDED = 1;
    final int MEDIA_PROVIDER_CHANGED_DELAYED = 2000;
    final int MSG_MEDIA_PROVIDER_CHANGED = 1;
    Thread mAsynInitializeWorker = new C04176();
    AsyncCorrectID3Task mAsyncCorrectID3Task = null;
    AutoPauseManager mAudioPauseManager;
    private final IBinder mBinder = new ServiceStub(this);
    private final Bundle mCallback = new Bundle();
    int mCardId;
    private String mChannelName;
    OnCompletionListener mCompletionListener = new C04209();
    private boolean mConnectCompleted = false;
    private String mConnectedDevice = null;
    private ConnectionListener mConnectionListener;
    private Handler mDelayedStopHandler = new C04187();
    String mFileToPlay;
    private int mForwardCount;
    boolean mHasNotification = false;
    private BroadcastReceiver mIntentReceiver = new C04132();
    boolean mIsSupposedToBePlaying = false;
    AlbumRequestCallback mLastAlbumRequestCallback;
    private long mLastForwardTime;
    private boolean mLastQueueEmpty = false;
    private long mLastRewindTime;
    private LockScreenListener mLockScreenListener;
    final LyricManager mLyricManager = new LyricManager();
    Handler mMediaObserverHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                FolderProvider.markForceUpdate();
                PlaylistRecoverer.markForceRecover();
                MediaPlaybackService.this.sendBroadcast(new Intent(Actions.ACTION_MEDIA_PROVIDER_CHANGED));
            }
        }
    };
    private MediaProviderObserver mMediaProviderObserver;
    final Handler mMediaplayerHandler = new C04121();
    final Handler mMetaDownloadHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    MediaPlaybackService.this.mLastAlbumRequestCallback = null;
                    ImageSearchInfo imageInfo = msg.obj;
                    if (TextUtils.equals(imageInfo.mAlbumName, MediaPlaybackService.this.getAlbumName()) && TextUtils.equals(imageInfo.mArtistName, MediaPlaybackService.this.getArtistName())) {
                        AlbumListAdapter.removeCacheAlbum(imageInfo);
                        MediaPlaybackService.this.notifyMetaChange(Out.META_CHANGED_ALBUM, true);
                        return;
                    }
                    return;
                case 2:
                    MediaPlaybackService.this.notifyMetaChange(Out.META_CHANGED_LYRIC, true);
                    return;
                case 3:
                    if (msg.obj instanceof Uri) {
                        Uri uri = msg.obj;
                        MediaPlaybackService.this.requeryTrackInfo(uri);
                        MediaPlaybackService.this.updateMiuiDBAfterID3Changed(uri);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    int mOpenFailedCounter = 0;
    private long[] mPlayList = null;
    int mPlayListLen = 0;
    private int mPlayPos = -1;
    PlayerStub mPlayer;
    private AsyncPlayerResponser mPlayerResponser;
    boolean mQueueIsSaveable = false;
    private final BroadcastReceiver mQuitReceiver = new C04143();
    private final Random mRandom = new Random(System.currentTimeMillis());
    private RemoteControlClient mRemoteControlClient;
    int mRepeatMode = 0;
    private int mRewindCount;
    private final OnScanCompletedListener mScanCompletedListener = new C04165();
    boolean mScreenOn = false;
    private final BroadcastReceiver mScreenStatusReceiver = new C04154();
    boolean mServiceInUse = false;
    int mServiceStartId = -1;
    ShakeListener mShakeListener;
    private String mShowLink;
    private ShowLinkListener mShowLinkListener = new ShowLinkListener() {
        public void onLinkChanged(String newLink) {
            MediaPlaybackService.this.mShowLink = newLink;
            MediaPlaybackService.this.notifyChange(Out.STATUS_SHOW_LINK_CHANGED);
        }
    };
    private int mShuffleMode = 0;
    private ShuffleTracer mShuffleTracer = new ShuffleTracer(null);
    long mSleepTriggerTime = 0;
    TrackInfo mTrackInfo = new TrackInfo();
    private BroadcastReceiver mUnmountReceiver = null;
    private int mUpdateVersion = 0;
    private VolumeAlertHelper mVolumeAlertHelper;
    WakeLock mWakeLock;
    private boolean mWakeLockNeeded = true;
    private WifiLock mWifiLock;

    class C04121 extends Handler {
        C04121() {
        }

        public void handleMessage(Message msg) {
            Utils.debugLog(MediaPlaybackService.LOGTAG, "mMediaplayerHandler.handleMessage " + msg.what);
            switch (msg.what) {
                case 1:
                    if (MediaPlaybackService.this.mRepeatMode == 1 || MediaPlaybackService.this.mPlayListLen == 1) {
                        MediaPlaybackService.this.accumulateCurrent();
                        MediaPlaybackService.this.seek(0);
                        MediaPlaybackService.this.play();
                        return;
                    }
                    MediaPlaybackService.this.next(false);
                    return;
                case 2:
                    if (MediaPlaybackService.this.mWakeLock.isHeld()) {
                        Log.d(MediaPlaybackService.LOGTAG, "wakelock is released.");
                        MediaPlaybackService.this.mWakeLock.release();
                        return;
                    }
                    return;
                case 3:
                    if (MediaPlaybackService.this.mIsSupposedToBePlaying) {
                        MediaPlaybackService.this.next(true);
                        return;
                    } else {
                        MediaPlaybackService.this.openCurrent();
                        return;
                    }
                case 10:
                case 11:
                    MediaPlaybackService.this.loopCheck(this, msg.what, msg.arg1, (CheckAction) msg.obj, false);
                    return;
                default:
                    return;
            }
        }
    }

    class C04132 extends BroadcastReceiver {
        C04132() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String cmd = intent.getStringExtra(In.CMDNAME);
            Utils.debugLog(MediaPlaybackService.LOGTAG, "mIntentReceiver.onReceive action=%s, cmd=%s", action, cmd);
            if (In.CMDNEXT.equals(cmd) || PlayerActions.In.ACTION_NEXT.equals(action)) {
                MediaPlaybackService.this.next(true);
            } else if (In.CMDPREVIOUS.equals(cmd) || PlayerActions.In.ACTION_PREVIOUS.equals(action)) {
                if (MediaPlaybackService.this.getChannelName() == null) {
                    MediaPlaybackService.this.prev();
                } else {
                    MediaPlaybackService.this.seek(0);
                }
            } else if (In.CMDTOGGLEPAUSE.equals(cmd) || PlayerActions.In.ACTION_TOGGLEPAUSE.equals(action)) {
                if (MediaPlaybackService.this.isPlaying()) {
                    MediaPlaybackService.this.pause();
                } else {
                    MediaPlaybackService.this.play();
                }
            } else if (In.CMDPAUSE.equals(cmd) || In.PAUSE_ACTION.equals(action)) {
                MediaPlaybackService.this.pause();
            } else if (In.CMDPLAY.equals(cmd)) {
                MediaPlaybackService.this.play();
            } else if (In.CMDSTOP.equals(cmd)) {
                MediaPlaybackService.this.pause();
                MediaPlaybackService.this.seek(0);
            } else if (In.CMDBACKWARD.equals(cmd)) {
                MediaPlaybackService.this.backward();
            } else if (In.CMDFORWARD.equals(cmd)) {
                MediaPlaybackService.this.forward();
            } else if (In.UPDATE_META_ACTION.equals(action)) {
                if ("lyric".equals(cmd)) {
                    MediaPlaybackService.this.notifyMetaChange(Out.META_CHANGED_LYRIC, true);
                } else if ("album".equals(cmd)) {
                    MediaPlaybackService.this.notifyMetaChange(Out.META_CHANGED_ALBUM, true);
                } else if ("track".equals(cmd)) {
                    MediaPlaybackService.this.notifyMetaChange(Out.META_CHANGED_TRACK, true);
                }
            } else if (In.UPDATE_SHAKE.equals(action)) {
                MediaPlaybackService.this.mShakeListener.onUpdatePref();
            } else if (In.QUIT_ACTION.equals(action)) {
                MediaPlaybackService.this.quit();
            } else if (PlayerActions.In.ACTION_SEEK.equals(action)) {
                String onlineId = intent.getStringExtra("online_id");
                boolean valid = onlineId != null && onlineId.equals(MediaPlaybackService.this.getOnlineId());
                if (!valid) {
                    valid = intent.getLongExtra(PlayerActions.In.KEY_LOACAL_ID, -1) == MediaPlaybackService.this.getAudioId();
                }
                if (valid) {
                    long pos = intent.getLongExtra(PlayerActions.In.KEY_SEEK_POSITION, -1);
                    if (pos >= 0) {
                        MediaPlaybackService.this.seek(pos);
                    }
                }
            } else if (PlayerActions.In.ACTION_REQUEST_PREGRESS.equals(action)) {
                MediaPlaybackService.this.notifyChange(Out.STATUS_REFRESH_PROGRESS);
            } else if (PlayerActions.In.ACTION_REQUEST_LYRIC.equals(action)) {
                MediaPlaybackService.this.notifyChange(Out.ACTION_RESPONSE_LYRIC);
            }
        }
    }

    class C04143 extends BroadcastReceiver {
        C04143() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (SleepModeManager.isSleepModeEnabled() && Actions.ACTION_MUSIC_QUIT.equals(action)) {
                MediaPlaybackService.this.mSleepTriggerTime = System.currentTimeMillis();
                BufferedMediaPlayer.toggleFadeOutMode(1);
                Intent quitIntent = new Intent(In.PAUSE_ACTION);
                quitIntent.putExtra(In.CMDNAME, In.CMDPAUSE);
                context.sendBroadcast(quitIntent);
            }
        }
    }

    class C04154 extends BroadcastReceiver {
        C04154() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            MediaPlaybackService.this.mScreenOn = "android.intent.action.SCREEN_ON".equals(action);
            if (!PreferenceCache.getPrefAsBoolean(MediaPlaybackService.this.getApplication(), PreferenceCache.PREF_SHAKE_WHILE_SCREEN_ON)) {
                return;
            }
            if (!MediaPlaybackService.this.mScreenOn) {
                MediaPlaybackService.this.mShakeListener.unregister();
            } else if (MediaPlaybackService.this.isPlaying()) {
                MediaPlaybackService.this.mShakeListener.register();
            }
        }
    }

    class C04165 implements OnScanCompletedListener {
        C04165() {
        }

        public void onScanCompleted(String path, Uri uri) {
            PlayerProvider.markID3Corrected(MediaPlaybackService.this.getContentResolver(), ContentUris.parseId(uri), path);
            Message msg = MediaPlaybackService.this.mMetaDownloadHandler.obtainMessage(3);
            msg.obj = uri;
            MediaPlaybackService.this.mMetaDownloadHandler.sendMessage(msg);
        }
    }

    class C04176 extends Thread {
        C04176() {
        }

        public void run() {
            OnlineAudioDetailHelper.clean(MediaPlaybackService.this.getApplication());
            StorageCache.trim();
            MediaPlaybackService.this.mAsynInitializeWorker = null;
        }
    }

    class C04187 extends Handler {
        C04187() {
        }

        public void handleMessage(Message msg) {
            if (msg.arg1 == 1 || !(MediaPlaybackService.this.isPlaying() || MediaPlaybackService.this.mAudioPauseManager.isEffect() || MediaPlaybackService.this.mServiceInUse || MediaPlaybackService.this.mMediaplayerHandler.hasMessages(1))) {
                MediaPlaybackService.this.saveQueue(true);
                MediaPlaybackService.this.stopSelf(MediaPlaybackService.this.mServiceStartId);
                if (2 == msg.what) {
                    Process.killProcess(Process.myPid());
                }
            }
        }
    }

    class C04198 extends BroadcastReceiver {
        C04198() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            StorageVolume storage = (StorageVolume) intent.getParcelableExtra("storage_volume");
            if (storage != null) {
                MusicLog.m395d(MediaPlaybackService.LOGTAG, "action=" + action + ", storage=" + storage);
                String path = storage.getPath();
                String filePath = MediaPlaybackService.this.getAbsolutePath();
                if (filePath != null && path != null && filePath.startsWith(path)) {
                    MusicLog.m395d(MediaPlaybackService.LOGTAG, "Stop, path=" + path + ", file path=" + path);
                    if (action.equals("android.intent.action.MEDIA_EJECT")) {
                        MediaPlaybackService.this.saveQueue(true);
                        MediaPlaybackService.this.mQueueIsSaveable = false;
                        MediaPlaybackService.this.closeExternalStorageFiles(intent.getData().getPath());
                    } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                        MediaPlaybackService.this.loopCheck(MediaPlaybackService.this.mMediaplayerHandler, 10, 10, new MountCheck(), true);
                    } else if (action.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                        Utils.debugLog(MediaPlaybackService.LOGTAG, "finish scan");
                        FolderProvider.markForceUpdate();
                    }
                }
            }
        }
    }

    class C04209 implements OnCompletionListener {
        C04209() {
        }

        public void onCompletion(MediaPlayer mp) {
            if (System.currentTimeMillis() - MediaPlaybackService.this.mSleepTriggerTime > BufferedMediaPlayer.getLongFadeOutTime()) {
                MediaPlaybackService.this.position();
                MediaPlaybackService.this.duration();
                MediaPlaybackService.this.mMediaplayerHandler.sendEmptyMessage(1);
            }
        }
    }

    private static class AlbumRequestCallback extends AsyncRequestCallback<Boolean> {
        private final WeakReference<Handler> mHandlerRef;
        private final ImageSearchInfo mImageInfo;

        public AlbumRequestCallback(ImageSearchInfo imageInfo, Handler handler) {
            this.mImageInfo = imageInfo;
            this.mHandlerRef = new WeakReference(handler);
        }

        public boolean isEqual(String albumName, String artistName) {
            return TextUtils.equals(this.mImageInfo.mAlbumName, albumName) && TextUtils.equals(this.mImageInfo.mArtistName, artistName);
        }

        public void run() {
            if (getResult() != null ? ((Boolean) getResult()).booleanValue() : false) {
                Handler handler = (Handler) this.mHandlerRef.get();
                if (handler != null) {
                    handler.obtainMessage(1, this.mImageInfo).sendToTarget();
                }
            }
        }
    }

    static class AlbumSource {
        String mFilePath = null;
        Uri mUri = null;

        AlbumSource() {
        }
    }

    class AsyncPlayerResponser implements AsyncPrepareListener {
        String mCurrentBufferingPath;
        boolean mIsBuffering = false;
        boolean mPlayAfterBuffer = false;
        final RemoteControlInfo mRemoteControlInfo = new RemoteControlInfo(new Handler(), new CorrectId3AfterPlay(), new BlockChangedNotifierForWidget(), new BufferedPosChangedNotifierForWidget());

        class BlockChangedNotifierForWidget implements OnBlockingChangedListener {
            BlockChangedNotifierForWidget() {
            }

            public void onBlockingChanged(boolean isBlocking) {
                MediaPlaybackService.this.notifyChange(Out.STATUS_REFRESH_PROGRESS);
            }
        }

        class BufferedPosChangedNotifierForWidget implements OnBufferedPositionChangedListener {
            BufferedPosChangedNotifierForWidget() {
            }

            public void onBufferedPositionChanged(float bufferedPer) {
                MediaPlaybackService.this.notifyChange(Out.STATUS_REFRESH_PROGRESS);
            }
        }

        AsyncPlayerResponser() {
        }

        public void resetBufferingPath(String path) {
            this.mCurrentBufferingPath = path;
            this.mIsBuffering = true;
            this.mPlayAfterBuffer = false;
        }

        public void stopBuffering() {
            this.mIsBuffering = false;
            this.mPlayAfterBuffer = false;
        }

        private CharSequence getFailedMessage(String path, String trackName, Exception exp) {
            boolean hasName;
            if (TextUtils.isEmpty(trackName)) {
                hasName = false;
            } else {
                hasName = true;
            }
            if (exp instanceof OnlinePlayDeniedException) {
                if (!hasName) {
                    return MediaPlaybackService.this.getString(C0329R.string.playback_failed_no_title_by_network);
                }
                return String.format(MediaPlaybackService.this.getString(C0329R.string.playback_failed_by_network), new Object[]{trackName});
            } else if (!hasName) {
                return MediaPlaybackService.this.getString(C0329R.string.playback_failed_no_title_by_bad_file);
            } else {
                return String.format(MediaPlaybackService.this.getString(C0329R.string.playback_failed_by_bad_file), new Object[]{trackName});
            }
        }

        public void onPrepareFailed(String path, Object extra, Exception exception) {
            MediaPlaybackService.this.onPlayStateChanged(false, false);
            if (!(exception instanceof InterruptedException)) {
                if (!((PrepareInfo) extra).mFirst) {
                    Toast.makeText(MediaPlaybackService.this, getFailedMessage(path, ((PrepareInfo) extra).mTrackName, exception), 0).show();
                }
                boolean isBuffering = this.mIsBuffering;
                boolean playAfterBuffer = this.mPlayAfterBuffer;
                if (path.equals(this.mCurrentBufferingPath)) {
                    this.mIsBuffering = false;
                }
                if (!(exception instanceof OnlinePlayDeniedException)) {
                    MediaPlaybackService mediaPlaybackService = MediaPlaybackService.this;
                    mediaPlaybackService.mOpenFailedCounter++;
                }
                MediaPlaybackService.this.stop(true, true);
                if (isBuffering && playAfterBuffer && MediaPlaybackService.this.mOpenFailedCounter < 10 && MediaPlaybackService.this.mOpenFailedCounter < MediaPlaybackService.this.mPlayListLen && MediaPlaybackService.this.mPlayListLen > 1) {
                    MediaPlaybackService.this.next(false);
                    MediaPlaybackService.this.play();
                }
                if (!(MediaPlaybackService.this.mPlayer.isInitialized() || MediaPlaybackService.this.mOpenFailedCounter == 0)) {
                    MediaPlaybackService.this.mOpenFailedCounter = 0;
                    Log.d(MediaPlaybackService.LOGTAG, "Failed to open file for playback");
                }
                MediaPlaybackService.this.notifyMetaChange(Out.META_CHANGED_BUFFERED_OVER);
                MediaPlaybackService.this.notifyChange(Out.STATUS_PLAYSTATE_CHANGED);
            }
        }

        public void onPrepareSuccess(String path, Object extra) {
            if (MediaPlaybackService.this.mConnectedDevice != null) {
                MediaPlaybackService.this.mConnectCompleted = true;
            }
            boolean oldBufferState = this.mIsBuffering;
            if (path.equals(this.mCurrentBufferingPath)) {
                this.mIsBuffering = false;
            }
            MediaPlaybackService.this.mOpenFailedCounter = 0;
            PrepareInfo info = (PrepareInfo) extra;
            long audioId = MediaPlaybackService.this.getAudioId();
            if (info.mFirst && PreferenceCache.getPrefAsBoolean(MediaPlaybackService.this.getApplicationContext(), PreferenceCache.PREF_KEEP_QUIT_LOCATION) && !PlayerProvider.isOnlineAudio(audioId)) {
                long seekpos = PreferenceManager.getDefaultSharedPreferences(MediaPlaybackService.this.getApplication()).getLong("seekpos", 0);
                MediaPlaybackService mediaPlaybackService = MediaPlaybackService.this;
                if (seekpos < 0 || seekpos >= MediaPlaybackService.this.duration()) {
                    seekpos = 0;
                }
                mediaPlaybackService.seek(seekpos);
            }
            if (oldBufferState && this.mPlayAfterBuffer) {
                MediaPlaybackService.this.play();
            } else {
                MediaPlaybackService.this.onPlayStateChanged(false, false);
            }
            MediaPlaybackService.this.notifyMetaChange(Out.META_CHANGED_BUFFERED_OVER);
        }

        public void onSeeked(int pos) {
            MediaPlaybackService.this.notifyChange(Out.STATUS_REFRESH_PROGRESS);
        }
    }

    interface CheckAction {
        boolean handle(boolean z);
    }

    public static class CorrectId3AfterPlay implements OnDownloadCompletedListener {
        public void onDownloadCompleted(Context context, String id, String appointName, String details) {
            MP3Downloader.correctId3(context, appointName, details, true);
        }
    }

    private class LyricOpenRunnable extends LyricAsyncCallback {
        private final String rArtist;
        private final String rTitle;

        public LyricOpenRunnable(String title, String artist) {
            this.rTitle = title;
            this.rArtist = artist;
        }

        public void run() {
            if (!(this.mInfoList == null || this.mInfoList.isEmpty())) {
                LyricContent lyric = ((LyricItemInfo) this.mInfoList.get(0)).getContent();
                if (lyric != null) {
                    LyricManager.saveLyricFile(MediaPlaybackService.this, this.rTitle, this.rArtist, lyric);
                }
            }
            if (isPlayingTrack(this.rTitle, this.rArtist)) {
                MediaPlaybackService.this.mMetaDownloadHandler.sendMessage(MediaPlaybackService.this.mMetaDownloadHandler.obtainMessage(2));
            }
        }

        private boolean isPlayingTrack(String title, String artist) {
            if (TextUtils.isEmpty(title) && TextUtils.isEmpty(artist)) {
                return false;
            }
            String currentTrackName = MediaPlaybackService.this.getTrackName();
            String currentArtistName = MediaPlaybackService.this.getArtistName();
            if (title.equals(currentTrackName) && artist.equals(currentArtistName)) {
                return true;
            }
            return false;
        }

        public boolean isAutoChoose() {
            return true;
        }
    }

    class MediaProviderCheck implements CheckAction {
        MediaProviderCheck() {
        }

        public boolean handle(boolean isFirst) {
            long audioId = MediaPlaybackService.this.mPlayList[MediaPlaybackService.this.mPlayPos];
            boolean success = true;
            if (!PlayerProvider.isOnlineAudio(audioId)) {
                Cursor crsr = SqlUtils.query(MediaPlaybackService.this.getApplication(), Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_id=" + audioId, null, null);
                if (crsr == null || crsr.getCount() <= 0) {
                    success = false;
                } else {
                    success = true;
                }
                if (crsr != null) {
                    crsr.close();
                }
            }
            if (success && !isFirst) {
                MediaPlaybackService.this.reloadQueue(false);
            }
            return success;
        }
    }

    final class MediaProviderObserver extends ContentObserver {
        public MediaProviderObserver(Handler handler) {
            super(handler);
        }

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Log.d(MediaPlaybackService.LOGTAG, "media provider changed");
            MediaPlaybackService.this.mMediaObserverHandler.removeMessages(2000);
            MediaPlaybackService.this.mMediaObserverHandler.sendEmptyMessageDelayed(1, 2000);
        }
    }

    class MountCheck implements CheckAction {
        MountCheck() {
        }

        public boolean handle(boolean isFirst) {
            int cardId = MediaPlaybackService.this.getCardId();
            if ((cardId == -1 && Environment.isExternalStorageRemovable()) || (cardId == MediaPlaybackService.this.mCardId && MediaPlaybackService.this.mFileToPlay != null)) {
                return false;
            }
            MediaPlaybackService.this.mCardId = cardId;
            MediaPlaybackService.this.reloadQueue(true);
            MediaPlaybackService.this.notifyChange(Out.STATUS_QUEUE_CHANGED);
            MediaPlaybackService.this.notifyMetaChange(Out.META_CHANGED_TRACK);
            return true;
        }
    }

    static class ServiceStub extends Stub {
        WeakReference<MediaPlaybackService> mService;

        ServiceStub(MediaPlaybackService service) {
            this.mService = new WeakReference(service);
        }

        public boolean open(long[] list, int position) {
            return ((MediaPlaybackService) this.mService.get()).open(list, position);
        }

        public boolean openList(long[] list, int position, boolean forceShuffle, String channelName) {
            return ((MediaPlaybackService) this.mService.get()).openList(list, position, forceShuffle, channelName);
        }

        public int getQueuePosition() {
            return ((MediaPlaybackService) this.mService.get()).getQueuePosition();
        }

        public void setQueuePosition(int index) {
            ((MediaPlaybackService) this.mService.get()).setQueuePosition(index);
        }

        public boolean isPlaying() {
            return ((MediaPlaybackService) this.mService.get()).isPlaying();
        }

        public void stop() {
            ((MediaPlaybackService) this.mService.get()).stop();
        }

        public void pause() {
            ((MediaPlaybackService) this.mService.get()).pause();
        }

        public void play() {
            ((MediaPlaybackService) this.mService.get()).play();
        }

        public void prev() {
            ((MediaPlaybackService) this.mService.get()).prev();
        }

        public void next() {
            ((MediaPlaybackService) this.mService.get()).next(true);
        }

        public String getTrackName() {
            return ((MediaPlaybackService) this.mService.get()).getTrackName();
        }

        public String getAlbumName() {
            return ((MediaPlaybackService) this.mService.get()).getAlbumName();
        }

        public long getAlbumId() {
            return ((MediaPlaybackService) this.mService.get()).getAlbumId();
        }

        public String getArtistName() {
            return ((MediaPlaybackService) this.mService.get()).getArtistName();
        }

        public long getArtistId() {
            return ((MediaPlaybackService) this.mService.get()).getArtistId();
        }

        public void enqueue(long[] list, int action) {
            ((MediaPlaybackService) this.mService.get()).enqueue(list, action);
        }

        public long[] getQueue() {
            return ((MediaPlaybackService) this.mService.get()).getQueue();
        }

        public int getQueueSize() {
            return ((MediaPlaybackService) this.mService.get()).getQueueSize();
        }

        public void moveQueueItem(int from, int to) {
            ((MediaPlaybackService) this.mService.get()).moveQueueItem(from, to);
        }

        public String getPath() {
            return ((MediaPlaybackService) this.mService.get()).getPath();
        }

        public long getAudioId() {
            return ((MediaPlaybackService) this.mService.get()).getAudioId();
        }

        public long position() {
            return ((MediaPlaybackService) this.mService.get()).position();
        }

        public long duration() {
            return ((MediaPlaybackService) this.mService.get()).duration();
        }

        public long seek(long pos) {
            return ((MediaPlaybackService) this.mService.get()).seek(pos);
        }

        public void setShuffleMode(int shufflemode) {
            ((MediaPlaybackService) this.mService.get()).setShuffleMode(shufflemode);
        }

        public int getShuffleMode() {
            return ((MediaPlaybackService) this.mService.get()).getShuffleMode();
        }

        public int removeTracksBatch(int[] posArr) {
            return ((MediaPlaybackService) this.mService.get()).removeTracks(posArr);
        }

        public int removeTracks(int first, int last) {
            return ((MediaPlaybackService) this.mService.get()).removeTracks(first, last);
        }

        public int removeTrack(long id) {
            return ((MediaPlaybackService) this.mService.get()).removeTrack(id);
        }

        public void setRepeatMode(int repeatmode) {
            ((MediaPlaybackService) this.mService.get()).setRepeatMode(repeatmode);
        }

        public int getRepeatMode() {
            return ((MediaPlaybackService) this.mService.get()).getRepeatMode();
        }

        public int getAudioSessionId() {
            return ((MediaPlaybackService) this.mService.get()).getAudioSessionId();
        }

        public String getOnlineId() throws RemoteException {
            return ((MediaPlaybackService) this.mService.get()).getOnlineId();
        }

        public boolean isBuffering() throws RemoteException {
            return ((MediaPlaybackService) this.mService.get()).isBuffering();
        }

        public float getBufferedPercent() throws RemoteException {
            return ((MediaPlaybackService) this.mService.get()).getBufferedPercent();
        }

        public long getBufferedPosition() throws RemoteException {
            return ((MediaPlaybackService) this.mService.get()).getBufferedPosition();
        }

        public boolean isBlocking() throws RemoteException {
            return ((MediaPlaybackService) this.mService.get()).isBlocking();
        }

        public void updateEqualizerBands(int[] levels) throws RemoteException {
            ((MediaPlaybackService) this.mService.get()).updateEqualizerBands(levels);
        }

        public String getAbsolutePath() throws RemoteException {
            return ((MediaPlaybackService) this.mService.get()).getAbsolutePath();
        }

        public String getPlayingFilePath() throws RemoteException {
            return ((MediaPlaybackService) this.mService.get()).getPlayingFilePath();
        }

        public int getLyricStatus() throws RemoteException {
            return ((MediaPlaybackService) this.mService.get()).getLyricStatus();
        }

        public long getAudioIdByPos(int pos) {
            return ((MediaPlaybackService) this.mService.get()).getAudioIdByPos(pos);
        }

        public void scanFiles(String[] paths, String[] mimeTypes) {
            ((MediaPlaybackService) this.mService.get()).scanFiles(paths, mimeTypes);
        }

        public void quit(boolean enableDelay) {
            ((MediaPlaybackService) this.mService.get()).quit(enableDelay);
        }

        public int getUpdateVersion() {
            return ((MediaPlaybackService) this.mService.get()).getUpdateVersion();
        }

        public void playAll(long[] list, int position, boolean forceShuffle, int history, boolean directly, String channelName) {
            ((MediaPlaybackService) this.mService.get()).playAll(list, position, forceShuffle, history, directly, channelName);
        }

        public void addToCurrentPlaylist(long[] list, int action) {
            ((MediaPlaybackService) this.mService.get()).addToCurrentPlaylist(list, action);
        }

        public String getChannelName() {
            return ((MediaPlaybackService) this.mService.get()).getChannelName();
        }

        public void setConnectedDevice(String device) {
            ((MediaPlaybackService) this.mService.get()).setConnectedDevice(device);
        }

        public String getConnectedDevice() {
            return ((MediaPlaybackService) this.mService.get()).getConnectedDevice();
        }

        public boolean isConnectCompleted() {
            return ((MediaPlaybackService) this.mService.get()).isConnectCompleted();
        }

        public boolean adjustVolume(boolean raise) {
            return ((MediaPlaybackService) this.mService.get()).adjustVolume(raise);
        }

        public void backward() {
            ((MediaPlaybackService) this.mService.get()).backward();
        }

        public void forward() {
            ((MediaPlaybackService) this.mService.get()).forward();
        }

        public String getShowLink() {
            return ((MediaPlaybackService) this.mService.get()).getShowLink();
        }
    }

    private static class TrackInfo {
        String mAbsolutePath;
        long mAlbumId;
        String mAlbumName;
        long mArtistId;
        String mArtistName;
        long mAudioId;
        private boolean mIsValid;
        String mOnlineId;
        String mTrackName;

        private TrackInfo() {
        }

        boolean isValid() {
            return this.mIsValid;
        }

        void setAudioId(long id) {
            this.mAudioId = id;
            update();
        }

        void reset() {
            this.mIsValid = false;
            this.mAudioId = -1;
            resetData();
        }

        private void resetData() {
            this.mAlbumId = -1;
            this.mArtistId = -1;
            this.mOnlineId = null;
            this.mAbsolutePath = null;
            this.mArtistName = null;
            this.mTrackName = null;
            this.mAlbumName = null;
        }

        void update() {
            if (this.mAudioId >= 0) {
                Cursor cursor;
                resetData();
                if (PlayerProvider.isOnlineAudio(this.mAudioId)) {
                    cursor = SqlUtils.query(MusicApplication.getApplication(), MiuiNowPlayingAudio.EXTERNAL_URI, MediaPlaybackService.ONLINE_CURSOR_COLS, "_id=" + this.mAudioId, null, null);
                } else {
                    cursor = SqlUtils.query(MusicApplication.getApplication(), Media.EXTERNAL_CONTENT_URI, MediaPlaybackService.LOCAL_CURSOR_COLS, "_id=" + this.mAudioId, null, null);
                }
                if (cursor != null && cursor.moveToFirst()) {
                    this.mIsValid = true;
                    try {
                        this.mAlbumId = cursor.getLong(cursor.getColumnIndexOrThrow("album_id"));
                    } catch (Exception e) {
                    }
                    try {
                        this.mArtistId = cursor.getLong(cursor.getColumnIndexOrThrow(Columns.ARTIST_ID));
                    } catch (Exception e2) {
                    }
                    try {
                        if (!PlayerProvider.isOnlineAudio(this.mAudioId)) {
                            this.mAbsolutePath = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        }
                    } catch (Exception e3) {
                    }
                    try {
                        this.mArtistName = MetaManager.getRawName(cursor.getString(cursor.getColumnIndexOrThrow("artist")));
                    } catch (Exception e4) {
                    }
                    try {
                        this.mTrackName = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                    } catch (Exception e5) {
                    }
                    try {
                        this.mAlbumName = MetaManager.getRawName(cursor.getString(cursor.getColumnIndexOrThrow("album")));
                    } catch (Exception e6) {
                    }
                    try {
                        this.mOnlineId = cursor.getString(cursor.getColumnIndexOrThrow("mi_online_id"));
                    } catch (Exception e7) {
                    }
                    cursor.close();
                }
            }
        }
    }

    private boolean makeAllShuffleList() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0081 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r12 = this;
        r11 = 1;
        r10 = 0;
        r0 = r12.getContentResolver();
        r6 = 0;
        r1 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r2 = 1;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r2 = new java.lang.String[r2];	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r3 = 0;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r4 = "_id";	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r2[r3] = r4;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r3 = com.miui.player.util.SqlUtils.wrapWithBlacklist(r12);	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r4 = 0;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r5 = "title";	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r6 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        if (r6 != 0) goto L_0x0030;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
    L_0x001e:
        r1 = 2131296380; // 0x7f09007c float:1.8210675E38 double:1.0530003225E-314;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r2 = 0;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1 = android.widget.Toast.makeText(r12, r1, r2);	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1.show();	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        if (r6 == 0) goto L_0x002e;
    L_0x002b:
        r6.close();
    L_0x002e:
        r1 = r10;
    L_0x002f:
        return r1;
    L_0x0030:
        r1 = r6.getCount();	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        if (r1 != 0) goto L_0x0048;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
    L_0x0036:
        r1 = 2131296384; // 0x7f090080 float:1.8210683E38 double:1.0530003244E-314;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r2 = 0;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1 = android.widget.Toast.makeText(r12, r1, r2);	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1.show();	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        if (r6 == 0) goto L_0x0046;
    L_0x0043:
        r6.close();
    L_0x0046:
        r1 = r10;
        goto L_0x002f;
    L_0x0048:
        r8 = r6.getCount();	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r9 = new long[r8];	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r7 = 0;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
    L_0x004f:
        if (r7 >= r8) goto L_0x005e;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
    L_0x0051:
        r6.moveToNext();	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1 = 0;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1 = r6.getLong(r1);	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r9[r7] = r1;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r7 = r7 + 1;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        goto L_0x004f;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
    L_0x005e:
        r1 = 0;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r12.mChannelName = r1;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1 = -1;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r12.open(r9, r1);	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1 = 1;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r12.setShuffleMode(r1);	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r1 = 0;	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        r12.play(r1);	 Catch:{ RuntimeException -> 0x007b, all -> 0x0074 }
        if (r6 == 0) goto L_0x0072;
    L_0x006f:
        r6.close();
    L_0x0072:
        r1 = r11;
        goto L_0x002f;
    L_0x0074:
        r1 = move-exception;
        if (r6 == 0) goto L_0x007a;
    L_0x0077:
        r6.close();
    L_0x007a:
        throw r1;
    L_0x007b:
        r1 = move-exception;
        if (r6 == 0) goto L_0x0081;
    L_0x007e:
        r6.close();
    L_0x0081:
        r1 = r10;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.service.MediaPlaybackService.makeAllShuffleList():boolean");
    }

    public synchronized void scanFiles(String[] paths, String[] mimeTypes) {
        MediaScannerConnection.scanFile(this, paths, mimeTypes, this.mScanCompletedListener);
    }

    void requeryTrackInfo(Uri uri) {
        synchronized (this) {
            if (this.mTrackInfo.isValid() && uri != null && this.mFileToPlay != null && this.mFileToPlay.equals(uri.toString())) {
                this.mTrackInfo.update();
                this.mLyricManager.reset();
                notifyMetaChange(Out.META_CHANGED_TRACK, false, true);
                if (this.mHasNotification) {
                    updateNotificationBar();
                }
            }
        }
    }

    void updateMiuiDBAfterID3Changed(Uri uri) {
        Cursor c = SqlUtils.query(this, uri, new String[]{"_id", "title", "artist", "album"}, null, null, null, 1);
        if (c != null) {
            try {
                if (c.moveToFirst()) {
                    String where = "audio_id=" + c.getLong(c.getColumnIndex("_id"));
                    String trackName = c.getString(c.getColumnIndex("title"));
                    String artistName = c.getString(c.getColumnIndex("artist"));
                    String albumName = c.getString(c.getColumnIndex("album"));
                    ContentValues values = new ContentValues();
                    values.put("album", albumName);
                    values.put("artist", artistName);
                    values.put("title", trackName);
                    getContentResolver().update(MiuiPlaylistsAudioMap.EXTERNAL_URI, values, where, null);
                }
                c.close();
            } catch (Throwable th) {
                c.close();
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        MusicLog.m395d(LOGTAG, "create service");
        this.mVolumeAlertHelper = new VolumeAlertHelper(this);
        this.mVolumeAlertHelper.registerReceiver();
        ServiceHelper.registerMediaButtonReceiver(this);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        ComponentName rec = new ComponentName(getPackageName(), MediaButtonIntentReceiver.class.getName());
        Intent i = new Intent("android.intent.action.MEDIA_BUTTON");
        i.setComponent(rec);
        this.mRemoteControlClient = new RemoteControlClient(PendingIntent.getBroadcast(this, 0, i, 0));
        audioManager.registerRemoteControlClient(this.mRemoteControlClient);
        this.mRemoteControlClient.setTransportControlFlags(DownloadStatus.STATUS_UNDOWNLOADED);
        this.mShakeListener = new ShakeListener(this, this);
        this.mAudioPauseManager = new AutoPauseManager(this, this);
        this.mAudioPauseManager.register();
        PowerManager pm = (PowerManager) getSystemService("power");
        this.mWakeLock = pm.newWakeLock(1, getClass().getName());
        this.mWakeLock.setReferenceCounted(false);
        this.mScreenOn = pm.isScreenOn();
        IntentFilter screenFilter = new IntentFilter();
        screenFilter.addAction("android.intent.action.SCREEN_ON");
        screenFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.mScreenStatusReceiver, screenFilter);
        this.mWifiLock = ((WifiManager) getSystemService("wifi")).createWifiLock(getClass().getName());
        this.mWifiLock.setReferenceCounted(false);
        this.mWifiLock.acquire();
        this.mCardId = getCardId();
        registerExternalStorageListener();
        this.mPlayerResponser = new AsyncPlayerResponser();
        this.mPlayer = new AsyncMusicPlayer(null, this.mPlayerResponser, this.mPlayerResponser.mRemoteControlInfo);
        if (this.mPlayer instanceof AsyncMusicPlayer) {
            ((AsyncMusicPlayer) this.mPlayer).setShowLinkLister(this.mShowLinkListener);
        }
        if (EqualizerActivity.isEqualizerEnabled(this)) {
            int equalizerConf = EqualizerActivity.getEqualizerConfigId(this);
            if (equalizerConf != -1) {
                updateEqualizerBands(PlayerProviderUtils.getEqualizerConfigData(this, equalizerConf));
            }
        }
        reloadQueue(true);
        IntentFilter commandFilter = new IntentFilter();
        commandFilter.addAction(In.SERVICECMD);
        commandFilter.addAction(PlayerActions.In.ACTION_TOGGLEPAUSE);
        commandFilter.addAction(In.PAUSE_ACTION);
        commandFilter.addAction(PlayerActions.In.ACTION_NEXT);
        commandFilter.addAction(PlayerActions.In.ACTION_PREVIOUS);
        commandFilter.addAction(In.UPDATE_META_ACTION);
        commandFilter.addAction(In.UPDATE_SHAKE);
        commandFilter.addAction(In.QUIT_ACTION);
        commandFilter.addAction(PlayerActions.In.ACTION_SEEK);
        commandFilter.addAction(PlayerActions.In.ACTION_REQUEST_PREGRESS);
        commandFilter.addAction(PlayerActions.In.ACTION_REQUEST_LYRIC);
        registerReceiver(this.mIntentReceiver, commandFilter);
        IntentFilter quitFilter = new IntentFilter();
        quitFilter.addAction(Actions.ACTION_MUSIC_QUIT);
        registerReceiver(this.mQuitReceiver, quitFilter);
        IntentFilter id3ChangedFilter = new IntentFilter();
        id3ChangedFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        id3ChangedFilter.addDataScheme("file");
        this.mLockScreenListener = new LockScreenListener();
        this.mLockScreenListener.registerScreenlock(this);
        this.mConnectionListener = new ConnectionListener();
        this.mConnectionListener.registerConnReceiver(this);
        this.mDelayedStopHandler.sendMessageDelayed(this.mDelayedStopHandler.obtainMessage(), 60000);
        this.mMediaProviderObserver = new MediaProviderObserver(new Handler());
        getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, this.mMediaProviderObserver);
        OnlineMusicReporter.postUserStart(this);
        if (this.mAsynInitializeWorker != null) {
            this.mAsynInitializeWorker.start();
        }
    }

    public void onDestroy() {
        onPlayStateChanged(false, false);
        ((AudioManager) getSystemService("audio")).unregisterRemoteControlClient(this.mRemoteControlClient);
        ServiceHelper.unregisterMediaButtonReceiver(this);
        this.mAudioPauseManager.unregister();
        if (isPlaying()) {
            Log.e(LOGTAG, "Service being destroyed while still playing.");
        }
        this.mPlayer.stop(true, true);
        this.mDelayedStopHandler.removeCallbacksAndMessages(null);
        this.mMediaplayerHandler.removeCallbacksAndMessages(null);
        unregisterReceiver(this.mIntentReceiver);
        unregisterReceiver(this.mQuitReceiver);
        this.mLockScreenListener.unregisterScreenlock();
        this.mConnectionListener.unregisterConnReceiver();
        if (this.mUnmountReceiver != null) {
            unregisterReceiver(this.mUnmountReceiver);
            this.mUnmountReceiver = null;
        }
        this.mShakeListener.release();
        unregisterReceiver(this.mScreenStatusReceiver);
        this.mWifiLock.release();
        if (this.mWakeLock.isHeld()) {
            Log.d(LOGTAG, " wakelock release  " + System.currentTimeMillis());
            this.mWakeLock.release();
        }
        this.mPlayer.release();
        getContentResolver().unregisterContentObserver(this.mMediaProviderObserver);
        synchronized (this) {
            this.mTrackInfo.reset();
        }
        this.mVolumeAlertHelper.unregisterReceiver();
        super.onDestroy();
    }

    void saveQueue(boolean full) {
        if (this.mQueueIsSaveable) {
            Editor ed = PreferenceManager.getDefaultSharedPreferences(this).edit();
            if (full) {
                HistoryManager.save(ed, 0, this.mPlayList, this.mPlayListLen);
                ed.putInt("cardid", this.mCardId);
                uploadPlayQueueAsync();
            }
            if (this.mShuffleMode == 1 && this.mPlayListLen > 0) {
                this.mShuffleTracer.save(ed, this.mPlayListLen, this.mPlayPos, full);
            }
            HistoryManager.savePosition(ed, 0, getAudioId(), this.mPlayPos);
            if (this.mPlayer.isPrepared()) {
                ed.putLong("seekpos", position());
                uploadPlayStatusAsync();
            }
            ed.putInt("repeatmode", this.mRepeatMode);
            ed.putInt("shufflemode", this.mShuffleMode);
            ed.putString("channel_name", this.mChannelName);
            ed.apply();
        }
    }

    void reloadQueue(boolean loopCheck) {
        if (!this.mPlayer.isInitialized()) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            this.mChannelName = sp.getString("channel_name", null);
            int id = this.mCardId;
            if (sp.contains("cardid")) {
                id = sp.getInt("cardid", this.mCardId ^ -1);
            }
            if (id == this.mCardId) {
                this.mPlayList = HistoryManager.load(sp, 0);
                this.mPlayListLen = this.mPlayList.length;
                int pos = HistoryManager.loadPostion(sp, 0);
                if (pos < 0 || pos >= this.mPlayListLen) {
                    this.mPlayListLen = 0;
                    return;
                }
                this.mPlayPos = pos;
                this.mRepeatMode = sp.getInt("repeatmode", 2);
                this.mShuffleMode = sp.getInt("shufflemode", 0);
                if (this.mShuffleMode == 1) {
                    this.mShuffleTracer.load(sp, this.mPlayListLen);
                }
                if (loopCheck) {
                    loopCheck(this.mMediaplayerHandler, 11, 10, new MediaProviderCheck(), false);
                }
            }
            if (!this.mPlayer.isInitialized()) {
                this.mOpenFailedCounter = 20;
                openCurrent(true);
                if (this.mPlayer.isInitialized()) {
                    notifyMetaChange(Out.META_CHANGED_TRACK);
                    return;
                }
                Log.d(LOGTAG, "player initialize failed!");
                this.mPlayListLen = 0;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        this.mDelayedStopHandler.removeCallbacksAndMessages(null);
        this.mServiceInUse = true;
        return this.mBinder;
    }

    public void onRebind(Intent intent) {
        this.mDelayedStopHandler.removeCallbacksAndMessages(null);
        this.mServiceInUse = true;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        MusicLog.m395d(LOGTAG, "start service, intent=" + intent + ", flags=" + flags + ", start id=" + startId);
        this.mServiceStartId = startId;
        this.mDelayedStopHandler.removeCallbacksAndMessages(null);
        if (intent != null) {
            String action = intent.getAction();
            String cmd = intent.getStringExtra(In.CMDNAME);
            Utils.debugLog(LOGTAG, "onStartCommand=%s, cmd=%s", action, cmd);
            if (In.CMDNEXT.equals(cmd) || PlayerActions.In.ACTION_NEXT.equals(action)) {
                next(true);
            } else if (In.CMDPREVIOUS.equals(cmd) || PlayerActions.In.ACTION_PREVIOUS.equals(action)) {
                if (getChannelName() == null) {
                    prev();
                } else {
                    seek(0);
                }
            } else if (In.CMDTOGGLEPAUSE.equals(cmd) || PlayerActions.In.ACTION_TOGGLEPAUSE.equals(action) || ACTION_TOGGLEPAUSE_UNREMOVE_NOTIFICATION.equals(action)) {
                if (isPlaying()) {
                    pause(!ACTION_TOGGLEPAUSE_UNREMOVE_NOTIFICATION.equals(action));
                } else {
                    play();
                }
            } else if (In.CMDPAUSE.equals(cmd) || In.PAUSE_ACTION.equals(action)) {
                pause();
            } else if (In.CMDPLAY.equals(cmd)) {
                play();
            } else if (In.CMDREPLAY.equals(cmd)) {
                stop(false, true);
                openCurrent();
                play();
            } else if (In.CMDSTOP.equals(cmd)) {
                pause();
                seek(0);
            } else if (In.CMDBACKWARD.equals(cmd)) {
                backward();
            } else if (In.CMDFORWARD.equals(cmd)) {
                forward();
            } else if (PlayerActions.In.ACTION_REQUEST_PREGRESS.equals(action)) {
                notifyChange(Out.STATUS_REFRESH_PROGRESS);
            } else if (PlayerActions.In.ACTION_REQUEST_LYRIC.equals(action)) {
                notifyChange(Out.ACTION_RESPONSE_LYRIC);
            } else if (PlayerActions.In.ACTION_TOGGLEFAVORITE.equals(action)) {
                audioId = getAudioId();
                long plid = FavoriteCache.getFavoritePlaylistId(this);
                if (audioId >= 0) {
                    if (!FavoriteCache.contains(this, audioId, getOnlineId())) {
                        PlaylistHelper.addToPlaylist(this, new long[]{audioId}, plid, true);
                    } else if (getOnlineId() != null) {
                        PlaylistHelper.removeOnlineMembers(this, Arrays.asList(new String[]{getOnlineId()}), OnlineMusicProxy.getProviderName(this), plid);
                    } else {
                        PlaylistHelper.removeMembers(this, new long[]{audioId}, plid);
                    }
                }
            } else if (In.ACTION_REQUEST_FAVORITE.equals(action)) {
                notifyChange(ServiceActions.Out.ACTION_RESPONSE_FAVORITE);
            } else if (PlayerActions.In.ACTION_REQUEST_STATUS.equals(action)) {
                notifyMetaChange(Out.META_CHANGED_TRACK, true);
            } else if (In.UPDATE_META_ACTION.equals(action)) {
                if ("lyric".equals(cmd)) {
                    notifyMetaChange(Out.META_CHANGED_LYRIC, true);
                } else if ("album".equals(cmd)) {
                    notifyMetaChange(Out.META_CHANGED_ALBUM, true);
                } else if ("track".equals(cmd)) {
                    notifyMetaChange(Out.META_CHANGED_TRACK, true);
                }
            } else if (In.UPDATE_SHAKE.equals(action)) {
                this.mShakeListener.onUpdatePref();
            } else if (In.QUIT_ACTION.equals(action)) {
                quit();
            } else if (PlayerActions.In.ACTION_MUSIC_META.equals(action)) {
                String name = intent.getStringExtra(PlayerActions.In.KEY_CALLBACK_NAME);
                Bundle value = intent.getBundleExtra(PlayerActions.In.KEY_CALLBACK_DATA);
                if (!(name == null || value == null)) {
                    this.mCallback.putBundle(name, value);
                }
                Object raw = intent.getParcelableArrayExtra(PlayerActions.In.KEY_MUSIC_META_ARRAY);
                if (raw != null) {
                    Object data = new MusicMeta[raw.length];
                    System.arraycopy(raw, 0, data, 0, raw.length);
                    playAll(data, intent.getIntExtra(PlayerActions.In.KEY_MUSIC_META_POSITION, 0), intent.getBooleanExtra("music_meta_append", false));
                }
            } else if (PlayerActions.In.ACTION_REMOVE.equals(action)) {
                long removeId = intent.getLongExtra(PlayerActions.In.KEY_REMOVE_ID, -1);
                if (removeId < 0) {
                    removeId = getAudioId();
                }
                if (removeId >= 0) {
                    removeTrack(removeId);
                }
            } else if (In.UPDATE_ID3_STATE.equals(action)) {
                String path = intent.getStringExtra(In.TRACKPATH);
                if (!TextUtils.isEmpty(path)) {
                    String mimeType = MediaFileManager.getMIMEType(new File(path));
                    scanFiles(new String[]{path}, new String[]{mimeType});
                }
            } else if (In.ACTION_OPEN_LIST.equals(action)) {
                Collection<Audio> audioList = (ArrayList) intent.getSerializableExtra("audio_list");
                String provider = intent.getStringExtra(In.KEY_PROVIDER);
                int position = intent.getIntExtra("position", 0);
                boolean append = intent.getBooleanExtra("music_meta_append", false);
                boolean forceShuffle = intent.getBooleanExtra(In.KEY_FORCE_SHUFFLE, false);
                String channelName = intent.getStringExtra("channel_name");
                long[] queue = getQueue();
                int pos = getQueuePosition();
                audioId = getAudioId();
                if (append) {
                    List<String> existOnlineIdlist = PlaylistHelper.getExistOnlineIdList(this, Members.getMembersUri(0));
                    if (existOnlineIdlist != null) {
                        audioList = PlaylistHelper.getDifferenceAudioList(audioList, existOnlineIdlist);
                    }
                    if (audioList.isEmpty()) {
                        Toast.makeText(this, getResources().getQuantityString(C0329R.plurals.NNNtrackstoplaylist, 0, new Object[]{Integer.valueOf(0)}), 0).show();
                        return 2;
                    }
                    addToCurrentPlaylist(PlayerProviderUtils.updateNowplayingList(this, audioList, provider, append), 3);
                } else {
                    if (getChannelName() == null) {
                        HistoryManager.moveNowplayingOnlineToHistory(this);
                    }
                    if (openList(PlayerProviderUtils.updateNowplayingList(this, audioList, provider, append), position, forceShuffle, channelName)) {
                        HistoryManager.shift(this, queue, pos, audioId, PreferenceManager.getDefaultSharedPreferences(this), HistoryManager.LAST_HISTORY_SIZE);
                    }
                    play();
                }
                if (!(append || getPath() == null)) {
                    Intent activityIntent = new Intent("com.miui.player.NOWPLAYING_PLAYLIST").setFlags(67108864);
                    activityIntent.setFlags(268435456);
                    startActivity(activityIntent);
                }
            }
        }
        this.mDelayedStopHandler.removeCallbacksAndMessages(null);
        this.mDelayedStopHandler.sendMessageDelayed(this.mDelayedStopHandler.obtainMessage(), 60000);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        this.mServiceInUse = false;
        saveQueue(true);
        if (!(isPlaying() || this.mAudioPauseManager.isEffect())) {
            if (this.mPlayListLen > 0 || this.mMediaplayerHandler.hasMessages(1)) {
                this.mDelayedStopHandler.sendMessageDelayed(this.mDelayedStopHandler.obtainMessage(), 60000);
            } else {
                stopSelf(this.mServiceStartId);
            }
        }
        return true;
    }

    public void closeExternalStorageFiles(String storagePath) {
        stop(true, true);
        notifyChange(Out.STATUS_QUEUE_CHANGED);
        notifyMetaChange(Out.META_CHANGED_TRACK);
    }

    public int getCardId() {
        Cursor c = getContentResolver().query(Uri.parse("content://media/external/fs_id"), null, null, null, null);
        int id = -1;
        if (c != null) {
            if (c.moveToFirst()) {
                id = c.getInt(0);
            }
            c.close();
        }
        return id;
    }

    public void registerExternalStorageListener() {
        if (this.mUnmountReceiver == null) {
            this.mUnmountReceiver = new C04198();
            IntentFilter iFilter = new IntentFilter();
            iFilter.addAction("android.intent.action.MEDIA_EJECT");
            iFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            iFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            iFilter.addDataScheme("file");
            registerReceiver(this.mUnmountReceiver, iFilter);
        }
    }

    void loopCheck(Handler handler, int what, int count, CheckAction action, boolean isFist) {
        handler.removeMessages(what);
        Log.i(LOGTAG, "loop checking: what=" + what + " times=" + count);
        if (action.handle(isFist)) {
            Log.i(LOGTAG, "loop check success: what=" + what);
            return;
        }
        count--;
        if (count > 0) {
            handler.sendMessageDelayed(handler.obtainMessage(what, count, 0, action), 1000);
        }
    }

    private void autoCorrecterID3(String trackPath, long audioId) {
        if (this.mAsyncCorrectID3Task == null || !this.mAsyncCorrectID3Task.isFirstTrackPathEquals(trackPath)) {
            Context context = getApplicationContext();
            if (PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_AUTO_CORRECT_ID3) && Utils.isSupportID3(trackPath) && !StatisticsHelper.queryIsCorrectedID3(context, audioId) && ID3Correcter.isNetworkActive(context, false)) {
                if (this.mAsyncCorrectID3Task != null) {
                    this.mAsyncCorrectID3Task.cancel(true);
                }
                this.mAsyncCorrectID3Task = new AsyncCorrectID3Task(context, new String[]{trackPath}, new long[]{audioId}, false, false);
                this.mAsyncCorrectID3Task.execute(new Void[0]);
            }
        }
    }

    private void notifyChange(String what, String extra, boolean reset, boolean isID3Changed) {
        if (Out.STATUS_META_CHANGED.equals(what)) {
            this.mUpdateVersion++;
        }
        String artistName = getArtistName();
        String albumName = getAlbumName();
        String trackName = getTrackName();
        String onlineId = getOnlineId();
        if (Out.STATUS_META_CHANGED.equals(what) && Out.META_CHANGED_TRACK.equals(extra)) {
            autoCorrecterID3(getAbsolutePath(), getAudioId());
        }
        String filePath = null;
        Uri uri = null;
        boolean needAlbum = Out.META_CHANGED_ALBUM.equals(extra) || Out.META_CHANGED_TRACK.equals(extra);
        if (needAlbum) {
            AlbumSource info = updateAlbum(trackName, albumName, artistName);
            filePath = info.mFilePath;
            uri = info.mUri;
        }
        ArrayList<CharSequence> lyricStrList = null;
        int[] timeArr = null;
        boolean requestLyricIntent = Out.ACTION_RESPONSE_LYRIC.equals(what);
        boolean needLyric = requestLyricIntent || Out.META_CHANGED_LYRIC.equals(extra) || Out.META_CHANGED_TRACK.equals(extra);
        boolean needLyricStatus = needLyric || Out.META_CHANGED_BUFFERED_OVER.equals(extra);
        if (needLyricStatus) {
            LyricManager lyricManager = this.mLyricManager;
            LyricAsyncCallback lyricOpenRunnable = new LyricOpenRunnable(trackName, artistName);
            boolean z = reset || requestLyricIntent;
            if (lyricManager.updateLyricStatus(this, lyricOpenRunnable, needLyric, trackName, albumName, artistName, z)) {
                lyricStrList = this.mLyricManager.getStringArr();
                timeArr = this.mLyricManager.getTimeArr();
                this.mLyricManager.recycleContent();
            }
        }
        if (Out.META_CHANGED_TRACK.equals(extra)) {
            StatHelper.uploadPlayTrack(trackName, artistName, albumName);
        }
        Intent intent = new Intent(what);
        intent.putExtra(Out.KEY_ID, Long.valueOf(getAudioId()));
        intent.putExtra("online_id", onlineId);
        intent.putExtra("artist", artistName);
        intent.putExtra("album", albumName);
        intent.putExtra("track", trackName);
        intent.putExtra(Out.KEY_TRACK_PATH, getAbsolutePath());
        intent.putExtra(Out.KEY_ALBUM_URI, uri);
        intent.putExtra(Out.KEY_ALBUM_PATH, filePath);
        intent.putExtra(Out.KEY_LYRIC_STATUS, this.mLyricManager.status());
        intent.putExtra("lyric", lyricStrList);
        intent.putExtra(Out.KEY_LYRIC_TIME, timeArr);
        intent.putExtra(Out.KEY_PLAYING, isPlaying());
        intent.putExtra(Out.KEY_BLOCKING, isBlocking());
        intent.putExtra("position", position());
        intent.putExtra("duration", duration());
        intent.putExtra(Out.KEY_BUFFERING, isBuffering());
        intent.putExtra(Out.KEY_BUFFERED_POS, getBufferedPosition());
        intent.putExtra("time_stamp", System.currentTimeMillis());
        intent.putExtra("favorite", FavoriteCache.contains(this, getAudioId(), onlineId));
        intent.putExtra(Out.KEY_UPDATE_VERSION, this.mUpdateVersion);
        intent.putExtra("channel_name", this.mChannelName);
        intent.putExtra(Out.KEY_CALLBACK_WRAP, this.mCallback);
        intent.putExtra(ServiceActions.Out.KEY_CHANGED_ID3, isID3Changed);
        if (extra != null) {
            intent.putExtra(Out.KEY_OTHER, extra);
        }
        sendBroadcast(intent);
        if (Out.STATUS_QUEUE_CHANGED.equals(what)) {
            saveQueue(true);
        } else if (Out.STATUS_PLAYBACK_COMPLETE.equals(what) || Out.STATUS_META_CHANGED.equals(what) || Out.STATUS_PLAYSTATE_CHANGED.equals(what)) {
            saveQueue(false);
        }
        if (what.equals(Out.STATUS_PLAYSTATE_CHANGED)) {
            int i;
            RemoteControlClient remoteControlClient = this.mRemoteControlClient;
            if (isPlaying()) {
                i = 3;
            } else {
                i = 2;
            }
            remoteControlClient.setPlaybackState(i);
            return;
        }
        if (what.equals(Out.STATUS_META_CHANGED)) {
            MetadataEditor ed = this.mRemoteControlClient.editMetadata(true);
            ed.putString(7, getTrackName());
            ed.putString(1, getAlbumName());
            ed.putString(13, getArtistName());
            ed.putLong(9, duration());
            ed.putLong(0, (long) this.mPlayPos);
            try {
                ed.putLong(10, (long) this.mPlayListLen);
            } catch (IllegalArgumentException e) {
                MusicLog.m397e(LOGTAG, "METADATA_KEY_NUM_TRACKS: failed: " + e);
            }
            AlbumSource albumSource = updateAlbum(getTrackName(), getAlbumName(), getArtistName());
            Drawable drawable = getResources().getDrawable(C0329R.drawable.widget_album_mask);
            int w = drawable.getIntrinsicWidth();
            int h = drawable.getIntrinsicHeight();
            Bitmap b = null;
            if (albumSource.mUri != null) {
                b = AlbumManager.getBitmapFromUri(this, albumSource.mUri, w, h);
            } else if (!TextUtils.isEmpty(albumSource.mFilePath)) {
                b = AlbumManager.getBitmapFromFile(albumSource.mFilePath, w, h);
            }
            if (b != null) {
                ed.putBitmap(100, b);
            }
            ed.apply();
        }
    }

    private void notifyChange(String what, String extra, boolean reset) {
        notifyChange(what, extra, reset, false);
    }

    void notifyMetaChange(String subType, boolean reset) {
        notifyChange(Out.STATUS_META_CHANGED, subType, reset);
    }

    void notifyMetaChange(String subType, boolean reset, boolean isID3Changed) {
        notifyChange(Out.STATUS_META_CHANGED, subType, reset, isID3Changed);
    }

    void notifyMetaChange(String subType) {
        notifyChange(Out.STATUS_META_CHANGED, subType, false);
    }

    void notifyChange(String what) {
        notifyChange(what, null, false);
    }

    private void ensurePlayListCapacity(int size) {
        if (this.mPlayList == null || size > this.mPlayList.length) {
            long[] newlist = new long[(size * 2)];
            int len = this.mPlayList != null ? this.mPlayList.length : this.mPlayListLen;
            for (int i = 0; i < len; i++) {
                newlist[i] = this.mPlayList[i];
            }
            this.mPlayList = newlist;
        }
    }

    private void addToPlayList(long[] list, int position) {
        int i;
        int addlen = list.length;
        if (position < 0) {
            this.mPlayListLen = 0;
            position = 0;
        }
        ensurePlayListCapacity(this.mPlayListLen + addlen);
        if (position > this.mPlayListLen) {
            position = this.mPlayListLen;
        }
        for (i = this.mPlayListLen - position; i > 0; i--) {
            this.mPlayList[position + i] = this.mPlayList[(position + i) - addlen];
        }
        for (i = 0; i < addlen; i++) {
            this.mPlayList[position + i] = list[i];
        }
        this.mPlayListLen += addlen;
        if (this.mPlayListLen == 0 && this.mTrackInfo.isValid()) {
            this.mTrackInfo.reset();
            notifyMetaChange(Out.META_CHANGED_TRACK);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enqueue(long[] r3, int r4) {
        /*
        r2 = this;
        if (r3 == 0) goto L_0x0005;
    L_0x0002:
        r0 = r3.length;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        monitor-enter(r2);
        r0 = 2;
        if (r4 != r0) goto L_0x0035;
    L_0x000a:
        r0 = r2.mPlayPos;	 Catch:{ all -> 0x0032 }
        r0 = r0 + 1;
        r1 = r2.mPlayListLen;	 Catch:{ all -> 0x0032 }
        if (r0 >= r1) goto L_0x0035;
    L_0x0012:
        r0 = r2.mPlayPos;	 Catch:{ all -> 0x0032 }
        r0 = r0 + 1;
        r2.addToPlayList(r3, r0);	 Catch:{ all -> 0x0032 }
        r0 = "com.miui.player.queuechanged";
        r2.notifyChange(r0);	 Catch:{ all -> 0x0032 }
    L_0x001e:
        r0 = r2.mPlayPos;	 Catch:{ all -> 0x0032 }
        if (r0 >= 0) goto L_0x0030;
    L_0x0022:
        r0 = 0;
        r2.mPlayPos = r0;	 Catch:{ all -> 0x0032 }
        r2.openCurrent();	 Catch:{ all -> 0x0032 }
        r2.play();	 Catch:{ all -> 0x0032 }
        r0 = "meta_changed_track";
        r2.notifyMetaChange(r0);	 Catch:{ all -> 0x0032 }
    L_0x0030:
        monitor-exit(r2);	 Catch:{ all -> 0x0032 }
        goto L_0x0005;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r2.addToPlayList(r3, r0);	 Catch:{ all -> 0x0032 }
        r0 = "com.miui.player.queuechanged";
        r2.notifyChange(r0);	 Catch:{ all -> 0x0032 }
        r0 = 1;
        if (r4 != r0) goto L_0x001e;
    L_0x0043:
        r0 = r2.mPlayListLen;	 Catch:{ all -> 0x0032 }
        r1 = r3.length;	 Catch:{ all -> 0x0032 }
        r0 = r0 - r1;
        r2.mPlayPos = r0;	 Catch:{ all -> 0x0032 }
        r2.openCurrent();	 Catch:{ all -> 0x0032 }
        r2.play();	 Catch:{ all -> 0x0032 }
        r0 = "meta_changed_track";
        r2.notifyMetaChange(r0);	 Catch:{ all -> 0x0032 }
        monitor-exit(r2);	 Catch:{ all -> 0x0032 }
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.service.MediaPlaybackService.enqueue(long[], int):void");
    }

    private boolean adjustShuffleMode(boolean forceShuffle, String channelName) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int oldShuffleModeBak = sp.getInt(KEY_SHUFFLE_MODE, 0);
        int newShuffleModeBak = oldShuffleModeBak;
        int oldRepeatModeBak = sp.getInt(KEY_REPEAT_MODE, 0);
        int newRepeatModeBak = oldRepeatModeBak;
        if (forceShuffle) {
            doSetShuffleMode(1);
            if (this.mRepeatMode == 1) {
                doSetRepeatMode(0);
            }
            newShuffleModeBak = this.mShuffleMode;
            newRepeatModeBak = this.mRepeatMode;
        } else if (this.mChannelName == null && channelName != null) {
            forceShuffle = true;
            newShuffleModeBak = this.mShuffleMode;
            newRepeatModeBak = this.mRepeatMode;
            doSetShuffleMode(1);
            if (this.mRepeatMode == 1) {
                doSetRepeatMode(0);
            }
        } else if (this.mChannelName != null && channelName == null) {
            doSetShuffleMode(oldShuffleModeBak);
            doSetRepeatMode(oldRepeatModeBak);
        }
        Editor editor = sp.edit();
        if (newShuffleModeBak != oldShuffleModeBak) {
            editor.putInt(KEY_SHUFFLE_MODE, newShuffleModeBak);
        }
        if (newRepeatModeBak != oldRepeatModeBak) {
            editor.putInt(KEY_REPEAT_MODE, newRepeatModeBak);
        }
        editor.apply();
        return forceShuffle;
    }

    public boolean openList(long[] list, int position, boolean forceShuffle, String channelName) {
        forceShuffle = adjustShuffleMode(forceShuffle, channelName);
        this.mChannelName = channelName;
        if (forceShuffle) {
            position = -1;
        }
        return open(list, position);
    }

    public boolean open(long[] list, int position) {
        boolean newlist;
        synchronized (this) {
            long oldId = getAudioId();
            int listlength = list.length;
            newlist = true;
            if (this.mPlayListLen == listlength) {
                newlist = false;
                for (int i = 0; i < listlength; i++) {
                    if (list[i] != this.mPlayList[i]) {
                        newlist = true;
                        break;
                    }
                }
            }
            if (newlist) {
                addToPlayList(list, -1);
            }
            if (position >= 0) {
                this.mPlayPos = position;
            } else {
                this.mPlayPos = this.mRandom.nextInt(this.mPlayListLen);
            }
            this.mShuffleTracer.clear();
            stop(false, true);
            openCurrent();
            notifyChange(Out.STATUS_QUEUE_CHANGED);
            notifyMetaChange(Out.META_CHANGED_TRACK);
        }
        return newlist;
    }

    public void moveQueueItem(int index1, int index2) {
        synchronized (this) {
            if (index1 >= this.mPlayListLen) {
                index1 = this.mPlayListLen - 1;
            }
            if (index2 >= this.mPlayListLen) {
                index2 = this.mPlayListLen - 1;
            }
            long tmp;
            int i;
            if (index1 < index2) {
                tmp = this.mPlayList[index1];
                for (i = index1; i < index2; i++) {
                    this.mPlayList[i] = this.mPlayList[i + 1];
                }
                this.mPlayList[index2] = tmp;
                if (this.mPlayPos == index1) {
                    this.mPlayPos = index2;
                } else if (this.mPlayPos >= index1 && this.mPlayPos <= index2) {
                    this.mPlayPos--;
                }
            } else if (index2 < index1) {
                tmp = this.mPlayList[index1];
                for (i = index1; i > index2; i--) {
                    this.mPlayList[i] = this.mPlayList[i - 1];
                }
                this.mPlayList[index2] = tmp;
                if (this.mPlayPos == index1) {
                    this.mPlayPos = index2;
                } else if (this.mPlayPos >= index2 && this.mPlayPos <= index1) {
                    this.mPlayPos++;
                }
            }
            notifyChange(Out.STATUS_QUEUE_CHANGED);
        }
    }

    public long[] getQueue() {
        long[] list;
        synchronized (this) {
            int len = this.mPlayListLen;
            list = new long[len];
            for (int i = 0; i < len; i++) {
                list[i] = this.mPlayList[i];
            }
        }
        return list;
    }

    public int getQueueSize() {
        int i;
        synchronized (this) {
            i = this.mPlayListLen;
        }
        return i;
    }

    void openCurrent() {
        openCurrent(false);
    }

    void openCurrent(boolean isFirst) {
        openCurrent(isFirst, 0, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void openCurrent(boolean r9, long r10, long r12) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.mTrackInfo;	 Catch:{ all -> 0x0019 }
        r0.reset();	 Catch:{ all -> 0x0019 }
        r0 = r8.mPlayListLen;	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);	 Catch:{ all -> 0x0019 }
    L_0x000b:
        return;
    L_0x000c:
        r0 = r8.mPlayPos;	 Catch:{ all -> 0x0019 }
        if (r0 < 0) goto L_0x0017;
    L_0x0010:
        r0 = r8.mPlayPos;	 Catch:{ all -> 0x0019 }
        r2 = r8.mPlayList;	 Catch:{ all -> 0x0019 }
        r2 = r2.length;	 Catch:{ all -> 0x0019 }
        if (r0 < r2) goto L_0x001c;
    L_0x0017:
        monitor-exit(r8);	 Catch:{ all -> 0x0019 }
        goto L_0x000b;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0019 }
        throw r0;
    L_0x001c:
        r1 = 0;
        r0 = r8.mPlayList;	 Catch:{ all -> 0x0019 }
        r2 = r8.mPlayPos;	 Catch:{ all -> 0x0019 }
        r2 = r0[r2];	 Catch:{ all -> 0x0019 }
        r7 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x0019 }
        r0 = r8.mPlayList;	 Catch:{ all -> 0x0019 }
        r2 = r8.mPlayPos;	 Catch:{ all -> 0x0019 }
        r2 = r0[r2];	 Catch:{ all -> 0x0019 }
        r0 = com.miui.player.provider.PlayerProvider.isOnlineAudio(r2);	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0075;
    L_0x0033:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0019 }
        r0.<init>();	 Catch:{ all -> 0x0019 }
        r2 = com.miui.player.provider.PlayerStore.MiuiNowPlayingAudio.EXTERNAL_URI;	 Catch:{ all -> 0x0019 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0019 }
        r2 = "/";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0019 }
        r0 = r0.append(r7);	 Catch:{ all -> 0x0019 }
        r1 = r0.toString();	 Catch:{ all -> 0x0019 }
    L_0x004c:
        r0 = r8.mTrackInfo;	 Catch:{ all -> 0x0019 }
        r2 = r8.mPlayList;	 Catch:{ all -> 0x0019 }
        r3 = r8.mPlayPos;	 Catch:{ all -> 0x0019 }
        r2 = r2[r3];	 Catch:{ all -> 0x0019 }
        r0.setAudioId(r2);	 Catch:{ all -> 0x0019 }
        r0 = r8.mTrackInfo;	 Catch:{ all -> 0x0019 }
        r0 = r0.isValid();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x008f;
    L_0x005f:
        if (r9 != 0) goto L_0x0064;
    L_0x0061:
        r8.accumulateCurrent();	 Catch:{ all -> 0x0019 }
    L_0x0064:
        r0 = r8;
        r2 = r9;
        r3 = r10;
        r5 = r12;
        r0.open(r1, r2, r3, r5);	 Catch:{ all -> 0x0019 }
        r0 = r8.mPlayer;	 Catch:{ all -> 0x0019 }
        r0 = r0.isInitialized();	 Catch:{ all -> 0x0019 }
        r8.mQueueIsSaveable = r0;	 Catch:{ all -> 0x0019 }
    L_0x0073:
        monitor-exit(r8);	 Catch:{ all -> 0x0019 }
        goto L_0x000b;
    L_0x0075:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0019 }
        r0.<init>();	 Catch:{ all -> 0x0019 }
        r2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;	 Catch:{ all -> 0x0019 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0019 }
        r2 = "/";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0019 }
        r0 = r0.append(r7);	 Catch:{ all -> 0x0019 }
        r1 = r0.toString();	 Catch:{ all -> 0x0019 }
        goto L_0x004c;
    L_0x008f:
        r0 = LOGTAG;	 Catch:{ all -> 0x0019 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0019 }
        r2.<init>();	 Catch:{ all -> 0x0019 }
        r3 = "query nowplaying cursor failed! id=";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0019 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0019 }
        r2 = r2.toString();	 Catch:{ all -> 0x0019 }
        android.util.Log.e(r0, r2);	 Catch:{ all -> 0x0019 }
        r8.stop();	 Catch:{ all -> 0x0019 }
        goto L_0x0073;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.service.MediaPlaybackService.openCurrent(boolean, long, long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void open(String r14, boolean r15, long r16, long r18) {
        /*
        r13 = this;
        monitor-enter(r13);
        r0 = 0;
        r13.mShowLink = r0;	 Catch:{ all -> 0x0058 }
        r0 = "com.miui.player.showlinkchanged";
        r13.notifyChange(r0);	 Catch:{ all -> 0x0058 }
        if (r14 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r13);	 Catch:{ all -> 0x0058 }
    L_0x000c:
        return;
    L_0x000d:
        r13.mFileToPlay = r14;	 Catch:{ all -> 0x0058 }
        r0 = r13.canPlay(r14, r15);	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x005b;
    L_0x0015:
        r0 = r13.mLyricManager;	 Catch:{ all -> 0x0058 }
        r0.reset();	 Catch:{ all -> 0x0058 }
        r0 = r13.mPlayerResponser;	 Catch:{ all -> 0x0058 }
        r1 = r13.mFileToPlay;	 Catch:{ all -> 0x0058 }
        r0.resetBufferingPath(r1);	 Catch:{ all -> 0x0058 }
        r0 = r13.mPlayer;	 Catch:{ all -> 0x0058 }
        r1 = 0;
        r0.setOnCompletionListener(r1);	 Catch:{ all -> 0x0058 }
        r11 = r13.mPlayer;	 Catch:{ all -> 0x0058 }
        r12 = r13.mFileToPlay;	 Catch:{ all -> 0x0058 }
        r0 = new com.miui.player.asyncplayer.PlayerStub$PrepareInfo;	 Catch:{ all -> 0x0058 }
        r2 = r13.getNextId();	 Catch:{ all -> 0x0058 }
        r7 = r13.getTrackName();	 Catch:{ all -> 0x0058 }
        r8 = r13.getAlbumName();	 Catch:{ all -> 0x0058 }
        r9 = r13.getArtistName();	 Catch:{ all -> 0x0058 }
        r1 = r15;
        r3 = r16;
        r5 = r18;
        r0.<init>(r1, r2, r3, r5, r7, r8, r9);	 Catch:{ all -> 0x0058 }
        r11.prepare(r12, r0);	 Catch:{ all -> 0x0058 }
        r0 = 1;
        r1 = 1;
        r13.onPlayStateChanged(r0, r1);	 Catch:{ all -> 0x0058 }
        r10 = r13.getOnlineId();	 Catch:{ all -> 0x0058 }
        if (r10 != 0) goto L_0x0056;
    L_0x0053:
        com.miui.player.reporter.OnlineMusicReporter.postLocalPlayStatus(r13);	 Catch:{ all -> 0x0058 }
    L_0x0056:
        monitor-exit(r13);	 Catch:{ all -> 0x0058 }
        goto L_0x000c;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x0058 }
        throw r0;
    L_0x005b:
        r13.stop();	 Catch:{ all -> 0x0058 }
        r0 = "meta_changed_track";
        r13.notifyMetaChange(r0);	 Catch:{ all -> 0x0058 }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.service.MediaPlaybackService.open(java.lang.String, boolean, long, long):void");
    }

    private String getNextId() {
        if (this.mPlayListLen <= 1) {
            return null;
        }
        long ret = -1;
        int nextIdx = this.mPlayPos + 1;
        if (this.mShuffleMode != 0) {
            ret = this.mPlayList[this.mShuffleTracer.peekNext(this.mPlayListLen, this.mPlayPos)];
        } else if (this.mRepeatMode != 2) {
            if (nextIdx >= this.mPlayListLen) {
                nextIdx = 0;
            }
            ret = this.mPlayList[nextIdx];
        } else if (nextIdx < this.mPlayListLen) {
            ret = this.mPlayList[nextIdx];
        }
        if (!PlayerProvider.isOnlineAudio(ret)) {
            ret = -1;
        }
        if (ret >= 0) {
            return String.valueOf(ret);
        }
        return null;
    }

    private boolean canPlay(String path, boolean isFirst) {
        boolean z = false;
        if (!path.startsWith(PlayerStore.MIUI_CONTENT_AUTHORITY_SLASH) || !NetworkUtil.isActiveNetworkMetered(this)) {
            return true;
        }
        boolean isOnlineAllow = PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_LISTEN_TO_MUSIC_OTHER);
        boolean allOnline = isAllOnline();
        if (!isOnlineAllow && allOnline) {
            Toast.makeText(this, C0329R.string.music_open_other_connect, 0).show();
        }
        if (isOnlineAllow || !allOnline) {
            z = true;
        }
        return z;
    }

    private boolean isAllOnline() {
        long[] queue = this.mPlayList;
        if (queue == null || this.mPlayListLen <= 0) {
            return false;
        }
        for (int i = 0; i < this.mPlayListLen; i++) {
            if (!PlayerProvider.isOnlineAudio(queue[i])) {
                return false;
            }
        }
        return true;
    }

    void accumulateCurrent() {
        if (this.mPlayPos >= 0 && this.mPlayPos < this.mPlayListLen) {
            long audioId = this.mPlayList[this.mPlayPos];
            if (audioId >= 0 && !PlayerProvider.isOnlineAudio(audioId)) {
                PlayerProvider.accumulatePlayCount(getContentResolver(), audioId, getAbsolutePath());
            }
        }
    }

    public void play() {
        play(true);
    }

    public void play(boolean shuffleIfNeeded) {
        if (this.mConnectedDevice != null) {
            DeviceController.instance().open(2);
        }
        MediaButtonIntentReceiver.setOneShot(false);
        if (this.mPlayer.isInitialized()) {
            if (this.mPlayerResponser.mIsBuffering) {
                String bufferingPath = this.mPlayerResponser.mCurrentBufferingPath;
                if (bufferingPath != null && bufferingPath.equals(getPath())) {
                    this.mPlayerResponser.mPlayAfterBuffer = true;
                    onPlayStateChanged(true, true);
                }
            } else {
                this.mPlayer.start();
                onPlayStateChanged(true, false);
            }
            this.mPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mAudioPauseManager.onStart();
            if (!this.mIsSupposedToBePlaying) {
                this.mIsSupposedToBePlaying = true;
                notifyChange(Out.STATUS_PLAYSTATE_CHANGED);
            }
            startForeground(1, new Builder(this).getNotification());
            updateNotificationBar();
        } else if (isAllOnline()) {
            if (!NetworkUtil.isActive(this)) {
                Toast.makeText(this, C0329R.string.network_error, 0).show();
            }
            this.mPlayList = null;
            this.mPlayListLen = 0;
            this.mPlayPos = -1;
            notifyChange(Out.STATUS_QUEUE_CHANGED);
        } else if (shuffleIfNeeded) {
            makeAllShuffleList();
        }
        this.mVolumeAlertHelper.refreshAlert();
    }

    void updateNotificationBar() {
        boolean isArtistValid;
        boolean isAlbumValid;
        CharSequence descript;
        CharSequence title = getTrackName();
        title = getTrackName();
        CharSequence artist = MetaManager.getLocaleArtistName(this, getArtistName());
        CharSequence album = MetaManager.getLocaleAlbumName(this, getAlbumName());
        if (TextUtils.isEmpty(artist)) {
            isArtistValid = false;
        } else {
            isArtistValid = true;
        }
        if (TextUtils.isEmpty(album)) {
            isAlbumValid = false;
        } else {
            isAlbumValid = true;
        }
        if (isArtistValid && isAlbumValid) {
            descript = artist + "  <" + album + ">";
        } else if (isArtistValid) {
            descript = artist;
        } else if (isAlbumValid) {
            descript = "<" + album + ">";
        } else {
            descript = MetaManager.UNKNOWN_STRING;
        }
        Builder builder = new Builder(this);
        builder.setTicker(title);
        builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent("com.miui.player.PLAYBACK_VIEWER"), 0));
        builder.setContent(createNotificationContent(C0329R.drawable.stat_notify_icon, title, descript));
        builder.setOngoing(isPlaying());
        builder.setSmallIcon(C0329R.drawable.stat_notify_icon);
        enqueueNotification(2, builder.getNotification());
        this.mHasNotification = true;
        MusicLog.m395d(LOGTAG, "update notification: title=" + title + ", isPlaying=" + isPlaying());
    }

    private RemoteViews createNotificationContent(int icon, CharSequence primary, CharSequence secondary) {
        RemoteViews rm = new RemoteViews(getPackageName(), C0329R.layout.status_bar);
        rm.setImageViewResource(16908294, icon);
        rm.setTextViewText(C0329R.id.primary_text, primary);
        rm.setTextViewText(C0329R.id.secondary_text, secondary);
        rm.setOnClickPendingIntent(C0329R.id.st_next, getPendingIntent(PlayerActions.In.ACTION_NEXT));
        rm.setImageViewResource(C0329R.id.st_pause, isPlaying() ? C0329R.drawable.st_pause_selector : C0329R.drawable.st_play_selector);
        rm.setOnClickPendingIntent(C0329R.id.st_pause, getPendingIntent(ACTION_TOGGLEPAUSE_UNREMOVE_NOTIFICATION));
        return rm;
    }

    private PendingIntent getPendingIntent(String action) {
        Intent intent = new Intent(this, getClass());
        intent.setAction(action);
        return PendingIntent.getService(this, 0, intent, 0);
    }

    private void enqueueNotification(int id, Notification notification) {
        int[] idOut = new int[1];
        INotificationManagerProxy service = new INotificationManagerProxy(NotificationManager.getService());
        String pkg = getPackageName();
        Log.v(LOGTAG, pkg + ": notify(" + id + ", " + notification + ")");
        try {
            service.enqueueNotificationWithTag(pkg, null, id, notification, idOut);
            if (id != idOut[0]) {
                Log.w(LOGTAG, "notify: id corrupted: sent " + id + ", got back " + idOut[0]);
            }
        } catch (RemoteException e) {
        }
    }

    void stop(boolean permanent, boolean removeNext) {
        this.mPlayerResponser.stopBuffering();
        if (this.mPlayer.isInitialized()) {
            this.mPlayer.stop(permanent, removeNext);
        }
        this.mFileToPlay = null;
        gotoIdleState(permanent);
        this.mIsSupposedToBePlaying = false;
        onPlayStateChanged(false, false);
    }

    public void stop() {
        stop(true, true);
    }

    public void quit() {
        quit(true);
    }

    public void quit(boolean enableDelay) {
        saveQueue(true);
        pause();
        setConnectedDevice(null);
        sendBroadcast(new Intent(ServiceActions.Out.KILL_PROCESS));
        gotoIdleState(true, 2, enableDelay ? 5000 : 1000);
    }

    public void pause() {
        pause(true);
    }

    public void pause(boolean removeStatusIcon) {
        pause(removeStatusIcon, true);
    }

    public void pause(boolean removeStatusIcon, boolean abandonAudioFocus) {
        synchronized (this) {
            this.mAudioPauseManager.onPause(abandonAudioFocus);
            if (isPlaying()) {
                this.mPlayer.pause();
                this.mIsSupposedToBePlaying = false;
                this.mPlayerResponser.stopBuffering();
                gotoIdleState(removeStatusIcon);
                notifyChange(Out.STATUS_PLAYSTATE_CHANGED);
            }
            onPlayStateChanged(false, false);
        }
        if (abandonAudioFocus) {
            this.mVolumeAlertHelper.refreshAlert();
        }
    }

    public boolean isPlaying() {
        return this.mIsSupposedToBePlaying;
    }

    public void prev() {
        prev(false);
    }

    public void prev(boolean isAutoStopped) {
        synchronized (this) {
            if (!(this.mRepeatMode == 1 && isAutoStopped)) {
                if (this.mShuffleMode == 1) {
                    int pos = this.mShuffleTracer.back(this.mPlayListLen, this.mPlayPos);
                    if (pos < 0) {
                        seek(0);
                        play();
                        return;
                    }
                    this.mPlayPos = pos;
                } else {
                    this.mPlayPos--;
                    if (this.mPlayPos < 0) {
                        this.mPlayPos = this.mPlayListLen - 1;
                    }
                }
            }
            stop(false, true);
            openCurrent();
            play();
            notifyMetaChange(Out.META_CHANGED_TRACK);
        }
    }

    public void next(boolean force) {
        next(force, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void next(boolean r5, boolean r6) {
        /*
        r4 = this;
        r2 = 1;
        monitor-enter(r4);
        r1 = r4.mPlayListLen;	 Catch:{ all -> 0x002b }
        if (r1 > 0) goto L_0x000f;
    L_0x0006:
        r1 = LOGTAG;	 Catch:{ all -> 0x002b }
        r2 = "No play queue";
        com.miui.player.util.Utils.debugLog(r1, r2);	 Catch:{ all -> 0x002b }
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
    L_0x000e:
        return;
    L_0x000f:
        r0 = 0;
        r1 = r4.mRepeatMode;	 Catch:{ all -> 0x002b }
        if (r1 != r2) goto L_0x002e;
    L_0x0014:
        if (r6 == 0) goto L_0x002e;
    L_0x0016:
        if (r0 == 0) goto L_0x006f;
    L_0x0018:
        r1 = 1;
        r4.gotoIdleState(r1);	 Catch:{ all -> 0x002b }
        r1 = "com.miui.player.playbackcomplete";
        r4.notifyChange(r1);	 Catch:{ all -> 0x002b }
        r1 = 0;
        r4.mIsSupposedToBePlaying = r1;	 Catch:{ all -> 0x002b }
        r1 = 0;
        r2 = 0;
        r4.onPlayStateChanged(r1, r2);	 Catch:{ all -> 0x002b }
    L_0x0029:
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
        goto L_0x000e;
    L_0x002b:
        r1 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
        throw r1;
    L_0x002e:
        r1 = r4.mShuffleMode;	 Catch:{ all -> 0x002b }
        if (r1 != r2) goto L_0x0053;
    L_0x0032:
        r1 = r4.mShuffleTracer;	 Catch:{ all -> 0x002b }
        r1 = r1.getTracer();	 Catch:{ all -> 0x002b }
        r2 = r4.mPlayListLen;	 Catch:{ all -> 0x002b }
        r2 = r2 + -1;
        if (r1 < r2) goto L_0x0044;
    L_0x003e:
        r1 = r4.mRepeatMode;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0044;
    L_0x0042:
        if (r5 == 0) goto L_0x0051;
    L_0x0044:
        r1 = r4.mShuffleTracer;	 Catch:{ all -> 0x002b }
        r2 = r4.mPlayListLen;	 Catch:{ all -> 0x002b }
        r3 = r4.mPlayPos;	 Catch:{ all -> 0x002b }
        r1 = r1.randNext(r2, r3);	 Catch:{ all -> 0x002b }
        r4.mPlayPos = r1;	 Catch:{ all -> 0x002b }
        goto L_0x0016;
    L_0x0051:
        r0 = 1;
        goto L_0x0016;
    L_0x0053:
        r1 = r4.mPlayPos;	 Catch:{ all -> 0x002b }
        r2 = r4.mPlayListLen;	 Catch:{ all -> 0x002b }
        r2 = r2 + -1;
        if (r1 < r2) goto L_0x0068;
    L_0x005b:
        r1 = r4.mRepeatMode;	 Catch:{ all -> 0x002b }
        r2 = 2;
        if (r1 != r2) goto L_0x0064;
    L_0x0060:
        if (r5 != 0) goto L_0x0064;
    L_0x0062:
        r0 = 1;
        goto L_0x0016;
    L_0x0064:
        r1 = 0;
        r4.mPlayPos = r1;	 Catch:{ all -> 0x002b }
        goto L_0x0016;
    L_0x0068:
        r1 = r4.mPlayPos;	 Catch:{ all -> 0x002b }
        r1 = r1 + 1;
        r4.mPlayPos = r1;	 Catch:{ all -> 0x002b }
        goto L_0x0016;
    L_0x006f:
        r1 = 0;
        r2 = 0;
        r4.stop(r1, r2);	 Catch:{ all -> 0x002b }
        r4.openCurrent();	 Catch:{ all -> 0x002b }
        r4.play();	 Catch:{ all -> 0x002b }
        r1 = "meta_changed_track";
        r4.notifyMetaChange(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.service.MediaPlaybackService.next(boolean, boolean):void");
    }

    public void backward() {
        synchronized (this) {
            if (SystemClock.uptimeMillis() - this.mLastRewindTime > 2000) {
                this.mRewindCount = 1;
            } else {
                this.mRewindCount++;
            }
            this.mLastRewindTime = SystemClock.uptimeMillis();
            seek(position() - ((long) (this.mRewindCount > 10 ? BACKWARD_FORWARD_QUICK_DELTA : 5000)));
        }
    }

    public void forward() {
        synchronized (this) {
            if (SystemClock.uptimeMillis() - this.mLastForwardTime > 2000) {
                this.mForwardCount = 1;
            } else {
                this.mForwardCount++;
            }
            this.mLastForwardTime = SystemClock.uptimeMillis();
            seek(position() + ((long) (this.mForwardCount > 10 ? BACKWARD_FORWARD_QUICK_DELTA : 5000)));
        }
    }

    private void gotoIdleState(boolean removeStatusIcon) {
        gotoIdleState(removeStatusIcon, 1, IDLE_DELAY);
    }

    private void gotoIdleState(boolean removeStatusIcon, int what, int delay) {
        DeviceController.instance().closeDelayed(2, 300000);
        this.mDelayedStopHandler.removeCallbacksAndMessages(null);
        Message msg = this.mDelayedStopHandler.obtainMessage(what);
        if (delay == 1000) {
            msg.arg1 = 1;
        }
        this.mDelayedStopHandler.sendMessageDelayed(msg, (long) delay);
        stopForeground(true);
        if (removeStatusIcon) {
            ((NotificationManager) getSystemService("notification")).cancel(2);
            this.mHasNotification = false;
        } else if (this.mHasNotification) {
            updateNotificationBar();
        }
    }

    public int removeTracks(int[] posArr) {
        int i;
        synchronized (this) {
            if (this.mPlayList == null) {
                i = 0;
            } else {
                if (len <= 0) {
                    i = 0;
                } else {
                    boolean gotoNext = false;
                    int beforeCurrent = 0;
                    i = 0;
                    for (int pos : posArr) {
                        if (pos < 0) {
                            break;
                        }
                        if (pos < this.mPlayListLen) {
                            this.mPlayList[pos] = -1;
                            i++;
                            if (pos < this.mPlayPos) {
                                beforeCurrent++;
                            } else if (pos == this.mPlayPos) {
                                gotoNext = true;
                            }
                        }
                    }
                    int step = 0;
                    int newLen = this.mPlayListLen - i;
                    int i2 = 0;
                    while (i2 < newLen) {
                        while (i2 + step <= this.mPlayListLen && this.mPlayList[i2 + step] < 0) {
                            step++;
                        }
                        long tmp = this.mPlayList[i2 + step];
                        if (tmp >= 0) {
                            this.mPlayList[i2] = tmp;
                        }
                        i2++;
                    }
                    for (i2 = newLen; i2 < this.mPlayListLen; i2++) {
                        this.mPlayList[i2] = 0;
                    }
                    this.mPlayListLen = newLen;
                    this.mPlayPos -= beforeCurrent;
                    if (this.mPlayListLen <= 0) {
                        stop(true, true);
                        this.mPlayPos = -1;
                    } else if (gotoNext) {
                        if (this.mPlayPos >= this.mPlayListLen) {
                            this.mPlayPos = 0;
                        }
                        boolean wasPlaying = isPlaying();
                        stop(true, true);
                        openCurrent();
                        if (wasPlaying) {
                            play();
                        }
                    }
                    if (i > 0) {
                        notifyChange(Out.STATUS_QUEUE_CHANGED);
                        if (gotoNext) {
                            notifyMetaChange(Out.META_CHANGED_TRACK, true);
                        }
                    }
                }
            }
        }
        return i;
    }

    public int removeTracks(int first, int last) {
        int numremoved = removeTracksInternal(first, last);
        if (numremoved > 0) {
            notifyChange(Out.STATUS_QUEUE_CHANGED);
        }
        return numremoved;
    }

    private int removeTracksInternal(int first, int last) {
        int i = 0;
        synchronized (this) {
            if (last < first) {
            } else {
                if (first < 0) {
                    first = 0;
                }
                if (last >= this.mPlayListLen) {
                    last = this.mPlayListLen - 1;
                }
                boolean gotonext = false;
                if (first <= this.mPlayPos && this.mPlayPos <= last) {
                    this.mPlayPos = first;
                    gotonext = true;
                } else if (this.mPlayPos > last) {
                    this.mPlayPos -= (last - first) + 1;
                }
                int num = (this.mPlayListLen - last) - 1;
                for (int i2 = 0; i2 < num; i2++) {
                    this.mPlayList[first + i2] = this.mPlayList[(last + 1) + i2];
                }
                this.mPlayListLen -= (last - first) + 1;
                if (gotonext) {
                    if (this.mPlayListLen == 0) {
                        stop(true, true);
                        this.mPlayPos = -1;
                        this.mTrackInfo.reset();
                    } else {
                        if (this.mPlayPos >= this.mPlayListLen) {
                            this.mPlayPos = 0;
                        }
                        boolean wasPlaying = isPlaying();
                        stop(true, true);
                        openCurrent();
                        if (wasPlaying) {
                            play();
                        }
                    }
                    notifyMetaChange(Out.META_CHANGED_TRACK);
                }
                i = (last - first) + 1;
            }
        }
        return i;
    }

    public int removeTrack(long id) {
        int numremoved = 0;
        synchronized (this) {
            int i = 0;
            while (i < this.mPlayListLen) {
                if (this.mPlayList[i] == id) {
                    numremoved += removeTracksInternal(i, i);
                    i--;
                }
                i++;
            }
        }
        if (numremoved > 0) {
            notifyChange(Out.STATUS_QUEUE_CHANGED);
        }
        return numremoved;
    }

    public void setShuffleMode(int mode) {
        doSetShuffleMode(mode);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putInt(KEY_SHUFFLE_MODE, mode).apply();
    }

    private void doSetShuffleMode(int mode) {
        if (this.mPlayListLen > 0) {
            synchronized (this) {
                this.mPlayer.changeMode(this.mShuffleMode, mode);
                this.mShuffleTracer.clear();
                this.mShuffleMode = mode;
                saveQueue(false);
            }
        }
    }

    public int getShuffleMode() {
        return this.mShuffleMode;
    }

    public void setRepeatMode(int mode) {
        doSetRepeatMode(mode);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putInt(KEY_REPEAT_MODE, mode).apply();
    }

    private void doSetRepeatMode(int mode) {
        synchronized (this) {
            this.mRepeatMode = mode;
            saveQueue(false);
        }
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public String getPath() {
        return this.mFileToPlay;
    }

    public String getAbsolutePath() {
        String str;
        synchronized (this) {
            str = this.mTrackInfo.mAbsolutePath;
        }
        return str;
    }

    public String getPlayingFilePath() {
        return this.mPlayer.getPath();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getAudioId() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mPlayPos;	 Catch:{ all -> 0x0019 }
        if (r0 < 0) goto L_0x0015;
    L_0x0005:
        r0 = r2.mPlayer;	 Catch:{ all -> 0x0019 }
        r0 = r0.isInitialized();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r2.mPlayList;	 Catch:{ all -> 0x0019 }
        r1 = r2.mPlayPos;	 Catch:{ all -> 0x0019 }
        r0 = r0[r1];	 Catch:{ all -> 0x0019 }
        monitor-exit(r2);	 Catch:{ all -> 0x0019 }
    L_0x0014:
        return r0;
    L_0x0015:
        monitor-exit(r2);	 Catch:{ all -> 0x0019 }
        r0 = -1;
        goto L_0x0014;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0019 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.service.MediaPlaybackService.getAudioId():long");
    }

    public int getQueuePosition() {
        int i;
        synchronized (this) {
            i = this.mPlayPos;
        }
        return i;
    }

    public void setQueuePosition(int pos) {
        synchronized (this) {
            this.mShuffleTracer.clear();
            this.mPlayPos = pos;
            stop(false, true);
            openCurrent(false);
            play();
            notifyMetaChange(Out.META_CHANGED_TRACK);
        }
    }

    public String getArtistName() {
        String str;
        synchronized (this) {
            str = this.mTrackInfo.mArtistName;
        }
        return str;
    }

    public long getArtistId() {
        long j;
        synchronized (this) {
            j = this.mTrackInfo.mArtistId;
        }
        return j;
    }

    public String getAlbumName() {
        String str;
        synchronized (this) {
            str = this.mTrackInfo.mAlbumName;
        }
        return str;
    }

    public long getAlbumId() {
        long j;
        synchronized (this) {
            j = this.mTrackInfo.mAlbumId;
        }
        return j;
    }

    public String getTrackName() {
        String str;
        synchronized (this) {
            str = this.mTrackInfo.mTrackName;
        }
        return str;
    }

    public long getAudioIdByPos(int pos) {
        long id;
        synchronized (this) {
            id = -1;
            if (pos >= 0) {
                if (pos < this.mPlayListLen) {
                    id = this.mPlayList[pos];
                }
            }
        }
        return id;
    }

    public long duration() {
        if (this.mPlayer.isInitialized()) {
            return this.mPlayer.duration();
        }
        return -1;
    }

    public long position() {
        if (this.mPlayer.isInitialized()) {
            return this.mPlayer.position();
        }
        return -1;
    }

    public long seek(long pos) {
        if (!this.mPlayer.isInitialized()) {
            return -1;
        }
        if (pos < 0) {
            pos = 0;
        }
        if (pos > this.mPlayer.duration()) {
            pos = this.mPlayer.duration();
        }
        this.mPlayer.seek(pos);
        return pos;
    }

    public int getAudioSessionId() {
        int audioSessionId;
        synchronized (this) {
            audioSessionId = this.mPlayer.getAudioSessionId();
        }
        return audioSessionId;
    }

    public boolean isBuffering() {
        return this.mPlayerResponser.mIsBuffering;
    }

    public boolean isBlocking() {
        return this.mPlayer.isBlocking();
    }

    public long getBufferedPosition() {
        try {
            return (long) (((float) this.mPlayer.duration()) * this.mPlayer.getBufferedPercent());
        } catch (Exception e) {
            return position();
        }
    }

    public float getBufferedPercent() {
        try {
            return this.mPlayer.getBufferedPercent();
        } catch (Exception e) {
            return 0.0f;
        }
    }

    public String getOnlineId() {
        String str;
        synchronized (this) {
            str = this.mTrackInfo.mOnlineId;
        }
        return str;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public File getAlbumFile(String albumName, String artistName) {
        if (TextUtils.isEmpty(albumName) && TextUtils.isEmpty(artistName)) {
            return null;
        }
        return MetaManager.getAlbumFile(albumName, artistName, getAbsolutePath());
    }

    public int getLyricStatus() {
        return this.mLyricManager.status();
    }

    public int getUpdateVersion() {
        return this.mUpdateVersion;
    }

    void onPlayStateChanged(boolean isPlay, boolean isPrepare) {
        if (isPlay) {
            ServiceHelper.registerMediaButtonReceiver(this);
            if (this.mWakeLockNeeded) {
                this.mMediaplayerHandler.removeMessages(2);
            }
            if (!this.mWakeLock.isHeld() && this.mWakeLockNeeded) {
                this.mWakeLock.acquire();
                Log.d(LOGTAG, " wakelock acquire " + System.currentTimeMillis());
            }
            if (!isPrepare) {
                if (this.mScreenOn || !PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_SHAKE_WHILE_SCREEN_ON)) {
                    this.mShakeListener.register();
                    return;
                }
                return;
            }
            return;
        }
        if (this.mWakeLock.isHeld()) {
            this.mMediaplayerHandler.removeMessages(2);
            this.mMediaplayerHandler.sendEmptyMessageDelayed(2, OnlinePlayStatstics.MIN_LOOP_TIME);
        }
        this.mShakeListener.unregister();
    }

    void updateMetaOnConnChanged(boolean connection) {
        if (connection) {
            String artistName = getArtistName();
            String albumName = getAlbumName();
            String trackName = getTrackName();
            if (!this.mLyricManager.isSuccess()) {
                this.mLyricManager.reset();
                this.mLyricManager.updateLyricStatus(this, new LyricOpenRunnable(trackName, artistName), false, trackName, albumName, artistName, false);
            }
            updateAlbum(trackName, albumName, artistName);
            OnlineMusicReporter.postUserStart(this);
        }
    }

    public boolean needSearch() {
        if (PlayerProvider.isOnlineAudio(getAudioId())) {
            return true;
        }
        boolean ret = false;
        String path = getAbsolutePath();
        if (!TextUtils.isEmpty(path)) {
            File f = new File(path);
            ret = f.exists() && f.length() > FileUtil.ONE_MB;
        }
        return ret;
    }

    private AlbumSource updateAlbum(String trackName, String albumName, String artistName) {
        AlbumSource info = new AlbumSource();
        if (PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_DISPLAY_ALBUM)) {
            if (PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_ANDROID_ALBUM)) {
                info.mUri = AlbumManager.getAlbumUriForDB(this, getAudioId(), getAlbumId());
            }
            if (info.mUri == null) {
                File albumFile = getAlbumFile(albumName, artistName);
                if (albumFile != null && albumFile.isFile()) {
                    albumFile.setLastModified(System.currentTimeMillis());
                    info.mFilePath = albumFile.getAbsolutePath();
                }
            }
            if (info.mFilePath == null && info.mUri == null && needSearch()) {
                downloadAlbum(albumName, artistName, getOnlineId());
            }
        }
        return info;
    }

    private void downloadAlbum(String albumName, String artistName, String onlineId) {
        if (NetworkUtil.isActiveNetworkMetered(this) && !PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_DOWNLOAD_ALBUM_OTHER)) {
            return;
        }
        if (!TextUtils.isEmpty(albumName) || !TextUtils.isEmpty(artistName)) {
            AlbumRequestCallback callback = this.mLastAlbumRequestCallback;
            if (callback == null || !callback.isEqual(albumName, artistName)) {
                ImageSearchInfo info = new ImageSearchInfo(albumName, artistName);
                this.mLastAlbumRequestCallback = new AlbumRequestCallback(info, this.mMetaDownloadHandler);
                ImageDownloader.downloadAsync(getApplicationContext(), info, onlineId, this.mLastAlbumRequestCallback);
            }
        }
    }

    public void updateEqualizerBands(int[] levels) {
        if (this.mPlayer instanceof AsyncMusicPlayer) {
            AsyncMusicPlayer player = this.mPlayer;
            if (levels == null) {
                player.updateEqualizerBands(null);
                return;
            }
            int len = levels.length;
            short[] tmp = new short[len];
            for (int i = 0; i < len; i++) {
                tmp[i] = (short) levels[i];
            }
            player.updateEqualizerBands(tmp);
            return;
        }
        Log.w(LOGTAG, "Equalizer is not supported by player " + this.mPlayer);
    }

    void playAll(MusicMeta[] data, int pos, boolean append) {
        if (data != null && data.length != 0) {
            HistoryManager.moveNowplayingOnlineToHistory(this);
            long[] list = PlayerProviderUtils.updateNowplayingList((Context) this, Arrays.asList(data), append);
            if (append) {
                addToCurrentPlaylist(list, 3);
                return;
            }
            playAll(list, pos, false, HistoryManager.LAST_HISTORY_SIZE, true, null);
        }
    }

    public void addToCurrentPlaylist(long[] list, int action) {
        if (list != null) {
            long[] current = getQueue();
            if (current != null) {
                Arrays.sort(current);
                list = SqlUtils.differenceSet(current, list);
            }
            enqueue(list, action);
            Toast.makeText(this, getResources().getQuantityString(C0329R.plurals.NNNtrackstoplaylist, list.length, new Object[]{Integer.valueOf(list.length)}), 0).show();
        }
    }

    public void playAll(long[] list, int position, boolean forceShuffle, int history, boolean directly, String channelName) {
        if (list == null || list.length == 0) {
            Log.e(LOGTAG, "attempt to play empty song list");
            Toast.makeText(this, getString(C0329R.string.emptyplaylist), 0).show();
            return;
        }
        forceShuffle = adjustShuffleMode(forceShuffle, channelName);
        this.mChannelName = channelName;
        long curid = getAudioId();
        int curpos = getQueuePosition();
        if (!directly && position != -1 && curpos == position && curid == list[position] && Arrays.equals(list, getQueue())) {
            play();
            notifyMetaChange(Out.META_CHANGED_TRACK);
            return;
        }
        if (position < 0) {
            position = 0;
        }
        long[] queue = getQueue();
        int pos = getQueuePosition();
        long audioId = getAudioId();
        if (!directly) {
            HistoryManager.moveNowplayingOnlineToHistory(this);
            list = PlayerProviderUtils.updateNowplayingList((Context) this, list, false);
        }
        if (open(list, forceShuffle ? -1 : position)) {
            HistoryManager.shift(this, queue, pos, audioId, PreferenceManager.getDefaultSharedPreferences(this), history);
        }
        play();
    }

    boolean isConnectCompleted() {
        return this.mConnectCompleted;
    }

    void setConnectedDevice(String device) {
        setConnectedDevice(device, false);
    }

    public void setConnectedDevice(String device, boolean forcePause) {
        if (!TextUtils.equals(this.mConnectedDevice, device)) {
            String oldDevice = this.mConnectedDevice;
            this.mConnectedDevice = device;
            this.mConnectCompleted = false;
            Log.i(LOGTAG, "connect to device, new=" + device + ", old=" + oldDevice);
            boolean wasPlaying = isPlaying();
            long pos = position();
            long dur = duration();
            stop(false, true);
            this.mPlayer.release();
            PlayerStub player = null;
            boolean isAirkanPlayer = false;
            if (device != null) {
                player = AirkanPlayer.createPlayer(this, this.mPlayerResponser, this, device);
                if (player != null) {
                    isAirkanPlayer = true;
                } else {
                    Log.e(LOGTAG, "create airkan player failed");
                }
            }
            if (player == null) {
                player = new AsyncMusicPlayer(null, this.mPlayerResponser, this.mPlayerResponser.mRemoteControlInfo);
            }
            this.mWakeLockNeeded = !isAirkanPlayer;
            if (isAirkanPlayer) {
                this.mAudioPauseManager.unregister();
                if (this.mWakeLock.isHeld()) {
                    Log.d(LOGTAG, "create airkan player success, release wakelock after 5s.");
                    this.mMediaplayerHandler.removeMessages(2);
                    this.mMediaplayerHandler.sendEmptyMessageDelayed(2, OnlinePlayStatstics.MIN_LOOP_TIME);
                } else {
                    Log.d(LOGTAG, "create airkan player success, wakelock is already released.");
                }
            } else {
                this.mAudioPauseManager.register();
            }
            this.mPlayer = player;
            openCurrent(false, pos, dur);
            if (wasPlaying) {
                if (forcePause) {
                    notifyChange(Out.STATUS_PLAYSTATE_CHANGED);
                } else {
                    play();
                }
            }
            Intent intent = new Intent(Actions.ACTION_AIRKAN_CONNECTED_DEVICE_CHANGED);
            intent.putExtra(Actions.EXTRA_OLD_DEVICE, oldDevice);
            intent.putExtra(Actions.EXTRA_NEW_DEVICE, device);
            intent.setPackage(MusicApplication.getApplication().getPackageName());
            sendBroadcast(intent);
        }
    }

    public String getConnectedDevice() {
        return this.mConnectedDevice;
    }

    boolean adjustVolume(boolean raise) {
        return this.mPlayer.adjustVolume(raise);
    }

    private void uploadPlayStatusAsync() {
        MusicLog.m395d(LOGTAG, "Upload play status start");
        if (!this.mLastQueueEmpty && this.mPlayPos < this.mPlayList.length) {
            PlayStatus playStatus = null;
            if (PlayerProvider.isOnlineAudio(this.mPlayList[this.mPlayPos])) {
                playStatus = new PlayStatus(getOnlineId(), null, (int) position());
            }
            if (playStatus == null) {
                loop0:
                for (int i = 0; i < this.mPlayListLen - 1; i++) {
                    if (PlayerProvider.isOnlineAudio(this.mPlayList[((this.mPlayPos + i) + 1) % this.mPlayListLen])) {
                        Cursor cursor = SqlUtils.query(MusicApplication.getApplication(), MiuiNowPlayingAudio.EXTERNAL_URI, new String[]{"mi_online_id"}, "_id=?", new String[]{String.valueOf(audioId)}, null, 1);
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    playStatus = new PlayStatus(cursor.getString(0), null, 0);
                                    cursor.close();
                                    break loop0;
                                }
                            } finally {
                                cursor.close();
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (playStatus != null) {
                final PlayStatus uploadStatus = playStatus;
                ThreadManager.postNetworkRequest(new Runnable() {
                    public void run() {
                        Context context = MediaPlaybackService.this.getApplicationContext();
                        CloudEngine engine = MusicEngine.get(context).getCloudEngine();
                        Account account = AccountUtils.getAccount(context);
                        if (account != null) {
                            MusicAuthToken token = AccountUtils.getToken(context, account);
                            if (token != null) {
                                try {
                                    engine.apply(engine.uploadNowplayingStatus(account, token, uploadStatus));
                                    MusicLog.m395d(MediaPlaybackService.LOGTAG, "Upload play status success, status=" + uploadStatus);
                                } catch (IllegalBlockSizeException e) {
                                    e.printStackTrace();
                                } catch (BadPaddingException e2) {
                                    e2.printStackTrace();
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                } catch (MusicCloudServerException e5) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private void uploadPlayQueueAsync() {
        MusicLog.m395d(LOGTAG, "Upload play queue start");
        List<String> queue = Lists.newArrayList();
        for (int i = 0; i < this.mPlayListLen; i++) {
            if (PlayerProvider.isOnlineAudio(this.mPlayList[i])) {
                queue.add(String.valueOf(this.mPlayList[i]));
            }
        }
        boolean lastQueueEmpty = queue.isEmpty();
        if (!this.mLastQueueEmpty || !lastQueueEmpty) {
            this.mLastQueueEmpty = lastQueueEmpty;
            final PlayQueue playQueue = new PlayQueue(queue);
            ThreadManager.postNetworkRequest(new Runnable() {
                public void run() {
                    Context context = MediaPlaybackService.this.getApplicationContext();
                    CloudEngine engine = MusicEngine.get(context).getCloudEngine();
                    Account account = AccountUtils.getAccount(context);
                    if (account != null) {
                        MusicAuthToken token = AccountUtils.getToken(context, account);
                        if (token != null) {
                            try {
                                engine.apply(engine.uploadNowplayingQueue(account, token, playQueue));
                                MusicLog.m395d(MediaPlaybackService.LOGTAG, "Upload play queue success, queue=" + playQueue);
                            } catch (IllegalBlockSizeException e) {
                                e.printStackTrace();
                            } catch (BadPaddingException e2) {
                                e2.printStackTrace();
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            } catch (MusicCloudServerException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    public String getOnlineUrl(Uri uri) {
        if (!"com.miui.player".equals(uri.getAuthority())) {
            return null;
        }
        long audioId = 0;
        try {
            audioId = ContentUris.parseId(uri);
        } catch (NumberFormatException e) {
        }
        if (audioId == 0 || ApplicationHelper.instance().getPlayerHelper().getRemoteMediaInfo(getApplicationContext(), String.valueOf(audioId)) == null) {
            return null;
        }
        return String.format("music://baidu/%s", new Object[]{ApplicationHelper.instance().getPlayerHelper().getRemoteMediaInfo(getApplicationContext(), String.valueOf(audioId)).mId});
    }

    public String getShowLink() {
        return this.mShowLink;
    }
}
