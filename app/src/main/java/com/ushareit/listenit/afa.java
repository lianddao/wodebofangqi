package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class afa extends afc<Drawable> {
    protected /* synthetic */ void mo614a(Object obj) {
        m5444d((Drawable) obj);
    }

    public afa(ImageView imageView) {
        super(imageView);
    }

    protected void m5444d(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }
}
