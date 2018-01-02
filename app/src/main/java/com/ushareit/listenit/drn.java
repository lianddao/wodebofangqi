package com.ushareit.listenit;

public final class drn extends dgi {
    public Long f10210a;
    public String f10211b;
    public Integer f10212c;
    public dro[] f10213d;
    public drm[] f10214e;
    public drf[] f10215f;

    public drn() {
        m15351a();
    }

    public drn m15351a() {
        this.f10210a = null;
        this.f10211b = null;
        this.f10212c = null;
        this.f10213d = dro.m15356a();
        this.f10214e = drm.m15345a();
        this.f10215f = drf.m15311a();
        this.g = -1;
        return this;
    }

    public drn m15352a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            int b;
            Object obj;
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f10210a = Long.valueOf(com_ushareit_listenit_dfz.m14138f());
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f10211b = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 24:
                    this.f10212c = Integer.valueOf(com_ushareit_listenit_dfz.m14140g());
                    continue;
                case 34:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 34);
                    a = this.f10213d == null ? 0 : this.f10213d.length;
                    obj = new dro[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10213d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new dro();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new dro();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10213d = obj;
                    continue;
                case 42:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 42);
                    a = this.f10214e == null ? 0 : this.f10214e.length;
                    obj = new drm[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10214e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drm();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drm();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10214e = obj;
                    continue;
                case 50:
                    b = dgl.m14265b(com_ushareit_listenit_dfz, 50);
                    a = this.f10215f == null ? 0 : this.f10215f.length;
                    obj = new drf[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10215f, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new drf();
                        com_ushareit_listenit_dfz.m14128a(obj[a]);
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = new drf();
                    com_ushareit_listenit_dfz.m14128a(obj[a]);
                    this.f10215f = obj;
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
        int i = 0;
        if (this.f10210a != null) {
            com_ushareit_listenit_dga.m14205b(1, this.f10210a.longValue());
        }
        if (this.f10211b != null) {
            com_ushareit_listenit_dga.m14197a(2, this.f10211b);
        }
        if (this.f10212c != null) {
            com_ushareit_listenit_dga.m14194a(3, this.f10212c.intValue());
        }
        if (this.f10213d != null && this.f10213d.length > 0) {
            for (dgi com_ushareit_listenit_dgi : this.f10213d) {
                if (com_ushareit_listenit_dgi != null) {
                    com_ushareit_listenit_dga.m14196a(4, com_ushareit_listenit_dgi);
                }
            }
        }
        if (this.f10214e != null && this.f10214e.length > 0) {
            for (dgi com_ushareit_listenit_dgi2 : this.f10214e) {
                if (com_ushareit_listenit_dgi2 != null) {
                    com_ushareit_listenit_dga.m14196a(5, com_ushareit_listenit_dgi2);
                }
            }
        }
        if (this.f10215f != null && this.f10215f.length > 0) {
            while (i < this.f10215f.length) {
                dgi com_ushareit_listenit_dgi3 = this.f10215f[i];
                if (com_ushareit_listenit_dgi3 != null) {
                    com_ushareit_listenit_dga.m14196a(6, com_ushareit_listenit_dgi3);
                }
                i++;
            }
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int i;
        int i2 = 0;
        int b = super.mo1667b();
        if (this.f10210a != null) {
            b += dga.m14179d(1, this.f10210a.longValue());
        }
        if (this.f10211b != null) {
            b += dga.m14169b(2, this.f10211b);
        }
        if (this.f10212c != null) {
            b += dga.m14167b(3, this.f10212c.intValue());
        }
        if (this.f10213d != null && this.f10213d.length > 0) {
            i = b;
            for (dgi com_ushareit_listenit_dgi : this.f10213d) {
                if (com_ushareit_listenit_dgi != null) {
                    i += dga.m14175c(4, com_ushareit_listenit_dgi);
                }
            }
            b = i;
        }
        if (this.f10214e != null && this.f10214e.length > 0) {
            i = b;
            for (dgi com_ushareit_listenit_dgi2 : this.f10214e) {
                if (com_ushareit_listenit_dgi2 != null) {
                    i += dga.m14175c(5, com_ushareit_listenit_dgi2);
                }
            }
            b = i;
        }
        if (this.f10215f != null && this.f10215f.length > 0) {
            while (i2 < this.f10215f.length) {
                dgi com_ushareit_listenit_dgi3 = this.f10215f[i2];
                if (com_ushareit_listenit_dgi3 != null) {
                    b += dga.m14175c(6, com_ushareit_listenit_dgi3);
                }
                i2++;
            }
        }
        return b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15352a(com_ushareit_listenit_dfz);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drn)) {
            return false;
        }
        drn com_ushareit_listenit_drn = (drn) obj;
        if (this.f10210a == null) {
            if (com_ushareit_listenit_drn.f10210a != null) {
                return false;
            }
        } else if (!this.f10210a.equals(com_ushareit_listenit_drn.f10210a)) {
            return false;
        }
        if (this.f10211b == null) {
            if (com_ushareit_listenit_drn.f10211b != null) {
                return false;
            }
        } else if (!this.f10211b.equals(com_ushareit_listenit_drn.f10211b)) {
            return false;
        }
        if (this.f10212c == null) {
            if (com_ushareit_listenit_drn.f10212c != null) {
                return false;
            }
        } else if (!this.f10212c.equals(com_ushareit_listenit_drn.f10212c)) {
            return false;
        }
        return !dgg.m14245a(this.f10213d, com_ushareit_listenit_drn.f10213d) ? false : !dgg.m14245a(this.f10214e, com_ushareit_listenit_drn.f10214e) ? false : dgg.m14245a(this.f10215f, com_ushareit_listenit_drn.f10215f);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10211b == null ? 0 : this.f10211b.hashCode()) + (((this.f10210a == null ? 0 : this.f10210a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f10212c != null) {
            i = this.f10212c.hashCode();
        }
        return ((((((hashCode + i) * 31) + dgg.m14242a(this.f10213d)) * 31) + dgg.m14242a(this.f10214e)) * 31) + dgg.m14242a(this.f10215f);
    }
}
