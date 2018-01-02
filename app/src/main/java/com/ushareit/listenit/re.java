package com.ushareit.listenit;

import android.util.SparseIntArray;

public abstract class re {
    final SparseIntArray f16396a;
    private boolean f16397b;

    public abstract int m25927a(int i);

    public void m25929a() {
        this.f16396a.clear();
    }

    public int m25928a(int i, int i2) {
        if (!this.f16397b) {
            return m25931b(i, i2);
        }
        int i3 = this.f16396a.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = m25931b(i, i2);
        this.f16396a.put(i, i3);
        return i3;
    }

    public int m25931b(int i, int i2) {
        int a = m25927a(i);
        if (a == i2) {
            return 0;
        }
        int b;
        int a2;
        int i3;
        if (this.f16397b && this.f16396a.size() > 0) {
            b = m25930b(i);
            if (b >= 0) {
                a2 = this.f16396a.get(b) + m25927a(b);
                b++;
                i3 = b;
                while (i3 < i) {
                    b = m25927a(i3);
                    a2 += b;
                    if (a2 == i2) {
                        b = 0;
                    } else if (a2 <= i2) {
                        b = a2;
                    }
                    i3++;
                    a2 = b;
                }
                if (a2 + a > i2) {
                    return a2;
                }
                return 0;
            }
        }
        b = 0;
        a2 = 0;
        i3 = b;
        while (i3 < i) {
            b = m25927a(i3);
            a2 += b;
            if (a2 == i2) {
                b = 0;
            } else if (a2 <= i2) {
                b = a2;
            }
            i3++;
            a2 = b;
        }
        if (a2 + a > i2) {
            return 0;
        }
        return a2;
    }

    int m25930b(int i) {
        int i2 = 0;
        int size = this.f16396a.size() - 1;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            if (this.f16396a.keyAt(i3) < i) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        size = i2 - 1;
        if (size < 0 || size >= this.f16396a.size()) {
            return -1;
        }
        return this.f16396a.keyAt(size);
    }

    public int m25932c(int i, int i2) {
        int a = m25927a(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            int a2 = m25927a(i3);
            i5 += a2;
            if (i5 == i2) {
                i4++;
                a2 = 0;
            } else if (i5 > i2) {
                i4++;
            } else {
                a2 = i5;
            }
            i3++;
            i5 = a2;
        }
        if (i5 + a > i2) {
            return i4 + 1;
        }
        return i4;
    }
}
