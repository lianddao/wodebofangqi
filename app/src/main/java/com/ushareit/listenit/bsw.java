package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class bsw {
    private static final Comparator<bsz> f7647a = new bsx();
    private static final Comparator<bsz> f7648b = new bsy();
    private final int f7649c;
    private final ArrayList<bsz> f7650d = new ArrayList();
    private final bsz[] f7651e = new bsz[5];
    private int f7652f = -1;
    private int f7653g;
    private int f7654h;
    private int f7655i;

    public bsw(int i) {
        this.f7649c = i;
    }

    public void m9746a(int i, float f) {
        int i2;
        bsz com_ushareit_listenit_bsz;
        m9743a();
        if (this.f7655i > 0) {
            bsz[] com_ushareit_listenit_bszArr = this.f7651e;
            i2 = this.f7655i - 1;
            this.f7655i = i2;
            com_ushareit_listenit_bsz = com_ushareit_listenit_bszArr[i2];
        } else {
            com_ushareit_listenit_bsz = new bsz();
        }
        i2 = this.f7653g;
        this.f7653g = i2 + 1;
        com_ushareit_listenit_bsz.f7656a = i2;
        com_ushareit_listenit_bsz.f7657b = i;
        com_ushareit_listenit_bsz.f7658c = f;
        this.f7650d.add(com_ushareit_listenit_bsz);
        this.f7654h += i;
        while (this.f7654h > this.f7649c) {
            i2 = this.f7654h - this.f7649c;
            com_ushareit_listenit_bsz = (bsz) this.f7650d.get(0);
            if (com_ushareit_listenit_bsz.f7657b <= i2) {
                this.f7654h -= com_ushareit_listenit_bsz.f7657b;
                this.f7650d.remove(0);
                if (this.f7655i < 5) {
                    bsz[] com_ushareit_listenit_bszArr2 = this.f7651e;
                    int i3 = this.f7655i;
                    this.f7655i = i3 + 1;
                    com_ushareit_listenit_bszArr2[i3] = com_ushareit_listenit_bsz;
                }
            } else {
                com_ushareit_listenit_bsz.f7657b -= i2;
                this.f7654h -= i2;
            }
        }
    }

    public float m9745a(float f) {
        m9744b();
        float f2 = f * ((float) this.f7654h);
        int i = 0;
        for (int i2 = 0; i2 < this.f7650d.size(); i2++) {
            bsz com_ushareit_listenit_bsz = (bsz) this.f7650d.get(i2);
            i += com_ushareit_listenit_bsz.f7657b;
            if (((float) i) >= f2) {
                return com_ushareit_listenit_bsz.f7658c;
            }
        }
        return this.f7650d.isEmpty() ? Float.NaN : ((bsz) this.f7650d.get(this.f7650d.size() - 1)).f7658c;
    }

    private void m9743a() {
        if (this.f7652f != 1) {
            Collections.sort(this.f7650d, f7647a);
            this.f7652f = 1;
        }
    }

    private void m9744b() {
        if (this.f7652f != 0) {
            Collections.sort(this.f7650d, f7648b);
            this.f7652f = 0;
        }
    }
}
