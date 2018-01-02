package com.ushareit.listenit;

public class cut {
    private final cwt f9014a;
    private final boolean f9015b;
    private final boolean f9016c;

    public cut(cwt com_ushareit_listenit_cwt, boolean z, boolean z2) {
        this.f9014a = com_ushareit_listenit_cwt;
        this.f9015b = z;
        this.f9016c = z2;
    }

    public boolean m12777a() {
        return this.f9015b;
    }

    public boolean m12778a(cqq com_ushareit_listenit_cqq) {
        return com_ushareit_listenit_cqq.m12347h() ? m12777a() && !this.f9016c : m12779a(com_ushareit_listenit_cqq.m12343d());
    }

    public boolean m12779a(cwc com_ushareit_listenit_cwc) {
        return (m12777a() && !this.f9016c) || this.f9014a.m13247a().mo1633a(com_ushareit_listenit_cwc);
    }

    public boolean m12780b() {
        return this.f9016c;
    }

    public cxa m12781c() {
        return this.f9014a.m13247a();
    }

    public cwt m12782d() {
        return this.f9014a;
    }
}
