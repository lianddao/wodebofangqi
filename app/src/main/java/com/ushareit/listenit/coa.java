package com.ushareit.listenit;

import java.util.Iterator;

class coa implements Iterable<coc> {
    private long f8535a;
    private final int f8536b;

    public coa(int i) {
        int i2 = i + 1;
        this.f8536b = (int) Math.floor(Math.log((double) i2) / Math.log(2.0d));
        this.f8535a = ((long) i2) & (((long) Math.pow(2.0d, (double) this.f8536b)) - 1);
    }

    public Iterator<coc> iterator() {
        return new cob(this);
    }
}
