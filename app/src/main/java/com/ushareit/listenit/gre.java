package com.ushareit.listenit;

import android.content.ComponentName;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.ushareit.listenit.popupview.SharePopupView;

public class gre implements OnItemClickListener {
    final /* synthetic */ SharePopupView f14579a;

    public gre(SharePopupView sharePopupView) {
        this.f14579a = sharePopupView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        gxl com_ushareit_listenit_gxl = (gxl) this.f14579a.f16273a.get(i);
        this.f14579a.f16277e.setComponent(new ComponentName(com_ushareit_listenit_gxl.f14861b, com_ushareit_listenit_gxl.f14864e));
        if (com_ushareit_listenit_gxl.f14861b.contains(this.f14579a.getResources().getString(C0349R.string.facebook_package_name))) {
            hin com_ushareit_listenit_hin = new hin(this.f14579a.getContext());
            com_ushareit_listenit_hin.m23911b().putString("SHARE_INFO", this.f14579a.f16277e.getStringExtra("SHARE_INFO"));
            com_ushareit_listenit_hin.e.onClick(view);
        } else {
            this.f14579a.getContext().startActivity(this.f14579a.f16277e);
        }
        fiq.m19372a(this.f14579a.getContext(), "UF_MenuShare", this.f14579a.f16280h, this.f14579a.f16280h == -10001 ? "normalplayer" : "menu");
        fii.m19306b(com_ushareit_listenit_gxl.f14861b);
        if (this.f14579a.f16280h == 8) {
            fis.m19422a(this.f14579a.getContext(), "UF_PlaylistShareSong", "sharesong");
        }
    }
}
