package com.ushareit.listenit;

import com.ushareit.listenit.lyrics.LyricView;

public class ghv implements ghs {
    final /* synthetic */ boolean f14140a;
    final /* synthetic */ glg f14141b;
    final /* synthetic */ LyricView f14142c;

    public ghv(LyricView lyricView, boolean z, glg com_ushareit_listenit_glg) {
        this.f14142c = lyricView;
        this.f14140a = z;
        this.f14141b = com_ushareit_listenit_glg;
    }

    public void mo2679a(ggm com_ushareit_listenit_ggm) {
        this.f14142c.f15874j = com_ushareit_listenit_ggm;
        if (this.f14142c.f15874j == null) {
            this.f14142c.m24757a(this.f14140a, this.f14141b);
            return;
        }
        this.f14142c.getLyricModifiedTime();
        this.f14142c.f15866b.post(this.f14142c.f15883s);
        fin.m19349a(eys.m18562a());
    }
}
