package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.C0016g;
import com.facebook.ads.C0017i;
import com.facebook.ads.C0071w;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.mobileads.FacebookInterstitial;
import com.umeng.analytics.pro.C0321x;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class amd extends amr {
    private ams f4810b;
    private Context f4811c;
    private boolean f4812d = false;
    private String f4813e;
    private String f4814f;
    private String f4815g;
    private String f4816h = UUID.randomUUID().toString();
    private String f4817i;
    private String f4818j;
    private String f4819k;
    private String f4820l;
    private String f4821m;
    private String f4822n;
    private String f4823o;
    private amt f4824p;
    private and f4825q;

    private void m6234e() {
        ec.m16689a(this.f4811c).m16693a(this.f4824p, this.f4824p.m6332a());
    }

    private void m6235f() {
        if (this.f4824p != null) {
            try {
                ec.m16689a(this.f4811c).m16692a(this.f4824p);
            } catch (Exception e) {
            }
        }
    }

    private String m6236g() {
        if (this.a == null) {
            return null;
        }
        String a = C0017i.m960a();
        if (a == null || a.isEmpty()) {
            a = "https://www.facebook.com/audience_network/server_side_reward";
        } else {
            a = String.format("https://www.%s.facebook.com/audience_network/server_side_reward", new Object[]{a});
        }
        Uri parse = Uri.parse(a);
        Builder builder = new Builder();
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        builder.query(parse.getQuery());
        builder.fragment(parse.getFragment());
        builder.appendQueryParameter(C0321x.at, this.a.m956a());
        builder.appendQueryParameter(fnl.KEY_PLAY_COUNT, this.a.m957b());
        builder.appendQueryParameter("ptid", this.f4816h);
        builder.appendQueryParameter("appid", this.f4821m);
        return builder.build().toString();
    }

    private String m6237h() {
        return this.f4822n;
    }

    public void mo730a(Context context, ams com_ushareit_listenit_ams, Map<String, Object> map) {
        this.f4810b = com_ushareit_listenit_ams;
        this.f4811c = context;
        this.f4812d = false;
        JSONObject jSONObject = (JSONObject) map.get("data");
        this.f4817i = jSONObject.optString(BaseVideoPlayerActivity.VIDEO_URL);
        if (this.f4817i == null || this.f4817i.isEmpty()) {
            this.f4810b.mo656a(this, C0016g.f613e);
            return;
        }
        this.f4818j = jSONObject.optString("video_report_url");
        this.f4823o = jSONObject.optString("ct");
        this.f4819k = jSONObject.optString("end_card_markup");
        this.f4820l = jSONObject.optString("activation_command");
        this.f4822n = jSONObject.optString("context_switch", "endvideo");
        this.f4815g = jSONObject.optString("title");
        this.f4814f = jSONObject.optString("subtitle");
        if (jSONObject.has("icon") && !jSONObject.isNull("icon")) {
            try {
                this.f4813e = jSONObject.getJSONObject("icon").getString("url");
            } catch (Throwable e) {
                Log.w(amd.class.toString(), "Failed to get adIconURL", e);
            }
        }
        String str = (String) map.get(FacebookInterstitial.PLACEMENT_ID_KEY);
        if (str != null) {
            this.f4821m = str.split("_")[0];
        } else {
            this.f4821m = "";
        }
        this.f4824p = new amt(this.f4816h, this, com_ushareit_listenit_ams);
        m6234e();
        this.f4825q = new and(context);
        this.f4825q.m6374b(this.f4817i);
        this.f4825q.m6372a(new ame(this));
    }

    public void mo674b() {
        m6235f();
    }

    public String m6240c() {
        Object obj = "";
        if (this.f4825q != null) {
            obj = this.f4825q.m6375c(this.f4817i);
        }
        return TextUtils.isEmpty(obj) ? this.f4817i : obj;
    }

    public boolean mo731d() {
        if (!this.f4812d) {
            return false;
        }
        Intent intent = new Intent(this.f4811c, AudienceNetworkActivity.class);
        intent.putExtra("viewType", C0071w.REWARDED_VIDEO);
        intent.putExtra("videoURL", m6240c());
        intent.putExtra("videoReportURL", this.f4818j);
        if (!app.m6627i(this.f4811c)) {
            intent.putExtra("predefinedOrientationKey", 6);
        }
        intent.putExtra("facebookRewardedVideoEndCardActivationCommand", this.f4820l);
        intent.putExtra("uniqueId", this.f4816h);
        intent.putExtra("facebookRewardedVideoEndCardMarkup", atz.m7173a(this.f4819k));
        intent.putExtra("clientToken", this.f4823o);
        intent.putExtra("rewardServerURL", m6236g());
        intent.putExtra("contextSwitchBehavior", m6237h());
        intent.putExtra("adTitle", this.f4815g);
        intent.putExtra("adSubtitle", this.f4814f);
        intent.putExtra("adIconUrl", this.f4813e);
        if (!(this.f4811c instanceof Activity)) {
            intent.setFlags(intent.getFlags() | 268435456);
        }
        this.f4811c.startActivity(intent);
        return true;
    }
}
