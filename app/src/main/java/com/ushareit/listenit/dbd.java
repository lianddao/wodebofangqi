package com.ushareit.listenit;

import java.util.Map.Entry;
import java.util.Set;

public final class dbd extends dba {
    private final dcs<String, dba> f9490a = new dcs();

    private dba m13712a(Object obj) {
        return obj == null ? dbc.f9489a : new dbg(obj);
    }

    public Set<Entry<String, dba>> m13713a() {
        return this.f9490a.entrySet();
    }

    public void m13714a(String str, dba com_ushareit_listenit_dba) {
        Object obj;
        if (com_ushareit_listenit_dba == null) {
            obj = dbc.f9489a;
        }
        this.f9490a.put(str, obj);
    }

    public void m13715a(String str, Boolean bool) {
        m13714a(str, m13712a((Object) bool));
    }

    public void m13716a(String str, String str2) {
        m13714a(str, m13712a((Object) str2));
    }

    public boolean m13717a(String str) {
        return this.f9490a.containsKey(str);
    }

    public dba m13718b(String str) {
        return (dba) this.f9490a.get(str);
    }

    public dax m13719c(String str) {
        return (dax) this.f9490a.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof dbd) && ((dbd) obj).f9490a.equals(this.f9490a));
    }

    public int hashCode() {
        return this.f9490a.hashCode();
    }
}
