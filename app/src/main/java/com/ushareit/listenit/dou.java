package com.ushareit.listenit;

class dou implements Runnable {
    final /* synthetic */ ceg f10112a;
    final /* synthetic */ dot f10113b;

    dou(dot com_ushareit_listenit_dot, ceg com_ushareit_listenit_ceg) {
        this.f10113b = com_ushareit_listenit_dot;
        this.f10112a = com_ushareit_listenit_ceg;
    }

    public void run() {
        cdz com_ushareit_listenit_cdz;
        try {
            dma.f8104d.set(Boolean.valueOf(true));
            this.f10113b.f10110h.sendMessage(this.f10113b.f10110h.obtainMessage(0, this.f10113b.f10103a.m10970a(this.f10112a)));
            dma.f8104d.set(Boolean.valueOf(false));
            this.f10113b.m15194b(this.f10112a);
            com_ushareit_listenit_cdz = (cdz) this.f10113b.f10109g.get();
            if (com_ushareit_listenit_cdz != null) {
                com_ushareit_listenit_cdz.mo2003b(this.f10113b);
            }
        } catch (RuntimeException e) {
            this.f10113b.f10110h.sendMessage(this.f10113b.f10110h.obtainMessage(1, e));
            dma.f8104d.set(Boolean.valueOf(false));
            this.f10113b.m15194b(this.f10112a);
            com_ushareit_listenit_cdz = (cdz) this.f10113b.f10109g.get();
            if (com_ushareit_listenit_cdz != null) {
                com_ushareit_listenit_cdz.mo2003b(this.f10113b);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            dma.f8104d.set(Boolean.valueOf(false));
            this.f10113b.m15194b(this.f10112a);
            com_ushareit_listenit_cdz = (cdz) this.f10113b.f10109g.get();
            if (com_ushareit_listenit_cdz != null) {
                com_ushareit_listenit_cdz.mo2003b(this.f10113b);
            }
        }
    }
}
