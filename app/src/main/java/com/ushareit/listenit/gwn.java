package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.ushareit.listenit.sleep.SleepPopupView;

public class gwn implements OnFocusChangeListener {
    final /* synthetic */ SleepPopupView f14830a;

    public gwn(SleepPopupView sleepPopupView) {
        this.f14830a = sleepPopupView;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f14830a.m26127a(this.f14830a.f16504j);
        }
    }
}
