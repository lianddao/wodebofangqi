package com.ushareit.listenit;

import android.net.Uri;

final class bnv implements bsd {
    final /* synthetic */ bnq f7189a;
    private final Uri f7190b;
    private final brh f7191c;
    private final bnw f7192d;
    private final bsj f7193e;
    private final bie f7194f = new bie();
    private volatile boolean f7195g;
    private boolean f7196h = true;
    private long f7197i = -1;

    public bnv(bnq com_ushareit_listenit_bnq, Uri uri, brh com_ushareit_listenit_brh, bnw com_ushareit_listenit_bnw, bsj com_ushareit_listenit_bsj) {
        this.f7189a = com_ushareit_listenit_bnq;
        this.f7190b = (Uri) bsg.m9654a((Object) uri);
        this.f7191c = (brh) bsg.m9654a((Object) com_ushareit_listenit_brh);
        this.f7192d = (bnw) bsg.m9654a((Object) com_ushareit_listenit_bnw);
        this.f7193e = com_ushareit_listenit_bsj;
    }

    public void m9204a(long j) {
        this.f7194f.f6409a = j;
        this.f7196h = true;
    }

    public void mo1039a() {
        this.f7195g = true;
    }

    public boolean mo1040b() {
        return this.f7195g;
    }

    public void mo1041c() {
        Throwable th;
        bhz com_ushareit_listenit_bhz;
        Throwable th2;
        int i = 0;
        while (i == 0 && !this.f7195g) {
            int a;
            try {
                long j = this.f7194f.f6409a;
                this.f7197i = this.f7191c.mo1088a(new brk(this.f7190b, j, -1, btc.m9779g(this.f7190b.toString())));
                if (this.f7197i != -1) {
                    this.f7197i += j;
                }
                bhz com_ushareit_listenit_bhq = new bhq(this.f7191c, j, this.f7197i);
                try {
                    int i2;
                    bhy a2 = this.f7192d.m9207a(com_ushareit_listenit_bhq);
                    if (this.f7196h) {
                        a2.mo980a(j);
                        this.f7196h = false;
                    }
                    long j2 = j;
                    int i3 = i;
                    while (i3 == 0) {
                        try {
                            if (this.f7195g) {
                                break;
                            }
                            this.f7193e.m9670c();
                            a = a2.mo979a(com_ushareit_listenit_bhq, this.f7194f);
                            try {
                                if (com_ushareit_listenit_bhq.mo968c() > 1048576 + j2) {
                                    j2 = com_ushareit_listenit_bhq.mo968c();
                                    this.f7193e.m9669b();
                                    this.f7189a.f7169m.post(this.f7189a.f7168l);
                                    i3 = a;
                                } else {
                                    i3 = a;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                com_ushareit_listenit_bhz = com_ushareit_listenit_bhq;
                                th2 = th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            a = i3;
                            com_ushareit_listenit_bhz = com_ushareit_listenit_bhq;
                            th2 = th;
                        }
                    }
                    if (i3 == 1) {
                        i2 = 0;
                    } else {
                        if (com_ushareit_listenit_bhq != null) {
                            this.f7194f.f6409a = com_ushareit_listenit_bhq.mo968c();
                        }
                        i2 = i3;
                    }
                    this.f7191c.mo1089a();
                    i = i2;
                } catch (Throwable th32) {
                    a = i;
                    bhz com_ushareit_listenit_bhz2 = com_ushareit_listenit_bhq;
                    th2 = th32;
                    com_ushareit_listenit_bhz = com_ushareit_listenit_bhz2;
                }
            } catch (Throwable th5) {
                th2 = th5;
                com_ushareit_listenit_bhz = null;
                a = i;
            }
        }
        return;
        if (!(a == 1 || com_ushareit_listenit_bhz == null)) {
            this.f7194f.f6409a = com_ushareit_listenit_bhz.mo968c();
        }
        this.f7191c.mo1089a();
        throw th2;
    }
}
