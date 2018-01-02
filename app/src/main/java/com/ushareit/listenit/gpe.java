package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.AdType;
import com.umeng.analytics.pro.C0271d.C0270c;
import com.ushareit.listenit.popupview.LockScreenSettingPopupView;

public class gpe implements OnClickListener {
    final /* synthetic */ LockScreenSettingPopupView f14525a;

    public gpe(LockScreenSettingPopupView lockScreenSettingPopupView) {
        this.f14525a = lockScreenSettingPopupView;
    }

    public void onClick(View view) {
        gvj.m22914b(this.f14525a.f16201f);
        this.f14525a.f16200e.mo2742a(this.f14525a.f16201f);
        try {
            gcd.m21661a().m21672a(this.f14525a.f16201f);
            fii.m19317e(this.f14525a.getContext(), this.f14525a.f16201f ? C0270c.f3617a : AdType.CUSTOM);
            this.f14525a.mo3063e();
        } catch (Throwable e) {
            exw.m18450b("LockScreenSettingPopupView", "The process of setting lock screen mode has an error.", e);
        }
    }
}
