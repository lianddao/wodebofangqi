package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.formats.NativeContentAdView;

class fgs implements OnClickListener {
    final /* synthetic */ NativeContentAdView f12687a;
    final /* synthetic */ esi f12688b;
    final /* synthetic */ fgm f12689c;

    fgs(fgm com_ushareit_listenit_fgm, NativeContentAdView nativeContentAdView, esi com_ushareit_listenit_esi) {
        this.f12689c = com_ushareit_listenit_fgm;
        this.f12687a = nativeContentAdView;
        this.f12688b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12687a.setVisibility(4);
        this.f12689c.m19170c(this.f12688b);
    }
}
