package com.ushareit.listenit;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.ProductSettingsActivity;

public class gvh implements OnClickListener {
    final /* synthetic */ ProductSettingsActivity f14796a;

    public gvh(ProductSettingsActivity productSettingsActivity) {
        this.f14796a = productSettingsActivity;
    }

    public void onClick(View view) {
        try {
            Bundle bundle = new Bundle();
            String str = "";
            bundle.putString("msg", this.f14796a.m26072b("cfg_pd") + this.f14796a.m26072b("cfg_pd_wifi") + this.f14796a.m26072b("cfg_pd_mobile") + this.f14796a.m26072b("beyla_page_use") + this.f14796a.m26072b("beyla_event_use") + this.f14796a.m26072b("upgrade_flag") + this.f14796a.m26072b("upgrade_new_verson"));
            hje com_ushareit_listenit_gvi = new gvi(this);
            com_ushareit_listenit_gvi.m18411a(hjk.ONEBUTTON);
            com_ushareit_listenit_gvi.m1317g(bundle);
            com_ushareit_listenit_gvi.mo1295a(this.f14796a.m709f(), "info");
        } catch (Exception e) {
        }
    }
}
