package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

final class bmg {
    private final bii f7052a;

    public bmg(bii com_ushareit_listenit_bii) {
        this.f7052a = com_ushareit_listenit_bii;
        com_ushareit_listenit_bii.mo975a(Format.m2069a(null, "application/cea-608", null, -1, 0, null, null));
    }

    public void m9030a(long j, bss com_ushareit_listenit_bss) {
        while (com_ushareit_listenit_bss.m9704b() > 1) {
            int g;
            int i = 0;
            do {
                g = com_ushareit_listenit_bss.m9713g();
                i += g;
            } while (g == 255);
            g = 0;
            while (true) {
                int g2 = com_ushareit_listenit_bss.m9713g();
                int i2 = g + g2;
                if (g2 != 255) {
                    break;
                }
                g = i2;
            }
            if (boy.m9300a(i, i2, com_ushareit_listenit_bss)) {
                com_ushareit_listenit_bss.m9709d(8);
                int g3 = com_ushareit_listenit_bss.m9713g() & 31;
                com_ushareit_listenit_bss.m9709d(1);
                int i3 = 0;
                for (i = 0; i < g3; i++) {
                    if ((com_ushareit_listenit_bss.m9712f() & 7) != 4) {
                        com_ushareit_listenit_bss.m9709d(3);
                    } else {
                        i3 += 3;
                        this.f7052a.mo976a(com_ushareit_listenit_bss, 3);
                    }
                }
                this.f7052a.mo974a(j, 1, i3, 0, null);
                com_ushareit_listenit_bss.m9709d(i2 - ((g3 * 3) + 10));
            } else {
                com_ushareit_listenit_bss.m9709d(i2);
            }
        }
    }
}
