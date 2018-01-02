package com.ushareit.listenit;

class eps implements epl {
    private epn f11455a;
    private ept f11456b;
    private int f11457c;

    public eps(epn com_ushareit_listenit_epn, ept com_ushareit_listenit_ept, int i) {
        this.f11455a = com_ushareit_listenit_epn;
        this.f11456b = com_ushareit_listenit_ept;
        this.f11457c = i;
    }

    public void mo2231c(epk com_ushareit_listenit_epk) {
    }

    public void mo2230b(epk com_ushareit_listenit_epk) {
        if (this.f11457c == 1) {
            m17313e(com_ushareit_listenit_epk);
        }
    }

    public void mo2232d(epk com_ushareit_listenit_epk) {
    }

    public void mo2229a(epk com_ushareit_listenit_epk) {
        if (this.f11457c == 0) {
            m17313e(com_ushareit_listenit_epk);
        }
    }

    private void m17313e(epk com_ushareit_listenit_epk) {
        if (!this.f11455a.f11435b) {
            Object obj;
            int size = this.f11456b.f11460c.size();
            for (int i = 0; i < size; i++) {
                obj = (epr) this.f11456b.f11460c.get(i);
                if (obj.f11454b == this.f11457c && obj.f11453a.f11458a == com_ushareit_listenit_epk) {
                    com_ushareit_listenit_epk.m17276b(this);
                    break;
                }
            }
            obj = null;
            this.f11456b.f11460c.remove(obj);
            if (this.f11456b.f11460c.size() == 0) {
                this.f11456b.f11458a.mo2234a();
                this.f11455a.f11436c.add(this.f11456b.f11458a);
            }
        }
    }
}
