package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.ActivePlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.widget.MiniPlayerView;

public class hcg implements OnClickListener {
    final /* synthetic */ MiniPlayerView f15176a;

    public hcg(MiniPlayerView miniPlayerView) {
        this.f15176a = miniPlayerView;
    }

    public void onClick(View view) {
        BasePopupView activePlaylistPopupView = new ActivePlaylistPopupView(this.f15176a.getContext(), "miniplayer");
        fyi com_ushareit_listenit_fyi = new fyi(activePlaylistPopupView);
        com_ushareit_listenit_fyi.m21347a(new hch(this, activePlaylistPopupView));
        gyn.m23197a((ak) this.f15176a.getContext(), com_ushareit_listenit_fyi);
        fit.m19436d(this.f15176a.getContext(), "miniplayer");
    }
}
