package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import com.ushareit.listenit.sleep.SleepPopupView;

public class gwt implements OnClickListener {
    final /* synthetic */ SleepPopupView f14836a;

    public gwt(SleepPopupView sleepPopupView) {
        this.f14836a = sleepPopupView;
    }

    public void onClick(View view) {
        this.f14836a.m26127a((RadioButton) view);
    }
}
