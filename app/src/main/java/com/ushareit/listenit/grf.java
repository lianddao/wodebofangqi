package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cloudsync.CloudSyncService;
import com.ushareit.listenit.popupview.SyncTrafficAlertPopupView;

public class grf implements OnClickListener {
    final /* synthetic */ SyncTrafficAlertPopupView f14580a;

    public grf(SyncTrafficAlertPopupView syncTrafficAlertPopupView) {
        this.f14580a = syncTrafficAlertPopupView;
    }

    public void onClick(View view) {
        CloudSyncService.m11590a(2);
        this.f14580a.mo3063e();
    }
}
