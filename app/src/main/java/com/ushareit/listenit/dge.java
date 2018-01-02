package com.ushareit.listenit;

public final class dge implements Cloneable {
    private static final dgf f9766a = new dgf();
    private boolean f9767b;
    private int[] f9768c;
    private dgf[] f9769d;
    private int f9770e;

    dge() {
        this(10);
    }

    dge(int i) {
        this.f9767b = false;
        int c = m14227c(i);
        this.f9768c = new int[c];
        this.f9769d = new dgf[c];
        this.f9770e = 0;
    }

    private boolean m14225a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean m14226a(dgf[] com_ushareit_listenit_dgfArr, dgf[] com_ushareit_listenit_dgfArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!com_ushareit_listenit_dgfArr[i2].equals(com_ushareit_listenit_dgfArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int m14227c(int i) {
        return m14228d(i * 4) / 4;
    }

    private int m14228d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int m14229e(int i) {
        int i2 = 0;
        int i3 = this.f9770e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f9768c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    int m14230a() {
        return this.f9770e;
    }

    dgf m14231a(int i) {
        int e = m14229e(i);
        return (e < 0 || this.f9769d[e] == f9766a) ? null : this.f9769d[e];
    }

    void m14232a(int i, dgf com_ushareit_listenit_dgf) {
        int e = m14229e(i);
        if (e >= 0) {
            this.f9769d[e] = com_ushareit_listenit_dgf;
            return;
        }
        e ^= -1;
        if (e >= this.f9770e || this.f9769d[e] != f9766a) {
            if (this.f9770e >= this.f9768c.length) {
                int c = m14227c(this.f9770e + 1);
                Object obj = new int[c];
                Object obj2 = new dgf[c];
                System.arraycopy(this.f9768c, 0, obj, 0, this.f9768c.length);
                System.arraycopy(this.f9769d, 0, obj2, 0, this.f9769d.length);
                this.f9768c = obj;
                this.f9769d = obj2;
            }
            if (this.f9770e - e != 0) {
                System.arraycopy(this.f9768c, e, this.f9768c, e + 1, this.f9770e - e);
                System.arraycopy(this.f9769d, e, this.f9769d, e + 1, this.f9770e - e);
            }
            this.f9768c[e] = i;
            this.f9769d[e] = com_ushareit_listenit_dgf;
            this.f9770e++;
            return;
        }
        this.f9768c[e] = i;
        this.f9769d[e] = com_ushareit_listenit_dgf;
    }

    dgf m14233b(int i) {
        return this.f9769d[i];
    }

    public boolean m14234b() {
        return m14230a() == 0;
    }

    public final dge m14235c() {
        int a = m14230a();
        dge com_ushareit_listenit_dge = new dge(a);
        System.arraycopy(this.f9768c, 0, com_ushareit_listenit_dge.f9768c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f9769d[i] != null) {
                com_ushareit_listenit_dge.f9769d[i] = (dgf) this.f9769d[i].clone();
            }
        }
        com_ushareit_listenit_dge.f9770e = a;
        return com_ushareit_listenit_dge;
    }

    public /* synthetic */ Object clone() {
        return m14235c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dge)) {
            return false;
        }
        dge com_ushareit_listenit_dge = (dge) obj;
        return m14230a() != com_ushareit_listenit_dge.m14230a() ? false : m14225a(this.f9768c, com_ushareit_listenit_dge.f9768c, this.f9770e) && m14226a(this.f9769d, com_ushareit_listenit_dge.f9769d, this.f9770e);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f9770e; i2++) {
            i = (((i * 31) + this.f9768c[i2]) * 31) + this.f9769d[i2].hashCode();
        }
        return i;
    }
}
