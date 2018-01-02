package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

final class bma extends blo {
    private final bss f7014a = new bss(10);
    private bii f7015b;
    private boolean f7016c;
    private long f7017d;
    private int f7018e;
    private int f7019f;

    public void mo1007a() {
        this.f7016c = false;
    }

    public void mo1009a(bia com_ushareit_listenit_bia, blr com_ushareit_listenit_blr) {
        this.f7015b = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
        this.f7015b.mo975a(Format.m2071a(null, "application/id3", null, -1, null));
    }

    public void mo1008a(long j, boolean z) {
        if (z) {
            this.f7016c = true;
            this.f7017d = j;
            this.f7018e = 0;
            this.f7019f = 0;
        }
    }

    public void mo1010a(bss com_ushareit_listenit_bss) {
        if (this.f7016c) {
            int b = com_ushareit_listenit_bss.m9704b();
            if (this.f7019f < 10) {
                int min = Math.min(b, 10 - this.f7019f);
                System.arraycopy(com_ushareit_listenit_bss.f7639a, com_ushareit_listenit_bss.m9708d(), this.f7014a.f7639a, this.f7019f, min);
                if (min + this.f7019f == 10) {
                    this.f7014a.m9707c(6);
                    this.f7018e = this.f7014a.m9725s() + 10;
                }
            }
            b = Math.min(b, this.f7018e - this.f7019f);
            this.f7015b.mo976a(com_ushareit_listenit_bss, b);
            this.f7019f = b + this.f7019f;
        }
    }

    public void mo1011b() {
        if (this.f7016c && this.f7018e != 0 && this.f7019f == this.f7018e) {
            this.f7015b.mo974a(this.f7017d, 1, this.f7018e, 0, null);
            this.f7016c = false;
        }
    }
}
