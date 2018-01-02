package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.widget.ImageView;

class gyg extends fay {
    final /* synthetic */ gyb f14913a;
    private int f14914b;
    private ImageView f14915g;
    private Bitmap f14916h;

    public gyg(gyb com_ushareit_listenit_gyb, int i, ImageView imageView) {
        this.f14913a = com_ushareit_listenit_gyb;
        if (imageView != null && i != 0) {
            this.f14914b = i;
            this.f14915g = imageView;
        }
    }

    public void mo2280a() {
        if (this.f14913a.m23126a(this.f14915g)) {
            this.f14916h = gyn.m23218c(this.f14914b, this.f14915g.getWidth(), this.f14915g.getHeight());
        }
    }

    public void mo2281a(Exception exception) {
        if (this.f14916h != null) {
            this.f14913a.f14900c.put(this.f14913a.m23128b(this.f14914b, this.f14915g), this.f14916h);
        }
    }
}
