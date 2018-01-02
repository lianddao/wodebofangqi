package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.ushareit.listenit.nearby.widget.MyHomePageBlurView;

public class gmx implements gxs {
    final /* synthetic */ MyHomePageBlurView f14433a;

    public gmx(MyHomePageBlurView myHomePageBlurView) {
        this.f14433a = myHomePageBlurView;
    }

    public void mo2368a(Bitmap bitmap) {
        this.f14433a.f16024g.setVisibility(0);
        this.f14433a.f16020c.setImageBitmap(bitmap);
        this.f14433a.f16020c.post(new gmy(this, bitmap));
    }
}
