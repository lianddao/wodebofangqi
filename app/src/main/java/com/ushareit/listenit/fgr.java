package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;

class fgr implements OnClickListener {
    final /* synthetic */ NativeAppInstallAdView f12684a;
    final /* synthetic */ esi f12685b;
    final /* synthetic */ fgm f12686c;

    fgr(fgm com_ushareit_listenit_fgm, NativeAppInstallAdView nativeAppInstallAdView, esi com_ushareit_listenit_esi) {
        this.f12686c = com_ushareit_listenit_fgm;
        this.f12684a = nativeAppInstallAdView;
        this.f12685b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12684a.setVisibility(4);
        this.f12686c.m19170c(this.f12685b);
    }
}
