package com.ushareit.listenit;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

class ox {
    private final RectF f16084a = new RectF();
    private final Paint f16085b = new Paint();
    private final Paint f16086c = new Paint();
    private final Callback f16087d;
    private float f16088e = 0.0f;
    private float f16089f = 0.0f;
    private float f16090g = 0.0f;
    private float f16091h = 5.0f;
    private float f16092i = 2.5f;
    private int[] f16093j;
    private int f16094k;
    private float f16095l;
    private float f16096m;
    private float f16097n;
    private boolean f16098o;
    private Path f16099p;
    private float f16100q;
    private double f16101r;
    private int f16102s;
    private int f16103t;
    private int f16104u;
    private final Paint f16105v = new Paint(1);
    private int f16106w;
    private int f16107x;

    public ox(Callback callback) {
        this.f16087d = callback;
        this.f16085b.setStrokeCap(Cap.SQUARE);
        this.f16085b.setAntiAlias(true);
        this.f16085b.setStyle(Style.STROKE);
        this.f16086c.setStyle(Style.FILL);
        this.f16086c.setAntiAlias(true);
    }

    public void m25387a(int i) {
        this.f16106w = i;
    }

    public void m25386a(float f, float f2) {
        this.f16102s = (int) f;
        this.f16103t = (int) f2;
    }

    public void m25389a(Canvas canvas, Rect rect) {
        RectF rectF = this.f16084a;
        rectF.set(rect);
        rectF.inset(this.f16092i, this.f16092i);
        float f = (this.f16088e + this.f16090g) * 360.0f;
        float f2 = ((this.f16089f + this.f16090g) * 360.0f) - f;
        this.f16085b.setColor(this.f16107x);
        canvas.drawArc(rectF, f, f2, false, this.f16085b);
        m25380a(canvas, f, f2, rect);
        if (this.f16104u < 255) {
            this.f16105v.setColor(this.f16106w);
            this.f16105v.setAlpha(255 - this.f16104u);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f16105v);
        }
    }

    private void m25380a(Canvas canvas, float f, float f2, Rect rect) {
        if (this.f16098o) {
            if (this.f16099p == null) {
                this.f16099p = new Path();
                this.f16099p.setFillType(FillType.EVEN_ODD);
            } else {
                this.f16099p.reset();
            }
            float f3 = ((float) (((int) this.f16092i) / 2)) * this.f16100q;
            float cos = (float) ((this.f16101r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
            float sin = (float) ((this.f16101r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
            this.f16099p.moveTo(0.0f, 0.0f);
            this.f16099p.lineTo(((float) this.f16102s) * this.f16100q, 0.0f);
            this.f16099p.lineTo((((float) this.f16102s) * this.f16100q) / 2.0f, ((float) this.f16103t) * this.f16100q);
            this.f16099p.offset(cos - f3, sin);
            this.f16099p.close();
            this.f16086c.setColor(this.f16107x);
            canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawPath(this.f16099p, this.f16086c);
        }
    }

    public void m25392a(int[] iArr) {
        this.f16093j = iArr;
        m25398c(0);
    }

    public void m25395b(int i) {
        this.f16107x = i;
    }

    public void m25398c(int i) {
        this.f16094k = i;
        this.f16107x = this.f16093j[this.f16094k];
    }

    public int m25383a() {
        return this.f16093j[m25381n()];
    }

    private int m25381n() {
        return (this.f16094k + 1) % this.f16093j.length;
    }

    public void m25393b() {
        m25398c(m25381n());
    }

    public void m25390a(ColorFilter colorFilter) {
        this.f16085b.setColorFilter(colorFilter);
        m25382o();
    }

    public void m25401d(int i) {
        this.f16104u = i;
    }

    public int m25396c() {
        return this.f16104u;
    }

    public void m25385a(float f) {
        this.f16091h = f;
        this.f16085b.setStrokeWidth(f);
        m25382o();
    }

    public float m25399d() {
        return this.f16091h;
    }

    public void m25394b(float f) {
        this.f16088e = f;
        m25382o();
    }

    public float m25402e() {
        return this.f16088e;
    }

    public float m25404f() {
        return this.f16095l;
    }

    public float m25405g() {
        return this.f16096m;
    }

    public int m25406h() {
        return this.f16093j[this.f16094k];
    }

    public void m25397c(float f) {
        this.f16089f = f;
        m25382o();
    }

    public float m25407i() {
        return this.f16089f;
    }

    public void m25400d(float f) {
        this.f16090g = f;
        m25382o();
    }

    public void m25388a(int i, int i2) {
        float min = (float) Math.min(i, i2);
        if (this.f16101r <= 0.0d || min < 0.0f) {
            min = (float) Math.ceil((double) (this.f16091h / 2.0f));
        } else {
            min = (float) (((double) (min / 2.0f)) - this.f16101r);
        }
        this.f16092i = min;
    }

    public void m25384a(double d) {
        this.f16101r = d;
    }

    public double m25408j() {
        return this.f16101r;
    }

    public void m25391a(boolean z) {
        if (this.f16098o != z) {
            this.f16098o = z;
            m25382o();
        }
    }

    public void m25403e(float f) {
        if (f != this.f16100q) {
            this.f16100q = f;
            m25382o();
        }
    }

    public float m25409k() {
        return this.f16097n;
    }

    public void m25410l() {
        this.f16095l = this.f16088e;
        this.f16096m = this.f16089f;
        this.f16097n = this.f16090g;
    }

    public void m25411m() {
        this.f16095l = 0.0f;
        this.f16096m = 0.0f;
        this.f16097n = 0.0f;
        m25394b(0.0f);
        m25397c(0.0f);
        m25400d(0.0f);
    }

    private void m25382o() {
        this.f16087d.invalidateDrawable(null);
    }
}
