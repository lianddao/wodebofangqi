package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;

class hdb implements fzv {
    final /* synthetic */ long f15200a;
    final /* synthetic */ ImageView f15201b;
    final /* synthetic */ glg f15202c;
    final /* synthetic */ hda f15203d;

    hdb(hda com_ushareit_listenit_hda, long j, ImageView imageView, glg com_ushareit_listenit_glg) {
        this.f15203d = com_ushareit_listenit_hda;
        this.f15200a = j;
        this.f15201b = imageView;
        this.f15202c = com_ushareit_listenit_glg;
    }

    public void mo2367a(Bitmap bitmap, aeq<? super Bitmap> com_ushareit_listenit_aeq__super_android_graphics_Bitmap, boolean z) {
        if (System.currentTimeMillis() - this.f15200a < 200) {
            this.f15201b.setImageBitmap(bitmap);
        } else {
            Drawable drawable = this.f15203d.f15199a.getResources().getDrawable(C0349R.drawable.default_albumart_white);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, bitmapDrawable});
            this.f15201b.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(200);
        }
        if (this.f15203d.f15199a.f17299I == this.f15202c.f14334b) {
            this.f15203d.f15199a.m26899a(bitmap);
            return;
        }
        this.f15203d.f15199a.aj = this.f15202c.f14334b;
        this.f15203d.f15199a.ai = bitmap;
    }
}
