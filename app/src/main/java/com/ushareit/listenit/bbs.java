package com.ushareit.listenit;

import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.C0116x;
import com.facebook.share.internal.LikeContent;

class bbs implements C0116x {
    final /* synthetic */ LikeContent f5870a;
    final /* synthetic */ bbr f5871b;

    bbs(bbr com_ushareit_listenit_bbr, LikeContent likeContent) {
        this.f5871b = com_ushareit_listenit_bbr;
        this.f5870a = likeContent;
    }

    public Bundle mo832a() {
        return bbp.m7611b(this.f5870a);
    }

    public Bundle mo833b() {
        Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
        return new Bundle();
    }
}
