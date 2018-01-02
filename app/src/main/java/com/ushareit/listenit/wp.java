package com.ushareit.listenit;

import android.graphics.Bitmap.Config;

class wp implements xb {
    private final wq f17486a;
    private int f17487b;
    private int f17488c;
    private Config f17489d;

    public wp(wq wqVar) {
        this.f17486a = wqVar;
    }

    public void m27133a(int i, int i2, Config config) {
        this.f17487b = i;
        this.f17488c = i2;
        this.f17489d = config;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof wp)) {
            return false;
        }
        wp wpVar = (wp) obj;
        if (this.f17487b == wpVar.f17487b && this.f17488c == wpVar.f17488c && this.f17489d == wpVar.f17489d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f17489d != null ? this.f17489d.hashCode() : 0) + (((this.f17487b * 31) + this.f17488c) * 31);
    }

    public String toString() {
        return wo.m27123d(this.f17487b, this.f17488c, this.f17489d);
    }

    public void mo3126a() {
        this.f17486a.m27134a(this);
    }
}
