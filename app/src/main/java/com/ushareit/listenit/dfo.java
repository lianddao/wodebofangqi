package com.ushareit.listenit;

import java.math.BigDecimal;

final class dfo extends dbq<BigDecimal> {
    dfo() {
    }

    public BigDecimal m14097a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        try {
            return new BigDecimal(com_ushareit_listenit_dfu.mo1720h());
        } catch (Throwable e) {
            throw new dbj(e);
        }
    }

    public void m14099a(dfx com_ushareit_listenit_dfx, BigDecimal bigDecimal) {
        com_ushareit_listenit_dfx.mo1731a((Number) bigDecimal);
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14097a(com_ushareit_listenit_dfu);
    }
}
