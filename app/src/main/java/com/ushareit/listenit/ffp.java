package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.mopub.nativeads.NativeAd;

final class ffp implements fzv {
    final /* synthetic */ ffl f12614a;
    final /* synthetic */ NativeAd f12615b;
    final /* synthetic */ ffs f12616c;

    ffp(ffl com_ushareit_listenit_ffl, NativeAd nativeAd, ffs com_ushareit_listenit_ffs) {
        this.f12614a = com_ushareit_listenit_ffl;
        this.f12615b = nativeAd;
        this.f12616c = com_ushareit_listenit_ffs;
    }

    public void mo2367a(Bitmap bitmap, aeq<? super Bitmap> com_ushareit_listenit_aeq__super_android_graphics_Bitmap, boolean z) {
        if (bitmap != null) {
            gxm.m23097a(bitmap, "MoPubAdBackgroundBlurTask", new ffq(this, bitmap));
        }
    }
}
