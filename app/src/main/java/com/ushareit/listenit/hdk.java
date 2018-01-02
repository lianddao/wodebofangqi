package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hdk implements gxs {
    final /* synthetic */ NormalPlayerView f15216a;

    public hdk(NormalPlayerView normalPlayerView) {
        this.f15216a = normalPlayerView;
    }

    public void mo2368a(Bitmap bitmap) {
        Drawable drawable = this.f15216a.f17318e.getDrawable();
        if (drawable != null) {
            this.f15216a.f17292B.setImageDrawable(drawable);
        }
        this.f15216a.f17318e.setImageBitmap(bitmap);
        this.f15216a.m26928g();
    }
}
