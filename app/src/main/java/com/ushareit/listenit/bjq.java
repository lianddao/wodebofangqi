package com.ushareit.listenit;

final class bjq implements bjn {
    private final bss f6638a;
    private final int f6639b = this.f6638a.m9726t();
    private final int f6640c = (this.f6638a.m9726t() & 255);
    private int f6641d;
    private int f6642e;

    public bjq(bjk com_ushareit_listenit_bjk) {
        this.f6638a = com_ushareit_listenit_bjk.aN;
        this.f6638a.m9707c(12);
    }

    public int mo997a() {
        return this.f6639b;
    }

    public int mo998b() {
        if (this.f6640c == 8) {
            return this.f6638a.m9713g();
        }
        if (this.f6640c == 16) {
            return this.f6638a.m9714h();
        }
        int i = this.f6641d;
        this.f6641d = i + 1;
        if (i % 2 != 0) {
            return this.f6642e & 15;
        }
        this.f6642e = this.f6638a.m9713g();
        return (this.f6642e & 240) >> 4;
    }

    public boolean mo999c() {
        return false;
    }
}
