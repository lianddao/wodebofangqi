package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.ads.C0016g;
import com.facebook.ads.af;
import com.facebook.ads.an;
import com.inmobi.ads.InMobiNative;
import com.inmobi.sdk.InMobiSdk;
import com.mopub.mobileads.FacebookInterstitial;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class amj extends amp implements amn {
    private amq f4853a;
    private InMobiNative f4854b;
    private boolean f4855c;
    private View f4856d;
    private String f4857e;
    private String f4858f;
    private String f4859g;
    private an f4860h;
    private an f4861i;

    public void mo669a(int i) {
    }

    public void mo670a(Context context, amq com_ushareit_listenit_amq, apa com_ushareit_listenit_apa, Map<String, Object> map) {
        atz.m7169a(context, aut.m7225a(mo699z()) + " Loading");
        JSONObject jSONObject = (JSONObject) map.get("data");
        Object optString = jSONObject.optString("account_id");
        Long valueOf = Long.valueOf(jSONObject.optLong(FacebookInterstitial.PLACEMENT_ID_KEY));
        if (TextUtils.isEmpty(optString) || valueOf == null) {
            com_ushareit_listenit_amq.mo94a(this, C0016g.f614f);
            return;
        }
        this.f4853a = com_ushareit_listenit_amq;
        InMobiSdk.init(context, optString);
        this.f4854b = new InMobiNative(valueOf.longValue(), new amk(this, context));
        this.f4854b.load();
    }

    public void mo671a(View view, List<View> list) {
        this.f4856d = view;
        if (mo677d()) {
            InMobiNative inMobiNative = this.f4854b;
            InMobiNative.bind(this.f4856d, this.f4854b);
        }
    }

    public void mo672a(amq com_ushareit_listenit_amq) {
        this.f4853a = com_ushareit_listenit_amq;
    }

    public void mo673a(Map<String, String> map) {
        this.f4853a.mo95b(this);
    }

    public void mo674b() {
        mo676c();
        this.f4854b = null;
        this.f4853a = null;
    }

    public void mo675b(Map<String, String> map) {
        if (mo677d()) {
            this.f4853a.mo96c(this);
            this.f4854b.reportAdClickAndOpenLandingPage(null);
        }
    }

    public void mo676c() {
        if (mo677d()) {
            InMobiNative inMobiNative = this.f4854b;
            InMobiNative.unbind(this.f4856d);
        }
        this.f4856d = null;
    }

    public boolean mo677d() {
        return this.f4854b != null && this.f4855c;
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
        return this.f4860h;
    }

    public an mo686m() {
        return this.f4861i;
    }

    public String mo687n() {
        return this.f4857e;
    }

    public String mo688o() {
        return this.f4858f;
    }

    public String mo689p() {
        return this.f4859g;
    }

    public an mo690q() {
        return null;
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
        return alj.INMOBI;
    }
}
