package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.sleep.SleepPopupView;

public class gwp implements OnClickListener {
    final /* synthetic */ SleepPopupView f14832a;

    public gwp(SleepPopupView sleepPopupView) {
        this.f14832a = sleepPopupView;
    }

    public void onClick(View view) {
        if (this.f14832a.f16507m == gwu.RADIO_COLSE) {
            gwk.m23063a().m23074b();
            heb.m23596a((int) C0349R.string.sleep_toast_close, 0).show();
            gvj.m22904b(0);
            this.f14832a.mo3063e();
        } else if (this.f14832a.f16507m == gwu.RADIO_CUSTOM) {
            String obj = this.f14832a.f16496b.getText().toString();
            if (gwk.m23063a().m23073a(obj)) {
                this.f14832a.setSleepTime(Integer.parseInt(obj));
                return;
            }
            heb.m23596a((int) C0349R.string.sleep_toast_illegal_input, 0).show();
        } else {
            this.f14832a.setSleepTime(this.f14832a.f16507m.m23079a());
        }
    }
}
