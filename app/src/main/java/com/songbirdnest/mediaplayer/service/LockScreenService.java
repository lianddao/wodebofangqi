package com.songbirdnest.mediaplayer.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.songbirdnest.mediaplayer.appwidget.LockScreenWidget;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService.Stub;

public class LockScreenService extends Service {
    static final int SCREEN_STATE_OFF = 0;
    static final int SCREEN_STATE_ON = 1;
    static final int SCREEN_STATE_UNKNOWN = -1;
    private boolean mConnected;
    private ServiceConnection mConnection = null;
    private int mLastScreenState = -1;
    private BroadcastReceiver mScreenStateReceiver = new C01891();
    private IntentFilter mScreenStateReceiverFilter = null;
    private SongbirdMediaService mService = null;
    private boolean mShouldShowWidget = false;

    class C01891 extends BroadcastReceiver {
        C01891() {
        }

        public void onReceive(Context aContext, Intent aIntent) {
            String action = aIntent.getAction();
            if (action.equals("android.intent.action.SCREEN_ON") || action.equals("android.intent.action.SCREEN_OFF")) {
                Log.i("LockScreenService", "Received Action -- " + action);
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    if (LockScreenService.this.mLastScreenState == 0) {
                        LockScreenService.this.mShouldShowWidget = true;
                    }
                    LockScreenService.this.mLastScreenState = 1;
                } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                    LockScreenService.this.mLastScreenState = 0;
                    LockScreenService.this.mShouldShowWidget = false;
                }
                if (!LockScreenService.this.isMediaServicePlaying()) {
                    LockScreenService.this.mShouldShowWidget = false;
                }
                if (LockScreenService.this.mShouldShowWidget) {
                    Intent i = new Intent(LockScreenService.this, LockScreenWidget.class);
                    i.addFlags(268500992);
                    LockScreenService.this.startActivity(i);
                }
            }
        }
    }

    class C01902 implements ServiceConnection {
        C01902() {
        }

        public void onServiceConnected(ComponentName aName, IBinder aService) {
            LockScreenService.this.mService = Stub.asInterface(aService);
            LockScreenService.this.mConnected = true;
        }

        public void onServiceDisconnected(ComponentName name) {
            LockScreenService.this.mService = null;
            LockScreenService.this.mConnected = false;
        }
    }

    public void onCreate() {
        bindMediaService(this);
        this.mScreenStateReceiverFilter = new IntentFilter();
        this.mScreenStateReceiverFilter.addAction("android.intent.action.SCREEN_ON");
        this.mScreenStateReceiverFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.mScreenStateReceiver, this.mScreenStateReceiverFilter);
    }

    public void onDestroy() {
        unregisterReceiver(this.mScreenStateReceiver);
        unbindMediaService(this);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void bindMediaService(Context aContext) {
        if (!this.mConnected) {
            if (this.mConnection == null) {
                this.mConnection = new C01902();
            }
            Intent i = new Intent(aContext, SongbirdMedia.class);
            aContext.startService(i);
            aContext.bindService(i, this.mConnection, 1);
        }
    }

    private void unbindMediaService(Context aContext) {
        if (this.mConnected) {
            aContext.unbindService(this.mConnection);
            this.mConnected = false;
        }
    }

    private boolean isMediaServicePlaying() {
        if (this.mService == null) {
            return false;
        }
        boolean isPlaying;
        try {
            isPlaying = this.mService.isPlaying() && !this.mService.isPaused();
        } catch (RemoteException e) {
            isPlaying = false;
        }
        return isPlaying;
    }
}
