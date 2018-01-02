package com.ushareit.listenit.lockscreen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.ushareit.listenit.C0349R;

public class EmptyPage extends FrameLayout {
    public EmptyPage(Context context) {
        super(context);
        m24552a(context);
    }

    public EmptyPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24552a(context);
    }

    public EmptyPage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24552a(context);
    }

    private void m24552a(Context context) {
        LayoutInflater.from(context).inflate(C0349R.layout.empty, this);
    }
}
