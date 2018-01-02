package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public abstract class eyr {
    private Map<String, Object> f11683a;

    public boolean m17719b(String str) {
        return this.f11683a != null && this.f11683a.containsKey(str);
    }

    public void m17714a(String str, long j) {
        m17713c(str, Long.valueOf(j));
    }

    public void m17718b(String str, String str2) {
        m17713c(str, str2);
    }

    public void m17715a(String str, Object obj) {
        m17713c(str, obj);
    }

    private void m17713c(String str, Object obj) {
        m17712a(str, obj, false);
    }

    private void m17712a(String str, Object obj, boolean z) {
        exu.m18430a((Object) str);
        if (obj != null || z) {
            if (this.f11683a == null) {
                this.f11683a = new HashMap(2);
            }
            this.f11683a.put(str, obj);
        }
    }

    public Object m17720c(String str) {
        return m17717b(str, null);
    }

    public Object m17717b(String str, Object obj) {
        Object obj2 = this.f11683a == null ? obj : this.f11683a.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }

    public long m17716b(String str, long j) {
        try {
            j = ((Long) m17717b(str, Long.valueOf(j))).longValue();
        } catch (ClassCastException e) {
            exu.m18432a(fbp.m18800a("%s's content extras is not %s type.", str, "long"));
        }
        return j;
    }

    public String m17721d(String str) {
        try {
            return (String) m17717b(str, null);
        } catch (ClassCastException e) {
            exu.m18432a(fbp.m18800a("%s's content extras is not %s type.", str, "String"));
            return null;
        }
    }
}
