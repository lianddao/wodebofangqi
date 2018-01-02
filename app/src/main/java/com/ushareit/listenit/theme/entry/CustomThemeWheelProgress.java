package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.util.AttributeSet;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;
import com.ushareit.listenit.widget.WheelProgress;

public class CustomThemeWheelProgress extends WheelProgress implements hhg {
    private int f16756a;
    private int f16757b;
    private gxi f16758c = new gxi(this);

    public CustomThemeWheelProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16756a = context.getResources().getColor(C0349R.color.common_text_color_orange);
        this.f16757b = context.getResources().getColor(C0349R.color.common_text_color_orange_night_1);
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                setBarColor(this.f16757b);
                return;
            case 2:
                setBarColor(gzd.m23358b());
                return;
            default:
                setBarColor(this.f16756a);
                return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16758c);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16758c);
        super.onDetachedFromWindow();
    }
}
