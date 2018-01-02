package com.ushareit.listenit;

import android.net.Uri;
import android.os.Handler;

public final class bny implements bod, boe {
    private final Uri f7203a;
    private final bri f7204b;
    private final bib f7205c;
    private final int f7206d;
    private final Handler f7207e;
    private final bnz f7208f;
    private final bge f7209g;
    private boe f7210h;
    private bgd f7211i;
    private boolean f7212j;

    public bny(Uri uri, bri com_ushareit_listenit_bri, bib com_ushareit_listenit_bib, Handler handler, bnz com_ushareit_listenit_bnz) {
        this(uri, com_ushareit_listenit_bri, com_ushareit_listenit_bib, -1, handler, com_ushareit_listenit_bnz);
    }

    public bny(Uri uri, bri com_ushareit_listenit_bri, bib com_ushareit_listenit_bib, int i, Handler handler, bnz com_ushareit_listenit_bnz) {
        this.f7203a = uri;
        this.f7204b = com_ushareit_listenit_bri;
        this.f7205c = com_ushareit_listenit_bib;
        this.f7206d = i;
        this.f7207e = handler;
        this.f7208f = com_ushareit_listenit_bnz;
        this.f7209g = new bge();
    }

    public void mo1049a(boe com_ushareit_listenit_boe) {
        this.f7210h = com_ushareit_listenit_boe;
        this.f7211i = new boi(-9223372036854775807L, false);
        com_ushareit_listenit_boe.mo907a(this.f7211i, null);
    }

    public void mo1047a() {
    }

    public bob mo1046a(int i, bra com_ushareit_listenit_bra, long j) {
        bsg.m9656a(i == 0);
        return new bnq(this.f7203a, this.f7204b.mo1099a(), this.f7205c.mo972a(), this.f7206d, this.f7207e, this.f7208f, this, com_ushareit_listenit_bra);
    }

    public void mo1048a(bob com_ushareit_listenit_bob) {
        ((bnq) com_ushareit_listenit_bob).m9191b();
    }

    public void mo1050b() {
        this.f7210h = null;
    }

    public void mo907a(bgd com_ushareit_listenit_bgd, Object obj) {
        boolean z = false;
        if (com_ushareit_listenit_bgd.m8212a(0, this.f7209g).m8219b() != -9223372036854775807L) {
            z = true;
        }
        if (!this.f7212j || z) {
            this.f7211i = com_ushareit_listenit_bgd;
            this.f7212j = z;
            this.f7210h.mo907a(this.f7211i, null);
        }
    }
}
