package com.miui.player.service;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.util.Log;
import com.miui.player.PlayerActions.In;
import com.miui.player.asyncplayer.AirkanPlayer.AirkanPlayerCallback;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.Utils;

public class ShakeListener implements SensorEventListener {
    public static final int ACCELATION_BASE = 25;
    public static final float ACCELATION_FACTOR_X = 1.0f;
    public static final float ACCELATION_FACTOR_Y = 0.45f;
    private static final long ACTIVE_INTERVAL = 1000;
    public static final long SHORT_SHAKE = 100;
    public static final String TAG = "com.miui.player.helper.ShakeListener";
    private final AirkanPlayerCallback mCallback;
    private boolean mIsFirstSensorEvent = true;
    private boolean mIsRegister = false;
    private long mLastActiveTime = 0;
    private long mLastTime = 0;
    private float mLastX = 0.0f;
    private float mLastY = 0.0f;
    private SensorManager mSensorManager;
    private final Context mService;
    private int mSoundEffectId = 0;
    private SoundPool mSoundPool = null;

    public ShakeListener(Context context, AirkanPlayerCallback callback) {
        this.mService = context;
        this.mCallback = callback;
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSoundPool = new SoundPool(1, 3, 0);
        try {
            this.mSoundEffectId = this.mSoundPool.load("/system/media/audio/ui/MusicShake.ogg", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!PreferenceCache.getPrefAsBoolean(this.mService, PreferenceCache.PREF_SHAKE)) {
            return;
        }
        if (this.mCallback.isPlaying()) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - this.mLastTime > 100) {
                float currentX = sensorEvent.values[0];
                float currentY = sensorEvent.values[1];
                if (!this.mIsFirstSensorEvent && currentTime - this.mLastActiveTime > 1000) {
                    float deltaX = Math.abs(currentX - this.mLastX);
                    float deltaY = Math.abs(currentY - this.mLastY);
                    int accuracy = 25 - PreferenceCache.getPrefAsInteger(this.mService, PreferenceCache.PREF_SHAKE_DEGREE).intValue();
                    float accelationY = ((float) accuracy) * ACCELATION_FACTOR_Y;
                    if (deltaX > ((float) accuracy) * ACCELATION_FACTOR_X && deltaY > accelationY && Utils.isExternalStorageMounted()) {
                        this.mService.sendBroadcast(new Intent(In.ACTION_NEXT));
                        this.mLastActiveTime = currentTime;
                        if (!(this.mSoundPool == null || this.mSoundEffectId == 0)) {
                            this.mSoundPool.play(this.mSoundEffectId, ACCELATION_FACTOR_X, ACCELATION_FACTOR_X, 0, 0, ACCELATION_FACTOR_X);
                        }
                    }
                }
                this.mLastX = currentX;
                this.mLastY = currentY;
                this.mLastTime = currentTime;
                this.mIsFirstSensorEvent = false;
                return;
            }
            return;
        }
        this.mIsFirstSensorEvent = true;
    }

    public void register() {
        synchronized (this) {
            if (!this.mIsRegister && PreferenceCache.getPrefAsBoolean(this.mService, PreferenceCache.PREF_SHAKE)) {
                this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(1), 2);
                this.mIsRegister = true;
                Log.d(TAG, "register success");
            }
        }
    }

    public void unregister() {
        synchronized (this) {
            if (this.mIsRegister) {
                this.mSensorManager.unregisterListener(this);
                this.mIsRegister = false;
                Log.d(TAG, "unregister success");
            }
        }
    }

    public void onUpdatePref() {
        synchronized (this) {
            if (this.mCallback.isPlaying() && PreferenceCache.getPrefAsBoolean(this.mService, PreferenceCache.PREF_SHAKE)) {
                register();
            } else {
                unregister();
            }
        }
    }

    public void release() {
        this.mSoundPool.release();
        this.mSoundPool = null;
    }
}
