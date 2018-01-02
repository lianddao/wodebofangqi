package com.ushareit.listenit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.hdu;

public class RoundedRectangleImageView extends ImageView {
    private hdu f17350a;
    private float f17351b = 0.0f;

    public RoundedRectangleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.RoundedRectangleImageView, 0, 0);
        this.f17351b = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f17350a != null) {
            this.f17350a.m23591a(this.f17351b);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        try {
            Bitmap a = hdu.m23590a(drawable);
            if (a != null) {
                this.f17350a = new hdu(a);
                super.setImageDrawable(this.f17350a);
                return;
            }
            super.setImageDrawable(drawable);
        } catch (Exception e) {
            exw.m18451b("RoundedRectangleImageView", "set image drawable has a error.", e);
            super.setImageDrawable(drawable);
        }
    }
}
