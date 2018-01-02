package com.ushareit.listenit;

import com.ushareit.listenit.popupview.BasePopupView;

class fyl implements fyw {
    final /* synthetic */ fyi f13732a;

    fyl(fyi com_ushareit_listenit_fyi) {
        this.f13732a = com_ushareit_listenit_fyi;
    }

    public void mo2625a(BasePopupView basePopupView) {
        if (basePopupView == null) {
            this.f13732a.m21328V();
        } else if (this.f13732a.f13723c.getGravity() == basePopupView.getGravity() && this.f13732a.f13723c.getGravity() == 17) {
            this.f13732a.f13723c = basePopupView;
            this.f13732a.m21334a(basePopupView);
        } else {
            this.f13732a.m21330a(new fym(this, basePopupView));
        }
    }
}
