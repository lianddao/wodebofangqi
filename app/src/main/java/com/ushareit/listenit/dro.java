package com.ushareit.listenit;

public final class dro extends dgi {
    private static volatile dro[] f10216c;
    public String f10217a;
    public String f10218b;

    public dro() {
        m15361c();
    }

    public static dro[] m15356a() {
        if (f10216c == null) {
            synchronized (dgg.f9776c) {
                if (f10216c == null) {
                    f10216c = new dro[0];
                }
            }
        }
        return f10216c;
    }

    public dro m15357a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.f10217a = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f10218b = com_ushareit_listenit_dfz.m14143j();
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
        if (this.f10217a != null) {
            com_ushareit_listenit_dga.m14197a(1, this.f10217a);
        }
        if (this.f10218b != null) {
            com_ushareit_listenit_dga.m14197a(2, this.f10218b);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10217a != null) {
            b += dga.m14169b(1, this.f10217a);
        }
        return this.f10218b != null ? b + dga.m14169b(2, this.f10218b) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15357a(com_ushareit_listenit_dfz);
    }

    public dro m15361c() {
        this.f10217a = null;
        this.f10218b = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dro)) {
            return false;
        }
        dro com_ushareit_listenit_dro = (dro) obj;
        if (this.f10217a == null) {
            if (com_ushareit_listenit_dro.f10217a != null) {
                return false;
            }
        } else if (!this.f10217a.equals(com_ushareit_listenit_dro.f10217a)) {
            return false;
        }
        return this.f10218b == null ? com_ushareit_listenit_dro.f10218b == null : this.f10218b.equals(com_ushareit_listenit_dro.f10218b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10217a == null ? 0 : this.f10217a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
        if (this.f10218b != null) {
            i = this.f10218b.hashCode();
        }
        return hashCode + i;
    }
}
