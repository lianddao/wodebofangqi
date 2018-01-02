package com.ushareit.listenit;

class bvt implements Runnable {
    final /* synthetic */ bvs f7869a;

    bvt(bvs com_ushareit_listenit_bvs) {
        this.f7869a = com_ushareit_listenit_bvs;
    }

    public void run() {
        if (this.f7869a.f7868a.f7867a != null) {
            try {
                this.f7869a.f7868a.f7867a.mo1172a(1);
            } catch (Throwable e) {
                bze.m10491c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
