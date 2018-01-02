package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.sleep.SleepPopupView;

public class gwr implements OnClickListener {
    final /* synthetic */ SleepPopupView f14834a;

    public gwr(SleepPopupView sleepPopupView) {
        this.f14834a = sleepPopupView;
    }

    public void onClick(View view) {
        this.f14834a.f16495a.hideSoftInputFromWindow(this.f14834a.f16496b.getWindowToken(), 0);
    }
}
