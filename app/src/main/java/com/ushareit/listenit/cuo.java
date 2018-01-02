package com.ushareit.listenit;

import java.util.Map.Entry;

public class cuo<T> {
    static final /* synthetic */ boolean f9005a = (!cuo.class.desiredAssertionStatus());
    private cwc f9006b;
    private cuo<T> f9007c;
    private cus<T> f9008d;

    public cuo() {
        this(null, null, new cus());
    }

    public cuo(cwc com_ushareit_listenit_cwc, cuo<T> com_ushareit_listenit_cuo_T, cus<T> com_ushareit_listenit_cus_T) {
        this.f9006b = com_ushareit_listenit_cwc;
        this.f9007c = com_ushareit_listenit_cuo_T;
        this.f9008d = com_ushareit_listenit_cus_T;
    }

    private void m12761a(cwc com_ushareit_listenit_cwc, cuo<T> com_ushareit_listenit_cuo_T) {
        boolean d = com_ushareit_listenit_cuo_T.m12774d();
        boolean containsKey = this.f9008d.f9012a.containsKey(com_ushareit_listenit_cwc);
        if (d && containsKey) {
            this.f9008d.f9012a.remove(com_ushareit_listenit_cwc);
            m12762e();
        } else if (!d && !containsKey) {
            this.f9008d.f9012a.put(com_ushareit_listenit_cwc, com_ushareit_listenit_cuo_T.f9008d);
            m12762e();
        }
    }

    private void m12762e() {
        if (this.f9007c != null) {
            this.f9007c.m12761a(this.f9006b, this);
        }
    }

    public cuo<T> m12763a(cqq com_ushareit_listenit_cqq) {
        cuo<T> com_ushareit_listenit_cuo_T;
        cwc d = com_ushareit_listenit_cqq.m12343d();
        while (d != null) {
            cuo<T> com_ushareit_listenit_cuo = new cuo(d, com_ushareit_listenit_cuo_T, com_ushareit_listenit_cuo_T.f9008d.f9012a.containsKey(d) ? (cus) com_ushareit_listenit_cuo_T.f9008d.f9012a.get(d) : new cus());
            com_ushareit_listenit_cqq = com_ushareit_listenit_cqq.m12344e();
            d = com_ushareit_listenit_cqq.m12343d();
            com_ushareit_listenit_cuo_T = com_ushareit_listenit_cuo;
        }
        return com_ushareit_listenit_cuo_T;
    }

    public T m12764a() {
        return this.f9008d.f9013b;
    }

    String m12765a(String str) {
        String d = this.f9006b == null ? "<anon>" : this.f9006b.m13144d();
        String valueOf = String.valueOf(this.f9008d.m12776a(String.valueOf(str).concat("\t")));
        return new StringBuilder(((String.valueOf(str).length() + 1) + String.valueOf(d).length()) + String.valueOf(valueOf).length()).append(str).append(d).append("\n").append(valueOf).toString();
    }

    public void m12766a(cur<T> com_ushareit_listenit_cur_T) {
        m12767a(com_ushareit_listenit_cur_T, false, false);
    }

    public void m12767a(cur<T> com_ushareit_listenit_cur_T, boolean z, boolean z2) {
        if (z && !z2) {
            com_ushareit_listenit_cur_T.mo1564a(this);
        }
        m12772b(new cup(this, com_ushareit_listenit_cur_T, z2));
        if (z && z2) {
            com_ushareit_listenit_cur_T.mo1564a(this);
        }
    }

    public void m12768a(T t) {
        this.f9008d.f9013b = t;
        m12762e();
    }

    public boolean m12769a(cuq<T> com_ushareit_listenit_cuq_T) {
        return m12770a((cuq) com_ushareit_listenit_cuq_T, false);
    }

    public boolean m12770a(cuq<T> com_ushareit_listenit_cuq_T, boolean z) {
        if (!z) {
            this = this.f9007c;
        }
        while (this != null) {
            if (com_ushareit_listenit_cuq_T.mo1565a(this)) {
                return true;
            }
            this = this.f9007c;
        }
        return false;
    }

    public cqq m12771b() {
        if (this.f9007c != null) {
            if (f9005a || this.f9006b != null) {
                return this.f9007c.m12771b().m12338a(this.f9006b);
            }
            throw new AssertionError();
        } else if (this.f9006b == null) {
            return cqq.m12332a();
        } else {
            return new cqq(this.f9006b);
        }
    }

    public void m12772b(cur<T> com_ushareit_listenit_cur_T) {
        Object[] toArray = this.f9008d.f9012a.entrySet().toArray();
        for (Object obj : toArray) {
            Entry entry = (Entry) obj;
            com_ushareit_listenit_cur_T.mo1564a(new cuo((cwc) entry.getKey(), this, (cus) entry.getValue()));
        }
    }

    public boolean m12773c() {
        return !this.f9008d.f9012a.isEmpty();
    }

    public boolean m12774d() {
        return this.f9008d.f9013b == null && this.f9008d.f9012a.isEmpty();
    }

    public String toString() {
        return m12765a("");
    }
}
