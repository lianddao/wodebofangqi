package com.ushareit.listenit;

import java.io.EOFException;
import java.util.Arrays;

public final class bhq implements bhz {
    private static final byte[] f6347a = new byte[4096];
    private final brh f6348b;
    private final long f6349c;
    private long f6350d;
    private byte[] f6351e = new byte[8192];
    private int f6352f;
    private int f6353g;

    public bhq(brh com_ushareit_listenit_brh, long j, long j2) {
        this.f6348b = com_ushareit_listenit_brh;
        this.f6350d = j;
        this.f6349c = j2;
    }

    public int mo961a(byte[] bArr, int i, int i2) {
        int d = m8453d(bArr, i, i2);
        if (d == 0) {
            d = m8452a(bArr, i, i2, 0, true);
        }
        m8457g(d);
        return d;
    }

    public boolean mo963a(byte[] bArr, int i, int i2, boolean z) {
        int d = m8453d(bArr, i, i2);
        while (d < i2 && d != -1) {
            d = m8452a(bArr, i, i2, d, z);
        }
        m8457g(d);
        return d != -1;
    }

    public void mo966b(byte[] bArr, int i, int i2) {
        mo963a(bArr, i, i2, false);
    }

    public int mo960a(int i) {
        int e = m8455e(i);
        if (e == 0) {
            e = m8452a(f6347a, 0, Math.min(i, f6347a.length), 0, true);
        }
        m8457g(e);
        return e;
    }

    public boolean m8461a(int i, boolean z) {
        int e = m8455e(i);
        while (e < i && e != -1) {
            e = m8452a(f6347a, -e, Math.min(i, f6347a.length + e), e, z);
        }
        m8457g(e);
        return e != -1;
    }

    public void mo965b(int i) {
        m8461a(i, false);
    }

    public boolean mo967b(byte[] bArr, int i, int i2, boolean z) {
        if (!m8466b(i2, z)) {
            return false;
        }
        System.arraycopy(this.f6351e, this.f6352f - i2, bArr, i, i2);
        return true;
    }

    public void mo970c(byte[] bArr, int i, int i2) {
        mo967b(bArr, i, i2, false);
    }

    public boolean m8466b(int i, boolean z) {
        m8454d(i);
        int min = Math.min(this.f6353g - this.f6352f, i);
        while (min < i) {
            min = m8452a(this.f6351e, this.f6352f, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.f6352f += i;
        this.f6353g = Math.max(this.f6353g, this.f6352f);
        return true;
    }

    public void mo969c(int i) {
        m8466b(i, false);
    }

    public void mo962a() {
        this.f6352f = 0;
    }

    public long mo964b() {
        return this.f6350d + ((long) this.f6352f);
    }

    public long mo968c() {
        return this.f6350d;
    }

    public long mo971d() {
        return this.f6349c;
    }

    private void m8454d(int i) {
        int i2 = this.f6352f + i;
        if (i2 > this.f6351e.length) {
            this.f6351e = Arrays.copyOf(this.f6351e, Math.max(this.f6351e.length * 2, i2));
        }
    }

    private int m8455e(int i) {
        int min = Math.min(this.f6353g, i);
        m8456f(min);
        return min;
    }

    private int m8453d(byte[] bArr, int i, int i2) {
        if (this.f6353g == 0) {
            return 0;
        }
        int min = Math.min(this.f6353g, i2);
        System.arraycopy(this.f6351e, 0, bArr, i, min);
        m8456f(min);
        return min;
    }

    private void m8456f(int i) {
        this.f6353g -= i;
        this.f6352f = 0;
        System.arraycopy(this.f6351e, i, this.f6351e, 0, this.f6353g);
    }

    private int m8452a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int a = this.f6348b.mo1087a(bArr, i + i3, i2 - i3);
        if (a != -1) {
            return i3 + a;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private void m8457g(int i) {
        if (i != -1) {
            this.f6350d += (long) i;
        }
    }
}
