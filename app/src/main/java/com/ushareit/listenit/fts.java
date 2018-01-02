package com.ushareit.listenit;

import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class fts extends epm {
    final /* synthetic */ ftl f13496a;
    private boolean f13497b;
    private ImageView f13498c;

    public fts(ftl com_ushareit_listenit_ftl, boolean z, ImageView imageView) {
        this.f13496a = com_ushareit_listenit_ftl;
        this.f13497b = z;
        this.f13498c = imageView;
    }

    public void mo2229a(epk com_ushareit_listenit_epk) {
        if (this.f13496a.aj.getWidth() > 500) {
            gxm.m23094a(this.f13496a.aj, "YoutubePlayerFragmentBlurTask", 0, 500, 200, this.f13496a.at);
        } else {
            gxm.m23096a(this.f13496a.aj, "YoutubePlayerFragmentBlurTask", 0, this.f13496a.at);
        }
    }

    public void mo2230b(epk com_ushareit_listenit_epk) {
        exw.m18454c("Video Player", "enter animation end");
        if (((Boolean) eyw.m18568a(this.f13496a.m1328m()).first).booleanValue()) {
            this.f13496a.ao.setVisibility(0);
            this.f13496a.ao.bringToFront();
            LayoutParams layoutParams = (LayoutParams) this.f13496a.ao.getLayoutParams();
            layoutParams.height = (int) ((((double) gyr.m23306a()) * 9.0d) / 16.0d);
            this.f13496a.ao.setLayoutParams(layoutParams);
            this.f13496a.ap.setOnClickListener(new ftt(this));
            return;
        }
        m20976a();
    }

    private void m20976a() {
        this.f13496a.f13480b.removeView(this.f13498c);
        this.f13496a.f13479a.setVisibility(0);
        this.f13496a.m1328m().getWindow().addFlags(128);
        if (this.f13497b) {
            this.f13496a.f13479a.m27105a(this.f13496a.ak, this.f13496a.f13487i, this.f13496a.au);
            return;
        }
        this.f13496a.f13479a.m27104a(this.f13496a.ak, this.f13496a.f13487i);
        this.f13496a.f13479a.m27106a(this.f13496a.f13486h, 0.0f);
    }
}
