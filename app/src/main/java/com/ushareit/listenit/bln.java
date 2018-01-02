package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

final class bln extends blo {
    private final bss f6897a = new bss(new byte[15]);
    private final String f6898b;
    private bii f6899c;
    private int f6900d;
    private int f6901e;
    private int f6902f;
    private long f6903g;
    private Format f6904h;
    private int f6905i;
    private long f6906j;

    public bln(String str) {
        this.f6897a.f7639a[0] = Byte.MAX_VALUE;
        this.f6897a.f7639a[1] = (byte) -2;
        this.f6897a.f7639a[2] = Byte.MIN_VALUE;
        this.f6897a.f7639a[3] = (byte) 1;
        this.f6900d = 0;
        this.f6898b = str;
    }

    public void mo1007a() {
        this.f6900d = 0;
        this.f6901e = 0;
        this.f6902f = 0;
    }

    public void mo1009a(bia com_ushareit_listenit_bia, blr com_ushareit_listenit_blr) {
        this.f6899c = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
    }

    public void mo1008a(long j, boolean z) {
        this.f6906j = j;
    }

    public void mo1010a(bss com_ushareit_listenit_bss) {
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            switch (this.f6900d) {
                case 0:
                    if (!m8947b(com_ushareit_listenit_bss)) {
                        break;
                    }
                    this.f6901e = 4;
                    this.f6900d = 1;
                    break;
                case 1:
                    if (!m8946a(com_ushareit_listenit_bss, this.f6897a.f7639a, 15)) {
                        break;
                    }
                    m8948c();
                    this.f6897a.m9707c(0);
                    this.f6899c.mo976a(this.f6897a, 15);
                    this.f6900d = 2;
                    break;
                case 2:
                    int min = Math.min(com_ushareit_listenit_bss.m9704b(), this.f6905i - this.f6901e);
                    this.f6899c.mo976a(com_ushareit_listenit_bss, min);
                    this.f6901e = min + this.f6901e;
                    if (this.f6901e != this.f6905i) {
                        break;
                    }
                    this.f6899c.mo974a(this.f6906j, 1, this.f6905i, 0, null);
                    this.f6906j += this.f6903g;
                    this.f6900d = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void mo1011b() {
    }

    private boolean m8946a(bss com_ushareit_listenit_bss, byte[] bArr, int i) {
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), i - this.f6901e);
        com_ushareit_listenit_bss.m9703a(bArr, this.f6901e, min);
        this.f6901e = min + this.f6901e;
        return this.f6901e == i;
    }

    private boolean m8947b(bss com_ushareit_listenit_bss) {
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            this.f6902f <<= 8;
            this.f6902f |= com_ushareit_listenit_bss.m9713g();
            if (this.f6902f == 2147385345) {
                this.f6902f = 0;
                return true;
            }
        }
        return false;
    }

    private void m8948c() {
        byte[] bArr = this.f6897a.f7639a;
        if (this.f6904h == null) {
            this.f6904h = bgz.m8302a(bArr, null, this.f6898b, null);
            this.f6899c.mo975a(this.f6904h);
        }
        this.f6905i = bgz.m8303b(bArr);
        this.f6903g = (long) ((int) ((((long) bgz.m8301a(bArr)) * 1000000) / ((long) this.f6904h.f1443q)));
    }
}
