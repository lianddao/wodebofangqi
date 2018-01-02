package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeScrollView extends ScrollView implements hhg {
    private Drawable f16691a = getBackground();
    private Drawable f16692b;
    private gxi f16693c = new gxi(this);

    public CustomThemeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeScrollView, 0, 0);
        this.f16692b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16692b != null) {
                    setBackgroundDrawable(this.f16692b);
                    return;
                }
                return;
            default:
                if (this.f16691a != null) {
                    setBackgroundDrawable(this.f16691a);
                    return;
                }
                return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16693c);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16693c);
        super.onDetachedFromWindow();
    }
}
