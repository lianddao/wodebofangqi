package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fxa implements OnClickListener {
    final /* synthetic */ fww f13650a;

    fxa(fww com_ushareit_listenit_fww) {
        this.f13650a = com_ushareit_listenit_fww;
    }

    public void onClick(View view) {
        if (this.f13650a.f13642f.m18926c() != this.f13650a.f13642f.getCount() || this.f13650a.f13642f.getCount() == 0) {
            this.f13650a.f13642f.m18929f();
            fip.m19369a(this.f13650a.m1326l(), "UF_ManageSelectAll", this.f13650a.aj.mo2565a());
        } else {
            this.f13650a.f13642f.m18928e();
            fip.m19369a(this.f13650a.m1326l(), "UF_ManageCancelAll", this.f13650a.aj.mo2565a());
        }
        this.f13650a.m21220W();
        this.f13650a.f13644h.m26965a(this.f13650a.f13642f.m18926c() > 0);
    }
}
