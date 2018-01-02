package com.ushareit.listenit;

final class dfc implements dbr {
    final /* synthetic */ Class f9724a;
    final /* synthetic */ Class f9725b;
    final /* synthetic */ dbq f9726c;

    dfc(Class cls, Class cls2, dbq com_ushareit_listenit_dbq) {
        this.f9724a = cls;
        this.f9725b = cls2;
        this.f9726c = com_ushareit_listenit_dbq;
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        Class a = com_ushareit_listenit_dft_T.m14120a();
        return (a == this.f9724a || a == this.f9725b) ? this.f9726c : null;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9724a.getName());
        String valueOf2 = String.valueOf(this.f9725b.getName());
        String valueOf3 = String.valueOf(this.f9726c);
        return new StringBuilder(((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
    }
}
