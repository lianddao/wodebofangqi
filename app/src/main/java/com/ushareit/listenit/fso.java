package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class fso implements OnClickListener {
    final /* synthetic */ fsn f13395a;

    fso(fsn com_ushareit_listenit_fsn) {
        this.f13395a = com_ushareit_listenit_fsn;
    }

    public void onClick(View view) {
        List b = gyn.m23210b(this.f13395a.f13393f.f13373l.f13341d);
        gyp.m23278a(b, (glg) b.get(this.f13395a.f13392e), 17, "");
        gyn.m23222c(this.f13395a.f13393f.f13372k);
        fii.m19311c(this.f13395a.f13393f.f13372k, gyn.m23181a(17) + "_" + "playone");
    }
}
