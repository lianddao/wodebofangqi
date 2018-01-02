package com.ushareit.listenit;

import java.util.Arrays;

public final class bok {
    public final int f7223a;
    private final boj[] f7224b;
    private int f7225c;

    public bok(boj... com_ushareit_listenit_bojArr) {
        this.f7224b = com_ushareit_listenit_bojArr;
        this.f7223a = com_ushareit_listenit_bojArr.length;
    }

    public boj m9239a(int i) {
        return this.f7224b[i];
    }

    public int m9238a(boj com_ushareit_listenit_boj) {
        for (int i = 0; i < this.f7223a; i++) {
            if (this.f7224b[i] == com_ushareit_listenit_boj) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f7225c == 0) {
            this.f7225c = Arrays.hashCode(this.f7224b);
        }
        return this.f7225c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bok com_ushareit_listenit_bok = (bok) obj;
        if (this.f7223a == com_ushareit_listenit_bok.f7223a && Arrays.equals(this.f7224b, com_ushareit_listenit_bok.f7224b)) {
            return true;
        }
        return false;
    }
}
