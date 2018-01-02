package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import com.ushareit.listenit.cutter.RingEditActivity;

class gku implements gop {
    final /* synthetic */ glg f14240a;
    final /* synthetic */ gks f14241b;

    gku(gks com_ushareit_listenit_gks, glg com_ushareit_listenit_glg) {
        this.f14241b = com_ushareit_listenit_gks;
        this.f14240a = com_ushareit_listenit_glg;
    }

    public boolean mo2508a(View view) {
        Intent intent = new Intent(this.f14241b.m20847s(), RingEditActivity.class);
        intent.putExtra("songId", this.f14240a.f14334b);
        this.f14241b.m20847s().startActivity(intent);
        fii.m19320f(eys.m18562a(), gyn.m23181a(this.f14241b.m20846r()));
        return false;
    }

    public boolean mo2509b(View view) {
        grz.m22656a().m22667b(this.f14240a.f14342j, 1);
        return false;
    }
}
