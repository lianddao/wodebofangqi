package com.ushareit.listenit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import com.ushareit.listenit.C0349R;

public class CustomCheckView extends ImageView implements Checkable {
    private boolean f16627a = false;
    private Drawable f16628b;
    private Drawable f16629c;

    public CustomCheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomCheckView, 0, 0);
        this.f16628b = obtainStyledAttributes.getDrawable(0);
        if (this.f16628b == null) {
            this.f16628b = getResources().getDrawable(C0349R.drawable.common_item_selected);
        }
        this.f16629c = obtainStyledAttributes.getDrawable(1);
        if (this.f16629c == null) {
            this.f16629c = getResources().getDrawable(C0349R.drawable.common_item_unselected);
        }
        obtainStyledAttributes.recycle();
        m26308a();
    }

    public CustomCheckView(Context context) {
        super(context);
        m26308a();
    }

    private void m26308a() {
        setImageDrawable(this.f16627a ? this.f16628b : this.f16629c);
    }

    public void setChecked(boolean z) {
        if (z != this.f16627a) {
            this.f16627a = z;
            setImageDrawable(this.f16627a ? this.f16628b : this.f16629c);
            drawableStateChanged();
        }
    }

    public boolean isChecked() {
        return this.f16627a;
    }

    public void toggle() {
        this.f16627a = !this.f16627a;
        setImageDrawable(this.f16627a ? this.f16628b : this.f16629c);
        drawableStateChanged();
    }
}
