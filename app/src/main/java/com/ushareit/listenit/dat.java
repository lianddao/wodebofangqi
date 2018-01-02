package com.ushareit.listenit;

class dat extends dbq<Number> {
    final /* synthetic */ dao f9477a;

    dat(dao com_ushareit_listenit_dao) {
        this.f9477a = com_ushareit_listenit_dao;
    }

    public Number m13675a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() != dfw.NULL) {
            return Long.valueOf(com_ushareit_listenit_dfu.mo1724l());
        }
        com_ushareit_listenit_dfu.mo1722j();
        return null;
    }

    public void m13676a(dfx com_ushareit_listenit_dfx, Number number) {
        if (number == null) {
            com_ushareit_listenit_dfx.mo1740f();
        } else {
            com_ushareit_listenit_dfx.mo1735b(number.toString());
        }
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m13675a(com_ushareit_listenit_dfu);
    }
}
