package com.ushareit.listenit;

import com.google.android.gms.common.data.DataHolder;
import java.util.Iterator;

public abstract class ces<T> implements cet<T> {
    protected final DataHolder f8200a;

    protected ces(DataHolder dataHolder) {
        this.f8200a = dataHolder;
        if (this.f8200a == null) {
        }
    }

    public void mo1297a() {
        if (this.f8200a != null) {
            this.f8200a.close();
        }
    }

    public int mo1298b() {
        return this.f8200a == null ? 0 : this.f8200a.m2271g();
    }

    public Iterator<T> iterator() {
        return new cex(this);
    }
}
