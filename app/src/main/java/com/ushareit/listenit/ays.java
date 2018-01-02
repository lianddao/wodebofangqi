package com.ushareit.listenit;

import android.net.Uri;
import android.util.Log;
import com.facebook.ads.AudienceNetworkActivity;
import java.util.Map;

class ays implements avm {
    final /* synthetic */ AudienceNetworkActivity f5681a;
    final /* synthetic */ ayr f5682b;

    ays(ayr com_ushareit_listenit_ayr, AudienceNetworkActivity audienceNetworkActivity) {
        this.f5682b = com_ushareit_listenit_ayr;
        this.f5681a = audienceNetworkActivity;
    }

    public void mo162a() {
        this.f5682b.f5676d.m5951a();
    }

    public void mo163a(int i) {
    }

    public void mo164a(String str, Map<String, String> map) {
        Uri parse = Uri.parse(str);
        if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
            this.f5681a.finish();
            return;
        }
        if ("fbad".equals(parse.getScheme()) && akp.m5929a(parse.getAuthority())) {
            this.f5682b.f5674b.mo157a("com.facebook.ads.interstitial.clicked");
        }
        ako a = akp.m5928a(this.f5681a, this.f5682b.f5677e.mo698y(), parse, map);
        if (a != null) {
            try {
                this.f5682b.f5680h = a.mo666a();
                this.f5682b.f5679g = System.currentTimeMillis();
                a.mo667b();
            } catch (Throwable e) {
                Log.e(ayr.f5673a, "Error executing action", e);
            }
        }
    }
}
