package com.ushareit.listenit;

import java.util.Map;

public class gg<K, V> {
    static Object[] f13216b;
    static int f13217c;
    static Object[] f13218d;
    static int f13219e;
    int[] f13220f;
    Object[] f13221g;
    int f13222h;

    int m20339a(Object obj, int i) {
        int i2 = this.f13222h;
        if (i2 == 0) {
            return -1;
        }
        int a = fs.m20754a(this.f13220f, i2, i);
        if (a < 0 || obj.equals(this.f13221g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f13220f[i3] == i) {
            if (obj.equals(this.f13221g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f13220f[a] == i) {
            if (obj.equals(this.f13221g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m20337a() {
        int i = this.f13222h;
        if (i == 0) {
            return -1;
        }
        int a = fs.m20754a(this.f13220f, i, 0);
        if (a < 0 || this.f13221g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f13220f[i2] == 0) {
            if (this.f13221g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f13220f[a] == 0) {
            if (this.f13221g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m20336e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (fq.class) {
                if (f13218d != null) {
                    objArr = f13218d;
                    this.f13221g = objArr;
                    f13218d = (Object[]) objArr[0];
                    this.f13220f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f13219e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (fq.class) {
                if (f13216b != null) {
                    objArr = f13216b;
                    this.f13221g = objArr;
                    f13216b = (Object[]) objArr[0];
                    this.f13220f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f13217c--;
                    return;
                }
            }
        }
        this.f13220f = new int[i];
        this.f13221g = new Object[(i << 1)];
    }

    private static void m20335a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (fq.class) {
                if (f13219e < 10) {
                    objArr[0] = f13218d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f13218d = objArr;
                    f13219e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (fq.class) {
                if (f13217c < 10) {
                    objArr[0] = f13216b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f13216b = objArr;
                    f13217c++;
                }
            }
        }
    }

    public gg() {
        this.f13220f = fs.f13327a;
        this.f13221g = fs.f13329c;
        this.f13222h = 0;
    }

    public gg(int i) {
        if (i == 0) {
            this.f13220f = fs.f13327a;
            this.f13221g = fs.f13329c;
        } else {
            m20336e(i);
        }
        this.f13222h = 0;
    }

    public void clear() {
        if (this.f13222h != 0) {
            m20335a(this.f13220f, this.f13221g, this.f13222h);
            this.f13220f = fs.f13327a;
            this.f13221g = fs.f13329c;
            this.f13222h = 0;
        }
    }

    public void m20341a(int i) {
        if (this.f13220f.length < i) {
            Object obj = this.f13220f;
            Object obj2 = this.f13221g;
            m20336e(i);
            if (this.f13222h > 0) {
                System.arraycopy(obj, 0, this.f13220f, 0, this.f13222h);
                System.arraycopy(obj2, 0, this.f13221g, 0, this.f13222h << 1);
            }
            m20335a(obj, obj2, this.f13222h);
        }
    }

    public boolean containsKey(Object obj) {
        return m20338a(obj) >= 0;
    }

    public int m20338a(Object obj) {
        return obj == null ? m20337a() : m20339a(obj, obj.hashCode());
    }

    int m20343b(Object obj) {
        int i = 1;
        int i2 = this.f13222h * 2;
        Object[] objArr = this.f13221g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m20343b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = m20338a(obj);
        return a >= 0 ? this.f13221g[(a << 1) + 1] : null;
    }

    public K m20344b(int i) {
        return this.f13221g[i << 1];
    }

    public V m20345c(int i) {
        return this.f13221g[(i << 1) + 1];
    }

    public V m20340a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f13221g[i2];
        this.f13221g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f13222h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m20337a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m20339a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f13221g[i3];
            this.f13221g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f13222h >= this.f13220f.length) {
            if (this.f13222h >= 8) {
                i2 = this.f13222h + (this.f13222h >> 1);
            } else if (this.f13222h < 4) {
                i2 = 4;
            }
            Object obj = this.f13220f;
            Object obj2 = this.f13221g;
            m20336e(i2);
            if (this.f13220f.length > 0) {
                System.arraycopy(obj, 0, this.f13220f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f13221g, 0, obj2.length);
            }
            m20335a(obj, obj2, this.f13222h);
        }
        if (a < this.f13222h) {
            System.arraycopy(this.f13220f, a, this.f13220f, a + 1, this.f13222h - a);
            System.arraycopy(this.f13221g, a << 1, this.f13221g, (a + 1) << 1, (this.f13222h - a) << 1);
        }
        this.f13220f[a] = i;
        this.f13221g[a << 1] = k;
        this.f13221g[(a << 1) + 1] = v;
        this.f13222h++;
        return null;
    }

    public void m20342a(gg<? extends K, ? extends V> ggVar) {
        int i = 0;
        int i2 = ggVar.f13222h;
        m20341a(this.f13222h + i2);
        if (this.f13222h != 0) {
            while (i < i2) {
                put(ggVar.m20344b(i), ggVar.m20345c(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(ggVar.f13220f, 0, this.f13220f, 0, i2);
            System.arraycopy(ggVar.f13221g, 0, this.f13221g, 0, i2 << 1);
            this.f13222h = i2;
        }
    }

    public V remove(Object obj) {
        int a = m20338a(obj);
        if (a >= 0) {
            return m20346d(a);
        }
        return null;
    }

    public V m20346d(int i) {
        int i2 = 8;
        V v = this.f13221g[(i << 1) + 1];
        if (this.f13222h <= 1) {
            m20335a(this.f13220f, this.f13221g, this.f13222h);
            this.f13220f = fs.f13327a;
            this.f13221g = fs.f13329c;
            this.f13222h = 0;
        } else if (this.f13220f.length <= 8 || this.f13222h >= this.f13220f.length / 3) {
            this.f13222h--;
            if (i < this.f13222h) {
                System.arraycopy(this.f13220f, i + 1, this.f13220f, i, this.f13222h - i);
                System.arraycopy(this.f13221g, (i + 1) << 1, this.f13221g, i << 1, (this.f13222h - i) << 1);
            }
            this.f13221g[this.f13222h << 1] = null;
            this.f13221g[(this.f13222h << 1) + 1] = null;
        } else {
            if (this.f13222h > 8) {
                i2 = this.f13222h + (this.f13222h >> 1);
            }
            Object obj = this.f13220f;
            Object obj2 = this.f13221g;
            m20336e(i2);
            this.f13222h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f13220f, 0, i);
                System.arraycopy(obj2, 0, this.f13221g, 0, i << 1);
            }
            if (i < this.f13222h) {
                System.arraycopy(obj, i + 1, this.f13220f, i, this.f13222h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f13221g, i << 1, (this.f13222h - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f13222h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object b;
        Object c;
        Object obj2;
        if (obj instanceof gg) {
            gg ggVar = (gg) obj;
            if (size() != ggVar.size()) {
                return false;
            }
            i = 0;
            while (i < this.f13222h) {
                try {
                    b = m20344b(i);
                    c = m20345c(i);
                    obj2 = ggVar.get(b);
                    if (c == null) {
                        if (obj2 != null || !ggVar.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.f13222h) {
                try {
                    b = m20344b(i);
                    c = m20345c(i);
                    obj2 = map.get(b);
                    if (c == null) {
                        if (obj2 != null || !map.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.f13220f;
        Object[] objArr = this.f13221g;
        int i = this.f13222h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f13222h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f13222h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            gg b = m20344b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m20345c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
