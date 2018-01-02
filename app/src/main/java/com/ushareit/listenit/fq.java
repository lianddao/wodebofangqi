package com.ushareit.listenit;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class fq<K, V> extends gg<K, V> implements Map<K, V> {
    fx<K, V> f13223a;

    public fq(int i) {
        super(i);
    }

    private fx<K, V> m20347b() {
        if (this.f13223a == null) {
            this.f13223a = new fr(this);
        }
        return this.f13223a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m20341a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean m20348a(Collection<?> collection) {
        return fx.m20507c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m20347b().m20519d();
    }

    public Set<K> keySet() {
        return m20347b().m20520e();
    }

    public Collection<V> values() {
        return m20347b().m20521f();
    }
}
