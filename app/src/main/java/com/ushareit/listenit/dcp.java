package com.ushareit.listenit;

class dcp extends dbq<T> {
    final /* synthetic */ boolean f9543a;
    final /* synthetic */ boolean f9544b;
    final /* synthetic */ dao f9545c;
    final /* synthetic */ dft f9546d;
    final /* synthetic */ dco f9547e;
    private dbq<T> f9548f;

    dcp(dco com_ushareit_listenit_dco, boolean z, boolean z2, dao com_ushareit_listenit_dao, dft com_ushareit_listenit_dft) {
        this.f9547e = com_ushareit_listenit_dco;
        this.f9543a = z;
        this.f9544b = z2;
        this.f9545c = com_ushareit_listenit_dao;
        this.f9546d = com_ushareit_listenit_dft;
    }

    private dbq<T> m13803a() {
        dbq<T> com_ushareit_listenit_dbq_T = this.f9548f;
        if (com_ushareit_listenit_dbq_T != null) {
            return com_ushareit_listenit_dbq_T;
        }
        com_ushareit_listenit_dbq_T = this.f9545c.m13650a(this.f9547e, this.f9546d);
        this.f9548f = com_ushareit_listenit_dbq_T;
        return com_ushareit_listenit_dbq_T;
    }

    public void mo1400a(dfx com_ushareit_listenit_dfx, T t) {
        if (this.f9544b) {
            com_ushareit_listenit_dfx.mo1740f();
        } else {
            m13803a().mo1400a(com_ushareit_listenit_dfx, t);
        }
    }

    public T mo1401b(dfu com_ushareit_listenit_dfu) {
        if (!this.f9543a) {
            return m13803a().mo1401b(com_ushareit_listenit_dfu);
        }
        com_ushareit_listenit_dfu.mo1726n();
        return null;
    }
}
