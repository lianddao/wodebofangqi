package com.ushareit.listenit;

class cpt implements Runnable {
    final /* synthetic */ Runnable f8667a;
    final /* synthetic */ cps f8668b;

    cpt(cps com_ushareit_listenit_cps, Runnable runnable) {
        this.f8668b = com_ushareit_listenit_cps;
        this.f8667a = runnable;
    }

    public void run() {
        this.f8668b.f8664h = null;
        this.f8667a.run();
    }
}
