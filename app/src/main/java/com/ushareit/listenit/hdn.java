package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hdn implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15219a;

    public hdn(NormalPlayerView normalPlayerView) {
        this.f15219a = normalPlayerView;
    }

    public void onClick(View view) {
        BasePopupView addToPlaylistPopupView = new AddToPlaylistPopupView(this.f15219a.getContext(), -10001, "normal");
        addToPlaylistPopupView.setItem(gyp.m23301o());
        gyn.m23197a((ak) this.f15219a.getContext(), new fyi(addToPlaylistPopupView));
        fit.m19432b(this.f15219a.getContext());
        fit.m19433b(this.f15219a.getContext(), "add_to_playlist");
    }
}
