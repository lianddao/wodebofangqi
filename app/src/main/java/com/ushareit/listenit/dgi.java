package com.ushareit.listenit;

public abstract class dgi {
    protected volatile int f9405g = -1;

    public static final void m13468a(dgi com_ushareit_listenit_dgi, byte[] bArr, int i, int i2) {
        try {
            dga a = dga.m14160a(bArr, i, i2);
            com_ushareit_listenit_dgi.mo1666a(a);
            a.m14204b();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] m13469a(dgi com_ushareit_listenit_dgi) {
        byte[] bArr = new byte[com_ushareit_listenit_dgi.m13475g()];
        m13468a(com_ushareit_listenit_dgi, bArr, 0, bArr.length);
        return bArr;
    }

    public void mo1666a(dga com_ushareit_listenit_dga) {
    }

    protected int mo1667b() {
        return 0;
    }

    public abstract dgi mo1670b(dfz com_ushareit_listenit_dfz);

    public /* synthetic */ Object clone() {
        return mo1669e();
    }

    public dgi mo1669e() {
        return (dgi) super.clone();
    }

    public int m13474f() {
        if (this.f9405g < 0) {
            m13475g();
        }
        return this.f9405g;
    }

    public int m13475g() {
        int b = mo1667b();
        this.f9405g = b;
        return b;
    }

    public String toString() {
        return dgj.m14253a(this);
    }
}
