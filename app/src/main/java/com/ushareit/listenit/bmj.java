package com.ushareit.listenit;

class bmj extends bmm {
    final /* synthetic */ bmh f7068a;
    private final bss f7069b = new bss();
    private final bsr f7070c = new bsr(new byte[4]);
    private int f7071d;
    private int f7072e;
    private int f7073f;

    public bmj(bmh com_ushareit_listenit_bmh) {
        this.f7068a = com_ushareit_listenit_bmh;
        super();
    }

    public void mo1013a() {
    }

    public void mo1014a(bss com_ushareit_listenit_bss, boolean z, bia com_ushareit_listenit_bia) {
        int i = 0;
        if (z) {
            com_ushareit_listenit_bss.m9709d(com_ushareit_listenit_bss.m9713g());
            com_ushareit_listenit_bss.m9701a(this.f7070c, 3);
            this.f7070c.m9695b(12);
            this.f7071d = this.f7070c.m9697c(12);
            this.f7072e = 0;
            this.f7073f = btc.m9761a(this.f7070c.f7635a, 0, 3, -1);
            this.f7069b.m9700a(this.f7071d);
        }
        int min = Math.min(com_ushareit_listenit_bss.m9704b(), this.f7071d - this.f7072e);
        com_ushareit_listenit_bss.m9703a(this.f7069b.f7639a, this.f7072e, min);
        this.f7072e = min + this.f7072e;
        if (this.f7072e >= this.f7071d && btc.m9761a(this.f7069b.f7639a, 0, this.f7071d, this.f7073f) == 0) {
            this.f7069b.m9709d(5);
            min = (this.f7071d - 9) / 4;
            while (i < min) {
                this.f7069b.m9701a(this.f7070c, 4);
                int c = this.f7070c.m9697c(16);
                this.f7070c.m9695b(3);
                if (c == 0) {
                    this.f7070c.m9695b(13);
                } else {
                    c = this.f7070c.m9697c(13);
                    this.f7068a.f7063k.put(c, new bml(this.f7068a, c));
                }
                i++;
            }
        }
    }
}
