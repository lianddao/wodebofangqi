package com.ushareit.listenit;

public class gh<E> implements Cloneable {
    private static final Object f14107a = new Object();
    private boolean f14108b;
    private int[] f14109c;
    private Object[] f14110d;
    private int f14111e;

    public /* synthetic */ Object clone() {
        return m21986a();
    }

    public gh() {
        this(10);
    }

    public gh(int i) {
        this.f14108b = false;
        if (i == 0) {
            this.f14109c = fs.f13327a;
            this.f14110d = fs.f13329c;
        } else {
            int a = fs.m20753a(i);
            this.f14109c = new int[a];
            this.f14110d = new Object[a];
        }
        this.f14111e = 0;
    }

    public gh<E> m21986a() {
        try {
            gh<E> ghVar = (gh) super.clone();
            try {
                ghVar.f14109c = (int[]) this.f14109c.clone();
                ghVar.f14110d = (Object[]) this.f14110d.clone();
                return ghVar;
            } catch (CloneNotSupportedException e) {
                return ghVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m21987a(int i) {
        return m21988a(i, null);
    }

    public E m21988a(int i, E e) {
        int a = fs.m20754a(this.f14109c, this.f14111e, i);
        return (a < 0 || this.f14110d[a] == f14107a) ? e : this.f14110d[a];
    }

    public void m21990b(int i) {
        int a = fs.m20754a(this.f14109c, this.f14111e, i);
        if (a >= 0 && this.f14110d[a] != f14107a) {
            this.f14110d[a] = f14107a;
            this.f14108b = true;
        }
    }

    public void m21993c(int i) {
        m21990b(i);
    }

    private void m21985d() {
        int i = this.f14111e;
        int[] iArr = this.f14109c;
        Object[] objArr = this.f14110d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f14107a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f14108b = false;
        this.f14111e = i2;
    }

    public void m21991b(int i, E e) {
        int a = fs.m20754a(this.f14109c, this.f14111e, i);
        if (a >= 0) {
            this.f14110d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f14111e || this.f14110d[a] != f14107a) {
            if (this.f14108b && this.f14111e >= this.f14109c.length) {
                m21985d();
                a = fs.m20754a(this.f14109c, this.f14111e, i) ^ -1;
            }
            if (this.f14111e >= this.f14109c.length) {
                int a2 = fs.m20753a(this.f14111e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f14109c, 0, obj, 0, this.f14109c.length);
                System.arraycopy(this.f14110d, 0, obj2, 0, this.f14110d.length);
                this.f14109c = obj;
                this.f14110d = obj2;
            }
            if (this.f14111e - a != 0) {
                System.arraycopy(this.f14109c, a, this.f14109c, a + 1, this.f14111e - a);
                System.arraycopy(this.f14110d, a, this.f14110d, a + 1, this.f14111e - a);
            }
            this.f14109c[a] = i;
            this.f14110d[a] = e;
            this.f14111e++;
            return;
        }
        this.f14109c[a] = i;
        this.f14110d[a] = e;
    }

    public int m21989b() {
        if (this.f14108b) {
            m21985d();
        }
        return this.f14111e;
    }

    public int m21994d(int i) {
        if (this.f14108b) {
            m21985d();
        }
        return this.f14109c[i];
    }

    public E m21995e(int i) {
        if (this.f14108b) {
            m21985d();
        }
        return this.f14110d[i];
    }

    public int m21996f(int i) {
        if (this.f14108b) {
            m21985d();
        }
        return fs.m20754a(this.f14109c, this.f14111e, i);
    }

    public void m21992c() {
        int i = this.f14111e;
        Object[] objArr = this.f14110d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f14111e = 0;
        this.f14108b = false;
    }

    public String toString() {
        if (m21989b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f14111e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f14111e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m21994d(i));
            stringBuilder.append('=');
            gh e = m21995e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
