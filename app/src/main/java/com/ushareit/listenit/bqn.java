package com.ushareit.listenit;

import java.util.Arrays;

public final class bqn<T> {
    public final T f7437a;
    public final int f7438b;
    private final bql[] f7439c;
    private int f7440d;

    public bqn(T t, bql... com_ushareit_listenit_bqlArr) {
        this.f7437a = t;
        this.f7439c = com_ushareit_listenit_bqlArr;
        this.f7438b = com_ushareit_listenit_bqlArr.length;
    }

    public bql m9530a(int i) {
        return this.f7439c[i];
    }

    public bql[] m9531a() {
        return (bql[]) this.f7439c.clone();
    }

    public int hashCode() {
        if (this.f7440d == 0) {
            this.f7440d = Arrays.hashCode(this.f7439c) + 527;
        }
        return this.f7440d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f7439c, ((bqn) obj).f7439c);
    }
}
