package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeFrameLayout extends FrameLayout implements hhg {
    private Drawable f16645a = getBackground();
    private Drawable f16646b;
    private gxi f16647c = new gxi(this);

    public CustomThemeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeFrameLayout, 0, 0);
        this.f16646b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16646b != null) {
                    setBackgroundDrawable(this.f16646b);
                    return;
                }
                return;
            default:
                if (this.f16645a != null) {
                    setBackgroundDrawable(this.f16645a);
                    return;
                }
                return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16647c);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16647c);
        super.onDetachedFromWindow();
    }
}
