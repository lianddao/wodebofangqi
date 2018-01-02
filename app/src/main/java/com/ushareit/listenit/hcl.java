package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hcl implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15182a;

    public hcl(NormalPlayerView normalPlayerView) {
        this.f15182a = normalPlayerView;
    }

    public void onClick(View view) {
        if (!fjx.m19570b(view)) {
            this.f15182a.f17316c.m19096a(this.f15182a.f17293C.getDisplayedChild() == 0);
        }
        gyp.m23291e();
        fii.m19311c(this.f15182a.getContext(), "normalplayer");
        fit.m19429a(this.f15182a.getContext(), "next");
    }
}
