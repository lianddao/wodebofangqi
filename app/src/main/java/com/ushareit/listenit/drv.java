package com.ushareit.listenit;

public final class drv extends dgi {
    public long[] f10270a;
    public long[] f10271b;

    public drv() {
        m15391a();
    }

    public drv m15391a() {
        this.f10270a = dgl.f9780b;
        this.f10271b = dgl.f9780b;
        this.g = -1;
        return this;
    }

    public drv m15392a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            int b;
            Object obj;
            int c;
            Object obj2;
            switch (a) {
                case 0:
                    break;
                case 8:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 8);
                    a = this.f10270a == null ? 0 : this.f10270a.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10270a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = com_ushareit_listenit_dfz.m14136e();
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = com_ushareit_listenit_dfz.m14136e();
                    this.f10270a = obj;
                    continue;
                case 10:
                    c = com_ushareit_listenit_dfz.m14133c(com_ushareit_listenit_dfz.m14145l());
                    b = com_ushareit_listenit_dfz.m14151r();
                    a = 0;
                    while (com_ushareit_listenit_dfz.m14149p() > 0) {
                        com_ushareit_listenit_dfz.m14136e();
                        a++;
                    }
                    com_ushareit_listenit_dfz.m14137e(b);
                    b = this.f10270a == null ? 0 : this.f10270a.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.f10270a, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = com_ushareit_listenit_dfz.m14136e();
                        b++;
                    }
                    this.f10270a = obj2;
                    com_ushareit_listenit_dfz.m14135d(c);
                    continue;
                case 16:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 16);
                    a = this.f10271b == null ? 0 : this.f10271b.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10271b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = com_ushareit_listenit_dfz.m14136e();
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = com_ushareit_listenit_dfz.m14136e();
                    this.f10271b = obj;
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    c = com_ushareit_listenit_dfz.m14133c(com_ushareit_listenit_dfz.m14145l());
                    b = com_ushareit_listenit_dfz.m14151r();
                    a = 0;
                    while (com_ushareit_listenit_dfz.m14149p() > 0) {
                        com_ushareit_listenit_dfz.m14136e();
                        a++;
                    }
                    com_ushareit_listenit_dfz.m14137e(b);
                    b = this.f10271b == null ? 0 : this.f10271b.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.f10271b, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = com_ushareit_listenit_dfz.m14136e();
                        b++;
                    }
                    this.f10271b = obj2;
                    com_ushareit_listenit_dfz.m14135d(c);
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
        if (this.f10270a != null && this.f10270a.length > 0) {
            for (long a : this.f10270a) {
                com_ushareit_listenit_dga.m14195a(1, a);
            }
        }
        if (this.f10271b != null && this.f10271b.length > 0) {
            while (i < this.f10271b.length) {
                com_ushareit_listenit_dga.m14195a(2, this.f10271b[i]);
                i++;
            }
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int i;
        int i2;
        int i3 = 0;
        int b = super.mo1667b();
        if (this.f10270a == null || this.f10270a.length <= 0) {
            i = b;
        } else {
            i2 = 0;
            for (long d : this.f10270a) {
                i2 += dga.m14180d(d);
            }
            i = (b + i2) + (this.f10270a.length * 1);
        }
        if (this.f10271b == null || this.f10271b.length <= 0) {
            return i;
        }
        i2 = 0;
        while (i3 < this.f10271b.length) {
            i2 += dga.m14180d(this.f10271b[i3]);
            i3++;
        }
        return (i + i2) + (this.f10271b.length * 1);
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15392a(com_ushareit_listenit_dfz);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drv)) {
            return false;
        }
        drv com_ushareit_listenit_drv = (drv) obj;
        return !dgg.m14244a(this.f10270a, com_ushareit_listenit_drv.f10270a) ? false : dgg.m14244a(this.f10271b, com_ushareit_listenit_drv.f10271b);
    }

    public int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + dgg.m14241a(this.f10270a)) * 31) + dgg.m14241a(this.f10271b);
    }
}
