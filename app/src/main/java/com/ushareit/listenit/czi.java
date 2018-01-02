package com.ushareit.listenit;

import java.util.Arrays;

public final class czi extends dgc<czi> {
    private static volatile czi[] f9409c;
    public String f9410a;
    public byte[] f9411b;

    public czi() {
        m13491c();
    }

    public static czi[] m13486a() {
        if (f9409c == null) {
            synchronized (dgg.f9776c) {
                if (f9409c == null) {
                    f9409c = new czi[0];
                }
            }
        }
        return f9409c;
    }

    public czi m13487a(dfz com_ushareit_listenit_dfz) {
        while (true) {
            int a = com_ushareit_listenit_dfz.m14126a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.f9410a = com_ushareit_listenit_dfz.m14143j();
                    continue;
                case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                    this.f9411b = com_ushareit_listenit_dfz.m14144k();
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
        if (!this.f9410a.equals("")) {
            com_ushareit_listenit_dga.m14197a(1, this.f9410a);
        }
        if (!Arrays.equals(this.f9411b, dgl.f9786h)) {
            com_ushareit_listenit_dga.m14199a(2, this.f9411b);
        }
        super.mo1666a(com_ushareit_listenit_dga);
    }

    protected int mo1667b() {
        int b = super.mo1667b();
        if (!this.f9410a.equals("")) {
            b += dga.m14169b(1, this.f9410a);
        }
        return !Arrays.equals(this.f9411b, dgl.f9786h) ? b + dga.m14171b(2, this.f9411b) : b;
    }

    public /* synthetic */ dgi mo1670b(dfz com_ushareit_listenit_dfz) {
        return m13487a(com_ushareit_listenit_dfz);
    }

    public czi m13491c() {
        this.f9410a = "";
        this.f9411b = dgl.f9786h;
        this.f = null;
        this.g = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof czi)) {
            return false;
        }
        czi com_ushareit_listenit_czi = (czi) obj;
        if (this.f9410a == null) {
            if (com_ushareit_listenit_czi.f9410a != null) {
                return false;
            }
        } else if (!this.f9410a.equals(com_ushareit_listenit_czi.f9410a)) {
            return false;
        }
        return Arrays.equals(this.f9411b, com_ushareit_listenit_czi.f9411b) ? (this.f == null || this.f.m14234b()) ? com_ushareit_listenit_czi.f == null || com_ushareit_listenit_czi.f.m14234b() : this.f.equals(com_ushareit_listenit_czi.f) : false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f9410a == null ? 0 : this.f9410a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + Arrays.hashCode(this.f9411b)) * 31;
        if (!(this.f == null || this.f.m14234b())) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
