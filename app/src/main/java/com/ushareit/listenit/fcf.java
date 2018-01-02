package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public final class fcf {
    private Map<String, Object> f12421a = new HashMap();

    public boolean m18850a(String str) {
        return this.f12421a.containsKey(str);
    }

    public void m18849a(String str, Object obj) {
        this.f12421a.put(str, obj);
    }

    public boolean m18851a(String str, boolean z) {
        Object obj = this.f12421a.get(str);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return z;
    }

    public int m18846a(String str, int i) {
        Object obj = this.f12421a.get(str);
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return i;
    }

    public long m18847a(String str, long j) {
        Object obj = this.f12421a.get(str);
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        return j;
    }

    public String m18848a(String str, String str2) {
        Object obj = this.f12421a.get(str);
        if (obj != null) {
            return String.valueOf(obj);
        }
        return str2;
    }

    public Object m18852b(String str, Object obj) {
        Object obj2 = this.f12421a.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }
}
