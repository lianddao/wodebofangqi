package com.ushareit.listenit;

public abstract class dgc<M extends dgc<M>> extends dgi {
    protected dge f9406f;

    public void mo1666a(dga com_ushareit_listenit_dga) {
        if (this.f9406f != null) {
            for (int i = 0; i < this.f9406f.m14230a(); i++) {
                this.f9406f.m14233b(i).m14238a(com_ushareit_listenit_dga);
            }
        }
    }

    protected final boolean m13477a(dfz com_ushareit_listenit_dfz, int i) {
        int r = com_ushareit_listenit_dfz.m14151r();
        if (!com_ushareit_listenit_dfz.m14131b(i)) {
            return false;
        }
        int b = dgl.m14264b(i);
        dgk com_ushareit_listenit_dgk = new dgk(i, com_ushareit_listenit_dfz.m14129a(r, com_ushareit_listenit_dfz.m14151r() - r));
        dgf com_ushareit_listenit_dgf = null;
        if (this.f9406f == null) {
            this.f9406f = new dge();
        } else {
            com_ushareit_listenit_dgf = this.f9406f.m14231a(b);
        }
        if (com_ushareit_listenit_dgf == null) {
            com_ushareit_listenit_dgf = new dgf();
            this.f9406f.m14232a(b, com_ushareit_listenit_dgf);
        }
        com_ushareit_listenit_dgf.m14239a(com_ushareit_listenit_dgk);
        return true;
    }

    protected int mo1667b() {
        int i = 0;
        if (this.f9406f == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f9406f.m14230a()) {
            i2 += this.f9406f.m14233b(i).m14237a();
            i++;
        }
        return i2;
    }

    public /* synthetic */ Object clone() {
        return m13479d();
    }

    public M m13479d() {
        dgc com_ushareit_listenit_dgc = (dgc) super.mo1669e();
        dgg.m14243a(this, com_ushareit_listenit_dgc);
        return com_ushareit_listenit_dgc;
    }

    public /* synthetic */ dgi mo1669e() {
        return (dgc) clone();
    }
}
