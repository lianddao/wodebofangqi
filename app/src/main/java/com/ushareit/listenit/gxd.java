package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.theme.ThemeSettingsActivity;

public class gxd implements OnClickListener {
    final /* synthetic */ ThemeSettingsActivity f14851a;

    public gxd(ThemeSettingsActivity themeSettingsActivity) {
        this.f14851a = themeSettingsActivity;
    }

    public void onClick(View view) {
        this.f14851a.f16610r.setVisibility(0);
        this.f14851a.f16613y.setColor(this.f14851a.f16598J);
        epk a = eqd.m17401a(this.f14851a.f16609q, "translationX", 0.0f, (float) (-this.f14851a.f16612t));
        epk a2 = eqd.m17401a(this.f14851a.f16610r, "translationX", (float) this.f14851a.f16612t, 0.0f);
        epn com_ushareit_listenit_epn = new epn();
        com_ushareit_listenit_epn.m17299b(500);
        com_ushareit_listenit_epn.m17296a(a).m17311a(a2);
        com_ushareit_listenit_epn.mo2234a();
    }
}
