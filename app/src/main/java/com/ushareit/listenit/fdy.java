package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.widget.ImageView;

class fdy extends hhw {
    final /* synthetic */ ImageView f12508a;
    final /* synthetic */ fnl f12509b;
    final /* synthetic */ fdx f12510c;
    private Bitmap f12511d;

    fdy(fdx com_ushareit_listenit_fdx, ImageView imageView, fnl com_ushareit_listenit_fnl) {
        this.f12510c = com_ushareit_listenit_fdx;
        this.f12508a = imageView;
        this.f12509b = com_ushareit_listenit_fnl;
    }

    public void execute() {
        this.f12511d = gyn.m23173a(m18938c(), this.f12508a.getWidth(), this.f12508a.getHeight());
    }

    public void callback() {
        this.f12508a.setImageBitmap(this.f12511d);
    }

    private int m18938c() {
        return this.f12509b.getId().charAt(0) % 18;
    }
}
