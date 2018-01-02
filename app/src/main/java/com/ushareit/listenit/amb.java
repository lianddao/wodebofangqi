package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.ads.C0016g;
import com.facebook.ads.af;
import com.facebook.ads.an;
import com.facebook.ads.ap;
import com.facebook.ads.av;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amb extends amp implements aty {
    private static final String f4764a = amb.class.getSimpleName();
    private an f4765A;
    private String f4766B;
    private String f4767C;
    private av f4768D;
    private List<af> f4769E;
    private int f4770F;
    private int f4771G;
    private String f4772H;
    private boolean f4773I;
    private boolean f4774J;
    private boolean f4775K;
    private boolean f4776L;
    private boolean f4777M;
    private long f4778N = 0;
    private atr f4779O = null;
    private apa f4780P;
    private Context f4781b;
    private amq f4782c;
    private Uri f4783d;
    private String f4784e;
    private String f4785f;
    private String f4786g;
    private String f4787h;
    private String f4788i;
    private an f4789j;
    private an f4790k;
    private ap f4791l;
    private String f4792m;
    private atw f4793n;
    private Collection<String> f4794o;
    private boolean f4795p;
    private boolean f4796q;
    private boolean f4797r;
    private int f4798s;
    private int f4799t;
    private int f4800u;
    private int f4801v;
    private String f4802w;
    private String f4803x;
    private atm f4804y;
    private String f4805z;

    private boolean m6189B() {
        return this.f4784e != null && this.f4784e.length() > 0 && this.f4787h != null && this.f4787h.length() > 0 && ((this.f4789j != null || this.f4773I) && this.f4790k != null);
    }

    private void m6190C() {
        if (!this.f4777M) {
            if (this.f4780P != null) {
                this.f4780P.mo741a(this.f4792m);
            }
            this.f4777M = true;
        }
    }

    private void m6192a(Context context, JSONObject jSONObject, apa com_ushareit_listenit_apa, String str, int i, int i2) {
        this.f4773I = true;
        this.f4781b = context;
        this.f4780P = com_ushareit_listenit_apa;
        this.f4770F = i;
        this.f4771G = i2;
        m6194a(jSONObject, str);
    }

    private void m6193a(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new amc(this, map2, m6196c(map)), (long) (this.f4798s * 1000));
        } catch (Exception e) {
        }
    }

    private void m6194a(JSONObject jSONObject, String str) {
        JSONArray jSONArray = null;
        int i = 0;
        if (this.f4774J) {
            throw new IllegalStateException("Adapter already loaded data");
        } else if (jSONObject != null) {
            atz.m7169a(this.f4781b, "Audience Network Loaded");
            this.f4772H = str;
            this.f4783d = Uri.parse(atz.m7162a(jSONObject, "fbad_command"));
            this.f4784e = atz.m7162a(jSONObject, "title");
            this.f4785f = atz.m7162a(jSONObject, "subtitle");
            this.f4786g = atz.m7162a(jSONObject, C0154a.f2970z);
            this.f4787h = atz.m7162a(jSONObject, "call_to_action");
            this.f4788i = atz.m7162a(jSONObject, "social_context");
            this.f4789j = an.m948a(jSONObject.optJSONObject("icon"));
            this.f4790k = an.m948a(jSONObject.optJSONObject("image"));
            this.f4791l = ap.m952a(jSONObject.optJSONObject("star_rating"));
            this.f4792m = atz.m7162a(jSONObject, "used_report_url");
            this.f4795p = jSONObject.optBoolean("manual_imp");
            this.f4796q = jSONObject.optBoolean("enable_view_log");
            this.f4797r = jSONObject.optBoolean("enable_snapshot_log");
            this.f4798s = jSONObject.optInt("snapshot_log_delay_second", 4);
            this.f4799t = jSONObject.optInt("snapshot_compress_quality", 0);
            this.f4800u = jSONObject.optInt("viewability_check_initial_delay", 0);
            this.f4801v = jSONObject.optInt("viewability_check_interval", 1000);
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_choices_icon");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("native_ui_config");
            av avVar = (optJSONObject2 == null || optJSONObject2.length() == 0) ? null : new av(optJSONObject2);
            this.f4768D = avVar;
            if (optJSONObject != null) {
                this.f4765A = an.m948a(optJSONObject);
            }
            this.f4766B = atz.m7162a(jSONObject, "ad_choices_link_url");
            this.f4767C = atz.m7162a(jSONObject, "request_id");
            this.f4793n = atw.m7149a(jSONObject.optString("invalidation_behavior"));
            try {
                jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f4794o = atx.m7150a(jSONArray);
            this.f4802w = atz.m7162a(jSONObject, BaseVideoPlayerActivity.VIDEO_URL);
            this.f4803x = atz.m7162a(jSONObject, "video_mpd");
            if (jSONObject.has("video_autoplay_enabled")) {
                this.f4804y = jSONObject.optBoolean("video_autoplay_enabled") ? atm.ON : atm.OFF;
            } else {
                this.f4804y = atm.UNKNOWN;
            }
            this.f4805z = atz.m7162a(jSONObject, "video_report_url");
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("carousel");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    List arrayList = new ArrayList(length);
                    while (i < length) {
                        amp com_ushareit_listenit_amb = new amb();
                        com_ushareit_listenit_amb.m6192a(this.f4781b, optJSONArray.getJSONObject(i), this.f4780P, str, i, length);
                        arrayList.add(new af(this.f4781b, com_ushareit_listenit_amb, null));
                        i++;
                    }
                    this.f4769E = arrayList;
                }
            } catch (Throwable e2) {
                Log.e(f4764a, "Unable to parse carousel data.", e2);
            }
            this.f4774J = true;
            this.f4775K = m6189B();
        }
    }

    private Map<String, String> m6196c(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        if (map.containsKey("view")) {
            hashMap.put("view", map.get("view"));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", map.get("snapshot"));
        }
        return hashMap;
    }

    public Collection<String> mo728A() {
        return this.f4794o;
    }

    public void mo669a(int i) {
        if (mo677d() && i == 0 && this.f4778N > 0 && this.f4779O != null) {
            att.m7141a(atq.m7136a(this.f4778N, this.f4779O, this.f4767C));
            this.f4778N = 0;
            this.f4779O = null;
        }
    }

    public void mo670a(Context context, amq com_ushareit_listenit_amq, apa com_ushareit_listenit_apa, Map<String, Object> map) {
        this.f4781b = context;
        this.f4782c = com_ushareit_listenit_amq;
        this.f4780P = com_ushareit_listenit_apa;
        JSONObject jSONObject = (JSONObject) map.get("data");
        m6194a(jSONObject, atz.m7162a(jSONObject, "ct"));
        if (atx.m7151a(context, (aty) this)) {
            com_ushareit_listenit_amq.mo94a(this, C0016g.f610b);
            return;
        }
        if (com_ushareit_listenit_amq != null) {
            com_ushareit_listenit_amq.mo93a(this);
        }
        atq.f5446a = this.f4767C;
    }

    public void mo671a(View view, List<View> list) {
    }

    public void mo672a(amq com_ushareit_listenit_amq) {
        this.f4782c = com_ushareit_listenit_amq;
    }

    public void mo673a(Map<String, String> map) {
        if (mo677d() && !this.f4776L) {
            if (this.f4782c != null) {
                this.f4782c.mo95b(this);
            }
            Map hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.f4773I) {
                hashMap.put("cardind", String.valueOf(this.f4770F));
                hashMap.put("cardcnt", String.valueOf(this.f4771G));
            }
            if (!(TextUtils.isEmpty(mo698y()) || this.f4780P == null)) {
                this.f4780P.mo742a(mo698y(), hashMap);
            }
            if (mo680g() || mo679f()) {
                m6193a((Map) map, hashMap);
            }
            this.f4776L = true;
        }
    }

    public void mo674b() {
    }

    public void mo675b(Map<String, String> map) {
        if (!mo677d()) {
            return;
        }
        if (app.m6620b(this.f4781b) && atp.m7134b((Map) map)) {
            Log.e(f4764a, "Click happened on lockscreen ad");
            return;
        }
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        atz.m7169a(this.f4781b, "Click logged");
        if (this.f4782c != null) {
            this.f4782c.mo96c(this);
        }
        if (this.f4773I) {
            hashMap.put("cardind", String.valueOf(this.f4770F));
            hashMap.put("cardcnt", String.valueOf(this.f4771G));
        }
        ako a = akp.m5928a(this.f4781b, this.f4772H, this.f4783d, hashMap);
        if (a != null) {
            try {
                this.f4778N = System.currentTimeMillis();
                this.f4779O = a.mo666a();
                a.mo667b();
            } catch (Throwable e) {
                Log.e(f4764a, "Error executing action", e);
            }
        }
    }

    public void mo676c() {
    }

    public boolean mo677d() {
        return this.f4774J && this.f4775K;
    }

    public boolean mo678e() {
        return mo677d() && this.f4795p;
    }

    public boolean mo679f() {
        return mo677d() && this.f4797r;
    }

    public boolean mo680g() {
        return mo677d() && this.f4796q;
    }

    public boolean mo681h() {
        return true;
    }

    public int mo682i() {
        return (this.f4799t < 0 || this.f4799t > 100) ? 0 : this.f4799t;
    }

    public int mo683j() {
        return this.f4800u;
    }

    public int mo684k() {
        return this.f4801v;
    }

    public an mo685l() {
        return !mo677d() ? null : this.f4789j;
    }

    public an mo686m() {
        return !mo677d() ? null : this.f4790k;
    }

    public String mo687n() {
        if (!mo677d()) {
            return null;
        }
        m6190C();
        return this.f4784e;
    }

    public String mo688o() {
        if (!mo677d()) {
            return null;
        }
        m6190C();
        return this.f4786g;
    }

    public String mo689p() {
        if (!mo677d()) {
            return null;
        }
        m6190C();
        return this.f4787h;
    }

    public an mo690q() {
        return !mo677d() ? null : this.f4765A;
    }

    public String mo691r() {
        return !mo677d() ? null : this.f4766B;
    }

    public String mo692s() {
        return !mo677d() ? null : "AdChoices";
    }

    public String mo693t() {
        return !mo677d() ? null : this.f4802w;
    }

    public String mo694u() {
        return !mo677d() ? null : this.f4803x;
    }

    public atm mo695v() {
        return !mo677d() ? atm.UNKNOWN : this.f4804y;
    }

    public String mo696w() {
        return this.f4805z;
    }

    public List<af> mo697x() {
        return !mo677d() ? null : this.f4769E;
    }

    public String mo698y() {
        return this.f4772H;
    }

    public atw mo729z() {
        return this.f4793n;
    }
}
