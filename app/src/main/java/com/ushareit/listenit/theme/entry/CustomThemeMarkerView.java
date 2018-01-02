package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.util.AttributeSet;
import com.ushareit.listenit.cutter.view.MarkerView;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeMarkerView extends MarkerView implements hhg {
    private gxi f16670a = new gxi(this);

    public CustomThemeMarkerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTheme(Context context) {
        for (int i : getDrawableState()) {
            if (i == 16842908) {
                hhe.m23350b(getDrawable(), gzd.m23358b());
                return;
            }
        }
        hhe.m23347a(getDrawable());
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setTheme(getContext());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16670a);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16670a);
        super.onDetachedFromWindow();
    }
}
