package com.ushareit.listenit;

import android.os.Build.VERSION;

public class nn {
    private static final nq f16040a;
    private final Object f16041b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f16040a = new nr();
        } else if (VERSION.SDK_INT >= 15) {
            f16040a = new np();
        } else if (VERSION.SDK_INT >= 14) {
            f16040a = new no();
        } else {
            f16040a = new ns();
        }
    }

    @Deprecated
    public nn(Object obj) {
        this.f16041b = obj;
    }

    public void m25229a(boolean z) {
        f16040a.mo2952a(this.f16041b, z);
    }

    public void m25228a(int i) {
        f16040a.mo2953b(this.f16041b, i);
    }

    public void m25230b(int i) {
        f16040a.mo2951a(this.f16041b, i);
    }

    public void m25231c(int i) {
        f16040a.mo2956e(this.f16041b, i);
    }

    public void m25232d(int i) {
        f16040a.mo2954c(this.f16041b, i);
    }

    public void m25233e(int i) {
        f16040a.mo2955d(this.f16041b, i);
    }

    public void m25234f(int i) {
        f16040a.mo2957f(this.f16041b, i);
    }

    public void m25235g(int i) {
        f16040a.mo2958g(this.f16041b, i);
    }

    public int hashCode() {
        return this.f16041b == null ? 0 : this.f16041b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        nn nnVar = (nn) obj;
        if (this.f16041b == null) {
            if (nnVar.f16041b != null) {
                return false;
            }
            return true;
        } else if (this.f16041b.equals(nnVar.f16041b)) {
            return true;
        } else {
            return false;
        }
    }
}
