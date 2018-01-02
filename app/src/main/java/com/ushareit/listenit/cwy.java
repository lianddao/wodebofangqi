package com.ushareit.listenit;

public class cwy extends cwv<cwy> {
    private final long f9294a;

    public cwy(Long l, cxa com_ushareit_listenit_cxa) {
        super(com_ushareit_listenit_cxa);
        this.f9294a = l.longValue();
    }

    protected int m13260a(cwy com_ushareit_listenit_cwy) {
        return cyr.m13383a(this.f9294a, com_ushareit_listenit_cwy.f9294a);
    }

    public cwy m13261a(cxa com_ushareit_listenit_cxa) {
        return new cwy(Long.valueOf(this.f9294a), com_ushareit_listenit_cxa);
    }

    public Object mo1643a() {
        return Long.valueOf(this.f9294a);
    }

    public String mo1644a(cxc com_ushareit_listenit_cxc) {
        String valueOf = String.valueOf(String.valueOf(m13123b(com_ushareit_listenit_cxc)).concat("number:"));
        String valueOf2 = String.valueOf(cyr.m13386a((double) this.f9294a));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public /* synthetic */ cxa mo1645b(cxa com_ushareit_listenit_cxa) {
        return m13261a(com_ushareit_listenit_cxa);
    }

    protected cwx c_() {
        return cwx.Number;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cwy)) {
            return false;
        }
        cwy com_ushareit_listenit_cwy = (cwy) obj;
        return this.f9294a == com_ushareit_listenit_cwy.f9294a && this.b.equals(com_ushareit_listenit_cwy.b);
    }

    public int hashCode() {
        return ((int) (this.f9294a ^ (this.f9294a >>> 32))) + this.b.hashCode();
    }
}
