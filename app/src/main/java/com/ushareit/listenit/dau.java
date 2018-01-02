package com.ushareit.listenit;

class dau<T> extends dbq<T> {
    private dbq<T> f9478a;

    dau() {
    }

    public void m13679a(dbq<T> com_ushareit_listenit_dbq_T) {
        if (this.f9478a != null) {
            throw new AssertionError();
        }
        this.f9478a = com_ushareit_listenit_dbq_T;
    }

    public void mo1400a(dfx com_ushareit_listenit_dfx, T t) {
        if (this.f9478a == null) {
            throw new IllegalStateException();
        }
        this.f9478a.mo1400a(com_ushareit_listenit_dfx, t);
    }

    public T mo1401b(dfu com_ushareit_listenit_dfu) {
        if (this.f9478a != null) {
            return this.f9478a.mo1401b(com_ushareit_listenit_dfu);
        }
        throw new IllegalStateException();
    }
}
