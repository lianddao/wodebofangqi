package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hdj implements fzv {
    final /* synthetic */ long f15213a;
    final /* synthetic */ ImageView f15214b;
    final /* synthetic */ NormalPlayerView f15215c;

    public hdj(NormalPlayerView normalPlayerView, long j, ImageView imageView) {
        this.f15215c = normalPlayerView;
        this.f15213a = j;
        this.f15214b = imageView;
    }

    public void mo2367a(Bitmap bitmap, aeq<? super Bitmap> com_ushareit_listenit_aeq__super_android_graphics_Bitmap, boolean z) {
        if (System.currentTimeMillis() - this.f15213a < 200) {
            this.f15214b.setImageBitmap(bitmap);
        } else {
            Drawable drawable = this.f15215c.getResources().getDrawable(C0349R.drawable.default_albumart_white);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, bitmapDrawable});
            this.f15214b.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(200);
        }
        gxm.m23096a(bitmap, "normalPlayViewBlurTask", 400, this.f15215c.f17304N);
    }
}
