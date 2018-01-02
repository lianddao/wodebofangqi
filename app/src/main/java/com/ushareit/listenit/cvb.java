package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public class cvb {
    private final cqj f9180a;
    private final cvy f9181b;

    public cvb(cqd com_ushareit_listenit_cqd) {
        this.f9180a = com_ushareit_listenit_cqd.m12280k();
        this.f9181b = com_ushareit_listenit_cqd.m12268a("EventRaiser");
    }

    public void m12976a(List<? extends cux> list) {
        if (this.f9181b.m13094a()) {
            this.f9181b.m13093a("Raising " + list.size() + " event(s)", new Object[0]);
        }
        this.f9180a.mo1451a(new cvc(this, new ArrayList(list)));
    }
}
