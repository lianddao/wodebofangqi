package com.ushareit.listenit;

import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class goo implements TextWatcher {
    final /* synthetic */ ConfirmPopupView f14511a;

    public goo(ConfirmPopupView confirmPopupView) {
        this.f14511a = confirmPopupView;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f14511a.f16151g.setText(editable.length() + "/" + 40);
        if (editable.toString().trim().length() == 0) {
            this.f14511a.f16154j.setEnabled(false);
            this.f14511a.f16154j.setTextColor(this.f14511a.getResources().getColor(C0349R.color.common_text_color_gray));
            this.f14511a.f16150f.setBackgroundColor(this.f14511a.getResources().getColor(C0349R.color.confirm_view_underline_color));
            return;
        }
        this.f14511a.f16154j.setEnabled(true);
        if (gzd.m23364e() == 2) {
            int b = gzd.m23358b();
            this.f14511a.f16154j.setTextColor(b);
            this.f14511a.f16150f.setBackgroundDrawable(new ColorDrawable(b));
            return;
        }
        this.f14511a.f16154j.setTextColor(this.f14511a.getResources().getColorStateList(C0349R.color.common_text_orange_bg));
        this.f14511a.f16150f.setBackgroundColor(this.f14511a.getResources().getColor(C0349R.color.common_text_color_orange));
    }
}
