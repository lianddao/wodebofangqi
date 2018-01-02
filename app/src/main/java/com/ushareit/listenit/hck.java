package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hck implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15181a;

    public hck(NormalPlayerView normalPlayerView) {
        this.f15181a = normalPlayerView;
    }

    public void onClick(View view) {
        if (gyp.m23297k() != 0) {
            if (gyp.m23302p()) {
                fit.m19429a(this.f15181a.getContext(), "pause");
            } else {
                fii.m19311c(this.f15181a.getContext(), "normalplayer");
                fit.m19429a(this.f15181a.getContext(), "play");
            }
            gyp.m23286c();
        }
    }
}
