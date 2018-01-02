package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

final class fzo extends afe<Bitmap> {
    final /* synthetic */ fzv f13770a;
    final /* synthetic */ ImageView f13771b;
    final /* synthetic */ String f13772c;
    final /* synthetic */ int f13773d;
    final /* synthetic */ Context f13774e;

    fzo(fzv com_ushareit_listenit_fzv, ImageView imageView, String str, int i, Context context) {
        this.f13770a = com_ushareit_listenit_fzv;
        this.f13771b = imageView;
        this.f13772c = str;
        this.f13773d = i;
        this.f13774e = context;
    }

    public void m21415a(Bitmap bitmap, aeq<? super Bitmap> com_ushareit_listenit_aeq__super_android_graphics_Bitmap) {
        if (this.f13770a == null) {
            return;
        }
        if (this.f13771b == null || this.f13771b.getTag(C0349R.id.glide_view_tag_id).equals(this.f13772c)) {
            Bitmap decodeResource = bitmap != null ? bitmap : this.f13773d > 0 ? BitmapFactory.decodeResource(this.f13774e.getResources(), this.f13773d) : null;
            this.f13770a.mo2367a(decodeResource, com_ushareit_listenit_aeq__super_android_graphics_Bitmap, bitmap != null);
        }
    }

    public void mo574a(Exception exception, Drawable drawable) {
        if (this.f13770a != null && (this.f13771b == null || this.f13771b.getTag(C0349R.id.glide_view_tag_id).equals(this.f13772c))) {
            Bitmap decodeResource;
            fzv com_ushareit_listenit_fzv = this.f13770a;
            if (this.f13773d > 0) {
                decodeResource = BitmapFactory.decodeResource(this.f13774e.getResources(), this.f13773d);
            } else {
                decodeResource = null;
            }
            com_ushareit_listenit_fzv.mo2367a(decodeResource, null, false);
        }
        super.mo574a(exception, drawable);
    }
}
