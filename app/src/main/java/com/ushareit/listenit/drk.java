package com.ushareit.listenit;

public final class drk extends dgi {
    public Integer f10202a;
    public String f10203b;
    public Boolean f10204c;
    public String[] f10205d;

    public drk() {
        m15340a();
    }

    public drk m15340a() {
        this.f10203b = null;
        this.f10204c = null;
        this.f10205d = dgl.f9784f;
        this.g = -1;
        return this;
    }

    public drk m15341a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    a = com_ushareit_listenit_dfz.m14140g();
                    switch (a) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.f10202a = Integer.valueOf(a);
                            break;
                        default:
                            continue;
                    }
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f10203b = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 24:
                    this.f10204c = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
                    continue;
                case 34:
                    int b = dgl.m14265b(com_ushareit_listenit_dfz, 34);
                    a = this.f10205d == null ? 0 : this.f10205d.length;
                    Object obj = new String[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f10205d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = com_ushareit_listenit_dfz.m14143j();
                        com_ushareit_listenit_dfz.m14126a();
                        a++;
                    }
                    obj[a] = com_ushareit_listenit_dfz.m14143j();
                    this.f10205d = obj;
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
        if (this.f10202a != null) {
            com_ushareit_listenit_dga.m14194a(1, this.f10202a.intValue());
        }
        if (this.f10203b != null) {
            com_ushareit_listenit_dga.m14197a(2, this.f10203b);
        }
        if (this.f10204c != null) {
            com_ushareit_listenit_dga.m14198a(3, this.f10204c.booleanValue());
        }
        if (this.f10205d != null && this.f10205d.length > 0) {
            for (String str : this.f10205d) {
                if (str != null) {
                    com_ushareit_listenit_dga.m14197a(4, str);
                }
            }
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int i = 0;
        int b = super.mo1667b();
        if (this.f10202a != null) {
            b += dga.m14167b(1, this.f10202a.intValue());
        }
        if (this.f10203b != null) {
            b += dga.m14169b(2, this.f10203b);
        }
        if (this.f10204c != null) {
            b += dga.m14170b(3, this.f10204c.booleanValue());
        }
        if (this.f10205d == null || this.f10205d.length <= 0) {
            return b;
        }
        int i2 = 0;
        int i3 = 0;
        while (i < this.f10205d.length) {
            String str = this.f10205d[i];
            if (str != null) {
                i3++;
                i2 += dga.m14172b(str);
            }
            i++;
        }
        return (b + i2) + (i3 * 1);
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15341a(com_ushareit_listenit_dfz);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drk)) {
            return false;
        }
        drk com_ushareit_listenit_drk = (drk) obj;
        if (this.f10202a == null) {
            if (com_ushareit_listenit_drk.f10202a != null) {
                return false;
            }
        } else if (!this.f10202a.equals(com_ushareit_listenit_drk.f10202a)) {
            return false;
        }
        if (this.f10203b == null) {
            if (com_ushareit_listenit_drk.f10203b != null) {
                return false;
            }
        } else if (!this.f10203b.equals(com_ushareit_listenit_drk.f10203b)) {
            return false;
        }
        if (this.f10204c == null) {
            if (com_ushareit_listenit_drk.f10204c != null) {
                return false;
            }
        } else if (!this.f10204c.equals(com_ushareit_listenit_drk.f10204c)) {
            return false;
        }
        return dgg.m14245a(this.f10205d, com_ushareit_listenit_drk.f10205d);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10203b == null ? 0 : this.f10203b.hashCode()) + (((this.f10202a == null ? 0 : this.f10202a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f10204c != null) {
            i = this.f10204c.hashCode();
        }
        return ((hashCode + i) * 31) + dgg.m14242a(this.f10205d);
    }
}
