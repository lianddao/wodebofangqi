package com.ushareit.listenit;

import android.view.inputmethod.InputMethodManager;
import com.ushareit.listenit.popupview.EditID3TagPopupView;

public class gow implements Runnable {
    final /* synthetic */ EditID3TagPopupView f14518a;

    public gow(EditID3TagPopupView editID3TagPopupView) {
        this.f14518a = editID3TagPopupView;
    }

    public void run() {
        if (this.f14518a.f16174n == null) {
            this.f14518a.f16174n = (InputMethodManager) this.f14518a.getContext().getSystemService("input_method");
        }
        this.f14518a.f16161a.setSelection(this.f14518a.f16161a.m26317c());
        this.f14518a.f16174n.showSoftInput(this.f14518a.f16161a, 1);
    }
}
