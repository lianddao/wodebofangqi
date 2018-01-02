package com.ushareit.listenit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class cwv<T extends cwv> implements cxa {
    static final /* synthetic */ boolean f9245c = (!cwv.class.desiredAssertionStatus());
    private String f9246a;
    protected final cxa f9247b;

    cwv(cxa com_ushareit_listenit_cxa) {
        this.f9247b = com_ushareit_listenit_cxa;
    }

    private static int m13114a(cwy com_ushareit_listenit_cwy, cwq com_ushareit_listenit_cwq) {
        return Double.valueOf((double) ((Long) com_ushareit_listenit_cwy.mo1643a()).longValue()).compareTo((Double) com_ushareit_listenit_cwq.mo1643a());
    }

    protected abstract int mo1642a(T t);

    public cxa mo1629a(cqq com_ushareit_listenit_cqq) {
        return com_ushareit_listenit_cqq.m12347h() ? this : com_ushareit_listenit_cqq.m12343d().m13145e() ? this.f9247b : cwr.m13215j();
    }

    public cxa mo1630a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        cwc d = com_ushareit_listenit_cqq.m12343d();
        if (d == null) {
            return com_ushareit_listenit_cxa;
        }
        if (com_ushareit_listenit_cxa.mo1635b() && !d.m13145e()) {
            return this;
        }
        if (f9245c || !com_ushareit_listenit_cqq.m12343d().m13145e() || com_ushareit_listenit_cqq.m12348i() == 1) {
            return mo1631a(d, cwr.m13215j().mo1630a(com_ushareit_listenit_cqq.m12344e(), com_ushareit_listenit_cxa));
        }
        throw new AssertionError();
    }

    public cxa mo1631a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        return com_ushareit_listenit_cwc.m13145e() ? mo1645b(com_ushareit_listenit_cxa) : !com_ushareit_listenit_cxa.mo1635b() ? cwr.m13215j().mo1631a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa).mo1645b(this.f9247b) : this;
    }

    public Object mo1632a(boolean z) {
        if (!z || this.f9247b.mo1635b()) {
            return mo1643a();
        }
        Map hashMap = new HashMap();
        hashMap.put(".value", mo1643a());
        hashMap.put(".priority", this.f9247b.mo1643a());
        return hashMap;
    }

    public boolean mo1633a(cwc com_ushareit_listenit_cwc) {
        return false;
    }

    protected int m13121b(cwv<?> com_ushareit_listenit_cwv_) {
        cwx c_ = c_();
        Enum c_2 = com_ushareit_listenit_cwv_.c_();
        return c_.equals(c_2) ? mo1642a((cwv) com_ushareit_listenit_cwv_) : c_.compareTo(c_2);
    }

    public cwc mo1634b(cwc com_ushareit_listenit_cwc) {
        return null;
    }

    protected String m13123b(cxc com_ushareit_listenit_cxc) {
        switch (cww.f9288a[com_ushareit_listenit_cxc.ordinal()]) {
            case 1:
            case 2:
                if (this.f9247b.mo1635b()) {
                    return "";
                }
                String valueOf = String.valueOf(this.f9247b.mo1644a(com_ushareit_listenit_cxc));
                return new StringBuilder(String.valueOf(valueOf).length() + 10).append("priority:").append(valueOf).append(":").toString();
            default:
                String valueOf2 = String.valueOf(com_ushareit_listenit_cxc);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 22).append("Unknown hash version: ").append(valueOf2).toString());
        }
    }

    public boolean mo1635b() {
        return false;
    }

    public int mo1636c() {
        return 0;
    }

    public int m13126c(cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cxa.mo1635b()) {
            return 1;
        }
        if (com_ushareit_listenit_cxa instanceof cwf) {
            return -1;
        }
        if (f9245c || com_ushareit_listenit_cxa.mo1639e()) {
            return ((this instanceof cwy) && (com_ushareit_listenit_cxa instanceof cwq)) ? m13114a((cwy) this, (cwq) com_ushareit_listenit_cxa) : ((this instanceof cwq) && (com_ushareit_listenit_cxa instanceof cwy)) ? m13114a((cwy) com_ushareit_listenit_cxa, (cwq) this) * -1 : m13121b((cwv) com_ushareit_listenit_cxa);
        } else {
            throw new AssertionError("Node is not leaf node!");
        }
    }

    public cxa mo1637c(cwc com_ushareit_listenit_cwc) {
        return com_ushareit_listenit_cwc.m13145e() ? this.f9247b : cwr.m13215j();
    }

    protected abstract cwx c_();

    public /* synthetic */ int compareTo(Object obj) {
        return m13126c((cxa) obj);
    }

    public String mo1638d() {
        if (this.f9246a == null) {
            this.f9246a = cyr.m13389b(mo1644a(cxc.V1));
        }
        return this.f9246a;
    }

    public boolean mo1639e() {
        return true;
    }

    public cxa mo1640f() {
        return this.f9247b;
    }

    public Iterator<cwz> mo1641i() {
        return Collections.emptyList().iterator();
    }

    public Iterator<cwz> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = mo1632a(true).toString();
        return obj.length() <= 100 ? obj : String.valueOf(obj.substring(0, 100)).concat("...");
    }
}
