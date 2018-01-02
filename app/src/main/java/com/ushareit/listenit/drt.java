package com.ushareit.listenit;

public final class drt extends dgi {
    public dru[] f10236a;

    public drt() {
        m15380a();
    }

    public drt m15380a() {
        this.f10236a = dru.m15385a();
        this.g = -1;
        return this;
    }

    public drt m15381a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    int b = dgl.m14265b(com_ushareit_listenit_dfz, 10);
                    a = this.f10236a == null ? 0 : this.f10236a.length;
                    Object obj = new dru[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10236a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new dru();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new dru();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10236a = obj;
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
        if (this.f10236a != null && this.f10236a.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f10236a) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(1, com_ushareit_listenit_dgi);
                }
            }
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10236a != null && this.f10236a.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f10236a) {
                if (com_ushareit_listenit_dgi != null) {
                    b += dga.m14175c(1, com_ushareit_listenit_dgi);
                }
            }
        }
        return b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15381a(com_ushareit_listenit_dfz);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drt)) {
            return false;
        }
        return dgg.m14245a(this.f10236a, ((drt) obj).f10236a);
    }

    public int hashCode() {
        return ((getClass().getName().hashCode() + 527) * 31) + dgg.m14242a(this.f10236a);
    }
}
