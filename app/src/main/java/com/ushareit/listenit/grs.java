package com.ushareit.listenit;

import android.content.Context;

class grs extends gww {
    final /* synthetic */ boolean f14610a;
    final /* synthetic */ Context f14611b;
    final /* synthetic */ grr f14612c;

    grs(grr com_ushareit_listenit_grr, boolean z, Context context) {
        this.f14612c = com_ushareit_listenit_grr;
        this.f14610a = z;
        this.f14611b = context;
    }

    public void execute() {
        boolean z = true;
        this.f14612c.m22651g();
        if (this.f14610a) {
            int b = grz.m22656a().m22665b(this.f14611b);
            int o = gvj.m23013o(this.f14611b);
            int p = gvj.m23019p(this.f14611b);
            int g = fbb.m18768g(this.f14611b);
            if (b == o && g == p) {
                this.f14612c.f14603d.m22616d();
            } else {
                if (g != p) {
                    this.f14612c.f14608i = false;
                    if (this.f14612c.f14605f.m22603a()) {
                        z = false;
                    }
                    frf.m20652a(z);
                    this.f14612c.m22622a(this.f14611b);
                } else {
                    this.f14612c.f14608i = true;
                    this.f14612c.m22629b(this.f14611b);
                }
                gvj.m22948f(this.f14611b, g);
                gvj.m22940e(this.f14611b, b);
                gvj.m22858C(this.f14611b);
            }
        } else {
            if (!gvj.m23044y(eys.m18562a())) {
                if (this.f14612c.f14605f.m22603a()) {
                    z = false;
                }
                frf.m20652a(z);
            }
            gvj.m22858C(this.f14611b);
            this.f14612c.m22639e(this.f14611b);
            this.f14612c.m22622a(this.f14611b);
        }
        ghp.m22016a();
    }
}
