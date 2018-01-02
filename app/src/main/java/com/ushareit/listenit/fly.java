package com.ushareit.listenit;

import android.util.Pair;

class fly extends faw {
    final /* synthetic */ boolean f12965a;
    final /* synthetic */ glg f12966b;
    final /* synthetic */ flw f12967c;

    fly(flw com_ushareit_listenit_flw, String str, boolean z, glg com_ushareit_listenit_glg) {
        this.f12967c = com_ushareit_listenit_flw;
        this.f12965a = z;
        this.f12966b = com_ushareit_listenit_glg;
        super(str);
    }

    public void mo2286a() {
        int f = fkb.m19610a().m19648f();
        Pair a = eyw.m18568a(eys.m18562a());
        boolean booleanValue = ((Boolean) a.first).booleanValue();
        boolean booleanValue2 = ((Boolean) a.second).booleanValue();
        if ((booleanValue || booleanValue2) && (!booleanValue || booleanValue2 || f == 2 || this.f12965a)) {
            String c = gyn.m23219c(this.f12966b);
            gnf.m22477a(this.f12966b.m22362h(), this.f12966b.f14344l, c, this.f12967c.f12962g);
            eyh a2 = eyh.m18491a(c);
            Object obj = (a2.mo2328c() && a2.mo2332g() == ((long) this.f12966b.f14344l)) ? 1 : null;
            if (obj != null) {
                this.f12966b.f14342j = c;
                return;
            } else if (this.f12967c.m19817i() > 0 && obj == null && !this.f12967c.f12958c.containsKey(this.f12966b)) {
                this.f12967c.f12958c.put(this.f12966b, eys.m18562a().getString(C0349R.string.sync_download_failure));
                return;
            } else {
                return;
            }
        }
        faq.m18735a(new flz(this));
    }
}
