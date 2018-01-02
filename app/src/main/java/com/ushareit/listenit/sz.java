package com.ushareit.listenit;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.C0002R;
import android.util.Log;
import com.mopub.mobileads.resource.DrawableConstants.RadialCountdown;
import com.mopub.volley.DefaultRetryPolicy;

class sz extends Drawable {
    static final double f16559a = Math.cos(Math.toRadians(45.0d));
    static ta f16560c;
    final float f16561b;
    Paint f16562d;
    Paint f16563e;
    Paint f16564f;
    final RectF f16565g;
    float f16566h;
    Path f16567i;
    float f16568j;
    float f16569k;
    float f16570l;
    float f16571m;
    private boolean f16572n = true;
    private final int f16573o;
    private final int f16574p;
    private boolean f16575q = true;
    private boolean f16576r = false;

    sz(Resources resources, int i, float f, float f2, float f3) {
        this.f16573o = resources.getColor(C0002R.color.cardview_shadow_start_color);
        this.f16574p = resources.getColor(C0002R.color.cardview_shadow_end_color);
        this.f16561b = resources.getDimension(C0002R.dimen.cardview_compat_inset_shadow);
        m26238a(f2, f3);
        this.f16562d = new Paint(5);
        this.f16562d.setColor(i);
        this.f16563e = new Paint(5);
        this.f16563e.setStyle(Style.FILL);
        this.f16563e.setDither(true);
        this.f16566h = f;
        this.f16565g = new RectF();
        this.f16564f = new Paint(this.f16563e);
    }

    public void m26240a(boolean z) {
        this.f16575q = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f16562d.setAlpha(i);
        this.f16563e.setAlpha(i);
        this.f16564f.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f16572n = true;
    }

    void m26238a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        if (f > f2) {
            if (!this.f16576r) {
                Log.w("CardView", "Shadow size is being clipped by the max shadow size. See {CardView#setMaxCardElevation}.");
                this.f16576r = true;
            }
            f = f2;
        }
        if (this.f16571m != f || this.f16569k != f2) {
            this.f16571m = f;
            this.f16569k = f2;
            this.f16570l = (1.5f * f) + this.f16561b;
            this.f16568j = this.f16561b + f2;
            this.f16572n = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m26231a(this.f16569k, this.f16566h, this.f16575q));
        int ceil2 = (int) Math.ceil((double) m26233b(this.f16569k, this.f16566h, this.f16575q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float m26231a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - f16559a) * ((double) f2)));
        }
        return 1.5f * f;
    }

    static float m26233b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f16559a) * ((double) f2)));
        }
        return f;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f16562d.setColorFilter(colorFilter);
        this.f16563e.setColorFilter(colorFilter);
        this.f16564f.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -1;
    }

    void m26237a(float f) {
        if (this.f16566h != f) {
            this.f16566h = f;
            this.f16572n = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f16572n) {
            m26234b(getBounds());
            this.f16572n = false;
        }
        canvas.translate(0.0f, this.f16571m / 2.0f);
        m26232a(canvas);
        canvas.translate(0.0f, (-this.f16571m) / 2.0f);
        f16560c.mo3015a(canvas, this.f16565g, this.f16566h, this.f16562d);
    }

    private void m26232a(Canvas canvas) {
        Object obj;
        float f = (-this.f16566h) - this.f16570l;
        float f2 = (this.f16566h + this.f16561b) + (this.f16571m / 2.0f);
        Object obj2 = this.f16565g.width() - (2.0f * f2) > 0.0f ? 1 : null;
        if (this.f16565g.height() - (2.0f * f2) > 0.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        int save = canvas.save();
        canvas.translate(this.f16565g.left + f2, this.f16565g.top + f2);
        canvas.drawPath(this.f16567i, this.f16563e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f16565g.width() - (2.0f * f2), -this.f16566h, this.f16564f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.f16565g.right - f2, this.f16565g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f16567i, this.f16563e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f16565g.width() - (2.0f * f2), this.f16570l + (-this.f16566h), this.f16564f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f16565g.left + f2, this.f16565g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f16567i, this.f16563e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f16565g.height() - (2.0f * f2), -this.f16566h, this.f16564f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f16565g.right - f2, this.f16565g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f16567i, this.f16563e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f16565g.height() - (2.0f * f2), -this.f16566h, this.f16564f);
        }
        canvas.restoreToCount(save2);
    }

    private void m26235f() {
        RectF rectF = new RectF(-this.f16566h, -this.f16566h, this.f16566h, this.f16566h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f16570l, -this.f16570l);
        if (this.f16567i == null) {
            this.f16567i = new Path();
        } else {
            this.f16567i.reset();
        }
        this.f16567i.setFillType(FillType.EVEN_ODD);
        this.f16567i.moveTo(-this.f16566h, 0.0f);
        this.f16567i.rLineTo(-this.f16570l, 0.0f);
        this.f16567i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f16567i.arcTo(rectF, 270.0f, RadialCountdown.START_ANGLE, false);
        this.f16567i.close();
        float f = this.f16566h / (this.f16566h + this.f16570l);
        float[] fArr = new float[]{0.0f, f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT};
        f = 0.0f;
        this.f16563e.setShader(new RadialGradient(0.0f, f, this.f16566h + this.f16570l, new int[]{this.f16573o, this.f16573o, this.f16574p}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.f16564f.setShader(new LinearGradient(0.0f, (-this.f16566h) + this.f16570l, f2, (-this.f16566h) - this.f16570l, new int[]{this.f16573o, this.f16573o, this.f16574p}, new float[]{0.0f, 0.5f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT}, TileMode.CLAMP));
    }

    private void m26234b(Rect rect) {
        float f = this.f16568j * 1.5f;
        this.f16565g.set(((float) rect.left) + this.f16568j, ((float) rect.top) + f, ((float) rect.right) - this.f16568j, ((float) rect.bottom) - f);
        m26235f();
    }

    float m26236a() {
        return this.f16566h;
    }

    void m26239a(Rect rect) {
        getPadding(rect);
    }

    void m26242b(float f) {
        m26238a(f, this.f16569k);
    }

    void m26244c(float f) {
        m26238a(this.f16571m, f);
    }

    float m26241b() {
        return this.f16571m;
    }

    float m26243c() {
        return this.f16569k;
    }

    float m26245d() {
        return (Math.max(this.f16569k, (this.f16566h + this.f16561b) + (this.f16569k / 2.0f)) * 2.0f) + ((this.f16569k + this.f16561b) * 2.0f);
    }

    float m26246e() {
        return (Math.max(this.f16569k, (this.f16566h + this.f16561b) + ((this.f16569k * 1.5f) / 2.0f)) * 2.0f) + (((this.f16569k * 1.5f) + this.f16561b) * 2.0f);
    }
}
