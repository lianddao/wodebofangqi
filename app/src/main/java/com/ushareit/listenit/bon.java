package com.ushareit.listenit;

import java.nio.ByteBuffer;

public abstract class bon extends bhh<bou, bov, bor> implements boq {
    private final String f7241a;

    protected abstract bop mo1077a(byte[] bArr, int i);

    protected /* synthetic */ bhf mo1059g() {
        return mo1061i();
    }

    protected /* synthetic */ bhg mo1060h() {
        return mo1062j();
    }

    protected bon(String str) {
        super(new bou[2], new bov[2]);
        this.f7241a = str;
        m8411a(1024);
    }

    public void mo1057a(long j) {
    }

    protected final bou mo1061i() {
        return new bou();
    }

    protected final bov mo1062j() {
        return new boo(this);
    }

    protected final void m9249a(bov com_ushareit_listenit_bov) {
        super.mo1058a((bhg) com_ushareit_listenit_bov);
    }

    protected final bor m9245a(bou com_ushareit_listenit_bou, bov com_ushareit_listenit_bov, boolean z) {
        try {
            ByteBuffer byteBuffer = com_ushareit_listenit_bou.b;
            bop a = mo1077a(byteBuffer.array(), byteBuffer.limit());
            com_ushareit_listenit_bov.m9261a(com_ushareit_listenit_bou.c, a, com_ushareit_listenit_bou.f7246d);
            return null;
        } catch (bor e) {
            return e;
        }
    }
}
