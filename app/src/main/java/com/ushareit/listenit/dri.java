package com.ushareit.listenit;

public final class dri extends dgi {
    public Integer f10193a;
    public Boolean f10194b;
    public String f10195c;
    public String f10196d;
    public String f10197e;

    public dri() {
        m15329a();
    }

    public dri m15329a() {
        this.f10194b = null;
        this.f10195c = null;
        this.f10196d = null;
        this.f10197e = null;
        this.g = -1;
        return this;
    }

    public dri m15330a(dfz com_ushareit_listenit_dfz) {
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
                            this.f10193a = Integer.valueOf(a);
                            break;
                        default:
                            continue;
                    }
                case 16:
                    this.f10194b = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
                    continue;
                case 26:
                    this.f10195c = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 34:
                    this.f10196d = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 42:
                    this.f10197e = com_ushareit_listenit_dfz.m14143j();
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
        if (this.f10193a != null) {
            com_ushareit_listenit_dga.m14194a(1, this.f10193a.intValue());
        }
        if (this.f10194b != null) {
            com_ushareit_listenit_dga.m14198a(2, this.f10194b.booleanValue());
        }
        if (this.f10195c != null) {
            com_ushareit_listenit_dga.m14197a(3, this.f10195c);
        }
        if (this.f10196d != null) {
            com_ushareit_listenit_dga.m14197a(4, this.f10196d);
        }
        if (this.f10197e != null) {
            com_ushareit_listenit_dga.m14197a(5, this.f10197e);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10193a != null) {
            b += dga.m14167b(1, this.f10193a.intValue());
        }
        if (this.f10194b != null) {
            b += dga.m14170b(2, this.f10194b.booleanValue());
        }
        if (this.f10195c != null) {
            b += dga.m14169b(3, this.f10195c);
        }
        if (this.f10196d != null) {
            b += dga.m14169b(4, this.f10196d);
        }
        return this.f10197e != null ? b + dga.m14169b(5, this.f10197e) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15330a(com_ushareit_listenit_dfz);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dri)) {
            return false;
        }
        dri com_ushareit_listenit_dri = (dri) obj;
        if (this.f10193a == null) {
            if (com_ushareit_listenit_dri.f10193a != null) {
                return false;
            }
        } else if (!this.f10193a.equals(com_ushareit_listenit_dri.f10193a)) {
            return false;
        }
        if (this.f10194b == null) {
            if (com_ushareit_listenit_dri.f10194b != null) {
                return false;
            }
        } else if (!this.f10194b.equals(com_ushareit_listenit_dri.f10194b)) {
            return false;
        }
        if (this.f10195c == null) {
            if (com_ushareit_listenit_dri.f10195c != null) {
                return false;
            }
        } else if (!this.f10195c.equals(com_ushareit_listenit_dri.f10195c)) {
            return false;
        }
        if (this.f10196d == null) {
            if (com_ushareit_listenit_dri.f10196d != null) {
                return false;
            }
        } else if (!this.f10196d.equals(com_ushareit_listenit_dri.f10196d)) {
            return false;
        }
        return this.f10197e == null ? com_ushareit_listenit_dri.f10197e == null : this.f10197e.equals(com_ushareit_listenit_dri.f10197e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10196d == null ? 0 : this.f10196d.hashCode()) + (((this.f10195c == null ? 0 : this.f10195c.hashCode()) + (((this.f10194b == null ? 0 : this.f10194b.hashCode()) + (((this.f10193a == null ? 0 : this.f10193a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f10197e != null) {
            i = this.f10197e.hashCode();
        }
        return hashCode + i;
    }
}
