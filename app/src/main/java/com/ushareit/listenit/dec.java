package com.ushareit.listenit;

import java.lang.reflect.Field;

class dec extends dee {
    final dbq<?> f9656a = this.f9661f.m13970a(this.f9657b, this.f9658c, this.f9659d);
    final /* synthetic */ dao f9657b;
    final /* synthetic */ Field f9658c;
    final /* synthetic */ dft f9659d;
    final /* synthetic */ boolean f9660e;
    final /* synthetic */ deb f9661f;

    dec(deb com_ushareit_listenit_deb, String str, boolean z, boolean z2, dao com_ushareit_listenit_dao, Field field, dft com_ushareit_listenit_dft, boolean z3) {
        this.f9661f = com_ushareit_listenit_deb;
        this.f9657b = com_ushareit_listenit_dao;
        this.f9658c = field;
        this.f9659d = com_ushareit_listenit_dft;
        this.f9660e = z3;
        super(str, z, z2);
    }

    void mo1742a(dfu com_ushareit_listenit_dfu, Object obj) {
        Object b = this.f9656a.mo1401b(com_ushareit_listenit_dfu);
        if (b != null || !this.f9660e) {
            this.f9658c.set(obj, b);
        }
    }

    void mo1743a(dfx com_ushareit_listenit_dfx, Object obj) {
        new dej(this.f9657b, this.f9656a, this.f9659d.m14121b()).mo1400a(com_ushareit_listenit_dfx, this.f9658c.get(obj));
    }

    public boolean mo1744a(Object obj) {
        return this.h && this.f9658c.get(obj) != obj;
    }
}
