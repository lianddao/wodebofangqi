package com.ushareit.listenit;

class gsi implements Runnable {
    final /* synthetic */ gsg f14643a;

    gsi(gsg com_ushareit_listenit_gsg) {
        this.f14643a = com_ushareit_listenit_gsg;
    }

    public void run() {
        if (grr.m22621a().m22648d()) {
            grr.m22621a().m22642a(eys.m18562a(), true);
            return;
        }
        grr.m22621a().m22647c();
        this.f14643a.f14639b.removeCallbacks(this.f14643a.f14641d);
        this.f14643a.f14639b.postDelayed(this.f14643a.f14641d, 500);
    }
}
