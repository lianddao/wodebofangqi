package com.ushareit.listenit;

import java.net.URLEncoder;
import java.util.Map;

public class ecg extends ecp {
    ecg(cqt com_ushareit_listenit_cqt, cqq com_ushareit_listenit_cqq) {
        super(com_ushareit_listenit_cqt, com_ushareit_listenit_cqq);
    }

    private dzo<Void> m16731a(Object obj, cxa com_ushareit_listenit_cxa, ecj com_ushareit_listenit_ecj) {
        cyt.m13395a(m16729c());
        cta.m12563a(m16729c(), obj);
        Object a = cyu.m13406a(obj);
        cyt.m13396a(a);
        cxa a2 = cxd.m13276a(a, com_ushareit_listenit_cxa);
        cyp a3 = cyr.m13384a(com_ushareit_listenit_ecj);
        this.a.m12396a(new ech(this, a2, a3));
        return (dzo) a3.m13380a();
    }

    private dzo<Void> m16732a(Map<String, Object> map, ecj com_ushareit_listenit_ecj) {
        if (map == null) {
            throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
        }
        Map a = cyu.m13410a((Map) map);
        cpz b = cpz.m12235b(cyt.m13394a(m16729c(), a));
        cyp a2 = cyr.m13384a(com_ushareit_listenit_ecj);
        this.a.m12396a(new eci(this, b, a2, a));
        return (dzo) a2.m13380a();
    }

    public dzo<Void> m16733a(Object obj) {
        return m16731a(obj, cxg.m13289a(null), null);
    }

    public dzo<Void> m16734a(Map<String, Object> map) {
        return m16732a(map, null);
    }

    public ecg mo2134a() {
        cqq f = m16729c().m12345f();
        return f != null ? new ecg(this.a, f) : null;
    }

    public ecg m16736a(String str) {
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
        }
        if (m16729c().m12347h()) {
            cyt.m13398b(str);
        } else {
            cyt.m13397a(str);
        }
        return new ecg(this.a, m16729c().m12337a(new cqq(str)));
    }

    public String m16737b() {
        return m16729c().m12347h() ? null : m16729c().m12346g().m13144d();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ecg) && toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        ecg a = mo2134a();
        if (a == null) {
            return this.a.toString();
        }
        String valueOf;
        try {
            valueOf = String.valueOf(a.toString());
            String valueOf2 = String.valueOf(URLEncoder.encode(m16737b(), "UTF-8").replace("+", "%20"));
            return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("/").append(valueOf2).toString();
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Failed to URLEncode key: ";
            valueOf = String.valueOf(m16737b());
            throw new ecf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
    }
}
