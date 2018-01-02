package com.miui.player.effect.dirac;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import com.miui.player.C0329R;
import com.miui.player.ui.view.GridPreference;
import com.miui.player.ui.view.GridPreference.OnItemClickListener;
import miui.os.Build;

public class DiracSettings extends PreferenceActivity implements OnPreferenceClickListener, OnItemClickListener {
    private static final String KEY_DIRAC_CONTROL = "mi_effect_control";
    private static final String KEY_EQUALIZER_CATEGORY = "equalizer_category";
    private static final String KEY_HEADSETS_GRID = "headsets_grid";
    private static final String KEY_MODE_CATEGORY = "mode_category";
    static final String TAG = DiracSettings.class.getName();
    private DiracHeadsetAdapter mAdapter;
    private DiracUtils mDiracUtil;
    private final BroadcastReceiver mHeadSetReceiver = new C03481();
    private Preference mPreEqualizer;
    private GridPreference mPreHeadsetsGird;
    private PreferenceCategory mPreModeCategory;
    private CheckBoxPreference mPrefDiracControl;

    class C03481 extends BroadcastReceiver {
        private static final int REFRESH_DELAY = 2000;
        private final Handler mHandler = new Handler();
        private final Runnable mRunnable = new C03471();

        class C03471 implements Runnable {
            C03471() {
            }

            public void run() {
                if (DiracSettings.this.isResumed()) {
                    DiracSettings.this.refreshEnabled();
                }
            }
        }

        C03481() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                int state = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0);
                if (state == 2 || state == 0) {
                    this.mHandler.removeCallbacks(this.mRunnable);
                    this.mHandler.postDelayed(this.mRunnable, 2000);
                    return;
                }
                return;
            }
            DiracSettings.this.refreshEnabled();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(C0329R.xml.dirac_settings);
        this.mDiracUtil = DiracUtils.newInstance();
        this.mDiracUtil.initialize();
        this.mPrefDiracControl = (CheckBoxPreference) findPreference(KEY_DIRAC_CONTROL);
        this.mPrefDiracControl.setOnPreferenceClickListener(this);
        this.mPreModeCategory = (PreferenceCategory) findPreference(KEY_MODE_CATEGORY);
        this.mPreHeadsetsGird = (GridPreference) findPreference(KEY_HEADSETS_GRID);
        this.mAdapter = new DiracHeadsetAdapter(this.mDiracUtil);
        this.mPreHeadsetsGird.setAdapter(this.mAdapter);
        this.mPreHeadsetsGird.setOnItemClickListener(this);
        this.mPreEqualizer = findPreference(KEY_EQUALIZER_CATEGORY);
    }

    private boolean equalizerEnable() {
        if (Build.IS_MI2A || Build.IS_MITHREE || Build.IS_HONGMI_TWO) {
            return true;
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        this.mDiracUtil.initialize();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.HEADSET_PLUG");
        filter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        registerReceiver(this.mHeadSetReceiver, filter);
        refresh();
        refreshEnabled();
    }

    public void onPause() {
        unregisterReceiver(this.mHeadSetReceiver);
        this.mDiracUtil.release();
        super.onPause();
    }

    private void refresh() {
        refreshDiracControl();
        refreshHeadsetType();
    }

    private void refreshHeadsetType() {
        int index = this.mAdapter.getHeadsetPositon(this.mDiracUtil.getHeadsetType(this));
        if (index != -1) {
            this.mPreHeadsetsGird.setChildSelected(index);
        }
    }

    public boolean onPreferenceClick(Preference preference) {
        if (preference == this.mPrefDiracControl) {
            this.mDiracUtil.setEnabled(this, this.mPrefDiracControl.isChecked());
        }
        refresh();
        return true;
    }

    private void refreshEnabled() {
        boolean isHeadSetOn;
        boolean gridEnabled;
        AudioManager manager = (AudioManager) getSystemService("audio");
        if (manager.isWiredHeadsetOn() || manager.isBluetoothA2dpOn()) {
            isHeadSetOn = true;
        } else {
            isHeadSetOn = false;
        }
        this.mPrefDiracControl.setEnabled(isHeadSetOn);
        if (isHeadSetOn && this.mPrefDiracControl.isChecked()) {
            gridEnabled = true;
        } else {
            gridEnabled = false;
        }
        this.mPreModeCategory.setEnabled(gridEnabled);
        this.mPreHeadsetsGird.setEnabled(gridEnabled);
        this.mPreEqualizer.setEnabled(isHeadSetOn);
    }

    private void refreshDiracControl() {
        boolean isEnabled = this.mDiracUtil.isEnabled(this);
        this.mPrefDiracControl.setChecked(isEnabled);
        this.mPreModeCategory.setEnabled(isEnabled);
        this.mPreHeadsetsGird.setEnabled(isEnabled);
    }

    public void onItemClick(GridPreference pref, int position) {
        if (this.mAdapter.getHeadsetType(position) != this.mDiracUtil.getHeadsetType(this)) {
            this.mDiracUtil.setHeadsetType(pref.getContext(), this.mAdapter.getHeadsetType(position));
            refresh();
        }
    }
}
