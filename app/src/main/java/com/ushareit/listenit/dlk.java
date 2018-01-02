package com.ushareit.listenit;

import android.os.RemoteException;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import java.util.Map;

abstract class dlk extends dlj {
    protected final SparseArray<Map<doi<?>, dol>> f9879c;
    protected final dzp<Void> f9880d;

    public dlk(int i, int i2, dzp<Void> com_ushareit_listenit_dzp_java_lang_Void, SparseArray<Map<doi<?>, dol>> sparseArray) {
        super(i, i2);
        this.f9879c = sparseArray;
        this.f9880d = com_ushareit_listenit_dzp_java_lang_Void;
    }

    private void m14769a(RemoteException remoteException) {
        mo1943a(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public void mo1942a(SparseArray<dow> sparseArray) {
    }

    public void mo1943a(Status status) {
        this.f9880d.m16567a(new cel(status));
    }

    public final void mo1944a(cdq com_ushareit_listenit_cdq) {
        try {
            mo1946b(com_ushareit_listenit_cdq);
        } catch (RemoteException e) {
            m14769a(e);
            throw e;
        } catch (RemoteException e2) {
            m14769a(e2);
        }
    }

    public boolean mo1945a() {
        this.f9880d.m16567a(new cel(Status.f1690e));
        return true;
    }

    protected abstract void mo1946b(cdq com_ushareit_listenit_cdq);
}
