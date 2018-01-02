package com.ushareit.listenit;

import com.google.firebase.database.connection.idl.CompoundHashParcelable;
import com.google.firebase.database.connection.idl.IPersistentConnectionImpl;

public class eda implements coo {
    final /* synthetic */ edu f10848a;
    final /* synthetic */ IPersistentConnectionImpl f10849b;

    public eda(IPersistentConnectionImpl iPersistentConnectionImpl, edu com_ushareit_listenit_edu) {
        this.f10849b = iPersistentConnectionImpl;
        this.f10848a = com_ushareit_listenit_edu;
    }

    public String mo1576a() {
        try {
            return this.f10848a.mo2146a();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public boolean mo1578b() {
        try {
            return this.f10848a.mo2147b();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public coe mo1579c() {
        try {
            return CompoundHashParcelable.m2534a(this.f10848a.mo2148c());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
