package com.ushareit.listenit;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class gsu implements OnEditorActionListener {
    final /* synthetic */ gsq f14680a;

    gsu(gsq com_ushareit_listenit_gsq) {
        this.f14680a = com_ushareit_listenit_gsq;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3 || this.f14680a.al == null) {
            return false;
        }
        this.f14680a.al.mo2741a(this.f14680a.f14669b.getText().toString().trim());
        return true;
    }
}
