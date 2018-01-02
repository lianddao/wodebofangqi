package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class cry {
    private cxa f8836a = null;
    private Map<cwc, cry> f8837b = null;

    public void m12462a(cqq com_ushareit_listenit_cqq, csb com_ushareit_listenit_csb) {
        if (this.f8836a != null) {
            com_ushareit_listenit_csb.mo1572a(com_ushareit_listenit_cqq, this.f8836a);
        } else {
            m12464a(new crz(this, com_ushareit_listenit_cqq, com_ushareit_listenit_csb));
        }
    }

    public void m12463a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            this.f8836a = com_ushareit_listenit_cxa;
            this.f8837b = null;
        } else if (this.f8836a != null) {
            this.f8836a = this.f8836a.mo1630a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa);
        } else {
            if (this.f8837b == null) {
                this.f8837b = new HashMap();
            }
            cwc d = com_ushareit_listenit_cqq.m12343d();
            if (!this.f8837b.containsKey(d)) {
                this.f8837b.put(d, new cry());
            }
            ((cry) this.f8837b.get(d)).m12463a(com_ushareit_listenit_cqq.m12344e(), com_ushareit_listenit_cxa);
        }
    }

    public void m12464a(csa com_ushareit_listenit_csa) {
        if (this.f8837b != null) {
            for (Entry entry : this.f8837b.entrySet()) {
                com_ushareit_listenit_csa.mo1575a((cwc) entry.getKey(), (cry) entry.getValue());
            }
        }
    }
}
