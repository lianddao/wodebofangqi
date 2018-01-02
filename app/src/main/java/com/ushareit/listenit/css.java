package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class css implements coo, csr {
    final /* synthetic */ csd f8904a;
    private final cvh f8905b;
    private final csu f8906c;

    public css(csd com_ushareit_listenit_csd, cvh com_ushareit_listenit_cvh) {
        this.f8904a = com_ushareit_listenit_csd;
        this.f8905b = com_ushareit_listenit_cvh;
        this.f8906c = com_ushareit_listenit_csd.m12497b(com_ushareit_listenit_cvh.m13008a());
    }

    public String mo1576a() {
        return this.f8905b.m13013b().mo1638d();
    }

    public List<? extends cux> mo1577a(ece com_ushareit_listenit_ece) {
        if (com_ushareit_listenit_ece == null) {
            return this.f8906c != null ? this.f8904a.m12520a(this.f8906c) : this.f8904a.m12511a(this.f8905b.m13008a().m13002a());
        } else {
            cvy a = this.f8904a.f8852i;
            String valueOf = String.valueOf(this.f8905b.m13008a().m13002a());
            String valueOf2 = String.valueOf(com_ushareit_listenit_ece.toString());
            a.m13090a(new StringBuilder((String.valueOf(valueOf).length() + 19) + String.valueOf(valueOf2).length()).append("Listen at ").append(valueOf).append(" failed: ").append(valueOf2).toString());
            return this.f8904a.m12521a(this.f8905b.m13008a(), com_ushareit_listenit_ece);
        }
    }

    public boolean mo1578b() {
        return cyn.m13376a(this.f8905b.m13013b()) > 1024;
    }

    public coe mo1579c() {
        cwk a = cwk.m13177a(this.f8905b.m13013b());
        List<cqq> a2 = a.m13181a();
        List arrayList = new ArrayList(a2.size());
        for (cqq c : a2) {
            arrayList.add(c.m12342c());
        }
        return new coe(arrayList, a.m13182b());
    }
}
