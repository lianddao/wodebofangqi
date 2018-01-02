package com.ushareit.listenit;

final class dfv extends dcq {
    dfv() {
    }

    public void mo1745a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu instanceof dds) {
            ((dds) com_ushareit_listenit_dfu).mo1727o();
            return;
        }
        int a = com_ushareit_listenit_dfu.f9609i;
        if (a == 0) {
            a = com_ushareit_listenit_dfu.mo1727o();
        }
        if (a == 13) {
            com_ushareit_listenit_dfu.f9609i = 9;
        } else if (a == 12) {
            com_ushareit_listenit_dfu.f9609i = 8;
        } else if (a == 14) {
            com_ushareit_listenit_dfu.f9609i = 10;
        } else {
            String valueOf = String.valueOf(com_ushareit_listenit_dfu.mo1718f());
            int c = com_ushareit_listenit_dfu.m13876v();
            int d = com_ushareit_listenit_dfu.m13877w();
            String q = com_ushareit_listenit_dfu.m13897q();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(q).length()).append("Expected a name but was ").append(valueOf).append(" ").append(" at line ").append(c).append(" column ").append(d).append(" path ").append(q).toString());
        }
    }
}
