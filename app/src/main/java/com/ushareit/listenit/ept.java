package com.ushareit.listenit;

import java.util.ArrayList;

class ept implements Cloneable {
    public epk f11458a;
    public ArrayList<epr> f11459b = null;
    public ArrayList<epr> f11460c = null;
    public ArrayList<ept> f11461d = null;
    public ArrayList<ept> f11462e = null;
    public boolean f11463f = false;

    public /* synthetic */ Object clone() {
        return m17318a();
    }

    public ept(epk com_ushareit_listenit_epk) {
        this.f11458a = com_ushareit_listenit_epk;
    }

    public void m17319a(epr com_ushareit_listenit_epr) {
        if (this.f11459b == null) {
            this.f11459b = new ArrayList();
            this.f11461d = new ArrayList();
        }
        this.f11459b.add(com_ushareit_listenit_epr);
        if (!this.f11461d.contains(com_ushareit_listenit_epr.f11453a)) {
            this.f11461d.add(com_ushareit_listenit_epr.f11453a);
        }
        ept com_ushareit_listenit_ept = com_ushareit_listenit_epr.f11453a;
        if (com_ushareit_listenit_ept.f11462e == null) {
            com_ushareit_listenit_ept.f11462e = new ArrayList();
        }
        com_ushareit_listenit_ept.f11462e.add(this);
    }

    public ept m17318a() {
        try {
            ept com_ushareit_listenit_ept = (ept) super.clone();
            com_ushareit_listenit_ept.f11458a = this.f11458a.mo2239f();
            return com_ushareit_listenit_ept;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
