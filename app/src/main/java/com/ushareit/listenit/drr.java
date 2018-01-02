package com.ushareit.listenit;

import com.umeng.analytics.C0154a;

public final class drr extends dgi {
    private static volatile drr[] f10224f;
    public drs[] f10225a;
    public String f10226b;
    public Long f10227c;
    public Long f10228d;
    public Integer f10229e;

    public drr() {
        m15373c();
    }

    public static drr[] m15368a() {
        if (f10224f == null) {
            synchronized (dgg.f9776c) {
                if (f10224f == null) {
                    f10224f = new drr[0];
                }
            }
        }
        return f10224f;
    }

    public drr m15369a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    int b = dgl.m14265b(com_ushareit_listenit_dfz, 10);
                    a = this.f10225a == null ? 0 : this.f10225a.length;
                    Object obj = new drs[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10225a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drs();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drs();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10225a = obj;
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f10226b = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 24:
                    this.f10227c = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case C0154a.f2957m /*32*/:
                    this.f10228d = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 40:
                    this.f10229e = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
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
        if (this.f10225a != null && this.f10225a.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f10225a) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(1, com_ushareit_listenit_dgi);
                }
            }
        }
        if (this.f10226b != null) {
            com_ushareit_listenit_dga.m14197a(2, this.f10226b);
        }
        if (this.f10227c != null) {
            com_ushareit_listenit_dga.m14205b(3, this.f10227c.longValue());
        }
        if (this.f10228d != null) {
            com_ushareit_listenit_dga.m14205b(4, this.f10228d.longValue());
        }
        if (this.f10229e != null) {
            com_ushareit_listenit_dga.m14194a(5, this.f10229e.intValue());
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10225a != null && this.f10225a.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f10225a) {
                if (com_ushareit_listenit_dgi != null) {
                    b += dga.m14175c(1, com_ushareit_listenit_dgi);
                }
            }
        }
        if (this.f10226b != null) {
            b += dga.m14169b(2, this.f10226b);
        }
        if (this.f10227c != null) {
            b += dga.m14179d(3, this.f10227c.longValue());
        }
        if (this.f10228d != null) {
            b += dga.m14179d(4, this.f10228d.longValue());
        }
        return this.f10229e != null ? b + dga.m14167b(5, this.f10229e.intValue()) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15369a(com_ushareit_listenit_dfz);
    }

    public drr m15373c() {
        this.f10225a = drs.m15374a();
        this.f10226b = null;
        this.f10227c = null;
        this.f10228d = null;
        this.f10229e = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drr)) {
            return false;
        }
        drr com_ushareit_listenit_drr = (drr) obj;
        if (!dgg.m14245a(this.f10225a, com_ushareit_listenit_drr.f10225a)) {
            return false;
        }
        if (this.f10226b == null) {
            if (com_ushareit_listenit_drr.f10226b != null) {
                return false;
            }
        } else if (!this.f10226b.equals(com_ushareit_listenit_drr.f10226b)) {
            return false;
        }
        if (this.f10227c == null) {
            if (com_ushareit_listenit_drr.f10227c != null) {
                return false;
            }
        } else if (!this.f10227c.equals(com_ushareit_listenit_drr.f10227c)) {
            return false;
        }
        if (this.f10228d == null) {
            if (com_ushareit_listenit_drr.f10228d != null) {
                return false;
            }
        } else if (!this.f10228d.equals(com_ushareit_listenit_drr.f10228d)) {
            return false;
        }
        return this.f10229e == null ? com_ushareit_listenit_drr.f10229e == null : this.f10229e.equals(com_ushareit_listenit_drr.f10229e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10228d == null ? 0 : this.f10228d.hashCode()) + (((this.f10227c == null ? 0 : this.f10227c.hashCode()) + (((this.f10226b == null ? 0 : this.f10226b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + dgg.m14242a(this.f10225a)) * 31)) * 31)) * 31)) * 31;
        if (this.f10229e != null) {
            i = this.f10229e.hashCode();
        }
        return hashCode + i;
    }
}
