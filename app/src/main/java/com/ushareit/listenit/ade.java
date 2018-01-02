package com.ushareit.listenit;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class ade implements adm {
    private final Set<adn> f4155a = Collections.newSetFromMap(new WeakHashMap());
    private boolean f4156b;
    private boolean f4157c;

    ade() {
    }

    public void mo590a(adn com_ushareit_listenit_adn) {
        this.f4155a.add(com_ushareit_listenit_adn);
        if (this.f4157c) {
            com_ushareit_listenit_adn.mo580f();
        } else if (this.f4156b) {
            com_ushareit_listenit_adn.mo578d();
        } else {
            com_ushareit_listenit_adn.mo579e();
        }
    }

    void m5268a() {
        this.f4156b = true;
        for (adn d : afu.m5495a(this.f4155a)) {
            d.mo578d();
        }
    }

    void m5270b() {
        this.f4156b = false;
        for (adn e : afu.m5495a(this.f4155a)) {
            e.mo579e();
        }
    }

    void m5271c() {
        this.f4157c = true;
        for (adn f : afu.m5495a(this.f4155a)) {
            f.mo580f();
        }
    }
}
