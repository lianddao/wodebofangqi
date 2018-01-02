package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.AdFlashView;

public class gij implements OnClickListener {
    final /* synthetic */ AdFlashView f14165a;

    public gij(AdFlashView adFlashView) {
        this.f14165a = adFlashView;
    }

    public void onClick(View view) {
        gik a = this.f14165a.f15893d;
        this.f14165a.f15893d = null;
        if (a != null) {
            if (this.f14165a.f15892c != null && this.f14165a.f15892c.m17719b("NativeAdListener")) {
                ((fge) this.f14165a.f15892c.m17720c("NativeAdListener")).onNativeAdClose();
            }
            this.f14165a.f15890a.removeCallbacks(this.f14165a.f15891b);
            a.mo2686a();
        }
    }
}
