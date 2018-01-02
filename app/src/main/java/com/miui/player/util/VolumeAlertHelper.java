package com.miui.player.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.miui.player.service.MediaPlaybackService;
import com.xiaomi.music.util.MusicLog;

public class VolumeAlertHelper {
    private static final long ALERT_DELAY = 72000000;
    private static final int MSG_ALERT = 0;
    private static final String TAG = VolumeAlertHelper.class.getName();
    private final Handler mHandler = new Handler(this.mService.getMainLooper());
    private BroadcastReceiver mReceiver;
    private final MediaPlaybackService mService;

    class C05331 implements Runnable {
        C05331() {
        }

        public void run() {
            VolumeAlertHelper.this.doAlert();
        }
    }

    class C05342 extends BroadcastReceiver {
        C05342() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            MusicLog.m395d(VolumeAlertHelper.TAG, "action=" + action);
            if ("android.media.VOLUME_CHANGED_ACTION".equals(action) || "android.intent.action.HEADSET_PLUG".equals(action)) {
                VolumeAlertHelper.this.refreshAlert();
            } else if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int state = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0);
                if (state == 2 || state == 0) {
                    VolumeAlertHelper.this.refreshAlert();
                }
            }
        }
    }

    public VolumeAlertHelper(MediaPlaybackService service) {
        this.mService = service;
    }

    private void showAlertDialog() {
        Intent intent = new Intent(Actions.ACTION_VOLUME_ALERT);
        intent.setFlags(268435456);
        this.mService.startActivity(intent);
    }

    private void doAlert() {
        if (needAlert()) {
            MusicLog.m395d(TAG, "doAlert");
            this.mService.pause();
            showAlertDialog();
        }
    }

    public void refreshAlert() {
        MusicLog.m395d(TAG, "refreshAlert");
        if (!needAlert()) {
            this.mHandler.removeMessages(0);
        } else if (!this.mHandler.hasMessages(0)) {
            MusicLog.m395d(TAG, "post alert, delay=72000000");
            this.mHandler.postDelayed(new C05331(), ALERT_DELAY);
        }
    }

    public boolean needAlert() {
        boolean z = true;
        if (!this.mService.isPlaying()) {
            return false;
        }
        boolean isHeadSetOn;
        AudioManager manager = (AudioManager) this.mService.getSystemService("audio");
        if (manager.isWiredHeadsetOn() || manager.isBluetoothA2dpOn()) {
            isHeadSetOn = true;
        } else {
            isHeadSetOn = false;
        }
        if (!isHeadSetOn) {
            return false;
        }
        if (manager.getStreamVolume(3) != manager.getStreamMaxVolume(3)) {
            z = false;
        }
        return z;
    }

    public void registerReceiver() {
        if (this.mReceiver == null) {
            this.mReceiver = new C05342();
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.media.VOLUME_CHANGED_ACTION");
            filter.addAction("android.intent.action.HEADSET_PLUG");
            filter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            this.mService.registerReceiver(this.mReceiver, filter);
        }
    }

    public void unregisterReceiver() {
        if (this.mReceiver != null) {
            this.mService.unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
        }
    }
}
