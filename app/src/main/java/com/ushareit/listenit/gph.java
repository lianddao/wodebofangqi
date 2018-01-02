package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.LockScreenSettingPopupView;

public class gph implements OnClickListener {
    final /* synthetic */ LockScreenSettingPopupView f14528a;

    public gph(LockScreenSettingPopupView lockScreenSettingPopupView) {
        this.f14528a = lockScreenSettingPopupView;
    }

    public void onClick(View view) {
        this.f14528a.f16201f = false;
        this.f14528a.f16197b.setChecked(true);
        this.f14528a.f16196a.setChecked(false);
    }
}
