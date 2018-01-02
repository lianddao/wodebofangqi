package com.miui.player.ui.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.plugin.onlinepay.VipOrderHelper;
import com.miui.player.ui.VipRecommendActivity;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.Actions;
import com.miui.player.util.PreferenceCache;
import com.miui.player.vod.ThunderStoneKtvNetwork;

public class SuspendBar implements OnClickListener {
    private static final int STATE_HIDE = 0;
    private static final int STATE_KTV_BAR = 1;
    private static final int STATE_VIP_REMIND = 2;
    private static final int STATE_VIP_TIME_OUT = 3;
    private final Activity mActivity;
    private final ImageView mCancleButton;
    private final View mContainer;
    private final TextView mExtraMessage;
    private final TextView mMessage;
    private int mState;
    private boolean mVisible = true;

    public SuspendBar(Activity activity) {
        this.mActivity = activity;
        this.mContainer = this.mActivity.findViewById(C0329R.id.suspend_bar);
        this.mContainer.setOnClickListener(this);
        this.mMessage = (TextView) this.mContainer.findViewById(C0329R.id.message);
        this.mExtraMessage = (TextView) this.mContainer.findViewById(C0329R.id.extra_message);
        this.mExtraMessage.setOnClickListener(this);
        this.mCancleButton = (ImageView) this.mContainer.findViewById(C0329R.id.cancle_button);
        this.mCancleButton.setOnClickListener(this);
        this.mState = 0;
    }

    public void refresh() {
        int i = 0;
        if (ThunderStoneKtvNetwork.isBinded()) {
            this.mState = 1;
            this.mContainer.setVisibility(0);
            this.mContainer.setBackgroundResource(C0329R.drawable.suspend_bar_bg_orange);
            this.mMessage.setText(this.mContainer.getContext().getString(C0329R.string.ktv_and_room, new Object[]{ThunderStoneKtvNetwork.getKtvName(), ThunderStoneKtvNetwork.getRoomName()}));
            this.mExtraMessage.setText(null);
            return;
        }
        Context context = this.mContainer.getContext();
        String vipRemind = AccountPermissionHelper.getVipRemindText();
        if (!PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_VIP_REMINDED) && vipRemind != null) {
            this.mState = 2;
            this.mContainer.setVisibility(0);
            this.mContainer.setBackgroundResource(C0329R.drawable.suspend_bar_bg_orange);
            this.mMessage.setText(vipRemind);
            this.mExtraMessage.setText(null);
        } else if (!AccountPermissionHelper.isVipTimeOut() || PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_VIP_TIME_OUT)) {
            this.mState = 0;
            this.mContainer.setVisibility(8);
        } else {
            this.mState = 3;
            this.mContainer.setVisibility(0);
            this.mContainer.setBackgroundResource(C0329R.drawable.suspend_bar_bg_red);
            this.mMessage.setText(C0329R.string.vip_expired);
            this.mExtraMessage.setText(C0329R.string.vip_rebuy);
            this.mExtraMessage.setBackgroundResource(C0329R.drawable.vip_rebuy_button);
        }
        View view = this.mContainer;
        if (!(this.mVisible && this.mContainer.getVisibility() == 0)) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void onClick(View v) {
        Context context = v.getContext();
        if (v == this.mCancleButton) {
            switch (this.mState) {
                case 1:
                    Intent intent = new Intent(Actions.ACTION_KTV_DISCONNECT);
                    intent.setPackage(context.getPackageName());
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return;
                case 2:
                    PreferenceCache.setPrefAsBoolean(context, PreferenceCache.PREF_VIP_REMINDED, true);
                    sendVisibleChangedBroadcast();
                    this.mContainer.setVisibility(4);
                    return;
                case 3:
                    PreferenceCache.setPrefAsBoolean(context, PreferenceCache.PREF_VIP_TIME_OUT, true);
                    sendVisibleChangedBroadcast();
                    this.mContainer.setVisibility(4);
                    return;
                default:
                    return;
            }
        } else if (v == this.mContainer) {
            switch (this.mState) {
                case 2:
                case 3:
                    context.startActivity(new Intent(context, VipRecommendActivity.class));
                    return;
                default:
                    return;
            }
        } else if (v == this.mExtraMessage) {
            switch (this.mState) {
                case 3:
                    VipOrderHelper.createOrderAsync(this.mActivity, Long.toString(VipOrderHelper.DEFAULT_PRODUCT_ID), null);
                    return;
                default:
                    return;
            }
        }
    }

    private void sendVisibleChangedBroadcast() {
        Context context = MusicApplication.getApplication();
        Intent intent = new Intent(Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public void setVisible(boolean visible) {
        this.mVisible = visible;
        this.mContainer.setVisibility(visible ? 0 : 8);
        this.mState = 0;
        refresh();
    }
}
