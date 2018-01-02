package com.ushareit.listenit;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import java.util.Collections;

final class bij extends bin {
    private static final int[] f6415b = new int[]{5500, 11000, 22000, 44000};
    private boolean f6416c;
    private boolean f6417d;

    public bij(bii com_ushareit_listenit_bii) {
        super(com_ushareit_listenit_bii);
    }

    protected boolean mo978a(bss com_ushareit_listenit_bss) {
        if (this.f6416c) {
            com_ushareit_listenit_bss.m9709d(1);
        } else {
            int g = com_ushareit_listenit_bss.m9713g();
            int i = (g >> 4) & 15;
            g = (g >> 2) & 3;
            if (g < 0 || g >= f6415b.length) {
                throw new bio("Invalid sample rate index: " + g);
            } else if (i != 10) {
                throw new bio("Audio format not supported: " + i);
            } else {
                this.f6416c = true;
            }
        }
        return true;
    }

    protected void mo977a(bss com_ushareit_listenit_bss, long j) {
        int g = com_ushareit_listenit_bss.m9713g();
        if (g == 0 && !this.f6417d) {
            Object obj = new byte[com_ushareit_listenit_bss.m9704b()];
            com_ushareit_listenit_bss.m9703a(obj, 0, obj.length);
            Pair a = bsh.m9660a(obj);
            this.a.mo975a(Format.m2068a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a.second).intValue(), ((Integer) a.first).intValue(), Collections.singletonList(obj), null, 0, null));
            this.f6417d = true;
        } else if (g == 1) {
            int b = com_ushareit_listenit_bss.m9704b();
            this.a.mo976a(com_ushareit_listenit_bss, b);
            this.a.mo974a(j, 1, b, 0, null);
        }
    }
}
