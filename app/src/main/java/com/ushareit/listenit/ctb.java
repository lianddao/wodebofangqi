package com.ushareit.listenit;

public class ctb extends cqh {
    private final cqt f8924b;
    private final ecy f8925c;
    private final cvg f8926d;

    public ctb(cqt com_ushareit_listenit_cqt, ecy com_ushareit_listenit_ecy, cvg com_ushareit_listenit_cvg) {
        this.f8924b = com_ushareit_listenit_cqt;
        this.f8925c = com_ushareit_listenit_ecy;
        this.f8926d = com_ushareit_listenit_cvg;
    }

    public cqh mo1580a(cvg com_ushareit_listenit_cvg) {
        return new ctb(this.f8924b, this.f8925c, com_ushareit_listenit_cvg);
    }

    public cuw mo1581a(cuv com_ushareit_listenit_cuv, cvg com_ushareit_listenit_cvg) {
        return new cuw(cuy.VALUE, this, eeh.m16842a(eeh.m16843a(this.f8924b, com_ushareit_listenit_cvg.m13002a()), com_ushareit_listenit_cuv.m12961c()), null);
    }

    public cvg mo1582a() {
        return this.f8926d;
    }

    public void mo1583a(cuw com_ushareit_listenit_cuw) {
        if (!m12300c()) {
            this.f8925c.mo2135a(com_ushareit_listenit_cuw.m12965c());
        }
    }

    public void mo1584a(ece com_ushareit_listenit_ece) {
        this.f8925c.mo2136a(com_ushareit_listenit_ece);
    }

    public boolean mo1585a(cqh com_ushareit_listenit_cqh) {
        return (com_ushareit_listenit_cqh instanceof ctb) && ((ctb) com_ushareit_listenit_cqh).f8925c.equals(this.f8925c);
    }

    public boolean mo1586a(cuy com_ushareit_listenit_cuy) {
        return com_ushareit_listenit_cuy == cuy.VALUE;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ctb) && ((ctb) obj).f8925c.equals(this.f8925c) && ((ctb) obj).f8924b.equals(this.f8924b) && ((ctb) obj).f8926d.equals(this.f8926d);
    }

    public int hashCode() {
        return (((this.f8925c.hashCode() * 31) + this.f8924b.hashCode()) * 31) + this.f8926d.hashCode();
    }

    public String toString() {
        return "ValueEventRegistration";
    }
}
