package com.ushareit.listenit;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public final class dln<TResult> extends dlj {
    private static final Status f9884e = new Status(8, "Connection to Google Play services was lost while executing the API call.");
    private final dos<cdq, TResult> f9885c;
    private final dzp<TResult> f9886d;

    public dln(int i, int i2, dos<cdq, TResult> com_ushareit_listenit_dos_com_ushareit_listenit_cdq__TResult, dzp<TResult> com_ushareit_listenit_dzp_TResult) {
        super(i, i2);
        this.f9886d = com_ushareit_listenit_dzp_TResult;
        this.f9885c = com_ushareit_listenit_dos_com_ushareit_listenit_cdq__TResult;
    }

    public void mo1943a(Status status) {
        if (status.m2259h() == 8) {
            this.f9886d.m16567a(new eal(status.m2254c()));
        } else {
            this.f9886d.m16567a(new eag(status.m2254c()));
        }
    }

    public void mo1944a(cdq com_ushareit_listenit_cdq) {
        try {
            this.f9885c.mo1396a(com_ushareit_listenit_cdq, this.f9886d);
        } catch (DeadObjectException e) {
            mo1943a(f9884e);
            throw e;
        } catch (RemoteException e2) {
            mo1943a(f9884e);
        }
    }
}
