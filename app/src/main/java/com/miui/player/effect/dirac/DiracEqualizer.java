package com.miui.player.effect.dirac;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.collect.Lists;
import com.miui.player.C0329R;
import com.miui.player.effect.EqualizerView;
import com.miui.player.effect.VerticalSeekBar;
import com.miui.player.effect.VerticalSeekBar.OnSeekBarChangeListener;
import com.miui.player.meta.MetaManager;
import java.util.List;

public class DiracEqualizer extends Activity implements OnClickListener, OnSeekBarChangeListener {
    private static final int BAND_COUNT = 7;
    private static final String EQ_AUTO_ID = "dirac_eq_auto";
    private static final String EQ_CUSTOM_ID_PREFIX = "dirac_eq_custom#";
    private static final String EQ_PRESET_ID_PREFIX = "dirac_eq_preset#";
    private static final String KEY_EQ_CURRENT_ID = "dirac_eq_current";
    private static final String KEY_EQ_CUSTOM_IDS = "dirac_eq_ids";
    private static final int REMOVE = 1;
    private static final int[] SEEK_BAR_IDS = new int[]{C0329R.id.progress_eq0, C0329R.id.progress_eq1, C0329R.id.progress_eq2, C0329R.id.progress_eq3, C0329R.id.progress_eq4, C0329R.id.progress_eq5, C0329R.id.progress_eq6};
    private static final String SEPARATOR = ",";
    static final String TAG = DiracEqualizer.class.getName();
    static final int TYPE_AUTO = 2;
    static final int TYPE_CUSTOM = 0;
    static final int TYPE_PRESET = 1;
    final VerticalSeekBar[] mBandSeekBars = new VerticalSeekBar[7];
    private EQConfigManager mConfigManager;
    private EQConfig mCurrentConfig;
    private final DialogInterface.OnClickListener mDeleteDialogListener = new C03451();
    private DiracUtils mDiracUtil;
    private EQConfig mEQConfigAuto;
    private EqualizerView mEqualizerCurve;
    private final DialogInterface.OnClickListener mListDialogListener = new C03462();
    private TextView mPresetSpinner;
    private Button mSaveButton;
    private int mValueFactor;

    class C03451 implements DialogInterface.OnClickListener {
        C03451() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which == -1 && DiracEqualizer.this.mConfigManager.remove(DiracEqualizer.this.mCurrentConfig)) {
                DiracEqualizer.this.mCurrentConfig = null;
                DiracEqualizer.this.ensureCurrentConfig();
                DiracEqualizer.this.applyEQConfig(DiracEqualizer.this.mCurrentConfig);
                DiracEqualizer.this.updateSeekBars();
                DiracEqualizer.this.updateCurve();
                DiracEqualizer.this.updateSpinner();
                Toast.makeText(DiracEqualizer.this, C0329R.string.eq_delete_success, 0).show();
            }
            dialog.dismiss();
        }
    }

    class C03462 implements DialogInterface.OnClickListener {
        C03462() {
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which != -2) {
                EQConfig config = DiracEqualizer.this.mConfigManager.get(which);
                if (!(config == null || DiracEqualizer.this.mCurrentConfig == config)) {
                    DiracEqualizer.this.applyEQConfig(config);
                    DiracEqualizer.this.setCurrentConfig(config);
                    DiracEqualizer.this.updateCurve();
                    DiracEqualizer.this.updateSeekBars();
                    DiracEqualizer.this.updateSpinner();
                }
            }
            dialog.dismiss();
        }
    }

    private static class EQConfig {
        public final String mId;
        public final String mTitle;
        public final int mType;
        public final float[] mValues = new float[7];

        public EQConfig(String id, String title, float[] values, int type) {
            this.mId = id;
            this.mTitle = title;
            this.mType = type;
            updateValues(values);
        }

        public void updateValues(float[] values) {
            if (values != null && values.length >= this.mValues.length) {
                System.arraycopy(values, 0, this.mValues, 0, this.mValues.length);
            }
        }
    }

    private static class EQConfigManager {
        private final List<EQConfig> mList = Lists.newArrayList();
        private final ContentResolver mResolver;

        public EQConfigManager(Context context) {
            loadPresets(context);
            ContentResolver cr = context.getContentResolver();
            this.mResolver = cr;
            String[] ids = DiracEqualizer.loadIds(cr);
            if (ids != null) {
                float[] values = new float[7];
                for (String id : ids) {
                    if (DiracEqualizer.isCustomId(id) && DiracEqualizer.loadValues(cr, id, values)) {
                        this.mList.add(new EQConfig(id, DiracEqualizer.getCustomTitle(id), values, 0));
                    }
                }
            }
        }

        public CharSequence[] getEQTitles() {
            CharSequence[] titles = new CharSequence[this.mList.size()];
            int i = 0;
            for (EQConfig c : this.mList) {
                int i2 = i + 1;
                titles[i] = c.mTitle;
                i = i2;
            }
            return titles;
        }

        private void loadPresets(Context context) {
            Resources res = context.getResources();
            String[] names = res.getStringArray(C0329R.array.dirac_equalizer_preset_names);
            String[] valueStrs = res.getStringArray(C0329R.array.dirac_equalizer_preset_values);
            float[] values = new float[7];
            for (int i = 0; i < names.length; i++) {
                if (DiracEqualizer.decode(valueStrs[i], values)) {
                    this.mList.add(new EQConfig(DiracEqualizer.EQ_PRESET_ID_PREFIX + i, names[i], values, 1));
                }
            }
        }

        public boolean remove(EQConfig config) {
            if (config == null || config.mType != 0) {
                return false;
            }
            if (this.mList.remove(config)) {
                DiracEqualizer.persistIds(this.mResolver, this.mList);
                DiracEqualizer.removeValues(this.mResolver, config.mId);
            }
            return true;
        }

        public EQConfig add(String title, float[] values) {
            if (title == null || values == null || values.length != 7) {
                return null;
            }
            String id = DiracEqualizer.getCustomId(title);
            EQConfig c = findById(id);
            if (c != null) {
                c.updateValues(values);
            } else {
                c = new EQConfig(id, title, values, 0);
                this.mList.add(c);
                DiracEqualizer.persistIds(this.mResolver, this.mList);
            }
            DiracEqualizer.persistValues(this.mResolver, c);
            return c;
        }

        public EQConfig getDefaultConfig() {
            return (EQConfig) this.mList.get(0);
        }

        public EQConfig get(int index) {
            if (index >= 0 || index < this.mList.size()) {
                return (EQConfig) this.mList.get(index);
            }
            return null;
        }

        public int indexOf(EQConfig config) {
            if (config == null || config.mId == null) {
                return -1;
            }
            String id = config.mId;
            int i = 0;
            for (EQConfig c : this.mList) {
                if (id.equals(c.mId)) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        public EQConfig findByTitle(String title) {
            return findById(DiracEqualizer.getCustomId(title));
        }

        public EQConfig findById(String id) {
            if (id != null) {
                for (EQConfig c : this.mList) {
                    if (id.equals(c.mId)) {
                        return c;
                    }
                }
            }
            return null;
        }
    }

    private class SaveDialogListener implements DialogInterface.OnClickListener, OnCancelListener {
        private final EditText mEditText;
        private TextWatcher mWatcher;

        public SaveDialogListener(EditText editor) {
            this.mEditText = editor;
        }

        public void setTextWatcher(TextWatcher watcher) {
            this.mWatcher = watcher;
        }

        public void onClick(DialogInterface dialog, int which) {
            if (which == -1) {
                String title = this.mEditText.getText().toString();
                if (!TextUtils.isEmpty(title)) {
                    EQConfig c = DiracEqualizer.this.mConfigManager.add(title, DiracEqualizer.this.mCurrentConfig.mValues);
                    if (!(c == null || c == DiracEqualizer.this.mCurrentConfig)) {
                        DiracEqualizer.this.setCurrentConfig(c);
                        DiracEqualizer.this.updateSpinner();
                    }
                }
            }
            removeTextWatcher();
        }

        private void removeTextWatcher() {
            if (this.mWatcher != null) {
                this.mEditText.removeTextChangedListener(this.mWatcher);
            }
        }

        public void onCancel(DialogInterface dialog) {
            removeTextWatcher();
        }
    }

    private class SaveTextWatcher implements TextWatcher {
        private final Button mDialogConfirm;

        public SaveTextWatcher(AlertDialog dialog) {
            this.mDialogConfirm = dialog.getButton(-1);
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            boolean rename = true;
            if (s.length() == 0) {
                this.mDialogConfirm.setEnabled(false);
                return;
            }
            this.mDialogConfirm.setEnabled(true);
            if (DiracEqualizer.this.mConfigManager.findByTitle(s.toString()) == null) {
                rename = false;
            }
            this.mDialogConfirm.setText(rename ? C0329R.string.eq_preset_rename : C0329R.string.eq_preset_create);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
        }
    }

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.mDiracUtil = DiracUtils.newInstance();
        this.mDiracUtil.initialize();
        this.mValueFactor = getResources().getInteger(C0329R.integer.dirac_euqliazer_level_factor);
        this.mConfigManager = new EQConfigManager(this);
        ensureCurrentConfig();
        setContentView(C0329R.layout.dirac_equalizer);
        this.mEqualizerCurve = (EqualizerView) findViewById(C0329R.id.surface);
        this.mEqualizerCurve.init(getResources().getInteger(C0329R.integer.dirac_equalizer_rank_min), getResources().getInteger(C0329R.integer.dirac_equalizer_rank_max));
        View titleView = findViewById(C0329R.id.title_view);
        titleView.findViewById(C0329R.id.title_bar_home).setOnClickListener(this);
        this.mSaveButton = (Button) titleView.findViewById(C0329R.id.title_bar_save);
        this.mSaveButton.setOnClickListener(this);
        refreshSaveButton();
        int maxProgress = (this.mEqualizerCurve.getMaxLevel() - this.mEqualizerCurve.getMinLevel()) * this.mValueFactor;
        for (int i = 0; i < 7; i++) {
            VerticalSeekBar seekBar = (VerticalSeekBar) findViewById(SEEK_BAR_IDS[i]);
            this.mBandSeekBars[i] = seekBar;
            seekBar.setTag(Integer.valueOf(i));
            seekBar.setMax(maxProgress);
            seekBar.setOnSeekBarChangeListener(this);
        }
        this.mPresetSpinner = (TextView) findViewById(C0329R.id.effect_type);
        this.mPresetSpinner.setOnClickListener(this);
        updateSeekBars();
        updateSpinner();
        updateCurve();
    }

    public void onResume() {
        super.onResume();
        this.mDiracUtil.initialize();
    }

    public void onPause() {
        this.mDiracUtil.release();
        super.onPause();
    }

    private void updateSeekBars() {
        ensureCurrentConfig();
        float[] values = this.mCurrentConfig.mValues;
        for (int i = 0; i < 7; i++) {
            this.mBandSeekBars[i].setProgress(leveltoProgress(values[i]));
        }
    }

    private void updateCurve() {
        ensureCurrentConfig();
        this.mEqualizerCurve.setBands(this.mCurrentConfig.mValues);
    }

    private void updateSpinner() {
        ensureCurrentConfig();
        this.mPresetSpinner.setText(this.mCurrentConfig.mTitle);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if (this.mCurrentConfig == null || this.mCurrentConfig.mType != 0) {
            return false;
        }
        menu.add(0, 1, 0, C0329R.string.eq_delete);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                new Builder(this).setTitle(101450031).setCancelable(true).setPositiveButton(17039370, this.mDeleteDialogListener).setNegativeButton(17039360, this.mDeleteDialogListener).show();
                return true;
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onProgressChanged(VerticalSeekBar seekBar, int progress, boolean fromUser) {
        int userBand = ((Integer) seekBar.getTag()).intValue();
        float level = progressToLevel(progress);
        this.mCurrentConfig.mValues[userBand] = level;
        setBandLevel(userBand, level);
        updateCurve();
    }

    public void onStartTrackingTouch(VerticalSeekBar seekBar) {
        if (this.mCurrentConfig != this.mEQConfigAuto) {
            newAutoEQConfig(this.mCurrentConfig);
            setCurrentConfig(this.mEQConfigAuto);
            updateSpinner();
        }
    }

    public void onStopTrackingTouch(VerticalSeekBar seekBar) {
        int progress = seekBar.getProgress();
        int userBand = ((Integer) seekBar.getTag()).intValue();
        float level = progressToLevel(progress);
        this.mCurrentConfig.mValues[userBand] = level;
        setBandLevel(userBand, level);
        updateCurve();
        persistValues(getContentResolver(), this.mCurrentConfig);
    }

    public void onClick(View v) {
        if (v == this.mPresetSpinner) {
            new Builder(this).setTitle(C0329R.string.eq_preset_select).setCancelable(true).setSingleChoiceItems(this.mConfigManager.getEQTitles(), this.mConfigManager.indexOf(this.mCurrentConfig), this.mListDialogListener).setNegativeButton(17039360, this.mListDialogListener).show();
        } else if (v.getId() == C0329R.id.title_bar_home) {
            finish();
        } else if (v.getId() == C0329R.id.title_bar_save && this.mCurrentConfig != null && this.mCurrentConfig.mType == 2) {
            View custom = View.inflate(this, C0329R.layout.eq_create_preset, null);
            EditText inputText = (EditText) custom.findViewById(C0329R.id.input_name);
            inputText.setText(getSuggestionName());
            inputText.setSelection(inputText.length());
            SaveDialogListener listener = new SaveDialogListener(inputText);
            Builder builder = new Builder(this);
            builder.setTitle(C0329R.string.eq_preset_hint).setCancelable(true).setPositiveButton(C0329R.string.eq_preset_create, listener).setNegativeButton(17039360, listener).setOnCancelListener(listener).setView(custom);
            TextWatcher watcher = new SaveTextWatcher(builder.show());
            inputText.addTextChangedListener(watcher);
            listener.setTextWatcher(watcher);
        }
    }

    private CharSequence getSuggestionName() {
        String format = getString(C0329R.string.eq_preset_format);
        int i = 1;
        while (true) {
            Object[] objArr = new Object[1];
            int i2 = i + 1;
            objArr[0] = Integer.valueOf(i);
            String suggest = String.format(format, objArr);
            if (this.mConfigManager.findByTitle(suggest) == null) {
                return suggest;
            }
            i = i2;
        }
    }

    void applyEQConfig(EQConfig config) {
        if (config != null) {
            float[] values = config.mValues;
            for (int i = 0; i < values.length; i++) {
                setBandLevel(i, values[i]);
            }
        }
    }

    float progressToLevel(int progress) {
        return ((float) ((this.mEqualizerCurve.getMinLevel() * this.mValueFactor) + progress)) / ((float) this.mValueFactor);
    }

    int leveltoProgress(float level) {
        return Math.round((level - ((float) this.mEqualizerCurve.getMinLevel())) * ((float) this.mValueFactor));
    }

    private void setBandLevel(int band, float level) {
        if (band < 0 || band >= 7) {
            Log.d(TAG, "Invalid band=" + band);
            return;
        }
        this.mDiracUtil.setLevel(this, band, Math.min((float) this.mEqualizerCurve.getMaxLevel(), Math.max((float) this.mEqualizerCurve.getMinLevel(), level)));
    }

    void setCurrentConfig(EQConfig config) {
        if (config != null && this.mCurrentConfig != config) {
            if (this.mCurrentConfig == this.mEQConfigAuto && this.mEQConfigAuto != null) {
                removeValues(getContentResolver(), this.mEQConfigAuto.mId);
                this.mEQConfigAuto = null;
            }
            this.mCurrentConfig = config;
            refreshSaveButton();
            System.putString(getContentResolver(), KEY_EQ_CURRENT_ID, this.mCurrentConfig.mId);
        }
    }

    void refreshSaveButton() {
        if (this.mSaveButton != null) {
            this.mSaveButton.setEnabled(this.mCurrentConfig.mType == 2);
        }
    }

    void ensureCurrentConfig() {
        if (this.mCurrentConfig == null) {
            ContentResolver cr = getContentResolver();
            EQConfig config = null;
            String current = System.getString(cr, KEY_EQ_CURRENT_ID);
            if (EQ_AUTO_ID.equals(current)) {
                newAutoEQConfig(null);
                if (decode(System.getString(cr, this.mEQConfigAuto.mId), this.mEQConfigAuto.mValues)) {
                    config = this.mEQConfigAuto;
                }
            }
            if (config == null) {
                config = this.mConfigManager.findById(current);
            }
            if (config == null) {
                config = this.mConfigManager.getDefaultConfig();
            }
            setCurrentConfig(config);
        }
    }

    void newAutoEQConfig(EQConfig src) {
        float[] values = src != null ? src.mValues : null;
        if (this.mEQConfigAuto == null) {
            this.mEQConfigAuto = new EQConfig(EQ_AUTO_ID, getString(C0329R.string.eq_auto), values, 2);
        } else {
            this.mEQConfigAuto.updateValues(values);
        }
    }

    static void persistValues(ContentResolver cr, EQConfig config) {
        if (config != null) {
            System.putString(cr, config.mId, encode(config.mValues));
        }
    }

    static boolean loadValues(ContentResolver cr, String id, float[] values) {
        String valueStr = System.getString(cr, id);
        if (valueStr != null) {
            return decode(valueStr, values);
        }
        return false;
    }

    static String encode(float[] values) {
        StringBuilder sb = new StringBuilder();
        for (float v : values) {
            sb.append(v);
            sb.append(",");
        }
        return sb.toString();
    }

    static boolean decode(String src, float[] values) {
        if (src == null || values == null) {
            return false;
        }
        String[] strs = src.split(",");
        int count = Math.min(strs.length, values.length);
        int i = 0;
        while (i < count) {
            try {
                values[i] = Float.parseFloat(strs[i]);
                i++;
            } catch (NumberFormatException e) {
                Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
                return false;
            }
        }
        return true;
    }

    private static String getCustomTitle(String id) {
        return id.substring(EQ_CUSTOM_ID_PREFIX.length());
    }

    private static boolean isCustomId(String id) {
        return id != null && id.startsWith(EQ_CUSTOM_ID_PREFIX);
    }

    private static String getCustomId(String title) {
        return EQ_CUSTOM_ID_PREFIX + title;
    }

    private static String[] loadIds(ContentResolver cr) {
        String ids = System.getString(cr, KEY_EQ_CUSTOM_IDS);
        if (ids == null) {
            return null;
        }
        return ids.split(",");
    }

    private static void persistIds(ContentResolver cr, List<EQConfig> list) {
        StringBuilder sb = new StringBuilder();
        for (EQConfig c : list) {
            sb.append(c.mId);
            sb.append(",");
        }
        System.putString(cr, KEY_EQ_CUSTOM_IDS, sb.toString());
    }

    private static void removeValues(ContentResolver cr, String id) {
        if (id != null) {
            System.putString(cr, id, null);
        }
    }
}
