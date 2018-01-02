package com.ushareit.listenit;

public final class bou extends bhf implements Comparable<bou> {
    public long f7246d;

    public /* synthetic */ int compareTo(Object obj) {
        return m9271a((bou) obj);
    }

    public bou() {
        super(1);
    }

    public int m9271a(bou com_ushareit_listenit_bou) {
        long j = this.c - com_ushareit_listenit_bou.c;
        if (j == 0) {
            return 0;
        }
        return j > 0 ? 1 : -1;
    }
}
