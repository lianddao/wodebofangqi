package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class fxm implements OnItemClickListener {
    final /* synthetic */ fxh f13685a;

    fxm(fxh com_ushareit_listenit_fxh) {
        this.f13685a = com_ushareit_listenit_fxh;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch ((int) j) {
            case 1:
                gyn.m23186a(this.f13685a.m1326l(), new fze());
                fio.m19366a(this.f13685a.m1328m(), "all_songs");
                if (gvj.m22883V(eys.m18562a()) > 0) {
                    gvj.m22884W(this.f13685a.m1326l());
                }
                fii.m19313d();
                return;
            case 4:
                if (gef.m21805a().m21835e()) {
                    gyj.m23149b(this.f13685a.m1328m());
                    fio.m19366a(this.f13685a.m1328m(), "user_info");
                    return;
                }
                return;
            default:
                return;
        }
    }
}
