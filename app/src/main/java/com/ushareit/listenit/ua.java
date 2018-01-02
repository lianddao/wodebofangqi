package com.ushareit.listenit;

public final class ua {
    final /* synthetic */ tz f16852a;
    private final A f16853b;
    private final Class<A> f16854c;
    private final boolean f16855d = true;

    ua(tz tzVar, A a) {
        this.f16852a = tzVar;
        this.f16853b = a;
        this.f16854c = tw.m26476c((Object) a);
    }

    public <Z> ts<A, T, Z> m26494a(Class<Z> cls) {
        ts<A, T, Z> tsVar = (ts) this.f16852a.f16849a.f16845f.m26495a(new ts(this.f16852a.f16849a.f16840a, this.f16852a.f16849a.f16844e, this.f16854c, this.f16852a.f16850b, this.f16852a.f16851c, cls, this.f16852a.f16849a.f16843d, this.f16852a.f16849a.f16841b, this.f16852a.f16849a.f16845f));
        if (this.f16855d) {
            tsVar.mo3079b(this.f16853b);
        }
        return tsVar;
    }
}
