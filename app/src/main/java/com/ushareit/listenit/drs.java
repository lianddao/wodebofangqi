package com.ushareit.listenit;

public final class drs extends dgi {
    private static volatile drs[] f10230f;
    public String f10231a;
    public String f10232b;
    public Long f10233c;
    public Float f10234d;
    public Double f10235e;

    public drs() {
        m15379c();
    }

    public static drs[] m15374a() {
        if (f10230f == null) {
            synchronized (dgg.f9776c) {
                if (f10230f == null) {
                    f10230f = new drs[0];
                }
            }
        }
        return f10230f;
    }

    public drs m15375a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.f10231a = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f10232b = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 24:
                    this.f10233c = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case 37:
                    this.f10234d = Float.valueOf(com_ushareit_listenit_dfz.m14134d());
                    continue;
                case 41:
                    this.f10235e = Double.valueOf(com_ushareit_listenit_dfz.m14132c());
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
        if (this.f10231a != null) {
            com_ushareit_listenit_dga.m14197a(1, this.f10231a);
        }
        if (this.f10232b != null) {
            com_ushareit_listenit_dga.m14197a(2, this.f10232b);
        }
        if (this.f10233c != null) {
            com_ushareit_listenit_dga.m14205b(3, this.f10233c.longValue());
        }
        if (this.f10234d != null) {
            com_ushareit_listenit_dga.m14193a(4, this.f10234d.floatValue());
        }
        if (this.f10235e != null) {
            com_ushareit_listenit_dga.m14192a(5, this.f10235e.doubleValue());
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10231a != null) {
            b += dga.m14169b(1, this.f10231a);
        }
        if (this.f10232b != null) {
            b += dga.m14169b(2, this.f10232b);
        }
        if (this.f10233c != null) {
            b += dga.m14179d(3, this.f10233c.longValue());
        }
        if (this.f10234d != null) {
            b += dga.m14166b(4, this.f10234d.floatValue());
        }
        return this.f10235e != null ? b + dga.m14165b(5, this.f10235e.doubleValue()) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15375a(com_ushareit_listenit_dfz);
    }

    public drs m15379c() {
        this.f10231a = null;
        this.f10232b = null;
        this.f10233c = null;
        this.f10234d = null;
        this.f10235e = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drs)) {
            return false;
        }
        drs com_ushareit_listenit_drs = (drs) obj;
        if (this.f10231a == null) {
            if (com_ushareit_listenit_drs.f10231a != null) {
                return false;
            }
        } else if (!this.f10231a.equals(com_ushareit_listenit_drs.f10231a)) {
            return false;
        }
        if (this.f10232b == null) {
            if (com_ushareit_listenit_drs.f10232b != null) {
                return false;
            }
        } else if (!this.f10232b.equals(com_ushareit_listenit_drs.f10232b)) {
            return false;
        }
        if (this.f10233c == null) {
            if (com_ushareit_listenit_drs.f10233c != null) {
                return false;
            }
        } else if (!this.f10233c.equals(com_ushareit_listenit_drs.f10233c)) {
            return false;
        }
        if (this.f10234d == null) {
            if (com_ushareit_listenit_drs.f10234d != null) {
                return false;
            }
        } else if (!this.f10234d.equals(com_ushareit_listenit_drs.f10234d)) {
            return false;
        }
        return this.f10235e == null ? com_ushareit_listenit_drs.f10235e == null : this.f10235e.equals(com_ushareit_listenit_drs.f10235e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10234d == null ? 0 : this.f10234d.hashCode()) + (((this.f10233c == null ? 0 : this.f10233c.hashCode()) + (((this.f10232b == null ? 0 : this.f10232b.hashCode()) + (((this.f10231a == null ? 0 : this.f10231a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f10235e != null) {
            i = this.f10235e.hashCode();
        }
        return hashCode + i;
    }
}
