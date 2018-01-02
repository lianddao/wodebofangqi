package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;
import com.ushareit.listenit.nearby.widget.NoLoginUserView;

public class CustomThemeNoLoginUserView extends NoLoginUserView implements hhg {
    private View f16672a = getChildAt(0);
    private gxi f16673b = new gxi(this);

    public CustomThemeNoLoginUserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                hhe.m23348a(this.f16672a.getBackground(), getResources().getColor(C0349R.color.common_text_color_gray_night));
                return;
            default:
                hhe.m23347a(this.f16672a.getBackground());
                return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16673b);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16673b);
        super.onDetachedFromWindow();
    }
}
