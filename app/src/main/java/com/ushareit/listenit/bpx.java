package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class bpx extends bon {
    private final bpu f7376a = new bpu();
    private final bss f7377b = new bss();
    private final bpt f7378c = new bpt();
    private final bpn f7379d = new bpn();
    private final List<bpq> f7380e = new ArrayList();

    protected /* synthetic */ bop mo1077a(byte[] bArr, int i) {
        return m9477b(bArr, i);
    }

    public bpx() {
        super("WebvttDecoder");
    }

    protected bpz m9477b(byte[] bArr, int i) {
        this.f7377b.m9702a(bArr, i);
        this.f7378c.m9449a();
        this.f7380e.clear();
        bpy.m9479a(this.f7377b);
        do {
        } while (!TextUtils.isEmpty(this.f7377b.m9730x()));
        List arrayList = new ArrayList();
        while (true) {
            int a = m9474a(this.f7377b);
            if (a == 0) {
                return new bpz(arrayList);
            }
            if (a == 1) {
                m9475b(this.f7377b);
            } else if (a == 2) {
                if (arrayList.isEmpty()) {
                    this.f7377b.m9730x();
                    bpq a2 = this.f7379d.m9410a(this.f7377b);
                    if (a2 != null) {
                        this.f7380e.add(a2);
                    }
                } else {
                    throw new bor("A style block was found after the first cue.");
                }
            } else if (a == 3 && this.f7376a.m9470a(this.f7377b, this.f7378c, this.f7380e)) {
                arrayList.add(this.f7378c.m9450b());
                this.f7378c.m9449a();
            }
        }
    }

    private static int m9474a(bss com_ushareit_listenit_bss) {
        int i = 0;
        int i2 = -1;
        while (i2 == -1) {
            i2 = com_ushareit_listenit_bss.m9708d();
            String x = com_ushareit_listenit_bss.m9730x();
            if (x == null) {
                i = 0;
            } else if ("STYLE".equals(x)) {
                i = 2;
            } else if ("NOTE".startsWith(x)) {
                i = 1;
            } else {
                i = 3;
            }
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        com_ushareit_listenit_bss.m9707c(i);
        return i2;
    }

    private static void m9475b(bss com_ushareit_listenit_bss) {
        do {
        } while (!TextUtils.isEmpty(com_ushareit_listenit_bss.m9730x()));
    }
}
