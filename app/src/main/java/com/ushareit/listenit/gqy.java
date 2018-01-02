package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.RatePopupView;

public class gqy implements OnClickListener {
    final /* synthetic */ RatePopupView f14573a;

    public gqy(RatePopupView ratePopupView) {
        this.f14573a = ratePopupView;
    }

    public void onClick(View view) {
        this.f14573a.mo3063e();
        fii.m19296a(this.f14573a.getContext(), "later", this.f14573a.f16260d.getRating());
    }
}
