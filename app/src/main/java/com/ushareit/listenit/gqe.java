package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.popupview.NearbyGuidePopupView;

public class gqe implements OnClickListener {
    final /* synthetic */ NearbyGuidePopupView f14551a;

    public gqe(NearbyGuidePopupView nearbyGuidePopupView) {
        this.f14551a = nearbyGuidePopupView;
    }

    public void onClick(View view) {
        gyn.m23214b(this.f14551a.f16231b);
        this.f14551a.f16230a.m21282V();
        View a = this.f14551a.f16231b.m24826a(this.f14551a.f16230a.m21286Z());
        erj.m17570a(a, 0.0f);
        erl.m17583a(a).mo2278e(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT).mo2272a(600);
        this.f14551a.f16230a.m21290a(new gqf(this, a));
        if (fhy.m19213a()) {
            fir.m19414p();
        } else {
            fir.m19415q();
        }
        this.f14551a.mo3063e();
    }
}
