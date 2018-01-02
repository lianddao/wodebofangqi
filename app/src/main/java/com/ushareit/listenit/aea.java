package com.ushareit.listenit;

import java.io.File;

public class aea<A, T, Z, R> implements aef<A, T, Z, R>, Cloneable {
    private final aef<A, T, Z, R> f4185a;
    private ux<File, Z> f4186b;
    private ux<T, Z> f4187c;
    private uy<Z> f4188d;
    private adb<Z, R> f4189e;
    private uu<T> f4190f;

    public /* synthetic */ Object clone() {
        return m5335g();
    }

    public aea(aef<A, T, Z, R> com_ushareit_listenit_aef_A__T__Z__R) {
        this.f4185a = com_ushareit_listenit_aef_A__T__Z__R;
    }

    public ze<A, T> mo593e() {
        return this.f4185a.mo593e();
    }

    public void m5329a(ux<T, Z> uxVar) {
        this.f4187c = uxVar;
    }

    public void m5328a(uu<T> uuVar) {
        this.f4190f = uuVar;
    }

    public ux<File, Z> mo561a() {
        if (this.f4186b != null) {
            return this.f4186b;
        }
        return this.f4185a.mo561a();
    }

    public ux<T, Z> mo562b() {
        if (this.f4187c != null) {
            return this.f4187c;
        }
        return this.f4185a.mo562b();
    }

    public uu<T> mo563c() {
        if (this.f4190f != null) {
            return this.f4190f;
        }
        return this.f4185a.mo563c();
    }

    public uy<Z> mo564d() {
        if (this.f4188d != null) {
            return this.f4188d;
        }
        return this.f4185a.mo564d();
    }

    public adb<Z, R> mo594f() {
        if (this.f4189e != null) {
            return this.f4189e;
        }
        return this.f4185a.mo594f();
    }

    public aea<A, T, Z, R> m5335g() {
        try {
            return (aea) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
