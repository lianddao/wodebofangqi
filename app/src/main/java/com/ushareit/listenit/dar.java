package com.ushareit.listenit;

class dar extends dbq<Number> {
    final /* synthetic */ dao f9475a;

    dar(dao com_ushareit_listenit_dao) {
        this.f9475a = com_ushareit_listenit_dao;
    }

    public Double m13667a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() != dfw.NULL) {
            return Double.valueOf(com_ushareit_listenit_dfu.mo1723k());
        }
        com_ushareit_listenit_dfu.mo1722j();
        return null;
    }

    public void m13668a(dfx com_ushareit_listenit_dfx, Number number) {
        if (number == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        this.f9475a.m13646a(number.doubleValue());
        com_ushareit_listenit_dfx.mo1731a(number);
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m13667a(com_ushareit_listenit_dfu);
    }
}
