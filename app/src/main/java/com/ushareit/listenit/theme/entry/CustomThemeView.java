package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.ery;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeView extends View implements hhg {
    private Drawable f16725a = getBackground();
    private Drawable f16726b;
    private float f16727c = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f16728d;
    private boolean f16729e;
    private gxi f16730f = new gxi(this);

    public CustomThemeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeView, 0, 0);
        this.f16726b = obtainStyledAttributes.getDrawable(0);
        this.f16729e = obtainStyledAttributes.getBoolean(2, false);
        this.f16728d = obtainStyledAttributes.getFraction(1, 100, 1, 100.0f) / 100.0f;
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16726b != null) {
                    setBackgroundDrawable(this.f16726b);
                }
                if (this.f16728d != this.f16727c) {
                    erj.m17570a(this, this.f16728d);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            case 2:
                if (this.f16729e) {
                    setBackgroundDrawable(new ColorDrawable(gzd.m23358b()));
                } else if (this.f16725a != null) {
                    setBackgroundDrawable(this.f16725a);
                }
                if (erj.m17569a(this) != this.f16727c) {
                    erj.m17570a(this, this.f16727c);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            default:
                if (this.f16725a != null) {
                    setBackgroundDrawable(this.f16725a);
                }
                if (erj.m17569a(this) != this.f16727c) {
                    erj.m17570a(this, this.f16727c);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16730f);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16730f);
        super.onDetachedFromWindow();
    }
}
