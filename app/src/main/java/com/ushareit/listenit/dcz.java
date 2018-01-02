package com.ushareit.listenit;

import java.util.Map.Entry;

final class dcz<K, V> implements Entry<K, V> {
    dcz<K, V> f9568a;
    dcz<K, V> f9569b;
    dcz<K, V> f9570c;
    dcz<K, V> f9571d;
    dcz<K, V> f9572e;
    final K f9573f;
    V f9574g;
    int f9575h;

    dcz() {
        this.f9573f = null;
        this.f9572e = this;
        this.f9571d = this;
    }

    dcz(dcz<K, V> com_ushareit_listenit_dcz_K__V, K k, dcz<K, V> com_ushareit_listenit_dcz_K__V2, dcz<K, V> com_ushareit_listenit_dcz_K__V3) {
        this.f9568a = com_ushareit_listenit_dcz_K__V;
        this.f9573f = k;
        this.f9575h = 1;
        this.f9571d = com_ushareit_listenit_dcz_K__V2;
        this.f9572e = com_ushareit_listenit_dcz_K__V3;
        com_ushareit_listenit_dcz_K__V3.f9571d = this;
        com_ushareit_listenit_dcz_K__V2.f9572e = this;
    }

    public dcz<K, V> m13820a() {
        dcz<K, V> com_ushareit_listenit_dcz_K__V;
        for (dcz<K, V> com_ushareit_listenit_dcz_K__V2 = this.f9569b; com_ushareit_listenit_dcz_K__V2 != null; com_ushareit_listenit_dcz_K__V2 = com_ushareit_listenit_dcz_K__V2.f9569b) {
            com_ushareit_listenit_dcz_K__V = com_ushareit_listenit_dcz_K__V2;
        }
        return com_ushareit_listenit_dcz_K__V;
    }

    public dcz<K, V> m13821b() {
        dcz<K, V> com_ushareit_listenit_dcz_K__V;
        for (dcz<K, V> com_ushareit_listenit_dcz_K__V2 = this.f9570c; com_ushareit_listenit_dcz_K__V2 != null; com_ushareit_listenit_dcz_K__V2 = com_ushareit_listenit_dcz_K__V2.f9570c) {
            com_ushareit_listenit_dcz_K__V = com_ushareit_listenit_dcz_K__V2;
        }
        return com_ushareit_listenit_dcz_K__V;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (this.f9573f == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!this.f9573f.equals(entry.getKey())) {
            return false;
        }
        if (this.f9574g == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!this.f9574g.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    public K getKey() {
        return this.f9573f;
    }

    public V getValue() {
        return this.f9574g;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f9573f == null ? 0 : this.f9573f.hashCode();
        if (this.f9574g != null) {
            i = this.f9574g.hashCode();
        }
        return hashCode ^ i;
    }

    public V setValue(V v) {
        V v2 = this.f9574g;
        this.f9574g = v;
        return v2;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9573f);
        String valueOf2 = String.valueOf(this.f9574g);
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
    }
}
