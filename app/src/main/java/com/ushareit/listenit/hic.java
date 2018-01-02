package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class hic {
    private Context f15477a;
    private PopupWindow f15478b;
    private View f15479c;

    public hic(Context context, View view) {
        this.f15477a = context;
        this.f15479c = view;
        this.f15478b = new PopupWindow(context);
        this.f15478b.setContentView(view);
        this.f15478b.setBackgroundDrawable(new ColorDrawable(0));
    }

    public void m23887a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[0] + view.getHeight());
        this.f15479c.setLayoutParams(new LayoutParams(-2, -2));
        this.f15479c.measure(-2, -2);
        m23888a(view, 0, true, Math.abs(rect.centerX() - (this.f15478b.getWidth() / 2)), rect.top);
    }

    public void m23890a(boolean z, int i, int i2) {
        m23888a(((Activity) this.f15477a).getWindow().getDecorView(), 49, z, i, i2);
    }

    public void m23888a(View view, int i, boolean z, int i2, int i3) {
        this.f15478b.setWidth(-2);
        this.f15478b.setHeight(-2);
        this.f15478b.setTouchable(true);
        this.f15478b.setFocusable(z);
        this.f15478b.setOutsideTouchable(true);
        this.f15478b.showAtLocation(view, i, i2, i3);
    }

    public void m23886a() {
        if (this.f15478b != null && this.f15478b.isShowing()) {
            this.f15478b.dismiss();
        }
    }

    public boolean m23891b() {
        return this.f15478b != null && this.f15478b.isShowing();
    }

    public void m23889a(OnDismissListener onDismissListener) {
        this.f15478b.setOnDismissListener(onDismissListener);
    }
}
