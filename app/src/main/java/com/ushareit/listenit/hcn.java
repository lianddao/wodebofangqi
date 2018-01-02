package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.ActivePlaylistPopupView;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hcn implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15184a;

    public hcn(NormalPlayerView normalPlayerView) {
        this.f15184a = normalPlayerView;
    }

    public void onClick(View view) {
        gyn.m23197a((ak) this.f15184a.getContext(), new fyi(new ActivePlaylistPopupView(this.f15184a.getContext(), "normal")));
        fit.m19436d(this.f15184a.getContext(), "normal");
    }
}
