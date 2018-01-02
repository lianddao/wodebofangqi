package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;
import com.ushareit.listenit.popupview.EditID3TagPopupView;

public class gos implements TextWatcher {
    final /* synthetic */ EditID3TagPopupView f14514a;

    public gos(EditID3TagPopupView editID3TagPopupView) {
        this.f14514a = editID3TagPopupView;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        EditID3TagPopupView editID3TagPopupView = this.f14514a;
        boolean z = (fbb.m18763c(obj) || obj.equals(this.f14514a.f16177q.f14338f)) ? false : true;
        editID3TagPopupView.m25570a(z);
    }
}
