package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hco implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15185a;

    public hco(NormalPlayerView normalPlayerView) {
        this.f15185a = normalPlayerView;
    }

    public void onClick(View view) {
        int g = gyp.m23293g();
        gyp.m23280b(g);
        heb.m23596a(this.f15185a.m26912c(g), 0).show();
        fit.m19428a(this.f15185a.getContext(), g, "normalplayer");
    }
}
