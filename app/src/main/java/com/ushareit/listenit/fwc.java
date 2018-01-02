package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class fwc implements OnScrollListener {
    final /* synthetic */ fvs f13613a;

    fwc(fvs com_ushareit_listenit_fvs) {
        this.f13613a = com_ushareit_listenit_fvs;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f13613a.f13597e.m18919a(i);
        switch (i) {
            case 1:
                if (this.f13613a.ak && !this.f13613a.al) {
                    this.f13613a.al = true;
                    fet.m19025b(this.f13613a.m1328m(), new fwd(this, 30000));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (!this.f13613a.ak) {
            return;
        }
        if (i == 0) {
            this.f13613a.f13595c.setVisibility(8);
        } else {
            this.f13613a.f13595c.setVisibility(0);
        }
    }
}
