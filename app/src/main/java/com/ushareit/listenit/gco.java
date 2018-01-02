package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;

public class gco implements OnClickListener {
    final /* synthetic */ MusicLockScreenView f13920a;

    public gco(MusicLockScreenView musicLockScreenView) {
        this.f13920a = musicLockScreenView;
    }

    public void onClick(View view) {
        BasePopupView addToPlaylistPopupView = new AddToPlaylistPopupView(this.f13920a.getContext(), 0, "lockscreen");
        addToPlaylistPopupView.setItem(gyp.m23301o());
        gyn.m23197a((ak) this.f13920a.getContext(), new fyi(addToPlaylistPopupView));
        fim.m19346a(this.f13920a.getContext(), "addToPlaylist");
    }
}
