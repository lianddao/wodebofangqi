package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.util.AttributeSet;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;
import com.ushareit.listenit.widget.LineEditView;

public class CustomThemeLineEditView extends LineEditView implements hhg {
    private boolean f16665g;
    private gxi f16666h = new gxi(this);

    public CustomThemeLineEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26318d();
        setTheme(context);
    }

    public void setTheme(Context context) {
        m26318d();
        if (!isEnabled()) {
            setLineHeightAndBackground(2, this.c);
        } else if (this.f16665g) {
            setLineHeightAndBackground(4, this.e);
        } else if (this.f) {
            setLineHeightAndBackground(4, this.d);
        } else {
            setLineHeightAndBackground(2, this.b);
        }
    }

    public void setEnable(boolean z) {
        int color;
        this.a.setEnabled(z);
        if (gzd.m23364e() == 1) {
            color = getResources().getColor(C0349R.color.common_text_color_gray_9_night);
        } else {
            color = getResources().getColor(C0349R.color.common_text_color_gray_9);
        }
        this.a.setTextColor(color);
    }

    public void setErrorState(boolean z) {
        this.f16665g = z;
        setTheme(getContext());
    }

    private void m26318d() {
        int e = gzd.m23364e();
        if (e == 1) {
            this.b = getResources().getColor(C0349R.color.stroke_color_normal_night);
            this.c = getResources().getColor(C0349R.color.stroke_color_disabled_night);
            this.d = getResources().getColor(C0349R.color.stroke_color_focused_night);
            this.e = getResources().getColor(C0349R.color.stroke_color_error_night);
            return;
        }
        this.b = getResources().getColor(C0349R.color.stroke_color_normal);
        this.c = getResources().getColor(C0349R.color.stroke_color_disabled);
        if (e == 2) {
            this.d = gzd.m23358b();
        } else {
            this.d = getResources().getColor(C0349R.color.stroke_color_focused);
        }
        this.e = getResources().getColor(C0349R.color.stroke_color_error);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16666h);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16666h);
        super.onDetachedFromWindow();
    }
}
