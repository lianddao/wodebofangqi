package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bpo extends bon {
    private static final int f7331a = btc.m9777e("payl");
    private static final int f7332b = btc.m9777e("sttg");
    private static final int f7333c = btc.m9777e("vttc");
    private final bss f7334d = new bss();
    private final bpt f7335e = new bpt();

    protected /* synthetic */ bop mo1077a(byte[] bArr, int i) {
        return m9413b(bArr, i);
    }

    public bpo() {
        super("Mp4WebvttDecoder");
    }

    protected bpp m9413b(byte[] bArr, int i) {
        this.f7334d.m9702a(bArr, i);
        List arrayList = new ArrayList();
        while (this.f7334d.m9704b() > 0) {
            if (this.f7334d.m9704b() < 8) {
                throw new bor("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int n = this.f7334d.m9720n();
            if (this.f7334d.m9720n() == f7333c) {
                arrayList.add(m9411a(this.f7334d, this.f7335e, n - 8));
            } else {
                this.f7334d.m9709d(n - 8);
            }
        }
        return new bpp(arrayList);
    }

    private static bom m9411a(bss com_ushareit_listenit_bss, bpt com_ushareit_listenit_bpt, int i) {
        com_ushareit_listenit_bpt.m9449a();
        while (i > 0) {
            if (i < 8) {
                throw new bor("Incomplete vtt cue box header found.");
            }
            int n = com_ushareit_listenit_bss.m9720n();
            int n2 = com_ushareit_listenit_bss.m9720n();
            int i2 = i - 8;
            n -= 8;
            String str = new String(com_ushareit_listenit_bss.f7639a, com_ushareit_listenit_bss.m9708d(), n);
            com_ushareit_listenit_bss.m9709d(n);
            i = i2 - n;
            if (n2 == f7332b) {
                bpu.m9460a(str, com_ushareit_listenit_bpt);
            } else if (n2 == f7331a) {
                bpu.m9462a(null, str.trim(), com_ushareit_listenit_bpt, Collections.emptyList());
            }
        }
        return com_ushareit_listenit_bpt.m9450b();
    }
}
