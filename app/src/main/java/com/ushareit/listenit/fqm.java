package com.ushareit.listenit;

import android.content.Context;
import java.io.File;

public class fqm {
    private static fqm f13234h = new fqm(eys.m18562a());
    private eyh f13235a;
    private eyh f13236b;
    private eyh f13237c;
    private eyh f13238d;
    private eyh f13239e;
    private eyh f13240f;
    private eyh f13241g;

    public static fqm m20393a() {
        return f13234h;
    }

    private fqm(Context context) {
        this.f13235a = fql.m20389b(context);
        m20394a(context);
    }

    public eyh m20396b() {
        exu.m18430a(this.f13236b);
        if (!this.f13236b.mo2328c()) {
            this.f13236b.mo2333h();
        }
        return this.f13236b;
    }

    public eyh m20397c() {
        exu.m18430a(this.f13237c);
        if (!this.f13237c.mo2328c()) {
            this.f13237c.mo2333h();
        }
        return this.f13237c;
    }

    public eyh m20398d() {
        exu.m18430a(this.f13238d);
        if (!this.f13238d.mo2328c()) {
            this.f13238d.mo2333h();
        }
        return this.f13238d;
    }

    public eyh m20399e() {
        exu.m18430a(this.f13239e);
        if (!this.f13239e.mo2328c()) {
            this.f13239e.mo2333h();
        }
        return this.f13239e;
    }

    public eyh m20400f() {
        exu.m18430a(this.f13240f);
        if (!this.f13240f.mo2328c()) {
            this.f13240f.mo2333h();
        }
        return this.f13240f;
    }

    public eyh m20401g() {
        exu.m18430a(this.f13241g);
        if (!this.f13241g.mo2328c()) {
            this.f13241g.mo2333h();
        }
        return this.f13241g;
    }

    private final void m20394a(Context context) {
        if (!this.f13235a.mo2328c()) {
            this.f13235a.mo2333h();
        }
        this.f13236b = eyh.m18488a(this.f13235a, "download/");
        if (!(this.f13236b == null || this.f13236b.mo2328c())) {
            this.f13236b.mo2333h();
        }
        this.f13237c = eyh.m18488a(this.f13235a, "albumart/");
        if (!(this.f13237c == null || this.f13237c.mo2328c())) {
            this.f13237c.mo2333h();
        }
        this.f13238d = eyh.m18488a(this.f13235a, "user/");
        if (!(this.f13238d == null || this.f13238d.mo2328c())) {
            this.f13238d.mo2333h();
        }
        m20395a(this.f13238d);
        this.f13239e = eyh.m18488a(this.f13235a, "lyrics/");
        if (!(this.f13239e == null || this.f13239e.mo2328c())) {
            this.f13239e.mo2333h();
        }
        m20395a(this.f13239e);
        this.f13240f = eyh.m18488a(this.f13235a, "clips/");
        if (!(this.f13240f == null || this.f13240f.mo2328c())) {
            this.f13240f.mo2333h();
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            this.f13241g = eyh.m18490a(externalCacheDir);
            return;
        }
        this.f13241g = eyh.m18488a(this.f13235a, ".cache/");
        if (!(this.f13241g == null || this.f13241g.mo2328c())) {
            this.f13241g.mo2333h();
        }
        m20395a(this.f13241g);
    }

    private static void m20395a(eyh com_ushareit_listenit_eyh) {
        eyh a = eyh.m18488a(com_ushareit_listenit_eyh, ".nomedia");
        if (a != null && !a.mo2328c()) {
            a.mo2334i();
        }
    }
}
