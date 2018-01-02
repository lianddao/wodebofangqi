package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;
import com.ushareit.listenit.popupview.EditID3TagPopupView;

public class got implements TextWatcher {
    final /* synthetic */ EditID3TagPopupView f14515a;

    public got(EditID3TagPopupView editID3TagPopupView) {
        this.f14515a = editID3TagPopupView;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        EditID3TagPopupView editID3TagPopupView = this.f14515a;
        boolean z = (fbb.m18763c(obj) || obj.equals(this.f14515a.f16177q.f14339g)) ? false : true;
        editID3TagPopupView.m25570a(z);
    }
}
