package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hdm implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15218a;

    public hdm(NormalPlayerView normalPlayerView) {
        this.f15218a = normalPlayerView;
    }

    public void onClick(View view) {
        if (fre.m20627a(gyp.m23301o())) {
            this.f15218a.f17326m.setImageDrawable(this.f15218a.m26918d(false));
            fre.m20626a(gyp.m23301o(), false);
            fit.m19430a(this.f15218a.getContext(), "unlike", gyp.m23301o());
        } else {
            this.f15218a.f17326m.setImageDrawable(this.f15218a.m26918d(true));
            fre.m20626a(gyp.m23301o(), true);
            fit.m19430a(this.f15218a.getContext(), "like", gyp.m23301o());
        }
        fii.m19321g(this.f15218a.getContext(), "normalPlayer ");
        fxh.m21245Y();
    }
}
