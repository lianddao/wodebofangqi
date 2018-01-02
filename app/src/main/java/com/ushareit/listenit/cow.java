package com.ushareit.listenit;

import java.util.Map;

class cow implements cpa {
    final /* synthetic */ String f8603a;
    final /* synthetic */ long f8604b;
    final /* synthetic */ cpf f8605c;
    final /* synthetic */ cph f8606d;
    final /* synthetic */ cor f8607e;

    cow(cor com_ushareit_listenit_cor, String str, long j, cpf com_ushareit_listenit_cpf, cph com_ushareit_listenit_cph) {
        this.f8607e = com_ushareit_listenit_cor;
        this.f8603a = str;
        this.f8604b = j;
        this.f8605c = com_ushareit_listenit_cpf;
        this.f8606d = com_ushareit_listenit_cph;
    }

    public void mo1539a(Map<String, Object> map) {
        if (this.f8607e.f8590v.m13094a()) {
            cvy a = this.f8607e.f8590v;
            String str = this.f8603a;
            String valueOf = String.valueOf(map);
            a.m13093a(new StringBuilder((String.valueOf(str).length() + 11) + String.valueOf(valueOf).length()).append(str).append(" response: ").append(valueOf).toString(), new Object[0]);
        }
        if (((cpf) this.f8607e.f8583o.get(Long.valueOf(this.f8604b))) == this.f8605c) {
            this.f8607e.f8583o.remove(Long.valueOf(this.f8604b));
            if (this.f8606d != null) {
                String str2 = (String) map.get("s");
                if (str2.equals("ok")) {
                    this.f8606d.mo1571a(null, null);
                } else {
                    this.f8606d.mo1571a(str2, (String) map.get("d"));
                }
            }
        } else if (this.f8607e.f8590v.m13094a()) {
            this.f8607e.f8590v.m13093a("Ignoring on complete for put " + this.f8604b + " because it was removed already.", new Object[0]);
        }
        this.f8607e.m12117q();
    }
}
