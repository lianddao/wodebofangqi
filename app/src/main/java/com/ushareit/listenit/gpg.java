package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.LockScreenSettingPopupView;

public class gpg implements OnClickListener {
    final /* synthetic */ LockScreenSettingPopupView f14527a;

    public gpg(LockScreenSettingPopupView lockScreenSettingPopupView) {
        this.f14527a = lockScreenSettingPopupView;
    }

    public void onClick(View view) {
        this.f14527a.f16201f = true;
        this.f14527a.f16196a.setChecked(true);
        this.f14527a.f16197b.setChecked(false);
    }
}
