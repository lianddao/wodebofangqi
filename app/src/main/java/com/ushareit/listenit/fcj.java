package com.ushareit.listenit;

import com.mopub.mobileads.GooglePlayServicesInterstitial;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0321x;
import org.json.JSONObject;

public class fcj extends fcb {
    protected String f12087e;
    protected int f12088f;
    protected String f12089g;
    protected boolean f12090h;
    protected boolean f12091i;
    protected fck f12092j;
    protected fbi f12093k;

    public fcj(JSONObject jSONObject) {
        super(fcg.APP, jSONObject);
    }

    public fcj(fcg com_ushareit_listenit_fcg, JSONObject jSONObject) {
        super(com_ushareit_listenit_fcg, jSONObject);
    }

    protected void mo2306a(fcf com_ushareit_listenit_fcf) {
        super.mo2306a(com_ushareit_listenit_fcf);
        this.f12087e = com_ushareit_listenit_fcf.m18848a(C0321x.f3844e, "");
        this.f12088f = com_ushareit_listenit_fcf.m18846a(C0321x.f3847h, 0);
        this.f12089g = com_ushareit_listenit_fcf.m18848a("version_name", "");
        this.f12090h = com_ushareit_listenit_fcf.m18851a("is_system_app", false);
        this.f12091i = com_ushareit_listenit_fcf.m18851a("is_enabled", false);
        this.f12092j = (fck) com_ushareit_listenit_fcf.m18852b("category_location", fck.UNKNOWN);
        this.f12093k = (fbi) com_ushareit_listenit_fcf.m18852b("category_type", fbi.APP);
    }

    protected void mo2307a(JSONObject jSONObject) {
        boolean z;
        boolean z2 = false;
        super.mo2307a(jSONObject);
        this.f12087e = jSONObject.getString("packagename");
        this.f12089g = jSONObject.has(C0154a.f2943C) ? jSONObject.getString(C0154a.f2943C) : "";
        this.f12088f = jSONObject.getInt(C0154a.f2942B);
        if (jSONObject.has("is_system_app")) {
            z = jSONObject.getBoolean("is_system_app");
        } else {
            z = false;
        }
        this.f12090h = z;
        if (jSONObject.has("is_enabled")) {
            z2 = jSONObject.getBoolean("is_enabled");
        }
        this.f12091i = z2;
        this.f12093k = jSONObject.has("category") ? fbi.m18781a(jSONObject.getInt("category")) : fbi.APP;
        this.f12092j = jSONObject.has(GooglePlayServicesInterstitial.LOCATION_KEY) ? fck.m18854a(jSONObject.getInt(GooglePlayServicesInterstitial.LOCATION_KEY)) : fck.UNKNOWN;
    }
}
