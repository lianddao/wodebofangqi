package com.ushareit.listenit;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.umeng.analytics.pro.C0277j;

public class aaz extends abo {
    private final Rect f4013a;
    private int f4014b;
    private int f4015c;
    private boolean f4016d;
    private boolean f4017e;
    private aba f4018f;

    public aaz(Resources resources, Bitmap bitmap) {
        this(resources, new aba(bitmap));
    }

    aaz(Resources resources, aba com_ushareit_listenit_aba) {
        this.f4013a = new Rect();
        if (com_ushareit_listenit_aba == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        int i;
        this.f4018f = com_ushareit_listenit_aba;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            if (i == 0) {
                i = C0277j.f3691b;
            }
            com_ushareit_listenit_aba.f4021b = i;
        } else {
            i = com_ushareit_listenit_aba.f4021b;
        }
        this.f4014b = com_ushareit_listenit_aba.f4020a.getScaledWidth(i);
        this.f4015c = com_ushareit_listenit_aba.f4020a.getScaledHeight(i);
    }

    public int getIntrinsicWidth() {
        return this.f4014b;
    }

    public int getIntrinsicHeight() {
        return this.f4015c;
    }

    public boolean mo568a() {
        return false;
    }

    public void mo567a(int i) {
    }

    public void start() {
    }

    public void stop() {
    }

    public boolean isRunning() {
        return false;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4016d = true;
    }

    public ConstantState getConstantState() {
        return this.f4018f;
    }

    public void draw(Canvas canvas) {
        if (this.f4016d) {
            Gravity.apply(119, this.f4014b, this.f4015c, getBounds(), this.f4013a);
            this.f4016d = false;
        }
        canvas.drawBitmap(this.f4018f.f4020a, null, this.f4013a, this.f4018f.f4022c);
    }

    public void setAlpha(int i) {
        if (this.f4018f.f4022c.getAlpha() != i) {
            this.f4018f.m5057a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4018f.m5058a(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        Bitmap bitmap = this.f4018f.f4020a;
        return (bitmap == null || bitmap.hasAlpha() || this.f4018f.f4022c.getAlpha() < 255) ? -3 : -1;
    }

    public Drawable mutate() {
        if (!this.f4017e && super.mutate() == this) {
            this.f4018f = new aba(this.f4018f);
            this.f4017e = true;
        }
        return this;
    }

    public Bitmap m5053b() {
        return this.f4018f.f4020a;
    }
}
