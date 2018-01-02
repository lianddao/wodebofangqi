package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.ushareit.listenit.sleep.SleepPopupView;

public class gws implements TextWatcher {
    final /* synthetic */ SleepPopupView f14835a;

    public gws(SleepPopupView sleepPopupView) {
        this.f14835a = sleepPopupView;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f14835a.f16497c.setEnabled(!TextUtils.isEmpty(editable.toString()));
    }
}
