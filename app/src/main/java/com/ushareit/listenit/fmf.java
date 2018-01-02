package com.ushareit.listenit;

import java.util.List;

class fmf extends fay {
    List<glg> f12981a;
    final /* synthetic */ fmc f12982b;

    fmf(fmc com_ushareit_listenit_fmc) {
        this.f12982b = com_ushareit_listenit_fmc;
    }

    public void mo2280a() {
        this.f12981a = this.f12982b.m19885k();
    }

    public void mo2281a(Exception exception) {
        if (!this.f12982b.f12976g && this.f12981a != null) {
            exw.m18443a("SongFileUploader", "asyncUploadAllSongs: size=" + this.f12981a.size());
            for (glg a : this.f12981a) {
                this.f12982b.m19878c(a);
            }
            if (this.f12982b.f12974e != null && this.f12982b.m19817i() == 0) {
                this.f12982b.f12976g = true;
                this.f12982b.f12974e.m19586b(System.currentTimeMillis());
            }
        }
    }
}
