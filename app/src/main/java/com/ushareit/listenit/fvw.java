package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fvw implements OnClickListener {
    final /* synthetic */ fvs f13606a;

    fvw(fvs com_ushareit_listenit_fvs) {
        this.f13606a = com_ushareit_listenit_fvs;
    }

    public void onClick(View view) {
        this.f13606a.aj = !this.f13606a.aj;
        gvj.m22924c(this.f13606a.m1326l(), this.f13606a.aj);
        if (this.f13606a.aj) {
            this.f13606a.f13596d.setSortOrderIcon(C0349R.drawable.timestamps_sort);
            this.f13606a.f13593a.m26827a(false);
            heb.m23597a(this.f13606a.m1329n().getString(C0349R.string.switch_by_timestamp), 0).show();
        } else {
            this.f13606a.f13596d.setSortOrderIcon(C0349R.drawable.music_name_sort);
            this.f13606a.f13593a.m26827a(true);
            heb.m23597a(this.f13606a.m1329n().getString(C0349R.string.switch_by_A_Z), 0).show();
        }
        this.f13606a.mo2550c();
    }
}
