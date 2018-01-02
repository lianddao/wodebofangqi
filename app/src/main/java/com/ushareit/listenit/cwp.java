package com.ushareit.listenit;

import java.util.Map;

public class cwp extends cwv<cwp> {
    static final /* synthetic */ boolean f9277a = (!cwp.class.desiredAssertionStatus());
    private Map<Object, Object> f9278e;

    public cwp(Map<Object, Object> map, cxa com_ushareit_listenit_cxa) {
        super(com_ushareit_listenit_cxa);
        this.f9278e = map;
    }

    protected int m13203a(cwp com_ushareit_listenit_cwp) {
        return 0;
    }

    public cwp m13205a(cxa com_ushareit_listenit_cxa) {
        if (f9277a || cxg.m13290a(com_ushareit_listenit_cxa)) {
            return new cwp(this.f9278e, com_ushareit_listenit_cxa);
        }
        throw new AssertionError();
    }

    public Object mo1643a() {
        return this.f9278e;
    }

    public String mo1644a(cxc com_ushareit_listenit_cxc) {
        String valueOf = String.valueOf(m13123b(com_ushareit_listenit_cxc));
        String valueOf2 = String.valueOf(this.f9278e);
        return new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length()).append(valueOf).append("deferredValue:").append(valueOf2).toString();
    }

    public /* synthetic */ cxa mo1645b(cxa com_ushareit_listenit_cxa) {
        return m13205a(com_ushareit_listenit_cxa);
    }

    protected cwx c_() {
        return cwx.DeferredValue;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cwp)) {
            return false;
        }
        cwp com_ushareit_listenit_cwp = (cwp) obj;
        return this.f9278e.equals(com_ushareit_listenit_cwp.f9278e) && this.b.equals(com_ushareit_listenit_cwp.b);
    }

    public int hashCode() {
        return this.f9278e.hashCode() + this.b.hashCode();
    }
}
