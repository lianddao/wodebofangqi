package com.ushareit.listenit;

public final class czh extends dgc<czh> {
    public czk[] f9407a;
    public long f9408b;

    public czh() {
        m13481a();
    }

    public czh m13481a() {
        this.f9407a = czk.m13497a();
        this.f9408b = 0;
        this.f = null;
        this.g = -1;
        return this;
    }

    public czh m13482a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    int b = dgl.m14265b(com_ushareit_listenit_dfz, 10);
                    a = this.f9407a == null ? 0 : this.f9407a.length;
                    Object obj = new czk[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f9407a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new czk();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new czk();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f9407a = obj;
                    continue;
                case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                    this.f9408b = com_ushareit_listenit_dfz.m14141h();
                    continue;
                default:
                    if (!super.m13477a(com_ushareit_listenit_dfz, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void mo1666a(dga com_ushareit_listenit_dga) {
        if (this.f9407a != null && this.f9407a.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f9407a) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(1, com_ushareit_listenit_dgi);
                }
            }
        }
        if (this.f9408b != 0) {
            com_ushareit_listenit_dga.m14212c(2, this.f9408b);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f9407a != null && this.f9407a.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f9407a) {
                if (com_ushareit_listenit_dgi != null) {
                    b += dga.m14175c(1, com_ushareit_listenit_dgi);
                }
            }
        }
        return this.f9408b != 0 ? b + dga.m14182e(2, this.f9408b) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m13482a(com_ushareit_listenit_dfz);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof czh)) {
            return false;
        }
        czh com_ushareit_listenit_czh = (czh) obj;
        return (dgg.m14245a(this.f9407a, com_ushareit_listenit_czh.f9407a) && this.f9408b == com_ushareit_listenit_czh.f9408b) ? (this.f == null || this.f.m14234b()) ? com_ushareit_listenit_czh.f == null || com_ushareit_listenit_czh.f.m14234b() : this.f.equals(com_ushareit_listenit_czh.f) : false;
    }

    public int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + dgg.m14242a(this.f9407a)) * 31) + ((int) (this.f9408b ^ (this.f9408b >>> 32)))) * 31;
        int hashCode2 = (this.f == null || this.f.m14234b()) ? 0 : this.f.hashCode();
        return hashCode2 + hashCode;
    }
}
