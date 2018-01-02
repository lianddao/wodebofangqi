package com.ushareit.listenit;

import com.ushareit.listenit.fx$com.ushareit.listenit.fz;
import com.ushareit.listenit.fx$com.ushareit.listenit.ga;
import com.ushareit.listenit.fx$com.ushareit.listenit.gc;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class fx<K, V> {
    fz f13245b;
    ga f13246c;
    gc f13247d;

    protected abstract int mo2539a();

    protected abstract int mo2540a(Object obj);

    protected abstract Object mo2541a(int i, int i2);

    protected abstract V mo2542a(int i, V v);

    protected abstract void mo2543a(int i);

    protected abstract void mo2544a(K k, V v);

    protected abstract int mo2545b(Object obj);

    protected abstract Map<K, V> mo2546b();

    protected abstract void mo2547c();

    fx() {
    }

    public static <K, V> boolean m20504a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m20506b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m20507c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] m20517b(int i) {
        int a = mo2539a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo2541a(i2, i);
        }
        return objArr;
    }

    public <T> T[] m20514a(T[] tArr, int i) {
        T[] tArr2;
        int a = mo2539a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo2541a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m20505a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set<Entry<K, V>> m20519d() {
        if (this.f13245b == null) {
            this.f13245b = new fz(this);
        }
        return this.f13245b;
    }

    public Set<K> m20520e() {
        if (this.f13246c == null) {
            this.f13246c = new ga(this);
        }
        return this.f13246c;
    }

    public Collection<V> m20521f() {
        if (this.f13247d == null) {
            this.f13247d = new gc(this);
        }
        return this.f13247d;
    }
}
