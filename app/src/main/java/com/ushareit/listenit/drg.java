package com.ushareit.listenit;

import com.umeng.analytics.C0154a;

public final class drg extends dgi {
    private static volatile drg[] f10182f;
    public Integer f10183a;
    public String f10184b;
    public drh[] f10185c;
    public Boolean f10186d;
    public dri f10187e;

    public drg() {
        m15322c();
    }

    public static drg[] m15317a() {
        if (f10182f == null) {
            synchronized (dgg.f9776c) {
                if (f10182f == null) {
                    f10182f = new drg[0];
                }
            }
        }
        return f10182f;
    }

    public drg m15318a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f10183a = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f10184b = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 26:
                    int b = dgl.m14265b(com_ushareit_listenit_dfz, 26);
                    a = this.f10185c == null ? 0 : this.f10185c.length;
                    Object obj = new drh[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10185c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drh();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drh();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10185c = obj;
                    continue;
                case C0154a.f2957m /*32*/:
                    this.f10186d = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
                    continue;
                case 42:
                    if (this.f10187e == null) {
                        this.f10187e = new dri();
                    }
                    com_ushareit_listenit_dfz.m14128a(this.f10187e);
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
        if (this.f10183a != null) {
            com_ushareit_listenit_dga.m14194a(1, this.f10183a.intValue());
        }
        if (this.f10184b != null) {
            com_ushareit_listenit_dga.m14197a(2, this.f10184b);
        }
        if (this.f10185c != null && this.f10185c.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f10185c) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(3, com_ushareit_listenit_dgi);
                }
            }
        }
        if (this.f10186d != null) {
            com_ushareit_listenit_dga.m14198a(4, this.f10186d.booleanValue());
        }
        if (this.f10187e != null) {
            com_ushareit_listenit_dga.m14196a(5, this.f10187e);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10183a != null) {
            b += dga.m14167b(1, this.f10183a.intValue());
        }
        if (this.f10184b != null) {
            b += dga.m14169b(2, this.f10184b);
        }
        if (this.f10185c != null && this.f10185c.length > 0) {
            int i = b;
            for (dgi com_ushareit_listenit_dgi : this.f10185c) {
                if (com_ushareit_listenit_dgi != null) {
                    i += dga.m14175c(3, com_ushareit_listenit_dgi);
                }
            }
            b = i;
        }
        if (this.f10186d != null) {
            b += dga.m14170b(4, this.f10186d.booleanValue());
        }
        return this.f10187e != null ? b + dga.m14175c(5, this.f10187e) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15318a(com_ushareit_listenit_dfz);
    }

    public drg m15322c() {
        this.f10183a = null;
        this.f10184b = null;
        this.f10185c = drh.m15323a();
        this.f10186d = null;
        this.f10187e = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drg)) {
            return false;
        }
        drg com_ushareit_listenit_drg = (drg) obj;
        if (this.f10183a == null) {
            if (com_ushareit_listenit_drg.f10183a != null) {
                return false;
            }
        } else if (!this.f10183a.equals(com_ushareit_listenit_drg.f10183a)) {
            return false;
        }
        if (this.f10184b == null) {
            if (com_ushareit_listenit_drg.f10184b != null) {
                return false;
            }
        } else if (!this.f10184b.equals(com_ushareit_listenit_drg.f10184b)) {
            return false;
        }
        if (!dgg.m14245a(this.f10185c, com_ushareit_listenit_drg.f10185c)) {
            return false;
        }
        if (this.f10186d == null) {
            if (com_ushareit_listenit_drg.f10186d != null) {
                return false;
            }
        } else if (!this.f10186d.equals(com_ushareit_listenit_drg.f10186d)) {
            return false;
        }
        return this.f10187e == null ? com_ushareit_listenit_drg.f10187e == null : this.f10187e.equals(com_ushareit_listenit_drg.f10187e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10186d == null ? 0 : this.f10186d.hashCode()) + (((((this.f10184b == null ? 0 : this.f10184b.hashCode()) + (((this.f10183a == null ? 0 : this.f10183a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + dgg.m14242a(this.f10185c)) * 31)) * 31;
        if (this.f10187e != null) {
            i = this.f10187e.hashCode();
        }
        return hashCode + i;
    }
}
