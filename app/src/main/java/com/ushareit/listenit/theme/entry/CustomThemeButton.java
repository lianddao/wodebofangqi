package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.ery;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeButton extends Button implements hhg {
    private ColorStateList f16619a;
    private ColorStateList f16620b;
    private Drawable f16621c;
    private Drawable f16622d;
    private float f16623e;
    private float f16624f;
    private boolean f16625g;
    private gxi f16626h;

    public CustomThemeButton(Context context) {
        super(context);
        this.f16626h = new gxi(this);
    }

    public CustomThemeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16626h = new gxi(this);
        this.f16619a = getTextColors();
        this.f16621c = getBackground();
        this.f16623e = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeButton, 0, 0);
        this.f16620b = obtainStyledAttributes.getColorStateList(0);
        this.f16622d = obtainStyledAttributes.getDrawable(1);
        this.f16625g = obtainStyledAttributes.getBoolean(2, false);
        this.f16624f = obtainStyledAttributes.getFraction(3, 100, 1, 100.0f) / 100.0f;
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (gzd.m23364e()) {
            case 1:
                if (this.f16620b != null) {
                    setTextColor(this.f16620b);
                }
                if (this.f16622d != null) {
                    setBackgroundDrawable(hhe.m23347a(this.f16622d));
                }
                if (this.f16624f != erj.m17569a(this)) {
                    erj.m17570a(this, this.f16624f);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            case 2:
                if (this.f16619a != null) {
                    setTextColor(this.f16619a);
                }
                if (this.f16625g && getBackground() != null) {
                    hhe.m23351c(getBackground(), gzd.m23353a(getDrawableState()));
                } else if (this.f16621c != null) {
                    setBackgroundDrawable(hhe.m23347a(this.f16621c));
                }
                if (erj.m17569a(this) != this.f16623e) {
                    erj.m17570a(this, this.f16623e);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            default:
                if (this.f16619a != null) {
                    setTextColor(this.f16619a);
                }
                if (this.f16621c != null) {
                    setBackgroundDrawable(hhe.m23347a(this.f16621c));
                }
                if (erj.m17569a(this) != this.f16623e) {
                    erj.m17570a(this, this.f16623e);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setTheme(getContext());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16626h);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16626h);
        super.onDetachedFromWindow();
    }
}
