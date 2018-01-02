package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomShadowView extends ImageView implements hhg {
    private ColorStateList f16615a;
    private ColorStateList f16616b;
    private boolean f16617c;
    private gxi f16618d = new gxi(this);

    public CustomShadowView(Context context) {
        super(context);
    }

    public CustomShadowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26307a(context, attributeSet);
    }

    private void m26307a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeShadowView, 0, 0);
        this.f16615a = obtainStyledAttributes.getColorStateList(0);
        this.f16616b = obtainStyledAttributes.getColorStateList(1);
        this.f16617c = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) getContext().getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16615a != null) {
                    hhe.m23348a(getBackground(), this.f16615a.getColorForState(getDrawableState(), 0));
                } else {
                    hhe.m23347a(getBackground());
                }
                if (this.f16616b != null) {
                    setColorFilter(this.f16616b.getColorForState(getDrawableState(), 0));
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
                }
                if (this.f16617c) {
                    hhe.m23348a(getBackground(), gzd.m23358b());
                    return;
                } else {
                    hhe.m23347a(getBackground());
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
        hhf.m23856a(this.f16618d);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16618d);
        super.onDetachedFromWindow();
    }
}
