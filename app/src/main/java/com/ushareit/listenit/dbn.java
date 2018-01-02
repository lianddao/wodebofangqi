package com.ushareit.listenit;

final class dbn<T> extends dbq<T> {
    private final dbi<T> f9496a;
    private final daz<T> f9497b;
    private final dao f9498c;
    private final dft<T> f9499d;
    private final dbr f9500e;
    private dbq<T> f9501f;

    private dbn(dbi<T> com_ushareit_listenit_dbi_T, daz<T> com_ushareit_listenit_daz_T, dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T, dbr com_ushareit_listenit_dbr) {
        this.f9496a = com_ushareit_listenit_dbi_T;
        this.f9497b = com_ushareit_listenit_daz_T;
        this.f9498c = com_ushareit_listenit_dao;
        this.f9499d = com_ushareit_listenit_dft_T;
        this.f9500e = com_ushareit_listenit_dbr;
    }

    private dbq<T> m13736a() {
        dbq<T> com_ushareit_listenit_dbq_T = this.f9501f;
        if (com_ushareit_listenit_dbq_T != null) {
            return com_ushareit_listenit_dbq_T;
        }
        com_ushareit_listenit_dbq_T = this.f9498c.m13650a(this.f9500e, this.f9499d);
        this.f9501f = com_ushareit_listenit_dbq_T;
        return com_ushareit_listenit_dbq_T;
    }

    public static dbr m13737a(dft<?> com_ushareit_listenit_dft_, Object obj) {
        return new dbp(obj, com_ushareit_listenit_dft_, false, null, null);
    }

    public static dbr m13738b(dft<?> com_ushareit_listenit_dft_, Object obj) {
        return new dbp(obj, com_ushareit_listenit_dft_, com_ushareit_listenit_dft_.m14121b() == com_ushareit_listenit_dft_.m14120a(), null, null);
    }

    public void mo1400a(dfx com_ushareit_listenit_dfx, T t) {
        if (this.f9496a == null) {
            m13736a().mo1400a(com_ushareit_listenit_dfx, t);
        } else if (t == null) {
            com_ushareit_listenit_dfx.mo1740f();
        } else {
            ddc.m13833a(this.f9496a.mo1699a(t, this.f9499d.m14121b(), this.f9498c.f9464b), com_ushareit_listenit_dfx);
        }
    }

    public T mo1401b(dfu com_ushareit_listenit_dfu) {
        if (this.f9497b == null) {
            return m13736a().mo1401b(com_ushareit_listenit_dfu);
        }
        dba a = ddc.m13831a(com_ushareit_listenit_dfu);
        if (a.m13698k()) {
            return null;
        }
        try {
            return this.f9497b.mo1700b(a, this.f9499d.m14121b(), this.f9498c.f9463a);
        } catch (dbe e) {
            throw e;
        } catch (Throwable e2) {
            throw new dbe(e2);
        }
    }
}
