package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cutter.view.SetRingPopupView;

public class fps implements OnClickListener {
    final /* synthetic */ SetRingPopupView f13208a;

    public fps(SetRingPopupView setRingPopupView) {
        this.f13208a = setRingPopupView;
    }

    public void onClick(View view) {
        this.f13208a.m12837a();
        switch (view.getId()) {
            case C0349R.id.radio_ringtone:
                this.f13208a.f9070d = 1;
                this.f13208a.f9067a.setChecked(true);
                return;
            case C0349R.id.radio_alarm:
                this.f13208a.f9070d = 4;
                this.f13208a.f9068b.setChecked(true);
                return;
            case C0349R.id.radio_notification:
                this.f13208a.f9070d = 2;
                this.f13208a.f9069c.setChecked(true);
                return;
            default:
                return;
        }
    }
}
