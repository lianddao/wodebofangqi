package com.ushareit.listenit;

import com.facebook.internal.ad;
import com.facebook.internal.cb;
import com.facebook.internal.cg;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0321x;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class aih {
    static final aik f4405a = new aik(200, 299);
    private final aij f4406b;
    private final int f4407c;
    private final int f4408d;
    private final int f4409e;
    private final String f4410f;
    private final String f4411g;
    private final String f4412h;
    private final String f4413i;
    private final String f4414j;
    private final JSONObject f4415k;
    private final JSONObject f4416l;
    private final Object f4417m;
    private final HttpURLConnection f4418n;
    private final aif f4419o;

    private aih(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, aif com_ushareit_listenit_aif) {
        this.f4407c = i;
        this.f4408d = i2;
        this.f4409e = i3;
        this.f4410f = str;
        this.f4411g = str2;
        this.f4416l = jSONObject;
        this.f4415k = jSONObject2;
        this.f4417m = obj;
        this.f4418n = httpURLConnection;
        this.f4412h = str3;
        this.f4413i = str4;
        Object obj2 = null;
        if (com_ushareit_listenit_aif != null) {
            this.f4419o = com_ushareit_listenit_aif;
            obj2 = 1;
        } else {
            this.f4419o = new air(this, str2);
        }
        ad g = m5691g();
        this.f4406b = obj2 != null ? aij.OTHER : g.m1376a(i2, i3, z);
        this.f4414j = g.m1377a(this.f4406b);
    }

    aih(HttpURLConnection httpURLConnection, Exception exception) {
        aif com_ushareit_listenit_aif;
        if (exception instanceof aif) {
            com_ushareit_listenit_aif = (aif) exception;
        } else {
            com_ushareit_listenit_aif = new aif((Throwable) exception);
        }
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, com_ushareit_listenit_aif);
    }

    public aih(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    public int m5692a() {
        return this.f4407c;
    }

    public int m5693b() {
        return this.f4408d;
    }

    public String m5694c() {
        return this.f4410f;
    }

    public String m5695d() {
        if (this.f4411g != null) {
            return this.f4411g;
        }
        return this.f4419o.getLocalizedMessage();
    }

    public JSONObject m5696e() {
        return this.f4415k;
    }

    public aif m5697f() {
        return this.f4419o;
    }

    public String toString() {
        return "{HttpStatus: " + this.f4407c + ", errorCode: " + this.f4408d + ", errorType: " + this.f4410f + ", errorMessage: " + m5695d() + "}";
    }

    static aih m5690a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        try {
            if (jSONObject.has("code")) {
                JSONObject jSONObject2;
                int i = jSONObject.getInt("code");
                Object a = cb.m1559a(jSONObject, C0154a.f2970z, "FACEBOOK_NON_JSON_RESULT");
                if (a != null && (a instanceof JSONObject)) {
                    jSONObject2 = (JSONObject) a;
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    boolean z = false;
                    int i2 = -1;
                    int i3 = -1;
                    Object obj2 = null;
                    if (jSONObject2.has(C0321x.aF)) {
                        JSONObject jSONObject3 = (JSONObject) cb.m1559a(jSONObject2, C0321x.aF, null);
                        str = jSONObject3.optString(VastExtensionXmlManager.TYPE, null);
                        str2 = jSONObject3.optString("message", null);
                        i2 = jSONObject3.optInt("code", -1);
                        i3 = jSONObject3.optInt("error_subcode", -1);
                        str3 = jSONObject3.optString("error_user_msg", null);
                        str4 = jSONObject3.optString("error_user_title", null);
                        z = jSONObject3.optBoolean("is_transient", false);
                        obj2 = 1;
                    } else if (jSONObject2.has("error_code") || jSONObject2.has("error_msg") || jSONObject2.has("error_reason")) {
                        str = jSONObject2.optString("error_reason", null);
                        str2 = jSONObject2.optString("error_msg", null);
                        i2 = jSONObject2.optInt("error_code", -1);
                        i3 = jSONObject2.optInt("error_subcode", -1);
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        return new aih(i, i2, i3, str, str2, str4, str3, z, jSONObject2, jSONObject, obj, httpURLConnection, null);
                    }
                }
                if (!f4405a.m5698a(i)) {
                    if (jSONObject.has(C0154a.f2970z)) {
                        jSONObject2 = (JSONObject) cb.m1559a(jSONObject, C0154a.f2970z, "FACEBOOK_NON_JSON_RESULT");
                    } else {
                        jSONObject2 = null;
                    }
                    return new aih(i, -1, -1, null, null, null, null, false, jSONObject2, jSONObject, obj, httpURLConnection, null);
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }

    static synchronized ad m5691g() {
        ad a;
        synchronized (aih.class) {
            cg d = cb.m1609d(ail.m5717h());
            if (d == null) {
                a = ad.m1372a();
            } else {
                a = d.m1633e();
            }
        }
        return a;
    }
}
