package com.songbirdnest.util;

import android.media.AudioManager;
import android.os.Handler;

public class IncreaseVolume implements Runnable {
    float mCurValue = 0.0f;
    Handler mHandler;
    AudioManager mManager;
    float mSlope;
    int mVolumeLimit;

    public IncreaseVolume(AudioManager pManager, Handler pHandler, int pLimit) {
        this.mManager = pManager;
        this.mVolumeLimit = pLimit;
        this.mHandler = pHandler;
        this.mSlope = ((float) pLimit) / 10.0f;
    }

    public void run() {
        this.mCurValue += this.mSlope;
        int aVolume = (int) this.mCurValue;
        if (aVolume < this.mVolumeLimit) {
            this.mHandler.postDelayed(this, 200);
        } else {
            aVolume = this.mVolumeLimit;
        }
        this.mManager.setStreamVolume(3, aVolume, 0);
    }
}
