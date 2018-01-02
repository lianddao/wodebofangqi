package com.ushareit.listenit;

class gzf implements Runnable {
    final /* synthetic */ Object f14950a;
    final /* synthetic */ faw f14951b;
    final /* synthetic */ gze f14952c;

    gzf(gze com_ushareit_listenit_gze, Object obj, faw com_ushareit_listenit_faw) {
        this.f14952c = com_ushareit_listenit_gze;
        this.f14950a = obj;
        this.f14951b = com_ushareit_listenit_faw;
    }

    public void run() {
        try {
            this.f14952c.f12951c.remove(this.f14950a);
            this.f14952c.f12952d.add(this.f14950a);
            this.f14952c.f12955g.m23370a(this.f14950a);
            this.f14951b.mo2286a();
        } catch (Throwable e) {
            exw.m18457e(gze.f12949a, "execute: error=" + exw.m18438a(e));
            this.f14952c.f12955g.m23373d(this.f14950a);
        } finally {
            this.f14952c.f12950b.remove(this.f14950a);
            this.f14952c.f12952d.remove(this.f14950a);
            this.f14952c.f12955g.m23372c(this.f14950a);
        }
    }
}
