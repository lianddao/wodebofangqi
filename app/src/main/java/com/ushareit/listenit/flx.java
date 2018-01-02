package com.ushareit.listenit;

import java.util.List;

class flx extends fay {
    List<glg> f12963a;
    final /* synthetic */ flw f12964b;

    flx(flw com_ushareit_listenit_flw) {
        this.f12964b = com_ushareit_listenit_flw;
    }

    public void mo2280a() {
        this.f12963a = this.f12964b.m19828k();
    }

    public void mo2281a(Exception exception) {
        if (!this.f12964b.f12961f && this.f12963a != null) {
            exw.m18457e("SongFileDownloader", "asyncDownloadAllSongs : size=" + this.f12963a.size());
            for (glg a : this.f12963a) {
                this.f12964b.m19832a(a, false);
            }
            if (this.f12964b.f12960e != null && this.f12964b.m19817i() == 0) {
                this.f12964b.f12961f = true;
                this.f12964b.f12960e.m19587c();
            }
        }
    }
}
