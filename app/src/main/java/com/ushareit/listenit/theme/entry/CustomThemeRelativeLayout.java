package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeRelativeLayout extends RelativeLayout implements hhg {
    private Drawable f16687a = getBackground();
    private Drawable f16688b;
    private boolean f16689c;
    private gxi f16690d = new gxi(this);

    public CustomThemeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeRelativeLayout, 0, 0);
        this.f16688b = obtainStyledAttributes.getDrawable(0);
        this.f16689c = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16688b != null) {
                    setBackgroundDrawable(this.f16688b);
                    return;
                }
                return;
            case 2:
                if (this.f16689c) {
                    setBackgroundDrawable(new ColorDrawable(gzd.m23358b()));
                    return;
                } else if (this.f16687a != null) {
                    setBackgroundDrawable(this.f16687a);
                    return;
                } else {
                    return;
                }
            default:
                if (this.f16687a != null) {
                    setBackgroundDrawable(this.f16687a);
                    return;
                }
                return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16690d);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16690d);
        super.onDetachedFromWindow();
    }
}
