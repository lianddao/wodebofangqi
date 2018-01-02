package com.ushareit.listenit;

import android.widget.ImageView;
import com.ushareit.listenit.main.MainActivity;

class ftu extends epm {
    final /* synthetic */ ftl f13500a;
    private ImageView f13501b;

    public ftu(ftl com_ushareit_listenit_ftl, ImageView imageView) {
        this.f13500a = com_ushareit_listenit_ftl;
        this.f13501b = imageView;
    }

    public void mo2229a(epk com_ushareit_listenit_epk) {
        exw.m18454c("Video Player", "exit animation start");
        this.f13500a.f13482d.setVisibility(4);
        this.f13500a.f13479a.setVisibility(4);
        erl.m17583a(this.f13500a.f13483e).mo2272a(140).mo2278e(0.0f);
        erl.m17583a(this.f13500a.f13481c).mo2272a(140).mo2278e(0.0f);
        erl.m17583a(this.f13500a.f13484f).mo2272a(140).mo2278e(0.0f);
        erl.m17583a(this.f13500a.f13485g).mo2272a(140).mo2278e(0.0f);
    }

    public void mo2230b(epk com_ushareit_listenit_epk) {
        exw.m18454c("Video Player", "exit animation end");
        this.f13500a.ar = false;
        if (this.f13500a.m1328m() != null) {
            ((MainActivity) this.f13500a.m1328m()).m24835p();
        }
        this.f13500a.f13480b.removeView(this.f13501b);
    }
}
