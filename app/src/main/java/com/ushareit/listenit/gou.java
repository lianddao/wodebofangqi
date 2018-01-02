package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;
import com.ushareit.listenit.popupview.EditID3TagPopupView;

public class gou implements TextWatcher {
    final /* synthetic */ EditID3TagPopupView f14516a;

    public gou(EditID3TagPopupView editID3TagPopupView) {
        this.f14516a = editID3TagPopupView;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        EditID3TagPopupView editID3TagPopupView = this.f14516a;
        boolean z = (fbb.m18763c(obj) || obj.equals(this.f14516a.f16177q.f14340h)) ? false : true;
        editID3TagPopupView.m25570a(z);
    }
}
