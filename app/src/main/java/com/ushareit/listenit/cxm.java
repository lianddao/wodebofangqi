package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class cxm implements cxn {
    private List<byte[]> f9311a = new ArrayList();
    private int f9312b = 0;

    cxm() {
    }

    public cya mo1662a() {
        byte[] bArr = new byte[this.f9312b];
        int i = 0;
        for (int i2 = 0; i2 < this.f9311a.size(); i2++) {
            byte[] bArr2 = (byte[]) this.f9311a.get(i2);
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            i += bArr2.length;
        }
        return new cya(bArr);
    }

    public boolean mo1663a(byte[] bArr) {
        this.f9311a.add(bArr);
        this.f9312b += bArr.length;
        return true;
    }
}
