package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class ggk implements OnClickListener {
    final /* synthetic */ ggj f14078a;

    ggk(ggj com_ushareit_listenit_ggj) {
        this.f14078a = com_ushareit_listenit_ggj;
    }

    public void onClick(View view) {
        this.f14078a.f14075f.m24639r();
        if (this.f14078a.f14076g.equals("Google")) {
            gef.m21805a().m21824a(this.f14078a.f14077h);
            gef.m21805a().m21822a(this.f14078a.m1328m());
            return;
        }
        gef.m21805a().m21824a(this.f14078a.f14077h);
        gef.m21805a().m21831b(this.f14078a.m1328m());
    }
}
