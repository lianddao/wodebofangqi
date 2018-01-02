package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class cqq implements Comparable<cqq>, Iterable<cwc> {
    static final /* synthetic */ boolean f8726a = (!cqq.class.desiredAssertionStatus());
    private static final cqq f8727e = new cqq("");
    private final cwc[] f8728b;
    private final int f8729c;
    private final int f8730d;

    public cqq(String str) {
        String[] split = str.split("/");
        int i = 0;
        for (String length : split) {
            if (length.length() > 0) {
                i++;
            }
        }
        this.f8728b = new cwc[i];
        int length2 = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            String str2 = split[i2];
            if (str2.length() > 0) {
                i = i3 + 1;
                this.f8728b[i3] = cwc.m13139a(str2);
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.f8729c = 0;
        this.f8730d = this.f8728b.length;
    }

    public cqq(List<String> list) {
        this.f8728b = new cwc[list.size()];
        int i = 0;
        for (String a : list) {
            int i2 = i + 1;
            this.f8728b[i] = cwc.m13139a(a);
            i = i2;
        }
        this.f8729c = 0;
        this.f8730d = list.size();
    }

    public cqq(cwc... com_ushareit_listenit_cwcArr) {
        this.f8728b = (cwc[]) Arrays.copyOf(com_ushareit_listenit_cwcArr, com_ushareit_listenit_cwcArr.length);
        this.f8729c = 0;
        this.f8730d = com_ushareit_listenit_cwcArr.length;
        int length = com_ushareit_listenit_cwcArr.length;
        int i = 0;
        while (i < length) {
            cwc com_ushareit_listenit_cwc = com_ushareit_listenit_cwcArr[i];
            if (f8726a || com_ushareit_listenit_cwc != null) {
                i++;
            } else {
                throw new AssertionError("Can't construct a path with a null value!");
            }
        }
    }

    private cqq(cwc[] com_ushareit_listenit_cwcArr, int i, int i2) {
        this.f8728b = com_ushareit_listenit_cwcArr;
        this.f8729c = i;
        this.f8730d = i2;
    }

    public static cqq m12332a() {
        return f8727e;
    }

    public static cqq m12333a(cqq com_ushareit_listenit_cqq, cqq com_ushareit_listenit_cqq2) {
        cwc d = com_ushareit_listenit_cqq.m12343d();
        cwc d2 = com_ushareit_listenit_cqq2.m12343d();
        if (d == null) {
            return com_ushareit_listenit_cqq2;
        }
        if (d.equals(d2)) {
            return m12333a(com_ushareit_listenit_cqq.m12344e(), com_ushareit_listenit_cqq2.m12344e());
        }
        String valueOf = String.valueOf(com_ushareit_listenit_cqq2);
        String valueOf2 = String.valueOf(com_ushareit_listenit_cqq);
        throw new ecf(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()).append("INTERNAL ERROR: ").append(valueOf).append(" is not contained in ").append(valueOf2).toString());
    }

    public cqq m12337a(cqq com_ushareit_listenit_cqq) {
        int i = m12348i() + com_ushareit_listenit_cqq.m12348i();
        Object obj = new cwc[i];
        System.arraycopy(this.f8728b, this.f8729c, obj, 0, m12348i());
        System.arraycopy(com_ushareit_listenit_cqq.f8728b, com_ushareit_listenit_cqq.f8729c, obj, m12348i(), com_ushareit_listenit_cqq.m12348i());
        return new cqq(obj, 0, i);
    }

    public cqq m12338a(cwc com_ushareit_listenit_cwc) {
        int i = m12348i();
        Object obj = new cwc[(i + 1)];
        System.arraycopy(this.f8728b, this.f8729c, obj, 0, i);
        obj[i] = com_ushareit_listenit_cwc;
        return new cqq(obj, 0, i + 1);
    }

    public String m12339b() {
        if (m12347h()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.f8729c; i < this.f8730d; i++) {
            if (i > this.f8729c) {
                stringBuilder.append("/");
            }
            stringBuilder.append(this.f8728b[i].m13144d());
        }
        return stringBuilder.toString();
    }

    public boolean m12340b(cqq com_ushareit_listenit_cqq) {
        if (m12348i() > com_ushareit_listenit_cqq.m12348i()) {
            return false;
        }
        int i = this.f8729c;
        int i2 = com_ushareit_listenit_cqq.f8729c;
        while (i < this.f8730d) {
            if (!this.f8728b[i].equals(com_ushareit_listenit_cqq.f8728b[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public int m12341c(cqq com_ushareit_listenit_cqq) {
        int i = this.f8729c;
        int i2 = com_ushareit_listenit_cqq.f8729c;
        while (i < this.f8730d && i2 < com_ushareit_listenit_cqq.f8730d) {
            int a = this.f8728b[i].m13143a(com_ushareit_listenit_cqq.f8728b[i2]);
            if (a != 0) {
                return a;
            }
            i++;
            i2++;
        }
        return (i == this.f8730d && i2 == com_ushareit_listenit_cqq.f8730d) ? 0 : i == this.f8730d ? -1 : 1;
    }

    public List<String> m12342c() {
        List<String> arrayList = new ArrayList(m12348i());
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((cwc) it.next()).m13144d());
        }
        return arrayList;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m12341c((cqq) obj);
    }

    public cwc m12343d() {
        return m12347h() ? null : this.f8728b[this.f8729c];
    }

    public cqq m12344e() {
        int i = this.f8729c;
        if (!m12347h()) {
            i++;
        }
        return new cqq(this.f8728b, i, this.f8730d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cqq)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        cqq com_ushareit_listenit_cqq = (cqq) obj;
        if (m12348i() != com_ushareit_listenit_cqq.m12348i()) {
            return false;
        }
        int i = this.f8729c;
        int i2 = com_ushareit_listenit_cqq.f8729c;
        while (i < this.f8730d && i2 < com_ushareit_listenit_cqq.f8730d) {
            if (!this.f8728b[i].equals(com_ushareit_listenit_cqq.f8728b[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public cqq m12345f() {
        return m12347h() ? null : new cqq(this.f8728b, this.f8729c, this.f8730d - 1);
    }

    public cwc m12346g() {
        return !m12347h() ? this.f8728b[this.f8730d - 1] : null;
    }

    public boolean m12347h() {
        return this.f8729c >= this.f8730d;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = this.f8729c; i2 < this.f8730d; i2++) {
            i = (i * 37) + this.f8728b[i2].hashCode();
        }
        return i;
    }

    public int m12348i() {
        return this.f8730d - this.f8729c;
    }

    public Iterator<cwc> iterator() {
        return new cqr(this);
    }

    public String toString() {
        if (m12347h()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.f8729c; i < this.f8730d; i++) {
            stringBuilder.append("/");
            stringBuilder.append(this.f8728b[i].m13144d());
        }
        return stringBuilder.toString();
    }
}
