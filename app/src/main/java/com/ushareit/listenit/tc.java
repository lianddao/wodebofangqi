package com.ushareit.listenit;

import android.view.View;

public abstract class tc extends sb {
    boolean f16347a = true;

    public abstract boolean mo3022a(sv svVar);

    public abstract boolean mo3023a(sv svVar, int i, int i2, int i3, int i4);

    public abstract boolean mo3024a(sv svVar, sv svVar2, int i, int i2, int i3, int i4);

    public abstract boolean mo3026b(sv svVar);

    public boolean mo3020g(sv svVar) {
        return !this.f16347a || svVar.m3235i();
    }

    public boolean mo3016a(sv svVar, se seVar, se seVar2) {
        int i = seVar.f16437a;
        int i2 = seVar.f16438b;
        View view = svVar.itemView;
        int left = seVar2 == null ? view.getLeft() : seVar2.f16437a;
        int top = seVar2 == null ? view.getTop() : seVar2.f16438b;
        if (svVar.m3238l() || (i == left && i2 == top)) {
            return mo3022a(svVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo3023a(svVar, i, i2, left, top);
    }

    public boolean mo3018b(sv svVar, se seVar, se seVar2) {
        if (seVar == null || (seVar.f16437a == seVar2.f16437a && seVar.f16438b == seVar2.f16438b)) {
            return mo3026b(svVar);
        }
        return mo3023a(svVar, seVar.f16437a, seVar.f16438b, seVar2.f16437a, seVar2.f16438b);
    }

    public boolean mo3019c(sv svVar, se seVar, se seVar2) {
        if (seVar.f16437a == seVar2.f16437a && seVar.f16438b == seVar2.f16438b) {
            m25862i(svVar);
            return false;
        }
        return mo3023a(svVar, seVar.f16437a, seVar.f16438b, seVar2.f16437a, seVar2.f16438b);
    }

    public boolean mo3017a(sv svVar, sv svVar2, se seVar, se seVar2) {
        int i;
        int i2;
        int i3 = seVar.f16437a;
        int i4 = seVar.f16438b;
        if (svVar2.m3229c()) {
            i = seVar.f16437a;
            i2 = seVar.f16438b;
        } else {
            i = seVar2.f16437a;
            i2 = seVar2.f16438b;
        }
        return mo3024a(svVar, svVar2, i3, i4, i, i2);
    }

    public final void m25861h(sv svVar) {
        m25868o(svVar);
        m25841e(svVar);
    }

    public final void m25862i(sv svVar) {
        m25872s(svVar);
        m25841e(svVar);
    }

    public final void m25863j(sv svVar) {
        m25870q(svVar);
        m25841e(svVar);
    }

    public final void m25848a(sv svVar, boolean z) {
        m25859d(svVar, z);
        m25841e(svVar);
    }

    public final void m25864k(sv svVar) {
        m25867n(svVar);
    }

    public final void m25865l(sv svVar) {
        m25871r(svVar);
    }

    public final void m25866m(sv svVar) {
        m25869p(svVar);
    }

    public final void m25854b(sv svVar, boolean z) {
        m25857c(svVar, z);
    }

    public void m25867n(sv svVar) {
    }

    public void m25868o(sv svVar) {
    }

    public void m25869p(sv svVar) {
    }

    public void m25870q(sv svVar) {
    }

    public void m25871r(sv svVar) {
    }

    public void m25872s(sv svVar) {
    }

    public void m25857c(sv svVar, boolean z) {
    }

    public void m25859d(sv svVar, boolean z) {
    }
}
