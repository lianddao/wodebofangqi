package com.ushareit.listenit;

import android.view.View;
import com.google.android.gms.ads.formats.NativeAdView;

class bei extends bzq {
    private final but f6009d;

    public bei(but com_ushareit_listenit_but) {
        this.f6009d = com_ushareit_listenit_but;
        m7911a(com_ushareit_listenit_but.mo1778b().toString());
        m7912a(com_ushareit_listenit_but.mo1779c());
        m7913b(com_ushareit_listenit_but.mo1780d().toString());
        m7910a(com_ushareit_listenit_but.mo1781e());
        m7914c(com_ushareit_listenit_but.mo1782f().toString());
        if (com_ushareit_listenit_but.mo1783g() != null) {
            m7908a(com_ushareit_listenit_but.mo1783g().doubleValue());
        }
        if (com_ushareit_listenit_but.mo1784h() != null) {
            m7915d(com_ushareit_listenit_but.mo1784h().toString());
        }
        if (com_ushareit_listenit_but.mo1785i() != null) {
            m7917e(com_ushareit_listenit_but.mo1785i().toString());
        }
        m7900a(true);
        m7903b(true);
        m7909a(com_ushareit_listenit_but.mo1786j());
    }

    public void mo859a(View view) {
        if (view instanceof NativeAdView) {
            ((NativeAdView) view).setNativeAd(this.f6009d);
        }
    }
}
