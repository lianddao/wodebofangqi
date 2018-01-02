package com.ushareit.listenit;

import com.google.android.gms.common.api.GoogleApiActivity;

class dly implements Runnable {
    final /* synthetic */ dlw f9905a;

    private dly(dlw com_ushareit_listenit_dlw) {
        this.f9905a = com_ushareit_listenit_dlw;
    }

    public void run() {
        if (!this.f9905a.f9892a) {
            return;
        }
        if (this.f9905a.f9895e.m2234a()) {
            this.f9905a.d.startActivityForResult(GoogleApiActivity.m2246b(this.f9905a.m13527e(), this.f9905a.f9895e.m2237d(), this.f9905a.f9896f, false), 1);
        } else if (this.f9905a.f9894c.mo1291a(this.f9905a.f9895e.m2236c())) {
            this.f9905a.f9894c.m10900a(this.f9905a.m13527e(), this.f9905a.d, this.f9905a.f9895e.m2236c(), 2, this.f9905a);
        } else if (this.f9905a.f9895e.m2236c() == 18) {
            this.f9905a.f9894c.m10896a(this.f9905a.m13527e().getApplicationContext(), new dlz(this, this.f9905a.f9894c.m10890a(this.f9905a.m13527e(), this.f9905a)));
        } else {
            this.f9905a.mo1951a(this.f9905a.f9895e, this.f9905a.f9896f);
        }
    }
}
