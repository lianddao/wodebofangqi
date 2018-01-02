package com.ushareit.listenit;

public class epq {
    final /* synthetic */ epn f11451a;
    private ept f11452b;

    epq(epn com_ushareit_listenit_epn, epk com_ushareit_listenit_epk) {
        this.f11451a = com_ushareit_listenit_epn;
        this.f11452b = (ept) com_ushareit_listenit_epn.f11437d.get(com_ushareit_listenit_epk);
        if (this.f11452b == null) {
            this.f11452b = new ept(com_ushareit_listenit_epk);
            com_ushareit_listenit_epn.f11437d.put(com_ushareit_listenit_epk, this.f11452b);
            com_ushareit_listenit_epn.f11438e.add(this.f11452b);
        }
    }

    public epq m17311a(epk com_ushareit_listenit_epk) {
        ept com_ushareit_listenit_ept = (ept) this.f11451a.f11437d.get(com_ushareit_listenit_epk);
        if (com_ushareit_listenit_ept == null) {
            com_ushareit_listenit_ept = new ept(com_ushareit_listenit_epk);
            this.f11451a.f11437d.put(com_ushareit_listenit_epk, com_ushareit_listenit_ept);
            this.f11451a.f11438e.add(com_ushareit_listenit_ept);
        }
        com_ushareit_listenit_ept.m17319a(new epr(this.f11452b, 0));
        return this;
    }

    public epq m17312b(epk com_ushareit_listenit_epk) {
        ept com_ushareit_listenit_ept = (ept) this.f11451a.f11437d.get(com_ushareit_listenit_epk);
        if (com_ushareit_listenit_ept == null) {
            com_ushareit_listenit_ept = new ept(com_ushareit_listenit_epk);
            this.f11451a.f11437d.put(com_ushareit_listenit_epk, com_ushareit_listenit_ept);
            this.f11451a.f11438e.add(com_ushareit_listenit_ept);
        }
        com_ushareit_listenit_ept.m17319a(new epr(this.f11452b, 1));
        return this;
    }
}
