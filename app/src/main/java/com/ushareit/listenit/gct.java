package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gct implements gxs {
    final /* synthetic */ MusicLockScreenView f13927a;

    public gct(MusicLockScreenView musicLockScreenView) {
        this.f13927a = musicLockScreenView;
    }

    public void mo2368a(Bitmap bitmap) {
        Drawable drawable = this.f13927a.f15666h.getDrawable();
        if (drawable != null) {
            this.f13927a.f15675q.setImageDrawable(drawable);
        }
        this.f13927a.f15666h.setImageBitmap(bitmap);
        this.f13927a.m24516i();
    }
}
