package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.RemoteControlClient.MetadataEditor;

class gce implements fzv {
    final /* synthetic */ gcd f13911a;

    gce(gcd com_ushareit_listenit_gcd) {
        this.f13911a = com_ushareit_listenit_gcd;
    }

    @TargetApi(14)
    public void mo2367a(Bitmap bitmap, aeq<? super Bitmap> com_ushareit_listenit_aeq__super_android_graphics_Bitmap, boolean z) {
        if (this.f13911a.f13898d != null && bitmap != null && !bitmap.isRecycled()) {
            MetadataEditor editMetadata = this.f13911a.f13898d.editMetadata(false);
            editMetadata.putBitmap(100, bitmap);
            editMetadata.apply();
        }
    }
}
