package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class adu {
    private final Set<aei> f4175a = Collections.newSetFromMap(new WeakHashMap());
    private final List<aei> f4176b = new ArrayList();
    private boolean f4177c;

    public void m5305a(aei com_ushareit_listenit_aei) {
        this.f4175a.add(com_ushareit_listenit_aei);
        if (this.f4177c) {
            this.f4176b.add(com_ushareit_listenit_aei);
        } else {
            com_ushareit_listenit_aei.mo599b();
        }
    }

    public void m5307b(aei com_ushareit_listenit_aei) {
        this.f4175a.remove(com_ushareit_listenit_aei);
        this.f4176b.remove(com_ushareit_listenit_aei);
    }

    public void m5304a() {
        this.f4177c = true;
        for (aei com_ushareit_listenit_aei : afu.m5495a(this.f4175a)) {
            if (com_ushareit_listenit_aei.mo602f()) {
                com_ushareit_listenit_aei.mo601e();
                this.f4176b.add(com_ushareit_listenit_aei);
            }
        }
    }

    public void m5306b() {
        this.f4177c = false;
        for (aei com_ushareit_listenit_aei : afu.m5495a(this.f4175a)) {
            if (!(com_ushareit_listenit_aei.mo603g() || com_ushareit_listenit_aei.mo605i() || com_ushareit_listenit_aei.mo602f())) {
                com_ushareit_listenit_aei.mo599b();
            }
        }
        this.f4176b.clear();
    }

    public void m5308c() {
        for (aei d : afu.m5495a(this.f4175a)) {
            d.mo600d();
        }
        this.f4176b.clear();
    }

    public void m5309d() {
        for (aei com_ushareit_listenit_aei : afu.m5495a(this.f4175a)) {
            if (!(com_ushareit_listenit_aei.mo603g() || com_ushareit_listenit_aei.mo605i())) {
                com_ushareit_listenit_aei.mo601e();
                if (this.f4177c) {
                    this.f4176b.add(com_ushareit_listenit_aei);
                } else {
                    com_ushareit_listenit_aei.mo599b();
                }
            }
        }
    }
}
