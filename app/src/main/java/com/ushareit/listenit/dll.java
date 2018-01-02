package com.ushareit.listenit;

import android.util.SparseArray;
import com.google.android.gms.common.api.Status;

public class dll<A extends dlu<? extends ceg, cdq>> extends dlj {
    protected final A f9881c;

    public dll(int i, int i2, A a) {
        super(i, i2);
        this.f9881c = a;
    }

    public void mo1942a(SparseArray<dow> sparseArray) {
        dow com_ushareit_listenit_dow = (dow) sparseArray.get(this.a);
        if (com_ushareit_listenit_dow != null) {
            com_ushareit_listenit_dow.m15206a(this.f9881c);
        }
    }

    public void mo1943a(Status status) {
        this.f9881c.m10810c(status);
    }

    public void mo1944a(cdq com_ushareit_listenit_cdq) {
        this.f9881c.m10808b(com_ushareit_listenit_cdq);
    }

    public boolean mo1945a() {
        return this.f9881c.m10797f();
    }
}
