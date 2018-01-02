package com.ushareit.listenit;

import com.umeng.analytics.C0154a;

public final class drq extends dgi {
    private static volatile drq[] f10219e;
    public Integer f10220a;
    public drv f10221b;
    public drv f10222c;
    public Boolean f10223d;

    public drq() {
        m15367c();
    }

    public static drq[] m15362a() {
        if (f10219e == null) {
            synchronized (dgg.f9776c) {
                if (f10219e == null) {
                    f10219e = new drq[0];
                }
            }
        }
        return f10219e;
    }

    public drq m15363a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f10220a = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    if (this.f10221b == null) {
                        this.f10221b = new drv();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f10221b);
                    continue;
                case 26:
                    if (this.f10222c == null) {
                        this.f10222c = new drv();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f10222c);
                    continue;
                case C0154a.f2957m /*32*/:
                    this.f10223d = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
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
        if (this.f10220a != null) {
            com_ushareit_listenit_dga.m14194a(1, this.f10220a.intValue());
        }
        if (this.f10221b != null) {
            com_ushareit_listenit_dga.m14196a(2, this.f10221b);
        }
        if (this.f10222c != null) {
            com_ushareit_listenit_dga.m14196a(3, this.f10222c);
        }
        if (this.f10223d != null) {
            com_ushareit_listenit_dga.m14198a(4, this.f10223d.booleanValue());
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10220a != null) {
            b += dga.m14167b(1, this.f10220a.intValue());
        }
        if (this.f10221b != null) {
            b += dga.m14175c(2, this.f10221b);
        }
        if (this.f10222c != null) {
            b += dga.m14175c(3, this.f10222c);
        }
        return this.f10223d != null ? b + dga.m14170b(4, this.f10223d.booleanValue()) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15363a(com_ushareit_listenit_dfz);
    }

    public drq m15367c() {
        this.f10220a = null;
        this.f10221b = null;
        this.f10222c = null;
        this.f10223d = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drq)) {
            return false;
        }
        drq com_ushareit_listenit_drq = (drq) obj;
        if (this.f10220a == null) {
            if (com_ushareit_listenit_drq.f10220a != null) {
                return false;
            }
        } else if (!this.f10220a.equals(com_ushareit_listenit_drq.f10220a)) {
            return false;
        }
        if (this.f10221b == null) {
            if (com_ushareit_listenit_drq.f10221b != null) {
                return false;
            }
        } else if (!this.f10221b.equals(com_ushareit_listenit_drq.f10221b)) {
            return false;
        }
        if (this.f10222c == null) {
            if (com_ushareit_listenit_drq.f10222c != null) {
                return false;
            }
        } else if (!this.f10222c.equals(com_ushareit_listenit_drq.f10222c)) {
            return false;
        }
        return this.f10223d == null ? com_ushareit_listenit_drq.f10223d == null : this.f10223d.equals(com_ushareit_listenit_drq.f10223d);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10222c == null ? 0 : this.f10222c.hashCode()) + (((this.f10221b == null ? 0 : this.f10221b.hashCode()) + (((this.f10220a == null ? 0 : this.f10220a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (this.f10223d != null) {
            i = this.f10223d.hashCode();
        }
        return hashCode + i;
    }
}
