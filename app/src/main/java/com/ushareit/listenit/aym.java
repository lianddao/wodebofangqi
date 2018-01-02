package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.C0064v;
import com.facebook.ads.internal.view.p000a.C0019a;
import com.facebook.ads.internal.view.p000a.C0020b;
import com.facebook.ads.internal.view.p000a.C0023d;

@TargetApi(19)
public class aym implements avo {
    private static final String f5656a = aym.class.getSimpleName();
    private final AudienceNetworkActivity f5657b;
    private final C0019a f5658c;
    private final C0023d f5659d;
    private final C0020b f5660e;
    private final C0064v f5661f = new ayn(this);
    private String f5662g;
    private String f5663h;
    private long f5664i;
    private boolean f5665j = true;
    private long f5666k = -1;
    private boolean f5667l = true;

    public aym(AudienceNetworkActivity audienceNetworkActivity, avp com_ushareit_listenit_avp) {
        this.f5657b = audienceNetworkActivity;
        int i = (int) (2.0f * audienceNetworkActivity.getResources().getDisplayMetrics().density);
        this.f5658c = new C0019a(audienceNetworkActivity);
        this.f5658c.setId(View.generateViewId());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.f5658c.setLayoutParams(layoutParams);
        this.f5658c.setListener(new ayo(this, audienceNetworkActivity));
        com_ushareit_listenit_avp.mo156a(this.f5658c);
        this.f5659d = new C0023d(audienceNetworkActivity);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.f5658c.getId());
        layoutParams.addRule(12);
        this.f5659d.setLayoutParams(layoutParams);
        this.f5659d.setListener(new ayp(this));
        com_ushareit_listenit_avp.mo156a(this.f5659d);
        this.f5660e = new C0020b(audienceNetworkActivity, null, 16842872);
        layoutParams = new RelativeLayout.LayoutParams(-1, i);
        layoutParams.addRule(3, this.f5658c.getId());
        this.f5660e.setLayoutParams(layoutParams);
        this.f5660e.setProgress(0);
        com_ushareit_listenit_avp.mo156a(this.f5660e);
        audienceNetworkActivity.m807a(this.f5661f);
    }

    public void mo712a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (this.f5666k < 0) {
            this.f5666k = System.currentTimeMillis();
        }
        if (bundle == null) {
            this.f5662g = intent.getStringExtra("browserURL");
            this.f5663h = intent.getStringExtra("clientToken");
            this.f5664i = intent.getLongExtra("handlerTime", -1);
        } else {
            this.f5662g = bundle.getString("browserURL");
            this.f5663h = bundle.getString("clientToken");
            this.f5664i = bundle.getLong("handlerTime", -1);
        }
        String str = this.f5662g != null ? this.f5662g : "about:blank";
        this.f5658c.setUrl(str);
        this.f5659d.loadUrl(str);
    }

    public void mo713a(Bundle bundle) {
        bundle.putString("browserURL", this.f5662g);
    }

    public void mo714a(avp com_ushareit_listenit_avp) {
    }

    public void mo674b() {
        this.f5657b.m808b(this.f5661f);
        aub.m7177a(this.f5659d);
        this.f5659d.destroy();
    }

    public void mo716i() {
        this.f5659d.onPause();
        if (this.f5667l) {
            this.f5667l = false;
            apb.m6565a(this.f5657b).m6574a(this.f5663h, new aug(this.f5659d.getFirstUrl()).m7186a(this.f5664i).m7187b(this.f5666k).m7188c(this.f5659d.getResponseEndMs()).m7189d(this.f5659d.getDomContentLoadedMs()).m7190e(this.f5659d.getScrollReadyMs()).m7191f(this.f5659d.getLoadFinishMs()).m7192g(System.currentTimeMillis()).m7185a());
        }
    }

    public void mo717j() {
        this.f5659d.onResume();
    }
}
