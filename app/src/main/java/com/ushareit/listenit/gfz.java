package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gfz implements OnClickListener {
    final /* synthetic */ gfx f14059a;

    gfz(gfx com_ushareit_listenit_gfx) {
        this.f14059a = com_ushareit_listenit_gfx;
    }

    public void onClick(View view) {
        String trim = this.f14059a.f14052d.getText().toString().trim();
        String obj = this.f14059a.aj.getText().toString();
        String obj2 = this.f14059a.ak.getText().toString();
        boolean a = this.f14059a.f14057i.m21920a(obj2, this.f14059a.f14055g);
        boolean a2 = this.f14059a.f14057i.m21919a(obj);
        if (a2) {
            this.f14059a.aa();
        } else {
            this.f14059a.m21902Z();
        }
        if (a && a2) {
            this.f14059a.al.m24639r();
            gef.m21805a().m21828a(trim, obj, obj2, this.f14059a.ap);
        }
    }
}
