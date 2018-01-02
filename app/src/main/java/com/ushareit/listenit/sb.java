package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

public abstract class sb {
    private sd f16341a = null;
    private ArrayList<sc> f16342b = new ArrayList();
    private long f16343c = 120;
    private long f16344d = 120;
    private long f16345e = 250;
    private long f16346f = 250;

    public abstract void mo3021a();

    public abstract boolean mo3016a(sv svVar, se seVar, se seVar2);

    public abstract boolean mo3017a(sv svVar, sv svVar2, se seVar, se seVar2);

    public abstract boolean mo3025b();

    public abstract boolean mo3018b(sv svVar, se seVar, se seVar2);

    public abstract void mo3027c();

    public abstract void mo3028c(sv svVar);

    public abstract boolean mo3019c(sv svVar, se seVar, se seVar2);

    public long m25839d() {
        return this.f16345e;
    }

    public long m25840e() {
        return this.f16343c;
    }

    public long m25842f() {
        return this.f16344d;
    }

    public long m25844g() {
        return this.f16346f;
    }

    public void m25831a(sd sdVar) {
        this.f16341a = sdVar;
    }

    public se m25829a(ss ssVar, sv svVar, int i, List<Object> list) {
        return m25847i().m26036a(svVar);
    }

    public se m25828a(ss ssVar, sv svVar) {
        return m25847i().m26036a(svVar);
    }

    public static int m25827d(sv svVar) {
        int f = svVar.f2675k & 14;
        if (svVar.m3235i()) {
            return 4;
        }
        if ((f & 4) != 0) {
            return f;
        }
        int oldPosition = svVar.getOldPosition();
        int adapterPosition = svVar.getAdapterPosition();
        if (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) {
            return f;
        }
        return f | 2048;
    }

    public final void m25841e(sv svVar) {
        m25843f(svVar);
        if (this.f16341a != null) {
            this.f16341a.mo3062a(svVar);
        }
    }

    public void m25843f(sv svVar) {
    }

    public boolean mo3020g(sv svVar) {
        return true;
    }

    public final void m25846h() {
        int size = this.f16342b.size();
        for (int i = 0; i < size; i++) {
            ((sc) this.f16342b.get(i)).m26034a();
        }
        this.f16342b.clear();
    }

    public se m25847i() {
        return new se();
    }
}
