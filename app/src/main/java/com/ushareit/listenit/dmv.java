package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;

class dmv extends dmz {
    final /* synthetic */ dmp f9967a;
    private final ArrayList<cdt> f9968c;

    public dmv(dmp com_ushareit_listenit_dmp, ArrayList<cdt> arrayList) {
        this.f9967a = com_ushareit_listenit_dmp;
        super(com_ushareit_listenit_dmp);
        this.f9968c = arrayList;
    }

    public void mo1990a() {
        this.f9967a.f9935a.f10017g.f9978d = this.f9967a.m14949j();
        Iterator it = this.f9968c.iterator();
        while (it.hasNext()) {
            ((cdt) it.next()).m10639a(this.f9967a.f9949o, this.f9967a.f9935a.f10017g.f9978d);
        }
    }
}
