package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;
import com.ushareit.listenit.widget.SearchWidget;

public class hdy implements TextWatcher {
    final /* synthetic */ SearchWidget f15243a;
    private String f15244b = null;

    public hdy(SearchWidget searchWidget) {
        this.f15243a = searchWidget;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        if (!fbb.m18763c(obj) || !fbb.m18763c(this.f15244b)) {
            if (fbb.m18763c(obj) || fbb.m18763c(this.f15244b) || !obj.equals(this.f15244b)) {
                this.f15243a.m26992a(obj);
                this.f15244b = obj;
            }
        }
    }
}
