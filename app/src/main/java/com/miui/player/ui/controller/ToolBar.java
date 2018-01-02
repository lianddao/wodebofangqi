package com.miui.player.ui.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.google.android.collect.Lists;
import com.miui.player.C0329R;
import com.miui.player.airkan.DeviceController;
import com.miui.player.airkan.DeviceController.DeviceChangedListener;
import com.miui.player.effect.dirac.DiracSettings;
import com.miui.player.effect.dirac.DiracUtils;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.ui.UIHelper;
import com.miui.player.util.Actions;
import com.miui.player.util.AudioEffectConfig;
import com.miui.player.util.MusicAnalyticsUtils;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.Utils;
import java.util.List;
import miui.analytics.XiaomiAnalytics;

public class ToolBar implements OnClickListener, DeviceChangedListener {
    private static final int REPEAT_ALL = 0;
    private static final int REPEAT_COUNT = 3;
    private static final int REPEAT_CURRENT = 1;
    private static final int REPEAT_SHUFFLE = 2;
    static final String TAG = "ToolBar";
    public static final int TOOL_AIRKAN = 2131624178;
    public static final int TOOL_DOWNLOAD = 2131624181;
    public static final int TOOL_EFFECT = 2131624179;
    public static final int TOOL_REPEAT_MODE = 2131624180;
    private final Activity mActivity;
    final BroadcastReceiver mAirkanReceiver = new C04911();
    private final List<String> mArikanDevices = Lists.newArrayList();
    private final View mContainer;
    private final Context mContext;
    private AlertDialog mDialogAirkan;
    private final Builder mDialogBuilder;
    private DiracUtils mDiracUtils;
    private final DownloadIndicator mDownloadIndicator;
    private int mRepeatMode;
    IMediaPlaybackService mService;
    private final ImageView mViewAirkan;
    private final ImageView mViewEffect;
    private final ImageView mViewMode;

    class C04911 extends BroadcastReceiver {
        C04911() {
        }

        public void onReceive(Context context, Intent intent) {
            ToolBar.this.refreshAirkan(true);
        }
    }

    class DeviceClickListener implements DialogInterface.OnClickListener {
        DeviceClickListener() {
        }

        public void onClick(DialogInterface dialog, int which) {
            IMediaPlaybackService service = ToolBar.this.mService;
            if (service != null) {
                if (which == 0) {
                    try {
                        service.setConnectedDevice(null);
                    } catch (RemoteException e) {
                    }
                } else {
                    which--;
                    if (which >= 0) {
                        if (which < ToolBar.this.mArikanDevices.size()) {
                            service.setConnectedDevice((String) ToolBar.this.mArikanDevices.get(which));
                        }
                    }
                    Log.e(ToolBar.TAG, "bad connected device index=" + which);
                }
                ToolBar.this.refreshAirkan(false);
                dialog.dismiss();
            }
        }
    }

    public ToolBar(Activity activity, View container) {
        this.mActivity = activity;
        this.mContext = container.getContext();
        this.mContainer = container;
        this.mViewAirkan = (ImageView) container.findViewById(2131624178);
        this.mViewAirkan.setImageResource(C0329R.drawable.tool_airkan);
        this.mViewAirkan.setOnClickListener(this);
        this.mViewAirkan.setEnabled(false);
        this.mViewMode = (ImageView) container.findViewById(2131624180);
        this.mViewMode.setOnClickListener(this);
        refreshRepeatMode();
        if (DiracUtils.supportDirac(this.mContext)) {
            this.mDiracUtils = DiracUtils.newInstance();
        }
        this.mViewEffect = (ImageView) container.findViewById(2131624179);
        this.mViewEffect.setOnClickListener(this);
        this.mViewEffect.setImageResource(DiracUtils.supportDirac(this.mContext) ? C0329R.drawable.dirac_button : C0329R.drawable.tool_effect);
        ImageView download = (ImageView) container.findViewById(2131624181);
        if (Utils.isOnlineVaild()) {
            download.setVisibility(0);
            download.setImageResource(C0329R.drawable.tool_download);
            this.mDownloadIndicator = new DownloadIndicator(this.mActivity, download);
        } else {
            download.setVisibility(8);
            this.mDownloadIndicator = null;
        }
        this.mDialogBuilder = new Builder(this.mContext).setTitle(C0329R.string.select_device);
    }

    public void refreshDownload() {
        if (this.mDownloadIndicator != null) {
            this.mDownloadIndicator.refresh();
        }
    }

    public void setVisible(int toolId, boolean visible) {
        View v = getView(toolId);
        if (v != null) {
            v.setVisibility(visible ? 0 : 4);
        }
    }

    public void setEnabled(int toolId, boolean enabled) {
        View v = getView(toolId);
        if (v != null) {
            v.setEnabled(enabled);
        }
    }

    public void setSelected(int toolId, boolean selected) {
        View v = getView(toolId);
        if (v != null) {
            v.setSelected(selected);
        }
    }

    public View getView(int id) {
        switch (id) {
            case 2131624178:
                return this.mViewAirkan;
            case 2131624179:
                return this.mViewEffect;
            case 2131624180:
                return this.mViewMode;
            case 2131624181:
                if (this.mDownloadIndicator != null) {
                    return this.mDownloadIndicator.getIconView();
                }
                return null;
            default:
                Log.w(TAG, "unsupported id=" + id);
                return null;
        }
    }

    public void refreshRepeatMode() {
        this.mRepeatMode = getRepeatMode();
        refreshRepeatMode(this.mRepeatMode);
    }

    private void setRepeatMode(int mode) {
        IMediaPlaybackService service = this.mService;
        if (service != null) {
            if (mode == 0) {
                try {
                    service.setRepeatMode(0);
                    service.setShuffleMode(0);
                } catch (RemoteException e) {
                }
            } else if (mode == 1) {
                service.setRepeatMode(1);
                service.setShuffleMode(0);
            } else {
                service.setRepeatMode(0);
                service.setShuffleMode(1);
            }
        }
    }

    private int getRepeatMode() {
        IMediaPlaybackService service = this.mService;
        if (service == null) {
            return 0;
        }
        try {
            if (service.getRepeatMode() == 1) {
                return 1;
            }
            if (service.getShuffleMode() == 1) {
                return 2;
            }
            return 0;
        } catch (RemoteException e) {
            return 0;
        }
    }

    private void refreshRepeatMode(int mode) {
        boolean z = true;
        if (mode == 0) {
            this.mViewMode.setImageResource(C0329R.drawable.tool_repeat_all);
        } else if (mode == 1) {
            this.mViewMode.setImageResource(C0329R.drawable.tool_repeat_current);
        } else if (mode == 2) {
            this.mViewMode.setImageResource(C0329R.drawable.tool_repeat_shuffle);
        }
        ImageView imageView = this.mViewMode;
        if (isChannel()) {
            z = false;
        }
        imageView.setEnabled(z);
    }

    void toggleRepeat() {
        this.mRepeatMode = (this.mRepeatMode + 1) % 3;
        setRepeatMode(this.mRepeatMode);
        refreshRepeatMode(this.mRepeatMode);
    }

    void handleAudioEffect(View v) {
        Context context = this.mContext;
        if (DiracUtils.supportDirac(context)) {
            context.startActivity(new Intent(context, DiracSettings.class));
        } else if (AudioEffectConfig.supportDolby(context)) {
            context.startActivity(new Intent("miui.intent.action.DOLBY_EQUALIZER_ALERT"));
        } else {
            context.startActivity(new Intent(Actions.ACTION_EQUALIZER));
        }
    }

    public void onClick(View v) {
        XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
        switch (v.getId()) {
            case 2131624178:
                handleAirkan();
                analytics.trackEvent(MusicAnalyticsUtils.CLICK_NOWPLAYING_TOOL_AIRKAN);
                return;
            case 2131624179:
                handleAudioEffect(v);
                analytics.trackEvent(MusicAnalyticsUtils.CLICK_NOWPLAYING_TOOL_AUDIO_EFFECT);
                return;
            case 2131624180:
                toggleRepeat();
                analytics.trackEvent(MusicAnalyticsUtils.CLICK_NOWPLAYING_TOOL_SHUFFLE);
                return;
            default:
                return;
        }
    }

    public void setVisible(boolean visible) {
        this.mContainer.setVisibility(visible ? 0 : 8);
        updateAirkanState(visible);
    }

    public boolean isVisible() {
        return this.mContainer.getVisibility() == 0;
    }

    public boolean toggleState() {
        setVisible(this.mContainer.getVisibility() != 0);
        if (isVisible()) {
            XiaomiAnalytics.getInstance().trackEvent(MusicAnalyticsUtils.EVENT_DISPLAY_TOOL_BAR);
        }
        return isVisible();
    }

    public void setService(IMediaPlaybackService service) {
        this.mService = service;
    }

    public void onResume() {
        if (this.mDownloadIndicator != null) {
            this.mDownloadIndicator.register();
        }
        updateAirkanState(isVisible());
        DeviceController.instance().addListener(this);
        this.mContext.registerReceiver(this.mAirkanReceiver, new IntentFilter(Actions.ACTION_AIRKAN_CONNECTED_DEVICE_CHANGED));
        if (this.mDiracUtils != null) {
            this.mDiracUtils.initialize();
            this.mViewEffect.setSelected(this.mDiracUtils.isEnabled(this.mContext));
        }
        XiaomiAnalytics.getInstance().startSession(this.mContext);
    }

    public void onPause() {
        XiaomiAnalytics.getInstance().endSession();
        if (this.mDownloadIndicator != null) {
            this.mDownloadIndicator.unregister();
        }
        updateAirkanState(false);
        DeviceController.instance().removeListener(this);
        if (this.mDialogAirkan != null) {
            this.mDialogAirkan.dismiss();
        }
        this.mContext.unregisterReceiver(this.mAirkanReceiver);
        if (this.mDiracUtils != null) {
            this.mDiracUtils.release();
        }
    }

    public void onDeviceAdded(String newDevice) {
        Log.i(TAG, "onDeviceAdded");
        if (!this.mArikanDevices.contains(newDevice)) {
            this.mArikanDevices.add(newDevice);
            refreshAirkan(true);
        }
    }

    public void onDeviceAvailable(List<String> deviceList) {
        Log.i(TAG, "onDeviceAvailable");
        boolean needUpdate = false;
        for (String dev : deviceList) {
            if (!this.mArikanDevices.contains(dev)) {
                this.mArikanDevices.add(dev);
                needUpdate = true;
            }
        }
        if (needUpdate) {
            refreshAirkan(true);
        }
    }

    public void onDeviceRemoved(String removedDevice) {
        Log.i(TAG, "onDeviceRemoved");
        this.mArikanDevices.remove(removedDevice);
        refreshAirkan(true);
    }

    void refreshAirkan(boolean updateDialog) {
        boolean z;
        ImageView imageView = this.mViewAirkan;
        if (this.mArikanDevices.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        imageView.setEnabled(z);
        boolean connected = false;
        boolean connectCompleted = false;
        IMediaPlaybackService service = this.mService;
        if (service != null) {
            try {
                if (service.getConnectedDevice() != null) {
                    connected = true;
                } else {
                    connected = false;
                }
                connectCompleted = service.isConnectCompleted();
            } catch (RemoteException e) {
            }
        }
        if (!connected || connectCompleted) {
            this.mViewAirkan.setImageResource(C0329R.drawable.tool_airkan);
            this.mViewAirkan.setSelected(connected);
        } else {
            this.mViewAirkan.setImageResource(C0329R.drawable.tool_airkan_connecting);
            ((AnimationDrawable) this.mViewAirkan.getDrawable()).start();
        }
        if (updateDialog && this.mDialogAirkan != null && this.mDialogAirkan.isShowing()) {
            updateAirkanDialog();
        }
    }

    void handleAirkan() {
        if (this.mArikanDevices.isEmpty()) {
            Log.w(TAG, "No project device avaliable");
        } else {
            updateAirkanDialog();
        }
    }

    private void updateAirkanDialog() {
        if (this.mDialogAirkan != null) {
            this.mDialogAirkan.dismiss();
        }
        IMediaPlaybackService service = this.mService;
        if (service != null) {
            String dev = null;
            try {
                dev = service.getConnectedDevice();
            } catch (RemoteException e) {
            }
            String[] items = getDeviceNames();
            int checked = 0;
            for (int i = 0; i < items.length; i++) {
                if (TextUtils.equals(dev, items[i])) {
                    checked = i;
                    break;
                }
            }
            this.mDialogBuilder.setSingleChoiceItems(items, checked, new DeviceClickListener());
            this.mDialogAirkan = this.mDialogBuilder.show();
        }
    }

    private String[] getDeviceNames() {
        String[] devArr = new String[(this.mArikanDevices.size() + 1)];
        devArr[0] = this.mContext.getString(C0329R.string.project_device_mobile);
        int i = 1;
        for (String dev : this.mArikanDevices) {
            int i2 = i + 1;
            devArr[i] = dev;
            i = i2;
        }
        return devArr;
    }

    void updateAirkanState(boolean active) {
        this.mArikanDevices.clear();
        if (active) {
            DeviceController.instance().open(1);
        } else {
            DeviceController.instance().closeDelayed(1, 300000);
        }
    }

    public void showUserGuide() {
        if (isVisible()) {
            UIHelper.showUserGuide(this.mActivity, (ImageView) this.mContainer.findViewById(2131624181), 0, this.mActivity.getResources().getInteger(C0329R.integer.pay_service_guide_download_offset_y), PreferenceCache.PREF_PAY_SERVICE_GUIDE_DOWNLOAD_ONE, C0329R.string.pay_service_guide_dowload);
        }
    }

    private boolean isChannel() {
        IMediaPlaybackService service = this.mService;
        if (service == null) {
            return false;
        }
        try {
            if (service.getChannelName() != null) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
