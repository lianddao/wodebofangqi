package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;
import com.ushareit.listenit.widget.SwitchButton;

public class CustomThemeSwitchButton extends SwitchButton implements hhg {
    private ColorStateList f16711a;
    private ColorStateList f16712b;
    private boolean f16713c;
    private gxi f16714d = new gxi(this);

    public CustomThemeSwitchButton(Context context) {
        super(context);
    }

    public CustomThemeSwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26326a(context, attributeSet);
    }

    private void m26326a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeSwitchButton, 0, 0);
        this.f16711a = obtainStyledAttributes.getColorStateList(0);
        this.f16712b = obtainStyledAttributes.getColorStateList(1);
        this.f16713c = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) eys.m18562a()).m4934b()) {
            case 1:
                if (!(this.f16711a == null || getThumbDrawable() == null)) {
                    hhe.m23348a(getThumbDrawable(), this.f16711a.getColorForState(getDrawableState(), 0));
                }
                if (this.f16712b != null && getBackground() != null) {
                    hhe.m23348a(getBackground(), this.f16712b.getColorForState(getDrawableState(), 0));
                    return;
                }
                return;
            case 2:
                if (this.f16713c) {
                    int b = gzd.m23358b();
                    if (getThumbDrawable() != null) {
                        hhe.m23348a(getThumbDrawable(), m26324a(b).getColorForState(getDrawableState(), b));
                    }
                    if (getBackground() != null) {
                        hhe.m23351c(getBackground(), m26327b(b).getColorForState(getDrawableState(), b));
                        return;
                    }
                    return;
                }
                if (getThumbDrawable() != null) {
                    hhe.m23347a(getThumbDrawable());
                }
                if (getBackground() != null) {
                    hhe.m23347a(getBackground());
                    return;
                }
                return;
            default:
                if (getThumbDrawable() != null) {
                    hhe.m23347a(getThumbDrawable());
                }
                if (getBackground() != null) {
                    hhe.m23347a(getBackground());
                    return;
                }
                return;
        }
    }

    private ColorStateList m26324a(int i) {
        return m26325a(i, 0, Color.parseColor("#D7D7D7"));
    }

    private ColorStateList m26327b(int i) {
        return m26325a(m26328c(i), Color.parseColor("#E0E0E0"), Color.parseColor("#B9B8B8"));
    }

    private int m26328c(int i) {
        float f = 0.0f;
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        if (fArr[0] - 6.0f > 0.0f) {
            f = fArr[0] - 6.0f;
        }
        fArr[0] = f;
        return Color.HSVToColor(76, fArr);
    }

    private ColorStateList m26325a(int i, int i2, int i3) {
        int[] iArr = new int[]{i3, i, i2};
        r1 = new int[3][];
        r1[0] = new int[]{-16842910};
        r1[1] = new int[]{16842912};
        r1[2] = new int[]{-16842912};
        return new ColorStateList(r1, iArr);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setTheme(getContext());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16714d);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16714d);
        super.onDetachedFromWindow();
    }
}
