package com.ushareit.listenit;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class yy implements yr {
    private final Map<String, List<yx>> f17593c;
    private volatile Map<String, String> f17594d;

    yy(Map<String, List<yx>> map) {
        this.f17593c = Collections.unmodifiableMap(map);
    }

    public Map<String, String> mo3149a() {
        if (this.f17594d == null) {
            synchronized (this) {
                if (this.f17594d == null) {
                    this.f17594d = Collections.unmodifiableMap(m27271b());
                }
            }
        }
        return this.f17594d;
    }

    private Map<String, String> m27271b() {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.f17593c.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            List list = (List) entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(((yx) list.get(i)).mo3150a());
                if (i != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            hashMap.put(entry.getKey(), stringBuilder.toString());
        }
        return hashMap;
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f17593c + '}';
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof yy)) {
            return false;
        }
        return this.f17593c.equals(((yy) obj).f17593c);
    }

    public int hashCode() {
        return this.f17593c.hashCode();
    }
}
