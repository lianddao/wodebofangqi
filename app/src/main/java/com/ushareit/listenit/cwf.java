package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cwf implements cxa {
    public static Comparator<cwc> f9256a = new cwg();
    static final /* synthetic */ boolean f9257b = (!cwf.class.desiredAssertionStatus());
    private final cnj<cwc, cxa> f9258c;
    private final cxa f9259e;
    private String f9260f;

    protected cwf() {
        this.f9260f = null;
        this.f9258c = cnk.m11905a(f9256a);
        this.f9259e = cxg.m13288a();
    }

    protected cwf(cnj<cwc, cxa> com_ushareit_listenit_cnj_com_ushareit_listenit_cwc__com_ushareit_listenit_cxa, cxa com_ushareit_listenit_cxa) {
        this.f9260f = null;
        if (!com_ushareit_listenit_cnj_com_ushareit_listenit_cwc__com_ushareit_listenit_cxa.mo1494d() || com_ushareit_listenit_cxa.mo1635b()) {
            this.f9259e = com_ushareit_listenit_cxa;
            this.f9258c = com_ushareit_listenit_cnj_com_ushareit_listenit_cwc__com_ushareit_listenit_cxa;
            return;
        }
        throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
    }

    private static void m13150a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(" ");
        }
    }

    private void m13151b(StringBuilder stringBuilder, int i) {
        if (this.f9258c.mo1494d() && this.f9259e.mo1635b()) {
            stringBuilder.append("{ }");
            return;
        }
        stringBuilder.append("{\n");
        Iterator it = this.f9258c.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            m13150a(stringBuilder, i + 2);
            stringBuilder.append(((cwc) entry.getKey()).m13144d());
            stringBuilder.append("=");
            if (entry.getValue() instanceof cwf) {
                ((cwf) entry.getValue()).m13151b(stringBuilder, i + 2);
            } else {
                stringBuilder.append(((cxa) entry.getValue()).toString());
            }
            stringBuilder.append("\n");
        }
        if (!this.f9259e.mo1635b()) {
            m13150a(stringBuilder, i + 2);
            stringBuilder.append(".priority=");
            stringBuilder.append(this.f9259e.toString());
            stringBuilder.append("\n");
        }
        m13150a(stringBuilder, i);
        stringBuilder.append("}");
    }

    public int mo1652a(cxa com_ushareit_listenit_cxa) {
        return mo1635b() ? com_ushareit_listenit_cxa.mo1635b() ? 0 : -1 : com_ushareit_listenit_cxa.mo1639e() ? 1 : com_ushareit_listenit_cxa.mo1635b() ? 1 : com_ushareit_listenit_cxa == cxa.f9244d ? -1 : 0;
    }

    public cxa mo1629a(cqq com_ushareit_listenit_cqq) {
        cwc d = com_ushareit_listenit_cqq.m12343d();
        return d == null ? this : mo1637c(d).mo1629a(com_ushareit_listenit_cqq.m12344e());
    }

    public cxa mo1630a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        cwc d = com_ushareit_listenit_cqq.m12343d();
        if (d == null) {
            return com_ushareit_listenit_cxa;
        }
        if (!d.m13145e()) {
            return mo1631a(d, mo1637c(d).mo1630a(com_ushareit_listenit_cqq.m12344e(), com_ushareit_listenit_cxa));
        }
        if (f9257b || cxg.m13290a(com_ushareit_listenit_cxa)) {
            return mo1645b(com_ushareit_listenit_cxa);
        }
        throw new AssertionError();
    }

    public cxa mo1631a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cwc.m13145e()) {
            return mo1645b(com_ushareit_listenit_cxa);
        }
        cnj com_ushareit_listenit_cnj = this.f9258c;
        if (com_ushareit_listenit_cnj.mo1488a((Object) com_ushareit_listenit_cwc)) {
            com_ushareit_listenit_cnj = com_ushareit_listenit_cnj.mo1492c(com_ushareit_listenit_cwc);
        }
        if (!com_ushareit_listenit_cxa.mo1635b()) {
            com_ushareit_listenit_cnj = com_ushareit_listenit_cnj.mo1485a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa);
        }
        return com_ushareit_listenit_cnj.mo1494d() ? cwr.m13215j() : new cwf(com_ushareit_listenit_cnj, this.f9259e);
    }

    public Object mo1643a() {
        return mo1632a(false);
    }

    public Object mo1632a(boolean z) {
        int i = 0;
        if (mo1635b()) {
            return null;
        }
        Map hashMap = new HashMap();
        Iterator it = this.f9258c.iterator();
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            int i5;
            int i6;
            Entry entry = (Entry) it.next();
            String d = ((cwc) entry.getKey()).m13144d();
            hashMap.put(d, ((cxa) entry.getValue()).mo1632a(z));
            i4++;
            if (i2 != 0) {
                if (d.length() <= 1 || d.charAt(0) != '0') {
                    Integer d2 = cyr.m13391d(d);
                    if (d2 == null || d2.intValue() < 0) {
                        i5 = 0;
                        i6 = i3;
                        i2 = i5;
                        i3 = i6;
                    } else if (d2.intValue() > i3) {
                        i3 = d2.intValue();
                        i5 = i2;
                        i6 = i3;
                        i2 = i5;
                        i3 = i6;
                    }
                } else {
                    i5 = 0;
                    i6 = i3;
                    i2 = i5;
                    i3 = i6;
                }
            }
            i5 = i2;
            i6 = i3;
            i2 = i5;
            i3 = i6;
        }
        if (z || i2 == 0 || i3 >= i4 * 2) {
            if (z && !this.f9259e.mo1635b()) {
                hashMap.put(".priority", this.f9259e.mo1643a());
            }
            return hashMap;
        }
        List arrayList = new ArrayList(i3 + 1);
        while (i <= i3) {
            arrayList.add(hashMap.get(i));
            i++;
        }
        return arrayList;
    }

    public String mo1644a(cxc com_ushareit_listenit_cxc) {
        if (com_ushareit_listenit_cxc != cxc.V1) {
            throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.f9259e.mo1635b()) {
            stringBuilder.append("priority:");
            stringBuilder.append(this.f9259e.mo1644a(cxc.V1));
            stringBuilder.append(":");
        }
        List<cwz> arrayList = new ArrayList();
        Iterator it = iterator();
        Object obj = null;
        while (it.hasNext()) {
            cwz com_ushareit_listenit_cwz = (cwz) it.next();
            arrayList.add(com_ushareit_listenit_cwz);
            Object obj2 = (obj == null && com_ushareit_listenit_cwz.m13268d().mo1640f().mo1635b()) ? null : 1;
            obj = obj2;
        }
        if (obj != null) {
            Collections.sort(arrayList, cxf.m13282d());
        }
        for (cwz com_ushareit_listenit_cwz2 : arrayList) {
            String d = com_ushareit_listenit_cwz2.m13268d().mo1638d();
            if (!d.equals("")) {
                stringBuilder.append(":");
                stringBuilder.append(com_ushareit_listenit_cwz2.m13267c().m13144d());
                stringBuilder.append(":");
                stringBuilder.append(d);
            }
        }
        return stringBuilder.toString();
    }

    public void m13159a(cwi com_ushareit_listenit_cwi) {
        m13160a(com_ushareit_listenit_cwi, false);
    }

    public void m13160a(cwi com_ushareit_listenit_cwi, boolean z) {
        if (!z || mo1640f().mo1635b()) {
            this.f9258c.mo1487a((cnu) com_ushareit_listenit_cwi);
        } else {
            this.f9258c.mo1487a(new cwh(this, com_ushareit_listenit_cwi));
        }
    }

    public boolean mo1633a(cwc com_ushareit_listenit_cwc) {
        return !mo1637c(com_ushareit_listenit_cwc).mo1635b();
    }

    public cwc mo1634b(cwc com_ushareit_listenit_cwc) {
        return (cwc) this.f9258c.mo1493d(com_ushareit_listenit_cwc);
    }

    public cxa mo1645b(cxa com_ushareit_listenit_cxa) {
        return this.f9258c.mo1494d() ? cwr.m13215j() : new cwf(this.f9258c, com_ushareit_listenit_cxa);
    }

    public boolean mo1635b() {
        return this.f9258c.mo1494d();
    }

    public int mo1636c() {
        return this.f9258c.mo1491c();
    }

    public cxa mo1637c(cwc com_ushareit_listenit_cwc) {
        return (!com_ushareit_listenit_cwc.m13145e() || this.f9259e.mo1635b()) ? this.f9258c.mo1488a((Object) com_ushareit_listenit_cwc) ? (cxa) this.f9258c.mo1490b(com_ushareit_listenit_cwc) : cwr.m13215j() : this.f9259e;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return mo1652a((cxa) obj);
    }

    public String mo1638d() {
        if (this.f9260f == null) {
            String a = mo1644a(cxc.V1);
            this.f9260f = a.isEmpty() ? "" : cyr.m13389b(a);
        }
        return this.f9260f;
    }

    public boolean mo1639e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cwf)) {
            return false;
        }
        cwf com_ushareit_listenit_cwf = (cwf) obj;
        if (!mo1640f().equals(com_ushareit_listenit_cwf.mo1640f())) {
            return false;
        }
        if (this.f9258c.mo1491c() != com_ushareit_listenit_cwf.f9258c.mo1491c()) {
            return false;
        }
        Iterator it = this.f9258c.iterator();
        Iterator it2 = com_ushareit_listenit_cwf.f9258c.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            if (((cwc) entry.getKey()).equals(entry2.getKey())) {
                if (!((cxa) entry.getValue()).equals(entry2.getValue())) {
                }
            }
            return false;
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }

    public cxa mo1640f() {
        return this.f9259e;
    }

    public cwc m13170g() {
        return (cwc) this.f9258c.mo1486a();
    }

    public cwc m13171h() {
        return (cwc) this.f9258c.mo1489b();
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            cwz com_ushareit_listenit_cwz = (cwz) it.next();
            i = com_ushareit_listenit_cwz.m13268d().hashCode() + (((i * 31) + com_ushareit_listenit_cwz.m13267c().hashCode()) * 17);
        }
        return i;
    }

    public Iterator<cwz> mo1641i() {
        return new cwj(this.f9258c.mo1495e());
    }

    public Iterator<cwz> iterator() {
        return new cwj(this.f9258c.iterator());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        m13151b(stringBuilder, 0);
        return stringBuilder.toString();
    }
}
