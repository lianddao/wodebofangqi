package com.ushareit.listenit;

public class cuu implements cux {
    private final cqq f9157a;
    private final cqh f9158b;
    private final ece f9159c;

    public cuu(cqh com_ushareit_listenit_cqh, ece com_ushareit_listenit_ece, cqq com_ushareit_listenit_cqq) {
        this.f9158b = com_ushareit_listenit_cqh;
        this.f9157a = com_ushareit_listenit_cqq;
        this.f9159c = com_ushareit_listenit_ece;
    }

    public cqq m12948a() {
        return this.f9157a;
    }

    public void mo1612b() {
        this.f9158b.mo1584a(this.f9159c);
    }

    public String toString() {
        String valueOf = String.valueOf(m12948a());
        return new StringBuilder(String.valueOf(valueOf).length() + 7).append(valueOf).append(":CANCEL").toString();
    }
}
