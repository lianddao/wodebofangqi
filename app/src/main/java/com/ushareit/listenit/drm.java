package com.ushareit.listenit;

public final class drm extends dgi {
    private static volatile drm[] f10206d;
    public String f10207a;
    public Boolean f10208b;
    public Boolean f10209c;

    public drm() {
        m15350c();
    }

    public static drm[] m15345a() {
        if (f10206d == null) {
            synchronized (dgg.f9776c) {
                if (f10206d == null) {
                    f10206d = new drm[0];
                }
            }
        }
        return f10206d;
    }

    public drm m15346a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.f10207a = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case 16:
                    this.f10208b = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
                    continue;
                case 24:
                    this.f10209c = Boolean.valueOf(com_ushareit_listenit_dfz.m14142i());
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
        if (this.f10207a != null) {
            com_ushareit_listenit_dga.m14197a(1, this.f10207a);
        }
        if (this.f10208b != null) {
            com_ushareit_listenit_dga.m14198a(2, this.f10208b.booleanValue());
        }
        if (this.f10209c != null) {
            com_ushareit_listenit_dga.m14198a(3, this.f10209c.booleanValue());
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f10207a != null) {
            b += dga.m14169b(1, this.f10207a);
        }
        if (this.f10208b != null) {
            b += dga.m14170b(2, this.f10208b.booleanValue());
        }
        return this.f10209c != null ? b + dga.m14170b(3, this.f10209c.booleanValue()) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m15346a(com_ushareit_listenit_dfz);
    }

    public drm m15350c() {
        this.f10207a = null;
        this.f10208b = null;
        this.f10209c = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof drm)) {
            return false;
        }
        drm com_ushareit_listenit_drm = (drm) obj;
        if (this.f10207a == null) {
            if (com_ushareit_listenit_drm.f10207a != null) {
                return false;
            }
        } else if (!this.f10207a.equals(com_ushareit_listenit_drm.f10207a)) {
            return false;
        }
        if (this.f10208b == null) {
            if (com_ushareit_listenit_drm.f10208b != null) {
                return false;
            }
        } else if (!this.f10208b.equals(com_ushareit_listenit_drm.f10208b)) {
            return false;
        }
        return this.f10209c == null ? com_ushareit_listenit_drm.f10209c == null : this.f10209c.equals(com_ushareit_listenit_drm.f10209c);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f10208b == null ? 0 : this.f10208b.hashCode()) + (((this.f10207a == null ? 0 : this.f10207a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f10209c != null) {
            i = this.f10209c.hashCode();
        }
        return hashCode + i;
    }
}
