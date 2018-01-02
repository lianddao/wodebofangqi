package com.ushareit.listenit;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class sy extends Drawable {
    private float f16552a;
    private final Paint f16553b;
    private final RectF f16554c;
    private final Rect f16555d;
    private float f16556e;
    private boolean f16557f = false;
    private boolean f16558g = true;

    public sy(int i, float f) {
        this.f16552a = f;
        this.f16553b = new Paint(5);
        this.f16553b.setColor(i);
        this.f16554c = new RectF();
        this.f16555d = new Rect();
    }

    void m26229a(float f, boolean z, boolean z2) {
        if (f != this.f16556e || this.f16557f != z || this.f16558g != z2) {
            this.f16556e = f;
            this.f16557f = z;
            this.f16558g = z2;
            m26226a(null);
            invalidateSelf();
        }
    }

    float m26227a() {
        return this.f16556e;
    }

    public void draw(Canvas canvas) {
        canvas.drawRoundRect(this.f16554c, this.f16552a, this.f16552a, this.f16553b);
    }

    private void m26226a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f16554c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f16555d.set(rect);
        if (this.f16557f) {
            float a = sz.m26231a(this.f16556e, this.f16552a, this.f16558g);
            this.f16555d.inset((int) Math.ceil((double) sz.m26233b(this.f16556e, this.f16552a, this.f16558g)), (int) Math.ceil((double) a));
            this.f16554c.set(this.f16555d);
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m26226a(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f16555d, this.f16552a);
    }

    void m26228a(float f) {
        if (f != this.f16552a) {
            this.f16552a = f;
            m26226a(null);
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }

    public float m26230b() {
        return this.f16552a;
    }
}
