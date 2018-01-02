package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class bjj extends bji {
    public final long aN;
    public final List<bjk> aO = new ArrayList();
    public final List<bjj> aP = new ArrayList();

    public bjj(int i, long j) {
        super(i);
        this.aN = j;
    }

    public void m8704a(bjk com_ushareit_listenit_bjk) {
        this.aO.add(com_ushareit_listenit_bjk);
    }

    public void m8703a(bjj com_ushareit_listenit_bjj) {
        this.aP.add(com_ushareit_listenit_bjj);
    }

    public bjk m8705d(int i) {
        int size = this.aO.size();
        for (int i2 = 0; i2 < size; i2++) {
            bjk com_ushareit_listenit_bjk = (bjk) this.aO.get(i2);
            if (com_ushareit_listenit_bjk.aM == i) {
                return com_ushareit_listenit_bjk;
            }
        }
        return null;
    }

    public bjj m8706e(int i) {
        int size = this.aP.size();
        for (int i2 = 0; i2 < size; i2++) {
            bjj com_ushareit_listenit_bjj = (bjj) this.aP.get(i2);
            if (com_ushareit_listenit_bjj.aM == i) {
                return com_ushareit_listenit_bjj;
            }
        }
        return null;
    }

    public String toString() {
        return bji.m8702c(this.aM) + " leaves: " + Arrays.toString(this.aO.toArray()) + " containers: " + Arrays.toString(this.aP.toArray());
    }
}
