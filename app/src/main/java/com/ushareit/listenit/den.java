package com.ushareit.listenit;

import java.net.URI;

final class den extends dbq<URI> {
    den() {
    }

    public URI m14013a(dfu com_ushareit_listenit_dfu) {
        URI uri = null;
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
        } else {
            try {
                String h = com_ushareit_listenit_dfu.mo1720h();
                if (!"null".equals(h)) {
                    uri = new URI(h);
                }
            } catch (Throwable e) {
                throw new dbb(e);
            }
        }
        return uri;
    }

    public void m14015a(dfx com_ushareit_listenit_dfx, URI uri) {
        com_ushareit_listenit_dfx.mo1735b(uri == null ? null : uri.toASCIIString());
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14013a(com_ushareit_listenit_dfu);
    }
}
