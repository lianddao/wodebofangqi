package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeProgressBar extends ProgressBar implements hhg {
    private Drawable f16674a = m26319a(getProgressDrawable());
    private ColorStateList f16675b;
    private boolean f16676c;
    private gxi f16677d = new gxi(this);

    public CustomThemeProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeProgressBar, 0, 0);
        this.f16675b = obtainStyledAttributes.getColorStateList(0);
        this.f16676c = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        if (this.f16674a != null) {
            switch (gzd.m23364e()) {
                case 1:
                    if (this.f16675b != null) {
                        hhe.m23348a(this.f16674a, this.f16675b.getDefaultColor());
                        return;
                    }
                    return;
                case 2:
                    hhe.m23348a(this.f16674a, gzd.m23358b());
                    return;
                default:
                    hhe.m23347a(this.f16674a);
                    return;
            }
        }
    }

    private Drawable m26319a(Drawable drawable) {
        Drawable drawable2 = null;
        if (drawable instanceof LayerDrawable) {
            try {
                drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(16908301);
            } catch (Exception e) {
            }
        }
        return drawable2;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16677d);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16677d);
        super.onDetachedFromWindow();
    }
}
