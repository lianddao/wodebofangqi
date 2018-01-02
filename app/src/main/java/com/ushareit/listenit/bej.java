package com.ushareit.listenit;

import android.view.View;
import com.google.android.gms.ads.formats.NativeAdView;

class bej extends bzr {
    private final buv f6016d;

    public bej(buv com_ushareit_listenit_buv) {
        this.f6016d = com_ushareit_listenit_buv;
        m7928a(com_ushareit_listenit_buv.mo1797b().toString());
        m7929a(com_ushareit_listenit_buv.mo1798c());
        m7930b(com_ushareit_listenit_buv.mo1799d().toString());
        if (com_ushareit_listenit_buv.mo1800e() != null) {
            m7927a(com_ushareit_listenit_buv.mo1800e());
        }
        m7931c(com_ushareit_listenit_buv.mo1801f().toString());
        m7932d(com_ushareit_listenit_buv.mo1802g().toString());
        m7900a(true);
        m7903b(true);
    }

    public void mo859a(View view) {
        if (view instanceof NativeAdView) {
            ((NativeAdView) view).setNativeAd(this.f6016d);
        }
    }
}
