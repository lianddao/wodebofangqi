package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ddy extends dbq<Object> {
    public static final dbr f9642a = new ddz();
    private final dao f9643b;

    private ddy(dao com_ushareit_listenit_dao) {
        this.f9643b = com_ushareit_listenit_dao;
    }

    public void mo1400a(dfx com_ushareit_listenit_dfx, Object obj) {
        if (obj == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        dbq a = this.f9643b.m13652a(obj.getClass());
        if (a instanceof ddy) {
            com_ushareit_listenit_dfx.mo1738d();
            com_ushareit_listenit_dfx.mo1739e();
            return;
        }
        a.mo1400a(com_ushareit_listenit_dfx, obj);
    }

    public Object mo1401b(dfu com_ushareit_listenit_dfu) {
        switch (dea.f9649a[com_ushareit_listenit_dfu.mo1718f().ordinal()]) {
            case 1:
                List arrayList = new ArrayList();
                com_ushareit_listenit_dfu.mo1712a();
                while (com_ushareit_listenit_dfu.mo1717e()) {
                    arrayList.add(mo1401b(com_ushareit_listenit_dfu));
                }
                com_ushareit_listenit_dfu.mo1713b();
                return arrayList;
            case 2:
                Map com_ushareit_listenit_dcs = new dcs();
                com_ushareit_listenit_dfu.mo1714c();
                while (com_ushareit_listenit_dfu.mo1717e()) {
                    com_ushareit_listenit_dcs.put(com_ushareit_listenit_dfu.mo1719g(), mo1401b(com_ushareit_listenit_dfu));
                }
                com_ushareit_listenit_dfu.mo1716d();
                return com_ushareit_listenit_dcs;
            case 3:
                return com_ushareit_listenit_dfu.mo1720h();
            case 4:
                return Double.valueOf(com_ushareit_listenit_dfu.mo1723k());
            case 5:
                return Boolean.valueOf(com_ushareit_listenit_dfu.mo1721i());
            case 6:
                com_ushareit_listenit_dfu.mo1722j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
