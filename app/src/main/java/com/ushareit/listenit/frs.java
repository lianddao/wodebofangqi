package com.ushareit.listenit;

import java.io.File;
import java.util.List;

final class frs extends hhw {
    final /* synthetic */ File f13309a;
    final /* synthetic */ boolean f13310b;
    final /* synthetic */ frt f13311c;
    private List<fsc> f13312d;

    frs(File file, boolean z, frt com_ushareit_listenit_frt) {
        this.f13309a = file;
        this.f13310b = z;
        this.f13311c = com_ushareit_listenit_frt;
    }

    public void execute() {
        if (this.f13309a != null) {
            this.f13312d = frj.m20714b(this.f13309a, this.f13310b);
        }
    }

    public void callback() {
        if (this.f13312d == null || this.f13312d.size() <= 0) {
            if (this.f13311c != null) {
                this.f13311c.mo2551a();
            }
        } else if (this.f13311c != null) {
            this.f13311c.mo2552a(this.f13312d);
        }
    }
}
