package com.ushareit.listenit;

import android.widget.PopupWindow.OnDismissListener;

class fuw implements OnDismissListener {
    final /* synthetic */ fus f13551a;

    fuw(fus com_ushareit_listenit_fus) {
        this.f13551a = com_ushareit_listenit_fus;
    }

    public void onDismiss() {
        if (this.f13551a.f13536a != null) {
            this.f13551a.f13536a.setOnVolumeTouchChangedListener(null);
            this.f13551a.f13536a.setOnAdjustVolumeFailureListener(null);
            this.f13551a.f13536a = null;
        }
        this.f13551a.f13537b = null;
        this.f13551a.m21039e();
    }
}
