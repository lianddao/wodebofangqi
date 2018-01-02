package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

class gyh extends gyg {
    final /* synthetic */ gyb f14917b;
    private int f14918g;
    private ImageView f14919h;

    public gyh(gyb com_ushareit_listenit_gyb, int i, ImageView imageView) {
        this.f14917b = com_ushareit_listenit_gyb;
        super(com_ushareit_listenit_gyb, i, imageView);
        if (com_ushareit_listenit_gyb.m23126a(imageView)) {
            this.f14918g = i;
            this.f14919h = imageView;
        }
    }

    public void mo2281a(Exception exception) {
        super.mo2281a(exception);
        Bitmap bitmap = (Bitmap) this.f14917b.f14900c.get(this.f14917b.m23128b(this.f14918g, this.f14919h));
        if (bitmap != null) {
            this.f14919h.setImageBitmap(bitmap);
            this.f14919h.startAnimation(AnimationUtils.loadAnimation(this.f14919h.getContext(), 17432576));
        }
    }
}
