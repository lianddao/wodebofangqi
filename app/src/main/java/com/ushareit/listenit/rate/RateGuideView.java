package com.ushareit.listenit.rate;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.epn;
import com.ushareit.listenit.eqd;
import com.ushareit.listenit.eqy;
import com.ushareit.listenit.gri;
import com.ushareit.listenit.grj;
import com.ushareit.listenit.grk;
import com.ushareit.listenit.grl;
import com.ushareit.listenit.grm;
import com.ushareit.listenit.hhx;

public class RateGuideView extends FrameLayout implements OnClickListener {
    private gri f16383a;
    private boolean f16384b = false;

    public RateGuideView(Context context) {
        super(context);
        m25918a(context);
    }

    private void m25918a(Context context) {
        View.inflate(context, C0349R.layout.external_gp_rate_guide_layout, this);
        this.f16383a = new gri(context.getApplicationContext());
        setOnClickListener(this);
    }

    public void m25926a(long j) {
        hhx.m23869a(new grj(this), 0, (int) j);
    }

    private void m25917a() {
        if (!this.f16384b && this.f16383a != null) {
            this.f16383a.m22600a(this, new grk(this));
        }
    }

    public void m25925a(int i) {
        hhx.m23869a(new grl(this), 0, i);
    }

    public void onClick(View view) {
        if (view == this) {
            m25925a(0);
        }
    }

    private void m25921b() {
        View findViewById = findViewById(C0349R.id.guide_hand_view);
        View findViewById2 = findViewById(C0349R.id.guide_tip);
        if (findViewById != null && findViewById2 != null) {
            Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setStartOffset(1000);
            alphaAnimation.setDuration(400);
            float dimension = getContext().getResources().getDimension(C0349R.dimen.common_dimens_150dp);
            eqy a = eqd.m17401a(findViewById, "translationY", 0.0f, -dimension);
            a.m17383a(new AccelerateInterpolator());
            a.mo2252c(600);
            eqy a2 = eqd.m17401a(findViewById, "translationY", -dimension, 0.0f);
            a2.m17383a(new DecelerateInterpolator());
            a2.mo2252c(400);
            new epn().m17298a(a, a2);
            new epn().m17298a(a, a2);
            epn com_ushareit_listenit_epn = new epn();
            com_ushareit_listenit_epn.m17298a(r3, r5);
            com_ushareit_listenit_epn.m17274a(new grm(this));
            com_ushareit_listenit_epn.mo2234a();
            findViewById2.setVisibility(0);
            findViewById2.startAnimation(alphaAnimation);
        }
    }
}
