package com.ushareit.listenit;

import java.util.Arrays;

class bml extends bmm {
    final /* synthetic */ bmh f7086a;
    private final bsr f7087b = new bsr(new byte[5]);
    private final bss f7088c = new bss();
    private final int f7089d;
    private int f7090e;
    private int f7091f;
    private int f7092g;

    public bml(bmh com_ushareit_listenit_bmh, int i) {
        this.f7086a = com_ushareit_listenit_bmh;
        super();
        this.f7089d = i;
    }

    public void mo1013a() {
    }

    public void mo1014a(bss com_ushareit_listenit_bss, boolean z, bia com_ushareit_listenit_bia) {
        if (z) {
            com_ushareit_listenit_bss.m9709d(com_ushareit_listenit_bss.m9713g());
            com_ushareit_listenit_bss.m9701a(this.f7087b, 3);
            this.f7087b.m9695b(12);
            this.f7090e = this.f7087b.m9697c(12);
            this.f7091f = 0;
            this.f7092g = btc.m9761a(this.f7087b.f7635a, 0, 3, -1);
            this.f7088c.m9700a(this.f7090e);
        }
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), this.f7090e - this.f7091f);
        com_ushareit_listenit_bss.m9703a(this.f7088c.f7639a, this.f7091f, min);
        this.f7091f = min + this.f7091f;
        if (this.f7091f >= this.f7090e && btc.m9761a(this.f7088c.f7639a, 0, this.f7090e, this.f7092g) == 0) {
            this.f7088c.m9709d(7);
            this.f7088c.m9701a(this.f7087b, 2);
            this.f7087b.m9695b(4);
            min = this.f7087b.m9697c(12);
            this.f7088c.m9709d(min);
            if (this.f7086a.f7057e && this.f7086a.f7067o == null) {
                this.f7086a.f7067o = this.f7086a.f7062j.mo1012a(21, new blp(21, null, new byte[0]));
                this.f7086a.f7067o.mo1009a(com_ushareit_listenit_bia, new blr(21, 8192));
            }
            int i = ((this.f7090e - 9) - min) - 4;
            while (i > 0) {
                this.f7088c.m9701a(this.f7087b, 5);
                min = this.f7087b.m9697c(8);
                this.f7087b.m9695b(3);
                int c = this.f7087b.m9697c(13);
                this.f7087b.m9695b(4);
                int c2 = this.f7087b.m9697c(12);
                blp a = m9060a(this.f7088c, c2);
                if (min == 6) {
                    min = a.f6907a;
                }
                c2 = i - (c2 + 5);
                if (this.f7086a.f7057e) {
                    i = min;
                } else {
                    i = c;
                }
                if (this.f7086a.f7064l.get(i)) {
                    i = c2;
                } else {
                    blo c3;
                    this.f7086a.f7064l.put(i, true);
                    if (this.f7086a.f7057e && min == 21) {
                        c3 = this.f7086a.f7067o;
                    } else {
                        c3 = this.f7086a.f7062j.mo1012a(min, a);
                        c3.mo1009a(com_ushareit_listenit_bia, new blr(i, 8192));
                    }
                    if (c3 != null) {
                        this.f7086a.f7063k.put(c, new bmk(c3, this.f7086a.f7058f));
                    }
                    i = c2;
                }
            }
            if (!this.f7086a.f7057e) {
                this.f7086a.f7063k.remove(0);
                this.f7086a.f7063k.remove(this.f7089d);
                com_ushareit_listenit_bia.mo1026a();
            } else if (!this.f7086a.f7066n) {
                com_ushareit_listenit_bia.mo1026a();
            }
            this.f7086a.f7066n = true;
        }
    }

    private blp m9060a(bss com_ushareit_listenit_bss, int i) {
        int d = com_ushareit_listenit_bss.m9708d();
        int i2 = d + i;
        int i3 = -1;
        String str = null;
        while (com_ushareit_listenit_bss.m9708d() < i2) {
            int g = com_ushareit_listenit_bss.m9713g();
            int g2 = com_ushareit_listenit_bss.m9713g() + com_ushareit_listenit_bss.m9708d();
            if (g == 5) {
                long l = com_ushareit_listenit_bss.m9718l();
                if (l == bmh.f7054b) {
                    i3 = 129;
                } else if (l == bmh.f7055c) {
                    i3 = 135;
                } else if (l == bmh.f7056d) {
                    i3 = 36;
                }
            } else if (g == 106) {
                i3 = 129;
            } else if (g == 122) {
                i3 = 135;
            } else if (g == 123) {
                i3 = 138;
            } else if (g == 10) {
                str = new String(com_ushareit_listenit_bss.f7639a, com_ushareit_listenit_bss.m9708d(), 3).trim();
            }
            com_ushareit_listenit_bss.m9709d(g2 - com_ushareit_listenit_bss.m9708d());
        }
        com_ushareit_listenit_bss.m9707c(i2);
        return new blp(i3, str, Arrays.copyOfRange(this.f7088c.f7639a, d, i2));
    }
}
