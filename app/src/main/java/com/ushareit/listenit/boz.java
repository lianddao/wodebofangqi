package com.ushareit.listenit;

import java.util.LinkedList;
import java.util.TreeSet;

abstract class boz implements boq {
    private final LinkedList<bou> f7258a = new LinkedList();
    private final LinkedList<bov> f7259b;
    private final TreeSet<bou> f7260c;
    private bou f7261d;
    private long f7262e;

    protected abstract void mo1071a(bou com_ushareit_listenit_bou);

    protected abstract boolean mo1073e();

    protected abstract bop mo1074f();

    public /* synthetic */ Object mo952a() {
        return mo1076h();
    }

    public /* synthetic */ void mo953a(Object obj) {
        mo1072b((bou) obj);
    }

    public /* synthetic */ Object mo954b() {
        return mo1075g();
    }

    public boz() {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            this.f7258a.add(new bou());
        }
        this.f7259b = new LinkedList();
        while (i < 2) {
            this.f7259b.add(new bpa(this));
            i++;
        }
        this.f7260c = new TreeSet();
    }

    public void mo1057a(long j) {
        this.f7262e = j;
    }

    public bou mo1076h() {
        bsg.m9658b(this.f7261d == null);
        if (this.f7258a.isEmpty()) {
            return null;
        }
        this.f7261d = (bou) this.f7258a.pollFirst();
        return this.f7261d;
    }

    public void mo1072b(bou com_ushareit_listenit_bou) {
        boolean z;
        boolean z2 = true;
        if (com_ushareit_listenit_bou != null) {
            z = true;
        } else {
            z = false;
        }
        bsg.m9656a(z);
        if (com_ushareit_listenit_bou != this.f7261d) {
            z2 = false;
        }
        bsg.m9656a(z2);
        this.f7260c.add(com_ushareit_listenit_bou);
        this.f7261d = null;
    }

    public bov mo1075g() {
        if (this.f7259b.isEmpty()) {
            return null;
        }
        while (!this.f7260c.isEmpty() && ((bou) this.f7260c.first()).c <= this.f7262e) {
            bou com_ushareit_listenit_bou = (bou) this.f7260c.pollFirst();
            if (com_ushareit_listenit_bou.m8384c()) {
                bov com_ushareit_listenit_bov = (bov) this.f7259b.pollFirst();
                com_ushareit_listenit_bov.m8382b(4);
                m9283c(com_ushareit_listenit_bou);
                return com_ushareit_listenit_bov;
            }
            mo1071a(com_ushareit_listenit_bou);
            if (mo1073e()) {
                bop f = mo1074f();
                if (!com_ushareit_listenit_bou.b_()) {
                    com_ushareit_listenit_bov = (bov) this.f7259b.pollFirst();
                    com_ushareit_listenit_bov.m9261a(com_ushareit_listenit_bou.c, f, 0);
                    m9283c(com_ushareit_listenit_bou);
                    return com_ushareit_listenit_bov;
                }
            }
            m9283c(com_ushareit_listenit_bou);
        }
        return null;
    }

    private void m9283c(bou com_ushareit_listenit_bou) {
        com_ushareit_listenit_bou.mo951a();
        this.f7258a.add(com_ushareit_listenit_bou);
    }

    protected void m9287a(bov com_ushareit_listenit_bov) {
        com_ushareit_listenit_bov.mo951a();
        this.f7259b.add(com_ushareit_listenit_bov);
    }

    public void mo955c() {
        this.f7262e = 0;
        while (!this.f7260c.isEmpty()) {
            m9283c((bou) this.f7260c.pollFirst());
        }
        if (this.f7261d != null) {
            m9283c(this.f7261d);
            this.f7261d = null;
        }
    }

    public void mo956d() {
    }
}
