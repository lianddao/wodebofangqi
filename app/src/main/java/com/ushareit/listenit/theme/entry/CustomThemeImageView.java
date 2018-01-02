package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.ery;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeImageView extends ImageView implements hhg {
    private ColorStateList f16648a;
    private ColorStateList f16649b;
    private float f16650c;
    private float f16651d;
    private boolean f16652e;
    private int f16653f;
    private int f16654g;
    private gxi f16655h = new gxi(this);

    public CustomThemeImageView(Context context) {
        super(context);
    }

    public CustomThemeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26311a(context, attributeSet);
    }

    private void m26311a(Context context, AttributeSet attributeSet) {
        this.f16650c = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeImageView, 0, 0);
        this.f16648a = obtainStyledAttributes.getColorStateList(0);
        this.f16649b = obtainStyledAttributes.getColorStateList(2);
        this.f16653f = obtainStyledAttributes.getInt(4, -1);
        this.f16652e = obtainStyledAttributes.getBoolean(6, false);
        this.f16651d = obtainStyledAttributes.getFraction(3, 100, 1, 100.0f) / 100.0f;
        this.f16654g = obtainStyledAttributes.getInt(5, 0);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) getContext().getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16649b != null) {
                    hhe.m23348a(getBackground(), this.f16649b.getColorForState(getDrawableState(), 0));
                }
                if (this.f16648a != null) {
                    setColorFilter(this.f16648a.getColorForState(getDrawableState(), 0));
                }
                if (this.f16651d != erj.m17569a(this)) {
                    erj.m17570a(this, this.f16651d);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            case 2:
                if (this.f16653f == 1 && getBackground() != null) {
                    hhe.m23351c(getBackground(), gzd.m23363d(this.f16654g));
                } else if (this.f16653f == 2 && getBackground() != null) {
                    hhe.m23351c(getBackground(), gzd.m23354a(getDrawableState(), this.f16654g));
                } else if (getBackground() != null) {
                    hhe.m23347a(getBackground());
                }
                if (this.f16652e && isEnabled()) {
                    setColorFilter(gzd.m23354a(getDrawableState(), this.f16654g));
                } else if (getDrawable() != null) {
                    clearColorFilter();
                }
                if (erj.m17569a(this) != this.f16650c) {
                    erj.m17570a(this, this.f16650c);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            default:
                if (getBackground() != null) {
                    hhe.m23347a(getBackground());
                }
                if (getDrawable() != null) {
                    clearColorFilter();
                }
                if (erj.m17569a(this) != this.f16650c) {
                    erj.m17570a(this, this.f16650c);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        setTheme(getContext());
    }

    public void setImageColorDrawable(int i, int i2) {
        int e = gzd.m23364e();
        Resources resources = getResources();
        if (e != 1) {
            i2 = i;
        }
        setImageDrawable(new ColorDrawable(resources.getColor(i2)));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setTheme(getContext());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16655h);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16655h);
        super.onDetachedFromWindow();
    }
}
