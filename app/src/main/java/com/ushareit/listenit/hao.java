package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class hao implements OnTouchListener {
    final /* synthetic */ hal f15067a;

    hao(hal com_ushareit_listenit_hal) {
        this.f15067a = com_ushareit_listenit_hal;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (gzd.m23364e() == 1) {
                    view.setBackgroundColor(view.getResources().getColor(C0349R.color.common_stroke_gray_normal_color_night));
                    break;
                }
                break;
            case 1:
                if (gzd.m23364e() == 1) {
                    view.setBackgroundColor(view.getResources().getColor(C0349R.color.common_dialog_background_color_night));
                    break;
                }
                break;
            case 3:
                if (gzd.m23364e() == 1) {
                    view.setBackgroundColor(view.getResources().getColor(C0349R.color.common_dialog_background_color_night));
                    break;
                }
                break;
        }
        return false;
    }
}
