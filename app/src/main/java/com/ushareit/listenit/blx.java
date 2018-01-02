package com.ushareit.listenit;

final class blx {
    private boolean f6961a;
    private boolean f6962b;
    private bsq f6963c;
    private int f6964d;
    private int f6965e;
    private int f6966f;
    private int f6967g;
    private boolean f6968h;
    private boolean f6969i;
    private boolean f6970j;
    private boolean f6971k;
    private int f6972l;
    private int f6973m;
    private int f6974n;
    private int f6975o;
    private int f6976p;

    private blx() {
    }

    public void m8982a() {
        this.f6962b = false;
        this.f6961a = false;
    }

    public void m8983a(int i) {
        this.f6965e = i;
        this.f6962b = true;
    }

    public void m8984a(bsq com_ushareit_listenit_bsq, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
        this.f6963c = com_ushareit_listenit_bsq;
        this.f6964d = i;
        this.f6965e = i2;
        this.f6966f = i3;
        this.f6967g = i4;
        this.f6968h = z;
        this.f6969i = z2;
        this.f6970j = z3;
        this.f6971k = z4;
        this.f6972l = i5;
        this.f6973m = i6;
        this.f6974n = i7;
        this.f6975o = i8;
        this.f6976p = i9;
        this.f6961a = true;
        this.f6962b = true;
    }

    public boolean m8985b() {
        return this.f6962b && (this.f6965e == 7 || this.f6965e == 2);
    }

    private boolean m8980a(blx com_ushareit_listenit_blx) {
        if (this.f6961a) {
            if (!com_ushareit_listenit_blx.f6961a || this.f6966f != com_ushareit_listenit_blx.f6966f || this.f6967g != com_ushareit_listenit_blx.f6967g || this.f6968h != com_ushareit_listenit_blx.f6968h) {
                return true;
            }
            if (this.f6969i && com_ushareit_listenit_blx.f6969i && this.f6970j != com_ushareit_listenit_blx.f6970j) {
                return true;
            }
            if (this.f6964d != com_ushareit_listenit_blx.f6964d && (this.f6964d == 0 || com_ushareit_listenit_blx.f6964d == 0)) {
                return true;
            }
            if (this.f6963c.f7632h == 0 && com_ushareit_listenit_blx.f6963c.f7632h == 0 && (this.f6973m != com_ushareit_listenit_blx.f6973m || this.f6974n != com_ushareit_listenit_blx.f6974n)) {
                return true;
            }
            if ((this.f6963c.f7632h == 1 && com_ushareit_listenit_blx.f6963c.f7632h == 1 && (this.f6975o != com_ushareit_listenit_blx.f6975o || this.f6976p != com_ushareit_listenit_blx.f6976p)) || this.f6971k != com_ushareit_listenit_blx.f6971k) {
                return true;
            }
            if (this.f6971k && com_ushareit_listenit_blx.f6971k && this.f6972l != com_ushareit_listenit_blx.f6972l) {
                return true;
            }
        }
        return false;
    }
}
