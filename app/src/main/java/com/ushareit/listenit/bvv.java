package com.ushareit.listenit;

class bvv implements Runnable {
    final /* synthetic */ bvu f7871a;

    bvv(bvu com_ushareit_listenit_bvu) {
        this.f7871a = com_ushareit_listenit_bvu;
    }

    public void run() {
        if (this.f7871a.f7870a != null) {
            try {
                this.f7871a.f7870a.mo1172a(1);
            } catch (Throwable e) {
                bze.m10491c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
