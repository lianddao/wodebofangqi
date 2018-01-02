package com.ushareit.listenit;

import android.text.Layout.Alignment;

final class bpj {
    private String f7307a;
    private int f7308b;
    private boolean f7309c;
    private int f7310d;
    private boolean f7311e;
    private int f7312f = -1;
    private int f7313g = -1;
    private int f7314h = -1;
    private int f7315i = -1;
    private int f7316j = -1;
    private float f7317k;
    private String f7318l;
    private bpj f7319m;
    private Alignment f7320n;

    public int m9365a() {
        int i = 0;
        if (this.f7314h == -1 && this.f7315i == -1) {
            return -1;
        }
        int i2 = this.f7314h == 1 ? 1 : 0;
        if (this.f7315i == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public boolean m9375b() {
        return this.f7312f == 1;
    }

    public bpj m9371a(boolean z) {
        boolean z2;
        int i = 1;
        if (this.f7319m == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        bsg.m9658b(z2);
        if (!z) {
            i = 0;
        }
        this.f7312f = i;
        return this;
    }

    public boolean m9378c() {
        return this.f7313g == 1;
    }

    public bpj m9374b(boolean z) {
        boolean z2;
        int i = 1;
        if (this.f7319m == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        bsg.m9658b(z2);
        if (!z) {
            i = 0;
        }
        this.f7313g = i;
        return this;
    }

    public bpj m9377c(boolean z) {
        boolean z2;
        int i = 1;
        if (this.f7319m == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        bsg.m9658b(z2);
        if (!z) {
            i = 0;
        }
        this.f7314h = i;
        return this;
    }

    public bpj m9379d(boolean z) {
        boolean z2;
        int i = 1;
        if (this.f7319m == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        bsg.m9658b(z2);
        if (!z) {
            i = 0;
        }
        this.f7315i = i;
        return this;
    }

    public String m9380d() {
        return this.f7307a;
    }

    public bpj m9370a(String str) {
        bsg.m9658b(this.f7319m == null);
        this.f7307a = str;
        return this;
    }

    public int m9381e() {
        if (this.f7309c) {
            return this.f7308b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public bpj m9367a(int i) {
        bsg.m9658b(this.f7319m == null);
        this.f7308b = i;
        this.f7309c = true;
        return this;
    }

    public boolean m9382f() {
        return this.f7309c;
    }

    public int m9383g() {
        if (this.f7311e) {
            return this.f7310d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public bpj m9372b(int i) {
        this.f7310d = i;
        this.f7311e = true;
        return this;
    }

    public boolean m9384h() {
        return this.f7311e;
    }

    public bpj m9369a(bpj com_ushareit_listenit_bpj) {
        return m9364a(com_ushareit_listenit_bpj, true);
    }

    private bpj m9364a(bpj com_ushareit_listenit_bpj, boolean z) {
        if (com_ushareit_listenit_bpj != null) {
            if (!this.f7309c && com_ushareit_listenit_bpj.f7309c) {
                m9367a(com_ushareit_listenit_bpj.f7308b);
            }
            if (this.f7314h == -1) {
                this.f7314h = com_ushareit_listenit_bpj.f7314h;
            }
            if (this.f7315i == -1) {
                this.f7315i = com_ushareit_listenit_bpj.f7315i;
            }
            if (this.f7307a == null) {
                this.f7307a = com_ushareit_listenit_bpj.f7307a;
            }
            if (this.f7312f == -1) {
                this.f7312f = com_ushareit_listenit_bpj.f7312f;
            }
            if (this.f7313g == -1) {
                this.f7313g = com_ushareit_listenit_bpj.f7313g;
            }
            if (this.f7320n == null) {
                this.f7320n = com_ushareit_listenit_bpj.f7320n;
            }
            if (this.f7316j == -1) {
                this.f7316j = com_ushareit_listenit_bpj.f7316j;
                this.f7317k = com_ushareit_listenit_bpj.f7317k;
            }
            if (z && !this.f7311e && com_ushareit_listenit_bpj.f7311e) {
                m9372b(com_ushareit_listenit_bpj.f7310d);
            }
        }
        return this;
    }

    public bpj m9373b(String str) {
        this.f7318l = str;
        return this;
    }

    public String m9385i() {
        return this.f7318l;
    }

    public Alignment m9386j() {
        return this.f7320n;
    }

    public bpj m9368a(Alignment alignment) {
        this.f7320n = alignment;
        return this;
    }

    public bpj m9366a(float f) {
        this.f7317k = f;
        return this;
    }

    public bpj m9376c(int i) {
        this.f7316j = i;
        return this;
    }

    public int m9387k() {
        return this.f7316j;
    }

    public float m9388l() {
        return this.f7317k;
    }
}
