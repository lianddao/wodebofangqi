package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class cui<T> implements Iterable<Entry<cqq, T>> {
    private static final cnj f8997c = cnk.m11905a(cod.m11998a(cwc.class));
    private static final cui f8998d = new cui(null, f8997c);
    private final T f8999a;
    private final cnj<cwc, cui<T>> f9000b;

    public cui(T t) {
        this(t, f8997c);
    }

    public cui(T t, cnj<cwc, cui<T>> com_ushareit_listenit_cnj_com_ushareit_listenit_cwc__com_ushareit_listenit_cui_T) {
        this.f8999a = t;
        this.f9000b = com_ushareit_listenit_cnj_com_ushareit_listenit_cwc__com_ushareit_listenit_cui_T;
    }

    public static <V> cui<V> m12736a() {
        return f8998d;
    }

    private <R> R m12737a(cqq com_ushareit_listenit_cqq, cul<? super T, R> com_ushareit_listenit_cul__super_T__R, R r) {
        Iterator it = this.f9000b.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            r = ((cui) entry.getValue()).m12737a(com_ushareit_listenit_cqq.m12338a((cwc) entry.getKey()), com_ushareit_listenit_cul__super_T__R, r);
        }
        return this.f8999a != null ? com_ushareit_listenit_cul__super_T__R.mo1484a(com_ushareit_listenit_cqq, this.f8999a, r) : r;
    }

    public cqq m12738a(cqq com_ushareit_listenit_cqq) {
        return m12739a(com_ushareit_listenit_cqq, cum.f8932e);
    }

    public cqq m12739a(cqq com_ushareit_listenit_cqq, cum<? super T> com_ushareit_listenit_cum__super_T) {
        if (this.f8999a != null && com_ushareit_listenit_cum__super_T.mo1587a(this.f8999a)) {
            return cqq.m12332a();
        }
        if (com_ushareit_listenit_cqq.m12347h()) {
            return null;
        }
        cui com_ushareit_listenit_cui = (cui) this.f9000b.mo1490b(com_ushareit_listenit_cqq.m12343d());
        if (com_ushareit_listenit_cui == null) {
            return null;
        }
        cqq a = com_ushareit_listenit_cui.m12739a(com_ushareit_listenit_cqq.m12344e(), (cum) com_ushareit_listenit_cum__super_T);
        if (a == null) {
            return null;
        }
        return new cqq(r2).m12337a(a);
    }

    public cui<T> m12740a(cqq com_ushareit_listenit_cqq, cui<T> com_ushareit_listenit_cui_T) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            return com_ushareit_listenit_cui_T;
        }
        cwc d = com_ushareit_listenit_cqq.m12343d();
        cui com_ushareit_listenit_cui = (cui) this.f9000b.mo1490b(d);
        if (com_ushareit_listenit_cui == null) {
            com_ushareit_listenit_cui = m12736a();
        }
        com_ushareit_listenit_cui = com_ushareit_listenit_cui.m12740a(com_ushareit_listenit_cqq.m12344e(), (cui) com_ushareit_listenit_cui_T);
        return new cui(this.f8999a, com_ushareit_listenit_cui.m12753d() ? this.f9000b.mo1492c(d) : this.f9000b.mo1485a(d, com_ushareit_listenit_cui));
    }

    public cui<T> m12741a(cqq com_ushareit_listenit_cqq, T t) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            return new cui(t, this.f9000b);
        }
        cwc d = com_ushareit_listenit_cqq.m12343d();
        cui com_ushareit_listenit_cui = (cui) this.f9000b.mo1490b(d);
        if (com_ushareit_listenit_cui == null) {
            com_ushareit_listenit_cui = m12736a();
        }
        return new cui(this.f8999a, this.f9000b.mo1485a(d, com_ushareit_listenit_cui.m12741a(com_ushareit_listenit_cqq.m12344e(), (Object) t)));
    }

    public cui<T> m12742a(cwc com_ushareit_listenit_cwc) {
        cui<T> com_ushareit_listenit_cui_T = (cui) this.f9000b.mo1490b(com_ushareit_listenit_cwc);
        return com_ushareit_listenit_cui_T != null ? com_ushareit_listenit_cui_T : m12736a();
    }

    public <R> R m12743a(R r, cul<? super T, R> com_ushareit_listenit_cul__super_T__R) {
        return m12737a(cqq.m12332a(), com_ushareit_listenit_cul__super_T__R, r);
    }

    public void m12744a(cul<T, Void> com_ushareit_listenit_cul_T__java_lang_Void) {
        m12737a(cqq.m12332a(), com_ushareit_listenit_cul_T__java_lang_Void, null);
    }

    public boolean m12745a(cum<? super T> com_ushareit_listenit_cum__super_T) {
        if (this.f8999a != null && com_ushareit_listenit_cum__super_T.mo1587a(this.f8999a)) {
            return true;
        }
        Iterator it = this.f9000b.iterator();
        while (it.hasNext()) {
            if (((cui) ((Entry) it.next()).getValue()).m12745a((cum) com_ushareit_listenit_cum__super_T)) {
                return true;
            }
        }
        return false;
    }

    public T m12746b() {
        return this.f8999a;
    }

    public T m12747b(cqq com_ushareit_listenit_cqq) {
        return m12751c(com_ushareit_listenit_cqq, cum.f8932e);
    }

    public T m12748b(cqq com_ushareit_listenit_cqq, cum<? super T> com_ushareit_listenit_cum__super_T) {
        if (this.f8999a != null && com_ushareit_listenit_cum__super_T.mo1587a(this.f8999a)) {
            return this.f8999a;
        }
        Iterator it = com_ushareit_listenit_cqq.iterator();
        while (it.hasNext()) {
            cui com_ushareit_listenit_cui = (cui) this.f9000b.mo1490b((cwc) it.next());
            if (com_ushareit_listenit_cui == null) {
                return null;
            }
            if (com_ushareit_listenit_cui.f8999a != null && com_ushareit_listenit_cum__super_T.mo1587a(com_ushareit_listenit_cui.f8999a)) {
                return com_ushareit_listenit_cui.f8999a;
            }
            this = com_ushareit_listenit_cui;
        }
        return null;
    }

    public cnj<cwc, cui<T>> m12749c() {
        return this.f9000b;
    }

    public cui<T> m12750c(cqq com_ushareit_listenit_cqq) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            return this;
        }
        cui com_ushareit_listenit_cui = (cui) this.f9000b.mo1490b(com_ushareit_listenit_cqq.m12343d());
        return com_ushareit_listenit_cui != null ? com_ushareit_listenit_cui.m12750c(com_ushareit_listenit_cqq.m12344e()) : m12736a();
    }

    public T m12751c(cqq com_ushareit_listenit_cqq, cum<? super T> com_ushareit_listenit_cum__super_T) {
        T t = (this.f8999a == null || !com_ushareit_listenit_cum__super_T.mo1587a(this.f8999a)) ? null : this.f8999a;
        Iterator it = com_ushareit_listenit_cqq.iterator();
        T t2 = t;
        while (it.hasNext()) {
            cui com_ushareit_listenit_cui = (cui) this.f9000b.mo1490b((cwc) it.next());
            if (com_ushareit_listenit_cui == null) {
                break;
            }
            if (com_ushareit_listenit_cui.f8999a != null && com_ushareit_listenit_cum__super_T.mo1587a(com_ushareit_listenit_cui.f8999a)) {
                t2 = com_ushareit_listenit_cui.f8999a;
            }
            this = com_ushareit_listenit_cui;
        }
        return t2;
    }

    public cui<T> m12752d(cqq com_ushareit_listenit_cqq) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            return this.f9000b.mo1494d() ? m12736a() : new cui(null, this.f9000b);
        } else {
            cwc d = com_ushareit_listenit_cqq.m12343d();
            cui com_ushareit_listenit_cui = (cui) this.f9000b.mo1490b(d);
            if (com_ushareit_listenit_cui == null) {
                return this;
            }
            com_ushareit_listenit_cui = com_ushareit_listenit_cui.m12752d(com_ushareit_listenit_cqq.m12344e());
            cnj c = com_ushareit_listenit_cui.m12753d() ? this.f9000b.mo1492c(d) : this.f9000b.mo1485a(d, com_ushareit_listenit_cui);
            return (this.f8999a == null && c.mo1494d()) ? m12736a() : new cui(this.f8999a, c);
        }
    }

    public boolean m12753d() {
        return this.f8999a == null && this.f9000b.mo1494d();
    }

    public T m12754e(cqq com_ushareit_listenit_cqq) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            return this.f8999a;
        }
        cui com_ushareit_listenit_cui = (cui) this.f9000b.mo1490b(com_ushareit_listenit_cqq.m12343d());
        return com_ushareit_listenit_cui != null ? com_ushareit_listenit_cui.m12754e(com_ushareit_listenit_cqq.m12344e()) : null;
    }

    public Collection<T> m12755e() {
        Collection arrayList = new ArrayList();
        m12744a(new cuj(this, arrayList));
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cui com_ushareit_listenit_cui = (cui) obj;
        if (this.f9000b == null ? com_ushareit_listenit_cui.f9000b != null : !this.f9000b.equals(com_ushareit_listenit_cui.f9000b)) {
            return false;
        }
        if (this.f8999a != null) {
            if (this.f8999a.equals(com_ushareit_listenit_cui.f8999a)) {
                return true;
            }
        } else if (com_ushareit_listenit_cui.f8999a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f8999a != null ? this.f8999a.hashCode() : 0) * 31;
        if (this.f9000b != null) {
            i = this.f9000b.hashCode();
        }
        return hashCode + i;
    }

    public Iterator<Entry<cqq, T>> iterator() {
        List arrayList = new ArrayList();
        m12744a(new cuk(this, arrayList));
        return arrayList.iterator();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableTree { value=");
        stringBuilder.append(m12746b());
        stringBuilder.append(", children={");
        Iterator it = this.f9000b.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append(((cwc) entry.getKey()).m13144d());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append("} }");
        return stringBuilder.toString();
    }
}
