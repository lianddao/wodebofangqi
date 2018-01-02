package com.ushareit.listenit;

public class cwq extends cwv<cwq> {
    static final /* synthetic */ boolean f9279a = (!cwq.class.desiredAssertionStatus());
    private final Double f9280e;

    public cwq(Double d, cxa com_ushareit_listenit_cxa) {
        super(com_ushareit_listenit_cxa);
        this.f9280e = d;
    }

    protected int m13209a(cwq com_ushareit_listenit_cwq) {
        return this.f9280e.compareTo(com_ushareit_listenit_cwq.f9280e);
    }

    public cwq m13211a(cxa com_ushareit_listenit_cxa) {
        if (f9279a || cxg.m13290a(com_ushareit_listenit_cxa)) {
            return new cwq(this.f9280e, com_ushareit_listenit_cxa);
        }
        throw new AssertionError();
    }

    public Object mo1643a() {
        return this.f9280e;
    }

    public String mo1644a(cxc com_ushareit_listenit_cxc) {
        String valueOf = String.valueOf(String.valueOf(m13123b(com_ushareit_listenit_cxc)).concat("number:"));
        String valueOf2 = String.valueOf(cyr.m13386a(this.f9280e.doubleValue()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public /* synthetic */ cxa mo1645b(cxa com_ushareit_listenit_cxa) {
        return m13211a(com_ushareit_listenit_cxa);
    }

    protected cwx c_() {
        return cwx.Number;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cwq)) {
            return false;
        }
        cwq com_ushareit_listenit_cwq = (cwq) obj;
        return this.f9280e.equals(com_ushareit_listenit_cwq.f9280e) && this.b.equals(com_ushareit_listenit_cwq.b);
    }

    public int hashCode() {
        return this.f9280e.hashCode() + this.b.hashCode();
    }
}
