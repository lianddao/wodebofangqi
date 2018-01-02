package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cloudsync.CloudSyncService;
import com.ushareit.listenit.popupview.SyncTrafficAlertPopupView;

public class grg implements OnClickListener {
    final /* synthetic */ SyncTrafficAlertPopupView f14581a;

    public grg(SyncTrafficAlertPopupView syncTrafficAlertPopupView) {
        this.f14581a = syncTrafficAlertPopupView;
    }

    public void onClick(View view) {
        CloudSyncService.m11590a(0);
        this.f14581a.mo3063e();
    }
}
