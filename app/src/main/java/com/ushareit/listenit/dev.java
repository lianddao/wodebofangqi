package com.ushareit.listenit;

import java.util.Iterator;
import java.util.Map.Entry;

final class dev extends dbq<dba> {
    dev() {
    }

    public dba m14042a(dfu com_ushareit_listenit_dfu) {
        dba com_ushareit_listenit_dax;
        switch (dfe.f9729a[com_ushareit_listenit_dfu.mo1718f().ordinal()]) {
            case 1:
                return new dbg(new dcr(com_ushareit_listenit_dfu.mo1720h()));
            case 2:
                return new dbg(Boolean.valueOf(com_ushareit_listenit_dfu.mo1721i()));
            case 3:
                return new dbg(com_ushareit_listenit_dfu.mo1720h());
            case 4:
                com_ushareit_listenit_dfu.mo1722j();
                return dbc.f9489a;
            case 5:
                com_ushareit_listenit_dax = new dax();
                com_ushareit_listenit_dfu.mo1712a();
                while (com_ushareit_listenit_dfu.mo1717e()) {
                    com_ushareit_listenit_dax.m13705a((dba) mo1401b(com_ushareit_listenit_dfu));
                }
                com_ushareit_listenit_dfu.mo1713b();
                return com_ushareit_listenit_dax;
            case 6:
                com_ushareit_listenit_dax = new dbd();
                com_ushareit_listenit_dfu.mo1714c();
                while (com_ushareit_listenit_dfu.mo1717e()) {
                    com_ushareit_listenit_dax.m13714a(com_ushareit_listenit_dfu.mo1719g(), (dba) mo1401b(com_ushareit_listenit_dfu));
                }
                com_ushareit_listenit_dfu.mo1716d();
                return com_ushareit_listenit_dax;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void m14043a(dfx com_ushareit_listenit_dfx, dba com_ushareit_listenit_dba) {
        if (com_ushareit_listenit_dba == null || com_ushareit_listenit_dba.m13698k()) {
            com_ushareit_listenit_dfx.mo1740f();
        } else if (com_ushareit_listenit_dba.m13697j()) {
            dbg n = com_ushareit_listenit_dba.m13701n();
            if (n.m13734p()) {
                com_ushareit_listenit_dfx.mo1731a(n.mo1702b());
            } else if (n.m13726a()) {
                com_ushareit_listenit_dfx.mo1733a(n.mo1707g());
            } else {
                com_ushareit_listenit_dfx.mo1735b(n.mo1703c());
            }
        } else if (com_ushareit_listenit_dba.m13695h()) {
            com_ushareit_listenit_dfx.mo1734b();
            Iterator it = com_ushareit_listenit_dba.m13700m().iterator();
            while (it.hasNext()) {
                m14043a(com_ushareit_listenit_dfx, (dba) it.next());
            }
            com_ushareit_listenit_dfx.mo1736c();
        } else if (com_ushareit_listenit_dba.m13696i()) {
            com_ushareit_listenit_dfx.mo1738d();
            for (Entry entry : com_ushareit_listenit_dba.m13699l().m13713a()) {
                com_ushareit_listenit_dfx.mo1732a((String) entry.getKey());
                m14043a(com_ushareit_listenit_dfx, (dba) entry.getValue());
            }
            com_ushareit_listenit_dfx.mo1739e();
        } else {
            String valueOf = String.valueOf(com_ushareit_listenit_dba.getClass());
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Couldn't write ").append(valueOf).toString());
        }
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14042a(com_ushareit_listenit_dfu);
    }
}
