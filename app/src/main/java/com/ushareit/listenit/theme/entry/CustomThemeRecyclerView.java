package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class CustomThemeRecyclerView extends RecyclerView implements hhg {
    private Drawable f16684i = getBackground();
    private Drawable f16685j;
    private gxi f16686k = new gxi(this);

    public CustomThemeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeRecyclerView, 0, 0);
        this.f16685j = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16685j != null) {
                    setBackgroundDrawable(this.f16685j);
                    return;
                }
                return;
            default:
                if (this.f16684i != null) {
                    setBackgroundDrawable(this.f16684i);
                    return;
                }
                return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16686k);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16686k);
        super.onDetachedFromWindow();
    }
}
