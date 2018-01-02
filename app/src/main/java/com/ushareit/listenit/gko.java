package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import com.ushareit.listenit.cutter.RingEditActivity;

class gko implements gop {
    final /* synthetic */ glg f14232a;
    final /* synthetic */ gkm f14233b;

    gko(gkm com_ushareit_listenit_gkm, glg com_ushareit_listenit_glg) {
        this.f14233b = com_ushareit_listenit_gkm;
        this.f14232a = com_ushareit_listenit_glg;
    }

    public boolean mo2508a(View view) {
        Intent intent = new Intent(this.f14233b.m20847s(), RingEditActivity.class);
        intent.putExtra("songId", this.f14232a.f14334b);
        this.f14233b.m20847s().startActivity(intent);
        fii.m19320f(eys.m18562a(), gyn.m23181a(this.f14233b.m20846r()));
        return false;
    }

    public boolean mo2509b(View view) {
        grz.m22656a().m22667b(this.f14232a.f14342j, 1);
        return false;
    }
}
