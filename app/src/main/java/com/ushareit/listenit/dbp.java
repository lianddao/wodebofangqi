package com.ushareit.listenit;

class dbp implements dbr {
    private final dft<?> f9502a;
    private final boolean f9503b;
    private final Class<?> f9504c;
    private final dbi<?> f9505d;
    private final daz<?> f9506e;

    private dbp(Object obj, dft<?> com_ushareit_listenit_dft_, boolean z, Class<?> cls) {
        this.f9505d = obj instanceof dbi ? (dbi) obj : null;
        this.f9506e = obj instanceof daz ? (daz) obj : null;
        boolean z2 = (this.f9505d == null && this.f9506e == null) ? false : true;
        dbw.m13749a(z2);
        this.f9502a = com_ushareit_listenit_dft_;
        this.f9503b = z;
        this.f9504c = cls;
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        boolean isAssignableFrom = this.f9502a != null ? this.f9502a.equals(com_ushareit_listenit_dft_T) || (this.f9503b && this.f9502a.m14121b() == com_ushareit_listenit_dft_T.m14120a()) : this.f9504c.isAssignableFrom(com_ushareit_listenit_dft_T.m14120a());
        return isAssignableFrom ? new dbn(this.f9505d, this.f9506e, com_ushareit_listenit_dao, com_ushareit_listenit_dft_T, this) : null;
    }
}
