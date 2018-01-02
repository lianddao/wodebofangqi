package com.ushareit.listenit;

class fvh implements het {
    final /* synthetic */ fva f13575a;

    fvh(fva com_ushareit_listenit_fva) {
        this.f13575a = com_ushareit_listenit_fva;
    }

    public void a_(int i, int i2) {
        if (i != i2) {
            int i3 = i2 > i ? -1 : 1;
            int i4;
            int i5;
            if (this.f13575a.am.mo2565a() == 4) {
                glc com_ushareit_listenit_glc = (glc) this.f13575a.f13563g.m18899b(i);
                int i6 = ((glc) this.f13575a.f13563g.m18899b(i2)).f14284d;
                i4 = i2;
                while (i4 != i) {
                    i5 = i4 + i3;
                    glc com_ushareit_listenit_glc2 = (glc) this.f13575a.f13563g.m18899b(i4);
                    glc com_ushareit_listenit_glc3 = (glc) this.f13575a.f13563g.m18899b(i5);
                    frd.m20600a(com_ushareit_listenit_glc3.f14284d, com_ushareit_listenit_glc2.f14283c);
                    com_ushareit_listenit_glc2.f14284d = com_ushareit_listenit_glc3.f14284d;
                    i4 = i5;
                }
                frd.m20600a(i6, com_ushareit_listenit_glc.f14283c);
                com_ushareit_listenit_glc.f14284d = i6;
                fis.m19422a(this.f13575a.m1326l(), "UF_PlaylistSortList", "sortlist");
            } else if (this.f13575a.am.mo2565a() == 8) {
                String e = frd.m20621e(this.f13575a.al);
                if (!fbb.m18763c(e)) {
                    gld com_ushareit_listenit_gld = (gld) this.f13575a.f13561e.get(i);
                    int i7 = ((gld) this.f13575a.f13561e.get(i2)).f14293b;
                    i4 = i2;
                    while (i4 != i) {
                        i5 = i4 + i3;
                        gld com_ushareit_listenit_gld2 = (gld) this.f13575a.f13561e.get(i4);
                        gld com_ushareit_listenit_gld3 = (gld) this.f13575a.f13561e.get(i5);
                        frd.m20604a(e, com_ushareit_listenit_gld2.f14295d, com_ushareit_listenit_gld3.f14293b);
                        com_ushareit_listenit_gld2.f14293b = com_ushareit_listenit_gld3.f14293b;
                        i4 = i5;
                    }
                    frd.m20604a(e, com_ushareit_listenit_gld.f14295d, i7);
                    com_ushareit_listenit_gld.f14293b = i7;
                }
                this.f13575a.m21064a(i, i2);
                fis.m19422a(this.f13575a.m1326l(), "UF_PlaylistSortSong", "sortsong");
            }
            this.f13575a.f13563g.m18896a(i, i2);
            fis.m19420a(this.f13575a.m1326l(), this.f13575a.am.mo2565a());
            this.f13575a.ao = true;
        }
    }
}
