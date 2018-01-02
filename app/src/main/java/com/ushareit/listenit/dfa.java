package com.ushareit.listenit;

final class dfa implements dbr {
    final /* synthetic */ Class f9721a;
    final /* synthetic */ Class f9722b;
    final /* synthetic */ dbq f9723c;

    dfa(Class cls, Class cls2, dbq com_ushareit_listenit_dbq) {
        this.f9721a = cls;
        this.f9722b = cls2;
        this.f9723c = com_ushareit_listenit_dbq;
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        Class a = com_ushareit_listenit_dft_T.m14120a();
        return (a == this.f9721a || a == this.f9722b) ? this.f9723c : null;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9722b.getName());
        String valueOf2 = String.valueOf(this.f9721a.getName());
        String valueOf3 = String.valueOf(this.f9723c);
        return new StringBuilder(((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
    }
}
