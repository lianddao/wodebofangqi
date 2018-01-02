package com.ushareit.listenit;

import android.view.animation.Animation;

class awq implements Runnable {
    final /* synthetic */ awp f5589a;

    awq(awp com_ushareit_listenit_awp) {
        this.f5589a = com_ushareit_listenit_awp;
    }

    public void run() {
        if (this.f5589a.f5588c.f681g) {
            this.f5589a.f5588c.f681g = false;
            Animation com_ushareit_listenit_awr = new awr(this);
            com_ushareit_listenit_awr.setDuration(300);
            com_ushareit_listenit_awr.setFillAfter(true);
            this.f5589a.f5588c.startAnimation(com_ushareit_listenit_awr);
        }
    }
}
