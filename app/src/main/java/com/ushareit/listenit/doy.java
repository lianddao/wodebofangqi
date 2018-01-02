package com.ushareit.listenit;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import java.lang.ref.WeakReference;

class doy implements DeathRecipient, doz {
    private final WeakReference<dma<?>> f10122a;
    private final WeakReference<cep> f10123b;
    private final WeakReference<IBinder> f10124c;

    private doy(dma<?> com_ushareit_listenit_dma_, cep com_ushareit_listenit_cep, IBinder iBinder) {
        this.f10123b = new WeakReference(com_ushareit_listenit_cep);
        this.f10122a = new WeakReference(com_ushareit_listenit_dma_);
        this.f10124c = new WeakReference(iBinder);
    }

    private void m15213a() {
        dma com_ushareit_listenit_dma = (dma) this.f10122a.get();
        cep com_ushareit_listenit_cep = (cep) this.f10123b.get();
        if (!(com_ushareit_listenit_cep == null || com_ushareit_listenit_dma == null)) {
            com_ushareit_listenit_cep.m10987a(com_ushareit_listenit_dma.mo1271a().intValue());
        }
        IBinder iBinder = (IBinder) this.f10124c.get();
        if (iBinder != null) {
            iBinder.unlinkToDeath(this, 0);
        }
    }

    public void mo2016a(dma<?> com_ushareit_listenit_dma_) {
        m15213a();
    }

    public void binderDied() {
        m15213a();
    }
}
