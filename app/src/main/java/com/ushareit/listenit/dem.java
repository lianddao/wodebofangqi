package com.ushareit.listenit;

import java.net.URL;

final class dem extends dbq<URL> {
    dem() {
    }

    public URL m14009a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        String h = com_ushareit_listenit_dfu.mo1720h();
        return !"null".equals(h) ? new URL(h) : null;
    }

    public void m14011a(dfx com_ushareit_listenit_dfx, URL url) {
        com_ushareit_listenit_dfx.mo1735b(url == null ? null : url.toExternalForm());
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14009a(com_ushareit_listenit_dfu);
    }
}
