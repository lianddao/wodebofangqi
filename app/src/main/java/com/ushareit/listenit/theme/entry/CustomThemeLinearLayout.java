package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeLinearLayout extends LinearLayout implements hhg {
    private Drawable f16667a;
    private Drawable f16668b;
    private gxi f16669c;

    public CustomThemeLinearLayout(Context context) {
        super(context);
        this.f16669c = new gxi(this);
    }

    public CustomThemeLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16669c = new gxi(this);
        this.f16667a = getBackground();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeLinearLayout, 0, 0);
        this.f16668b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16668b != null) {
                    setBackgroundDrawable(this.f16668b);
                    return;
                }
                return;
            default:
                if (this.f16667a != null) {
                    setBackgroundDrawable(this.f16667a);
                    return;
                }
                return;
        }
    }

    public void setBackgroundResource(int i, int i2) {
        if (((ListenItApp) getContext().getApplicationContext()).m4934b() != 1) {
            i2 = i;
        }
        setBackgroundResource(i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16669c);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16669c);
        super.onDetachedFromWindow();
    }
}
