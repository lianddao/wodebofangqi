package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

final class bip extends bin {
    private final bss f6434b = new bss(bso.f7618a);
    private final bss f6435c = new bss(4);
    private int f6436d;
    private boolean f6437e;
    private int f6438f;

    public bip(bii com_ushareit_listenit_bii) {
        super(com_ushareit_listenit_bii);
    }

    protected boolean mo978a(bss com_ushareit_listenit_bss) {
        int g = com_ushareit_listenit_bss.m9713g();
        int i = (g >> 4) & 15;
        g &= 15;
        if (g != 7) {
            throw new bio("Video format not supported: " + g);
        }
        this.f6438f = i;
        return i != 5;
    }

    protected void mo977a(bss com_ushareit_listenit_bss, long j) {
        int g = com_ushareit_listenit_bss.m9713g();
        long k = (((long) com_ushareit_listenit_bss.m9717k()) * 1000) + j;
        if (g == 0 && !this.f6437e) {
            bss com_ushareit_listenit_bss2 = new bss(new byte[com_ushareit_listenit_bss.m9704b()]);
            com_ushareit_listenit_bss.m9703a(com_ushareit_listenit_bss2.f7639a, 0, com_ushareit_listenit_bss.m9704b());
            btf a = btf.m9785a(com_ushareit_listenit_bss2);
            this.f6436d = a.f7673b;
            this.a.mo975a(Format.m2064a(null, "video/avc", null, -1, -1, a.f7674c, a.f7675d, -1.0f, a.f7672a, -1, a.f7676e, null));
            this.f6437e = true;
        } else if (g == 1) {
            byte[] bArr = this.f6435c.f7639a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            g = 4 - this.f6436d;
            int i = 0;
            while (com_ushareit_listenit_bss.m9704b() > 0) {
                com_ushareit_listenit_bss.m9703a(this.f6435c.f7639a, g, this.f6436d);
                this.f6435c.m9707c(0);
                int t = this.f6435c.m9726t();
                this.f6434b.m9707c(0);
                this.a.mo976a(this.f6434b, 4);
                int i2 = i + 4;
                this.a.mo976a(com_ushareit_listenit_bss, t);
                i = i2 + t;
            }
            this.a.mo974a(k, this.f6438f == 1 ? 1 : 0, i, 0, null);
        }
    }
}
