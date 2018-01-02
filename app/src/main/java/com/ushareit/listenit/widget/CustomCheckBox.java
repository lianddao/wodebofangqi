package com.ushareit.listenit.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.Checkable;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hbl;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;

public class CustomCheckBox extends CustomThemeImageView implements Checkable {
    private boolean f17198a;
    private hbl f17199b;
    private ColorStateList f17200c;

    public void setOnCheckChangedListener(hbl com_ushareit_listenit_hbl) {
        this.f17199b = com_ushareit_listenit_hbl;
    }

    public CustomCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26808a();
    }

    public CustomCheckBox(Context context) {
        super(context);
        m26808a();
    }

    private void m26808a() {
        setImageResource(C0349R.drawable.common_item_unselected);
        this.f17198a = false;
        this.f17200c = getResources().getColorStateList(C0349R.color.common_checkbox_button_bg_night);
        setTheme();
    }

    public void setChecked(boolean z) {
        if (z != this.f17198a) {
            this.f17198a = z;
            if (this.f17199b != null) {
                this.f17199b.mo2353a(this);
            }
        }
    }

    public void m26809a(boolean z) {
        setImageResource(z ? C0349R.drawable.common_item_selected : C0349R.drawable.common_item_unselected);
        this.f17198a = z;
        drawableStateChanged();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setTheme();
    }

    public void setTheme() {
        switch (gzd.m23364e()) {
            case 1:
                if (this.f17200c != null) {
                    setColorFilter(this.f17200c.getColorForState(getDrawableState(), 0));
                    return;
                }
                return;
            case 2:
                if (isChecked()) {
                    setColorFilter(gzd.m23358b());
                    return;
                } else if (getDrawable() != null) {
                    clearColorFilter();
                    return;
                } else {
                    return;
                }
            default:
                if (getDrawable() != null) {
                    clearColorFilter();
                    return;
                }
                return;
        }
    }

    public boolean isChecked() {
        return this.f17198a;
    }

    public void toggle() {
        if (this.f17199b != null) {
            this.f17199b.mo2353a(this);
        }
    }
}
