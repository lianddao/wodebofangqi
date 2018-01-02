package com.songbirdnest.mediaplayer.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.songbirdnest.billing.BillingHelper;
import com.songbirdnest.billing.BillingListener;
import com.songbirdnest.billing.BillingManager;
import com.songbirdnest.billing.InAppPurchases;
import com.songbirdnest.billing.ResponseCode;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.service.EqualizerSettings;
import com.songbirdnest.mediaplayer.service.EqualizerSettings.PRESET_TYPE;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService.Stub;
import com.songbirdnest.mediaplayer.widgets.SlidingButton;
import com.songbirdnest.mediaplayer.widgets.SlidingButton.OnCheckedChangeListener;
import com.songbirdnest.mediaplayer.widgets.VerticalProgressBar;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.List;

public class Equalizer extends Activity {
    private boolean alwaysEnableDialogForTesting = false;
    private BillingListener billingListener;
    private BillingManager billingManager;
    private Button closeButton;
    private boolean debugging = false;
    private boolean disabled;
    private boolean eqAvailable = false;
    private boolean eqIsOn;
    private boolean eqPurchased = false;
    private SlidingButton eq_power;
    private List<ViewGroup> equalizerBands = new ArrayList();
    private ViewGroup equalizerParent;
    private EqualizerSettings equalizerSettings;
    private View equalizerView;
    private Handler handler;
    private boolean mConnected;
    private boolean mConnecting;
    private ServiceConnection mConnection = null;
    private SongbirdMediaService mService = null;
    private List<String> presetStrings = new ArrayList();
    private Spinner presets;
    private ArrayAdapter<String> presetsAdapter;
    private Dialog purchaseDialog;
    private boolean settingAdapter = false;
    private boolean testBilling = false;

    class C01741 implements OnClickListener {
        C01741() {
        }

        public void onClick(View v) {
            boolean z;
            boolean z2 = true;
            Equalizer equalizer = Equalizer.this;
            if (Equalizer.this.eq_power.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            equalizer.enableEQ(z);
            SlidingButton access$000 = Equalizer.this.eq_power;
            if (Equalizer.this.eq_power.isChecked()) {
                z2 = false;
            }
            access$000.setChecked(z2);
        }
    }

    class C01752 implements OnCheckedChangeListener {
        C01752() {
        }

        public void onCheckedChanged(CheckedTextView buttonView, boolean isChecked) {
            Equalizer.this.enableEQ(Equalizer.this.eq_power.isChecked());
        }
    }

    class C01773 implements OnClickListener {

        class C01761 implements AnimationListener {
            C01761() {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                Equalizer.this.equalizerView.setVisibility(8);
                Equalizer.this.finish();
            }

            public void onAnimationRepeat(Animation animation) {
            }
        }

        C01773() {
        }

        public void onClick(View v) {
            Animation animation = AnimationUtils.loadAnimation(Equalizer.this, 17432577);
            animation.setAnimationListener(new C01761());
            Equalizer.this.equalizerView.startAnimation(animation);
        }
    }

    class C01784 implements OnItemSelectedListener {
        C01784() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (!Equalizer.this.settingAdapter && Equalizer.this.presetsAdapter != null && Equalizer.this.equalizerSettings != null) {
                Equalizer.this.setPreset((short) position);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C01795 implements BillingListener {
        C01795() {
        }

        public void onPurchased(String productId, boolean purchased) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "Equalizer:onPurchased productId " + productId + " purchased " + purchased);
            }
            if (purchased && productId.equalsIgnoreCase(InAppPurchases.EQUALIZER.getProductId())) {
                Equalizer.this.eqPurchased = true;
                Equalizer.this.eqAvailable = true;
                Equalizer.this.enableControls();
            }
        }

        public void onRestoreTransactions(ResponseCode responseCode) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "Equalizer:onRestoreTransactions responseCode " + responseCode);
            }
            switch (responseCode) {
                case RESULT_OK:
                    if (Equalizer.this.billingManager.isPurchased(InAppPurchases.EQUALIZER.getProductId())) {
                        Equalizer.this.eqPurchased = true;
                        Equalizer.this.eqAvailable = true;
                        Equalizer.this.enableControls();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onBillingSupported(boolean supported) {
            if (BillingHelper.debugging) {
                Logger.debug(this, "Equalizer:onBillingSupported supported " + supported);
            }
            Equalizer.this.setControlState();
        }

        public void onError(ResponseCode code) {
        }
    }

    class C01806 implements ServiceConnection {
        C01806() {
        }

        public void onServiceConnected(ComponentName aName, IBinder aService) {
            if (Equalizer.this.debugging) {
                Logger.debug(this, "Equalizer:bindMediaService connected");
            }
            Equalizer.this.mConnecting = false;
            Equalizer.this.mService = Stub.asInterface(aService);
            Equalizer.this.mConnected = true;
            Equalizer.this.onConnected();
        }

        public void onServiceDisconnected(ComponentName name) {
            if (Equalizer.this.debugging) {
                Logger.debug(this, "Equalizer:bindMediaService disconnected");
            }
            Equalizer.this.mConnecting = false;
            Equalizer.this.mService = null;
            Equalizer.this.mConnected = false;
        }
    }

    class C01828 implements OnClickListener {
        C01828() {
        }

        public void onClick(View v) {
            Equalizer.this.purchaseDialog.dismiss();
            Equalizer.this.finish();
        }
    }

    class C01839 implements OnClickListener {
        C01839() {
        }

        public void onClick(View v) {
            Equalizer.this.billingManager.purchase(InAppPurchases.EQUALIZER);
            Equalizer.this.purchaseDialog.dismiss();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(1);
        init();
    }

    public void init() {
        this.handler = new Handler();
        getWindow().getAttributes().windowAnimations = C0116R.style.eqDialog;
        this.equalizerView = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C0116R.layout.equalizer, null);
        setContentView(this.equalizerView);
        this.equalizerParent = (ViewGroup) this.equalizerView.findViewById(C0116R.id.equalizerBands);
        this.presets = (Spinner) this.equalizerView.findViewById(C0116R.id.presets);
        this.eq_power = (SlidingButton) this.equalizerView.findViewById(C0116R.id.eq_power);
        this.eq_power.setToggleButtonImage(C0116R.drawable.eq_power);
        this.eqIsOn = getSharedPreferences(PrefKeys.PREFS_FILENAME, 0).getBoolean(PrefKeys.sCurrentEQ_status, true);
        this.eq_power.setChecked(this.eqIsOn);
        this.eq_power.setOnClickListener(new C01741());
        this.eq_power.setCheckedChangeListener(new C01752());
        this.closeButton = (Button) this.equalizerView.findViewById(C0116R.id.close);
        this.closeButton.setOnClickListener(new C01773());
        this.presets.setOnItemSelectedListener(new C01784());
        this.billingManager = BillingManager.getBillingManager();
        this.billingListener = new C01795();
        this.billingManager.addBillingListener(this.billingListener);
        getWindow().setLayout(-1, -1);
        this.billingManager.start(this);
    }

    private void setControlState() {
        this.eqPurchased = this.billingManager.isPurchased(InAppPurchases.EQUALIZER.getProductId());
        if (!this.eqPurchased && BillingHelper.debugging) {
            Logger.debug(this, "Equalizer: Haven't purchased yet");
        }
        this.eqAvailable = this.billingManager.isBillingAvailable();
        if (!this.eqAvailable && BillingHelper.debugging) {
            Logger.debug(this, "Equalizer: Billing is unavailable");
        }
        if (this.eqPurchased || this.alwaysEnableDialogForTesting) {
            enableControls();
        } else {
            disableControls();
        }
        if (this.testBilling) {
            disableControls();
        }
    }

    private void setPreset(short position) {
        if (this.mService != null) {
            try {
                if (position != this.presetsAdapter.getCount() - 1) {
                    this.mService.usePreset(position);
                } else {
                    this.mService.setPresetType(PRESET_TYPE.CUSTOM.ordinal());
                }
                this.equalizerSettings = this.mService.getEQSettings();
                resetBars();
            } catch (RemoteException e) {
                Logger.error(this, "Problems setting preset", e);
            }
        }
    }

    private void bindMediaService(Context aContext) {
        if (this.debugging) {
            Logger.debug(this, "Equalizer:bindMediaService");
        }
        if (!this.mConnected && !this.mConnecting) {
            this.mConnecting = true;
            if (this.mConnection == null) {
                this.mConnection = new C01806();
            }
            Intent i = new Intent(aContext, SongbirdMedia.class);
            aContext.startService(i);
            aContext.bindService(i, this.mConnection, 1);
        }
    }

    private void onConnected() {
        getCurrentEQSettings();
        setupEqualizer();
        boolean enable = !this.testBilling && ((this.alwaysEnableDialogForTesting || (this.eqAvailable && this.eqPurchased)) && this.equalizerSettings.isEnabled());
        enableEQControls(enable);
        this.eq_power.setChecked(enable);
    }

    private void unbindMediaService(Context aContext) {
        if (this.debugging) {
            Logger.debug(this, "Equalizer:unbindMediaService");
        }
        if (this.mConnected) {
            aContext.unbindService(this.mConnection);
            this.mConnected = false;
        }
    }

    private void saveSettings() {
        if (this.mService != null) {
            try {
                this.mService.saveEQSettings();
                return;
            } catch (RemoteException e) {
                Logger.error(this, "Problems saving settings", e);
                return;
            }
        }
        Logger.error((Object) this, "Service not set");
    }

    protected void onStart() {
        if (this.debugging) {
            Logger.debug(this, "Equalizer:onStart");
        }
        super.onStart();
        bindMediaService(this);
        setControlState();
    }

    protected void onStop() {
        if (this.debugging) {
            Logger.debug(this, "Equalizer:onStop");
        }
        saveSettings();
        unbindMediaService(this);
        super.onStop();
    }

    protected void onDestroy() {
        this.billingManager.removeBillingListener(this.billingListener);
        this.billingManager.stop();
        super.onDestroy();
    }

    public void getCurrentEQSettings() {
        if (this.mService != null) {
            try {
                this.equalizerSettings = this.mService.getEQSettings();
                return;
            } catch (RemoteException e) {
                Logger.error(this, "Problems getting EQ Settings", e);
                return;
            }
        }
        Logger.error((Object) this, "Service not set");
    }

    public void enableEQ(boolean enable) {
        this.eqIsOn = enable;
        if (this.mService != null) {
            try {
                this.mService.setEQEnabled(enable);
                this.equalizerSettings.setEnabled(enable);
            } catch (RemoteException e) {
                Logger.error(this, "Problems setting preset", e);
            }
        } else {
            Logger.error((Object) this, "Service not set");
        }
        enableEQControls(enable);
    }

    private void enableEQControls(boolean enable) {
        if (enable) {
            enableControls();
            return;
        }
        disableControls();
        this.eq_power.setEnabled(true);
    }

    private void setupEqualizer() {
        short bands = this.equalizerSettings.getNumberOfBands();
        short minEQLevel = this.equalizerSettings.getMinEQLevel();
        short maxEQLevel = this.equalizerSettings.getMaxEQLevel();
        this.presetStrings = this.equalizerSettings.getPresets();
        this.presetStrings.add(getString(C0116R.string.custom));
        createPresetAdapter(true);
        LayoutInflater layoutInflater = getLayoutInflater();
        int buttonWidth = getResources().getDrawable(C0116R.drawable.eq_slider_on).getIntrinsicWidth() + 10;
        if (this.debugging) {
            Logger.debug(this, "setupEqualizer:  minEQLevel: " + minEQLevel + " maxEQLevel:" + maxEQLevel);
        }
        this.equalizerParent.removeAllViews();
        for (short i = (short) 0; i < bands; i = (short) (i + 1)) {
            final short band = i;
            LinearLayout equalizerBand = (LinearLayout) layoutInflater.inflate(C0116R.layout.equalizer_band, this.equalizerParent, false);
            this.equalizerBands.add(equalizerBand);
            TextView frequency = (TextView) equalizerBand.findViewById(C0116R.id.frequency);
            int centerFreq = this.equalizerSettings.getCenterFreq(band);
            if (centerFreq > 1000000) {
                frequency.setText(String.format("%d", new Object[]{Long.valueOf(Math.round(((double) ((float) centerFreq)) / 1000000.0d))}) + "K");
            } else if (centerFreq > 100000) {
                frequency.setText(String.format("%d", new Object[]{Long.valueOf(Math.round(((double) ((float) centerFreq)) / 1000.0d))}) + "");
            } else {
                frequency.setText(String.format("%d", new Object[]{Integer.valueOf(Math.round((float) (centerFreq / SongbirdMedia.PODCAST_BACKUP)))}) + "");
            }
            VerticalProgressBar bar = (VerticalProgressBar) equalizerBand.findViewById(C0116R.id.bandPosition);
            bar.setMaxWidth(buttonWidth);
            bar.setMax(maxEQLevel - minEQLevel);
            setBandProgress(bar, band);
            bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        Equalizer.this.setBandLevel(seekBar, band, progress);
                        Equalizer.this.presets.setSelection(Equalizer.this.presetsAdapter.getCount() - 1);
                        if (Equalizer.this.debugging) {
                            Logger.debug(this, "setOnSeekBarChangeListener:  Band Level for band " + band + " value: " + Equalizer.this.equalizerSettings.getBandLevel(band) + " Progress: " + progress);
                        }
                    }
                }

                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
            this.equalizerParent.addView(equalizerBand);
        }
    }

    private void createPresetAdapter(boolean enabled) {
        this.settingAdapter = true;
        if (enabled) {
            this.presetsAdapter = new ArrayAdapter(this, C0116R.layout.eq_spinner_item, this.presetStrings);
        } else {
            this.presetsAdapter = new ArrayAdapter(this, C0116R.layout.eq_spinner_item_disabled, this.presetStrings);
        }
        this.presetsAdapter.setDropDownViewResource(C0116R.layout.eq_dropdown_spinner);
        this.presets.setAdapter(this.presetsAdapter);
        if (this.equalizerSettings == null || this.equalizerSettings.getPresetType() != PRESET_TYPE.SYSTEM || this.equalizerSettings.getCurPreset() == (short) -1) {
            this.presets.setSelection(this.presetsAdapter.getCount() - 1);
        } else {
            this.presets.setSelection(this.equalizerSettings.getCurPreset());
        }
        this.settingAdapter = false;
    }

    private void setBandProgress(SeekBar bar, short band) {
        short bandLevel = this.equalizerSettings.getBandLevel(band);
        int progress = (bar.getMax() / 2) + bandLevel;
        if (this.debugging) {
            Logger.debug(this, "setBandProgress:  band: " + band + " bandLevel:" + bandLevel + " progress:" + progress);
        }
        bar.setProgress(progress);
    }

    private void setBandLevel(SeekBar bar, short band, int progress) {
        short bandLevel = (short) (progress - (bar.getMax() / 2));
        this.equalizerSettings.setBandLevel(band, bandLevel);
        if (this.mService != null) {
            try {
                this.mService.setBandLevel(band, bandLevel);
            } catch (RemoteException e) {
                Logger.error(this, "Problems setting band level", e);
            }
        } else {
            Logger.error((Object) this, "Service not set");
        }
        if (this.debugging) {
            Logger.debug(this, "setBandLevel:  band: " + band + " bandLevel:" + bandLevel + " progress:" + progress);
        }
    }

    private void resetBars() {
        if (this.equalizerSettings != null) {
            short bands = this.equalizerSettings.getNumberOfBands();
            for (short i = (short) 0; i < bands; i = (short) (i + 1)) {
                setBandProgress((SeekBar) ((ViewGroup) this.equalizerBands.get(i)).findViewById(C0116R.id.bandPosition), i);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == 0 && this.disabled && ((!this.eqPurchased || this.testBilling) && !this.alwaysEnableDialogForTesting)) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            Rect temp = new Rect();
            this.closeButton.getGlobalVisibleRect(temp);
            if (temp.contains(x, y)) {
                this.closeButton.performClick();
                return true;
            } else if (this.testBilling || this.billingManager.isBillingAvailable()) {
                showPurchaseDialog();
            } else {
                Utils.showLongToast(this, getString(C0116R.string.purchaseBillingUnavailable));
                return true;
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void showPurchaseDialog() {
        this.purchaseDialog = new Dialog(this, C0116R.style.eqDialog);
        this.purchaseDialog.setCancelable(false);
        View dialog = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C0116R.layout.eq_purchase_dialog, null);
        this.purchaseDialog.setContentView(dialog);
        dialog.findViewById(C0116R.id.noThanks).setOnClickListener(new C01828());
        dialog.findViewById(C0116R.id.getItNow).setOnClickListener(new C01839());
        this.purchaseDialog.show();
    }

    private void disableControls() {
        this.handler.post(new Runnable() {
            public void run() {
                Equalizer.this.disabled = true;
                Equalizer.this.enableDisableView(Equalizer.this.equalizerView, false);
                Equalizer.this.closeButton.setEnabled(true);
                Equalizer.this.createPresetAdapter(false);
            }
        });
    }

    private void enableControls() {
        this.handler.post(new Runnable() {
            public void run() {
                Equalizer.this.disabled = false;
                Equalizer.this.enableDisableView(Equalizer.this.equalizerView, true);
                Equalizer.this.createPresetAdapter(true);
                Equalizer.this.eq_power.setChecked(Equalizer.this.eqIsOn);
            }
        });
    }

    private void enableDisableView(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int idx = 0; idx < group.getChildCount(); idx++) {
                enableDisableView(group.getChildAt(idx), enabled);
            }
        }
    }
}
