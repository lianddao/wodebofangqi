package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;

public final class btg {
    public final List<byte[]> f7677a;
    public final int f7678b;

    public static btg m9787a(bss com_ushareit_listenit_bss) {
        try {
            int h;
            int i;
            int i2;
            com_ushareit_listenit_bss.m9709d(21);
            int g = com_ushareit_listenit_bss.m9713g() & 3;
            int g2 = com_ushareit_listenit_bss.m9713g();
            int d = com_ushareit_listenit_bss.m9708d();
            int i3 = 0;
            int i4 = 0;
            while (i3 < g2) {
                com_ushareit_listenit_bss.m9709d(1);
                h = com_ushareit_listenit_bss.m9714h();
                i = i4;
                for (i2 = 0; i2 < h; i2++) {
                    i4 = com_ushareit_listenit_bss.m9714h();
                    i += i4 + 4;
                    com_ushareit_listenit_bss.m9709d(i4);
                }
                i3++;
                i4 = i;
            }
            com_ushareit_listenit_bss.m9707c(d);
            Object obj = new byte[i4];
            i3 = 0;
            i2 = 0;
            while (i3 < g2) {
                com_ushareit_listenit_bss.m9709d(1);
                h = com_ushareit_listenit_bss.m9714h();
                i = i2;
                for (i2 = 0; i2 < h; i2++) {
                    int h2 = com_ushareit_listenit_bss.m9714h();
                    System.arraycopy(bso.f7618a, 0, obj, i, bso.f7618a.length);
                    i += bso.f7618a.length;
                    System.arraycopy(com_ushareit_listenit_bss.f7639a, com_ushareit_listenit_bss.m9708d(), obj, i, h2);
                    i += h2;
                    com_ushareit_listenit_bss.m9709d(h2);
                }
                i3++;
                i2 = i;
            }
            return new btg(i4 == 0 ? null : Collections.singletonList(obj), g + 1);
        } catch (Throwable e) {
            throw new bfw("Error parsing HEVC config", e);
        }
    }

    private btg(List<byte[]> list, int i) {
        this.f7677a = list;
        this.f7678b = i;
    }
}
