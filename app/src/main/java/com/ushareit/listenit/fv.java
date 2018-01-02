package com.ushareit.listenit;

public class fv<E> implements Cloneable {
    private static final Object f13555a = new Object();
    private boolean f13556b;
    private long[] f13557c;
    private Object[] f13558d;
    private int f13559e;

    public /* synthetic */ Object clone() {
        return m21051a();
    }

    public fv() {
        this(10);
    }

    public fv(int i) {
        this.f13556b = false;
        if (i == 0) {
            this.f13557c = fs.f13328b;
            this.f13558d = fs.f13329c;
        } else {
            int b = fs.m20757b(i);
            this.f13557c = new long[b];
            this.f13558d = new Object[b];
        }
        this.f13559e = 0;
    }

    public fv<E> m21051a() {
        try {
            fv<E> fvVar = (fv) super.clone();
            try {
                fvVar.f13557c = (long[]) this.f13557c.clone();
                fvVar.f13558d = (Object[]) this.f13558d.clone();
                return fvVar;
            } catch (CloneNotSupportedException e) {
                return fvVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m21052a(long j) {
        return m21053a(j, null);
    }

    public E m21053a(long j, E e) {
        int a = fs.m20755a(this.f13557c, this.f13559e, j);
        return (a < 0 || this.f13558d[a] == f13555a) ? e : this.f13558d[a];
    }

    public void m21054a(int i) {
        if (this.f13558d[i] != f13555a) {
            this.f13558d[i] = f13555a;
            this.f13556b = true;
        }
    }

    private void m21050d() {
        int i = this.f13559e;
        long[] jArr = this.f13557c;
        Object[] objArr = this.f13558d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f13555a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f13556b = false;
        this.f13559e = i2;
    }

    public void m21057b(long j, E e) {
        int a = fs.m20755a(this.f13557c, this.f13559e, j);
        if (a >= 0) {
            this.f13558d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f13559e || this.f13558d[a] != f13555a) {
            if (this.f13556b && this.f13559e >= this.f13557c.length) {
                m21050d();
                a = fs.m20755a(this.f13557c, this.f13559e, j) ^ -1;
            }
            if (this.f13559e >= this.f13557c.length) {
                int b = fs.m20757b(this.f13559e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f13557c, 0, obj, 0, this.f13557c.length);
                System.arraycopy(this.f13558d, 0, obj2, 0, this.f13558d.length);
                this.f13557c = obj;
                this.f13558d = obj2;
            }
            if (this.f13559e - a != 0) {
                System.arraycopy(this.f13557c, a, this.f13557c, a + 1, this.f13559e - a);
                System.arraycopy(this.f13558d, a, this.f13558d, a + 1, this.f13559e - a);
            }
            this.f13557c[a] = j;
            this.f13558d[a] = e;
            this.f13559e++;
            return;
        }
        this.f13557c[a] = j;
        this.f13558d[a] = e;
    }

    public int m21055b() {
        if (this.f13556b) {
            m21050d();
        }
        return this.f13559e;
    }

    public long m21056b(int i) {
        if (this.f13556b) {
            m21050d();
        }
        return this.f13557c[i];
    }

    public E m21058c(int i) {
        if (this.f13556b) {
            m21050d();
        }
        return this.f13558d[i];
    }

    public void m21059c() {
        int i = this.f13559e;
        Object[] objArr = this.f13558d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f13559e = 0;
        this.f13556b = false;
    }

    public String toString() {
        if (m21055b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f13559e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f13559e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m21056b(i));
            stringBuilder.append('=');
            fv c = m21058c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
