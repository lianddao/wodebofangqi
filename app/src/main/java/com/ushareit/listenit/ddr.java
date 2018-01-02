package com.ushareit.listenit;

public final class ddr implements dbr {
    private final dcb f9600a;

    public ddr(dcb com_ushareit_listenit_dcb) {
        this.f9600a = com_ushareit_listenit_dcb;
    }

    static dbq<?> m13855a(dcb com_ushareit_listenit_dcb, dao com_ushareit_listenit_dao, dft<?> com_ushareit_listenit_dft_, dbs com_ushareit_listenit_dbs) {
        Class a = com_ushareit_listenit_dbs.m13743a();
        if (dbq.class.isAssignableFrom(a)) {
            return (dbq) com_ushareit_listenit_dcb.m13777a(dft.m14119b(a)).mo1710a();
        }
        if (dbr.class.isAssignableFrom(a)) {
            return ((dbr) com_ushareit_listenit_dcb.m13777a(dft.m14119b(a)).mo1710a()).mo1709a(com_ushareit_listenit_dao, com_ushareit_listenit_dft_);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        dbs com_ushareit_listenit_dbs = (dbs) com_ushareit_listenit_dft_T.m14120a().getAnnotation(dbs.class);
        return com_ushareit_listenit_dbs == null ? null : m13855a(this.f9600a, com_ushareit_listenit_dao, com_ushareit_listenit_dft_T, com_ushareit_listenit_dbs);
    }
}
