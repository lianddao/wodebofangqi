package com.ushareit.listenit;

class bkk implements bif {
    final /* synthetic */ bki f6770a;

    private bkk(bki com_ushareit_listenit_bki) {
        this.f6770a = com_ushareit_listenit_bki;
    }

    public boolean mo957a() {
        return true;
    }

    public long mo959b(long j) {
        if (j == 0) {
            this.f6770a.f6763g = 0;
            return this.f6770a.f6758b;
        }
        this.f6770a.f6763g = this.f6770a.f6760d.m8844c(j);
        return this.f6770a.m8816a(this.f6770a.f6758b, this.f6770a.f6763g, 30000);
    }

    public long mo958b() {
        return this.f6770a.f6760d.m8842b(this.f6770a.f6762f);
    }
}
