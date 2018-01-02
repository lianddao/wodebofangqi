package com.ushareit.listenit;

final class dfb extends dbq<Boolean> {
    dfb() {
    }

    public Boolean m14055a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() != dfw.NULL) {
            return com_ushareit_listenit_dfu.mo1718f() == dfw.STRING ? Boolean.valueOf(Boolean.parseBoolean(com_ushareit_listenit_dfu.mo1720h())) : Boolean.valueOf(com_ushareit_listenit_dfu.mo1721i());
        } else {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
    }

    public void m14056a(dfx com_ushareit_listenit_dfx, Boolean bool) {
        if (bool == null) {
            com_ushareit_listenit_dfx.mo1740f();
        } else {
            com_ushareit_listenit_dfx.mo1733a(bool.booleanValue());
        }
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14055a(com_ushareit_listenit_dfu);
    }
}
