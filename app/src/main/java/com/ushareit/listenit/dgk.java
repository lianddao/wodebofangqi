package com.ushareit.listenit;

import java.util.Arrays;

final class dgk {
    final int f9777a;
    final byte[] f9778b;

    dgk(int i, byte[] bArr) {
        this.f9777a = i;
        this.f9778b = bArr;
    }

    int m14259a() {
        return (dga.m14184f(this.f9777a) + 0) + this.f9778b.length;
    }

    void m14260a(dga com_ushareit_listenit_dga) {
        com_ushareit_listenit_dga.m14215e(this.f9777a);
        com_ushareit_listenit_dga.m14214d(this.f9778b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dgk)) {
            return false;
        }
        dgk com_ushareit_listenit_dgk = (dgk) obj;
        return this.f9777a == com_ushareit_listenit_dgk.f9777a && Arrays.equals(this.f9778b, com_ushareit_listenit_dgk.f9778b);
    }

    public int hashCode() {
        return ((this.f9777a + 527) * 31) + Arrays.hashCode(this.f9778b);
    }
}
