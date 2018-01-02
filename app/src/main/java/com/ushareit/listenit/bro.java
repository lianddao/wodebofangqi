package com.ushareit.listenit;

import android.content.Context;

public final class bro implements brh {
    private final brh f7532a;
    private final brh f7533b;
    private final brh f7534c;
    private final brh f7535d;
    private brh f7536e;

    public bro(Context context, bsf<? super brh> com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh, brh com_ushareit_listenit_brh) {
        this.f7532a = (brh) bsg.m9654a((Object) com_ushareit_listenit_brh);
        this.f7533b = new brs(com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh);
        this.f7534c = new brb(context, com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh);
        this.f7535d = new brf(context, com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh);
    }

    public long mo1088a(brk com_ushareit_listenit_brk) {
        bsg.m9658b(this.f7536e == null);
        String scheme = com_ushareit_listenit_brk.f7504a.getScheme();
        if (btc.m9769a(com_ushareit_listenit_brk.f7504a)) {
            if (com_ushareit_listenit_brk.f7504a.getPath().startsWith("/android_asset/")) {
                this.f7536e = this.f7534c;
            } else {
                this.f7536e = this.f7533b;
            }
        } else if ("asset".equals(scheme)) {
            this.f7536e = this.f7534c;
        } else if ("content".equals(scheme)) {
            this.f7536e = this.f7535d;
        } else {
            this.f7536e = this.f7532a;
        }
        return this.f7536e.mo1088a(com_ushareit_listenit_brk);
    }

    public int mo1087a(byte[] bArr, int i, int i2) {
        return this.f7536e.mo1087a(bArr, i, i2);
    }

    public void mo1089a() {
        if (this.f7536e != null) {
            try {
                this.f7536e.mo1089a();
            } finally {
                this.f7536e = null;
            }
        }
    }
}
