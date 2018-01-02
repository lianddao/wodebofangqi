package com.ushareit.listenit;

import java.io.EOFException;

final class bnw {
    private final bhy[] f7198a;
    private final bia f7199b;
    private bhy f7200c;

    public bnw(bhy[] com_ushareit_listenit_bhyArr, bia com_ushareit_listenit_bia) {
        this.f7198a = com_ushareit_listenit_bhyArr;
        this.f7199b = com_ushareit_listenit_bia;
    }

    public bhy m9207a(bhz com_ushareit_listenit_bhz) {
        if (this.f7200c != null) {
            return this.f7200c;
        }
        bhy[] com_ushareit_listenit_bhyArr = this.f7198a;
        int length = com_ushareit_listenit_bhyArr.length;
        int i = 0;
        loop0:
        while (i < length) {
            bhy com_ushareit_listenit_bhy = com_ushareit_listenit_bhyArr[i];
            try {
                if (com_ushareit_listenit_bhy.mo982a(com_ushareit_listenit_bhz)) {
                    this.f7200c = com_ushareit_listenit_bhy;
                    com_ushareit_listenit_bhz.mo962a();
                    break loop0;
                }
                i++;
            } catch (EOFException e) {
                i++;
            } finally {
                com_ushareit_listenit_bhz.mo962a();
            }
        }
        if (this.f7200c == null) {
            throw new boa(this.f7198a);
        }
        this.f7200c.mo981a(this.f7199b);
        return this.f7200c;
    }

    public void m9208a() {
        if (this.f7200c != null) {
            this.f7200c.mo983c();
            this.f7200c = null;
        }
    }
}
