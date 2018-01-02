package com.ushareit.listenit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.eqd;
import java.util.Locale;

public class SwitchButton extends CompoundButton {
    private RectF f16698a;
    private RectF f16699b;
    private RectF f16700c;
    private RectF f16701d;
    private Drawable f16702e;
    private eqd f16703f;
    private int f16704g;
    private int f16705h;
    private float f16706i = 0.0f;
    private float f16707j;
    private float f16708k;
    private boolean f16709l = false;
    private OnCheckedChangeListener f16710m;

    public SwitchButton(Context context) {
        super(context);
        m26322a(null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26322a(attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26322a(attributeSet);
    }

    private void m26322a(AttributeSet attributeSet) {
        boolean z = true;
        this.f16704g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f16705h = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, C0349R.styleable.SwitchButton, 0, 0);
            try {
                this.f16702e = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f16698a = new RectF();
        this.f16699b = new RectF();
        this.f16700c = new RectF();
        this.f16701d = new RectF();
        setClickable(true);
        if (VERSION.SDK_INT >= 17) {
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                z = false;
            }
            this.f16709l = z;
        }
        if (this.f16709l) {
            this.f16703f = eqd.m17401a(this, "process", DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT).mo2251b(250);
            this.f16703f.m17383a(new AccelerateDecelerateInterpolator());
            return;
        }
        this.f16703f = eqd.m17401a(this, "process", 0.0f, 0.0f).mo2251b(250);
        this.f16703f.m17383a(new AccelerateDecelerateInterpolator());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3 || i2 != i4) {
            this.f16698a.set(0.0f, 0.0f, (float) i2, (float) i2);
            this.f16699b.set(0.0f, 0.0f, (float) i, (float) i2);
            getBackground().setBounds((int) this.f16699b.left, (int) this.f16699b.top, m26321a((double) this.f16699b.right), m26321a((double) this.f16699b.bottom));
            this.f16700c.set(this.f16698a.left, 0.0f, this.f16699b.right - this.f16698a.width(), 0.0f);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getBackground().draw(canvas);
        this.f16701d.set(this.f16698a);
        this.f16701d.offset(this.f16706i * this.f16700c.width(), 0.0f);
        this.f16702e.setBounds((int) this.f16701d.left, (int) this.f16701d.top, m26321a((double) this.f16701d.right), m26321a((double) this.f16701d.bottom));
        this.f16702e.draw(canvas);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f16702e.setState(getDrawableState());
        getBackground().setState(getDrawableState());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isClickable()) {
            return false;
        }
        float x = motionEvent.getX() - this.f16707j;
        switch (motionEvent.getAction()) {
            case 0:
                this.f16707j = motionEvent.getX();
                this.f16708k = this.f16707j;
                return true;
            case 1:
            case 3:
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x >= ((float) this.f16704g) || 0.0f >= ((float) this.f16704g) || eventTime >= ((float) this.f16705h)) {
                    boolean z = this.f16709l ? getProcess() < 0.5f : getProcess() > 0.5f;
                    if (z != isChecked()) {
                        playSoundEffect(0);
                        setChecked(z);
                        return true;
                    }
                    m26323a(z);
                    return true;
                }
                performClick();
                return true;
            case 2:
                x = motionEvent.getX();
                setProcess(getProcess() + ((x - this.f16708k) / this.f16700c.width()));
                this.f16708k = x;
                return true;
            default:
                return true;
        }
    }

    public void setChecked(boolean z) {
        if (isChecked() != z) {
            m26323a(z);
        }
        super.setChecked(z);
    }

    public void setCheckedImmediately(boolean z) {
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        float f2 = 0.0f;
        if (this.f16710m != null) {
            super.setOnCheckedChangeListener(null);
        }
        super.setChecked(z);
        if (this.f16703f != null && this.f16703f.mo2236c()) {
            this.f16703f.mo2235b();
        }
        if (this.f16709l) {
            if (!z) {
                f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            }
            setProcess(f2);
        } else {
            if (!z) {
                f = 0.0f;
            }
            setProcess(f);
        }
        invalidate();
        if (this.f16710m != null) {
            super.setOnCheckedChangeListener(this.f16710m);
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.f16710m = onCheckedChangeListener;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f16702e = drawable;
        invalidate();
    }

    public Drawable getThumbDrawable() {
        return this.f16702e;
    }

    public final float getProcess() {
        return this.f16706i;
    }

    public final void setProcess(float f) {
        if (f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f16706i = f;
        invalidate();
    }

    private void m26323a(boolean z) {
        if (this.f16703f != null) {
            if (this.f16703f.mo2236c()) {
                this.f16703f.mo2235b();
            }
            this.f16703f.mo2251b(250);
            if (this.f16709l) {
                if (z) {
                    this.f16703f.mo2249a(this.f16706i, 0.0f);
                } else {
                    this.f16703f.mo2249a(this.f16706i, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                }
            } else if (z) {
                this.f16703f.mo2249a(this.f16706i, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            } else {
                this.f16703f.mo2249a(this.f16706i, 0.0f);
            }
            this.f16703f.mo2234a();
        }
    }

    private int m26321a(double d) {
        return (int) Math.ceil(d);
    }
}
