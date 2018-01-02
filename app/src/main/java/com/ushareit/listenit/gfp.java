package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gfp implements OnClickListener {
    final /* synthetic */ gfo f14039a;

    gfp(gfo com_ushareit_listenit_gfo) {
        this.f14039a = com_ushareit_listenit_gfo;
    }

    public void onClick(View view) {
        String trim = this.f14039a.f14034e.getText().toString().trim();
        if (this.f14039a.f14036g.m21921a(trim, this.f14039a.f14035f, this.f14039a.f14034e)) {
            this.f14039a.f14037h.m24639r();
            gef.m21805a().m21825a(trim);
        }
    }
}
