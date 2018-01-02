package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;
import com.ushareit.listenit.widget.CustomCheckView;

public class CustomThemeCheckView extends CustomCheckView implements hhg {
    private ColorStateList f16630a;
    private boolean f16631b;
    private gxi f16632c = new gxi(this);

    public CustomThemeCheckView(Context context) {
        super(context);
    }

    public CustomThemeCheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26309a(context, attributeSet);
    }

    private void m26309a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeCheckView, 0, 0);
        this.f16630a = obtainStyledAttributes.getColorStateList(0);
        this.f16631b = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) getContext().getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16630a != null) {
                    setColorFilter(this.f16630a.getColorForState(getDrawableState(), 0));
                    return;
                }
                return;
            case 2:
                if (this.f16631b && isChecked()) {
                    setColorFilter(gzd.m23358b());
                    return;
                } else if (getDrawable() != null) {
                    clearColorFilter();
                    return;
                } else {
                    return;
                }
            default:
                if (getDrawable() != null) {
                    clearColorFilter();
                    return;
                }
                return;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setTheme(getContext());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16632c);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16632c);
        super.onDetachedFromWindow();
    }
}
