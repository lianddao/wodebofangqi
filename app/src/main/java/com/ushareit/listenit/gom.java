package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class gom implements OnClickListener {
    final /* synthetic */ ConfirmPopupView f14509a;

    public gom(ConfirmPopupView confirmPopupView) {
        this.f14509a = confirmPopupView;
    }

    public void onClick(View view) {
        this.f14509a.f16156l = !this.f14509a.f16156l;
        this.f14509a.f16152h.setChecked(this.f14509a.f16156l);
    }
}
