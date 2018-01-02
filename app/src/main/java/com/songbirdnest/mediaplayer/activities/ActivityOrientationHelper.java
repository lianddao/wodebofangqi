package com.songbirdnest.mediaplayer.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import com.songbirdnest.mediaplayer.PrefKeys;

public class ActivityOrientationHelper {
    static final int FULL_SENSOR = 1;
    static final int PORTRAIT_LOCK = 2;
    Activity mActivity;
    final boolean mDefOrientation;
    OnSharedPreferenceChangeListener mPrefListener = new C01291();
    boolean mPrefListenerRegistered = false;

    class C01291 implements OnSharedPreferenceChangeListener {
        C01291() {
        }

        public void onSharedPreferenceChanged(SharedPreferences aSharedPreferences, String aKey) {
            if (aKey.equals(PrefKeys.ENABLE_FULL_SENSOR)) {
                ActivityOrientationHelper.this.setOrientationAction(aSharedPreferences);
            }
        }
    }

    public ActivityOrientationHelper(Activity iActivity) {
        boolean z = false;
        this.mActivity = iActivity;
        if ((this.mActivity.getResources().getConfiguration().screenLayout & 15) != 4) {
            z = true;
        }
        this.mDefOrientation = z;
    }

    public void onResume() {
        if (!this.mPrefListenerRegistered) {
            SharedPreferences pref = this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
            setOrientationAction(pref);
            pref.registerOnSharedPreferenceChangeListener(this.mPrefListener);
            this.mPrefListenerRegistered = true;
        }
    }

    private int getMask(SharedPreferences aPref) {
        int aMaskPass = 0;
        if (aPref.getBoolean(PrefKeys.ENABLE_FULL_SENSOR, false)) {
            aMaskPass = 0 | 1;
        }
        if (aPref.getBoolean(PrefKeys.LOCK_PORTRAIT, this.mDefOrientation)) {
            return aMaskPass | 2;
        }
        return aMaskPass;
    }

    public void resetOrientation() {
        setOrientationAction(this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0));
    }

    private void setOrientationAction(SharedPreferences aPref) {
        boolean aKeyboardShown = false;
        int aMaskedValue = getMask(aPref);
        if ((aMaskedValue & 1) != 1 || VERSION.SDK_INT < 9) {
            Intent i = this.mActivity.registerReceiver(null, new IntentFilter("android.intent.action.DOCK_EVENT"));
            int state = 0;
            if (i != null) {
                state = i.getIntExtra("android.intent.extra.DOCK_STATE", 0);
            }
            if (this.mActivity.getResources().getConfiguration().hardKeyboardHidden == 1) {
                aKeyboardShown = true;
            }
            if (state == 0 && !aKeyboardShown && (aMaskedValue & 2) == 2) {
                this.mActivity.setRequestedOrientation(1);
                return;
            } else {
                this.mActivity.setRequestedOrientation(4);
                return;
            }
        }
        this.mActivity.setRequestedOrientation(10);
    }

    public void onPause() {
        this.mActivity.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).unregisterOnSharedPreferenceChangeListener(this.mPrefListener);
        this.mPrefListenerRegistered = false;
    }
}
