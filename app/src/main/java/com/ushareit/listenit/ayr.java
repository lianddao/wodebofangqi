package com.ushareit.listenit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.view.C0030c;
import java.util.HashMap;
import java.util.Map;

public class ayr implements avo {
    private static final String f5673a = ayr.class.getSimpleName();
    private final avp f5674b;
    private final C0030c f5675c;
    private final ami f5676d;
    private amh f5677e;
    private long f5678f = System.currentTimeMillis();
    private long f5679g;
    private atr f5680h;

    public ayr(AudienceNetworkActivity audienceNetworkActivity, avp com_ushareit_listenit_avp) {
        this.f5674b = com_ushareit_listenit_avp;
        this.f5675c = new C0030c(audienceNetworkActivity, new ays(this, audienceNetworkActivity), 1);
        this.f5675c.setLayoutParams(new LayoutParams(-1, -1));
        this.f5676d = new ami(audienceNetworkActivity, this.f5675c, this.f5675c.getViewabilityChecker(), new ayt(this));
        com_ushareit_listenit_avp.mo156a(this.f5675c);
    }

    public void mo712a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (bundle == null || !bundle.containsKey("dataModel")) {
            this.f5677e = amh.m6276b(intent);
            if (this.f5677e != null) {
                this.f5676d.m6287a(this.f5677e);
                this.f5675c.loadDataWithBaseURL(aub.m7176a(), this.f5677e.m6278a(), "text/html", "utf-8", null);
                this.f5675c.m998a(this.f5677e.m6282d(), this.f5677e.m6283e());
                return;
            }
            return;
        }
        this.f5677e = amh.m6274a(bundle.getBundle("dataModel"));
        if (this.f5677e != null) {
            this.f5675c.loadDataWithBaseURL(aub.m7176a(), this.f5677e.m6278a(), "text/html", "utf-8", null);
            this.f5675c.m998a(this.f5677e.m6282d(), this.f5677e.m6283e());
        }
    }

    public void mo713a(Bundle bundle) {
        if (this.f5677e != null) {
            bundle.putBundle("dataModel", this.f5677e.m6284f());
        }
    }

    public void mo714a(avp com_ushareit_listenit_avp) {
    }

    public void mo674b() {
        if (this.f5677e != null) {
            att.m7141a(atq.m7136a(this.f5678f, atr.XOUT, this.f5677e.m6281c()));
            if (!TextUtils.isEmpty(this.f5677e.mo698y())) {
                Map hashMap = new HashMap();
                this.f5675c.getViewabilityChecker().m6935a(hashMap);
                hashMap.put("touch", atz.m7161a(this.f5675c.getTouchData()));
                apb.m6565a(this.f5675c.getContext()).mo749e(this.f5677e.mo698y(), hashMap);
            }
        }
        aub.m7177a(this.f5675c);
        this.f5675c.destroy();
    }

    public void mo716i() {
        this.f5675c.onPause();
    }

    public void mo717j() {
        if (!(this.f5679g <= 0 || this.f5680h == null || this.f5677e == null)) {
            att.m7141a(atq.m7136a(this.f5679g, this.f5680h, this.f5677e.m6281c()));
        }
        this.f5675c.onResume();
    }
}
