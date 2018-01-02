package com.ushareit.listenit;

class dji implements Runnable {
    final /* synthetic */ bed f9854a;
    final /* synthetic */ djh f9855b;

    dji(djh com_ushareit_listenit_djh, bed com_ushareit_listenit_bed) {
        this.f9855b = com_ushareit_listenit_djh;
        this.f9854a = com_ushareit_listenit_bed;
    }

    public void run() {
        try {
            this.f9855b.f9853a.mo1838a(djk.m14657a(this.f9854a));
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdFailedToLoad.", e);
        }
    }
}
