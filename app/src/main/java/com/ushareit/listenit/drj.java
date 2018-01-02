package com.ushareit.listenit;

public final class drj extends dgi {
    private static volatile drj[] f10198d;
    public Integer f10199a;
    public String f10200b;
    public drh f10201c;

    public drj() {
        m15339c();
    }

    public static drj[] m15334a() {
        if (f10198d == null) {
            synchronized (dgg.f9776c) {
                if (f10198d == null) {
                    f10198d = new drj[0];
                }
            }
        }
        return f10198d;
    }

    public drj m15335a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f10199a = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f10200b = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 26:
                    if (this.f10201c == null) {
                        this.f10201c = new drh();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f10201c);
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
        if (this.f10199a != null) {
            com_ushareit_listenit_dga.m14194a(1, this.f10199a.intValue());
        }
        if (this.f10200b != null) {
            com_ushareit_listenit_dga.m14197a(2, this.f10200b);
        }
        if (this.f10201c != null) {
            com_ushareit_listenit_dga.m14196a(3, this.f10201c);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10199a != null) {
            b += dga.m14167b(1, this.f10199a.intValue());
        }
        if (this.f10200b != null) {
            b += dga.m14169b(2, this.f10200b);
        }
        return this.f10201c != null ? b + dga.m14175c(3, this.f10201c) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15335a(com_ushareit_listenit_dfz);
    }

    public drj m15339c() {
        this.f10199a = null;
        this.f10200b = null;
        this.f10201c = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drj)) {
            return false;
        }
        drj com_ushareit_listenit_drj = (drj) obj;
        if (this.f10199a == null) {
            if (com_ushareit_listenit_drj.f10199a != null) {
                return false;
            }
        } else if (!this.f10199a.equals(com_ushareit_listenit_drj.f10199a)) {
            return false;
        }
        if (this.f10200b == null) {
            if (com_ushareit_listenit_drj.f10200b != null) {
                return false;
            }
        } else if (!this.f10200b.equals(com_ushareit_listenit_drj.f10200b)) {
            return false;
        }
        return this.f10201c == null ? com_ushareit_listenit_drj.f10201c == null : this.f10201c.equals(com_ushareit_listenit_drj.f10201c);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10200b == null ? 0 : this.f10200b.hashCode()) + (((this.f10199a == null ? 0 : this.f10199a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f10201c != null) {
            i = this.f10201c.hashCode();
        }
        return hashCode + i;
    }
}
