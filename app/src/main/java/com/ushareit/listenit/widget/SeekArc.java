package com.ushareit.listenit.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.C0154a;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.hea;

public class SeekArc extends View {
    private static final String f17376a = SeekArc.class.getSimpleName();
    private static int f17377b = -1;
    private ColorStateList f17378A;
    private ColorStateList f17379B;
    private final int f17380c = -90;
    private Drawable f17381d;
    private int f17382e = 100;
    private int f17383f = 0;
    private int f17384g = 4;
    private int f17385h = 2;
    private int f17386i = 0;
    private int f17387j = C0154a.f2960p;
    private int f17388k = 0;
    private boolean f17389l = false;
    private boolean f17390m = true;
    private boolean f17391n = true;
    private int f17392o = 0;
    private float f17393p = 0.0f;
    private RectF f17394q = new RectF();
    private Paint f17395r;
    private Paint f17396s;
    private int f17397t;
    private int f17398u;
    private int f17399v;
    private int f17400w;
    private double f17401x;
    private float f17402y;
    private hea f17403z;

    public SeekArc(Context context) {
        super(context);
        m27007a(context, null, 0);
    }

    public SeekArc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27007a(context, attributeSet, C0349R.attr.seekArcStyle);
    }

    public SeekArc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27007a(context, attributeSet, i);
    }

    private void m27007a(Context context, AttributeSet attributeSet, int i) {
        Resources resources = getResources();
        float f = context.getResources().getDisplayMetrics().density;
        this.f17381d = resources.getDrawable(C0349R.drawable.seek_arc_control_selector);
        this.f17384g = (int) (((float) this.f17384g) * f);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.SeekArc, i, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                this.f17381d = drawable;
            }
            int intrinsicHeight = this.f17381d.getIntrinsicHeight() / 2;
            int intrinsicWidth = this.f17381d.getIntrinsicWidth() / 2;
            this.f17381d.setBounds(-intrinsicWidth, -intrinsicHeight, intrinsicWidth, intrinsicHeight);
            this.f17382e = obtainStyledAttributes.getInteger(2, this.f17382e);
            this.f17383f = obtainStyledAttributes.getInteger(5, this.f17383f);
            this.f17384g = (int) obtainStyledAttributes.getDimension(3, (float) this.f17384g);
            this.f17385h = (int) obtainStyledAttributes.getDimension(4, (float) this.f17385h);
            this.f17386i = obtainStyledAttributes.getInt(7, this.f17386i);
            this.f17387j = obtainStyledAttributes.getInt(8, this.f17387j);
            this.f17388k = obtainStyledAttributes.getInt(6, this.f17388k);
            this.f17389l = obtainStyledAttributes.getBoolean(11, this.f17389l);
            this.f17390m = obtainStyledAttributes.getBoolean(12, this.f17390m);
            this.f17391n = obtainStyledAttributes.getBoolean(13, this.f17391n);
            setEnabled(obtainStyledAttributes.getBoolean(14, false));
            this.f17378A = obtainStyledAttributes.getColorStateList(9);
            this.f17379B = obtainStyledAttributes.getColorStateList(10);
            obtainStyledAttributes.recycle();
        }
        this.f17383f = this.f17383f > this.f17382e ? this.f17382e : this.f17383f;
        this.f17383f = this.f17383f < 0 ? 0 : this.f17383f;
        this.f17387j = this.f17387j > C0154a.f2960p ? C0154a.f2960p : this.f17387j;
        this.f17387j = this.f17387j < 0 ? 0 : this.f17387j;
        this.f17393p = (((float) this.f17383f) / ((float) this.f17382e)) * ((float) this.f17387j);
        this.f17386i = this.f17386i > C0154a.f2960p ? 0 : this.f17386i;
        this.f17386i = this.f17386i < 0 ? 0 : this.f17386i;
        this.f17395r = new Paint();
        this.f17395r.setColor(this.f17378A.getColorForState(getDrawableState(), 0));
        this.f17395r.setAntiAlias(true);
        this.f17395r.setStyle(Style.STROKE);
        this.f17395r.setStrokeWidth((float) this.f17385h);
        this.f17396s = new Paint();
        this.f17396s.setColor(this.f17379B.getColorForState(getDrawableState(), 0));
        this.f17396s.setAntiAlias(true);
        this.f17396s.setStyle(Style.STROKE);
        this.f17396s.setStrokeWidth((float) this.f17384g);
        if (this.f17389l) {
            this.f17395r.setStrokeCap(Cap.ROUND);
            this.f17396s.setStrokeCap(Cap.ROUND);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (!this.f17391n) {
            canvas.scale(-1.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, this.f17394q.centerX(), this.f17394q.centerY());
        }
        int i = (this.f17386i - 90) + this.f17388k;
        int i2 = this.f17387j;
        this.f17393p = this.f17393p == 0.0f ? 0.1f : this.f17393p;
        canvas.drawArc(this.f17394q, (float) i, (float) i2, false, this.f17395r);
        canvas.drawArc(this.f17394q, (float) i, this.f17393p, false, this.f17396s);
        canvas.translate((float) (this.f17397t - this.f17399v), (float) (this.f17398u - this.f17400w));
        this.f17381d.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumHeight(), i2);
        int defaultSize2 = getDefaultSize(getSuggestedMinimumWidth(), i);
        int min = Math.min(defaultSize2, defaultSize);
        this.f17397t = (int) (((float) defaultSize2) * 0.5f);
        this.f17398u = (int) (((float) defaultSize) * 0.5f);
        min -= getPaddingLeft();
        this.f17392o = min / 2;
        float f = (float) ((defaultSize / 2) - (min / 2));
        float f2 = (float) ((defaultSize2 / 2) - (min / 2));
        this.f17394q.set(f2, f, ((float) min) + f2, ((float) min) + f);
        defaultSize = ((((int) this.f17393p) + this.f17386i) + this.f17388k) + 90;
        this.f17399v = (int) (((double) this.f17392o) * Math.cos(Math.toRadians((double) defaultSize)));
        this.f17400w = (int) (Math.sin(Math.toRadians((double) defaultSize)) * ((double) this.f17392o));
        setTouchInSide(this.f17390m);
        super.onMeasure(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (motionEvent.getAction()) {
            case 0:
                m27005a();
                m27008a(motionEvent);
                return true;
            case 1:
                m27011b();
                setPressed(false);
                getParent().requestDisallowInterceptTouchEvent(false);
                return true;
            case 2:
                m27008a(motionEvent);
                return true;
            case 3:
                m27011b();
                setPressed(false);
                getParent().requestDisallowInterceptTouchEvent(false);
                return true;
            default:
                return true;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f17381d != null && this.f17381d.isStateful()) {
            this.f17381d.setState(getDrawableState());
        }
        if (!(this.f17395r == null || this.f17396s == null)) {
            this.f17395r.setColor(this.f17378A.getColorForState(getDrawableState(), 0));
            this.f17396s.setColor(this.f17379B.getColorForState(getDrawableState(), 0));
        }
        invalidate();
    }

    private void m27005a() {
        if (this.f17403z != null) {
            this.f17403z.mo2594a(this);
        }
    }

    private void m27011b() {
        if (this.f17403z != null) {
            this.f17403z.mo2596b(this);
        }
    }

    private void m27008a(MotionEvent motionEvent) {
        if (!m27009a(motionEvent.getX(), motionEvent.getY())) {
            setPressed(true);
            this.f17401x = m27010b(motionEvent.getX(), motionEvent.getY());
            m27006a(m27004a(this.f17401x), true);
        }
    }

    private boolean m27009a(float f, float f2) {
        float f3 = f - ((float) this.f17397t);
        float f4 = f2 - ((float) this.f17398u);
        if (((float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)))) < this.f17402y) {
            return true;
        }
        return false;
    }

    private double m27010b(float f, float f2) {
        float f3 = f - ((float) this.f17397t);
        float f4 = f2 - ((float) this.f17398u);
        if (!this.f17391n) {
            f3 = -f3;
        }
        double toDegrees = Math.toDegrees((Math.atan2((double) f4, (double) f3) + 1.5707963267948966d) - Math.toRadians((double) this.f17388k));
        if (toDegrees < 0.0d) {
            toDegrees += 360.0d;
        }
        return toDegrees - ((double) this.f17386i);
    }

    private int m27004a(double d) {
        int round = (int) Math.round(((double) m27013c()) * d);
        if (round < 0) {
            round = f17377b;
        }
        if (round > this.f17382e) {
            return f17377b;
        }
        return round;
    }

    private float m27013c() {
        return ((float) this.f17382e) / ((float) this.f17387j);
    }

    private void m27006a(int i, boolean z) {
        m27012b(i, z);
    }

    private void m27014d() {
        int i = (int) (((((float) this.f17386i) + this.f17393p) + ((float) this.f17388k)) + 90.0f);
        this.f17399v = (int) (((double) this.f17392o) * Math.cos(Math.toRadians((double) i)));
        this.f17400w = (int) (Math.sin(Math.toRadians((double) i)) * ((double) this.f17392o));
    }

    private void m27012b(int i, boolean z) {
        if (i != f17377b) {
            int i2 = i > this.f17382e ? this.f17382e : i;
            if (i2 < 0) {
                i2 = 0;
            }
            this.f17383f = i2;
            if (this.f17403z != null) {
                this.f17403z.mo2595a(this, i2, z);
            }
            this.f17393p = (((float) i2) / ((float) this.f17382e)) * ((float) this.f17387j);
            m27014d();
            invalidate();
        }
    }

    public void setOnSeekArcChangeListener(hea com_ushareit_listenit_hea) {
        this.f17403z = com_ushareit_listenit_hea;
    }

    public void setProgress(int i) {
        m27012b(i, false);
    }

    public int getProgress() {
        return this.f17383f;
    }

    public int getProgressWidth() {
        return this.f17384g;
    }

    public void setProgressWidth(int i) {
        this.f17384g = i;
        this.f17396s.setStrokeWidth((float) i);
    }

    public int getArcWidth() {
        return this.f17385h;
    }

    public void setArcWidth(int i) {
        this.f17385h = i;
        this.f17395r.setStrokeWidth((float) i);
    }

    public int getArcRotation() {
        return this.f17388k;
    }

    public void setArcRotation(int i) {
        this.f17388k = i;
        m27014d();
    }

    public int getStartAngle() {
        return this.f17386i;
    }

    public void setStartAngle(int i) {
        this.f17386i = i;
        m27014d();
    }

    public int getSweepAngle() {
        return this.f17387j;
    }

    public void setSweepAngle(int i) {
        this.f17387j = i;
        m27014d();
    }

    public void setRoundedEdges(boolean z) {
        this.f17389l = z;
        if (this.f17389l) {
            this.f17395r.setStrokeCap(Cap.ROUND);
            this.f17396s.setStrokeCap(Cap.ROUND);
            return;
        }
        this.f17395r.setStrokeCap(Cap.SQUARE);
        this.f17396s.setStrokeCap(Cap.SQUARE);
    }

    public void setTouchInSide(boolean z) {
        int intrinsicHeight = this.f17381d.getIntrinsicHeight() / 2;
        int intrinsicWidth = this.f17381d.getIntrinsicWidth() / 2;
        this.f17390m = z;
        if (this.f17390m) {
            this.f17402y = ((float) this.f17392o) / 4.0f;
        } else {
            this.f17402y = (float) (this.f17392o - Math.min(intrinsicWidth, intrinsicHeight));
        }
    }

    public void setClockwise(boolean z) {
        this.f17391n = z;
    }

    public int getProgressColor() {
        return this.f17396s.getColor();
    }

    public void setProgressColor(int i) {
        this.f17396s.setColor(i);
        invalidate();
    }

    public int getArcColor() {
        return this.f17395r.getColor();
    }

    public void setArcColor(int i) {
        this.f17395r.setColor(i);
        invalidate();
    }

    public int getMax() {
        return this.f17382e;
    }

    public void setMax(int i) {
        this.f17382e = i;
    }
}
