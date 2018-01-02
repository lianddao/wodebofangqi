package com.ushareit.listenit;

import java.util.Iterator;

class cob implements Iterator<coc> {
    final /* synthetic */ coa f8537a;
    private int f8538b = (this.f8537a.f8536b - 1);

    cob(coa com_ushareit_listenit_coa) {
        this.f8537a = com_ushareit_listenit_coa;
    }

    public coc m11997a() {
        boolean z = true;
        long b = this.f8537a.f8535a & ((long) (1 << this.f8538b));
        coc com_ushareit_listenit_coc = new coc();
        if (b != 0) {
            z = false;
        }
        com_ushareit_listenit_coc.f8539a = z;
        com_ushareit_listenit_coc.f8540b = (int) Math.pow(2.0d, (double) this.f8538b);
        this.f8538b--;
        return com_ushareit_listenit_coc;
    }

    public boolean hasNext() {
        return this.f8538b >= 0;
    }

    public /* synthetic */ Object next() {
        return m11997a();
    }

    public void remove() {
    }
}
