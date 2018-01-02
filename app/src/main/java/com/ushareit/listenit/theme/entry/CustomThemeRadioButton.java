package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeRadioButton extends RadioButton implements hhg {
    private ColorStateList f16678a = getTextColors();
    private ColorStateList f16679b;
    private ColorStateList f16680c;
    private Drawable f16681d;
    private boolean f16682e;
    private gxi f16683f = new gxi(this);

    public CustomThemeRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeRadioButton, 0, 0);
        this.f16679b = obtainStyledAttributes.getColorStateList(1);
        this.f16680c = obtainStyledAttributes.getColorStateList(2);
        this.f16681d = obtainStyledAttributes.getDrawable(0);
        this.f16682e = obtainStyledAttributes.getBoolean(3, false);
        obtainStyledAttributes.recycle();
        setButtonDrawable(this.f16681d);
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16679b != null) {
                    setTextColor(this.f16679b);
                }
                if (this.f16681d != null && this.f16680c != null) {
                    hhe.m23348a(this.f16681d, this.f16680c.getColorForState(getDrawableState(), 0));
                    return;
                }
                return;
            case 2:
                if (this.f16682e && isChecked() && this.f16681d != null) {
                    hhe.m23348a(this.f16681d, gzd.m23358b());
                } else if (this.f16681d != null) {
                    hhe.m23347a(this.f16681d);
                }
                if (this.f16678a != null) {
                    setTextColor(this.f16678a);
                    return;
                }
                return;
            default:
                if (this.f16678a != null) {
                    setTextColor(this.f16678a);
                }
                if (this.f16681d != null) {
                    hhe.m23347a(this.f16681d);
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
        hhf.m23856a(this.f16683f);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16683f);
        super.onDetachedFromWindow();
    }
}
