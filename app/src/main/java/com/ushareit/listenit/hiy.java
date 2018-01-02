package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class hiy implements OnClickListener {
    final /* synthetic */ hix f15515a;

    hiy(hix com_ushareit_listenit_hix) {
        this.f15515a = com_ushareit_listenit_hix;
    }

    public void onClick(View view) {
        if (this.f15515a.g.f15495h != null) {
            this.f15515a.g.f15495h.mo2787a(this.f15515a.b);
        }
        if (this.f15515a.g.f15489b.contains(this.f15515a.g.f15488a)) {
            StringBuilder stringBuilder = new StringBuilder();
            hik com_ushareit_listenit_hik = this.f15515a.g;
            com_ushareit_listenit_hik.f15489b = stringBuilder.append(com_ushareit_listenit_hik.f15489b).append("?ch=ZKJ").toString();
        }
        hip.m23907a(this.f15515a.a, "com.qzone", this.f15515a.g.f15489b);
    }
}
