package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class gok implements OnClickListener {
    final /* synthetic */ ConfirmPopupView f14507a;

    public gok(ConfirmPopupView confirmPopupView) {
        this.f14507a = confirmPopupView;
    }

    public void onClick(View view) {
        if (this.f14507a.f16157m == null || !this.f14507a.f16157m.mo2508a(view)) {
            if (this.f14507a.f16148d.getVisibility() == 0) {
                this.f14507a.m25553j();
            }
            this.f14507a.mo3063e();
        }
    }
}
