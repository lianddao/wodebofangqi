package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.C0016g;
import com.facebook.ads.internal.view.C0052n;
import com.facebook.ads.internal.view.p003d.p004b.C0033a;
import com.facebook.ads.internal.view.p003d.p004b.C0034b;
import com.facebook.ads.internal.view.p003d.p004b.C0035c;
import com.facebook.ads.internal.view.p003d.p004b.C0036e;
import com.facebook.ads.internal.view.p003d.p004b.C0040h;
import com.facebook.ads.internal.view.p003d.p004b.C0042j;
import com.facebook.ads.internal.view.p003d.p004b.C0043k;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class alq extends aml implements atd<Bundle> {
    static final /* synthetic */ boolean f4697d = (!alq.class.desiredAssertionStatus());
    protected C0052n f4698a;
    protected JSONObject f4699b;
    protected Context f4700c;
    private final apo<avr> f4701e = new alr(this);
    private final apo<awb> f4702f = new als(this);
    private final apo<avt> f4703g = new alt(this);
    private final apo<avq> f4704h = new alu(this);
    private ajv f4705i;
    private apa f4706j;
    private String f4707k;
    private boolean f4708l = false;
    private ath f4709m;
    private String f4710n;

    private void m6075a(Context context, ajv com_ushareit_listenit_ajv, JSONObject jSONObject, apa com_ushareit_listenit_apa, Bundle bundle) {
        this.f4700c = context;
        this.f4705i = com_ushareit_listenit_ajv;
        this.f4706j = com_ushareit_listenit_apa;
        this.f4699b = jSONObject;
        this.f4708l = false;
        JSONObject jSONObject2 = jSONObject.getJSONObject("video");
        this.f4710n = jSONObject.optString("ct");
        this.f4707k = jSONObject2.getString("videoURL");
        this.f4698a = new C0052n(context);
        mo715c();
        this.f4698a.getEventBus().m6617a(this.f4701e);
        this.f4698a.getEventBus().m6617a(this.f4703g);
        this.f4698a.getEventBus().m6617a(this.f4702f);
        this.f4698a.getEventBus().m6617a(this.f4704h);
        if (bundle != null) {
            this.f4709m = new asq(context, com_ushareit_listenit_apa, this.f4698a, this.f4710n, bundle.getBundle("logger"));
        } else {
            this.f4709m = new asq(context, com_ushareit_listenit_apa, this.f4698a, this.f4710n);
        }
        this.f4705i.mo649a((aml) this, this.f4698a);
        this.f4698a.setVideoURI(this.f4707k);
    }

    public final void mo706a(Context context, ajv com_ushareit_listenit_ajv, Map<String, Object> map, apa com_ushareit_listenit_apa) {
        try {
            m6075a(context, com_ushareit_listenit_ajv, (JSONObject) map.get("data"), com_ushareit_listenit_apa, null);
        } catch (JSONException e) {
            com_ushareit_listenit_ajv.mo650a((aml) this, C0016g.f613e);
        }
    }

    public void mo674b() {
        if (this.f4698a != null) {
            this.f4698a.m1113g();
        }
        this.f4705i = null;
        this.f4706j = null;
        this.f4707k = null;
        this.f4708l = false;
        this.f4710n = null;
        this.f4698a = null;
        this.f4709m = null;
        this.f4699b = null;
        this.f4700c = null;
    }

    protected void mo715c() {
        if (!f4697d && this.f4700c == null) {
            throw new AssertionError();
        } else if (f4697d || this.f4699b != null) {
            JSONObject jSONObject = this.f4699b.getJSONObject("video");
            JSONObject optJSONObject = this.f4699b.optJSONObject("text");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.f4698a.m1105a(new C0042j(this.f4700c));
            axy c0043k = new C0043k(this.f4700c);
            this.f4698a.m1105a(c0043k);
            this.f4698a.m1105a(new awx(c0043k, axg.INVSIBLE));
            this.f4698a.m1105a(new C0034b(this.f4700c));
            String d = m6082d();
            if (d != null) {
                axy c0035c = new C0035c(this.f4700c, d);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                c0035c.setLayoutParams(layoutParams);
                c0035c.setCountdownTextColor(-1);
                this.f4698a.m1105a(c0035c);
            }
            if (jSONObject.has("destinationURL") && !jSONObject.isNull("destinationURL")) {
                Object string = jSONObject.getString("destinationURL");
                if (!TextUtils.isEmpty(string)) {
                    c0043k = new C0036e(this.f4700c, string, this.f4710n, optJSONObject.optString("learnMore", CtaButton.DEFAULT_CTA_TEXT));
                    LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(10);
                    layoutParams2.addRule(11);
                    c0043k.setLayoutParams(layoutParams2);
                    this.f4698a.m1105a(c0043k);
                }
            }
            this.f4698a.m1105a(new C0033a(this.f4700c, "http://m.facebook.com/ads/ad_choices", this.f4710n, new float[]{0.0f, 0.0f, CloseButton.STROKE_WIDTH, 0.0f}));
            int e = m6083e();
            if (e > 0) {
                c0043k = new C0040h(this.f4700c, e, optJSONObject.optString("skipAdIn", "Skip Ad in"), optJSONObject.optString("skipAd", "Skip Ad"));
                LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(12);
                layoutParams3.addRule(11);
                c0043k.setLayoutParams(layoutParams3);
                c0043k.setPadding(0, 0, 0, 30);
                this.f4698a.m1105a(c0043k);
            }
        } else {
            throw new AssertionError();
        }
    }

    protected String m6082d() {
        String str = null;
        if (f4697d || this.f4699b != null) {
            try {
                JSONObject jSONObject = this.f4699b.getJSONObject("capabilities");
                if (jSONObject.has("countdown") && !jSONObject.isNull("countdown")) {
                    jSONObject = jSONObject.getJSONObject("countdown");
                    if (jSONObject.has("format")) {
                        str = jSONObject.optString("format");
                    }
                }
            } catch (Throwable e) {
                Log.w(String.valueOf(alq.class), "Invalid JSON", e);
            }
            return str;
        }
        throw new AssertionError();
    }

    protected int m6083e() {
        int i = -1;
        if (f4697d || this.f4699b != null) {
            try {
                JSONObject jSONObject = this.f4699b.getJSONObject("capabilities");
                if (jSONObject.has("skipButton") && !jSONObject.isNull("skipButton")) {
                    jSONObject = jSONObject.getJSONObject("skipButton");
                    if (jSONObject.has("skippableSeconds")) {
                        i = jSONObject.getInt("skippableSeconds");
                    }
                }
            } catch (Throwable e) {
                Log.w(String.valueOf(alq.class), "Invalid JSON", e);
            }
            return i;
        }
        throw new AssertionError();
    }

    public boolean mo707f() {
        if (!this.f4708l || this.f4698a == null) {
            return false;
        }
        if (this.f4709m.m7007k() > 0) {
            this.f4698a.m1103a(this.f4709m.m7007k());
            this.f4698a.mo151d();
        } else {
            this.f4698a.mo151d();
            m6085g();
        }
        return true;
    }

    protected void m6085g() {
        if (this.f4706j != null) {
            this.f4706j.mo742a(this.f4710n, new HashMap());
            if (this.f4705i != null) {
                this.f4705i.mo652c(this);
            }
        }
    }

    public Bundle getSaveInstanceState() {
        if (this.f4709m == null || this.f4699b == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("logger", this.f4709m.getSaveInstanceState());
        bundle.putString("ad_response", this.f4699b.toString());
        return bundle;
    }
}
