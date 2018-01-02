package com.ushareit.listenit;

import java.io.File;

public class aee<A, T, Z, R> implements aef<A, T, Z, R> {
    private final ze<A, T> f4194a;
    private final adb<Z, R> f4195b;
    private final aeb<T, Z> f4196c;

    public aee(ze<A, T> zeVar, adb<Z, R> com_ushareit_listenit_adb_Z__R, aeb<T, Z> com_ushareit_listenit_aeb_T__Z) {
        if (zeVar == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.f4194a = zeVar;
        if (com_ushareit_listenit_adb_Z__R == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.f4195b = com_ushareit_listenit_adb_Z__R;
        if (com_ushareit_listenit_aeb_T__Z == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.f4196c = com_ushareit_listenit_aeb_T__Z;
    }

    public ze<A, T> mo593e() {
        return this.f4194a;
    }

    public adb<Z, R> mo594f() {
        return this.f4195b;
    }

    public ux<File, Z> mo561a() {
        return this.f4196c.mo561a();
    }

    public ux<T, Z> mo562b() {
        return this.f4196c.mo562b();
    }

    public uu<T> mo563c() {
        return this.f4196c.mo563c();
    }

    public uy<Z> mo564d() {
        return this.f4196c.mo564d();
    }
}
