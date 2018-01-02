package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

public class fds {
    private TextView f12493a;

    public fds(View view) {
        this.f12493a = (TextView) view.findViewById(C0349R.id.equalizer);
    }

    public void m18915a(String str) {
        this.f12493a.setText(str);
    }

    public void m18913a(int i) {
        this.f12493a.setTextColor(i);
    }

    public void m18914a(Drawable drawable) {
        this.f12493a.setBackgroundDrawable(drawable);
    }
}
