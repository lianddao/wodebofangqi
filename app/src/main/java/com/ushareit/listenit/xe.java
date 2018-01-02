package com.ushareit.listenit;

import android.graphics.Bitmap.Config;

final class xe implements xb {
    private final xf f17526a;
    private int f17527b;
    private Config f17528c;

    public xe(xf xfVar) {
        this.f17526a = xfVar;
    }

    public void m27190a(int i, Config config) {
        this.f17527b = i;
        this.f17528c = config;
    }

    public void mo3126a() {
        this.f17526a.m27134a(this);
    }

    public String toString() {
        return xc.m27180b(this.f17527b, this.f17528c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof xe)) {
            return false;
        }
        xe xeVar = (xe) obj;
        if (this.f17527b != xeVar.f17527b) {
            return false;
        }
        if (this.f17528c == null) {
            if (xeVar.f17528c != null) {
                return false;
            }
        } else if (!this.f17528c.equals(xeVar.f17528c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f17528c != null ? this.f17528c.hashCode() : 0) + (this.f17527b * 31);
    }
}
