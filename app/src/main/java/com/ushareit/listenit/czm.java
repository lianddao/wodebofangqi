package com.ushareit.listenit;

public final class czm extends dgc<czm> {
    private static volatile czm[] f9422d;
    public int f9423a;
    public long f9424b;
    public String f9425c;

    public czm() {
        m13513c();
    }

    public static czm[] m13508a() {
        if (f9422d == null) {
            synchronized (dgg.f9776c) {
                if (f9422d == null) {
                    f9422d = new czm[0];
                }
            }
        }
        return f9422d;
    }

    public czm m13509a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f9423a = com_ushareit_listenit_dfz.m14140g();
                    continue;
                case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                    this.f9424b = com_ushareit_listenit_dfz.m14141h();
                    continue;
                case 26:
                    this.f9425c = com_ushareit_listenit_dfz.m14143j();
                    continue;
                default:
                    if (!super.m13477a(com_ushareit_listenit_dfz, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void mo1666a(dga com_ushareit_listenit_dga) {
        if (this.f9423a != 0) {
            com_ushareit_listenit_dga.m14194a(1, this.f9423a);
        }
        if (this.f9424b != 0) {
            com_ushareit_listenit_dga.m14212c(2, this.f9424b);
        }
        if (!this.f9425c.equals("")) {
            com_ushareit_listenit_dga.m14197a(3, this.f9425c);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f9423a != 0) {
            b += dga.m14167b(1, this.f9423a);
        }
        if (this.f9424b != 0) {
            b += dga.m14182e(2, this.f9424b);
        }
        return !this.f9425c.equals("") ? b + dga.m14169b(3, this.f9425c) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m13509a(com_ushareit_listenit_dfz);
    }

    public czm m13513c() {
        this.f9423a = 0;
        this.f9424b = 0;
        this.f9425c = "";
        this.f = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof czm)) {
            return false;
        }
        czm com_ushareit_listenit_czm = (czm) obj;
        if (this.f9423a != com_ushareit_listenit_czm.f9423a || this.f9424b != com_ushareit_listenit_czm.f9424b) {
            return false;
        }
        if (this.f9425c == null) {
            if (com_ushareit_listenit_czm.f9425c != null) {
                return false;
            }
        } else if (!this.f9425c.equals(com_ushareit_listenit_czm.f9425c)) {
            return false;
        }
        return (this.f == null || this.f.m14234b()) ? com_ushareit_listenit_czm.f == null || com_ushareit_listenit_czm.f.m14234b() : this.f.equals(com_ushareit_listenit_czm.f);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f9425c == null ? 0 : this.f9425c.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.f9423a) * 31) + ((int) (this.f9424b ^ (this.f9424b >>> 32)))) * 31)) * 31;
        if (!(this.f == null || this.f.m14234b())) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
