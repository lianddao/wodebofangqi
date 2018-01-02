package com.ushareit.listenit;

public class aex<R> implements aes<R> {
    private final aew f4249a;
    private aeq<R> f4250b;

    aex(aew com_ushareit_listenit_aew) {
        this.f4249a = com_ushareit_listenit_aew;
    }

    public aeq<R> mo610a(boolean z, boolean z2) {
        if (z || !z2) {
            return aet.m5422b();
        }
        if (this.f4250b == null) {
            this.f4250b = new aev(this.f4249a);
        }
        return this.f4250b;
    }
}
