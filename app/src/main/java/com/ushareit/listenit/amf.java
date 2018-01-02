package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import com.facebook.ads.af;
import com.facebook.ads.an;
import com.flurry.android.FlurryAgent;
import com.flurry.android.ads.FlurryAdNative;
import com.mopub.mobileads.FacebookInterstitial;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class amf extends amp implements amn {
    private static volatile boolean f4827a;
    private amq f4828b;
    private FlurryAdNative f4829c;
    private boolean f4830d;
    private String f4831e;
    private String f4832f;
    private String f4833g;
    private an f4834h;
    private an f4835i;
    private an f4836j;

    public void mo669a(int i) {
    }

    public void mo670a(Context context, amq com_ushareit_listenit_amq, apa com_ushareit_listenit_apa, Map<String, Object> map) {
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("api_key");
        String optString2 = jSONObject.optString(FacebookInterstitial.PLACEMENT_ID_KEY);
        synchronized (amf.class) {
            if (!f4827a) {
                atz.m7169a(context, aut.m7225a(mo699z()) + " Initializing");
                FlurryAgent.setLogEnabled(true);
                FlurryAgent.init(context, optString);
                f4827a = true;
            }
        }
        atz.m7169a(context, aut.m7225a(mo699z()) + " Loading");
        this.f4828b = com_ushareit_listenit_amq;
        this.f4829c = new FlurryAdNative(context, optString2);
        this.f4829c.setListener(new amg(this, context));
        this.f4829c.fetchAd();
    }

    public void mo671a(View view, List<View> list) {
        if (this.f4829c != null) {
            this.f4829c.setTrackingView(view);
        }
    }

    public void mo672a(amq com_ushareit_listenit_amq) {
        this.f4828b = com_ushareit_listenit_amq;
    }

    public void mo673a(Map<String, String> map) {
    }

    public void mo674b() {
        mo676c();
        this.f4828b = null;
        if (this.f4829c != null) {
            this.f4829c.destroy();
            this.f4829c = null;
        }
    }

    public void mo675b(Map<String, String> map) {
    }

    public void mo676c() {
        if (this.f4829c != null) {
            this.f4829c.removeTrackingView();
        }
    }

    public boolean mo677d() {
        return this.f4830d;
    }

    public boolean mo678e() {
        return false;
    }

    public boolean mo679f() {
        return false;
    }

    public boolean mo680g() {
        return false;
    }

    public boolean mo681h() {
        return true;
    }

    public int mo682i() {
        return 0;
    }

    public int mo683j() {
        return 0;
    }

    public int mo684k() {
        return 0;
    }

    public an mo685l() {
        return this.f4834h;
    }

    public an mo686m() {
        return this.f4835i;
    }

    public String mo687n() {
        return this.f4831e;
    }

    public String mo688o() {
        return this.f4832f;
    }

    public String mo689p() {
        return this.f4833g;
    }

    public an mo690q() {
        return this.f4836j;
    }

    public String mo691r() {
        return null;
    }

    public String mo692s() {
        return "Ad";
    }

    public String mo693t() {
        return null;
    }

    public String mo694u() {
        return null;
    }

    public atm mo695v() {
        return atm.UNKNOWN;
    }

    public String mo696w() {
        return null;
    }

    public List<af> mo697x() {
        return null;
    }

    public String mo698y() {
        return null;
    }

    public alj mo699z() {
        return alj.YAHOO;
    }
}
