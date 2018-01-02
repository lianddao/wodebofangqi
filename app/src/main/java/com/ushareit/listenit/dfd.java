package com.ushareit.listenit;

final class dfd implements dbr {
    final /* synthetic */ Class f9727a;
    final /* synthetic */ dbq f9728b;

    dfd(Class cls, dbq com_ushareit_listenit_dbq) {
        this.f9727a = cls;
        this.f9728b = com_ushareit_listenit_dbq;
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        return this.f9727a.isAssignableFrom(com_ushareit_listenit_dft_T.m14120a()) ? this.f9728b : null;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9727a.getName());
        String valueOf2 = String.valueOf(this.f9728b);
        return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Factory[typeHierarchy=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
    }
}
