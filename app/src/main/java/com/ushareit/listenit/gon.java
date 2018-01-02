package com.ushareit.listenit;

import android.view.inputmethod.InputMethodManager;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class gon implements Runnable {
    final /* synthetic */ ConfirmPopupView f14510a;

    public gon(ConfirmPopupView confirmPopupView) {
        this.f14510a = confirmPopupView;
    }

    public void run() {
        this.f14510a.f16149e.setFocusable(true);
        this.f14510a.f16149e.requestFocus();
        ((InputMethodManager) this.f14510a.getContext().getSystemService("input_method")).showSoftInput(this.f14510a.f16149e, 1);
    }
}
