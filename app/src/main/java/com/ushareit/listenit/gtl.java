package com.ushareit.listenit;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class gtl implements OnClickListener {
    final /* synthetic */ gta f14710a;

    gtl(gta com_ushareit_listenit_gta) {
        this.f14710a = com_ushareit_listenit_gta;
    }

    public void onClick(View view) {
        if (gyn.m23256m()) {
            this.f14710a.ax = true;
            fji com_ushareit_listenit_gua = new gua();
            Bundle bundle = new Bundle();
            bundle.putString("search_key", this.f14710a.an.getText().toString());
            com_ushareit_listenit_gua.m1317g(bundle);
            gyn.m23186a(this.f14710a.m1326l(), com_ushareit_listenit_gua);
            fiv.m19445b(this.f14710a.m1326l(), view != null ? "button" : "list");
            return;
        }
        heb.m23596a((int) C0349R.string.sync_net_offline, 1).show();
    }
}
