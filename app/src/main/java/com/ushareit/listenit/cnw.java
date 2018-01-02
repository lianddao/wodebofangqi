package com.ushareit.listenit;

import java.util.Comparator;

public abstract class cnw<K, V> implements cns<K, V> {
    private final K f8520a;
    private final V f8521b;
    private cns<K, V> f8522c;
    private final cns<K, V> f8523d;

    cnw(K k, V v, cns<K, V> com_ushareit_listenit_cns_K__V, cns<K, V> com_ushareit_listenit_cns_K__V2) {
        cns a;
        cns a2;
        this.f8520a = k;
        this.f8521b = v;
        if (com_ushareit_listenit_cns_K__V == null) {
            a = cnr.m11958a();
        }
        this.f8522c = a;
        if (com_ushareit_listenit_cns_K__V2 == null) {
            a2 = cnr.m11958a();
        }
        this.f8523d = a2;
    }

    private static cnt m11931b(cns com_ushareit_listenit_cns) {
        return com_ushareit_listenit_cns.mo1513b() ? cnt.BLACK : cnt.RED;
    }

    private cns<K, V> m11932k() {
        if (this.f8522c.mo1503c()) {
            return cnr.m11958a();
        }
        if (!(mo1506f().mo1513b() || mo1506f().mo1506f().mo1513b())) {
            this = m11933l();
        }
        return mo1512a(null, null, ((cnw) this.f8522c).m11932k(), null).m11935n();
    }

    private cnw<K, V> m11933l() {
        cnw<K, V> q = m11938q();
        return q.mo1507g().mo1506f().mo1513b() ? q.mo1512a(null, null, null, ((cnw) q.mo1507g()).m11937p()).m11936o().m11938q() : q;
    }

    private cnw<K, V> m11934m() {
        cnw<K, V> q = m11938q();
        return q.mo1506f().mo1506f().mo1513b() ? q.m11937p().m11938q() : q;
    }

    private cnw<K, V> m11935n() {
        cnw<K, V> o;
        if (this.f8523d.mo1513b() && !this.f8522c.mo1513b()) {
            o = m11936o();
        }
        if (o.f8522c.mo1513b() && ((cnw) o.f8522c).f8522c.mo1513b()) {
            o = o.m11937p();
        }
        return (o.f8522c.mo1513b() && o.f8523d.mo1513b()) ? o.m11938q() : o;
    }

    private cnw<K, V> m11936o() {
        return (cnw) this.f8523d.mo1499a(null, null, mo1511a(), (cnw) mo1499a(null, null, cnt.RED, null, ((cnw) this.f8523d).f8522c), null);
    }

    private cnw<K, V> m11937p() {
        return (cnw) this.f8522c.mo1499a(null, null, mo1511a(), null, (cnw) mo1499a(null, null, cnt.RED, ((cnw) this.f8522c).f8523d, null));
    }

    private cnw<K, V> m11938q() {
        return (cnw) mo1499a(null, null, m11931b(this), this.f8522c.mo1499a(null, null, m11931b(this.f8522c), null, null), this.f8523d.mo1499a(null, null, m11931b(this.f8523d), null, null));
    }

    public /* synthetic */ cns mo1499a(Object obj, Object obj2, cnt com_ushareit_listenit_cnt, cns com_ushareit_listenit_cns, cns com_ushareit_listenit_cns2) {
        return m11946b(obj, obj2, com_ushareit_listenit_cnt, com_ushareit_listenit_cns, com_ushareit_listenit_cns2);
    }

    public cns<K, V> mo1500a(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.f8520a);
        cnw a = compare < 0 ? mo1512a(null, null, this.f8522c.mo1500a(k, v, comparator), null) : compare == 0 ? mo1512a(k, v, null, null) : mo1512a(null, null, null, this.f8523d.mo1500a(k, v, comparator));
        return a.m11935n();
    }

    public cns<K, V> mo1501a(K k, Comparator<K> comparator) {
        cnw a;
        if (comparator.compare(k, this.f8520a) < 0) {
            if (!(this.f8522c.mo1503c() || this.f8522c.mo1513b() || ((cnw) this.f8522c).f8522c.mo1513b())) {
                this = m11933l();
            }
            a = mo1512a(null, null, this.f8522c.mo1501a(k, comparator), null);
        } else {
            if (this.f8522c.mo1513b()) {
                this = m11937p();
            }
            if (!(this.f8523d.mo1503c() || this.f8523d.mo1513b() || ((cnw) this.f8523d).f8522c.mo1513b())) {
                this = m11934m();
            }
            if (comparator.compare(k, this.f8520a) == 0) {
                if (this.f8523d.mo1503c()) {
                    return cnr.m11958a();
                }
                cns h = this.f8523d.mo1508h();
                this = mo1512a(h.mo1504d(), h.mo1505e(), null, ((cnw) this.f8523d).m11932k());
            }
            a = mo1512a(null, null, null, this.f8523d.mo1501a(k, comparator));
        }
        return a.m11935n();
    }

    protected abstract cnt mo1511a();

    protected abstract cnw<K, V> mo1512a(K k, V v, cns<K, V> com_ushareit_listenit_cns_K__V, cns<K, V> com_ushareit_listenit_cns_K__V2);

    void m11944a(cns<K, V> com_ushareit_listenit_cns_K__V) {
        this.f8522c = com_ushareit_listenit_cns_K__V;
    }

    public void mo1502a(cnu<K, V> com_ushareit_listenit_cnu_K__V) {
        this.f8522c.mo1502a(com_ushareit_listenit_cnu_K__V);
        com_ushareit_listenit_cnu_K__V.mo1573a(this.f8520a, this.f8521b);
        this.f8523d.mo1502a(com_ushareit_listenit_cnu_K__V);
    }

    public cnw<K, V> m11946b(K k, V v, cnt com_ushareit_listenit_cnt, cns<K, V> com_ushareit_listenit_cns_K__V, cns<K, V> com_ushareit_listenit_cns_K__V2) {
        Object obj;
        Object obj2;
        cns com_ushareit_listenit_cns;
        cns com_ushareit_listenit_cns2;
        if (k == null) {
            obj = this.f8520a;
        }
        if (v == null) {
            obj2 = this.f8521b;
        }
        if (com_ushareit_listenit_cns_K__V == null) {
            com_ushareit_listenit_cns = this.f8522c;
        }
        if (com_ushareit_listenit_cns_K__V2 == null) {
            com_ushareit_listenit_cns2 = this.f8523d;
        }
        return com_ushareit_listenit_cnt == cnt.RED ? new cnv(obj, obj2, com_ushareit_listenit_cns, com_ushareit_listenit_cns2) : new cnq(obj, obj2, com_ushareit_listenit_cns, com_ushareit_listenit_cns2);
    }

    public boolean mo1503c() {
        return false;
    }

    public K mo1504d() {
        return this.f8520a;
    }

    public V mo1505e() {
        return this.f8521b;
    }

    public cns<K, V> mo1506f() {
        return this.f8522c;
    }

    public cns<K, V> mo1507g() {
        return this.f8523d;
    }

    public cns<K, V> mo1508h() {
        return this.f8522c.mo1503c() ? this : this.f8522c.mo1508h();
    }

    public cns<K, V> mo1509i() {
        return this.f8523d.mo1503c() ? this : this.f8523d.mo1509i();
    }

    public int mo1510j() {
        return (this.f8522c.mo1510j() + 1) + this.f8523d.mo1510j();
    }
}
