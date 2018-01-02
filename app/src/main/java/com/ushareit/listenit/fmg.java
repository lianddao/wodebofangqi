package com.ushareit.listenit;

import java.util.List;

class fmg extends fay {
    List<glg> f12983a;
    final /* synthetic */ fmc f12984b;

    fmg(fmc com_ushareit_listenit_fmc) {
        this.f12984b = com_ushareit_listenit_fmc;
    }

    public void mo2280a() {
        this.f12983a = this.f12984b.m19885k();
    }

    public void mo2281a(Exception exception) {
        if (!this.f12984b.f12976g && this.f12983a != null) {
            exw.m18443a("SongFileUploader", "asyncFastUploadAllSongs: size=" + this.f12983a.size());
            for (glg b : this.f12983a) {
                this.f12984b.m19880d(b);
            }
            if (this.f12984b.f12974e != null && this.f12984b.m19817i() == 0) {
                this.f12984b.f12976g = true;
                this.f12984b.f12974e.m19586b(System.currentTimeMillis());
            }
        }
    }
}
