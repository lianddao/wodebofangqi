package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class gol implements OnClickListener {
    final /* synthetic */ ConfirmPopupView f14508a;

    public gol(ConfirmPopupView confirmPopupView) {
        this.f14508a = confirmPopupView;
    }

    public void onClick(View view) {
        if (this.f14508a.f16157m == null || !this.f14508a.f16157m.mo2509b(view)) {
            if (this.f14508a.f16148d.getVisibility() == 0) {
                this.f14508a.m25553j();
            }
            this.f14508a.mo3063e();
        }
    }
}
