package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class fft extends esj {
    private static AtomicBoolean f12624g = new AtomicBoolean(false);

    public fft(esa com_ushareit_listenit_esa) {
        super(com_ushareit_listenit_esa);
    }

    public int mo2369a(ese com_ushareit_listenit_ese) {
        if (!m19131c()) {
            return 9004;
        }
        if (com_ushareit_listenit_ese == null || TextUtils.isEmpty(com_ushareit_listenit_ese.f11684a) || !com_ushareit_listenit_ese.f11684a.startsWith("admob")) {
            return 9003;
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void mo2370a(com.ushareit.listenit.ese r7, int r8) {
        /*
        r6 = this;
        r3 = 1;
        r1 = 0;
        r0 = f12624g;
        r0 = r0.compareAndSet(r1, r3);
        if (r0 == 0) goto L_0x0019;
    L_0x000a:
        r0 = r6.b;
        r0 = r0.m17691a();
        r0 = r0.getApplicationContext();
        r2 = "ca-app-pub-2075998924432436~9746449935";
        com.ushareit.listenit.bud.m9875a(r0, r2);
    L_0x0019:
        r0 = r7;
        r0 = (com.ushareit.listenit.ffl) r0;
        r4 = r0.f12605j;
        r2 = -1;
        r5 = r4.hashCode();
        switch(r5) {
            case 105: goto L_0x0034;
            case 110: goto L_0x002b;
            default: goto L_0x0026;
        };
    L_0x0026:
        r1 = r2;
    L_0x0027:
        switch(r1) {
            case 0: goto L_0x003e;
            case 1: goto L_0x004f;
            default: goto L_0x002a;
        };
    L_0x002a:
        return;
    L_0x002b:
        r3 = "n";
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x0026;
    L_0x0033:
        goto L_0x0027;
    L_0x0034:
        r1 = "i";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0026;
    L_0x003c:
        r1 = r3;
        goto L_0x0027;
    L_0x003e:
        r0 = r6.m19128c(r7);
        r1 = r6.m19124b();
        r0.m9840a(r1);
        r0 = r7.f11686c;
        com.ushareit.listenit.fie.m19255d(r0);
        goto L_0x002a;
    L_0x004f:
        r3 = new com.ushareit.listenit.buc;
        r1 = r6.b;
        r1 = r1.m17691a();
        r1 = r1.getApplicationContext();
        r3.<init>(r1);
        r0 = r0.c;
        r3.m9870a(r0);
        r0 = new com.ushareit.listenit.ffy;
        r4 = java.lang.System.currentTimeMillis();
        r1 = r6;
        r2 = r7;
        r0.<init>(r1, r2, r3, r4);
        r3.m9867a(r0);
        r0 = r6.m19124b();
        r3.m9868a(r0);
        r0 = r7.f11686c;
        com.ushareit.listenit.fie.m19260e(r0);
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.fft.a(com.ushareit.listenit.ese, int):void");
    }

    private btv m19128c(ese com_ushareit_listenit_ese) {
        btw com_ushareit_listenit_btw = new btw(this.b.m17691a(), com_ushareit_listenit_ese.f11686c);
        com_ushareit_listenit_btw.m9843a(new bus().m9908b(false).m9904a(2).m9905a(new buj().m9886a(false).m9885a()).m9906a(false).m9907b(0).m9903a());
        btu com_ushareit_listenit_ffz = new ffz(this, com_ushareit_listenit_ese, null, System.currentTimeMillis());
        long currentTimeMillis = System.currentTimeMillis();
        if ("admob".equals(com_ushareit_listenit_ese.f11684a) || "admobapp".equals(com_ushareit_listenit_ese.f11684a)) {
            com_ushareit_listenit_btw.m9844a(new ffu(this, com_ushareit_listenit_ffz, com_ushareit_listenit_ese, currentTimeMillis));
        }
        if ("admob".equals(com_ushareit_listenit_ese.f11684a) || "admobcon".equals(com_ushareit_listenit_ese.f11684a)) {
            com_ushareit_listenit_btw.m9845a(new ffw(this, com_ushareit_listenit_ffz, com_ushareit_listenit_ese, currentTimeMillis));
        }
        return com_ushareit_listenit_btw.m9842a(com_ushareit_listenit_ffz).m9841a();
    }

    private btx m19124b() {
        return new btz().m9848a();
    }

    private boolean m19131c() {
        return cdd.m10887a().mo1287a(eys.m18562a()) == 0;
    }
}
