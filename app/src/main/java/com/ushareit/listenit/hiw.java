package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class hiw implements OnClickListener {
    final /* synthetic */ hiv f15513a;

    hiw(hiv com_ushareit_listenit_hiv) {
        this.f15513a = com_ushareit_listenit_hiv;
    }

    public void onClick(View view) {
        if (this.f15513a.g.f15495h != null) {
            this.f15513a.g.f15495h.mo2787a(this.f15513a.b);
        }
        if (this.f15513a.g.f15489b.contains(this.f15513a.g.f15488a)) {
            StringBuilder stringBuilder = new StringBuilder();
            hik com_ushareit_listenit_hik = this.f15513a.g;
            com_ushareit_listenit_hik.f15489b = stringBuilder.append(com_ushareit_listenit_hik.f15489b).append("?ch=ZQQ").toString();
        }
        hip.m23907a(this.f15513a.a, "com.tencent.mobileqq", this.f15513a.g.f15489b);
    }
}
