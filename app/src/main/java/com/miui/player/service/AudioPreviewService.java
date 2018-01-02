package com.miui.player.service;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.AsyncQueryHandler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.android.pushservice.PushConstants;
import com.miui.player.C0329R;
import com.miui.player.asyncplayer.PlayerProxy;
import com.miui.player.receiver.MediaButtonIntentReceiver;
import com.miui.player.service.IAudioPreviewService.Stub;
import com.miui.player.util.ServiceActions.OneShot;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;

public class AudioPreviewService extends Service implements OnAudioFocusChangeListener {
    private static final int NOTIFICATION_ID = 101;
    private static final int SERVICE_ID = 100;
    static final String TAG = AudioPreviewService.class.getName();
    private AudioManager mAudioManager;
    private boolean mBinded = false;
    private IBinder mBinder = new ServiceStub(this);
    int mCachedPosition = -1;
    private final OnCompletionListener mCompletionListener = new C04064();
    private final OnErrorListener mErrorListener = new C04053();
    final BroadcastReceiver mMediaButtonReceiver = new C04075();
    boolean mPausedByTransientLossOfFocus = false;
    private PlayerProxy mPlayer = new PlayerProxy();
    boolean mPrepared = false;
    private final OnPreparedListener mPreparedListener = new C04042();
    String mPrimaryText;
    String mSecondaryText;
    private int mStartId = 0;
    boolean mSupposedToBePlaying = false;
    private Uri mUri = null;
    private WakeLock mWakeLock;

    class C04042 implements OnPreparedListener {
        C04042() {
        }

        public void onPrepared(MediaPlayer mp) {
            AudioPreviewService.this.mPrepared = true;
            if (AudioPreviewService.this.mSupposedToBePlaying) {
                AudioPreviewService.this.start();
            }
            AudioPreviewService.this.notifyStatus(OneShot.ACTION_PREPARED);
        }
    }

    class C04053 implements OnErrorListener {
        C04053() {
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            AudioPreviewService.this.mPrepared = false;
            AudioPreviewService.this.notifyStatus(OneShot.ACTION_PLAY_ERROR);
            return false;
        }
    }

    class C04064 implements OnCompletionListener {
        C04064() {
        }

        public void onCompletion(MediaPlayer mp) {
            MediaButtonIntentReceiver.setOneShot(false);
            AudioPreviewService.this.mCachedPosition = AudioPreviewService.this.duration();
            AudioPreviewService.this.mSupposedToBePlaying = false;
            AudioPreviewService.this.notifyStatus(OneShot.ACTION_PLAYSTATE_CHANGED);
            AudioPreviewService.this.gotoBackground();
        }
    }

    class C04075 extends BroadcastReceiver {
        C04075() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (OneShot.ACTION_PLAY.equals(action)) {
                AudioPreviewService.this.start();
            } else if (OneShot.ACTION_PAUSE.equals(action)) {
                AudioPreviewService.this.pause();
            } else if (OneShot.ACTION_TOGGLEPAUSE.equals(action)) {
                if (AudioPreviewService.this.isPlaying()) {
                    AudioPreviewService.this.pause();
                } else {
                    AudioPreviewService.this.start();
                }
            } else if ("android.media.AUDIO_BECOMING_NOISY".equals(action)) {
                AudioPreviewService.this.pause();
            }
        }
    }

    static class ServiceStub extends Stub {
        private final AudioPreviewService mService;

        ServiceStub(AudioPreviewService service) {
            this.mService = service;
        }

        public int duration() throws RemoteException {
            return this.mService.duration();
        }

        public void pause() throws RemoteException {
            this.mService.pause();
        }

        public int position() throws RemoteException {
            return this.mService.position();
        }

        public void prepareAsync(String path) throws RemoteException {
            this.mService.prepareAsync(path);
        }

        public void start() throws RemoteException {
            this.mService.start();
        }

        public void seek(int position) throws RemoteException {
            this.mService.seek(position);
        }

        public boolean isPlaying() {
            return this.mService.isPlaying();
        }

        public boolean isPrepared() {
            return this.mService.isPrepared();
        }

        public String getUriString() {
            return this.mService.getUriString();
        }

        public String getPrimaryText() {
            return this.mService.getPrimaryText();
        }

        public String getSecondaryText() {
            return this.mService.getSecondaryText();
        }
    }

    public void onCreate() {
        super.onCreate();
        this.mPlayer.setOnErrorListener(this.mErrorListener);
        this.mPlayer.setOnPreparedListener(this.mPreparedListener);
        this.mPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mAudioManager = (AudioManager) getSystemService("audio");
        this.mWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, TAG);
        this.mWakeLock.setReferenceCounted(false);
        ServiceHelper.registerMediaButtonReceiver(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(OneShot.ACTION_TOGGLEPAUSE);
        filter.addAction(OneShot.ACTION_PAUSE);
        filter.addAction(OneShot.ACTION_PLAY);
        filter.addAction("android.media.AUDIO_BECOMING_NOISY");
        registerReceiver(this.mMediaButtonReceiver, filter);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        this.mStartId = startId;
        return 2;
    }

    public void onDestroy() {
        this.mPrepared = false;
        this.mSupposedToBePlaying = false;
        this.mAudioManager.abandonAudioFocus(this);
        this.mPlayer.release();
        ServiceHelper.unregisterMediaButtonReceiver(this);
        unregisterReceiver(this.mMediaButtonReceiver);
        MediaButtonIntentReceiver.setOneShot(false);
        if (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        MusicLog.m395d(TAG, "destroy");
        super.onDestroy();
    }

    public int duration() {
        return this.mPlayer.getDuration();
    }

    public int position() {
        return this.mCachedPosition >= 0 ? this.mCachedPosition : this.mPlayer.getCurrentPosition();
    }

    public boolean isPrepared() {
        return this.mPrepared;
    }

    public boolean isPlaying() {
        return this.mSupposedToBePlaying;
    }

    private void resetStatus() {
        this.mWakeLock.acquire();
        MediaButtonIntentReceiver.setOneShot(true);
        this.mAudioManager.requestAudioFocus(this, 3, 1);
        this.mCachedPosition = -1;
        this.mSupposedToBePlaying = true;
    }

    public void prepareAsync(String path) {
        try {
            this.mPrepared = false;
            resetStatus();
            updateMetaInfo(path);
            this.mPlayer.reset();
            this.mPlayer.setDataSourceAndPrepareAsync(this, this.mUri);
            notifyStatus(OneShot.ACTION_METAINFO_CHANGED);
        } catch (IOException e) {
            Log.e(TAG, e.toString());
            Toast.makeText(this, C0329R.string.playback_failed_no_title_by_bad_file, 0).show();
        }
    }

    public void start() {
        resetStatus();
        this.mPlayer.start();
        notifyStatus(OneShot.ACTION_PLAYSTATE_CHANGED);
        updateNotificationBar();
        startForeground(100, new Builder(this).getNotification());
    }

    public void pause() {
        pause(true);
    }

    private void pause(boolean gotoBackground) {
        this.mPlayer.pause();
        this.mSupposedToBePlaying = false;
        notifyStatus(OneShot.ACTION_PLAYSTATE_CHANGED);
        if (gotoBackground) {
            gotoBackground();
        }
    }

    public void seek(int position) {
        this.mPlayer.seekTo(position);
    }

    public void onAudioFocusChange(int focusChange) {
        if (this.mPlayer == null) {
            this.mAudioManager.abandonAudioFocus(this);
            return;
        }
        switch (focusChange) {
            case -3:
            case -2:
                if (isPlaying()) {
                    this.mPausedByTransientLossOfFocus = true;
                    pause(false);
                    return;
                }
                return;
            case -1:
                this.mPausedByTransientLossOfFocus = false;
                pause();
                return;
            case 1:
                if (this.mPausedByTransientLossOfFocus) {
                    this.mPausedByTransientLossOfFocus = false;
                    start();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public String getUriString() {
        return this.mUri != null ? this.mUri.toString() : null;
    }

    public String getPrimaryText() {
        return this.mPrimaryText;
    }

    public String getSecondaryText() {
        return this.mSecondaryText;
    }

    private void updateMetaInfo(String path) {
        this.mPrimaryText = null;
        this.mSecondaryText = null;
        this.mUri = Uri.parse(path);
        String scheme = this.mUri.getScheme();
        AsyncQueryHandler mAsyncQueryHandler = new AsyncQueryHandler(getContentResolver()) {
            protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
                if (cursor == null || !cursor.moveToFirst()) {
                    Log.w(AudioPreviewService.TAG, "empty cursor");
                } else {
                    int titleIdx = cursor.getColumnIndex("title");
                    int artistIdx = cursor.getColumnIndex("artist");
                    int displaynameIdx = cursor.getColumnIndex("_display_name");
                    if (titleIdx >= 0) {
                        AudioPreviewService.this.mPrimaryText = cursor.getString(titleIdx);
                        if (artistIdx >= 0) {
                            AudioPreviewService.this.mSecondaryText = cursor.getString(artistIdx);
                        }
                    } else if (displaynameIdx >= 0) {
                        AudioPreviewService.this.mPrimaryText = cursor.getString(displaynameIdx);
                    } else {
                        Log.w(AudioPreviewService.TAG, "Cursor had no names for us");
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                AudioPreviewService.this.setNames();
            }
        };
        if (scheme.equals(PushConstants.EXTRA_CONTENT)) {
            if (this.mUri.getAuthority() == "media") {
                mAsyncQueryHandler.startQuery(0, null, this.mUri, new String[]{"title", "artist"}, null, null, null);
                return;
            }
            mAsyncQueryHandler.startQuery(0, null, this.mUri, null, null, null, null);
        } else if (scheme.equals("file")) {
            String file = this.mUri.getPath();
            mAsyncQueryHandler.startQuery(0, null, Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "title", "artist"}, "_data=?", new String[]{file}, null);
        } else {
            setNames();
        }
    }

    void setNames() {
        if (TextUtils.isEmpty(this.mPrimaryText)) {
            this.mPrimaryText = this.mUri.getLastPathSegment();
        }
        if (TextUtils.isEmpty(this.mSecondaryText)) {
            this.mSecondaryText = null;
        }
        notifyStatus(OneShot.ACTION_METAINFO_CHANGED);
        updateNotificationBar();
        if (isPlaying()) {
            startForeground(100, new Builder(this).getNotification());
        }
    }

    private void updateNotificationBar() {
        if (isPlaying()) {
            Builder builder = new Builder(this);
            builder.setTicker(this.mPrimaryText);
            builder.setContentTitle(this.mPrimaryText);
            builder.setContentText(this.mSecondaryText);
            builder.setSmallIcon(C0329R.drawable.app_music);
            builder.setOngoing(true);
            Intent intent = new Intent();
            intent.setAction(OneShot.ACTION_OPEN_UI);
            builder.setContentIntent(PendingIntent.getActivity(this, 0, intent, 0));
            enqueueNotification(101, builder.getNotification());
            return;
        }
        ((NotificationManager) getSystemService("notification")).cancel(101);
    }

    void notifyStatus(String action) {
        if (this.mUri != null) {
            sendBroadcast(new Intent(action));
        }
    }

    public IBinder onBind(Intent intent) {
        this.mBinded = true;
        return this.mBinder;
    }

    public void onRebind(Intent intent) {
        this.mBinded = true;
    }

    public boolean onUnbind(Intent intent) {
        this.mBinded = false;
        if (!isPlaying()) {
            stopSelf(this.mStartId);
        }
        return true;
    }

    void gotoBackground() {
        stopForeground(true);
        updateNotificationBar();
        if (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        if (!this.mBinded) {
            stopSelf(this.mStartId);
        }
    }

    private void enqueueNotification(int id, Notification notification) {
        ((NotificationManager) getSystemService("notification")).notify(id, notification);
    }
}
