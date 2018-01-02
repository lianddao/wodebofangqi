package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.List;

final class bkz extends bku {
    private bla f6821a;
    private int f6822b;
    private boolean f6823c;
    private blf f6824d;
    private bld f6825e;

    bkz() {
    }

    public static boolean m8888a(bss com_ushareit_listenit_bss) {
        try {
            return blb.m8898a(1, com_ushareit_listenit_bss, true);
        } catch (bfw e) {
            return false;
        }
    }

    protected void mo1003a(boolean z) {
        super.mo1003a(z);
        if (z) {
            this.f6821a = null;
            this.f6824d = null;
            this.f6825e = null;
        }
        this.f6822b = 0;
        this.f6823c = false;
    }

    protected void mo1006d(long j) {
        boolean z;
        int i = 0;
        super.mo1006d(j);
        if (j != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f6823c = z;
        if (this.f6824d != null) {
            i = this.f6824d.f6851g;
        }
        this.f6822b = i;
    }

    protected long mo1005b(bss com_ushareit_listenit_bss) {
        int i = 0;
        if ((com_ushareit_listenit_bss.f7639a[0] & 1) == 1) {
            return -1;
        }
        int a = m8886a(com_ushareit_listenit_bss.f7639a[0], this.f6821a);
        if (this.f6823c) {
            i = (this.f6822b + a) / 4;
        }
        m8887a(com_ushareit_listenit_bss, (long) i);
        this.f6823c = true;
        this.f6822b = a;
        return (long) i;
    }

    protected boolean mo1004a(bss com_ushareit_listenit_bss, long j, bkw com_ushareit_listenit_bkw) {
        if (this.f6821a != null) {
            return false;
        }
        this.f6821a = m8892c(com_ushareit_listenit_bss);
        if (this.f6821a == null) {
            return true;
        }
        List arrayList = new ArrayList();
        arrayList.add(this.f6821a.f6828a.f6854j);
        arrayList.add(this.f6821a.f6830c);
        com_ushareit_listenit_bkw.f6815a = Format.m2068a(null, "audio/vorbis", null, this.f6821a.f6828a.f6849e, 65025, this.f6821a.f6828a.f6846b, (int) this.f6821a.f6828a.f6847c, arrayList, null, 0, null);
        return true;
    }

    bla m8892c(bss com_ushareit_listenit_bss) {
        if (this.f6824d == null) {
            this.f6824d = blb.m8896a(com_ushareit_listenit_bss);
            return null;
        } else if (this.f6825e == null) {
            this.f6825e = blb.m8901b(com_ushareit_listenit_bss);
            return null;
        } else {
            Object obj = new byte[com_ushareit_listenit_bss.m9706c()];
            System.arraycopy(com_ushareit_listenit_bss.f7639a, 0, obj, 0, com_ushareit_listenit_bss.m9706c());
            ble[] a = blb.m8900a(com_ushareit_listenit_bss, this.f6824d.f6846b);
            return new bla(this.f6824d, this.f6825e, obj, a, blb.m8894a(a.length - 1));
        }
    }

    static int m8885a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    static void m8887a(bss com_ushareit_listenit_bss, long j) {
        com_ushareit_listenit_bss.m9705b(com_ushareit_listenit_bss.m9706c() + 4);
        com_ushareit_listenit_bss.f7639a[com_ushareit_listenit_bss.m9706c() - 4] = (byte) ((int) (j & 255));
        com_ushareit_listenit_bss.f7639a[com_ushareit_listenit_bss.m9706c() - 3] = (byte) ((int) ((j >>> 8) & 255));
        com_ushareit_listenit_bss.f7639a[com_ushareit_listenit_bss.m9706c() - 2] = (byte) ((int) ((j >>> 16) & 255));
        com_ushareit_listenit_bss.f7639a[com_ushareit_listenit_bss.m9706c() - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    private static int m8886a(byte b, bla com_ushareit_listenit_bla) {
        if (com_ushareit_listenit_bla.f6831d[m8885a(b, com_ushareit_listenit_bla.f6832e, 1)].f6841a) {
            return com_ushareit_listenit_bla.f6828a.f6852h;
        }
        return com_ushareit_listenit_bla.f6828a.f6851g;
    }
}
