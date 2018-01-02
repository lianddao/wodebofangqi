package com.songbirdnest.mediaplayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;

public class MediaButtonReceiver {
    private static final int DEFAULT_HEADSETHOOK_DOWNTIME = 5000;
    private static final int DOUBLE_CLICK = 2;
    private static final int MSG_DEFERRED_KEY = 4096;
    private static final int MSG_DELAY = 100;
    private static final int SEEK_INCREMENT = 1000;
    private static final int SINGLE_CLICK = 1;
    private static final int TRIPLE_CLICK = 3;
    private SongbirdApplication mApplication = null;
    private Handler mHandler = new C01121();
    private Runnable mHeadsetHookClickRunnable = new C01132();
    private int mHeadsetHookKeyCount = 0;
    private SongbirdMediaService mService = null;
    private TelephonyManager mTelephonyManager = null;

    class C01121 extends Handler {
        C01121() {
        }

        public void handleMessage(Message aMessage) {
            MediaButtonReceiver.this.mService = MediaButtonReceiver.this.mApplication.getMediaService();
            switch (aMessage.what) {
                case 4096:
                    if (MediaButtonReceiver.this.mService == null) {
                        MediaButtonReceiver.this.mHandler.sendMessageDelayed(Message.obtain(MediaButtonReceiver.this.mHandler, 4096, aMessage.obj), 100);
                        return;
                    }
                    MediaButtonReceiver.this.onReceive(MediaButtonReceiver.this.mApplication, (Intent) aMessage.obj);
                    return;
                default:
                    return;
            }
        }
    }

    class C01132 implements Runnable {
        C01132() {
        }

        public void run() {
            switch (MediaButtonReceiver.this.mHeadsetHookKeyCount) {
                case 1:
                    try {
                        if (!MediaButtonReceiver.this.mService.isPlaying()) {
                            MediaButtonReceiver.this.mService.play();
                            break;
                        } else {
                            MediaButtonReceiver.this.mService.pause();
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                case 2:
                    try {
                        MediaButtonReceiver.this.mService.next();
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        break;
                    }
                case 3:
                    try {
                        MediaButtonReceiver.this.mService.prev();
                        break;
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        break;
                    }
            }
            MediaButtonReceiver.this.mHeadsetHookKeyCount = 0;
        }
    }

    public boolean onReceive(Context aContext, Intent aIntent) {
        String action = aIntent.getAction();
        if (!action.equals("android.intent.action.MEDIA_BUTTON")) {
            return false;
        }
        if (!aContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getBoolean(PrefKeys.DEFAULT_MEDIA_BUTTON_RECEIVER, true)) {
            return false;
        }
        if (this.mTelephonyManager == null) {
            this.mTelephonyManager = (TelephonyManager) aContext.getSystemService("phone");
        }
        int callState = this.mTelephonyManager.getCallState();
        KeyEvent keyEvent = (KeyEvent) aIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (this.mApplication == null) {
            this.mApplication = (SongbirdApplication) aContext.getApplicationContext();
        }
        if (this.mService == null) {
            this.mService = this.mApplication.getMediaService();
            if (this.mService == null && action.equals("android.intent.action.MEDIA_BUTTON") && callState == 0) {
                this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 4096, aIntent), 100);
                return true;
            }
        }
        boolean hasHandledIntent = false;
        int keyCode = keyEvent.getKeyCode();
        int keyRepeatCount = keyEvent.getRepeatCount();
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int position;
        switch (keyCode) {
            case 79:
                if (callState == 2 || callState == 1) {
                    return false;
                }
                if (keyRepeatCount == 0) {
                    this.mHandler.removeCallbacks(this.mHeadsetHookClickRunnable);
                    this.mHeadsetHookKeyCount++;
                    this.mHandler.postDelayed(this.mHeadsetHookClickRunnable, 666);
                } else if (SystemClock.uptimeMillis() - keyEvent.getDownTime() > 5000) {
                    Intent i = new Intent("android.intent.action.MAIN");
                    i.setComponent(new ComponentName("com.songbirdnest.mediaplayer", "com.songbirdnest.mediaplayer.Songbird"));
                    i.setFlags(335544320);
                    aContext.startActivity(i);
                }
                return true;
            case 85:
                try {
                    if (this.mService.isPlaying()) {
                        this.mService.pause();
                    } else {
                        this.mService.play();
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 86:
                try {
                    if (this.mService.isPlaying()) {
                        this.mService.pause();
                    }
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            case 87:
                try {
                    if (this.mService.isPlaying() || this.mService.isPaused()) {
                        this.mService.next();
                    }
                    return true;
                } catch (Exception e22) {
                    e22.printStackTrace();
                    return false;
                }
            case 88:
                try {
                    if (this.mService.isPlaying() || this.mService.isPaused()) {
                        this.mService.prev();
                    }
                    hasHandledIntent = true;
                    break;
                } catch (Exception e222) {
                    e222.printStackTrace();
                    break;
                }
            case 89:
                try {
                    if (this.mService.isPlaying()) {
                        position = this.mService.position() - 1000;
                        if (position < 0) {
                            position = 0;
                        }
                        this.mService.seek(position);
                    }
                    return true;
                } catch (Exception e2222) {
                    e2222.printStackTrace();
                    return false;
                }
            case 90:
                break;
            case 126:
                try {
                    this.mService.play();
                    return true;
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                    return false;
                }
            case 127:
                try {
                    if (!this.mService.isPlaying()) {
                        return false;
                    }
                    this.mService.pause();
                    return true;
                } catch (Exception ex2) {
                    ex2.printStackTrace();
                    return false;
                }
            default:
                Log.i("MediaButtonReceiver", "Didn't handle this key: " + keyEvent.getKeyCode());
                return false;
        }
        Log.i("KEYCODE_FFWD", "FFWDING!");
        try {
            if (this.mService.isPlaying()) {
                int duration = this.mService.duration();
                position = this.mService.position() + 1000;
                if (position > duration) {
                    position = duration;
                }
                this.mService.seek(position);
            }
            return true;
        } catch (Exception e22222) {
            e22222.printStackTrace();
            return hasHandledIntent;
        }
    }
}
