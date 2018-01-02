package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class hjh implements OnClickListener {
    final /* synthetic */ hje f15520a;

    hjh(hje com_ushareit_listenit_hje) {
        this.f15520a = com_ushareit_listenit_hje;
    }

    public void onClick(View view) {
        this.f15520a.al = Boolean.valueOf(!this.f15520a.al.booleanValue());
        this.f15520a.av.setSelected(this.f15520a.al.booleanValue());
    }
}
