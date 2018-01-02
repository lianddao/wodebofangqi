package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.RatePopupView;
import com.ushareit.listenit.rate.RateGuideView;

public class gqz implements OnClickListener {
    final /* synthetic */ RatePopupView f14574a;

    public gqz(RatePopupView ratePopupView) {
        this.f14574a = ratePopupView;
    }

    public void onClick(View view) {
        Context context = this.f14574a.getContext();
        if (this.f14574a.f16260d.getRating() == this.f14574a.f16260d.getNumStars()) {
            fad.m18688a(context, context.getPackageName(), fql.m20387a(), "rateus_navigation", true);
            if (fbj.m18787b(context, "com.android.vending")) {
                new RateGuideView(context).m25926a(1000);
            }
        } else {
            gxw.m23113a(context, "Listenit@ushareit.com", null);
            fii.m19297a(context, "feedback", "from_rateus");
        }
        fii.m19296a(context, "feedback", this.f14574a.f16260d.getRating());
        this.f14574a.mo3063e();
    }
}
