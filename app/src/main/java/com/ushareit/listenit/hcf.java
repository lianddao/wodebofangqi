package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.MiniPlayerView;
import java.util.List;

public class hcf implements OnClickListener {
    final /* synthetic */ MiniPlayerView f15175a;

    public hcf(MiniPlayerView miniPlayerView) {
        this.f15175a = miniPlayerView;
    }

    public void onClick(View view) {
        if (this.f15175a.f17275f != null) {
            if (gyp.m23297k() == 0) {
                List a = fqs.m20451a(this.f15175a.getContext());
                if (!a.isEmpty()) {
                    gyp.m23277a(a, 0, "");
                    fii.m19311c(this.f15175a.getContext(), "miniplayer");
                    fit.m19429a(this.f15175a.getContext(), "play");
                    return;
                }
                return;
            }
            if (gyp.m23302p()) {
                fit.m19429a(this.f15175a.getContext(), "pause");
            } else {
                fii.m19311c(this.f15175a.getContext(), "miniplayer");
                fit.m19429a(this.f15175a.getContext(), "play");
            }
            gyp.m23286c();
        }
    }
}
