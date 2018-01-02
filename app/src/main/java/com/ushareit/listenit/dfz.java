package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class dfz {
    private final byte[] f9746a;
    private int f9747b;
    private int f9748c;
    private int f9749d;
    private int f9750e;
    private int f9751f;
    private int f9752g = MoPubClientPositioning.NO_REPEAT;
    private int f9753h;
    private int f9754i = 64;
    private int f9755j = 67108864;

    private dfz(byte[] bArr, int i, int i2) {
        this.f9746a = bArr;
        this.f9747b = i;
        this.f9748c = i + i2;
        this.f9750e = i;
    }

    public static dfz m14123a(byte[] bArr) {
        return m14124a(bArr, 0, bArr.length);
    }

    public static dfz m14124a(byte[] bArr, int i, int i2) {
        return new dfz(bArr, i, i2);
    }

    private void m14125t() {
        this.f9748c += this.f9749d;
        int i = this.f9748c;
        if (i > this.f9752g) {
            this.f9749d = i - this.f9752g;
            this.f9748c -= this.f9749d;
            return;
        }
        this.f9749d = 0;
    }

    public int m14126a() {
        if (m14150q()) {
            this.f9751f = 0;
            return 0;
        }
        this.f9751f = m14145l();
        if (this.f9751f != 0) {
            return this.f9751f;
        }
        throw dgh.m14249d();
    }

    public void m14127a(int i) {
        if (this.f9751f != i) {
            throw dgh.m14250e();
        }
    }

    public void m14128a(dgi com_ushareit_listenit_dgi) {
        int l = m14145l();
        if (this.f9753h >= this.f9754i) {
            throw dgh.m14252g();
        }
        l = m14133c(l);
        this.f9753h++;
        com_ushareit_listenit_dgi.mo1670b(this);
        m14127a(0);
        this.f9753h--;
        m14135d(l);
    }

    public byte[] m14129a(int i, int i2) {
        if (i2 == 0) {
            return dgl.f9786h;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f9746a, this.f9747b + i, obj, 0, i2);
        return obj;
    }

    public void m14130b() {
        int a;
        do {
            a = m14126a();
            if (a == 0) {
                return;
            }
        } while (m14131b(a));
    }

    public boolean m14131b(int i) {
        switch (dgl.m14261a(i)) {
            case 0:
                m14140g();
                return true;
            case 1:
                m14148o();
                return true;
            case 2:
                m14139f(m14145l());
                return true;
            case 3:
                m14130b();
                m14127a(dgl.m14262a(dgl.m14264b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m14147n();
                return true;
            default:
                throw dgh.m14251f();
        }
    }

    public double m14132c() {
        return Double.longBitsToDouble(m14148o());
    }

    public int m14133c(int i) {
        if (i < 0) {
            throw dgh.m14247b();
        }
        int i2 = this.f9750e + i;
        int i3 = this.f9752g;
        if (i2 > i3) {
            throw dgh.m14246a();
        }
        this.f9752g = i2;
        m14125t();
        return i3;
    }

    public float m14134d() {
        return Float.intBitsToFloat(m14147n());
    }

    public void m14135d(int i) {
        this.f9752g = i;
        m14125t();
    }

    public long m14136e() {
        return m14146m();
    }

    public void m14137e(int i) {
        if (i > this.f9750e - this.f9747b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f9750e - this.f9747b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f9750e = this.f9747b + i;
        }
    }

    public long m14138f() {
        return m14146m();
    }

    public void m14139f(int i) {
        if (i < 0) {
            throw dgh.m14247b();
        } else if (this.f9750e + i > this.f9752g) {
            m14139f(this.f9752g - this.f9750e);
            throw dgh.m14246a();
        } else if (i <= this.f9748c - this.f9750e) {
            this.f9750e += i;
        } else {
            throw dgh.m14246a();
        }
    }

    public int m14140g() {
        return m14145l();
    }

    public long m14141h() {
        return m14148o();
    }

    public boolean m14142i() {
        return m14145l() != 0;
    }

    public String m14143j() {
        int l = m14145l();
        if (l < 0) {
            throw dgh.m14247b();
        } else if (l > this.f9748c - this.f9750e) {
            throw dgh.m14246a();
        } else {
            String str = new String(this.f9746a, this.f9750e, l, dgg.f9774a);
            this.f9750e = l + this.f9750e;
            return str;
        }
    }

    public byte[] m14144k() {
        int l = m14145l();
        if (l < 0) {
            throw dgh.m14247b();
        } else if (l == 0) {
            return dgl.f9786h;
        } else {
            if (l > this.f9748c - this.f9750e) {
                throw dgh.m14246a();
            }
            Object obj = new byte[l];
            System.arraycopy(this.f9746a, this.f9750e, obj, 0, l);
            this.f9750e = l + this.f9750e;
            return obj;
        }
    }

    public int m14145l() {
        byte s = m14152s();
        if (s >= (byte) 0) {
            return s;
        }
        int i = s & 127;
        byte s2 = m14152s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 7);
        }
        i |= (s2 & 127) << 7;
        s2 = m14152s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 14);
        }
        i |= (s2 & 127) << 14;
        s2 = m14152s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 21);
        }
        i |= (s2 & 127) << 21;
        s2 = m14152s();
        i |= s2 << 28;
        if (s2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m14152s() >= (byte) 0) {
                return i;
            }
        }
        throw dgh.m14248c();
    }

    public long m14146m() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte s = m14152s();
            j |= ((long) (s & 127)) << i;
            if ((s & 128) == 0) {
                return j;
            }
        }
        throw dgh.m14248c();
    }

    public int m14147n() {
        return (((m14152s() & 255) | ((m14152s() & 255) << 8)) | ((m14152s() & 255) << 16)) | ((m14152s() & 255) << 24);
    }

    public long m14148o() {
        byte s = m14152s();
        byte s2 = m14152s();
        return ((((((((((long) s2) & 255) << 8) | (((long) s) & 255)) | ((((long) m14152s()) & 255) << 16)) | ((((long) m14152s()) & 255) << 24)) | ((((long) m14152s()) & 255) << 32)) | ((((long) m14152s()) & 255) << 40)) | ((((long) m14152s()) & 255) << 48)) | ((((long) m14152s()) & 255) << 56);
    }

    public int m14149p() {
        if (this.f9752g == MoPubClientPositioning.NO_REPEAT) {
            return -1;
        }
        return this.f9752g - this.f9750e;
    }

    public boolean m14150q() {
        return this.f9750e == this.f9748c;
    }

    public int m14151r() {
        return this.f9750e - this.f9747b;
    }

    public byte m14152s() {
        if (this.f9750e == this.f9748c) {
            throw dgh.m14246a();
        }
        byte[] bArr = this.f9746a;
        int i = this.f9750e;
        this.f9750e = i + 1;
        return bArr[i];
    }
}
