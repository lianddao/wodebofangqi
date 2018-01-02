package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.ushareit.listenit.lyrics.LyricView;

public class ghy implements OnScrollListener {
    final /* synthetic */ LyricView f14146a;

    public ghy(LyricView lyricView) {
        this.f14146a = lyricView;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
                this.f14146a.m24762b(false);
                return;
            case 1:
                this.f14146a.m24769f();
                return;
            default:
                return;
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f14146a.m24772g();
    }
}
