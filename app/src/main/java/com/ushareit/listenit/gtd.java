package com.ushareit.listenit;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class gtd implements OnEditorActionListener {
    final /* synthetic */ gta f14702a;

    gtd(gta com_ushareit_listenit_gta) {
        this.f14702a = com_ushareit_listenit_gta;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.f14702a.m22737X();
        fio.m19367b(this.f14702a.m1326l(), "search in soft input");
        return true;
    }
}
