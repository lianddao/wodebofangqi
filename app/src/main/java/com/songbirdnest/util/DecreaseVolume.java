package com.songbirdnest.util;

import android.media.AudioManager;
import android.os.Handler;
import android.os.RemoteException;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;

public class DecreaseVolume implements Runnable {
    float mCurValue = ((float) this.mManager.getStreamVolume(3));
    Handler mHandler;
    AudioManager mManager;
    SongbirdMediaService mMediaService;
    float mSlope = (this.mCurValue / 10.0f);

    public DecreaseVolume(AudioManager pManager, Handler pHandler, SongbirdMediaService pService) {
        this.mManager = pManager;
        this.mHandler = pHandler;
        this.mMediaService = pService;
    }

    public void run() {
        this.mCurValue -= this.mSlope;
        int aVolume = (int) this.mCurValue;
        if (aVolume <= 0) {
            try {
                this.mMediaService.pause();
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        this.mManager.setStreamVolume(3, aVolume, 0);
        this.mHandler.postDelayed(this, 200);
    }
}
