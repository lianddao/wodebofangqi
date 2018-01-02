package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class fhw implements fzv {
    final /* synthetic */ View f12750a;
    final /* synthetic */ ImageView f12751b;
    final /* synthetic */ Context f12752c;
    final /* synthetic */ fhv f12753d;

    fhw(fhv com_ushareit_listenit_fhv, View view, ImageView imageView, Context context) {
        this.f12753d = com_ushareit_listenit_fhv;
        this.f12750a = view;
        this.f12751b = imageView;
        this.f12752c = context;
    }

    public void mo2367a(Bitmap bitmap, aeq<? super Bitmap> com_ushareit_listenit_aeq__super_android_graphics_Bitmap, boolean z) {
        this.f12750a.setVisibility(8);
        this.f12751b.setImageBitmap(bitmap);
        this.f12751b.setScaleType(z ? ScaleType.FIT_XY : ScaleType.CENTER);
        if (z) {
            fig.m19277a(eys.m18562a());
            this.f12751b.setOnClickListener(new fhx(this, bitmap));
        }
    }
}
