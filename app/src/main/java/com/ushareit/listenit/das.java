package com.ushareit.listenit;

class das extends dbq<Number> {
    final /* synthetic */ dao f9476a;

    das(dao com_ushareit_listenit_dao) {
        this.f9476a = com_ushareit_listenit_dao;
    }

    public Float m13671a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() != dfw.NULL) {
            return Float.valueOf((float) com_ushareit_listenit_dfu.mo1723k());
        }
        com_ushareit_listenit_dfu.mo1722j();
        return null;
    }

    public void m13672a(dfx com_ushareit_listenit_dfx, Number number) {
        if (number == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        this.f9476a.m13646a((double) number.floatValue());
        com_ushareit_listenit_dfx.mo1731a(number);
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m13671a(com_ushareit_listenit_dfu);
    }
}
