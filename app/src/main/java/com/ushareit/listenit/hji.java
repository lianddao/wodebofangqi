package com.ushareit.listenit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class hji implements OnKeyListener {
    final /* synthetic */ hje f15521a;

    hji(hje com_ushareit_listenit_hje) {
        this.f15521a = com_ushareit_listenit_hje;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return !this.f15521a.am && i == 4 && keyEvent.getRepeatCount() == 0;
    }
}
