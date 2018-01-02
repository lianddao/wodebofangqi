package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.AdType;
import com.ushareit.listenit.popupview.ActivePlaylistPopupView;

public class gny implements OnClickListener {
    final /* synthetic */ ActivePlaylistPopupView f14487a;

    public gny(ActivePlaylistPopupView activePlaylistPopupView) {
        this.f14487a = activePlaylistPopupView;
    }

    public void onClick(View view) {
        if (this.f14487a.f16118d.getCount() != 0) {
            gyp.m23295i();
            this.f14487a.f16118d.m22554a();
            this.f14487a.m25515a(this.f14487a.f16118d.getCount());
            fis.m19425c(this.f14487a.getContext(), AdType.CLEAR);
        }
    }
}
