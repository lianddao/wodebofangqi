package com.ushareit.listenit;

class fmj extends faw {
    final /* synthetic */ glg f12988a;
    final /* synthetic */ fmc f12989b;

    fmj(fmc com_ushareit_listenit_fmc, String str, glg com_ushareit_listenit_glg) {
        this.f12989b = com_ushareit_listenit_fmc;
        this.f12988a = com_ushareit_listenit_glg;
        super(str);
    }

    public void mo2286a() {
        if (eyh.m18491a(this.f12988a.f14342j).mo2328c() && this.f12988a.f14352t <= 0) {
            this.f12989b.m19882e(this.f12988a);
            if (gnf.m22476a(this.f12988a.m22362h())) {
                exw.m18443a("SongFileUploader", "upload song success: name=" + this.f12988a.f14338f + ", md5=" + this.f12988a.m22362h());
                frf.m20673d(this.f12988a);
            }
        }
    }
}
