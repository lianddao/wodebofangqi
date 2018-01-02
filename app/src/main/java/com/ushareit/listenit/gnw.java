package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.ActivePlaylistPopupView;

public class gnw implements OnClickListener {
    final /* synthetic */ ActivePlaylistPopupView f14485a;

    public gnw(ActivePlaylistPopupView activePlaylistPopupView) {
        this.f14485a = activePlaylistPopupView;
    }

    public void onClick(View view) {
        if (this.f14485a.f16122h != null) {
            boolean z;
            if (this.f14485a.f16122h.mo2453j()) {
                z = false;
            } else {
                z = true;
            }
            gyp.m23284b(z);
            heb.m23596a(this.f14485a.m25512a(z), 0).show();
            fit.m19438f(this.f14485a.getContext(), "nowplaylist");
        }
    }
}
