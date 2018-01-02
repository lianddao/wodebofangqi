package com.ushareit.listenit;

import com.ushareit.listenit.lyrics.LyricView;

public class ghw implements Runnable {
    final /* synthetic */ LyricView f14143a;

    public ghw(LyricView lyricView) {
        this.f14143a = lyricView;
    }

    public void run() {
        if (this.f14143a.f15874j != null) {
            this.f14143a.m24764c();
            if (this.f14143a.f15866b.getHeaderViewsCount() == 0) {
                this.f14143a.m24766d();
            }
            if (this.f14143a.f15866b.getAdapter() != this.f14143a.f15875k) {
                this.f14143a.f15866b.setAdapter(this.f14143a.f15875k);
            }
            this.f14143a.f15875k.m22046a(this.f14143a.f15874j);
            this.f14143a.m24767e();
            this.f14143a.f15866b.setOnScrollListener(this.f14143a.f15874j.m21961e() ? this.f14143a.f15884t : null);
            hhx.m23869a(new ghx(this, this.f14143a.f15881q), 0, 100);
        }
    }
}
