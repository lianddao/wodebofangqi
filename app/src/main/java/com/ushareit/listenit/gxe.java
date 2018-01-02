package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.theme.ThemeSettingsActivity;

public class gxe implements OnClickListener {
    final /* synthetic */ ThemeSettingsActivity f14852a;

    public gxe(ThemeSettingsActivity themeSettingsActivity) {
        this.f14852a = themeSettingsActivity;
    }

    public void onClick(View view) {
        if (this.f14852a.f16614z) {
            this.f14852a.m26303u();
            ((View) this.f14852a.f16607o.get(this.f14852a.f16607o.size() - 1)).setVisibility(0);
        }
        epk a = eqd.m17401a(this.f14852a.f16609q, "translationX", (float) (-this.f14852a.f16612t), 0.0f);
        epk a2 = eqd.m17401a(this.f14852a.f16610r, "translationX", 0.0f, (float) this.f14852a.f16612t);
        epn com_ushareit_listenit_epn = new epn();
        com_ushareit_listenit_epn.m17299b(500);
        com_ushareit_listenit_epn.m17296a(a).m17311a(a2);
        com_ushareit_listenit_epn.mo2234a();
    }
}
