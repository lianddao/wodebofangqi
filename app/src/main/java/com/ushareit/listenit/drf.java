package com.ushareit.listenit;

public final class drf extends dgi {
    private static volatile drf[] f10178d;
    public Integer f10179a;
    public drj[] f10180b;
    public drg[] f10181c;

    public drf() {
        m15316c();
    }

    public static drf[] m15311a() {
        if (f10178d == null) {
            synchronized (dgg.f9776c) {
                if (f10178d == null) {
                    f10178d = new drf[0];
                }
            }
        }
        return f10178d;
    }

    public drf m15312a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            int b;
            Object obj;
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f10179a = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 18);
                    a = this.f10180b == null ? 0 : this.f10180b.length;
                    obj = new drj[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10180b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drj();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drj();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10180b = obj;
                    continue;
                case 26:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 26);
                    a = this.f10181c == null ? 0 : this.f10181c.length;
                    obj = new drg[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10181c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drg();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drg();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10181c = obj;
                    continue;
                default:
                    if (!dgl.m14263a(com_ushareit_listenit_dfz, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void mo1666a(dga com_ushareit_listenit_dga) {
        int i = 0;
        if (this.f10179a != null) {
            com_ushareit_listenit_dga.m14194a(1, this.f10179a.intValue());
        }
        if (this.f10180b != null && this.f10180b.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f10180b) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(2, com_ushareit_listenit_dgi);
                }
            }
        }
        if (this.f10181c != null && this.f10181c.length > 0) {
            while (i < this.f10181c.length) {
                dgi com_ushareit_listenit_dgi2 = this.f10181c[i];
                if (com_ushareit_listenit_dgi2 != null) {
                    com_ushareit_listenit_dga.m14196a(3, com_ushareit_listenit_dgi2);
                }
                i++;
            }
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int i = 0;
        int b = super.mo1667b();
        if (this.f10179a != null) {
            b += dga.m14167b(1, this.f10179a.intValue());
        }
        if (this.f10180b != null && this.f10180b.length > 0) {
            int i2 = b;
            for (dgi com_ushareit_listenit_dgi : this.f10180b) {
                if (com_ushareit_listenit_dgi != null) {
                    i2 += dga.m14175c(2, com_ushareit_listenit_dgi);
                }
            }
            b = i2;
        }
        if (this.f10181c != null && this.f10181c.length > 0) {
            while (i < this.f10181c.length) {
                dgi com_ushareit_listenit_dgi2 = this.f10181c[i];
                if (com_ushareit_listenit_dgi2 != null) {
                    b += dga.m14175c(3, com_ushareit_listenit_dgi2);
                }
                i++;
            }
        }
        return b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15312a(com_ushareit_listenit_dfz);
    }

    public drf m15316c() {
        this.f10179a = null;
        this.f10180b = drj.m15334a();
        this.f10181c = drg.m15317a();
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drf)) {
            return false;
        }
        drf com_ushareit_listenit_drf = (drf) obj;
        if (this.f10179a == null) {
            if (com_ushareit_listenit_drf.f10179a != null) {
                return false;
            }
        } else if (!this.f10179a.equals(com_ushareit_listenit_drf.f10179a)) {
            return false;
        }
        return !dgg.m14245a(this.f10180b, com_ushareit_listenit_drf.f10180b) ? false : dgg.m14245a(this.f10181c, com_ushareit_listenit_drf.f10181c);
    }

    public int hashCode() {
        return (((((this.f10179a == null ? 0 : this.f10179a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + dgg.m14242a(this.f10180b)) * 31) + dgg.m14242a(this.f10181c);
    }
}
