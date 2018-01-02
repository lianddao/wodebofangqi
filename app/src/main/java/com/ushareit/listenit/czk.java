package com.ushareit.listenit;

public final class czk extends dgc<czk> {
    private static volatile czk[] f9414c;
    public String f9415a;
    public czi[] f9416b;

    public czk() {
        m13502c();
    }

    public static czk[] m13497a() {
        if (f9414c == null) {
            synchronized (dgg.f9776c) {
                if (f9414c == null) {
                    f9414c = new czk[0];
                }
            }
        }
        return f9414c;
    }

    public czk m13498a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.f9415a = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    int b = dgl.m14265b(com_ushareit_listenit_dfz, 18);
                    a = this.f9416b == null ? 0 : this.f9416b.length;
                    Object obj = new czi[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f9416b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new czi();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new czi();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f9416b = obj;
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
        if (!this.f9415a.equals("")) {
            com_ushareit_listenit_dga.m14197a(1, this.f9415a);
        }
        if (this.f9416b != null && this.f9416b.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f9416b) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(2, com_ushareit_listenit_dgi);
                }
            }
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (!this.f9415a.equals("")) {
            b += dga.m14169b(1, this.f9415a);
        }
        if (this.f9416b == null || this.f9416b.length <= 0) {
            return b;
        }
        int i = b;
        for (dgi com_ushareit_listenit_dgi : this.f9416b) {
            if (com_ushareit_listenit_dgi != null) {
                i += dga.m14175c(2, com_ushareit_listenit_dgi);
            }
        }
        return i;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m13498a(com_ushareit_listenit_dfz);
    }

    public czk m13502c() {
        this.f9415a = "";
        this.f9416b = czi.m13486a();
        this.f = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof czk)) {
            return false;
        }
        czk com_ushareit_listenit_czk = (czk) obj;
        if (this.f9415a == null) {
            if (com_ushareit_listenit_czk.f9415a != null) {
                return false;
            }
        } else if (!this.f9415a.equals(com_ushareit_listenit_czk.f9415a)) {
            return false;
        }
        return dgg.m14245a(this.f9416b, com_ushareit_listenit_czk.f9416b) ? (this.f == null || this.f.m14234b()) ? com_ushareit_listenit_czk.f == null || com_ushareit_listenit_czk.f.m14234b() : this.f.equals(com_ushareit_listenit_czk.f) : false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f9415a == null ? 0 : this.f9415a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + dgg.m14242a(this.f9416b)) * 31;
        if (!(this.f == null || this.f.m14234b())) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
