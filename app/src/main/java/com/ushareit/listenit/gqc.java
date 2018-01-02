package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.NearbyGuidePopupView;

public class gqc implements Runnable {
    final /* synthetic */ View f14548a;
    final /* synthetic */ NearbyGuidePopupView f14549b;

    public gqc(NearbyGuidePopupView nearbyGuidePopupView, View view) {
        this.f14549b = nearbyGuidePopupView;
        this.f14548a = view;
    }

    public void run() {
        this.f14549b.m25602a(this.f14548a);
    }
}
