package com.ushareit.listenit;

import java.net.InetAddress;

final class dep extends dbq<InetAddress> {
    dep() {
    }

    public InetAddress m14021a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() != dfw.NULL) {
            return InetAddress.getByName(com_ushareit_listenit_dfu.mo1720h());
        }
        com_ushareit_listenit_dfu.mo1722j();
        return null;
    }

    public void m14023a(dfx com_ushareit_listenit_dfx, InetAddress inetAddress) {
        com_ushareit_listenit_dfx.mo1735b(inetAddress == null ? null : inetAddress.getHostAddress());
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14021a(com_ushareit_listenit_dfu);
    }
}
