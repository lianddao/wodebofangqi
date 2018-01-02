package com.ushareit.listenit;

import java.util.UUID;

final class deq extends dbq<UUID> {
    deq() {
    }

    public UUID m14025a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() != dfw.NULL) {
            return UUID.fromString(com_ushareit_listenit_dfu.mo1720h());
        }
        com_ushareit_listenit_dfu.mo1722j();
        return null;
    }

    public void m14027a(dfx com_ushareit_listenit_dfx, UUID uuid) {
        com_ushareit_listenit_dfx.mo1735b(uuid == null ? null : uuid.toString());
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m14025a(com_ushareit_listenit_dfu);
    }
}
