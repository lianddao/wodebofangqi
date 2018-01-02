package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import com.ushareit.listenit.cutter.RingEditActivity;

class gqp implements gop {
    final /* synthetic */ glg f14564a;
    final /* synthetic */ gqo f14565b;

    gqp(gqo com_ushareit_listenit_gqo, glg com_ushareit_listenit_glg) {
        this.f14565b = com_ushareit_listenit_gqo;
        this.f14564a = com_ushareit_listenit_glg;
    }

    public boolean mo2508a(View view) {
        Intent intent = new Intent(this.f14565b.f14563a.getContext(), RingEditActivity.class);
        intent.putExtra("songId", this.f14564a.f14334b);
        this.f14565b.f14563a.getContext().startActivity(intent);
        return false;
    }

    public boolean mo2509b(View view) {
        grz.m22656a().m22667b(this.f14564a.f14342j, 1);
        fit.m19433b(this.f14565b.f14563a.getContext(), "setAsDefaultRingtone");
        return false;
    }
}
