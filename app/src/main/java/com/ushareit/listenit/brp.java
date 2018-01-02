package com.ushareit.listenit;

import android.content.Context;

public final class brp implements bri {
    private final Context f7537a;
    private final bsf<? super brh> f7538b;
    private final bri f7539c;

    public /* synthetic */ brh mo1099a() {
        return m9604b();
    }

    public brp(Context context, String str, bsf<? super brh> com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh) {
        this(context, (bsf) com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh, new brr(str, com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh));
    }

    public brp(Context context, bsf<? super brh> com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh, bri com_ushareit_listenit_bri) {
        this.f7537a = context.getApplicationContext();
        this.f7538b = com_ushareit_listenit_bsf__super_com_ushareit_listenit_brh;
        this.f7539c = com_ushareit_listenit_bri;
    }

    public bro m9604b() {
        return new bro(this.f7537a, this.f7538b, this.f7539c.mo1099a());
    }
}
