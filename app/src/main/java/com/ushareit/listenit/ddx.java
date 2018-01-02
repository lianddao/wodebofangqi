package com.ushareit.listenit;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class ddx<K, V> extends dbq<Map<K, V>> {
    final /* synthetic */ ddw f9638a;
    private final dbq<K> f9639b;
    private final dbq<V> f9640c;
    private final dda<? extends Map<K, V>> f9641d;

    public ddx(ddw com_ushareit_listenit_ddw, dao com_ushareit_listenit_dao, Type type, dbq<K> com_ushareit_listenit_dbq_K, Type type2, dbq<V> com_ushareit_listenit_dbq_V, dda<? extends Map<K, V>> com_ushareit_listenit_dda__extends_java_util_Map_K__V) {
        this.f9638a = com_ushareit_listenit_ddw;
        this.f9639b = new dej(com_ushareit_listenit_dao, com_ushareit_listenit_dbq_K, type);
        this.f9640c = new dej(com_ushareit_listenit_dao, com_ushareit_listenit_dbq_V, type2);
        this.f9641d = com_ushareit_listenit_dda__extends_java_util_Map_K__V;
    }

    private String m13959a(dba com_ushareit_listenit_dba) {
        if (com_ushareit_listenit_dba.m13697j()) {
            dbg n = com_ushareit_listenit_dba.m13701n();
            if (n.m13734p()) {
                return String.valueOf(n.mo1702b());
            }
            if (n.m13726a()) {
                return Boolean.toString(n.mo1707g());
            }
            if (n.m13735q()) {
                return n.mo1703c();
            }
            throw new AssertionError();
        } else if (com_ushareit_listenit_dba.m13698k()) {
            return "null";
        } else {
            throw new AssertionError();
        }
    }

    public Map<K, V> m13960a(dfu com_ushareit_listenit_dfu) {
        dfw f = com_ushareit_listenit_dfu.mo1718f();
        if (f == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        Map<K, V> map = (Map) this.f9641d.mo1710a();
        Object b;
        if (f == dfw.BEGIN_ARRAY) {
            com_ushareit_listenit_dfu.mo1712a();
            while (com_ushareit_listenit_dfu.mo1717e()) {
                com_ushareit_listenit_dfu.mo1712a();
                b = this.f9639b.mo1401b(com_ushareit_listenit_dfu);
                if (map.put(b, this.f9640c.mo1401b(com_ushareit_listenit_dfu)) != null) {
                    String valueOf = String.valueOf(b);
                    throw new dbj(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                }
                com_ushareit_listenit_dfu.mo1713b();
            }
            com_ushareit_listenit_dfu.mo1713b();
            return map;
        }
        com_ushareit_listenit_dfu.mo1714c();
        while (com_ushareit_listenit_dfu.mo1717e()) {
            dcq.f9549a.mo1745a(com_ushareit_listenit_dfu);
            b = this.f9639b.mo1401b(com_ushareit_listenit_dfu);
            if (map.put(b, this.f9640c.mo1401b(com_ushareit_listenit_dfu)) != null) {
                valueOf = String.valueOf(b);
                throw new dbj(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
            }
        }
        com_ushareit_listenit_dfu.mo1716d();
        return map;
    }

    public void m13962a(dfx com_ushareit_listenit_dfx, Map<K, V> map) {
        int i = 0;
        if (map == null) {
            com_ushareit_listenit_dfx.mo1740f();
        } else if (this.f9638a.f9637b) {
            List arrayList = new ArrayList(map.size());
            List arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            for (Entry entry : map.entrySet()) {
                dba a = this.f9639b.m11605a(entry.getKey());
                arrayList.add(a);
                arrayList2.add(entry.getValue());
                int i3 = (a.m13695h() || a.m13696i()) ? 1 : 0;
                i2 = i3 | i2;
            }
            if (i2 != 0) {
                com_ushareit_listenit_dfx.mo1734b();
                while (i < arrayList.size()) {
                    com_ushareit_listenit_dfx.mo1734b();
                    ddc.m13833a((dba) arrayList.get(i), com_ushareit_listenit_dfx);
                    this.f9640c.mo1400a(com_ushareit_listenit_dfx, arrayList2.get(i));
                    com_ushareit_listenit_dfx.mo1736c();
                    i++;
                }
                com_ushareit_listenit_dfx.mo1736c();
                return;
            }
            com_ushareit_listenit_dfx.mo1738d();
            while (i < arrayList.size()) {
                com_ushareit_listenit_dfx.mo1732a(m13959a((dba) arrayList.get(i)));
                this.f9640c.mo1400a(com_ushareit_listenit_dfx, arrayList2.get(i));
                i++;
            }
            com_ushareit_listenit_dfx.mo1739e();
        } else {
            com_ushareit_listenit_dfx.mo1738d();
            for (Entry entry2 : map.entrySet()) {
                com_ushareit_listenit_dfx.mo1732a(String.valueOf(entry2.getKey()));
                this.f9640c.mo1400a(com_ushareit_listenit_dfx, entry2.getValue());
            }
            com_ushareit_listenit_dfx.mo1739e();
        }
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m13960a(com_ushareit_listenit_dfu);
    }
}
