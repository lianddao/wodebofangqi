package com.ushareit.listenit;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class gof implements OnClickListener {
    final /* synthetic */ AddToPlaylistPopupView f14502a;

    public gof(AddToPlaylistPopupView addToPlaylistPopupView) {
        this.f14502a = addToPlaylistPopupView;
    }

    public void onClick(View view) {
        BasePopupView confirmPopupView = new ConfirmPopupView(this.f14502a.getContext());
        confirmPopupView.m25554a().setTitle((int) C0349R.string.confirm_view_new_playlist);
        confirmPopupView.m25558g().setInputDesc("0/40");
        confirmPopupView.m25557f().setSelectDesc((int) C0349R.string.confirm_view_playlist_visibility);
        if (this.f14502a.f16135d != null && ((this.f14502a.f16135d instanceof gkw) || (this.f14502a.f16135d instanceof gkv) || (this.f14502a.f16135d instanceof gkz))) {
            Object c = this.f14502a.f16135d.mo2562c();
            if (!TextUtils.isEmpty(c)) {
                confirmPopupView.setEditText(c);
            }
        }
        confirmPopupView.setConfirmListener(new gog(this, confirmPopupView));
        this.f14502a.m12832a(confirmPopupView);
    }
}
