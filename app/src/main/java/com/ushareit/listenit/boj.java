package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.util.Arrays;

public final class boj {
    public final int f7220a;
    private final Format[] f7221b;
    private int f7222c;

    public boj(Format... formatArr) {
        bsg.m9658b(formatArr.length > 0);
        this.f7221b = formatArr;
        this.f7220a = formatArr.length;
    }

    public Format m9237a(int i) {
        return this.f7221b[i];
    }

    public int m9236a(Format format) {
        for (int i = 0; i < this.f7221b.length; i++) {
            if (format == this.f7221b[i]) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f7222c == 0) {
            this.f7222c = Arrays.hashCode(this.f7221b) + 527;
        }
        return this.f7222c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        boj com_ushareit_listenit_boj = (boj) obj;
        if (this.f7220a == com_ushareit_listenit_boj.f7220a && Arrays.equals(this.f7221b, com_ushareit_listenit_boj.f7221b)) {
            return true;
        }
        return false;
    }
}
