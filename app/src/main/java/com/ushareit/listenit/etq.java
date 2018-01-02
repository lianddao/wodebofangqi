package com.ushareit.listenit;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.umeng.analytics.pro.C0321x;
import java.util.TimeZone;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public class etq {
    private String f11806A;
    private String f11807B;
    private String f11808C;
    private int f11809a;
    private int f11810b;
    private String f11811c;
    private String f11812d;
    private String f11813e;
    private String f11814f;
    private String f11815g;
    private String f11816h;
    private int f11817i;
    private String f11818j;
    private String f11819k;
    private String f11820l;
    private String f11821m;
    private String f11822n;
    private String f11823o;
    private String f11824p;
    private String f11825q;
    private eza f11826r;
    private String f11827s;
    private String f11828t;
    private String f11829u;
    private String f11830v;
    private String f11831w;
    private String f11832x;
    private String f11833y;
    private eyz f11834z;

    public etq(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.f11809a = i;
        this.f11810b = i2;
        this.f11811c = str;
        this.f11812d = str2;
        this.f11813e = str3;
        this.f11814f = str4;
        this.f11815g = str5;
        this.f11816h = str6;
        this.f11817i = i3;
        this.f11818j = str7;
        this.f11819k = str8;
        this.f11820l = str9;
        this.f11821m = str10;
        this.f11822n = str11;
        this.f11823o = str12;
        this.f11824p = str13;
        this.f11827s = str14;
        this.f11828t = str15;
    }

    public etq(String str, String str2, String str3, String str4) {
        this(102, TimeZone.getDefault().getRawOffset(), fbb.m18749a(), str2, etk.f11780a, etk.f11781b, str, etk.f11784e, etk.f11783d, etk.f11782c, "android", String.valueOf(VERSION.SDK_INT), str3, str4, Build.MANUFACTURER, Build.MODEL, etk.f11787h, etk.f11785f);
    }

    public int m17919a() {
        return this.f11809a;
    }

    public int m17921b() {
        return this.f11810b;
    }

    public String m17922c() {
        return this.f11811c;
    }

    public String m17923d() {
        return this.f11812d;
    }

    public String m17924e() {
        return this.f11813e;
    }

    public String m17925f() {
        return this.f11814f;
    }

    public String m17926g() {
        return this.f11815g;
    }

    public String m17927h() {
        return this.f11816h;
    }

    public int m17928i() {
        return this.f11817i;
    }

    public String m17929j() {
        return this.f11818j;
    }

    public String m17930k() {
        return this.f11819k;
    }

    public String m17931l() {
        return this.f11820l;
    }

    public String m17932m() {
        return this.f11821m;
    }

    public String m17933n() {
        return this.f11822n;
    }

    public String m17934o() {
        return this.f11823o;
    }

    public String m17935p() {
        return this.f11824p;
    }

    public String m17936q() {
        return this.f11827s;
    }

    public String m17937r() {
        return this.f11828t;
    }

    public void m17920a(Context context) {
        if (TextUtils.isEmpty(this.f11815g)) {
            this.f11815g = euh.m18003a(context, null);
        }
        if (TextUtils.isEmpty(this.f11828t)) {
            this.f11828t = etk.f11785f;
        }
        eyx a = eyx.m18571a(context);
        this.f11826r = a.m18575b();
        this.f11834z = a.m18576c();
        this.f11807B = a.m18577d();
        this.f11806A = etk.f11786g;
        Pair a2 = fap.m18731a(context);
        this.f11825q = a2.first + "x" + a2.second;
        this.f11829u = fah.m18704b(context);
        this.f11830v = fah.m18707c(context);
        this.f11831w = fah.m18710d(context);
        this.f11832x = fah.m18701a();
        this.f11833y = fah.m18703b();
        this.f11808C = fah.m18712e(context);
    }

    public JSONObject m17938s() {
        String str = "unknown";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_ver", this.f11809a);
            jSONObject.put("time_zone", this.f11810b);
            jSONObject.put("commit_id", this.f11811c);
            jSONObject.put("pid", this.f11812d);
            jSONObject.put("commit_time", System.currentTimeMillis());
            jSONObject.put("app_token", this.f11813e);
            jSONObject.put("app_id", this.f11814f);
            jSONObject.put(C0321x.f3860u, this.f11815g);
            jSONObject.put("device_id_type", fah.m18699a(this.f11815g).m18715b());
            jSONObject.put("release_channel", !TextUtils.isEmpty(this.f11816h) ? this.f11816h : "unknown");
            jSONObject.put("app_ver_code", this.f11817i);
            jSONObject.put("app_ver_name", !TextUtils.isEmpty(this.f11818j) ? this.f11818j : "unknown");
            jSONObject.put("os_name", !TextUtils.isEmpty(this.f11819k) ? this.f11819k : "unknown");
            jSONObject.put("os_ver", !TextUtils.isEmpty(this.f11820l) ? this.f11820l : "unknown");
            jSONObject.put(C0321x.f3819F, !TextUtils.isEmpty(this.f11821m) ? this.f11821m : "unknown");
            jSONObject.put(C0321x.f3820G, !TextUtils.isEmpty(this.f11822n) ? this.f11822n : "unknown");
            jSONObject.put("manufacture", !TextUtils.isEmpty(this.f11823o) ? this.f11823o : "unknown");
            jSONObject.put(C0321x.f3861v, !TextUtils.isEmpty(this.f11824p) ? this.f11824p : "unknown");
            jSONObject.put(C0321x.f3857r, !TextUtils.isEmpty(this.f11825q) ? this.f11825q : "unknown");
            jSONObject.put("net_type", this.f11826r.m18581a());
            if (!TextUtils.isEmpty(this.f11827s)) {
                jSONObject.put("account", this.f11827s);
            }
            if (!TextUtils.isEmpty(this.f11828t)) {
                jSONObject.put("app_device_id", this.f11828t);
            }
            if (!TextUtils.isEmpty(this.f11829u)) {
                jSONObject.put("mac", this.f11829u);
            }
            if (!TextUtils.isEmpty(this.f11830v)) {
                jSONObject.put("android_id", this.f11830v);
            }
            if (!TextUtils.isEmpty(this.f11831w)) {
                jSONObject.put("imei", this.f11831w);
            }
            if (!TextUtils.isEmpty(this.f11832x)) {
                jSONObject.put("cid_sn", this.f11832x);
            }
            if (!TextUtils.isEmpty(this.f11833y)) {
                jSONObject.put("build_num", this.f11833y);
            }
            if (this.f11834z != eyz.UNKNOWN) {
                jSONObject.put("mobile_data_type", this.f11834z.m18579a());
            }
            if (!TextUtils.isEmpty(this.f11806A)) {
                jSONObject.put("promotion_channel", this.f11806A);
            }
            if (!TextUtils.isEmpty(this.f11807B)) {
                jSONObject.put(C0321x.f3821H, this.f11807B);
            }
            if (!TextUtils.isEmpty(this.f11808C)) {
                jSONObject.put("gaid", this.f11808C);
            }
        } catch (JSONException e) {
            Assert.fail("impossible");
        }
        return jSONObject;
    }

    public String toString() {
        return "HeaderEntity [mSdkVer=" + this.f11809a + ", mTimeZone=" + this.f11810b + ", mCommitId=" + this.f11811c + ", mPid=" + this.f11812d + ", mAppToken=" + this.f11813e + ", mAppId=" + this.f11814f + ", mDeviceId=" + this.f11815g + ", mDeviceType=" + fah.m18699a(this.f11815g).m18715b() + ", mReleaseChannel=" + this.f11816h + ", mAppVerCode=" + this.f11817i + ", mAppVerName=" + this.f11818j + ", mOsName=" + this.f11819k + ", mOsVer=" + this.f11820l + ", mLanguage=" + this.f11821m + ", mCountry=" + this.f11822n + ", mManufacture=" + this.f11823o + ", mDeviceModel=" + this.f11824p + ", mResolution=" + this.f11825q + ", mNetType=" + this.f11826r + ", mAccount=" + this.f11827s + ", mAppDeviceId=" + this.f11828t + ", mMacAddres=" + this.f11829u + ", mAndroidId=" + this.f11830v + ", mImei=" + this.f11831w + ", mCidSn=" + this.f11832x + ", mBuildNum=" + this.f11833y + ", mMobileDataType=" + this.f11834z + ", mPromotionChannel=" + this.f11806A + ", mCarrier=" + this.f11807B + ", mGAid=" + this.f11808C + "]";
    }
}
