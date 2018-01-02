package com.ushareit.listenit;

import android.view.View;

public class aev<R> implements aeq<R> {
    private final aew f4248a;

    aev(aew com_ushareit_listenit_aew) {
        this.f4248a = com_ushareit_listenit_aew;
    }

    public boolean mo612a(R r, aer com_ushareit_listenit_aer) {
        View a = com_ushareit_listenit_aer.m5418a();
        if (a != null) {
            a.clearAnimation();
            a.startAnimation(this.f4248a.mo611a());
        }
        return false;
    }
}
