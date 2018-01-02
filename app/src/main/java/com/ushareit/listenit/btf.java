package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.List;

public final class btf {
    public final List<byte[]> f7672a;
    public final int f7673b;
    public final int f7674c;
    public final int f7675d;
    public final float f7676e;

    public static btf m9785a(bss com_ushareit_listenit_bss) {
        int i = -1;
        int i2 = 0;
        try {
            com_ushareit_listenit_bss.m9709d(4);
            int g = (com_ushareit_listenit_bss.m9713g() & 3) + 1;
            if (g == 3) {
                throw new IllegalStateException();
            }
            int i3;
            List arrayList = new ArrayList();
            int g2 = com_ushareit_listenit_bss.m9713g() & 31;
            for (i3 = 0; i3 < g2; i3++) {
                arrayList.add(m9786b(com_ushareit_listenit_bss));
            }
            i3 = com_ushareit_listenit_bss.m9713g();
            while (i2 < i3) {
                arrayList.add(m9786b(com_ushareit_listenit_bss));
                i2++;
            }
            float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            if (g2 > 0) {
                bsq a = bso.m9684a((byte[]) arrayList.get(0), g, ((byte[]) arrayList.get(0)).length);
                i3 = a.f7626b;
                i = a.f7627c;
                f = a.f7628d;
            } else {
                i3 = -1;
            }
            return new btf(arrayList, g, i3, i, f);
        } catch (Throwable e) {
            throw new bfw("Error parsing AVC config", e);
        }
    }

    private btf(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f7672a = list;
        this.f7673b = i;
        this.f7674c = i2;
        this.f7675d = i3;
        this.f7676e = f;
    }

    private static byte[] m9786b(bss com_ushareit_listenit_bss) {
        int h = com_ushareit_listenit_bss.m9714h();
        int d = com_ushareit_listenit_bss.m9708d();
        com_ushareit_listenit_bss.m9709d(h);
        return bsh.m9662a(com_ushareit_listenit_bss.f7639a, d, h);
    }
}
