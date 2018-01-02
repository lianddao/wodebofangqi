package com.miui.player.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.provider.PlayerProviderUtils;
import com.miui.player.provider.PlayerStore.MiuiEqualizer;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.view.EqualizerView;
import com.miui.player.ui.view.VerticalSeekBar;
import com.miui.player.ui.view.VerticalSeekBar.OnSeekBarChangeListener;
import com.miui.player.util.AudioEffectConfig;
import java.util.ArrayList;
import java.util.List;

public class EqualizerActivity extends Activity implements DialogCallback {
    private static final int BAND_COUNT = 5;
    public static final String EQUALIZER_PREF_NAME = "miui_equalizer";
    public static final String PREF_EQUALIZER_ENABLED = "equablzier_enabled";
    public static final String PREF_EQUALIZER_ID = "equalizer_id";
    public static final int REMOVE = 2;
    public static final int SAVE_EQUALIZER_CONFIG = 1;
    private static final int[] SEEK_BAR_IDS = new int[]{C0329R.id.progress_eq1, C0329R.id.progress_eq2, C0329R.id.progress_eq3, C0329R.id.progress_eq4, C0329R.id.progress_eq5};
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static final int VOLUME_SEEK_RANGE = 1000;
    private final int[] mBandLevels = new int[5];
    final VerticalSeekBar[] mBandSeekBar = new VerticalSeekBar[5];
    private TextView mConfigText;
    EqualizerView mEqualizerSurface;
    final List<Integer> mIdArr = new ArrayList();
    final List<CharSequence> mNameArr = new ArrayList();
    private BroadcastReceiver mReceiver = new C04311();
    private TextView mSaveText;
    boolean mSpinnerEnable = true;
    boolean mVolumeAdjustBySeekBar = false;
    VerticalSeekBar mVolumeSeekBar;

    class C04311 extends BroadcastReceiver {
        C04311() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(EqualizerActivity.VOLUME_CHANGED_ACTION) && !EqualizerActivity.this.mVolumeAdjustBySeekBar) {
                EqualizerActivity.this.refreshVolume();
            }
        }
    }

    private static class EffectTypeAdapter extends ArrayAdapter<CharSequence> {
        public EffectTypeAdapter(Context context, List<CharSequence> objects) {
            super(context, 17367049, 0, objects);
        }

        public int getCount() {
            return super.getCount() - 1;
        }
    }

    class EqualizerAdjustListener implements OnSeekBarChangeListener {
        EqualizerAdjustListener() {
        }

        public void onProgressChanged(VerticalSeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser && ServiceHelper.sService != null) {
                EqualizerActivity.this.notifyServiceEqualizer(true);
                Object tag = seekBar.getTag();
                if (tag instanceof Integer) {
                    int i = ((Integer) tag).intValue();
                    if (i >= 0 && i < 5) {
                        EqualizerActivity.this.mEqualizerSurface.setBand(i, seekBar.getProgress() + EqualizerActivity.getMinBandLevel(EqualizerActivity.this));
                    }
                }
            }
        }

        public void onStartTrackingTouch(VerticalSeekBar seekBar) {
            if (EqualizerActivity.getEqualizerConfigId(EqualizerActivity.this) != 0) {
                int[] custom = EqualizerActivity.this.getCurrentConfigData();
                PlayerProviderUtils.updateEqualizerConfig(EqualizerActivity.this, 0, custom);
                EqualizerActivity.this.saveEqualizerConfigId(0);
                EqualizerActivity.this.refreshEqualizer(0, custom, false);
            }
        }

        public void onStopTrackingTouch(VerticalSeekBar seekBar) {
            PlayerProviderUtils.updateEqualizerConfig(EqualizerActivity.this, 0, EqualizerActivity.this.getCurrentConfigData());
            EqualizerActivity.this.saveEqualizerConfigId(0);
        }
    }

    class OnEffectTypeClick implements OnClickListener {
        OnEffectTypeClick() {
        }

        public void onClick(View v) {
            int config = EqualizerActivity.getEqualizerConfigId(EqualizerActivity.this);
            int idx = -1;
            if (config != 0) {
                idx = EqualizerActivity.this.mIdArr.indexOf(Integer.valueOf(config));
            }
            new Builder(EqualizerActivity.this).setSingleChoiceItems(new EffectTypeAdapter(EqualizerActivity.this, EqualizerActivity.this.mNameArr), idx, new OnEffectTypeSelected()).create().show();
        }
    }

    class OnEffectTypeSelected implements DialogInterface.OnClickListener {
        OnEffectTypeSelected() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which < EqualizerActivity.this.mIdArr.size()) {
                int newId = ((Integer) EqualizerActivity.this.mIdArr.get(which)).intValue();
                EqualizerActivity.this.saveEqualizerConfigId(newId);
                EqualizerActivity.this.refreshEqualizer(newId, true);
                EqualizerActivity.this.notifyServiceEqualizer(newId != -1);
            }
            dialog.dismiss();
        }
    }

    class OnSaveClickListener implements OnClickListener {
        OnSaveClickListener() {
        }

        public void onClick(View v) {
            OperationDialog.makeEqualizerConfigCreator(EqualizerActivity.this, EqualizerActivity.this, 1, PlayerProviderUtils.codeEqualizerConfig(EqualizerActivity.this.getCurrentConfigData()), new Intent()).show();
        }
    }

    class VolumeAdjustListener implements OnSeekBarChangeListener {
        VolumeAdjustListener() {
        }

        public void onProgressChanged(VerticalSeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                AudioManager am = (AudioManager) EqualizerActivity.this.getSystemService("audio");
                am.setStreamVolume(3, (progress * am.getStreamMaxVolume(3)) / 1000, 0);
            }
        }

        public void onStartTrackingTouch(VerticalSeekBar seekBar) {
            EqualizerActivity.this.mVolumeAdjustBySeekBar = true;
        }

        public void onStopTrackingTouch(VerticalSeekBar seekBar) {
            EqualizerActivity.this.mVolumeAdjustBySeekBar = false;
        }
    }

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(C0329R.layout.equalizer);
        this.mVolumeSeekBar = (VerticalSeekBar) findViewById(C0329R.id.progress_volume);
        this.mVolumeSeekBar.setOnSeekBarChangeListener(new VolumeAdjustListener());
        this.mVolumeSeekBar.setMax(1000);
        EqualizerAdjustListener l = new EqualizerAdjustListener();
        int maxProgress = getMaxBandLevel(this) - getMinBandLevel(this);
        for (int i = 0; i < 5; i++) {
            this.mBandSeekBar[i] = (VerticalSeekBar) findViewById(SEEK_BAR_IDS[i]);
            this.mBandSeekBar[i].setOnSeekBarChangeListener(l);
            this.mBandSeekBar[i].setMax(maxProgress);
            this.mBandSeekBar[i].setTag(Integer.valueOf(i));
        }
        this.mConfigText = (TextView) findViewById(C0329R.id.effect_type);
        this.mConfigText.setOnClickListener(new OnEffectTypeClick());
        this.mSaveText = (TextView) findViewById(C0329R.id.commit_to_save);
        this.mSaveText.setOnClickListener(new OnSaveClickListener());
        this.mEqualizerSurface = (EqualizerView) findViewById(C0329R.id.surface);
        setVolumeControlStream(3);
    }

    protected void onResume() {
        super.onResume();
        updateIdAndNameArr();
        refreshEqualizer();
        refreshVolume();
        registerReceiver(this.mReceiver, new IntentFilter(VOLUME_CHANGED_ACTION));
    }

    protected void onPause() {
        unregisterReceiver(this.mReceiver);
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if (getEqualizerConfigId(this) != -1) {
            menu.add(0, 2, 0, C0329R.string.equalizer_delete);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 2:
                int id = getEqualizerConfigId(this);
                if (id != -1) {
                    if (id != 0) {
                        getContentResolver().delete(MiuiEqualizer.EXTERNAL_URI, "_id=?", new String[]{String.valueOf(id)});
                        updateIdAndNameArr();
                    }
                    saveEqualizerConfigId(-1);
                    refreshEqualizer(-1, true);
                    notifyServiceEqualizer(false);
                    Toast.makeText(this, C0329R.string.equalizer_delete_success, 0).show();
                    break;
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onDialogResult(int requestCode, boolean confirm, Intent intent) {
        switch (requestCode) {
            case 1:
                if (confirm && intent != null) {
                    Uri uri = intent.getData();
                    if (uri != null) {
                        updateIdAndNameArr();
                        int newId = Integer.valueOf(uri.getLastPathSegment()).intValue();
                        saveEqualizerConfigId(newId);
                        refreshEqualizer(newId, false);
                        Toast.makeText(this, C0329R.string.equalizer_save_success, 0).show();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    void updateIdAndNameArr() {
        this.mNameArr.clear();
        this.mIdArr.clear();
        this.mNameArr.add(getString(C0329R.string.no_effect));
        this.mIdArr.add(Integer.valueOf(-1));
        Cursor c = PlayerProviderUtils.queryNormalEqualizer(this);
        if (c != null) {
            int idIdx = c.getColumnIndex("_id");
            int nameIdx = c.getColumnIndex("name");
            while (c.moveToNext()) {
                this.mNameArr.add(c.getString(nameIdx));
                this.mIdArr.add(Integer.valueOf(c.getInt(idIdx)));
            }
            c.close();
        }
        this.mNameArr.add(getString(C0329R.string.custom));
        this.mIdArr.add(Integer.valueOf(0));
    }

    void refreshVolume() {
        AudioManager am = (AudioManager) getSystemService("audio");
        this.mVolumeSeekBar.setProgress((am.getStreamVolume(3) * 1000) / am.getStreamMaxVolume(3));
    }

    void refreshEqualizer() {
        refreshEqualizer(getEqualizerConfigId(this), true);
    }

    void refreshEqualizer(int id, boolean refreshBars) {
        refreshEqualizer(id, PlayerProviderUtils.getEqualizerConfigData(this, id), refreshBars);
    }

    void refreshEqualizer(int id, int[] levels, boolean refreshBars) {
        int selected = this.mIdArr.indexOf(Integer.valueOf(id));
        if (selected < 0) {
            id = -1;
            selected = 0;
        }
        if (selected < this.mNameArr.size()) {
            this.mConfigText.setText((CharSequence) this.mNameArr.get(selected));
        }
        this.mSaveText.setEnabled(id == 0);
        if (refreshBars) {
            for (int i = 0; i < 5; i++) {
                this.mBandSeekBar[i].setProgress(levels[i] - getMinBandLevel(this));
            }
        }
        this.mEqualizerSurface.setBands(levels);
    }

    void saveEqualizerConfigId(int id) {
        Editor editor = getSharedPreferences(EQUALIZER_PREF_NAME, 3).edit();
        editor.putInt(PREF_EQUALIZER_ID, id);
        editor.commit();
    }

    public static int getEqualizerConfigId(Context context) {
        return context.getSharedPreferences(EQUALIZER_PREF_NAME, 3).getInt(PREF_EQUALIZER_ID, -1);
    }

    public static boolean isEqualizerEnabled(Context context) {
        if (!AudioEffectConfig.isAndroidEqualizerEnabled()) {
            return false;
        }
        SharedPreferences sp = context.getSharedPreferences(EQUALIZER_PREF_NAME, 3);
        if (sp.contains(PREF_EQUALIZER_ENABLED)) {
            return sp.getBoolean(PREF_EQUALIZER_ENABLED, true);
        }
        setEqualizerEnabled(context, true);
        return true;
    }

    public static void setEqualizerEnabled(Context context, boolean enabled) {
        SharedPreferences sp = context.getSharedPreferences(EQUALIZER_PREF_NAME, 3);
        if (enabled != sp.getBoolean(PREF_EQUALIZER_ENABLED, !enabled)) {
            int[] levels = null;
            Editor editor = sp.edit();
            editor.putBoolean(PREF_EQUALIZER_ENABLED, enabled);
            if (enabled) {
                int normalId = PlayerProviderUtils.getEqualizerIdByName(context, context.getResources().getStringArray(C0329R.array.equalizer_presents)[0]);
                int lastId = sp.getInt(PREF_EQUALIZER_ID, normalId);
                int newId = -1;
                if (lastId != -1) {
                    levels = PlayerProviderUtils.getEqualizerConfigData(context, lastId, true);
                    if (levels != null) {
                        newId = lastId;
                    } else if (!(lastId == normalId || normalId == -1)) {
                        levels = PlayerProviderUtils.getEqualizerConfigData(context, normalId, true);
                        if (levels != null) {
                            newId = normalId;
                        }
                    }
                }
                editor.putInt(PREF_EQUALIZER_ID, newId);
            }
            editor.commit();
            IMediaPlaybackService service = ServiceHelper.sService;
            if (service != null) {
                try {
                    service.updateEqualizerBands(levels);
                } catch (RemoteException e) {
                }
            }
        }
    }

    void notifyServiceEqualizer(boolean enabled) {
        IMediaPlaybackService service = ServiceHelper.sService;
        if (service != null) {
            if (enabled) {
                for (int i = 0; i < 5; i++) {
                    this.mBandLevels[i] = this.mBandSeekBar[i].getProgress() + getMinBandLevel(this);
                }
                try {
                    service.updateEqualizerBands(this.mBandLevels);
                    return;
                } catch (RemoteException e) {
                    return;
                }
            }
            try {
                service.updateEqualizerBands(null);
            } catch (RemoteException e2) {
            }
        }
    }

    int[] getCurrentConfigData() {
        int[] custom = new int[5];
        for (int i = 0; i < 5; i++) {
            custom[i] = this.mBandSeekBar[i].getProgress() + getMinBandLevel(this);
        }
        return custom;
    }

    public static int getMaxBandLevel(Context context) {
        return EqualizerView.getMaxRank(context) * EqualizerView.SCALE;
    }

    public static int getMinBandLevel(Context context) {
        return EqualizerView.getMinRank(context) * EqualizerView.SCALE;
    }
}
