package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class hgc implements OnClickListener {
    final /* synthetic */ hft f15394a;

    hgc(hft com_ushareit_listenit_hft) {
        this.f15394a = com_ushareit_listenit_hft;
    }

    public void onClick(View view) {
        this.f15394a.m23662a(!this.f15394a.f15378t);
        if (this.f15394a.f15378t) {
            this.f15394a.f15382x = false;
            this.f15394a.f15368j.setVisibility(8);
            this.f15394a.f15366h.m27111e();
            this.f15394a.m23673i();
            return;
        }
        this.f15394a.f15366h.m27112f();
        this.f15394a.f15384z.removeCallbacks(this.f15394a.f15358A);
    }
}
