package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
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

public class CustomThemeTextView extends TextView implements hhg {
    private ColorStateList f16715a = getTextColors();
    private ColorStateList f16716b;
    private Drawable f16717c = getBackground();
    private Drawable f16718d;
    private float f16719e = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f16720f;
    private boolean f16721g;
    private boolean f16722h;
    private int f16723i = hashCode();
    private gxi f16724j = new gxi(this);

    public CustomThemeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeTextView, 0, 0);
        this.f16716b = obtainStyledAttributes.getColorStateList(0);
        this.f16718d = obtainStyledAttributes.getDrawable(1);
        this.f16721g = obtainStyledAttributes.getBoolean(3, false);
        this.f16722h = obtainStyledAttributes.getBoolean(4, false);
        this.f16720f = obtainStyledAttributes.getFraction(2, 100, 1, 100.0f) / 100.0f;
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16716b != null) {
                    setTextColor(this.f16716b);
                }
                m26329a();
                if (this.f16720f != erj.m17569a(this)) {
                    erj.m17570a(this, this.f16720f);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            case 2:
                if (this.f16721g) {
                    setTextColor(gzd.m23355a());
                } else if (this.f16715a != null) {
                    setTextColor(this.f16715a);
                }
                m26330b();
                if (erj.m17569a(this) != this.f16719e) {
                    erj.m17570a(this, this.f16719e);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            default:
                if (this.f16715a != null) {
                    setTextColor(this.f16715a);
                }
                m26331c();
                if (erj.m17569a(this) != this.f16719e) {
                    erj.m17570a(this, this.f16719e);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
        }
    }

    private void m26329a() {
        if (this.f16718d != null) {
            setBackgroundDrawable(hhe.m23347a(this.f16718d));
        }
    }

    private void m26330b() {
        if (this.f16722h) {
            setBackgroundDrawable(hhe.m23351c(this.f16717c, gzd.m23358b()));
        } else if (this.f16717c != null) {
            setBackgroundDrawable(hhe.m23347a(this.f16717c));
        }
    }

    private void m26331c() {
        if (this.f16722h) {
            setBackgroundDrawable(hhe.m23347a(this.f16717c));
        } else if (this.f16717c != null) {
            setBackgroundDrawable(hhe.m23347a(this.f16717c));
        }
    }

    public void setTextColor(int i, int i2) {
        int b = ((ListenItApp) getContext().getApplicationContext()).m4934b();
        Resources resources = getResources();
        if (b != 1) {
            i2 = i;
        }
        setTextColor(resources.getColorStateList(i2));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16724j);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16724j);
        super.onDetachedFromWindow();
    }
}
