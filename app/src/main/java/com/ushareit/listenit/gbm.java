package com.ushareit.listenit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class gbm implements OnClickListener {
    final /* synthetic */ Object f13859a;
    final /* synthetic */ String[] f13860b;

    gbm(Object obj, String[] strArr) {
        this.f13859a = obj;
        this.f13860b = strArr;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        gbk.m21602b(this.f13859a, this.f13860b, 257);
    }
}
