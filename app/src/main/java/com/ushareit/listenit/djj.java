package com.ushareit.listenit;

class djj implements Runnable {
    final /* synthetic */ bed f9856a;
    final /* synthetic */ djh f9857b;

    djj(djh com_ushareit_listenit_djh, bed com_ushareit_listenit_bed) {
        this.f9857b = com_ushareit_listenit_djh;
        this.f9856a = com_ushareit_listenit_bed;
    }

    public void run() {
        try {
            this.f9857b.f9853a.mo1838a(djk.m14657a(this.f9856a));
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdFailedToLoad.", e);
        }
    }
}
