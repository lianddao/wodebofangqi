package com.miui.player.service;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.miui.player.asyncplayer.AirkanPlayer.AirkanPlayerCallback;
import com.miui.player.ui.base.ApplicationHelper;

public class AutoPauseManager {
    private static final int MSG_CALLSTATECHANGE = 1;
    private static final int MSG_FOCUSCHANGE = 2;
    static final String TAG = "AutoPauseManager";
    private OnAudioFocusChangeListener mAudioFocusListener = new C04103();
    private final AirkanPlayerCallback mCallback;
    private final Context mContext;
    private final Handler mHandler = new C04081();
    private final PhoneStateListener mPhoneStateListener = new C04092();
    private boolean mRegitsted = false;
    private final AutoPauseState mState = new AutoPauseState();

    class C04081 extends Handler {
        C04081() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (msg.arg1 == 0) {
                        Log.v(AutoPauseManager.TAG, "CallState: goto idle");
                        if (AutoPauseManager.this.mState.remove(AutoPauseState.TYPE_CALL_STATE)) {
                            AutoPauseManager.this.mCallback.play();
                            return;
                        } else if (AutoPauseManager.this.mCallback.isPlaying()) {
                            ((AudioManager) AutoPauseManager.this.mContext.getSystemService("audio")).requestAudioFocus(AutoPauseManager.this.mAudioFocusListener, 3, 1);
                            return;
                        } else {
                            return;
                        }
                    }
                    Log.v(AutoPauseManager.TAG, "CallState: leave idle");
                    if (AutoPauseManager.this.mCallback.isPlaying() && AutoPauseManager.this.needPauseByPhone((String) msg.obj)) {
                        AutoPauseManager.this.mCallback.pause();
                        AutoPauseManager.this.mState.add(AutoPauseState.TYPE_CALL_STATE);
                        return;
                    }
                    return;
                case 2:
                    switch (msg.arg1) {
                        case -3:
                        case -2:
                            Log.v(AutoPauseManager.TAG, "AudioFocus: received " + msg.arg1);
                            if (AutoPauseManager.this.mCallback.isPlaying()) {
                                AutoPauseManager.this.mCallback.pause(true, false);
                                AutoPauseManager.this.mState.add(AutoPauseState.TYPE_AUDIO_FOCUS);
                                return;
                            }
                            return;
                        case -1:
                            Log.v(AutoPauseManager.TAG, "AudioFocus: received AUDIOFOCUS_LOSS");
                            if (AutoPauseManager.this.mCallback.isPlaying()) {
                                AutoPauseManager.this.mCallback.pause();
                                return;
                            }
                            return;
                        case 1:
                            Log.v(AutoPauseManager.TAG, "AudioFocus: received AUDIOFOCUS_GAIN");
                            if (AutoPauseManager.this.mState.remove(AutoPauseState.TYPE_AUDIO_FOCUS)) {
                                AutoPauseManager.this.mCallback.play();
                                return;
                            }
                            return;
                        default:
                            Log.e(AutoPauseManager.TAG, "Unknown audio focus change code");
                            return;
                    }
                default:
                    return;
            }
        }
    }

    class C04092 extends PhoneStateListener {
        C04092() {
        }

        public void onCallStateChanged(int state, String incomingNumber) {
            AutoPauseManager.this.mHandler.obtainMessage(1, state, 0, incomingNumber).sendToTarget();
        }
    }

    class C04103 implements OnAudioFocusChangeListener {
        C04103() {
        }

        public void onAudioFocusChange(int focusChange) {
            AutoPauseManager.this.mHandler.obtainMessage(2, focusChange, 0).sendToTarget();
        }
    }

    private static class AutoPauseState {
        public static int TYPE_AUDIO_FOCUS = 1;
        public static int TYPE_CALL_STATE = 2;
        private static int TYPE_MASK = 3;
        private int mState = 0;

        public void add(int type) {
            this.mState |= TYPE_MASK & type;
        }

        public boolean remove(int type) {
            if (this.mState == 0) {
                return false;
            }
            this.mState &= (TYPE_MASK & type) ^ -1;
            if (this.mState == 0) {
                return true;
            }
            return false;
        }

        public void clear() {
            this.mState = 0;
        }

        public boolean isEffect() {
            return this.mState != 0;
        }
    }

    public AutoPauseManager(Context context, AirkanPlayerCallback callback) {
        this.mContext = context;
        this.mCallback = callback;
    }

    public void register() {
        if (!this.mRegitsted) {
            this.mRegitsted = true;
            ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 32);
        }
    }

    public void unregister() {
        if (this.mRegitsted) {
            this.mRegitsted = false;
            ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 0);
            ((AudioManager) this.mContext.getSystemService("audio")).abandonAudioFocus(this.mAudioFocusListener);
            this.mState.clear();
        }
    }

    public void onStart() {
        if (this.mRegitsted) {
            ((AudioManager) this.mContext.getSystemService("audio")).requestAudioFocus(this.mAudioFocusListener, 3, 1);
        }
    }

    public void onPause(boolean abandonAudioFocus) {
        if (this.mRegitsted) {
            this.mState.clear();
            if (abandonAudioFocus) {
                ((AudioManager) this.mContext.getSystemService("audio")).abandonAudioFocus(this.mAudioFocusListener);
            }
        }
    }

    public boolean isEffect() {
        return this.mState.isEffect();
    }

    private boolean needPauseByPhone(String number) {
        return ApplicationHelper.instance().getDeviceCompat().shouldPauseWhenInComingCall(this.mContext, number);
    }
}
