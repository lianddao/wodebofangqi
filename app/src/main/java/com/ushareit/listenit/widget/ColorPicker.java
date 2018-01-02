package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.C0154a;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.hbk;

public class ColorPicker extends View {
    private Drawable f17168A;
    private Rect f17169B;
    private Rect f17170C;
    private hbk f17171D;
    private float[] f17172a = new float[]{0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT};
    private int f17173b;
    private int f17174c;
    private int f17175d;
    private int f17176e;
    private int f17177f;
    private int f17178g;
    private int f17179h;
    private int f17180i;
    private boolean f17181j;
    private boolean f17182k;
    private float f17183l;
    private float f17184m;
    private float f17185n;
    private float f17186o;
    private float f17187p;
    private float f17188q;
    private float f17189r;
    private float f17190s;
    private Paint f17191t;
    private Paint f17192u;
    private RectF f17193v;
    private RectF f17194w;
    private Shader f17195x;
    private Shader f17196y;
    private Drawable f17197z;

    public ColorPicker(Context context) {
        super(context);
        m26798a();
    }

    public ColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26798a();
    }

    public ColorPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26798a();
    }

    private void m26798a() {
        this.f17178g = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_20dp);
        this.f17177f = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_4dp);
        this.f17179h = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_25dp);
        this.f17184m = (float) getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_2dp);
        this.f17180i = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_30dp);
        this.f17191t = new Paint();
        this.f17191t.setShader(this.f17195x);
        this.f17191t.setAntiAlias(true);
        this.f17197z = getResources().getDrawable(C0349R.drawable.color_picker_thumb);
        this.f17169B = new Rect();
        this.f17192u = new Paint();
        this.f17192u.setShader(this.f17196y);
        this.f17192u.setAntiAlias(true);
        this.f17168A = getResources().getDrawable(C0349R.drawable.color_picker_thumb);
        this.f17170C = new Rect();
        this.f17175d = this.f17197z.getIntrinsicWidth();
        this.f17176e = this.f17197z.getIntrinsicHeight();
    }

    public void setColor(int i) {
        Color.colorToHSV(i, this.f17172a);
        m26807g();
        m26802c();
        m26804d();
        m26805e();
        m26806f();
        invalidate();
    }

    public void setOnColorChangedListener(hbk com_ushareit_listenit_hbk) {
        this.f17171D = com_ushareit_listenit_hbk;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f17183l = (float) ((i - this.f17178g) - this.f17178g);
        m26799a(i2);
        float f = (float) (this.f17179h + this.f17177f);
        int i5 = (this.f17176e / 2) - (this.f17177f / 2);
        this.f17193v = new RectF((float) this.f17178g, (float) this.f17179h, ((float) this.f17178g) + this.f17183l, f);
        if (this.f17195x == null) {
            this.f17195x = new LinearGradient(this.f17193v.left, this.f17193v.top, this.f17193v.right, this.f17193v.top, m26801b(), null, TileMode.CLAMP);
        }
        this.f17191t.setShader(this.f17195x);
        this.f17173b = this.f17178g;
        this.f17169B.top = ((int) this.f17193v.top) - i5;
        this.f17169B.bottom = ((int) this.f17193v.bottom) + i5;
        m26805e();
        float f2 = ((float) this.f17180i) + f;
        this.f17194w = new RectF((float) this.f17178g, f2, ((float) this.f17178g) + this.f17183l, ((float) this.f17177f) + f2);
        if (this.f17196y == null) {
            m26807g();
        }
        this.f17174c = (int) (((float) this.f17178g) + this.f17183l);
        this.f17170C.top = ((int) this.f17194w.top) - i5;
        this.f17170C.bottom = ((int) this.f17194w.bottom) + i5;
        m26806f();
    }

    private int[] m26801b() {
        int[] iArr = new int[361];
        for (int i = 0; i < 361; i++) {
            iArr[i] = Color.HSVToColor(new float[]{(float) i, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        }
        return iArr;
    }

    private void m26799a(int i) {
        this.f17185n = (float) this.f17178g;
        this.f17186o = ((float) this.f17178g) + this.f17183l;
        this.f17187p = 0.0f;
        float f = (float) (i / 2);
        this.f17189r = f;
        this.f17188q = f;
        this.f17190s = (float) i;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(this.f17193v, this.f17184m, this.f17184m, this.f17191t);
        this.f17197z.draw(canvas);
        canvas.drawRoundRect(this.f17194w, this.f17184m, this.f17184m, this.f17192u);
        this.f17168A.draw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f17197z.setState(getDrawableState());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (y > this.f17187p && y <= this.f17188q) {
                    this.f17181j = true;
                    this.f17182k = false;
                }
                if (y > this.f17189r && y < this.f17190s) {
                    this.f17181j = false;
                    this.f17182k = true;
                }
                if (x >= this.f17185n && x <= this.f17186o) {
                    if (this.f17181j) {
                        this.f17173b = Math.round(x);
                        m26800b(this.f17173b);
                        m26805e();
                    }
                    if (this.f17182k) {
                        this.f17174c = Math.round(x);
                        m26803c(this.f17174c);
                        m26806f();
                    }
                }
                invalidate();
                break;
            case 1:
                this.f17181j = false;
                this.f17182k = false;
                break;
            case 2:
                if (this.f17181j) {
                    if (x >= this.f17185n && x <= this.f17186o) {
                        this.f17173b = Math.round(x);
                    } else if (x < this.f17185n) {
                        this.f17173b = (int) this.f17185n;
                    } else if (x > this.f17186o) {
                        this.f17173b = (int) this.f17186o;
                    }
                    m26800b(this.f17173b);
                    m26805e();
                    invalidate();
                }
                if (this.f17182k) {
                    if (x >= this.f17185n && x <= this.f17186o) {
                        this.f17174c = Math.round(x);
                    } else if (x < this.f17185n) {
                        this.f17174c = (int) this.f17185n;
                    } else if (x > this.f17186o) {
                        this.f17174c = (int) this.f17186o;
                    }
                    m26803c(this.f17174c);
                    m26806f();
                    invalidate();
                    break;
                }
                break;
        }
        return true;
    }

    private void m26800b(int i) {
        this.f17172a[0] = (((float) ((i - this.f17178g) * C0154a.f2960p)) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / this.f17183l;
        if (this.f17171D != null) {
            this.f17172a[1] = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            this.f17171D.mo2743a(Color.HSVToColor(this.f17172a));
        }
        m26807g();
    }

    private void m26802c() {
        this.f17173b = (int) (((this.f17172a[0] / 360.0f) * this.f17183l) + ((float) this.f17178g));
    }

    private void m26803c(int i) {
        this.f17172a[2] = (((float) (i - this.f17178g)) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / this.f17183l;
        if (this.f17171D != null) {
            this.f17171D.mo2743a(Color.HSVToColor(this.f17172a));
        }
    }

    private void m26804d() {
        this.f17174c = (int) ((this.f17172a[2] * this.f17183l) + ((float) this.f17178g));
    }

    private void m26805e() {
        this.f17169B.left = this.f17173b - (this.f17175d / 2);
        this.f17169B.right = this.f17169B.left + this.f17175d;
        this.f17197z.setBounds(this.f17169B);
    }

    private void m26806f() {
        this.f17170C.left = this.f17174c - (this.f17175d / 2);
        this.f17170C.right = this.f17170C.left + this.f17175d;
        this.f17168A.setBounds(this.f17170C);
    }

    private void m26807g() {
        this.f17196y = new LinearGradient(this.f17194w.left, this.f17194w.top, this.f17194w.right, this.f17194w.top, CtaButton.BACKGROUND_COLOR, Color.HSVToColor(255, new float[]{this.f17172a[0], DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT}), TileMode.CLAMP);
        this.f17192u.setShader(this.f17196y);
    }
}
