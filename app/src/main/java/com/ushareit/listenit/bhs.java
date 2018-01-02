package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class bhs implements bii {
    private final bra f6355a;
    private final int f6356b;
    private final bhv f6357c = new bhv();
    private final LinkedBlockingDeque<bqz> f6358d = new LinkedBlockingDeque();
    private final bhu f6359e = new bhu();
    private final bss f6360f = new bss(32);
    private final AtomicInteger f6361g = new AtomicInteger();
    private long f6362h;
    private Format f6363i;
    private long f6364j;
    private long f6365k;
    private bqz f6366l;
    private int f6367m = this.f6356b;
    private boolean f6368n = true;
    private boolean f6369o;
    private bhw f6370p;

    public bhs(bra com_ushareit_listenit_bra) {
        this.f6355a = com_ushareit_listenit_bra;
        this.f6356b = com_ushareit_listenit_bra.mo1094c();
    }

    public void m8494a(boolean z) {
        int andSet = this.f6361g.getAndSet(z ? 0 : 2);
        m8486h();
        this.f6357c.m8506b();
        if (andSet == 2) {
            this.f6363i = null;
        }
    }

    public int m8487a() {
        return this.f6357c.m8508c();
    }

    public void m8496b() {
        if (this.f6361g.getAndSet(2) == 0) {
            m8486h();
        }
    }

    public boolean m8497c() {
        return this.f6357c.m8510d();
    }

    public Format m8498d() {
        return this.f6357c.m8511e();
    }

    public long m8499e() {
        return this.f6357c.m8512f();
    }

    public boolean m8495a(long j) {
        long a = this.f6357c.m8502a(j);
        if (a == -1) {
            return false;
        }
        m8483b(a);
        return true;
    }

    public int m8488a(bfu com_ushareit_listenit_bfu, bhf com_ushareit_listenit_bhf, boolean z, long j) {
        switch (this.f6357c.m8500a(com_ushareit_listenit_bfu, com_ushareit_listenit_bhf, this.f6363i, this.f6359e)) {
            case -5:
                this.f6363i = com_ushareit_listenit_bfu.f6128a;
                return -5;
            case -4:
                if (com_ushareit_listenit_bhf.f6322c < j) {
                    com_ushareit_listenit_bhf.m8382b(Integer.MIN_VALUE);
                }
                if (com_ushareit_listenit_bhf.m8398d()) {
                    m8482a(com_ushareit_listenit_bhf, this.f6359e);
                }
                com_ushareit_listenit_bhf.m8400e(this.f6359e.f6371a);
                m8480a(this.f6359e.f6372b, com_ushareit_listenit_bhf.f6321b, this.f6359e.f6371a);
                m8483b(this.f6359e.f6373c);
                return -4;
            case -3:
                if (!z) {
                    return -3;
                }
                com_ushareit_listenit_bhf.a_(4);
                return -4;
            default:
                throw new IllegalStateException();
        }
    }

    private void m8482a(bhf com_ushareit_listenit_bhf, bhu com_ushareit_listenit_bhu) {
        long j;
        int i = 0;
        long j2 = com_ushareit_listenit_bhu.f6372b;
        this.f6360f.m9700a(1);
        m8481a(j2, this.f6360f.f7639a, 1);
        long j3 = 1 + j2;
        byte b = this.f6360f.f7639a[0];
        int i2 = (b & 128) != 0 ? 1 : 0;
        int i3 = b & 127;
        if (com_ushareit_listenit_bhf.f6320a.f6306a == null) {
            com_ushareit_listenit_bhf.f6320a.f6306a = new byte[16];
        }
        m8481a(j3, com_ushareit_listenit_bhf.f6320a.f6306a, i3);
        j3 += (long) i3;
        if (i2 != 0) {
            this.f6360f.m9700a(2);
            m8481a(j3, this.f6360f.f7639a, 2);
            j3 += 2;
            i3 = this.f6360f.m9714h();
            j = j3;
        } else {
            i3 = 1;
            j = j3;
        }
        int[] iArr = com_ushareit_listenit_bhf.f6320a.f6309d;
        if (iArr == null || iArr.length < i3) {
            iArr = new int[i3];
        }
        int[] iArr2 = com_ushareit_listenit_bhf.f6320a.f6310e;
        if (iArr2 == null || iArr2.length < i3) {
            iArr2 = new int[i3];
        }
        if (i2 != 0) {
            i2 = i3 * 6;
            this.f6360f.m9700a(i2);
            m8481a(j, this.f6360f.f7639a, i2);
            j += (long) i2;
            this.f6360f.m9707c(0);
            while (i < i3) {
                iArr[i] = this.f6360f.m9714h();
                iArr2[i] = this.f6360f.m9726t();
                i++;
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = com_ushareit_listenit_bhu.f6371a - ((int) (j - com_ushareit_listenit_bhu.f6372b));
        }
        com_ushareit_listenit_bhf.f6320a.m8389a(i3, iArr, iArr2, com_ushareit_listenit_bhu.f6374d, com_ushareit_listenit_bhf.f6320a.f6306a, 1);
        i2 = (int) (j - com_ushareit_listenit_bhu.f6372b);
        com_ushareit_listenit_bhu.f6372b += (long) i2;
        com_ushareit_listenit_bhu.f6371a -= i2;
    }

    private void m8480a(long j, ByteBuffer byteBuffer, int i) {
        while (i > 0) {
            m8483b(j);
            int i2 = (int) (j - this.f6362h);
            int min = Math.min(i, this.f6356b - i2);
            bqz com_ushareit_listenit_bqz = (bqz) this.f6358d.peek();
            byteBuffer.put(com_ushareit_listenit_bqz.f7480a, com_ushareit_listenit_bqz.m9550a(i2), min);
            j += (long) min;
            i -= min;
        }
    }

    private void m8481a(long j, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            m8483b(j);
            int i3 = (int) (j - this.f6362h);
            int min = Math.min(i - i2, this.f6356b - i3);
            bqz com_ushareit_listenit_bqz = (bqz) this.f6358d.peek();
            System.arraycopy(com_ushareit_listenit_bqz.f7480a, com_ushareit_listenit_bqz.m9550a(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
        }
    }

    private void m8483b(long j) {
        int i = ((int) (j - this.f6362h)) / this.f6356b;
        for (int i2 = 0; i2 < i; i2++) {
            this.f6355a.mo1091a((bqz) this.f6358d.remove());
            this.f6362h += (long) this.f6356b;
        }
    }

    public void m8492a(bhw com_ushareit_listenit_bhw) {
        this.f6370p = com_ushareit_listenit_bhw;
    }

    public void mo975a(Format format) {
        Format a = m8479a(format, this.f6364j);
        boolean a2 = this.f6357c.m8505a(a);
        if (this.f6370p != null && a2) {
            this.f6370p.mo1027a(a);
        }
    }

    public int mo973a(bhz com_ushareit_listenit_bhz, int i, boolean z) {
        int a;
        if (m8484f()) {
            try {
                a = com_ushareit_listenit_bhz.mo961a(this.f6366l.f7480a, this.f6366l.m9550a(this.f6367m), m8478a(i));
                if (a != -1) {
                    this.f6367m += a;
                    this.f6365k += (long) a;
                    m8485g();
                    return a;
                } else if (z) {
                    return -1;
                } else {
                    throw new EOFException();
                }
            } finally {
                m8485g();
            }
        } else {
            a = com_ushareit_listenit_bhz.mo960a(i);
            if (a != -1) {
                return a;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
    }

    public void mo976a(bss com_ushareit_listenit_bss, int i) {
        if (m8484f()) {
            while (i > 0) {
                int a = m8478a(i);
                com_ushareit_listenit_bss.m9703a(this.f6366l.f7480a, this.f6366l.m9550a(this.f6367m), a);
                this.f6367m += a;
                this.f6365k += (long) a;
                i -= a;
            }
            m8485g();
            return;
        }
        com_ushareit_listenit_bss.m9709d(i);
    }

    public void mo974a(long j, int i, int i2, int i3, byte[] bArr) {
        if (m8484f()) {
            try {
                if (this.f6369o) {
                    if ((i & 1) == 0 || !this.f6357c.m8509c(j)) {
                        m8485g();
                        return;
                    }
                    this.f6369o = false;
                }
                if (this.f6368n) {
                    if ((i & 1) == 0) {
                        m8485g();
                        return;
                    }
                    this.f6368n = false;
                }
                this.f6357c.m8504a(j + this.f6364j, i, (this.f6365k - ((long) i2)) - ((long) i3), i2, bArr);
                m8485g();
            } catch (Throwable th) {
                m8485g();
            }
        } else {
            this.f6357c.m8507b(j);
        }
    }

    private boolean m8484f() {
        return this.f6361g.compareAndSet(0, 1);
    }

    private void m8485g() {
        if (!this.f6361g.compareAndSet(1, 0)) {
            m8486h();
        }
    }

    private void m8486h() {
        this.f6357c.m8503a();
        this.f6355a.mo1092a((bqz[]) this.f6358d.toArray(new bqz[this.f6358d.size()]));
        this.f6358d.clear();
        this.f6355a.mo1093b();
        this.f6362h = 0;
        this.f6365k = 0;
        this.f6366l = null;
        this.f6367m = this.f6356b;
        this.f6368n = true;
    }

    private int m8478a(int i) {
        if (this.f6367m == this.f6356b) {
            this.f6367m = 0;
            this.f6366l = this.f6355a.mo1090a();
            this.f6358d.add(this.f6366l);
        }
        return Math.min(i, this.f6356b - this.f6367m);
    }

    private static Format m8479a(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j == 0 || format.f1447u == Long.MAX_VALUE) {
            return format;
        }
        return format.m2079a(format.f1447u + j);
    }
}
