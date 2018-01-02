package com.miui.player.airkan;

import android.content.Context;
import android.util.Log;
import com.milink.api.v1.MilinkClientManager;
import com.milink.api.v1.MilinkClientManagerDelegate;
import com.milink.api.v1.type.DeviceType;
import com.milink.api.v1.type.ErrorCode;
import com.milink.api.v1.type.MediaType;
import miui.provider.ExtraSettings.System;

public class MilinkManager {
    private static final String TAG = "MilinkManager";
    private static final MilinkManager sInstance = new MilinkManager();
    private Context mContext;
    MilinkClientManagerDelegate mDelegate = new C03321();
    private DeviceListener mDeviceListener;
    private MilinkClientManager mMusicManager;
    private PlayListener mPlayListener;

    public interface DeviceListener {
        void onClose();

        void onDeviceFound(String str, String str2, DeviceType deviceType);

        void onDeviceLost(String str);

        void onOpen();
    }

    class C03321 implements MilinkClientManagerDelegate {
        C03321() {
        }

        public void onOpen() {
            Log.i(MilinkManager.TAG, "milink opened");
            if (MilinkManager.this.mDeviceListener != null) {
                MilinkManager.this.mDeviceListener.onOpen();
            }
        }

        public void onClose() {
            Log.i(MilinkManager.TAG, "milink closed");
            if (MilinkManager.this.mDeviceListener != null) {
                MilinkManager.this.mDeviceListener.onClose();
            }
        }

        public void onDeviceFound(String deviceId, String name, DeviceType type) {
            if (MilinkManager.this.mDeviceListener != null) {
                MilinkManager.this.mDeviceListener.onDeviceFound(deviceId, name, type);
            }
        }

        public void onDeviceLost(String deviceId) {
            if (MilinkManager.this.mDeviceListener != null) {
                MilinkManager.this.mDeviceListener.onDeviceLost(deviceId);
            }
        }

        public void onConnected() {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.didConnected();
            }
        }

        public void onConnectedFailed(ErrorCode errorCode) {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.didConnectedFailed();
            }
        }

        public void onDisconnected() {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.didDisconnected();
            }
        }

        public void onLoading() {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.onLoading();
            }
        }

        public void onPlaying() {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.onPlaying();
            }
        }

        public void onStopped() {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.onStopped();
            }
        }

        public void onPaused() {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.onPaused();
            }
        }

        public void onVolume(int volume) {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.onVolume(volume);
            }
        }

        public void onNextAudio(boolean isAuto) {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.onRequestNextItem(isAuto);
            }
        }

        public void onPrevAudio(boolean isAuto) {
            if (MilinkManager.this.mPlayListener != null) {
                MilinkManager.this.mPlayListener.onRequestPrevItem(isAuto);
            }
        }
    }

    public interface PlayListener {
        void didConnected();

        void didConnectedFailed();

        void didDisconnected();

        void onLoading();

        void onPaused();

        void onPlaying();

        void onRequestNextItem(boolean z);

        void onRequestPrevItem(boolean z);

        void onStopped();

        void onVolume(int i);
    }

    public static MilinkManager instance() {
        return sInstance;
    }

    public void setPlayListener(PlayListener playListener) {
        this.mPlayListener = playListener;
    }

    public void setDeviceListener(DeviceListener deviceListener) {
        this.mDeviceListener = deviceListener;
    }

    public synchronized void init(Context context) {
        if (this.mContext == null) {
            this.mContext = context;
            String deviceName = System.getDeviceName(this.mContext);
            if (deviceName == null || deviceName.isEmpty()) {
                deviceName = "XiaoMi";
            }
            this.mMusicManager = new MilinkClientManager(this.mContext);
            this.mMusicManager.setDeviceName(deviceName);
            this.mMusicManager.setDelegate(this.mDelegate);
        }
    }

    public void open() {
        this.mMusicManager.open();
    }

    public void close() {
        this.mMusicManager.close();
    }

    public void connect(String deviceId, int timeout) {
        this.mMusicManager.connect(deviceId, timeout);
    }

    public void disconnect() {
        this.mMusicManager.disconnect();
    }

    public void play(String url, String title, int iPosition, double dPosition) {
        this.mMusicManager.startPlay(url, title, iPosition, dPosition, MediaType.Audio);
    }

    public void stopPlay() {
        this.mMusicManager.stopPlay();
    }

    public void setPlaybackRate(int rate) {
        this.mMusicManager.setPlaybackRate(rate);
    }

    public int getPlaybackRate() {
        return this.mMusicManager.getPlaybackRate();
    }

    public void setPlaybackProgress(int position) {
        this.mMusicManager.setPlaybackProgress(position);
    }

    public int getPlaybackDuration() {
        return this.mMusicManager.getPlaybackDuration();
    }

    public int getPlaybackProgress() {
        return this.mMusicManager.getPlaybackProgress();
    }

    public void setVolume(int volume) {
        this.mMusicManager.setVolume(volume);
    }

    public int getVolume() {
        return this.mMusicManager.getVolume();
    }
}
