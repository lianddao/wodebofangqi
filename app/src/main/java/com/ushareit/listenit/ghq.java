package com.ushareit.listenit;

import java.io.File;

final class ghq extends hhw {
    final /* synthetic */ glg f14133a;
    final /* synthetic */ boolean f14134b;
    final /* synthetic */ ghs f14135c;
    private ggm f14136d = null;

    ghq(String str, glg com_ushareit_listenit_glg, boolean z, ghs com_ushareit_listenit_ghs) {
        this.f14133a = com_ushareit_listenit_glg;
        this.f14134b = z;
        this.f14135c = com_ushareit_listenit_ghs;
        super(str);
    }

    public void execute() {
        String a = ghp.m22023d(this.f14133a);
        if (fbb.m18763c(a) && this.f14134b) {
            a = ghp.m22024e(this.f14133a);
        }
        if (!fbb.m18763c(a) && !ghp.m22025f(this.f14133a)) {
            this.f14136d = ght.m22029a(new File(a), "UTF-8");
        }
    }

    public void callback() {
        if (this.f14135c != null && ghp.f14131b != null && ghp.f14131b.equals(this.f14133a)) {
            this.f14135c.mo2679a(this.f14136d);
        }
    }
}
