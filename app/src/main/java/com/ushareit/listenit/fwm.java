package com.ushareit.listenit;

class fwm implements goj {
    final /* synthetic */ fwl f13629a;

    fwm(fwl com_ushareit_listenit_fwl) {
        this.f13629a = com_ushareit_listenit_fwl;
    }

    public void mo2612a() {
        fqx.m20493a(this.f13629a.f13628a.ao.m20816e());
        if (this.f13629a.f13628a.f13620h != null) {
            this.f13629a.f13628a.f13620h.setText(this.f13629a.f13628a.m1275a((int) C0349R.string.lyric_saved_toast));
            this.f13629a.f13628a.f13620h.setEnabled(false);
            this.f13629a.f13628a.f13620h.setClickable(false);
            this.f13629a.f13628a.f13620h.postDelayed(new fwn(this), 1000);
        } else if (fqx.m20495a(this.f13629a.f13628a.ao.m20816e().mo2562c(), this.f13629a.f13628a.ao.mo2565a())) {
            fqx.m20496b();
        }
    }
}
