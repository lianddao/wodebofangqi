package com.miui.player.ui.controller;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper.AccountPermissionListener;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.MediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.controller.QualityAlert.OnQualitySelectedListener;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.ServiceActions.In;
import com.miui.player.util.StorageConfig;
import com.xiaomi.music.util.NetworkUtil;

public class TitleBarController {
    private static final int BIT_RATE_ICON = 2131624101;
    private static final int BIT_RATE_ICON_CONTAINER = 2131624100;
    private static final int IMAGE_BACK = 16908332;
    private static final int IMAGE_ICON = 16908294;
    private static final int IMAGE_SEPARATOR = 101384321;
    private static final int IMAGE_TOGGLE = 16908311;
    private static final int TEXT_PRIMARY = 16908300;
    private static final int TEXT_SECONDARY = 16908299;
    private static final int TEXT_TERTIARY = 16908293;
    private final Activity mActivity;
    private final ImageView mBackImage;
    private final View mBitRateContainer;
    private final TextView mBitRateIcon;
    private final ImageView mIconImage;
    private final TextView mPrimaryText;
    private final TextView mSecondaryText;
    private final ImageView mSeparator;
    private IMediaPlaybackService mService;
    private final TextView mTertiaryText;
    private final ImageView mToggleImage;
    private VipPermissionChangeListener mVipPermissionChangedListener;

    public class BitRateListener implements OnClickListener {
        private Activity mActivity;
        private View mContainer;
        private TextView mIcon;

        class C04901 implements OnQualitySelectedListener {

            class C04881 implements DialogInterface.OnClickListener {
                C04881() {
                }

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }

            C04901() {
            }

            public void onSelected(final int quality, boolean allow) {
                if (!allow) {
                    return;
                }
                if (quality == 0 && NetworkUtil.isActiveNetworkMetered(BitRateListener.this.mActivity)) {
                    new Builder(BitRateListener.this.mActivity).setTitle(C0329R.string.data_usage_warning).setMessage(C0329R.string.data_usage_warning_summary).setPositiveButton(C0329R.string.confirm, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            TitleBarController.saveUserChoice(StorageConfig.getMusicBitRate(quality));
                            TitleBarController.refreshBitRateIcon(BitRateListener.this.mActivity, BitRateListener.this.mContainer, BitRateListener.this.mIcon, true);
                        }
                    }).setNegativeButton(C0329R.string.cancel, new C04881()).show();
                    return;
                }
                TitleBarController.saveUserChoice(StorageConfig.getMusicBitRate(quality));
                TitleBarController.refreshBitRateIcon(BitRateListener.this.mActivity, BitRateListener.this.mContainer, BitRateListener.this.mIcon, true);
            }
        }

        public BitRateListener(Activity activity, View container, TextView icon) {
            this.mActivity = activity;
            this.mContainer = container;
            this.mIcon = icon;
        }

        public void onClick(View v) {
            RemoteException e;
            Audio audio = null;
            if (TitleBarController.this.mService != null) {
                try {
                    String title = TitleBarController.this.mService.getTrackName();
                    String artist = TitleBarController.this.mService.getArtistName();
                    String album = TitleBarController.this.mService.getAlbumName();
                    Audio audio2 = new Audio(null, title);
                    try {
                        audio2.mDetail = new AudioDetail();
                        audio2.mDetail.mArtistName = artist;
                        audio2.mDetail.mAlbumName = album;
                        audio = audio2;
                    } catch (RemoteException e2) {
                        e = e2;
                        audio = audio2;
                        e.printStackTrace();
                        QualityAlert.show(this.mActivity, false, TitleBarController.readUserChoice(), audio, new C04901(), "试听");
                    }
                } catch (RemoteException e3) {
                    e = e3;
                    e.printStackTrace();
                    QualityAlert.show(this.mActivity, false, TitleBarController.readUserChoice(), audio, new C04901(), "试听");
                }
            }
            QualityAlert.show(this.mActivity, false, TitleBarController.readUserChoice(), audio, new C04901(), "试听");
        }
    }

    private class VipPermissionChangeListener implements AccountPermissionListener {
        private VipPermissionChangeListener() {
        }

        public void onPermissionChanged(int allowQuality) {
            TitleBarController.this.refreshBitRateIcon();
        }

        public void onPeriodChanged(String startTime, String endTime) {
        }
    }

    public TitleBarController(final Activity activity, View container) {
        this.mActivity = activity;
        this.mPrimaryText = (TextView) container.findViewById(TEXT_PRIMARY);
        this.mSecondaryText = (TextView) container.findViewById(TEXT_SECONDARY);
        this.mTertiaryText = (TextView) container.findViewById(TEXT_TERTIARY);
        this.mSeparator = (ImageView) container.findViewById(IMAGE_SEPARATOR);
        this.mBackImage = (ImageView) container.findViewById(IMAGE_BACK);
        this.mBackImage.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                activity.finish();
            }
        });
        this.mToggleImage = (ImageView) container.findViewById(IMAGE_TOGGLE);
        this.mIconImage = (ImageView) container.findViewById(IMAGE_ICON);
        this.mBitRateIcon = (TextView) container.findViewById(2131624101);
        this.mBitRateContainer = container.findViewById(2131624100);
        if (this.mBitRateContainer != null) {
            this.mBitRateContainer.setOnClickListener(new BitRateListener(this.mActivity, this.mBitRateContainer, this.mBitRateIcon));
            this.mVipPermissionChangedListener = new VipPermissionChangeListener();
            AccountPermissionHelper.addListener(this.mVipPermissionChangedListener);
        }
    }

    public void setPrimaryText(int resId) {
        this.mPrimaryText.setText(resId);
    }

    public void setPrimaryText(CharSequence text) {
        this.mPrimaryText.setText(text);
    }

    public void setSecondaryText(int resId) {
        this.mSecondaryText.setText(resId);
        updateSeparator();
    }

    public void setSecondaryText(CharSequence text) {
        this.mSecondaryText.setText(text);
        updateSeparator();
    }

    public void setTertiaryText(int resId) {
        this.mTertiaryText.setText(resId);
        updateSeparator();
    }

    public void setTertiaryText(CharSequence text) {
        this.mTertiaryText.setText(text);
        updateSeparator();
    }

    public void setBackDrawable(Drawable background) {
        this.mBackImage.setBackground(background);
    }

    public void setBackDrawable(int resId) {
        this.mBackImage.setBackgroundResource(resId);
    }

    public void setToggle(Drawable background) {
        this.mToggleImage.setBackground(background);
    }

    public void setToggle(int resId) {
        this.mToggleImage.setBackgroundResource(resId);
    }

    public void setToggleListener(OnClickListener listener) {
        this.mToggleImage.setOnClickListener(listener);
    }

    public void setIcon(Drawable background) {
        this.mIconImage.setBackground(background);
    }

    public void setIcon(int resId) {
        this.mIconImage.setBackgroundResource(resId);
    }

    public CharSequence getSecondaryText() {
        return this.mSecondaryText.getText();
    }

    public CharSequence getTertiaryText() {
        return this.mTertiaryText.getText();
    }

    private void updateSeparator() {
        if (this.mSeparator != null) {
            if (TextUtils.isEmpty(getSecondaryText()) || TextUtils.isEmpty(getTertiaryText())) {
                this.mSeparator.setVisibility(8);
            } else {
                this.mSeparator.setVisibility(0);
            }
        }
    }

    private static void saveUserChoice(int bitRate) {
        Context context = MusicApplication.getApplication();
        if (PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_TRACK_BIT_RATE).intValue() != bitRate) {
            PreferenceCache.setPrefAsInteger(context, PreferenceCache.PREF_TRACK_BIT_RATE, bitRate);
            doCommand(In.CMDREPLAY);
        }
    }

    private static int readUserChoice() {
        switch (StorageConfig.getUserChoice(PreferenceCache.getPrefAsInteger(MusicApplication.getApplication(), PreferenceCache.PREF_TRACK_BIT_RATE).intValue())) {
            case 0:
                if (AccountPermissionHelper.allowUHDMusic()) {
                    return 0;
                }
                break;
            case 1:
                break;
        }
        if (AccountPermissionHelper.allowHDMusic()) {
            return 1;
        }
        return 2;
    }

    private void refreshBitRateIcon() {
        refreshBitRateIcon(this.mActivity, this.mBitRateContainer, this.mBitRateIcon, ServiceHelper.getCurrentOnlineId() != null);
    }

    public void refreshBitRateIcon(boolean isVisible) {
        refreshBitRateIcon(this.mActivity, this.mBitRateContainer, this.mBitRateIcon, isVisible);
    }

    public static void refreshBitRateIcon(Activity activity, View container, TextView icon, boolean isVisible) {
        if (container != null && icon != null) {
            container.setVisibility(isVisible ? 0 : 8);
            if (isVisible) {
                switch (readUserChoice()) {
                    case 0:
                        icon.setText(null);
                        icon.setBackgroundResource(C0329R.drawable.vip_diamond);
                        return;
                    case 1:
                        icon.setText(C0329R.string.track_bit_rate_hd);
                        icon.setBackgroundResource(C0329R.drawable.media_playback_activity_title_bar_bit_rate_icon_bg);
                        return;
                    case 2:
                        icon.setText(C0329R.string.track_bit_rate_standard);
                        icon.setBackgroundResource(C0329R.drawable.media_playback_activity_title_bar_bit_rate_icon_bg);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void showUserGuide() {
        if (this.mBitRateContainer != null && this.mBitRateContainer.getVisibility() == 0) {
            UIHelper.showUserGuide(this.mActivity, this.mBitRateIcon, 0, 0, PreferenceCache.PREF_PAY_SERVICE_GUIDE_LISTEN, C0329R.string.pay_service_guide_listen);
        }
    }

    public static void doCommand(String command) {
        Context context = MusicApplication.getApplication();
        Intent i = new Intent(context, MediaPlaybackService.class);
        i.setAction(In.SERVICECMD);
        i.putExtra(In.CMDNAME, command);
        context.startService(i);
    }

    public void destory() {
        if (this.mVipPermissionChangedListener != null) {
            AccountPermissionHelper.removeListener(this.mVipPermissionChangedListener);
        }
    }

    public void setService(IMediaPlaybackService service) {
        this.mService = service;
    }
}
