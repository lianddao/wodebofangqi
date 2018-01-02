package com.miui.player.asyncplayer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.pushservice.PushConstants;
import com.miui.player.airkan.DeviceController;
import com.miui.player.airkan.MilinkManager;
import com.miui.player.airkan.MilinkManager.PlayListener;
import com.miui.player.asyncplayer.PlayerStub.AsyncPrepareListener;
import com.miui.player.asyncplayer.PlayerStub.PrepareInfo;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.Actions;
import com.miui.player.util.ServiceActions.In;
import com.miui.player.util.SqlUtils;
import java.io.FileNotFoundException;
import java.util.List;

public class AirkanPlayer implements PlayerStub {
    private static final float AIRKAN_VOLUME_DELTA = 5.0f;
    static final String TAG = "AirkanPlayer";
    private final PlayListener mAudioListener = new C03331();
    private boolean mBlocking;
    private final AirkanPlayerCallback mCallback;
    private boolean mCallbackFromAirkan = false;
    private final Context mContext;
    private long mCurrentPosition;
    private final String mDevice;
    private final String mDeviceName;
    private long mDuration;
    private boolean mIsConnected = false;
    private final AsyncPrepareListener mListener;
    private long mLocDuration;
    private long mLocPosition;
    private final MilinkManager mMusicManager;
    private String mPath;
    private PrepareInfo mPrepareInfo;

    class C03331 implements PlayListener {
        C03331() {
        }

        public void didConnected() {
            Log.i(AirkanPlayer.TAG, "onConnected");
            AirkanPlayer.this.mIsConnected = true;
            if (AirkanPlayer.this.mCallback != null) {
                AirkanPlayer.this.mCallback.setConnectedDevice(AirkanPlayer.this.mDeviceName, false);
            }
            AirkanPlayer.this.setBlocking(false);
            AirkanPlayer.this.mCallbackFromAirkan = true;
            try {
                AirkanPlayer.this.play();
                Intent intent = new Intent(Actions.ACTION_AIRKAN_CONNECTED_DEVICE_CHANGED);
                intent.setPackage(MusicApplication.getApplication().getPackageName());
                AirkanPlayer.this.mContext.sendBroadcast(intent);
            } finally {
                AirkanPlayer.this.mCallbackFromAirkan = false;
            }
        }

        public void didConnectedFailed() {
            Log.i(AirkanPlayer.TAG, "onConnectedFailed");
            AirkanPlayer.this.mIsConnected = false;
            if (AirkanPlayer.this.mCallback != null) {
                AirkanPlayer.this.mCallback.setConnectedDevice(null, true);
            }
        }

        public void didDisconnected() {
            Log.i(AirkanPlayer.TAG, "onDisconnected");
            if (AirkanPlayer.this.mCallback != null) {
                AirkanPlayer.this.mCallback.setConnectedDevice(null, true);
            }
        }

        public void onLoading() {
            Log.i(AirkanPlayer.TAG, "onLoading");
        }

        public void onPlaying() {
            Log.i(AirkanPlayer.TAG, "onPlaying");
            AirkanPlayer.this.setBlocking(false);
            AirkanPlayer.this.mCallbackFromAirkan = true;
            try {
                if (AirkanPlayer.this.mCallback != null) {
                    AirkanPlayer.this.mCallback.play(false);
                }
                AirkanPlayer.this.mCallbackFromAirkan = false;
            } catch (Throwable th) {
                AirkanPlayer.this.mCallbackFromAirkan = false;
            }
        }

        public void onStopped() {
            Log.i(AirkanPlayer.TAG, "onStopped");
            AirkanPlayer.this.mCallbackFromAirkan = true;
            try {
                if (!(AirkanPlayer.this.mCallback == null || AirkanPlayer.this.mCallback.getAbsolutePath() == null)) {
                    AirkanPlayer.this.mCallback.pause();
                }
                AirkanPlayer.this.mCallbackFromAirkan = false;
            } catch (Throwable th) {
                AirkanPlayer.this.mCallbackFromAirkan = false;
            }
        }

        public void onPaused() {
            Log.i(AirkanPlayer.TAG, "onPaused");
            AirkanPlayer.this.mCallbackFromAirkan = true;
            try {
                if (AirkanPlayer.this.mCallback != null && AirkanPlayer.this.mCallback.isPlaying()) {
                    AirkanPlayer.this.mCallback.pause();
                }
                AirkanPlayer.this.mCallbackFromAirkan = false;
            } catch (Throwable th) {
                AirkanPlayer.this.mCallbackFromAirkan = false;
            }
        }

        public void onRequestNextItem(boolean isAuto) {
            Log.i(AirkanPlayer.TAG, "onRequestNextMusic " + isAuto);
            if (AirkanPlayer.this.mCallback != null) {
                AirkanPlayer.this.mCallback.next(false, isAuto);
            }
        }

        public void onRequestPrevItem(boolean isAuto) {
            Log.i(AirkanPlayer.TAG, "onRequestPrevItem " + isAuto);
            if (AirkanPlayer.this.mCallback != null) {
                AirkanPlayer.this.mCallback.prev(isAuto);
            }
        }

        public void onVolume(int volume) {
        }
    }

    public interface AirkanPlayerCallback {
        String getAbsolutePath();

        String getConnectedDevice();

        String getOnlineUrl(Uri uri);

        boolean isPlaying();

        void next(boolean z, boolean z2);

        void pause();

        void pause(boolean z, boolean z2);

        void play();

        void play(boolean z);

        void prev(boolean z);

        void setConnectedDevice(String str, boolean z);
    }

    private class PlayAsyncTask extends AsyncTask<String, Object, String> {
        private PlayAsyncTask() {
        }

        protected String doInBackground(String... params) {
            return AirkanPlayer.this.translatePath(params[0]);
        }

        protected void onPostExecute(String result) {
            AirkanPlayer.this.playSync(result);
            super.onPostExecute(result);
        }
    }

    public AirkanPlayer(Context c, AirkanPlayerCallback service, AsyncPrepareListener l, String device) {
        this.mContext = c;
        this.mCallback = service;
        this.mMusicManager = MilinkManager.instance();
        this.mMusicManager.init(c);
        this.mMusicManager.setPlayListener(this.mAudioListener);
        this.mListener = l;
        this.mDeviceName = device;
        this.mDevice = DeviceController.instance().getDeviceByName(device);
    }

    public void prepare(String path, PrepareInfo info) {
        this.mPath = null;
        if (path != null) {
            Log.i(TAG, "setMusicURI, url=" + path + ", PrepareInfo=" + info);
            setBlocking(true);
            this.mCurrentPosition = info.mStartPosition;
            this.mDuration = info.mDuration;
            this.mLocPosition = info.mStartPosition;
            this.mLocDuration = info.mDuration;
            this.mPath = path;
            this.mPrepareInfo = info;
            if (this.mIsConnected) {
                play();
            } else {
                Log.v(TAG, "connect to " + this.mDevice);
                this.mMusicManager.connect(this.mDevice, 6000);
            }
        }
        if (this.mPath == null) {
            this.mListener.onPrepareFailed(path, info, new FileNotFoundException(path));
        }
    }

    private void play() {
        new PlayAsyncTask().execute(new String[]{this.mPath});
    }

    private void playSync(String url) {
        double ratio = 0.0d;
        int pos = 0;
        if (this.mDuration > 0 && this.mCurrentPosition > 0) {
            ratio = ((double) this.mCurrentPosition) / ((double) this.mDuration);
            pos = (int) this.mCurrentPosition;
        }
        Log.i(TAG, "play: " + url + " " + this.mPrepareInfo.mTrackName + " " + pos + " / " + this.mDuration);
        this.mMusicManager.play(url, this.mPrepareInfo.mTrackName, pos, ratio);
    }

    public void start() {
        if (!this.mCallbackFromAirkan) {
            Log.i(TAG, "start");
            this.mMusicManager.setPlaybackRate(1);
        }
    }

    public void pause() {
        if (!this.mCallbackFromAirkan) {
            Log.i(TAG, In.CMDPAUSE);
            this.mMusicManager.setPlaybackRate(0);
        }
    }

    public void stop(boolean permanent, boolean stopPrefetch) {
        if (permanent) {
            Log.i(TAG, In.CMDSTOP);
            this.mMusicManager.stopPlay();
        }
    }

    public void release() {
        Log.i(TAG, "release");
        this.mMusicManager.stopPlay();
        this.mMusicManager.disconnect();
    }

    public void seek(long pos) {
        Log.i(TAG, "seek");
        int p = (int) pos;
        this.mMusicManager.setPlaybackProgress(p);
        this.mListener.onSeeked(p);
    }

    public long position() {
        if (this.mBlocking) {
            return this.mCurrentPosition;
        }
        int pos = this.mMusicManager.getPlaybackProgress();
        if (pos > 0) {
            this.mCurrentPosition = (long) pos;
        }
        return this.mCurrentPosition;
    }

    public long duration() {
        if (this.mBlocking) {
            return this.mDuration;
        }
        int dur = this.mMusicManager.getPlaybackDuration();
        if (dur > 0) {
            this.mDuration = (long) dur;
        }
        return this.mDuration;
    }

    public String getPath() {
        return this.mPath;
    }

    public boolean isBlocking() {
        return this.mBlocking;
    }

    public boolean isInitialized() {
        return DeviceController.instance().isOpened();
    }

    public boolean isPrepared() {
        return this.mPath != null;
    }

    public void changeMode(int oldMode, int newMode) {
    }

    public int getAudioSessionId() {
        return 0;
    }

    public float getBufferedPercent() {
        return ShakeListener.ACCELATION_FACTOR_X;
    }

    public void setOnCompletionListener(OnCompletionListener l) {
    }

    public boolean adjustVolume(boolean raise) {
        this.mMusicManager.setVolume((int) ((((float) (raise ? 1 : -1)) * AIRKAN_VOLUME_DELTA) + ((float) this.mMusicManager.getVolume())));
        return true;
    }

    void setBlocking(boolean blocking) {
        this.mBlocking = blocking;
        if (!blocking && this.mListener != null) {
            Log.i(TAG, "setBlocking: " + blocking);
            this.mListener.onPrepareSuccess(this.mPath, this.mPrepareInfo);
        }
    }

    private String translatePath(String path) {
        String url = null;
        Uri uri = Uri.parse(path);
        if (PushConstants.EXTRA_CONTENT.equals(uri.getScheme())) {
            if ("media".equals(uri.getAuthority())) {
                Cursor cursor = SqlUtils.query(MusicApplication.getApplication(), Uri.parse(path), new String[]{"_data"}, null, null, null, 1);
                if (cursor == null) {
                    return null;
                }
                if (cursor.moveToFirst()) {
                    url = cursor.getString(0);
                }
                cursor.close();
                return url;
            }
            String onlineUrl = this.mCallback.getOnlineUrl(uri);
            if (onlineUrl == null) {
                return null;
            }
            Pair<AudioDetail, List<AudioLink>> audio = ApplicationHelper.instance().getPlayerHelper().requestAudioDetail(this.mContext, Uri.parse(onlineUrl).getLastPathSegment());
            if (audio == null || ((List) audio.second).isEmpty()) {
                return path;
            }
            return ((AudioLink) ((List) audio.second).get(0)).mURL;
        } else if ("file".equals(uri.getScheme())) {
            return path;
        } else {
            return null;
        }
    }

    public static AirkanPlayer createPlayer(Context c, AsyncPrepareListener l, AirkanPlayerCallback service, String device) {
        if (device == null) {
            Log.e(TAG, "device is null");
            return null;
        } else if (DeviceController.instance().isOpened()) {
            return new AirkanPlayer(c, service, l, device);
        } else {
            Log.e(TAG, "device is not open");
            return null;
        }
    }
}
