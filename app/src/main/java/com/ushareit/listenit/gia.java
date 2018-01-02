package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lyrics.LyricView;

public class gia implements OnClickListener {
    final /* synthetic */ LyricView f14150a;

    public gia(LyricView lyricView) {
        this.f14150a = lyricView;
    }

    public void onClick(View view) {
        this.f14150a.m24762b(true);
        gyp.m23273a(this.f14150a.f15874j.m21949b(this.f14150a.getCenterItemIndex() - 1));
        fin.m19354c(eys.m18562a());
    }
}
