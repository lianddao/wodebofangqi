package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gft implements OnClickListener {
    final /* synthetic */ gfr f14048a;

    gft(gfr com_ushareit_listenit_gfr) {
        this.f14048a = com_ushareit_listenit_gfr;
    }

    public void onClick(View view) {
        String obj = this.f14048a.f14041d.getText().toString();
        String obj2 = this.f14048a.f14043f.getText().toString();
        if (this.f14048a.f14044g.m21922b(obj2, this.f14048a.f14045h)) {
            this.f14048a.aj.m24639r();
            gef.m21805a().m21827a(obj, obj2, this.f14048a.al);
        }
    }
}
