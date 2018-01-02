package com.ushareit.listenit;

public final class drh extends dgi {
    private static volatile drh[] f10188e;
    public drk f10189a;
    public dri f10190b;
    public Boolean f10191c;
    public String f10192d;

    public drh() {
        m15328c();
    }

    public static drh[] m15323a() {
        if (f10188e == null) {
            synchronized (dgg.f9776c) {
                if (f10188e == null) {
                    f10188e = new drh[0];
                }
            }
        }
        return f10188e;
    }

    public drh m15324a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    if (this.f10189a == null) {
                        this.f10189a = new drk();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f10189a);
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    if (this.f10190b == null) {
                        this.f10190b = new dri();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f10190b);
                    continue;
                case 24:
                    this.f10191c = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
                    continue;
                case 34:
                    this.f10192d = com_ushareit_listenit_dfz.m14143j();
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
        if (this.f10189a != null) {
            com_ushareit_listenit_dga.m14196a(1, this.f10189a);
        }
        if (this.f10190b != null) {
            com_ushareit_listenit_dga.m14196a(2, this.f10190b);
        }
        if (this.f10191c != null) {
            com_ushareit_listenit_dga.m14198a(3, this.f10191c.booleanValue());
        }
        if (this.f10192d != null) {
            com_ushareit_listenit_dga.m14197a(4, this.f10192d);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10189a != null) {
            b += dga.m14175c(1, this.f10189a);
        }
        if (this.f10190b != null) {
            b += dga.m14175c(2, this.f10190b);
        }
        if (this.f10191c != null) {
            b += dga.m14170b(3, this.f10191c.booleanValue());
        }
        return this.f10192d != null ? b + dga.m14169b(4, this.f10192d) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15324a(com_ushareit_listenit_dfz);
    }

    public drh m15328c() {
        this.f10189a = null;
        this.f10190b = null;
        this.f10191c = null;
        this.f10192d = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drh)) {
            return false;
        }
        drh com_ushareit_listenit_drh = (drh) obj;
        if (this.f10189a == null) {
            if (com_ushareit_listenit_drh.f10189a != null) {
                return false;
            }
        } else if (!this.f10189a.equals(com_ushareit_listenit_drh.f10189a)) {
            return false;
        }
        if (this.f10190b == null) {
            if (com_ushareit_listenit_drh.f10190b != null) {
                return false;
            }
        } else if (!this.f10190b.equals(com_ushareit_listenit_drh.f10190b)) {
            return false;
        }
        if (this.f10191c == null) {
            if (com_ushareit_listenit_drh.f10191c != null) {
                return false;
            }
        } else if (!this.f10191c.equals(com_ushareit_listenit_drh.f10191c)) {
            return false;
        }
        return this.f10192d == null ? com_ushareit_listenit_drh.f10192d == null : this.f10192d.equals(com_ushareit_listenit_drh.f10192d);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10191c == null ? 0 : this.f10191c.hashCode()) + (((this.f10190b == null ? 0 : this.f10190b.hashCode()) + (((this.f10189a == null ? 0 : this.f10189a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (this.f10192d != null) {
            i = this.f10192d.hashCode();
        }
        return hashCode + i;
    }
}
