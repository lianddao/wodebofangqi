package com.ushareit.listenit.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.hef;
import com.ushareit.listenit.heg;

public class WheelProgress extends View {
    private final int f16731a = 16;
    private final int f16732b = 270;
    private final long f16733c = 200;
    private int f16734d = 28;
    private int f16735e = 4;
    private int f16736f = 4;
    private boolean f16737g = false;
    private double f16738h = 0.0d;
    private double f16739i = 460.0d;
    private float f16740j = 0.0f;
    private boolean f16741k = true;
    private long f16742l = 0;
    private int f16743m = -12022286;
    private int f16744n = 16777215;
    private Paint f16745o = new Paint();
    private Paint f16746p = new Paint();
    private RectF f16747q = new RectF();
    private float f16748r = 230.0f;
    private long f16749s = 0;
    private boolean f16750t;
    private float f16751u = 0.0f;
    private float f16752v = 0.0f;
    private boolean f16753w = false;
    private hef f16754x;
    private boolean f16755y;

    public class WheelSavedState extends BaseSavedState {
        public static final Creator<WheelSavedState> CREATOR = new heg();
        float f17412a;
        float f17413b;
        boolean f17414c;
        float f17415d;
        int f17416e;
        int f17417f;
        int f17418g;
        int f17419h;
        int f17420i;
        boolean f17421j;
        boolean f17422k;

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            super(parcel);
            this.f17412a = parcel.readFloat();
            this.f17413b = parcel.readFloat();
            this.f17414c = parcel.readByte() != (byte) 0;
            this.f17415d = parcel.readFloat();
            this.f17416e = parcel.readInt();
            this.f17417f = parcel.readInt();
            this.f17418g = parcel.readInt();
            this.f17419h = parcel.readInt();
            this.f17420i = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.f17421j = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.f17422k = z2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f17412a);
            parcel.writeFloat(this.f17413b);
            parcel.writeByte((byte) (this.f17414c ? 1 : 0));
            parcel.writeFloat(this.f17415d);
            parcel.writeInt(this.f17416e);
            parcel.writeInt(this.f17417f);
            parcel.writeInt(this.f17418g);
            parcel.writeInt(this.f17419h);
            parcel.writeInt(this.f17420i);
            if (this.f17421j) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (!this.f17422k) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
        }
    }

    public WheelProgress(Context context) {
        super(context);
        setAnimationEnabled();
    }

    public WheelProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26334a(context.obtainStyledAttributes(attributeSet, C0349R.styleable.WheelProgress));
        setAnimationEnabled();
    }

    public void setBarColor(int i) {
        this.f16743m = i;
    }

    @TargetApi(17)
    private void setAnimationEnabled() {
        float f;
        if (VERSION.SDK_INT >= 17) {
            f = Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        } else {
            f = System.getFloat(getContext().getContentResolver(), "animator_duration_scale", DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
        this.f16755y = f != 0.0f;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = (this.f16734d + getPaddingLeft()) + getPaddingRight();
        int paddingTop = (this.f16734d + getPaddingTop()) + getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(size, paddingTop);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setupBounds(i, i2);
        setupPaints();
        invalidate();
    }

    private void setupPaints() {
        this.f16745o.setColor(this.f16743m);
        this.f16745o.setAntiAlias(true);
        this.f16745o.setStyle(Style.STROKE);
        this.f16745o.setStrokeWidth((float) this.f16735e);
        this.f16746p.setColor(this.f16744n);
        this.f16746p.setAntiAlias(true);
        this.f16746p.setStyle(Style.STROKE);
        this.f16746p.setStrokeWidth((float) this.f16736f);
    }

    private void setupBounds(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.f16737g) {
            this.f16747q = new RectF((float) (paddingLeft + this.f16735e), (float) (paddingTop + this.f16735e), (float) ((i - paddingRight) - this.f16735e), (float) ((i2 - paddingBottom) - this.f16735e));
            return;
        }
        int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.f16734d * 2) - (this.f16735e * 2));
        paddingLeft += (((i - paddingLeft) - paddingRight) - min) / 2;
        paddingTop += (((i2 - paddingTop) - paddingBottom) - min) / 2;
        this.f16747q = new RectF((float) (this.f16735e + paddingLeft), (float) (this.f16735e + paddingTop), (float) ((paddingLeft + min) - this.f16735e), (float) ((paddingTop + min) - this.f16735e));
    }

    private void m26334a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f16735e = (int) TypedValue.applyDimension(1, (float) this.f16735e, displayMetrics);
        this.f16736f = (int) TypedValue.applyDimension(1, (float) this.f16736f, displayMetrics);
        this.f16734d = (int) TypedValue.applyDimension(1, (float) this.f16734d, displayMetrics);
        this.f16734d = (int) typedArray.getDimension(6, (float) this.f16734d);
        this.f16737g = typedArray.getBoolean(7, false);
        this.f16735e = (int) typedArray.getDimension(8, (float) this.f16735e);
        this.f16736f = (int) typedArray.getDimension(3, (float) this.f16736f);
        this.f16748r = typedArray.getFloat(4, this.f16748r / 360.0f) * 360.0f;
        this.f16739i = (double) typedArray.getInt(5, (int) this.f16739i);
        this.f16743m = typedArray.getColor(1, this.f16743m);
        this.f16744n = typedArray.getColor(2, this.f16744n);
        this.f16750t = typedArray.getBoolean(9, false);
        if (typedArray.getBoolean(0, false)) {
            m26336a();
        }
        typedArray.recycle();
    }

    public void setCallback(hef com_ushareit_listenit_hef) {
        this.f16754x = com_ushareit_listenit_hef;
        if (!this.f16753w) {
            m26335b();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f16747q, 360.0f, 360.0f, false, this.f16746p);
        Object obj = null;
        if (this.f16755y) {
            Object obj2;
            float f;
            float f2;
            if (this.f16753w) {
                obj2 = 1;
                long uptimeMillis = SystemClock.uptimeMillis() - this.f16749s;
                f = (((float) uptimeMillis) * this.f16748r) / 1000.0f;
                m26333a(uptimeMillis);
                this.f16751u += f;
                if (this.f16751u > 360.0f) {
                    this.f16751u -= 360.0f;
                    m26332a(-1.0f);
                }
                this.f16749s = SystemClock.uptimeMillis();
                f = this.f16751u - 90.0f;
                f2 = 16.0f + this.f16740j;
                if (isInEditMode()) {
                    f = 0.0f;
                    f2 = 135.0f;
                }
                canvas.drawArc(this.f16747q, f, f2, false, this.f16745o);
            } else {
                float f3 = this.f16751u;
                if (this.f16751u != this.f16752v) {
                    obj = 1;
                    this.f16751u = Math.min(((((float) (SystemClock.uptimeMillis() - this.f16749s)) / 1000.0f) * this.f16748r) + this.f16751u, this.f16752v);
                    this.f16749s = SystemClock.uptimeMillis();
                }
                obj2 = obj;
                if (f3 != this.f16751u) {
                    m26335b();
                }
                float f4 = this.f16751u;
                if (this.f16750t) {
                    f = 0.0f;
                } else {
                    f4 = ((float) (1.0d - Math.pow((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - (this.f16751u / 360.0f)), (double) 1073741824))) * 360.0f;
                    f = ((float) (1.0d - Math.pow((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - (this.f16751u / 360.0f)), (double) (2.0f * 2.0f)))) * 360.0f;
                }
                if (isInEditMode()) {
                    f2 = 360.0f;
                } else {
                    f2 = f4;
                }
                canvas.drawArc(this.f16747q, f - 90.0f, f2, false, this.f16745o);
            }
            if (obj2 != null) {
                invalidate();
            }
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.f16749s = SystemClock.uptimeMillis();
        }
    }

    private void m26333a(long j) {
        if (this.f16742l >= 200) {
            this.f16738h += (double) j;
            if (this.f16738h > this.f16739i) {
                this.f16738h -= this.f16739i;
                this.f16742l = 0;
                this.f16741k = !this.f16741k;
            }
            float cos = (((float) Math.cos(((this.f16738h / this.f16739i) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.f16741k) {
                this.f16740j = cos * 254.0f;
                return;
            }
            cos = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - cos) * 254.0f;
            this.f16751u += this.f16740j - cos;
            this.f16740j = cos;
            return;
        }
        this.f16742l += j;
    }

    public void m26336a() {
        this.f16749s = SystemClock.uptimeMillis();
        this.f16753w = true;
        invalidate();
    }

    private void m26332a(float f) {
        if (this.f16754x != null) {
            this.f16754x.m23598a(f);
        }
    }

    private void m26335b() {
        if (this.f16754x != null) {
            this.f16754x.m23598a(((float) Math.round((this.f16751u * 100.0f) / 360.0f)) / 100.0f);
        }
    }

    public void setInstantProgress(float f) {
        if (this.f16753w) {
            this.f16751u = 0.0f;
            this.f16753w = false;
        }
        if (f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            f -= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f != this.f16752v) {
            this.f16752v = Math.min(f * 360.0f, 360.0f);
            this.f16751u = this.f16752v;
            this.f16749s = SystemClock.uptimeMillis();
            invalidate();
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f17412a = this.f16751u;
        wheelSavedState.f17413b = this.f16752v;
        wheelSavedState.f17414c = this.f16753w;
        wheelSavedState.f17415d = this.f16748r;
        wheelSavedState.f17416e = this.f16735e;
        wheelSavedState.f17417f = this.f16743m;
        wheelSavedState.f17418g = this.f16736f;
        wheelSavedState.f17419h = this.f16744n;
        wheelSavedState.f17420i = this.f16734d;
        wheelSavedState.f17421j = this.f16750t;
        wheelSavedState.f17422k = this.f16737g;
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof WheelSavedState) {
            WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
            super.onRestoreInstanceState(wheelSavedState.getSuperState());
            this.f16751u = wheelSavedState.f17412a;
            this.f16752v = wheelSavedState.f17413b;
            this.f16753w = wheelSavedState.f17414c;
            this.f16748r = wheelSavedState.f17415d;
            this.f16735e = wheelSavedState.f17416e;
            this.f16743m = wheelSavedState.f17417f;
            this.f16736f = wheelSavedState.f17418g;
            this.f16744n = wheelSavedState.f17419h;
            this.f16734d = wheelSavedState.f17420i;
            this.f16750t = wheelSavedState.f17421j;
            this.f16737g = wheelSavedState.f17422k;
            this.f16749s = SystemClock.uptimeMillis();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setLinearProgress(boolean z) {
        this.f16750t = z;
        if (!this.f16753w) {
            invalidate();
        }
    }
}
