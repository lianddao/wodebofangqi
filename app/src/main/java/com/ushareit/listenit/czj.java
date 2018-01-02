package com.ushareit.listenit;

public final class czj extends dgc<czj> {
    public int f9412a;
    public boolean f9413b;

    public czj() {
        m13492a();
    }

    public czj m13492a() {
        this.f9412a = 0;
        this.f9413b = false;
        this.f = null;
        this.g = -1;
        return this;
    }

    public czj m13493a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f9412a = com_ushareit_listenit_dfz.m14140g();
                    continue;
                case 16:
                    this.f9413b = com_ushareit_listenit_dfz.m14142i();
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
        if (this.f9412a != 0) {
            com_ushareit_listenit_dga.m14194a(1, this.f9412a);
        }
        if (this.f9413b) {
            com_ushareit_listenit_dga.m14198a(2, this.f9413b);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (this.f9412a != 0) {
            b += dga.m14167b(1, this.f9412a);
        }
        return this.f9413b ? b + dga.m14170b(2, this.f9413b) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m13493a(com_ushareit_listenit_dfz);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof czj)) {
            return false;
        }
        czj com_ushareit_listenit_czj = (czj) obj;
        return (this.f9412a == com_ushareit_listenit_czj.f9412a && this.f9413b == com_ushareit_listenit_czj.f9413b) ? (this.f == null || this.f.m14234b()) ? com_ushareit_listenit_czj.f == null || com_ushareit_listenit_czj.f.m14234b() : this.f.equals(com_ushareit_listenit_czj.f) : false;
    }

    public int hashCode() {
        int hashCode = ((this.f9413b ? 1231 : 1237) + ((((getClass().getName().hashCode() + 527) * 31) + this.f9412a) * 31)) * 31;
        int hashCode2 = (this.f == null || this.f.m14234b()) ? 0 : this.f.hashCode();
        return hashCode2 + hashCode;
    }
}
