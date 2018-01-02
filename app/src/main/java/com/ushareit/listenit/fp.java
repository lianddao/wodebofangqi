package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;

class fp extends fl {
    private Context f13130a;
    private Uri f13131b;

    fp(fl flVar, Context context, Uri uri) {
        super(flVar);
        this.f13130a = context;
        this.f13131b = uri;
    }

    public fl mo2485a(String str, String str2) {
        Uri a = fn.m19957a(this.f13130a, this.f13131b, str, str2);
        return a != null ? new fp(this, this.f13130a, a) : null;
    }

    public fl mo2484a(String str) {
        Uri a = fn.m19956a(this.f13130a, this.f13131b, str);
        return a != null ? new fp(this, this.f13130a, a) : null;
    }

    public Uri mo2483a() {
        return this.f13131b;
    }

    public String mo2486b() {
        return fm.m19858b(this.f13130a, this.f13131b);
    }

    public long mo2488d() {
        return fm.m19859c(this.f13130a, this.f13131b);
    }

    public boolean mo2489e() {
        return fm.m19860d(this.f13130a, this.f13131b);
    }

    public boolean mo2490f() {
        return fm.m19861e(this.f13130a, this.f13131b);
    }

    public boolean mo2491g() {
        return fm.m19862f(this.f13130a, this.f13131b);
    }

    public boolean mo2492h() {
        return fm.m19863g(this.f13130a, this.f13131b);
    }

    public fl[] mo2493i() {
        Uri[] a = fn.m19960a(this.f13130a, this.f13131b);
        fl[] flVarArr = new fl[a.length];
        for (int i = 0; i < a.length; i++) {
            flVarArr[i] = new fp(this, this.f13130a, a[i]);
        }
        return flVarArr;
    }

    public boolean mo2487c(String str) {
        Uri b = fn.m19961b(this.f13130a, this.f13131b, str);
        if (b == null) {
            return false;
        }
        this.f13131b = b;
        return true;
    }
}
