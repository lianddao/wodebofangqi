package com.ushareit.listenit;

import android.app.Activity;
import android.location.Geocoder;
import com.umeng.analytics.C0154a;

public class gbe {
    private static gbe f13849b;
    private static long f13850c = 0;
    private gaz f13851a;
    private gbd f13852d = new gbf(this);

    private gbe() {
    }

    public static gbe m21585a() {
        if (f13849b == null) {
            f13849b = new gbe();
        }
        return f13849b;
    }

    public void m21587a(Activity activity) {
        if (!gef.m21805a().m21838h() || !gyn.m23254l()) {
            return;
        }
        if ((fbb.m18763c(gvj.al(eys.m18562a())) || (Geocoder.isPresent() && fbb.m18763c(gvj.aw(eys.m18562a())))) && System.currentTimeMillis() - gvj.an(eys.m18562a()) >= C0154a.f2953i && gvj.ap(eys.m18562a()) <= 15) {
            try {
                f13850c = System.currentTimeMillis();
                this.f13851a = new gaz(new gay());
                this.f13851a.m21566a(activity);
                this.f13851a.m21567a(this.f13852d);
                this.f13851a.m21570b();
                gvj.m22998l(eys.m18562a(), System.currentTimeMillis());
                gvj.ao(eys.m18562a());
            } catch (Throwable th) {
                exw.m18457e("LocationRequster", "requestLocation error, " + exw.m18438a(th));
            }
        }
    }

    public void m21588b() {
        if (this.f13851a != null) {
            this.f13851a.m21569a();
        }
    }
}
