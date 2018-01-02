package com.ushareit.listenit;

final class dez implements dbr {
    final /* synthetic */ Class f9719a;
    final /* synthetic */ dbq f9720b;

    dez(Class cls, dbq com_ushareit_listenit_dbq) {
        this.f9719a = cls;
        this.f9720b = com_ushareit_listenit_dbq;
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        return com_ushareit_listenit_dft_T.m14120a() == this.f9719a ? this.f9720b : null;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9719a.getName());
        String valueOf2 = String.valueOf(this.f9720b);
        return new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append("Factory[type=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
    }
}
