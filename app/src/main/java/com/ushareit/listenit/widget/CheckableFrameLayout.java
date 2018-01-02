package com.ushareit.listenit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.theme.entry.CustomThemeFrameLayout;

public class CheckableFrameLayout extends CustomThemeFrameLayout implements Checkable {
    private CustomCheckBox f17145a;

    public CheckableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f17145a = (CustomCheckBox) findViewById(C0349R.id.checkbox);
    }

    public boolean isChecked() {
        return this.f17145a.isChecked();
    }

    public void setChecked(boolean z) {
        this.f17145a.setChecked(z);
    }

    public void toggle() {
        this.f17145a.toggle();
    }
}
