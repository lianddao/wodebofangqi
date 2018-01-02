package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hcp implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15186a;

    public hcp(NormalPlayerView normalPlayerView) {
        this.f15186a = normalPlayerView;
    }

    public void onClick(View view) {
        if (this.f15186a.f17294D != null) {
            boolean z;
            if (this.f15186a.f17294D.mo2453j()) {
                z = false;
            } else {
                z = true;
            }
            this.f15186a.f17294D.mo2436b(z);
            heb.m23596a(this.f15186a.m26924f(z), 0).show();
            fit.m19438f(this.f15186a.getContext(), "normalplayer");
        }
    }
}
