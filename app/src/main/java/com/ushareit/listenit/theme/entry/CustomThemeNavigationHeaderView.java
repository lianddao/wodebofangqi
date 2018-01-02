package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeNavigationHeaderView extends View implements hhg {
    private gxi f16671a = new gxi(this);

    public CustomThemeNavigationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void setTheme(Context context) {
        if (getBackground() != null) {
            switch (gzd.m23364e()) {
                case 1:
                    hhe.m23350b(getBackground(), getResources().getColor(C0349R.color.orange_button_normal_color_night));
                    return;
                case 2:
                    int b = gzd.m23358b();
                    float[] fArr = new float[3];
                    Color.colorToHSV(b, fArr);
                    if (fArr[2] < 0.2f) {
                        hhe.m23350b(getBackground(), getResources().getColor(C0349R.color.orange_button_normal_color_night));
                        return;
                    } else {
                        hhe.m23350b(getBackground(), b);
                        return;
                    }
                default:
                    hhe.m23350b(getBackground(), gzd.m23368g());
                    return;
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16671a);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16671a);
        super.onDetachedFromWindow();
    }
}
