package com.ushareit.listenit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.view.C0052n;
import com.facebook.ads.internal.view.p003d.p004b.C0034b;
import com.mopub.volley.DefaultRetryPolicy;

public class azp implements avo {
    private final avu f5738a = new azq(this);
    private final awa f5739b = new azr(this);
    private final avy f5740c = new azs(this);
    private final avs f5741d = new azt(this);
    private final AudienceNetworkActivity f5742e;
    private final C0052n f5743f;
    private final avp f5744g;
    private asq f5745h;
    private int f5746i;

    public azp(AudienceNetworkActivity audienceNetworkActivity, avp com_ushareit_listenit_avp) {
        this.f5742e = audienceNetworkActivity;
        this.f5743f = new C0052n(audienceNetworkActivity);
        this.f5743f.m1105a(new C0034b(audienceNetworkActivity));
        this.f5743f.getEventBus().m6617a(this.f5739b);
        this.f5743f.getEventBus().m6617a(this.f5740c);
        this.f5743f.getEventBus().m6617a(this.f5741d);
        this.f5743f.getEventBus().m6617a(this.f5738a);
        this.f5744g = com_ushareit_listenit_avp;
        this.f5743f.setIsFullScreen(true);
        this.f5743f.setVolume(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.f5743f.setLayoutParams(layoutParams);
        com_ushareit_listenit_avp.mo156a(this.f5743f);
    }

    public void mo712a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        boolean booleanExtra = intent.getBooleanExtra("autoplay", false);
        String stringExtra = intent.getStringExtra("videoURL");
        String stringExtra2 = intent.getStringExtra("videoMPD");
        Bundle bundleExtra = intent.getBundleExtra("videoLogger");
        String stringExtra3 = intent.getStringExtra("clientToken");
        this.f5746i = intent.getIntExtra("videoSeekTime", 0);
        this.f5743f.setAutoplay(booleanExtra);
        this.f5745h = new asq(audienceNetworkActivity, apb.m6565a(audienceNetworkActivity.getApplicationContext()), this.f5743f, stringExtra3, bundleExtra);
        this.f5743f.setVideoMPD(stringExtra2);
        this.f5743f.setVideoURI(stringExtra);
        if (this.f5746i > 0) {
            this.f5743f.m1103a(this.f5746i);
        }
        this.f5743f.mo151d();
    }

    public void mo713a(Bundle bundle) {
    }

    public void m7456a(View view) {
        this.f5743f.setControlsAnchorView(view);
    }

    public void mo714a(avp com_ushareit_listenit_avp) {
    }

    public void mo674b() {
        this.f5744g.mo158a("videoInterstitalEvent", new awf(this.f5746i, this.f5743f.getCurrentPosition()));
        this.f5745h.m6998b(this.f5743f.getCurrentPosition());
        this.f5743f.m1113g();
    }

    public void mo716i() {
        this.f5744g.mo158a("videoInterstitalEvent", new avv());
        this.f5743f.m1111e();
    }

    public void mo717j() {
        this.f5744g.mo158a("videoInterstitalEvent", new avw());
        this.f5743f.mo151d();
    }
}
