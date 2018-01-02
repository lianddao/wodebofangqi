package com.ushareit.listenit;

final class bmf {
    private final blo f7044a;
    private final bih f7045b;
    private final bsr f7046c = new bsr(new byte[64]);
    private boolean f7047d;
    private boolean f7048e;
    private boolean f7049f;
    private int f7050g;
    private long f7051h;

    public bmf(blo com_ushareit_listenit_blo, bih com_ushareit_listenit_bih) {
        this.f7044a = com_ushareit_listenit_blo;
        this.f7045b = com_ushareit_listenit_bih;
    }

    public void m9028a() {
        this.f7049f = false;
        this.f7044a.mo1007a();
    }

    public void m9029a(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9703a(this.f7046c.f7635a, 0, 3);
        this.f7046c.m9694a(0);
        m9026b();
        com_ushareit_listenit_bss.m9703a(this.f7046c.f7635a, 0, this.f7050g);
        this.f7046c.m9694a(0);
        m9027c();
        this.f7044a.mo1008a(this.f7051h, true);
        this.f7044a.mo1010a(com_ushareit_listenit_bss);
        this.f7044a.mo1011b();
    }

    private void m9026b() {
        this.f7046c.m9695b(8);
        this.f7047d = this.f7046c.m9696b();
        this.f7048e = this.f7046c.m9696b();
        this.f7046c.m9695b(6);
        this.f7050g = this.f7046c.m9697c(8);
    }

    private void m9027c() {
        this.f7051h = 0;
        if (this.f7047d) {
            this.f7046c.m9695b(4);
            long c = ((long) this.f7046c.m9697c(3)) << 30;
            this.f7046c.m9695b(1);
            c |= (long) (this.f7046c.m9697c(15) << 15);
            this.f7046c.m9695b(1);
            c |= (long) this.f7046c.m9697c(15);
            this.f7046c.m9695b(1);
            if (!this.f7049f && this.f7048e) {
                this.f7046c.m9695b(4);
                long c2 = ((long) this.f7046c.m9697c(3)) << 30;
                this.f7046c.m9695b(1);
                c2 |= (long) (this.f7046c.m9697c(15) << 15);
                this.f7046c.m9695b(1);
                c2 |= (long) this.f7046c.m9697c(15);
                this.f7046c.m9695b(1);
                this.f7045b.m8563a(c2);
                this.f7049f = true;
            }
            this.f7051h = this.f7045b.m8563a(c);
        }
    }
}
