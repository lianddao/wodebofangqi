package com.ushareit.listenit;

public class cwb extends cwv<cwb> {
    private final boolean f9248a;

    public cwb(Boolean bool, cxa com_ushareit_listenit_cxa) {
        super(com_ushareit_listenit_cxa);
        this.f9248a = bool.booleanValue();
    }

    protected int m13132a(cwb com_ushareit_listenit_cwb) {
        return this.f9248a == com_ushareit_listenit_cwb.f9248a ? 0 : this.f9248a ? 1 : -1;
    }

    public cwb m13134a(cxa com_ushareit_listenit_cxa) {
        return new cwb(Boolean.valueOf(this.f9248a), com_ushareit_listenit_cxa);
    }

    public Object mo1643a() {
        return Boolean.valueOf(this.f9248a);
    }

    public String mo1644a(cxc com_ushareit_listenit_cxc) {
        String valueOf = String.valueOf(m13123b(com_ushareit_listenit_cxc));
        return new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append("boolean:").append(this.f9248a).toString();
    }

    public /* synthetic */ cxa mo1645b(cxa com_ushareit_listenit_cxa) {
        return m13134a(com_ushareit_listenit_cxa);
    }

    protected cwx c_() {
        return cwx.Boolean;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cwb)) {
            return false;
        }
        cwb com_ushareit_listenit_cwb = (cwb) obj;
        return this.f9248a == com_ushareit_listenit_cwb.f9248a && this.b.equals(com_ushareit_listenit_cwb.b);
    }

    public int hashCode() {
        return (this.f9248a ? 1 : 0) + this.b.hashCode();
    }
}
