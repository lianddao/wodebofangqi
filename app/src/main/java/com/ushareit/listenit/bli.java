package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

final class bli extends blo {
    private final bsr f6861a;
    private final bss f6862b;
    private final String f6863c;
    private bii f6864d;
    private int f6865e;
    private int f6866f;
    private boolean f6867g;
    private long f6868h;
    private Format f6869i;
    private int f6870j;
    private boolean f6871k;
    private long f6872l;

    public bli() {
        this(null);
    }

    public bli(String str) {
        this.f6861a = new bsr(new byte[8]);
        this.f6862b = new bss(this.f6861a.f7635a);
        this.f6865e = 0;
        this.f6863c = str;
    }

    public void mo1007a() {
        this.f6865e = 0;
        this.f6866f = 0;
        this.f6867g = false;
    }

    public void mo1009a(bia com_ushareit_listenit_bia, blr com_ushareit_listenit_blr) {
        this.f6864d = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
    }

    public void mo1008a(long j, boolean z) {
        this.f6872l = j;
    }

    public void mo1010a(bss com_ushareit_listenit_bss) {
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            switch (this.f6865e) {
                case 0:
                    if (!m8917b(com_ushareit_listenit_bss)) {
                        break;
                    }
                    this.f6865e = 1;
                    this.f6862b.f7639a[0] = (byte) 11;
                    this.f6862b.f7639a[1] = (byte) 119;
                    this.f6866f = 2;
                    break;
                case 1:
                    if (!m8916a(com_ushareit_listenit_bss, this.f6862b.f7639a, 8)) {
                        break;
                    }
                    m8918c();
                    this.f6862b.m9707c(0);
                    this.f6864d.mo976a(this.f6862b, 8);
                    this.f6865e = 2;
                    break;
                case 2:
                    int min = Math.min(com_ushareit_listenit_bss.m9704b(), this.f6870j - this.f6866f);
                    this.f6864d.mo976a(com_ushareit_listenit_bss, min);
                    this.f6866f = min + this.f6866f;
                    if (this.f6866f != this.f6870j) {
                        break;
                    }
                    this.f6864d.mo974a(this.f6872l, 1, this.f6870j, 0, null);
                    this.f6872l += this.f6868h;
                    this.f6865e = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void mo1011b() {
    }

    private boolean m8916a(bss com_ushareit_listenit_bss, byte[] bArr, int i) {
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), i - this.f6866f);
        com_ushareit_listenit_bss.m9703a(bArr, this.f6866f, min);
        this.f6866f = min + this.f6866f;
        return this.f6866f == i;
    }

    private boolean m8917b(bss com_ushareit_listenit_bss) {
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            if (this.f6867g) {
                int g = com_ushareit_listenit_bss.m9713g();
                if (g == 119) {
                    this.f6867g = false;
                    return true;
                }
                this.f6867g = g == 11;
            } else {
                this.f6867g = com_ushareit_listenit_bss.m9713g() == 11;
            }
        }
        return false;
    }

    private void m8918c() {
        int b;
        if (this.f6869i == null) {
            Format b2;
            this.f6861a.m9695b(40);
            this.f6871k = this.f6861a.m9697c(5) == 16;
            this.f6861a.m9694a(this.f6861a.m9693a() - 45);
            if (this.f6871k) {
                b2 = bgg.m8233b(this.f6861a, null, this.f6863c, null);
            } else {
                b2 = bgg.m8230a(this.f6861a, null, this.f6863c, null);
            }
            this.f6869i = b2;
            this.f6864d.mo975a(this.f6869i);
        }
        if (this.f6871k) {
            b = bgg.m8232b(this.f6861a.f7635a);
        } else {
            b = bgg.m8229a(this.f6861a.f7635a);
        }
        this.f6870j = b;
        if (this.f6871k) {
            b = bgg.m8235c(this.f6861a.f7635a);
        } else {
            b = bgg.m8226a();
        }
        this.f6868h = (long) ((int) ((((long) b) * 1000000) / ((long) this.f6869i.f1443q)));
    }
}
