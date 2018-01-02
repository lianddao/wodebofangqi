package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

final class bmb extends blo {
    private final bss f7020a;
    private final bid f7021b;
    private final String f7022c;
    private bii f7023d;
    private int f7024e;
    private int f7025f;
    private boolean f7026g;
    private boolean f7027h;
    private long f7028i;
    private int f7029j;
    private long f7030k;

    public bmb() {
        this(null);
    }

    public bmb(String str) {
        this.f7024e = 0;
        this.f7020a = new bss(4);
        this.f7020a.f7639a[0] = (byte) -1;
        this.f7021b = new bid();
        this.f7022c = str;
    }

    public void mo1007a() {
        this.f7024e = 0;
        this.f7025f = 0;
        this.f7027h = false;
    }

    public void mo1009a(bia com_ushareit_listenit_bia, blr com_ushareit_listenit_blr) {
        this.f7023d = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
    }

    public void mo1008a(long j, boolean z) {
        this.f7030k = j;
    }

    public void mo1010a(bss com_ushareit_listenit_bss) {
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            switch (this.f7024e) {
                case 0:
                    m9007b(com_ushareit_listenit_bss);
                    break;
                case 1:
                    m9008c(com_ushareit_listenit_bss);
                    break;
                case 2:
                    m9009d(com_ushareit_listenit_bss);
                    break;
                default:
                    break;
            }
        }
    }

    public void mo1011b() {
    }

    private void m9007b(bss com_ushareit_listenit_bss) {
        byte[] bArr = com_ushareit_listenit_bss.f7639a;
        int d = com_ushareit_listenit_bss.m9708d();
        int c = com_ushareit_listenit_bss.m9706c();
        int i = d;
        while (i < c) {
            boolean z = (bArr[i] & 255) == 255;
            if (this.f7027h && (bArr[i] & 224) == 224) {
                int i2 = 1;
            } else {
                boolean z2 = false;
            }
            this.f7027h = z;
            if (i2 != 0) {
                com_ushareit_listenit_bss.m9707c(i + 1);
                this.f7027h = false;
                this.f7020a.f7639a[1] = bArr[i];
                this.f7025f = 2;
                this.f7024e = 1;
                return;
            }
            i++;
        }
        com_ushareit_listenit_bss.m9707c(c);
    }

    private void m9008c(bss com_ushareit_listenit_bss) {
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), 4 - this.f7025f);
        com_ushareit_listenit_bss.m9703a(this.f7020a.f7639a, this.f7025f, min);
        this.f7025f = min + this.f7025f;
        if (this.f7025f >= 4) {
            this.f7020a.m9707c(0);
            if (bid.m8557a(this.f7020a.m9720n(), this.f7021b)) {
                this.f7029j = this.f7021b.f6404c;
                if (!this.f7026g) {
                    this.f7028i = (1000000 * ((long) this.f7021b.f6408g)) / ((long) this.f7021b.f6405d);
                    this.f7023d.mo975a(Format.m2068a(null, this.f7021b.f6403b, null, -1, 4096, this.f7021b.f6406e, this.f7021b.f6405d, null, null, 0, this.f7022c));
                    this.f7026g = true;
                }
                this.f7020a.m9707c(0);
                this.f7023d.mo976a(this.f7020a, 4);
                this.f7024e = 2;
                return;
            }
            this.f7025f = 0;
            this.f7024e = 1;
        }
    }

    private void m9009d(bss com_ushareit_listenit_bss) {
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), this.f7029j - this.f7025f);
        this.f7023d.mo976a(com_ushareit_listenit_bss, min);
        this.f7025f = min + this.f7025f;
        if (this.f7025f >= this.f7029j) {
            this.f7023d.mo974a(this.f7030k, 1, this.f7029j, 0, null);
            this.f7030k += this.f7028i;
            this.f7025f = 0;
            this.f7024e = 0;
        }
    }
}
